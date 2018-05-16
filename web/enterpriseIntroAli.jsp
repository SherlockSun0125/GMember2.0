<%@page contentType="text/html; charset=utf-8" %>
<html>
<head>
    <title>企业介绍</title>
    <meta name="viewport" content="width=100%; initial-scale=1; maximum-scale=1; minimum-scale=1; user-scalable=no;"/>
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/images/apple-touch-icon-144-precomposed.png"/>
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/images/apple-touch-icon-114-precomposed.png"/>
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/images/apple-touch-icon-72-precomposed.png"/>
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/images/apple-touch-icon-57-precomposed.png"/>
    <link href="${pageContext.request.contextPath}/css/bootstrap-2.min.css" type="text/css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/prettyPhoto.css" type="text/css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/font-icomoon.css" type="text/css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/font-awesome.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.quicksand.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/superfish.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/hoverIntent.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.flexslider.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jflickrfeed.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.elastislide.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.tweet.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/smoothscroll.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.ui.totop.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/ajax-mail.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>


<body>

<!--header-->
<header id="header">
    <div class="container" style="margin-bottom: 2px">
        <div class="row header-top" style="margin-left:5px;margin-bottom:0;">
            <div class="span5 logo" style="width: 100%;margin-left:10px">
                <a class="logo-img" href="home.jsp" title="responsive template" style="margin-bottom: 5px"><img
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
                        <li class="current"><a href="${pageContext.request.contextPath}/enterprise.jsp"><span class="name">合作企业</span></a>
                        </li>
                        <li><a><span class="name">用户中心</span></a>
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/studentLogin.jsp" target="_blank">学生用户登录</a></li>
                                <li><a href="${pageContext.request.contextPath}/teacherLogin.jsp" target="_blank">教师用户登录</a></li>
                                <li><a href="${pageContext.request.contextPath}/employeeLogin.jsp" target="_blank">企业用户登录</a></li>
                            </ul>
                        </li>
                        <%--<li><a href="download.jsp"><span class="name">下载中心</span></a></li>--%>
                        <li><a href="${pageContext.request.contextPath}/about1.jsp"><span class="name">计划介绍</span></a></li>
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
        <div class="row">
            <section id="page-sidebar" class="alignrleft span8">

                <article class="blog-post">
                    <div class="row">
                        <div class="span8">
                            <h3 class="post-title">阿里巴巴集团</h3>
                            <div class="post-media"><img src="${pageContext.request.contextPath}/images/enterprise/alibaba-1.jpg" alt=""/></div>
                            <div class="post-content">
                                <p class="introP">
                                    阿里巴巴网络技术有限公司（简称：阿里巴巴集团）是以曾担任英语教师的马云为首的18人于1999年在浙江杭州创立。
                                    阿里巴巴集团经营多项业务，另外也从关联公司的业务和服务中取得经营商业生态系统上的支援。
                                    业务和关联公司的业务包括：淘宝网、天猫、聚划算、全球速卖通、阿里巴巴国际交易市场、1688、阿里妈妈、阿里云、蚂蚁金服、
                                    菜鸟网络等。
                                </p>

                                <%--<blockquote>--%>
                                <%----%>
                                <%--</blockquote>--%>
                                <p class="introP">
                                    2014年9月19日，阿里巴巴集团在纽约证券交易所正式挂牌上市，股票代码“BABA”，创始人和董事局主席为马云。
                                </p>
                                <p class="introP">2016年8月，阿里巴巴集团在"2016中国企业500强"中排名第148位。</p>
                            </div>
                            <ul class="post-meta">
                                <li><i class="icon-calendar"></i> <a href="#">2018.04.11</a></li>
                                <li><i class="icon-user"></i> <a href="#">发布人</a></li>
                                </li>
                            </ul>
                        </div>

                    </div>
                </article>

                <hr/>

            </section>
            <!--sidebar-->
            <aside id="sidebar" class="pull-right span4">
                <%--Categories--%>
                <%--<section>--%>
                    <%--<h3 class="widget-title">Categories</h3>--%>
                    <%--<ul class="icons ul-list">--%>
                        <%--<li><a href="#">Nam Interdum Tellus Nisi</a></li>--%>
                        <%--<li><a href="#">Nullam Pharetra Velit Quam</a></li>--%>
                        <%--<li><a href="#">Phasellus Blandit Cursus </a></li>--%>
                        <%--<li><a href="#">Donec Vulputate Justo </a></li>--%>
                        <%--<li><a href="#">Nulla Commodo Leo </a></li>--%>
                    <%--</ul>--%>
                <%--</section>--%>

                    <%--Blog Archives--%>
                <%--<section>--%>
                    <%--<h3 class="widget-title">Blog Archives</h3>--%>
                    <%--<div class="accordion" id="accordion2">--%>
                        <%--<div class="accordion-group">--%>
                            <%--<div class="accordion-heading">--%>
                                <%--<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2"--%>
                                   <%--href="#collapse1">--%>
                                    <%--<i class="icon-minus icon-white"></i>--%>
                                    <%--December 2012--%>
                                <%--</a>--%>
                            <%--</div>--%>
                            <%--<div id="collapse1" class="accordion-body collapse in">--%>
                                <%--<div class="accordion-inner">--%>
                                    <%--<ul class="icons ul-list-2">--%>
                                        <%--<li><a href="#">Wed Design</a></li>--%>
                                        <%--<li><a href="#">Responsive</a></li>--%>
                                        <%--<li><a href="#">HTML5 / CSS3</a></li>--%>
                                        <%--<li><a href="#">Coding Essentials</a></li>--%>
                                        <%--<li><a href="#">SEO Optimization</a></li>--%>
                                    <%--</ul>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="accordion-group">--%>
                            <%--<div class="accordion-heading">--%>
                                <%--<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2"--%>
                                   <%--href="#collapse2">--%>
                                    <%--<i class="icon-plus icon-white"></i>--%>
                                    <%--November 2012--%>
                                <%--</a>--%>
                            <%--</div>--%>
                            <%--<div id="collapse2" class="accordion-body collapse">--%>
                                <%--<div class="accordion-inner">--%>
                                    <%--<ul class="icons ul-list-2">--%>
                                        <%--<li><a href="#">Wed Design</a></li>--%>
                                        <%--<li><a href="#">Responsive</a></li>--%>
                                        <%--<li><a href="#">HTML5 / CSS3</a></li>--%>
                                        <%--<li><a href="#">Coding Essentials</a></li>--%>
                                        <%--<li><a href="#">SEO Optimization</a></li>--%>
                                    <%--</ul>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="accordion-group">--%>
                            <%--<div class="accordion-heading">--%>
                                <%--<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2"--%>
                                   <%--href="#collapse3">--%>
                                    <%--<i class="icon-plus icon-white"></i>--%>
                                    <%--October 2012--%>
                                <%--</a>--%>
                            <%--</div>--%>
                            <%--<div id="collapse3" class="accordion-body collapse">--%>
                                <%--<div class="accordion-inner">--%>
                                    <%--<ul class="icons ul-list-2">--%>
                                        <%--<li><a href="#">Wed Design</a></li>--%>
                                        <%--<li><a href="#">Responsive</a></li>--%>
                                        <%--<li><a href="#">HTML5 / CSS3</a></li>--%>
                                        <%--<li><a href="#">Coding Essentials</a></li>--%>
                                        <%--<li><a href="#">SEO Optimization</a></li>--%>
                                    <%--</ul>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="accordion-group">--%>
                            <%--<div class="accordion-heading">--%>
                                <%--<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2"--%>
                                   <%--href="#collapse4">--%>
                                    <%--<i class="icon-plus icon-white"></i>--%>
                                    <%--September 2012--%>
                                <%--</a>--%>
                            <%--</div>--%>
                            <%--<div id="collapse4" class="accordion-body collapse">--%>
                                <%--<div class="accordion-inner">--%>
                                    <%--<ul class="icons ul-list-2">--%>
                                        <%--<li><a href="#">Wed Design</a></li>--%>
                                        <%--<li><a href="#">Responsive</a></li>--%>
                                        <%--<li><a href="#">HTML5 / CSS3</a></li>--%>
                                        <%--<li><a href="#">Coding Essentials</a></li>--%>
                                        <%--<li><a href="#">SEO Optimization</a></li>--%>
                                    <%--</ul>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="accordion-group">--%>
                            <%--<div class="accordion-heading">--%>
                                <%--<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2"--%>
                                   <%--href="#collapse5">--%>
                                    <%--<i class="icon-plus icon-white"></i>--%>
                                    <%--August 2012--%>
                                <%--</a>--%>
                            <%--</div>--%>
                            <%--<div id="collapse5" class="accordion-body collapse">--%>
                                <%--<div class="accordion-inner">--%>
                                    <%--<ul class="icons ul-list-2">--%>
                                        <%--<li><a href="#">Wed Design</a></li>--%>
                                        <%--<li><a href="#">Responsive</a></li>--%>
                                        <%--<li><a href="#">HTML5 / CSS3</a></li>--%>
                                        <%--<li><a href="#">Coding Essentials</a></li>--%>
                                        <%--<li><a href="#">SEO Optimization</a></li>--%>
                                    <%--</ul>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="accordion-group">--%>
                            <%--<div class="accordion-heading">--%>
                                <%--<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2"--%>
                                   <%--href="#collapse6">--%>
                                    <%--<i class="icon-plus icon-white"></i>--%>
                                    <%--July 2012--%>
                                <%--</a>--%>
                            <%--</div>--%>
                            <%--<div id="collapse6" class="accordion-body collapse">--%>
                                <%--<div class="accordion-inner">--%>
                                    <%--<ul class="icons ul-list-2">--%>
                                        <%--<li><a href="#">Wed Design</a></li>--%>
                                        <%--<li><a href="#">Responsive</a></li>--%>
                                        <%--<li><a href="#">HTML5 / CSS3</a></li>--%>
                                        <%--<li><a href="#">Coding Essentials</a></li>--%>
                                        <%--<li><a href="#">SEO Optimization</a></li>--%>
                                    <%--</ul>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</section>--%>
                <section>
                    <h3 class="widget-title">工作环境</h3>
                    <div id="latestwork-sidebar" class="carousel slide">
                        <div class="carousel-inner">
                            <div class="active item"><img src="${pageContext.request.contextPath}/images/enterprise/alibaba-2.jpg" alt="photo"/></div>
                            <div class="item"><img src="${pageContext.request.contextPath}/images/enterprise/alibaba-3.jpg" alt="photo"/></div>
                            <div class="item"><img src="${pageContext.request.contextPath}/images/enterprise/alibaba-4.jpg" alt="photo"/></div>
                        </div>
                        <a class="carousel-control left" href="#latestwork-sidebar" data-slide="prev"></a>
                        <a class="carousel-control right" href="#latestwork-sidebar" data-slide="next"></a>
                    </div>
                    <script type="text/javascript">
                        $(document).ready(function () {
                            $('.carousel').carousel({
                                interval: 5000
                            })
                        });
                    </script>
                </section>

            </aside>
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
            <a class="my_a_link" href="${pageContext.request.contextPath}/adminLogin.jsp" style="color: #1a1a1a">登陆</a>
        </p>
    </div>
</section>
</body>
</html>
