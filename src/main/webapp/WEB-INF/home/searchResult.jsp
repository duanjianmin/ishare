<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<div class="hmtop">
    <!--顶部导航条 -->
    <div class="am-container header">
        <ul class="message-l">
            <div class="topMessage">
                <div class="menu-hd">
                    <a href="#" target="_top" class="h">登录</a>
                    <a href="#" target="_top">免费注册</a>
                </div>
            </div>
        </ul>

    </div>

    <!--悬浮搜索框-->

    <div class="nav white">
        <div class="logo"><img src="../images/logo.png"/></div>
        <div class="logoBig">
            <li><img src="../images/logobig.png"/></li>
        </div>

        <div class="search-bar pr">
            <a name="index_none_header_sysc" href="#"></a>
            <form action="search.action" method="get">
                <input id="searchInput" name="bookName" type="text" placeholder="搜索" autocomplete="off">
                <input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
                <input id="pageNumberId" name ="pageNumber" type="text" hidden value="1">
            </form>
        </div>
    </div>

</div>


<div class="shopNav">
<div class="slideall" style="height: auto;">
        <div class="nav-cont">
            <ul>
                <li class="index"><a href="main.action">首页</a></li>

                <c:forEach items="${categoryBookPageDto.categoryMap}" var="map">
                <li class="qc"><a href="category.action?categoryId=${map.key}&&pageNumber=1"><c:out value="${map.value}"></c:out></a></li>
                </c:forEach>

            </ul>
            <%--<div class="padding-top:10px; padding-bottom:5px;margin:0px 0px 0px 0px;">--%>
        </div>

    </div>

</div>

<div class="shopMainbg">
    <div class="shopMain" id="shopmain">

                <div class="am-g am-g-fixed flood method3 ">
                    <ul class="am-thumbnails ">

                        <c:forEach items="${categoryBookPageDto.booksList}" var="book">

                        <li>
                            <div class="list ">
                                <a href="book.action?bookId= ${book.id}">
                                    <img src="${categoryBookPageDto.fileServerPrefix}${book.getPictureName()}" height="200" width="200"></img>
                                    <div class="pro-title "><c:out value="${book.bookName}"></c:out></div>
                                    <c:if test="${book.bookName.length() lt 14}"><br/></c:if>
                                    <div class="pro-title ">作者：<c:out value="${book.author}"></c:out></div>
                                    <div class="pro-title ">分类：<c:out value="${categoryBookPageDto.categoryMap[book.bookCategoryId]}"></c:out></div>
                                </a>
                            </div>
                        </li>

                        </c:forEach>

                    </ul>
                </div>


        <div class="tres">

            <c:if test="${categoryBookPageDto.pageNumber>1}">
                <a href="search.action?bookName=${categoryBookPageDto.bookName}&&pageNumber=1">首页</a>
                <a href="search.action?bookName=${categoryBookPageDto.bookName}&&pageNumber=${categoryBookPageDto.pageNumber-1}">上一页</a>
            </c:if>

            <c:if test="${categoryBookPageDto.pageNumber<=categoryBookPageDto.lastPage}">
                <a href="search.action?bookName=${categoryBookPageDto.bookName}&&pageNumber=${categoryBookPageDto.pageNumber}">${categoryBookPageDto.pageNumber}</a>
            </c:if>

            <c:if test="${categoryBookPageDto.pageNumber+1<=categoryBookPageDto.lastPage}">
                <a href="search.action?bookName=${categoryBookPageDto.bookName}&&pageNumber=${categoryBookPageDto.pageNumber+1}">${categoryBookPageDto.pageNumber+1}</a>
            </c:if>


            <c:if test="${categoryBookPageDto.pageNumber+2<=categoryBookPageDto.lastPage}">
            <a href="search.action?bookName=${categoryBookPageDto.bookName}&&pageNumber=${categoryBookPageDto.pageNumber+2}">${categoryBookPageDto.pageNumber+2}</a>
            </c:if>


            <c:if test="${categoryBookPageDto.pageNumber+3<=categoryBookPageDto.lastPage}">
            <a href="search.action?bookName=${categoryBookPageDto.bookName}&&pageNumber=${categoryBookPageDto.pageNumber+3}">${categoryBookPageDto.pageNumber+3}</a>
            </c:if>

            <c:if test="${categoryBookPageDto.pageNumber+4<=categoryBookPageDto.lastPage}">
            <a href="search.action?bookName=${categoryBookPageDto.bookName}&&pageNumber=${categoryBookPageDto.pageNumber+4}">${categoryBookPageDto.pageNumber+4}</a>
            </c:if>

            <c:if test="${categoryBookPageDto.pageNumber<categoryBookPageDto.lastPage}">
                <a href="search.action?bookName=${categoryBookPageDto.bookName}&&pageNumber=${categoryBookPageDto.pageNumber+1}">下一页 </a>
                <a href="search.action?bookName=${categoryBookPageDto.bookName}&&pageNumber=${categoryBookPageDto.lastPage}">末页 </a>
            </c:if>

        </div>

        <div class="footer ">
            <div class="footer-hd ">
                <p>
                    <a href="# ">恒望科技</a>
                    <b>|</b>
                    <a href="# ">商城首页</a>
                    <b>|</b>
                    <a href="# ">支付宝</a>
                    <b>|</b>
                    <a href="# ">物流</a>
                </p>
            </div>
            <div class="footer-bd ">
                <p>
                    <a href="# ">关于恒望</a>
                    <a href="# ">合作伙伴</a>
                    <a href="# ">联系我们</a>
                    <a href="# ">网站地图</a>
                    <em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank"
                                                               title="模板之家">模板之家</a> - Collect from <a
                            href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
                </p>
            </div>
        </div>
    </div>
</div>
</div>
</div>

<script>
    window.jQuery || document.write('<script src="basic/js/jquery.min.js "><\/script>');
</script>
<script type="text/javascript " src="../basic/js/quick_links.js "></script>
</body>


<style type="text/css">


    /*BODY {*/
        /*FONT-SIZE: 12px;FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif;*/
        /*WIDTH: 60%; PADDING-LEFT: 25px;*/
    /*}*/
    /* CSS 翻页代码 */
    DIV.tres {
        PADDING-RIGHT: 7px; PADDING-LEFT: 7px; FONT-WEIGHT: bold;
        FONT-SIZE: 13.2pt; PADDING-BOTTOM: 7px; MARGIN: 3px;
        PADDING-TOP: 7px; FONT-FAMILY: Arial, Helvetica, sans-serif; TEXT-ALIGN: center
    }
    DIV.tres A {
        BORDER-RIGHT: #d9d300 2px solid; PADDING-RIGHT: 5px;
        BORDER-TOP: #d9d300 2px solid; PADDING-LEFT: 5px; PADDING-BOTTOM: 2px;
        MARGIN: 2px; BORDER-LEFT: #d9d300 2px solid; COLOR: #fff; PADDING-TOP: 2px;
        BORDER-BOTTOM: #d9d300 2px solid; BACKGROUND-COLOR: #d90; TEXT-DECORATION: none
    }
    DIV.tres A:hover {
        BORDER-RIGHT: #ff0 2px solid; BORDER-TOP: #ff0 2px solid;
        BORDER-LEFT: #ff0 2px solid; COLOR: #000; BORDER-BOTTOM: #ff0 2px solid;
        BACKGROUND-COLOR: #ff0
    }
    DIV.tres A:active {
        BORDER-RIGHT: #ff0 2px solid; BORDER-TOP: #ff0 2px solid;
        BORDER-LEFT: #ff0 2px solid; COLOR: #000;
        BORDER-BOTTOM: #ff0 2px solid; BACKGROUND-COLOR: #ff0
    }
    DIV.tres SPAN.current {
        BORDER-RIGHT: #fff 2px solid; PADDING-RIGHT: 5px;
        BORDER-TOP: #fff 2px solid; PADDING-LEFT: 5px; FONT-WEIGHT: bold;
        PADDING-BOTTOM: 2px; MARGIN: 2px; BORDER-LEFT: #fff 2px solid;
        COLOR: #000; PADDING-TOP: 2px; BORDER-BOTTOM: #fff 2px solid
    }
    DIV.tres SPAN.disabled {
        DISPLAY: none
    }



</style>
</html>