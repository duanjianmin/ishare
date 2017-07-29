package com.service;

import com.dto.BookDto;
import com.dto.BookResourceDto;
import com.dto.CategoryBookPageDto;
import com.dto.DashboardDto;
import com.entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

/**
 * Created by tony.duan on 4/22/17.
 */
@Service
@Transactional
public class DashboardServiceImpl implements DashboardService {

    @PersistenceContext(unitName = "ishare")
    private EntityManager entityManager;
    @Autowired
    private TestRepository testRepository;

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookResourceRepository bookResourceRepository;

    private static final Integer PAGE_SIZE = 12;

    private static final String FILE_SERVER_PREFIX = "http://localhost:8070/images/";

    @Override
    public String findTest(String name) {
        Test test = testRepository.findByName(name);;;
        return test.getName()+" -- "+test.getNumber();
    }



    @Override
    public DashboardDto fetchTopBooks(int topNumberForAllBooks, int topNumberForCategory) {

        List<Book> topAllList = getTopAllList(topNumberForAllBooks);
        List<Book> topCategoryList = getTopCategoryList(topNumberForCategory);
        Map<Integer,String> categoryMap = getCategoryMapping();

        List<BookDto> topAllDtoList = new ArrayList<>();

        for(Book book : topAllList){
            BookDto bookDto = new BookDto();
            BeanUtils.copyProperties(book,bookDto);
            topAllDtoList.add(bookDto);
        }

        Map<Integer,List<BookDto>> bookCategoryMap = new HashMap<>();
        for(Book book : topCategoryList){
            Integer categoryId = book.getBookCategoryId();
            List<BookDto> existedList = bookCategoryMap.get(categoryId);
            if(null==existedList){
                existedList = new ArrayList<>();
            }

            if(bookCategoryMap.containsKey(categoryId) && existedList.size()>topNumberForCategory){
                continue;
            }


            BookDto bookDto = new BookDto();
            BeanUtils.copyProperties(book,bookDto);
            existedList.add(bookDto);
            bookCategoryMap.put(categoryId,existedList);

        }


        DashboardDto dashboardDto = new DashboardDto();
        dashboardDto.setTopAllBooksList(topAllDtoList);
        dashboardDto.setCategoryBooksMap(bookCategoryMap);
        dashboardDto.setCategoryMap(categoryMap);
        dashboardDto.setFileServerPrefix(FILE_SERVER_PREFIX);
        return dashboardDto;
    }


    @Override
    public CategoryBookPageDto fetchCategoryBooks(Integer categoryId,Integer pageNumber) {
        List<BookDto> bookDtoList = new ArrayList<>();


        Query query1 = entityManager.createNativeQuery(BookNativeSql.GET_CATEGORY_BOOKS, Book.class);
        query1.setParameter("categoryId",categoryId);
        query1.setParameter("startNumber",(pageNumber-1)*PAGE_SIZE);
        query1.setParameter("pageSize",PAGE_SIZE);
        List<Book> bookList = query1.getResultList();


        //get total page
        List<Book> bookAll = bookRepository.findByBookCategoryId(categoryId);
        Double count = null!=bookAll?Double.valueOf(bookAll.size()+""):0;
        Integer lastPageNumber = (int) Math.ceil(count/PAGE_SIZE);;


        for(Book book : bookList){
            BookDto bookDto = new BookDto();
            BeanUtils.copyProperties(book,bookDto);
            bookDtoList.add(bookDto);
        }


        Map<Integer,String> map = getCategoryMapping();

        CategoryBookPageDto bookPageDto = new CategoryBookPageDto();
        bookPageDto.setCategoryMap(map);
        bookPageDto.setBooksList(bookDtoList);
        bookPageDto.setCategoryId(categoryId);
        bookPageDto.setCategoryName(map.get(categoryId));
        // set last page number
        bookPageDto.setPageNumber(pageNumber);
        bookPageDto.setLastPage(lastPageNumber);
        bookPageDto.setFileServerPrefix(FILE_SERVER_PREFIX);
        return bookPageDto;
    }


    @Override
    public BookDto fetchBook(Integer bookId) {
        Book book = bookRepository.findById(bookId);
        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(book,bookDto);



        List<BookResource> bookResourceList = bookResourceRepository.findByBookId(bookId);
        List<BookResourceDto> bookResourceDtoList = new ArrayList<>();
        for(BookResource resource : bookResourceList){
            BookResourceDto bookResourceDto = new BookResourceDto();
            BeanUtils.copyProperties(resource,bookResourceDto);
            bookResourceDtoList.add(bookResourceDto);
        }

        Map<Integer,String> map = getCategoryMapping();
        bookDto.setCategoryMap(map);
        bookDto.setFileServerPrefix(FILE_SERVER_PREFIX);
        bookDto.setBookResourceDtoList(bookResourceDtoList);
        return bookDto;
    }


    @Override
    public CategoryBookPageDto searchByBookName(String bookName,Integer pageNumber) {

        List<BookDto> bookDtoList = new ArrayList<>();


        Query query1 = entityManager.createNativeQuery(BookNativeSql.GET_SEARCH_BOOKS, Book.class);
        if("".equals(bookName)){
            bookName = null;
        }
        query1.setParameter("bookName",bookName);
        query1.setParameter("startNumber",(pageNumber-1)*PAGE_SIZE);
        query1.setParameter("pageSize",PAGE_SIZE);
        List<Book> bookList = query1.getResultList();


        //get total page
        List<Book> bookAll ;
        if(null==bookName|| "".equals(bookName)){
            bookAll = bookRepository.findAll();
        } else{
            bookAll = bookRepository.findByBookName(bookName);
        }
        Double count = null!=bookAll?Double.valueOf(bookAll.size()+""):0;
        Integer lastPageNumber = (int) Math.ceil(count/PAGE_SIZE);;


        for(Book book : bookList){
            BookDto bookDto = new BookDto();
            BeanUtils.copyProperties(book,bookDto);
            bookDtoList.add(bookDto);
        }


        Map<Integer,String> map = getCategoryMapping();

        CategoryBookPageDto bookPageDto = new CategoryBookPageDto();
        bookPageDto.setCategoryMap(map);
        bookPageDto.setBooksList(bookDtoList);
//        bookPageDto.setCategoryId(categoryId);
//        bookPageDto.setCategoryName(map.get(categoryId));
        // set last page number
        bookPageDto.setPageNumber(pageNumber);
        bookPageDto.setLastPage(lastPageNumber);
        bookPageDto.setBookName(bookName);
        bookPageDto.setFileServerPrefix(FILE_SERVER_PREFIX);

        return bookPageDto;
    }

    private List<Book> getTopAllList(int topNumberForAllBooks){
        Query query1 = entityManager.createNativeQuery(BookNativeSql.GET_TOP_BOOKS_FOR_ALL, Book.class);
        query1.setParameter("topNumberForAllBooks",topNumberForAllBooks);
        List<Book> topAllList = query1.getResultList();
        return topAllList;
    }

    private List<Book> getTopCategoryList(int topNumberForCategory){
        Query query2 = entityManager.createNativeQuery(BookNativeSql.GET_TOP_BOOKS_FOR_CATEGORY,Book.class);
        query2.setParameter("topNumberForCategory",topNumberForCategory);
        List<Book> topCategoryList = query2.getResultList();
        return topCategoryList;
    }


    private Map<Integer,String> getCategoryMapping(){
        List<BookCategory> categoryList = bookCategoryRepository.findAll();
        Map<Integer,String> categoryMap = new LinkedHashMap<>();
        for(BookCategory category : categoryList){
            categoryMap.put(category.getId(),category.getCategoryName());
        }
        return categoryMap;
    }

}
