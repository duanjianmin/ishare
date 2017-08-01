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
<div style="width:100%;text-align:center">
    <!--悬浮搜索框-->

    <h1>新建书籍</h1>
    <br/>
    <form action="/management.action" method="post">

        <div>
            Book Name : <input id="bookNameId" name="bookName" type="text">
        </div>
        <br/>

        <div>
            Book Category : <input id="bookCategoryId" name="bookName" type="text">
        </div>
        <br/>

        <div>
            Remark : <input id="remarkId" name="remark" type="text">
        </div>
        <br/>

        <div>
            Author : <input id="authorId" name="author" type="text">
        </div>
        <br/>

        <div>
            Picture Name : <input id="pictureNameId" name="author" type="text">
        </div>
        <br/>


        <div>
            Introduction : <input id="introductionId" name="author" type="text">
        </div>
        <br/>

        <div>
            Amazon Link : <input id="amazonLinkId" name="author" type="text">
        </div>
        <br/>


        <div>
            Label : <input id="labelId" name="author" type="text">
        </div>
        <br/>


        <div>
            DownLoad Frequence : <input id="downloadFrequenceId" name="author" type="text">
        </div>
        <br/>

        <div>
            DouBan Star : <input id="doubarStarId" name="author" type="text">
        </div>
        <br/>

        <div>
            Usable : <input id="usableId" name="author" type="text">
        </div>
        <br/>


        <input id="create"  value="提交" index="1"
               type="submit">

    </form>

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