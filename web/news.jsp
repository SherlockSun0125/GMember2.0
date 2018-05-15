<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=utf-8"%>

<html>
<head>
    <title>新闻中心</title>
    <meta name="viewport" content="width=100%; initial-scale=1; maximum-scale=1; minimum-scale=1; user-scalable=no;"/>
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/apple-touch-icon-144-precomposed.png"/>
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/apple-touch-icon-114-precomposed.png"/>
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/apple-touch-icon-72-precomposed.png"/>
    <link rel="apple-touch-icon-precomposed" href="images/apple-touch-icon-57-precomposed.png"/>
    <link href="css/bootstrap-2.min.css" type="text/css" rel="stylesheet"/>
    <link href="css/style.css" type="text/css" rel="stylesheet"/>
    <link href="css/prettyPhoto.css" type="text/css" rel="stylesheet"/>
    <link href="css/font-icomoon.css" type="text/css" rel="stylesheet"/>
    <link href="css/font-awesome.css" type="text/css" rel="stylesheet"/>
    <%--<link href="css/bs-preview.css" type="text/css" rel="stylesheet"/>--%>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="js/jquery.quicksand.js"></script>
    <script type="text/javascript" src="js/superfish.js"></script>
    <script type="text/javascript" src="js/hoverIntent.js"></script>
    <script type="text/javascript" src="js/jquery.flexslider.js"></script>
    <script type="text/javascript" src="js/jflickrfeed.min.js"></script>
    <script type="text/javascript" src="js/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="js/jquery.elastislide.js"></script>
    <script type="text/javascript" src="js/jquery.tweet.js"></script>
    <script type="text/javascript" src="js/smoothscroll.js"></script>
    <script type="text/javascript" src="js/jquery.ui.totop.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <script type="text/javascript" src="js/ajax-mail.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <style>
        /*列表*/
        .listContent li{
            color:#4c657e;
            border-bottom: dashed 1px #b4b4b4;
            height:28px;
            line-height:28px;
            /*background-image: url();*/
            background-repeat: no-repeat;
            padding-left:30px;
            background-position: 13px 8px;
            list-style-type: none;
        }
        .listContent li a{
            color:#4c657e;
            text-decoration: none;
            float:left;
        }
        .listContent li span{
            float:right;
        }
    </style>
    <link type="text/css" rel="stylesheet" href="pager/pager.css">
</head>

<body>
<!--header-->
<header id="header">
    <div class="container" style="margin-bottom: 2px">
        <div class="row header-top" style="margin-left:5px;margin-bottom:0px;">
            <div class="span5 logo" style="width: 100%;margin-left:10px">
                <a class="logo-img" href="home.jsp" title="responsive template" style="margin-bottom: 5px"><img
                        src="images/myimg/hitwh_logo_blue.png" alt="哈工大威海校徽"/></a>
            </div>
        </div>
        <div class="row header-nav">
            <div class="span12">
                <nav id="menu" class="clearfix">
                    <ul>
                        <li><a href="home.jsp"><span class="name">主页</span></a>
                        </li>
                        <li class="current"><a href="${pageContext.request.contextPath}/newsServlet?method=findAllNews"><span class="name">新闻中心</span></a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/noticeServlet?method=findAllNotices"><span class="name">通知公告</span></a>
                        </li>
                        <li><a href="enterprise.jsp"><span class="name">合作企业</span></a>
                        </li>
                        <li><a><span class="name">用户中心</span></a>
                            <ul>
                                <li><a href="studentLogin.jsp" target="_blank">学生用户登录</a></li>
                                <li><a href="teacherLogin.jsp" target="_blank">教师用户登录</a></li>
                                <li><a href="employeeLogin.jsp" target="_blank">企业用户登录</a></li>
                            </ul>
                        </li>
                        <%--<li><a href="download.jsp"><span class="name">下载中心</span></a></li>--%>
                        <li><a href="about1.jsp"><span class="name">计划介绍</span></a></li>
                    </ul>
                </nav>
                <form class="top-search pull-right">
                    <input type="text" placeholder="站内搜索..." class="span3">
                    <button type="button" class="btn"><i class="icon-search-form"></i></button>
                </form>
            </div>
        </div>
    </div>
</header>

<!--container-->
<section id="container">
    <div class="container">

        <div class="row" style="padding-left: 50px">
            <div class="span2 bs-docs-sidebar" style="background-color: #f7f7f9;">
                <ul class="nav nav-list bs-docs-sidenav">
                    <li style="border-bottom: #3c3c3c 1px dashed"><a href="${pageContext.request.contextPath}/newsServlet?method=findNewsByType&sectionid=1"><i class="icon-chevron-right"></i> 综合要闻</a></li>
                    <li style="border-bottom: #3c3c3c 1px dashed"><a href="${pageContext.request.contextPath}/newsServlet?method=findNewsByType&sectionid=2"><i class="icon-chevron-right"></i> 校园资讯</a></li>
                    <li style="border-bottom: #3c3c3c 1px dashed"><a href="${pageContext.request.contextPath}/newsServlet?method=findNewsByType&sectionid=3"><i class="icon-chevron-right"></i> 教学科研</a></li>
                    <li style="border-bottom: #3c3c3c 1px dashed"><a href="${pageContext.request.contextPath}/newsServlet?method=findNewsByType&sectionid=4"><i class="icon-chevron-right"></i> 专题新闻</a></li>
                </ul>
            </div>
            <div class="span9">
                <div  style="margin-left: 0px">
                    <div style="margin-bottom: 10px">
                        <ul class="nav nav-list">
                            <c:forEach items="${pb.beanList}" var="news">
                                <li><a href="${pageContext.request.contextPath}/newsServlet"><i class="icon-caret-right"></i>${news.news_id}/${news.news_title}<span style="display:inline-block;float:right;color: #000000">${news.news_time}</span> </a></li>
                            </c:forEach>
                        </ul>
                    </div>

                    <div style="float:left; width: 100%; text-align: center;" >
                        <%@include file="pager/pager.jsp"%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- 最下方 -->
<footer id="footer">
    <div class="container" align="center">
        友情链接：
        <a href="http://www.hit.edu.cn/">哈工大（本部）</a>&nbsp;
        <a href="http://www.hitwh.edu.cn/">哈工大（威海）</a>&nbsp;
        <a href="http://www.hitsz.edu.cn/index.html">哈工大（深圳）</a>&nbsp;
    </div>
</footer>

<!--footer menu-->
<section id="footer-menu">
    <div class="container">
        <p align="center">
            山东省威海市环翠区文化西路2号&nbsp;&nbsp;&nbsp;&nbsp;邮政编码：264209&nbsp;&nbsp;&nbsp;&nbsp;哈尔滨工业大学（威海）版权所有 |
            <a class="my_a_link" href="adminLogin.jsp" style="color: #1a1a1a">登陆</a>
        </p>
    </div>
</section>


</body>
</html>
