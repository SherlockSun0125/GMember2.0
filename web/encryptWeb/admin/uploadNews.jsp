<%@page contentType="text/html; charset=utf-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>管理员</title>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
    <script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="lib/jQuery-Knob/js/jquery.knob.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            $(".knob").knob();
        });
    </script>
    <link rel="stylesheet" type="text/css" href="../../css/theme.css">
    <link rel="stylesheet" type="text/css" href="../../css/premium.css">
    <script type="text/javascript">
        $(function () {
            var match = document.cookie.match(new RegExp('color=([^;]+)'));
            if (match) var color = match[1];
            if (color) {
                $('body').removeClass(function (index, css) {
                    return (css.match(/\btheme-\S+/g) || []).join(' ')
                })
                $('body').addClass('theme-' + color);
            }

            $('[data-popover="true"]').popover({html: true});

        });
    </script>
    <style type="text/css">
        #line-chart {
            height: 300px;
            width: 800px;
            margin: 0px auto;
            margin-top: 1em;
        }

        .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover {
            color: #fff;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            var uls = $('.sidebar-nav > ul > *').clone();
            uls.addClass('visible-xs');
            $('#main-menu').append(uls.clone());
        });
    </script>
    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function () {
            $('.demo-cancel-click').click(function () {
                return false;
            });
        });
    </script>

</head>

<body class="theme-blue">

<!--头部-->
<div class="navbar navbar-default" role="navigation">
    <div class="navbar-header">

        <a class="" href="adminHome.jsp">
            <span class="navbar-brand" style="padding-top: 2px;height: 45px">
                <img src="../../images/myimg/hitwh_logo.png" height="45px" style="padding-top: 0;padding-bottom: 0">
            </span>
        </a>
    </div>

    <div class="navbar-collapse collapse" style="height: 1px;">
        <ul id="main-menu" class="nav navbar-nav navbar-right">
            <li class="dropdown hidden-xs">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user padding-right-small"
                          style="position:relative;top: 3px;"></span> Paul Suen
                    <i class="fa fa-caret-down"></i>
                </a>

                <ul class="dropdown-menu">
                    <li><a href="./">我的账户</a></li>
                    <li class="divider"></li>
                    <li class="dropdown-header">管理面板</li>
                    <%--<li><a href="./">用户</a></li>--%>
                    <li><a href="./">安全</a></li>
                    <li class="divider"></li>
                    <li><a tabindex="-1" href="../../adminLogin.jsp">退出</a></li>
                </ul>
            </li>
        </ul>

    </div>
</div>

<%--左侧边栏--%>
<div class="sidebar-nav">
    <ul>
        <%--网站数据--%>
        <li><a href="adminHome.jsp" class="nav-header" target="_self"><i
                class="fa fa-fw fa-heart"></i>&nbsp;&nbsp;网站数据</a></li>
        <%--教师管理--%>
        <li><a href="teacherM.jsp" class="nav-header"><i class="fa fa-fw fa-question-circle"></i>&nbsp;&nbsp;教师管理</a></li>

        <%--学生管理--%>
        <li><a href="#" data-target=".dashboard-menu" class="nav-header" data-toggle="collapse">
            <i class="fa fa-fw fa-dashboard"></i>&nbsp;&nbsp;学生管理<i class="fa fa-collapse"></i></a></li>
        <li>
            <ul class="dashboard-menu nav nav-list collapse"><!--"class=in"的时候展开-->
                <li><a href=""><span class="fa fa-caret-right"></span> 学生遴选阶段</a></li>
                <li><a href=""><span class="fa fa-caret-right"></span> 工程学习阶段</a></li>
                <li><a href=""><span class="fa fa-caret-right"></span> 校企合作阶段</a></li>
                <li><a href=""><span class="fa fa-caret-right"></span> 毕业设计阶段</a></li>
                <li><a href=""><span class="fa fa-caret-right"></span> 就业推荐阶段</a></li>
                <%--<li><a href="calendar.html"><span class="fa fa-caret-right"></span> Calendar</a></li>--%>
            </ul>
        </li>

        <li data-popover="true" data-placement="right">
            <a href="#" data-target=".premium-menu" class="nav-header collapsed" data-toggle="collapse">
                <i class="fa fa-fw fa-briefcase"></i>&nbsp;&nbsp;企业管理<i class="fa fa-collapse"></i>
            </a>
        </li>
        <li>
            <ul class="premium-menu nav nav-list collapse">
                <li><a href=""><span class="fa fa-caret-right"></span> 国际化大型软件公司</a></li>
                <li><a href=""><span class="fa fa-caret-right"></span> 游戏外包公司</a></li>
                <li><a href=""><span class="fa fa-caret-right"></span> 数字游戏公司</a></li>
                <li><a href=""><span class="fa fa-caret-right"></span> 嵌入式公司</a>
                </li>
                <li><a href=""><span class="fa fa-caret-right"></span> 电子商务公司</a>
                </li>
                <li><a href=""><span class="fa fa-caret-right"></span> 互联网公司</a></li>
                <li><a href=""><span class="fa fa-caret-right"></span> 其他行业</a></li>
                <%--<li><a href="premium-users.html"><span class="fa fa-caret-right"></span> Enhanced Users List</a></li>--%>
                <%--<li><a href="premium-media.html"><span class="fa fa-caret-right"></span> Enhanced Media</a></li>--%>
                <%--<li><a href="premium-invoice.html"><span class="fa fa-caret-right"></span> Invoice</a></li>--%>
                <%--<li><a href="premium-build.html"><span class="fa fa-caret-right"></span> Advanced Tools</a></li>--%>
                <%--<li><a href="premium-colors.html"><span class="fa fa-caret-right"></span> Additional Color Themes</a>--%>
                </li>
            </ul>
        </li>

        <%--新闻中心--%>
        <li>
            <a href="#" data-target=".legal-menu" class="nav-header collapsed" data-toggle="collapse">
                <i class="fa fa-fw fa-legal"></i>&nbsp;&nbsp;新闻中心<i class="fa fa-collapse"></i>
            </a>
        </li>
        <li>
            <ul class="legal-menu nav nav-list collapse in">
                <li><a href=""><span class="fa fa-caret-right"></span> 综合要闻</a></li>
                <li><a href=""><span class="fa fa-caret-right"></span> 校园资讯</a></li>
                <li><a href=""><span class="fa fa-caret-right"></span> 教学科研</a></li>
                <li><a href=""><span class="fa fa-caret-right"></span> 专题新闻</a></li>
                <li><a href=""><span class="fa fa-caret-right"></span> 上传新闻</a></li>
            </ul>
        </li>

        <%--通知公告--%>
        <li>
            <a href="#" data-target=".accounts-menu" class="nav-header collapsed" data-toggle="collapse">
                <i class="fa fa-fw fa-comment"></i>&nbsp;&nbsp;通知公告<i class="fa fa-collapse"></i>
            </a>
        </li>
        <li>
            <ul class="accounts-menu nav nav-list collapse">
                <li><a href=""><span class="fa fa-caret-right"></span> 通知公告</a></li>
                <li><a href=""><span class="fa fa-caret-right"></span> 院系通知</a></li>
                <li><a href=""><span class="fa fa-caret-right"></span> 学术科研</a></li>
                <li><a href=""><span class="fa fa-caret-right"></span> 上传公告</a></li>
            </ul>
        </li>

        <%--<li><a href="faq.html" class="nav-header"><i class="fa fa-fw fa-comment"></i> Faq</a></li>--%>
    </ul>
</div>

<%--中间部分--%>
<div class="content">
    <div class="main-content">
       <div>
           <!-- 加载编辑器的容器 -->
           <script id="container" name="content" type="text/plain">
        这里写你的初始化内容
    </script>
           <!-- 配置文件 -->
           <script type="text/javascript" src="ueditor/ueditor.config.js"></script>
           <!-- 编辑器源码文件 -->
           <script type="text/javascript" src="ueditor/ueditor.all.js"></script>
           <!-- 实例化编辑器 -->
           <script type="text/javascript">
               var ue = UE.getEditor('container');
           </script>
       </div>

        <footer>
            <hr>

            <p align="right">© 2014 <a href="../../index.jsp" target="_blank">哈工大（威海）工程领军人与卓越工程师计划</a></p>
        </footer>
    </div>
</div>

</body>
</html>