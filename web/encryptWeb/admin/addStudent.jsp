<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=utf-8" %>
<html>
<head>
    <title>管理员</title>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/encryptWeb/admin/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/encryptWeb/admin/lib/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/encryptWeb/admin/lib/jquery-1.11.1.min.js"
            type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/theme.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/premium.css">
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
    <script src="${pageContext.request.contextPath}/encryptWeb/admin/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function () {
            $('.demo-cancel-click').click(function () {
                return false;
            });
        });
    </script>

    <script type="text/javascript">
        function checkForm() {
            if(!$("#stunum").val()){
                alert("学号不能为空!");
                return false;
            }
            if(!$("#stuname").val()){
                alert("姓名不能为空!");
                return false;
            }
            if(!$("#stusex").val()){
                alert("性别不能为空!");
                return false;
            }
            if(!$("#stuage").val()){
                alert("年龄不能为空!");
                return false;
            }
            if(!$("#depid").val()){
                alert("院系不能为空!");
                return false;
            }
            if(!$("#stulevelid").val()){
                alert("阶段不能为空!");
                return false;
            }
            if(!$("#stuphone").val()){
                alert("手机号不能为空!");
                return false;
            }
            if(!$("#stumail").val()){
                alert("邮箱不能为空!");
                return false;
            }
            return true;
        }
    </script>

</head>
<body class=" theme-blue">
<!--头部-->
<div class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <a class="" href="${pageContext.request.contextPath}/encryptWeb/admin/adminHome.jsp">
            <span class="navbar-brand" style="padding-top: 2px;height: 45px">
                <img src="${pageContext.request.contextPath}/images/myimg/hitwh_logo.png" height="45px"
                     style="padding-top: 0;padding-bottom: 0">
            </span>
        </a>
    </div>

    <div class="navbar-collapse collapse" style="height: 1px;">
        <ul id="main-menu" class="nav navbar-nav navbar-right">
            <li class="dropdown hidden-xs">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user padding-right-small"
                          style="position:relative;top: 3px;"></span>${Admin.admin_name}
                    <i class="fa fa-caret-down"></i>
                </a>

                <ul class="dropdown-menu">
                    <li><a href="./">我的账户</a></li>
                    <li class="divider"></li>
                    <li class="dropdown-header">管理面板</li>
                    <%--<li><a href="./">用户</a></li>--%>
                    <li><a href="./">安全</a></li>
                    <li class="divider"></li>
                    <li><a tabindex="-1" href="${pageContext.request.contextPath}/adminLogin.jsp">退出</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>

<%--左侧边栏--%>
<div class="sidebar-nav">
    <ul>
        <%--网站数据--%>
        <li><a href="${pageContext.request.contextPath}/encryptWeb/admin/adminHome.jsp" class="nav-header"
               target="_self"><i
                class="fa fa-fw fa-heart"></i>&nbsp;&nbsp;网站数据</a></li>
        <%--教师管理--%>
        <li><a href=""${pageContext.request.contextPath}/encryptWeb/admin/stucherList.jsp" class="nav-header"><i class="fa fa-fw fa-question-circle"></i>&nbsp;&nbsp;教师管理</a>
        </li>

        <%--学生管理--%>
        <li><a href="#" data-target=".dashboard-menu" class="nav-header" data-toggle="collapse">
            <i class="fa fa-fw fa-dashboard"></i>&nbsp;&nbsp;学生管理<i class="fa fa-collapse"></i></a></li>
        <li>
            <ul class="dashboard-menu nav nav-list collapse"><!--"class=in"的时候展开-->
                <li><a href="${pageContext.request.contextPath}/encryptWeb/admin/studentL0.jsp"><span class="fa fa-caret-right"></span> 学生遴选阶段</a></li>
                <li><a href=""${pageContext.request.contextPath}/encryptWeb/admin/studentL1.jsp"><span class="fa fa-caret-right"></span> 工程学习阶段</a></li>
                <li><a href=""${pageContext.request.contextPath}/encryptWeb/admin/studentL2.jsp"><span class="fa fa-caret-right"></span> 校企合作阶段</a></li>
                <li><a href=""${pageContext.request.contextPath}/encryptWeb/admin/studentL3.jsp"><span class="fa fa-caret-right"></span> 毕业设计阶段</a></li>
                <li><a href=""${pageContext.request.contextPath}/encryptWeb/admin/studentL4.jsp"><span class="fa fa-caret-right"></span> 就业推荐阶段</a></li>
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
            <ul class="legal-menu nav nav-list collapse">
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

    </ul>
</div>

<div class="content">
    <div class="main-content">

        <ul class="nav nav-tabs">
            <li class="active"><a href="#home" data-toggle="tab">基本资料</a></li>
            <%--<li><a href="#profile" data-toggle="tab">更改密码</a></li>--%>
        </ul>

        <div class="row">
            <div class="col-md-4">
                <br>
                <form action="${pageContext.request.contextPath}/studentServlet?method=addStudent" method="post" onsubmit="return checkForm()">
                    <div id="myTabContent" class="tab-content">
                        <div class="tab-pane active in" id="home">
                            <div id="tab" >
                                <div class="form-group">
                                    <label for="stunum">学号</label>
                                    <input type="text" name="stunum" id="stunum" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="stuname">姓名</label>
                                    <input type="text" name="stuname" id="stuname" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="stusex">性别</label>
                                    <input type="text" name="stusex" id="stusex" placeholder="男/女" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="stuage">年龄</label>
                                    <input type="text" name="stuage" id="stuage" class="form-control">
                                </div>

                                <div class="form-group">
                                    <label for="depid">院系</label>
                                    <select name="depid" id="depid" class="form-control">
                                        <%--pb是院系的pageBean--%>
                                            <c:forEach items="${departmentPageBean.beanList}" var="department">
                                                <option value="${department.dep_id}">${department.dep_name} </option>
                                            </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="stulevelid">阶段</label>
                                    <select name="stulevelid" id="stulevelid" class="form-control">
                                        <c:forEach items="${stuLevelPageBean.beanList}" var="stulevel">
                                           <option value="${stulevel.stu_level_id}">${stulevel.stu_level_name} </option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="stuphone">手机号</label><small>(密码默认为手机号)</small>
                                    <input type="text" id="stuphone" name="stuphone" class="form-control">
                                </div>

                                <div class="form-group">
                                    <label for="stumail">邮箱</label>
                                    <input type="text" id="stumail" name="stumail" class="form-control">
                                </div>

                                <div class="form-group">
                                    <label for="stunote">备注</label>
                                    <textarea name="stunote" id="stunote" rows="3" class="form-control"></textarea>
                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="btn-toolbar list-toolbar">
                        <button class="btn btn-primary" type="submit"><i class="fa fa-save"></i>&nbsp;增加</button>
                        <%--<a href="#myModal" data-toggle="modal" class="btn btn-danger">Delete</a>--%>
                    </div>
                </form>

                <small>${msgAddStudent}</small>
            </div>
        </div>

        <footer>
            <hr>
            <p align="right">© 2018 <a href="${pageContext.request.contextPath}/index.jsp" target="_blank">哈工大（威海）工程领军人与卓越工程师计划&nbsp;&nbsp;</a>
            </p>
        </footer>
    </div>
</div>
</body>
</html>
