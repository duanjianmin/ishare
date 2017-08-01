<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <title>首页</title>

    <link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css"/>
    <link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css"/>

    <link href="../basic/css/demo.css" rel="stylesheet" type="text/css"/>

    <link href="../css/hmstyle.css" rel="stylesheet" type="text/css"/>
    <script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
    <script src="../AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>

</head>

<body>
<div style="width:100%;text-align:left">
    <!--悬浮搜索框-->

    <h1>书籍管理</h1>
    <br/>
    <form action="/management.action" method="post" id="searchForm">

        <div>
            书名 : <input id="bookNameId" name="bookName" value="${bookDto.bookName}" type="text">
        </div>
        <br/>

        <div>
            作者 : <input id="authorId" name="author"  value="${bookDto.author}" type="text">
        </div>
        <br/>

        <div>
            分类 : <select name="bookCategoryId">
            <option value="1" <c:if test="${bookDto.bookCategoryId eq 1}">selected</c:if>>小说</option>
            <option value="2" <c:if test="${bookDto.bookCategoryId eq 2}">selected</c:if>>文学</option>
            <option value="3" <c:if test="${bookDto.bookCategoryId eq 3}">selected</c:if>>历史</option>
            <option value="4" <c:if test="${bookDto.bookCategoryId eq 4}">selected</c:if>>经管</option>
            <option value="5" <c:if test="${bookDto.bookCategoryId eq 5}">selected</c:if>>生活</option>
            <option value="6" <c:if test="${bookDto.bookCategoryId eq 6}">selected</c:if>>传记</option>
            <option value="7" <c:if test="${bookDto.bookCategoryId eq 7}">selected</c:if>>少儿</option>
            <option value="8" <c:if test="${bookDto.bookCategoryId eq 8}">selected</c:if>>英文</option>
            <option value="9" <c:if test="${bookDto.bookCategoryId eq 9}">selected</c:if>>心理</option>
            <option value="10" <c:if test="${bookDto.bookCategoryId eq 10}">selected</c:if>>励志</option>
            <option value="11" <c:if test="${bookDto.bookCategoryId eq 11}">selected</c:if>>科技</option>
            <option value="12" <c:if test="${bookDto.bookCategoryId eq 12}">selected</c:if>>人文社科</option>
            <option value="13" <c:if test="${bookDto.bookCategoryId eq 13}">selected</c:if>>其他</option>
        </select>
        </div>
        <br/>

        <div>
            Usable :<select name="usable">
            <option value="1" <c:if test="${bookDto.usable eq true}">selected</c:if> >True</option>
            <option value="0" <c:if test="${bookDto.usable eq false}">selected</c:if> >False</option>
        </select>
        </div>
        <br/>

        <input id="pageNumberHidden" name="pageNumber" value="${categoryBookPageDto.pageNumber}" type="hidden"/>
        <input id="create" value="检索" index="1"
               type="submit">

    </form>

    <c:forEach items="${categoryBookPageDto.booksList}" var="book">

        <li>
            <div class="list ">
                <a href="book.action?bookId= ${book.id}">
                    <%--<img src="${categoryBookPageDto.fileServerPrefix}${book.getPictureName()}" height="200" width="200"></img>--%>
                    <div class="pro-title "><c:out value="${book.bookName}"></c:out></div>
                    <c:if test="${book.bookName.length() lt 14}"><br/></c:if>
                    <div class="pro-title ">作者：<c:out value="${book.author}"></c:out></div>
                    <div class="pro-title ">分类：<c:out value="${categoryBookPageDto.categoryMap[book.bookCategoryId]}"></c:out></div>
                </a>
            </div>
        </li>

    </c:forEach>


    <div class="tres">

        <c:if test="${categoryBookPageDto.pageNumber>1}">
            <a  href="javascript:void(0)" onclick="searchCommit(1);">首页</a>
            <a href="javascript:void(0)" onclick="searchCommit(${categoryBookPageDto.pageNumber-1});">上一页</a>
        </c:if>

        <c:if test="${categoryBookPageDto.pageNumber<=categoryBookPageDto.lastPage}">
            <a href="javascript:void(0)" onclick="searchCommit(${categoryBookPageDto.pageNumber});">${categoryBookPageDto.pageNumber}</a>
        </c:if>

        <c:if test="${categoryBookPageDto.pageNumber+1<=categoryBookPageDto.lastPage}">
            <a href="javascript:void(0)" onclick="searchCommit(${categoryBookPageDto.pageNumber+1});">${categoryBookPageDto.pageNumber+1}</a>
        </c:if>


        <c:if test="${categoryBookPageDto.pageNumber+2<=categoryBookPageDto.lastPage}">
            <a href="javascript:void(0)" onclick="searchCommit(${categoryBookPageDto.pageNumber+2});">${categoryBookPageDto.pageNumber+2}</a>
        </c:if>


        <c:if test="${categoryBookPageDto.pageNumber+3<=categoryBookPageDto.lastPage}">
            <a  href="javascript:void(0)" onclick="searchCommit(${categoryBookPageDto.pageNumber+3});">${categoryBookPageDto.pageNumber+3}</a>
        </c:if>

        <c:if test="${categoryBookPageDto.pageNumber+4<=categoryBookPageDto.lastPage}">
            <a  href="javascript:void(0)" onclick="searchCommit(${categoryBookPageDto.pageNumber+4});">${categoryBookPageDto.pageNumber+4}</a>
        </c:if>

        <c:if test="${categoryBookPageDto.pageNumber<categoryBookPageDto.lastPage}">
            <a  href="javascript:void(0)" onclick="searchCommit(${categoryBookPageDto.pageNumber+1});">下一页 </a>
            <a href="javascript:void(0)" onclick="searchCommit(${categoryBookPageDto.lastPage});">末页 </a>
        </c:if>

    </div>
</div>

</div>
</div>

<script>
    window.jQuery || document.write('<script src="basic/js/jquery.min.js "><\/script>');
    function searchCommit(number){
        $("#pageNumberHidden").val(number);
        $("#searchForm").submit();
    }

</script>
<script type="text/javascript " src="../basic/js/quick_links.js ">
</script>
</body>


<style type="text/css">


    /*BODY {*/
    /*FONT-SIZE: 12px;FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif;*/
    /*WIDTH: 60%; PADDING-LEFT: 25px;*/
    /*}*/
    /* CSS 翻页代码 */
    DIV.tres {
        PADDING-RIGHT: 7px;
        PADDING-LEFT: 7px;
        FONT-WEIGHT: bold;
        FONT-SIZE: 13.2pt;
        PADDING-BOTTOM: 7px;
        MARGIN: 3px;
        PADDING-TOP: 7px;
        FONT-FAMILY: Arial, Helvetica, sans-serif;
        TEXT-ALIGN: center
    }

    DIV.tres A {
        BORDER-RIGHT: #d9d300 2px solid;
        PADDING-RIGHT: 5px;
        BORDER-TOP: #d9d300 2px solid;
        PADDING-LEFT: 5px;
        PADDING-BOTTOM: 2px;
        MARGIN: 2px;
        BORDER-LEFT: #d9d300 2px solid;
        COLOR: #fff;
        PADDING-TOP: 2px;
        BORDER-BOTTOM: #d9d300 2px solid;
        BACKGROUND-COLOR: #d90;
        TEXT-DECORATION: none
    }

    DIV.tres A:hover {
        BORDER-RIGHT: #ff0 2px solid;
        BORDER-TOP: #ff0 2px solid;
        BORDER-LEFT: #ff0 2px solid;
        COLOR: #000;
        BORDER-BOTTOM: #ff0 2px solid;
        BACKGROUND-COLOR: #ff0
    }

    DIV.tres A:active {
        BORDER-RIGHT: #ff0 2px solid;
        BORDER-TOP: #ff0 2px solid;
        BORDER-LEFT: #ff0 2px solid;
        COLOR: #000;
        BORDER-BOTTOM: #ff0 2px solid;
        BACKGROUND-COLOR: #ff0
    }

    DIV.tres SPAN.current {
        BORDER-RIGHT: #fff 2px solid;
        PADDING-RIGHT: 5px;
        BORDER-TOP: #fff 2px solid;
        PADDING-LEFT: 5px;
        FONT-WEIGHT: bold;
        PADDING-BOTTOM: 2px;
        MARGIN: 2px;
        BORDER-LEFT: #fff 2px solid;
        COLOR: #000;
        PADDING-TOP: 2px;
        BORDER-BOTTOM: #fff 2px solid
    }

    DIV.tres SPAN.disabled {
        DISPLAY: none
    }


</style>
</html>