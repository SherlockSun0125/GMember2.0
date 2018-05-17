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
                          style="position:relative;top: 3px;"></span> ${Admain.admin_name}
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
        <li><a href="teacherList.jsp" class="nav-header"><i class="fa fa-fw fa-question-circle"></i>&nbsp;&nbsp;教师管理</a>
        </li>

        <%--学生管理--%>
        <li><a href="${pageContext.request.contextPath}/studentServlet?method=findAllStudents"
               data-target=".dashboard-menu" class="nav-header" data-toggle="collapse">
            <i class="fa fa-fw fa-dashboard"></i>&nbsp;&nbsp;学生管理<i class="fa fa-collapse"></i></a></li>
        <li>
            <ul class="dashboard-menu nav nav-list collapse in"><!--"class=in"的时候展开-->
                <c:forEach items="${stuLevelPageBean.beanList}" var="stulevel">
                    <li>
                        <a href="${pageContext.request.contextPath}/studentServlet?method=findStudentsByLevel&levelid=${stulevel.stu_level_id}"><span
                                class="fa fa-caret-right"></span>${stulevel.stu_level_name}</a></li>
                </c:forEach>
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
        <div class="btn-toolbar list-toolbar">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/studentServlet?method=toAddStudent"><i class="fa fa-plus"></i>增加学生</a>
            <button class="btn btn-default">导入</button>
            <button class="btn btn-default">导出</button>
            <div class="btn-group"></div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th>id</th>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>院系</th>
                <th>导师</th>
                <th>阶段</th>
                <th>手机号</th>
                <th>邮箱</th>
                <th>备注</th>
                <th>密码</th>
                <th>谨慎操作</th>
            </tr>
            </thead>
            <tbody>
            <%--<c:set var="num" value="0"></c:set>--%>
            <c:forEach items="${pb.beanList}" var="stu">
                <tr>
                    <td>${stu.stu_id}</td>
                    <td>${stu.stu_num}</td>
                    <td>${stu.stu_name}</td>
                    <td>${stu.stu_sex}</td>
                    <td>${stu.stu_age}</td>
                    <td>
                        <c:forEach items="${departmentPageBean.beanList}" var="dep">
                            <c:choose>
                                <c:when test="${stu.dep_id eq dep.dep_id}">
                                    ${dep.dep_name}
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </td>
                    <td>${stu.emp_id}</td>
                    <td>${stu.stu_level_id}</td>
                    <td>${stu.stu_phone}</td>
                    <td>${stu.stu_mail}</td>
                    <td>${stu.stu_note}</td>
                    <td>${stu.stu_pwd}</td>
                    <td style="text-align: center">
                        <a href="${pageContext.request.contextPath}/studentServlet?method=findStudentById&studentid=${stu.stu_id}"><i
                                class="fa fa-pencil"></i></a>
                        &nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath}/studentServlet?method=deleteStudent&studentid=${stu.stu_id}&studentname=${stu.stu_name}&levelid=${stu.stu_level_id}"
                           role="button"><i class="fa fa-trash-o"></i></a>
                            <%--<a href="#myModal" role="button" data-toggle="modal" data-target="myModal"><i class="fa fa-trash-o"></i></a>--%>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
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