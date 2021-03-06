<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
${pageContext.request.contextPath}/<%@page contentType="text/html; charset=utf-8" %>
<html>
<head>
    <title>合作企业</title>
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
</head>

<body>
<!--header-->
<header id="header">
    <div class="container" style="margin-bottom: 2px">
        <div class="row header-top" style="margin-left:5px;margin-bottom:0;">
            <div class="span5 logo" style="width: 100%;margin-left:10px">
                <a class="logo-img" href="${pageContext.request.contextPath}/home.jsp" title="responsive template" style="margin-bottom: 5px"><img
                        src="${pageContext.request.contextPath}/images/myimg/hitwh_logo_blue.png" alt="哈工大威海校徽"/></a>
            </div>
        </div>
        <div class="row header-nav">
            <div class="span12">
                <nav id="menu" class="clearfix">
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/home.jsp"><span class="name">主页</span></a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/newsServlet?method=findAllNews"><span class="name">新闻中心</span></a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/noticeServlet?method=findAllNotices"><span class="name">通知公告</span></a>
                        </li>
                        <li class="current"><a href="${pageContext.request.contextPath}/companyServlet?method=findAllCompanys"><span class="name">合作企业</span></a>
                        </li>
                        <li><a><span class="name">用户中心</span></a>
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/studentLogin.jsp"  target="_blank">学生用户登录</a></li>
                                <li><a href="${pageContext.request.contextPath}/teacherLogin.jsp"  target="_blank">教师用户登录</a></li>
                                <li><a href="${pageContext.request.contextPath}/employeeLogin.jsp"  target="_blank">企业用户登录</a></li>
                            </ul>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/about1.jsp"><span class="name">计划介绍</span></a></li>
                    </ul>
                </nav>
                <form class="top-search pull-right">
                    <%--<input type="text" placeholder="站内搜索..." class="span3">--%>
                    <%--<button type="button" class="btn" href=""><i class="icon-search-form"></i></button>--%>
                </form>
            </div>
        </div>
    </div>
</header>

<!--container-->
<section id="container">
    <div class="container">
        <!--filter-->
        <ul id="filtrable">
            <li class="current all"><a href="#all">全部</a></li>
            <%--International large software company--%>
            <li class="ils-co"><a href="#ils-co">国际化大型软件公司</a></li>
            <%--Game outsourcing company--%>
            <li class="go-co"><a href="#go-co">游戏外包公司</a></li>
            <%--Digital Game Company--%>
            <li class="dg-co"><a href="#dg-co">数字游戏公司</a></li>
            <%--Embedded company--%>
            <li class="embedded-co"><a href="#embedded-co">嵌入式公司</a></li>
            <%--Internet Co--%>
            <li class="internet-co"><a href="#internet-co">互联网公司</a></li>
            <%--e-commerce--%>
            <li class="e-commerce"><a href="#e-commerce">电子商务公司</a></li>
            <%--others--%>
            <li class="others"><a href="#others">其他行业</a></li>
        </ul>

        <div class="clear"></div>

        <section class="row portfolio filtrable clearfix">
            <c:forEach items="${companyPageBean.beanList}" var="company">
                <c:choose>
                    <c:when test="${company.comtype_id eq 1}">
                        <article data-id="id-${company.com_id}" data-type="ils-co" class="span3" >
                            <div class="inner-image">
                                <img src="${pageContext.request.contextPath}/upload/company/img/${company.com_img}" alt="photo" style="height: 200px"/>
                                <span class="frame-overlay"></span>
                            </div>
                            <div class="inner-text">
                                <h4 class="title"><a href="${pageContext.request.contextPath}/companyServlet?method=findCompanyById&comid=${company.com_id}">${company.com_name}</a></h4>
                                <p>${company.com_info}</p>
                            </div>
                        </article>
                    </c:when>
                    <c:when test="${company.comtype_id eq 2}">
                        <article data-id="id-${company.com_id}" data-type="go-co" class="span3">
                            <div class="inner-image">
                                <img src="${pageContext.request.contextPath}/upload/company/img/${company.com_img}" alt="photo" style="height: 200px"/>
                                <span class="frame-overlay"></span>
                            </div>
                            <div class="inner-text">
                                <h4 class="title"><a href="${pageContext.request.contextPath}/companyServlet?method=findCompanyById&comid=${company.com_id}">${company.com_name}</a></h4>
                                <p>${company.com_info}</p>
                            </div>
                        </article>
                    </c:when>
                    <c:when test="${company.comtype_id eq 3}">
                        <article data-id="id-${company.com_id}" data-type="dg-co" class="span3">
                            <div class="inner-image">
                                <img src="${pageContext.request.contextPath}/upload/company/img/${company.com_img}" alt="photo" style="height: 200px"/>
                                <span class="frame-overlay"></span>
                            </div>
                            <div class="inner-text">
                                <h4 class="title"><a href="${pageContext.request.contextPath}/companyServlet?method=findCompanyById&comid=${company.com_id}">${company.com_name}</a></h4>
                                <p>${company.com_info}</p>
                            </div>
                        </article>
                    </c:when>
                    <c:when test="${company.comtype_id eq 4}">
                        <article data-id="id-${company.com_id}" data-type="embedded-co" class="span3">
                            <div class="inner-image">
                                <img src="${pageContext.request.contextPath}/upload/company/img/${company.com_img}" alt="photo" style="height: 200px"/>
                                <span class="frame-overlay"></span>
                            </div>
                            <div class="inner-text">
                                <h4 class="title"><a href="${pageContext.request.contextPath}/companyServlet?method=findCompanyById&comid=${company.com_id}">${company.com_name}</a></h4>
                                <p>${company.com_info}</p>
                            </div>
                        </article>
                    </c:when>
                    <c:when test="${company.comtype_id eq 5}">
                        <article data-id="id-${company.com_id}" data-type="internet-co" class="span3">
                            <div class="inner-image">
                                <img src="${pageContext.request.contextPath}/upload/company/img/${company.com_img}" alt="photo" style="height: 200px"/>
                                <span class="frame-overlay"></span>
                            </div>
                            <div class="inner-text">
                                <h4 class="title"><a href="${pageContext.request.contextPath}/companyServlet?method=findCompanyById&comid=${company.com_id}">${company.com_name}</a></h4>
                                <p>${company.com_info}</p>
                            </div>
                        </article>
                    </c:when>

                    <c:when test="${company.comtype_id eq 6}">
                        <article data-id="id-${company.com_id}" data-type="e-commerce" class="span3">
                            <div class="inner-image">
                                <img src="${pageContext.request.contextPath}/upload/company/img/${company.com_img}" alt="photo" style="height: 200px"/>
                                <span class="frame-overlay"></span>
                            </div>
                            <div class="inner-text">
                                <h4 class="title"><a href="${pageContext.request.contextPath}/companyServlet?method=findCompanyById&comid=${company.com_id}">${company.com_name}</a></h4>
                                <p>${company.com_info}</p>
                            </div>
                        </article>
                    </c:when>
                    <c:otherwise>
                        <article data-id="id-${company.com_id}" data-type="others" class="span3">
                            <div class="inner-image">
                                <img src="${pageContext.request.contextPath}/upload/company/img/${company.com_img}" alt="photo" style="height: 200px"/>
                                <span class="frame-overlay"></span>
                            </div>
                            <div class="inner-text">
                                <h4 class="title"><a href="${pageContext.request.contextPath}/companyServlet?method=findCompanyById&comid=${company.com_id}">${company.com_name}</a></h4>
                                <p>${company.com_info}</p>
                            </div>
                        </article>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </section>
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
            <a class="my_a_link" href="${pageContext.request.contextPath}/adminLogin.jsp" style="color: #1a1a1a">登陆</a>
        </p>
    </div>
</section>

</body>
</html>
