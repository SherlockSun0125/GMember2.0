<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>管理员</title>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/encryptWeb/admin/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/encryptWeb/admin/lib/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/encryptWeb/admin/lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/encryptWeb/admin/lib/jQuery-Knob/js/jquery.knob.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            $(".knob").knob();
        });
    </script>
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
    <link href="${pageContext.request.contextPath}/pager/adminPager.css" rel="stylesheet" type="text/css">

    <style type="text/css">
        .tname{
            width: 7em;
            font-weight: bold;
        }
        table, th, td{
            border: 3px solid #EEEEEE;
        }
    </style>
</head>

<body class="theme-blue">
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
                    <li><a href="${pageContext.request.contextPath}/encryptWeb/admin/addCompany.jsp"><span class="fa fa-caret-right"></span> 增加企业</a></li>
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
            <ul class="accounts-menu nav nav-list collapse in">
                <c:forEach items="${noticeSectionPageBean.beanList}" var="noticeSections">
                    <li><a href="${pageContext.request.contextPath}/noticeServlet?method=adminFindNoticesBySection&sectionid=${noticeSections.notice_section_id}"><span class="fa fa-caret-right"></span>${noticeSections.notice_section_name}</a></li>
                </c:forEach>
                <li><a href="${pageContext.request.contextPath}/encryptWeb/admin/addNotice.jsp"><span class="fa fa-caret-right"></span> 上传公告</a></li>
            </ul>
        </li>

        <%--<li><a href="faq.html" class="nav-header"><i class="fa fa-fw fa-comment"></i> Faq</a></li>--%>
    </ul>
</div>

<%--中间部分--%>
<div class="content">
    <div class="main-content">
        <div class="btn-toolbar list-toolbar">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/noticeServlet?method=toUpdateNotice&notiid=${noti.noti_id}">
                <i class="fa fa-pencil"></i>&nbsp;修改公告</a>
            <button class="btn btn-default">导出新闻</button>
            <div class="btn-group"></div>
        </div>
        <div>
            <table class="table table-bordered">
                <tbody>
                    <tr>
                        <td class="tname" style="border: 3px solid #EEEEEE">公告标题</td>
                        <td colspan="5" style="border: 3px solid #EEEEEE">${noti.noti_title}</td>
                    </tr>
                    <tr>
                        <td class="tname" style="border: 3px solid #EEEEEE">发布者</td>
                        <td>${noti.publisher}</td>
                        <td  class="tname" style="border: 3px solid #EEEEEE">管理员姓名</td>
                        <td style="border: 3px solid #EEEEEE">
                            ${noti.author_id}
                        </td>
                        <td class="tname" style="border: 3px solid #EEEEEE">新闻来源</td>
                        <td style="border: 3px solid #EEEEEE">${noti.noti_source}</td>
                    </tr>
                    <tr>
                        <td class="tname" style="border: 3px solid #EEEEEE">时间</td>
                        <td style="border: 3px solid #EEEEEE">${noti.noti_time}</td>
                        <td class="tname" style="border: 3px solid #EEEEEE">版块</td>
                        <td style="border: 3px solid #EEEEEE">
                            <c:forEach items="${noticeSectionPageBean.beanList}" var="noticeSection">
                                <c:choose>
                                    <c:when test="${noti.noti_section_id eq noticeSection.notice_section_id}">
                                    ${noticeSection.notice_section_name}
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </td>
                        <td class="tname" style="border: 3px solid #EEEEEE">阅读次数</td>
                        <td style="border: 3px solid #EEEEEE">${noti.noti_readtimes}</td>
                    </tr>
                    <tr>
                        <td class="tname" style="vertical-align: middle;text-align: center;border: 3px solid #EEEEEE">公<br/>告<br/>内<br/>容</td>
                        <td colspan="5" style="border: 3px solid #EEEEEE">${noti.noti_content}</td>
                    </tr>
                </tbody>
            </table>
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
