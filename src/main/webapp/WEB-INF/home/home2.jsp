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

                <c:forEach items="${dashboardDto.categoryMap}" var="map">
                <li class="qc"><a href="category.action?categoryId=${map.key}&&pageNumber=1">${map.value}</a></li>
                </c:forEach>

            </ul>
            <%--<div class="padding-top:10px; padding-bottom:5px;margin:0px 0px 0px 0px;">--%>
        </div>

    </div>

</div>

<div class="shopMainbg">
    <div class="shopMain" id="shopmain">

        <div class="am-container activity ">

            <div class="am-g am-g-fixed ">
                <div class="am-u-sm-3 ">
                    <div class="icon-sale one "></div>
                    <h4>热门好书</h4>
                    <div class="activityMain ">
                        <a href="book.action?bookId=${dashboardDto.topAllBooksList.get(0).getId()}">
                            <img src="${dashboardDto.fileServerPrefix}${dashboardDto.topAllBooksList.get(0).getPictureName()}"></img>
                        </a>
                    </div>
                    <div class="info ">
                        <h3>${dashboardDto.topAllBooksList.get(0).getBookName()}</h3>
                    </div>
                </div>

                <div class="am-u-sm-3 ">
                    <div class="icon-sale two "></div>
                    <h4>热门好书</h4>
                    <div class="activityMain ">
                        <a href="book.action?bookId=${dashboardDto.topAllBooksList.get(1).getId()}">
                            <img src="${dashboardDto.fileServerPrefix}${dashboardDto.topAllBooksList.get(1).getPictureName()}"></img>
                        </a>
                    </div>
                    <div class="info ">
                        <h3>${dashboardDto.topAllBooksList.get(1).getBookName()}</h3>
                    </div>
                </div>

                <div class="am-u-sm-3 ">
                    <div class="icon-sale three "></div>
                    <h4>热门好书</h4>
                    <div class="activityMain ">
                        <a href="book.action?bookId=${dashboardDto.topAllBooksList.get(2).getId()}">
                            <img src="${dashboardDto.fileServerPrefix}${dashboardDto.topAllBooksList.get(2).getPictureName()}"></img>
                        </a>
                    </div>
                    <div class="info ">
                        <h3>${dashboardDto.topAllBooksList.get(2).getBookName()}</h3>
                    </div>
                </div>

                <div class="am-u-sm-3 last ">
                    <div class="icon-sale "></div>
                    <h4>广告</h4>
                    <div class="activityMain ">
                        <img src="../images/dhwc.jpg"></img>
                    </div>

                </div>

            </div>
        </div>


        <c:forEach items="${dashboardDto.categoryBooksMap}" var="map">

            <div class="am-container ">
                <div class="shopTitle ">
                    <h4>
                        <a href="category.action?categoryId=${map.key}&&pageNumber=1">${dashboardDto.categoryMap[map.key]}</a>
                    </h4>
                    <h3>你是我的优乐美么？不，我是你小鱼干</h3>
                </div>
            </div>


            <div class="am-g am-g-fixed flood method3 ">
                <ul class="am-thumbnails ">

                    <c:forEach items="${map.value}" var="list">

                    <li>
                        <div class="list ">
                            <a href="book.action?bookId= ${list.id}">
                                <img src="${dashboardDto.fileServerPrefix}${list.getPictureName()}"></img>
                                <div class="pro-title "><c:out value="${list.bookName}"></c:out></div>
                                <div class="pro-title ">作者：<c:out value="${list.author}"></c:out></div>
                                <div class="pro-title ">分类：<c:out value="${dashboardDto.categoryMap[map.key]}"></c:out></div>
                            </a>
                        </div>
                    </li>

                    </c:forEach>

                </ul>
            </div>

        </c:forEach>

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

</html>