package com.controller;

import com.dto.BookDto;
import com.dto.CategoryBookPageDto;
import com.dto.DashboardDto;
import com.service.DashboardService;
import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;


@Controller
public class DashboardController {
    @Autowired
    TestService service;

    @Autowired
    DashboardService dashboardService;


    @RequestMapping(value="/main.action",method= RequestMethod.GET)
    public String dashboard(Model model){
        // top number for all book is 3
        // top number for specified category is 6
        DashboardDto dashboardDto = dashboardService.fetchTopBooks(4,6);
        model.addAttribute(dashboardDto);
        return "/home/home2";
    }


    @RequestMapping(value="/category.action",method= RequestMethod.GET)
    public String category(@RequestParam("categoryId")Integer categoryId,@RequestParam("pageNumber")Integer pageNumber,Model model){
        // top number for all book is 3
        // top number for specified category is 6
        CategoryBookPageDto categoryPageDto = dashboardService.fetchCategoryBooks(categoryId,pageNumber);
        model.addAttribute(categoryPageDto);
        return "/home/categoryBook";
    }


    @RequestMapping(value="/book.action",method= RequestMethod.GET)
    public String book(@RequestParam("bookId")Integer bookId,Model model){
        // top number for all book is 3
        // top number for specified category is 6
        BookDto bookDto = dashboardService.fetchBook(bookId);
        model.addAttribute(bookDto);
        return "/home/book";
    }

    @RequestMapping(value="/search.action",method= RequestMethod.GET)
    public String book(@RequestParam("bookName")String bookName,@RequestParam("pageNumber")Integer pageNumber,Model model){
//        try {
//            bookName = new String(bookName.getBytes("ISO-8859-1"), "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        CategoryBookPageDto categoryPageDto = dashboardService.searchByBookName(bookName,pageNumber);
        model.addAttribute(categoryPageDto);
        return "/home/searchResult";
    }


    @RequestMapping("/upload.do")
    public String upload(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        // 这里我用到了jar包
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                MultipartFile file = multiRequest.getFile((String) iter.next());
                if (file != null) {
                    String fileName = file.getOriginalFilename();

                    String path1 = Thread.currentThread()
                            .getContextClassLoader().getResource("").getPath()
                            + "download" + File.separator;

                    //  下面的加的日期是为了防止上传的名字一样
                    String path = path1
                            + new SimpleDateFormat("yyyyMMddHHmmss")
                            .format(new Date()) + fileName;

                    File localFile = new File(path);

                    file.transferTo(localFile);
                }

            }

        }
        return "uploadSuccess";

    }
    @RequestMapping("/toUpload.do")
    public String toUpload() {
        return "upload";
    }

    @RequestMapping("/download.action")
    public String download(@RequestParam("fileName") String fileName, HttpServletRequest request,
                           HttpServletResponse response) throws IOException{
//        fileName = "WiredTiger.lock";
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + fileName);

        try {
            String path = "http://localhost:8070/book/";
            URL url = new URL(path+fileName);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();

            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }

            // 这里主要关闭。
            os.close();

            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  返回值要注意，要不然就出现下面这句错误！
        //java+getOutputStream() has already been called for this response
        return null;
    }

    @RequestMapping(value="/management.action",method= RequestMethod.GET)
    public String management(@RequestParam(value = "bookName", required = false) String bookName,@RequestParam("pageNumber")Integer pageNumber,Model model){
        try {
            if(null!=bookName)
                bookName = new String(bookName.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        CategoryBookPageDto categoryPageDto = dashboardService.searchByBookName(bookName,pageNumber);
        model.addAttribute(categoryPageDto);
        return "/home/bookManagement";
    }


}