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
            if(!$("#teanum").val()){
                alert("学号不能为空!");
                return false;
            }
            if(!$("#teaname").val()){
                alert("姓名不能为空!");
                return false;
            }
            if(!$("#teasex").val()){
                alert("性别不能为空!");
                return false;
            }
            if(!$("#teaage").val()){
                alert("年龄不能为空!");
                return false;
            }
            if(!$("#teaphone").val()){
                alert("手机号不能为空!");
                return false;
            }
            if(!$("#teamail").val()){
                alert("邮箱不能为空!");
                return false;
            }
            if(!$("#teapwd").val()){
                alert("密码不能为空!");
                return false;
            }
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
                    <li class="dropdown-header">管理面板</li>
                    <li><a href="${pageContext.request.contextPath}/encryptWeb/admin/adminProfile.jsp">账号安全</a></li>
                    <li class="divider"></li>
                    <li><a tabindex="-1" href="${pageContext.request.contextPath}/adminLogin.jsp">安全退出</a></li>
                </ul>
            </li>
        </ul>

    </div>
</div>

<%--左侧边栏--%>
<div class="sidebar-nav">
    <ul>
        <%--网站数据--%>
        <li><a href="${pageContext.request.contextPath}/encryptWeb/admin/adminHome.jsp" class="nav-header" target="_self"><i
                class="fa fa-fw fa-heart"></i>&nbsp;&nbsp;网站数据</a></li>
        <%--教师管理--%>
        <li><a href="${pageContext.request.contextPath}/teacherServlet?method=findAllTeachers" class="nav-header"><i
                class="fa fa-fw fa-question-circle"></i>&nbsp;&nbsp;教师管理</a></li>

        <%--学生管理--%>
        <li><a href="${pageContext.request.contextPath}/studentServlet?method=findAllStudents" data-target=".dashboard-menu" class="nav-header" data-toggle="collapse">
            <%--<li><a href="#" data-target=".dashboard-menu" class="nav-header" data-toggle="collapse">--%>
            <i class="fa fa-fw fa-dashboard"></i>&nbsp;&nbsp;学生管理<i class="fa fa-collapse"></i></a></li>
        <li>
            <ul class="dashboard-menu nav nav-list collapse"><!--"class=in"的时候展开-->
                <c:forEach items="${stuLevelPageBean.beanList}" var="stulevel">
                    <li><a href="${pageContext.request.contextPath}/studentServlet?method=findStudentsByLevel&levelid=${stulevel.stu_level_id}"><span class="fa fa-caret-right"></span>${stulevel.stu_level_name}</a></li>
                </c:forEach>
            </ul>
        </li>
            <%--企业管理--%>
            <li>
                <a href="${pageContext.request.contextPath}/companyServlet?method=adminFindAllComanies" data-target=".premium-menu" class="nav-header collapsed" data-toggle="collapse">
                    <i class="fa fa-fw fa-briefcase"></i>&nbsp;&nbsp;企业管理<i class="fa fa-collapse"></i>
                </a>
            </li>
            <li>
                <ul class="premium-menu nav nav-list collapse">
                    <c:forEach items="${comtypePageBean.beanList}" var="comtypes">
                        <li>
                            <a href="${pageContext.request.contextPath}/companyServlet?method=adminFindCompaniesByType&comtypeid=${comtypes.comtype_id}">
                                <span class="fa fa-caret-right"></span>${comtypes.comtype_name}
                            </a>
                        </li>
                    </c:forEach>
                    <li><a href="${pageContext.request.contextPath}/encryptWeb/admin/addCompany.jsp"><span class="fa fa-caret-right"></span>增加企业</a></li>
                    <li><a href="${pageContext.request.contextPath}/employeeServlet?method=adminFindAllEmployees"><span class="fa fa-caret-right"></span>企业导师</a></li>
                </ul>
            </li>

        <%--新闻中心--%>
        <li>
            <a href="${pageContext.request.contextPath}/newsServlet?method=adminFindAllNews" data-target=".legal-menu" class="nav-header collapsed" data-toggle="collapse">
                <i class="fa fa-fw fa-legal"></i>&nbsp;&nbsp;新闻中心<i class="fa fa-collapse"></i>
            </a>
        </li>
        <li>
            <ul class="legal-menu nav nav-list collapse">
                <c:forEach items="${newsSectionPageBean.beanList}" var="newsSections">
                    <li><a href="${pageContext.request.contextPath}/newsServlet?method=adminFindNewsBySection&sectionid=${newsSections.news_section_id}"><span class="fa fa-caret-right"></span>${newsSections.news_section_name}</a></li>
                </c:forEach>
                <li><a href="${pageContext.request.contextPath}/encryptWeb/admin/addNews.jsp"><span class="fa fa-caret-right"></span> 上传新闻</a></li>
            </ul>
        </li>

        <%--通知公告--%>
        <li>
            <a href="${pageContext.request.contextPath}/noticeServlet?method=adminFindAllNotices" data-target=".accounts-menu" class="nav-header collapsed" data-toggle="collapse">
                <i class="fa fa-fw fa-comment"></i>&nbsp;&nbsp;通知公告<i class="fa fa-collapse"></i>
            </a>
        </li>
        <li>
            <ul class="accounts-menu nav nav-list collapse">
                <c:forEach items="${noticeSectionPageBean.beanList}" var="noticeSections">
                    <li><a href="${pageContext.request.contextPath}/noticeServlet?method=adminFindNoticesBySection&sectionid=${noticeSections.notice_section_id}"><span class="fa fa-caret-right"></span>${noticeSections.notice_section_name}</a></li>
                </c:forEach>
                <li><a href="${pageContext.request.contextPath}/encryptWeb/admin/addNotice.jsp"><span class="fa fa-caret-right"></span> 上传公告</a></li>
            </ul>
        </li>

        <%--<li><a href="faq.html" class="nav-header"><i class="fa fa-fw fa-comment"></i> Faq</a></li>--%>
    </ul>
</div>

<div class="content">
    <div class="main-content">

        <ul class="nav nav-tabs">
            <li class="active"><a href="#home" data-toggle="tab">基本资料</a></li>
            <li><a href="#profile" data-toggle="tab">更改密码</a></li>
        </ul>

        <div class="row">
            <div class="col-md-4">
                <br>
                <form action="${pageContext.request.contextPath}/teacherServlet?method=updateTeacher&teacherid=${tea.tea_id}" method="post" onsubmit="return checkForm()">
                    <div id="myTabContent" class="tab-content">
                        <div class="tab-pane active in" id="home">
                            <div id="tab" >
                                <div class="form-group">
                                    <label for="teanum">工号</label>
                                    <input type="text" name="teanum" id="teanum" value="${tea.tea_num}" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="teaname">姓名</label>
                                    <input type="text" name="teaname" id="teaname" value="${tea.tea_name}" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="teasex">性别</label>
                                    <input type="text" name="teasex" id="teasex" value="${tea.tea_sex}" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="teaage">年龄</label>
                                    <input type="text" name="teaage" id="teaage" value="${tea.tea_age}" class="form-control">
                                </div>

                                <div class="form-group">
                                    <label for="depid">院系</label>
                                    <select name="depid" id="depid" class="form-control">
                                        <%--pb是院系的pageBean--%>
                                            <c:forEach items="${departmentPageBean.beanList}" var="department">
                                                <c:choose>
                                                    <c:when test="${department.dep_id eq tea.dep_id}">
                                                        <option value="${department.dep_id}" selected="selected">${department.dep_name}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${department.dep_id}">${department.dep_name} </option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="teaphone">手机号</label>
                                    <input type="text" id="teaphone" name="teaphone" value="${tea.tea_phone}" class="form-control">
                                </div>

                                <div class="form-group">
                                    <label for="teamail">邮箱</label>
                                    <input type="text" id="teamail" name="teamail" value="${tea.tea_mail}" class="form-control">
                                </div>

                                <%--<div class="form-group">--%>
                                    <%--<label>Address</label>--%>
                                    <%--<textarea value="Smith" rows="3" class="form-control">内容</textarea>--%>
                                <%--</div>--%>

                            </div>
                        </div>

                        <div class="tab-pane fade" id="profile">

                            <div id="tab2">
                                <div class="form-group">
                                    <label for="teapwd">输入新密码</label>
                                    <input type="password" class="form-control" id="teapwd" name="teapwd" value="${tea.tea_pwd}">
                                </div>
                                <%--<div>--%>
                                    <%--<button class="btn btn-primary">更新密码</button>--%>
                                <%--</div>--%>
                            </div>
                        </div>
                    </div>

                    <div class="btn-toolbar list-toolbar">
                        <button class="btn btn-primary" type="submit"><i class="fa fa-save"></i> 更新</button>
                        <%--<a href="#myModal" data-toggle="modal" class="btn btn-danger">Delete</a>--%>
                    </div>
                </form>

                <small>${msgUpdateTeacher}</small>
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
