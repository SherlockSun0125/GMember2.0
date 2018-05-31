<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>管理员</title>

    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/encryptWeb/admin/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/encryptWeb/admin/lib/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/theme.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/premium.css">
    <script src="${pageContext.request.contextPath}/encryptWeb/admin/lib/jquery-1.11.1.min.js"
            type="text/javascript"></script>

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


    <script src="${pageContext.request.contentType}/encryptWeb/admin/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function () {
            $('.demo-cancel-click').click(function () {
                return false;
            });
        });
    </script>
    <link href="${pageContext.request.contextPath}/pager/adminPager.css" rel="stylesheet" type="text/css">

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
            <ul class="dashboard-menu nav nav-list collapse in"><!--"class=in"的时候展开-->
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
        <div class="btn-toolbar list-toolbar">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/studentServlet?method=toAddStudent"><i class="fa fa-plus"></i>增加学生</a>
            <%--<button class="btn btn-default">导入</button>--%>
            <%--<button class="btn btn-default">导出</button>--%>
            <div class="btn-group"></div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th>id</th>
                <th>学号</th>
                <th>姓名</th>
                <th>院系</th>
                <th>阶段</th>
                <th>教师</th>
                <th>导师</th>
                <th>谨慎操作</th>
            </tr>
            </thead>
            <tbody>
            <%--<c:set var="num" value="0"></c:set>--%>
            <c:forEach items="${pb.beanList}" var="stu">
                <tr>
                    <td>${stu.stu_id}</td>
                    <td><a href="${pageContext.request.contextPath}/studentServlet?method=adminFindStudentById&studentid=${stu.stu_id}">${stu.stu_num}</a></td>
                    <td>${stu.stu_name}</td>
                    <td>
                        <c:forEach items="${departmentPageBean.beanList}" var="dep">
                            <c:choose>
                                <c:when test="${stu.dep_id eq dep.dep_id}">
                                    ${dep.dep_name}
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${stuLevelPageBean.beanList}" var="stulevel">
                            <c:choose>
                                <c:when test="${stulevel.stu_level_id eq stu.stu_level_id}">
                                    ${stulevel.stu_level_name}
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${teacherPageBean.beanList}" var="teachers">
                            <c:choose>
                                <c:when test="${stu.tea_id eq teachers.tea_id}">
                                    ${teachers.tea_name}
                                </c:when>
                            </c:choose>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${stu.tea_id eq 0}">
                                未分配
                            </c:when>
                        </c:choose>
                    </td>
                    <td>
                        <c:forEach items="${employeePageBean.beanList}" var="employees">
                            <c:choose>
                                <c:when test="${stu.emp_id eq employees.emp_id}">
                                    ${employees.emp_name}
                                </c:when>
                            </c:choose>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${stu.emp_id eq 0}">
                                未分配
                            </c:when>
                        </c:choose>
                    </td>
                    <td style="text-align: center">
                        <a href="${pageContext.request.contextPath}/studentServlet?method=toUpdateStudent&studentid=${stu.stu_id}"><i
                                class="fa fa-pencil"></i></a>
                        &nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath}/studentServlet?method=deleteStudent&studentid=${stu.stu_id}&studentname=${stu.stu_name}"
                           role="button"><i class="fa fa-trash-o"></i></a>
                            <%--<a href="#myModal" role="button" data-toggle="modal" data-target="myModal"><i class="fa fa-trash-o"></i></a>--%>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div style="float:left; width: 100%; text-align: center;" >
            <%@include file="/pager/pager.jsp"%>
        </div>
        <small>${msgDeleteStudent}</small>

        <%--<ul class="pagination">--%>
        <%--<li><a href="#">&laquo;</a></li>--%>
        <%--<li><a href="#">1</a></li>--%>
        <%--<li><a href="#">2</a></li>--%>
        <%--<li><a href="#">3</a></li>--%>
        <%--<li><a href="#">4</a></li>--%>
        <%--<li><a href="#">5</a></li>--%>
        <%--<li><a href="#">&raquo;</a></li>--%>
        <%--</ul>--%>

        <%--modal 为模态框--%>
        <div class="modal small fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <form action="${pageContext.request.contextPath}/teacherServlet?method=deleteTeacher&teacherid=${tea.tea_id}">
                    <div class="modal-content">
                        <%--模态框头部--%>
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h3 id="myModalLabel">删除提醒</h3>
                        </div>
                        <%--模态框身体部分--%>
                        <div class="modal-body">
                            <p class="error-text"><i class="fa fa-warning modal-icon"></i>你确定删除该用户吗？
                                <br>该操作不可逆。</p>
                        </div>
                        <%--模态框底部--%>
                        <div class="modal-footer">
                            <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">取消</button>
                            <button class="btn btn-danger" type="submit">删除</button>
                            <%--<button class="btn btn-danger" href="${pageContext.request.contextPath}/encryptWeb/admin/index.jsp">删除2</button>--%>
                        </div>
                    </div>
                </form>
            </div>

        </div>


        <%--<footer style="position: absolute;bottom: 0;width: 100%">--%>
        <footer>
            <hr>
            <p align="right">© 2018 <a href="${pageContext.request.contextPath}/index.jsp" target="_blank">哈工大（威海）工程领军人与卓越工程师计划&nbsp;&nbsp;</a>
            </p>
        </footer>
    </div>
</div>
</body>
</html>
