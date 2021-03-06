<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>毕业设计阶段管理</title>
    <!--三个重要的CSS文件-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/encryptWeb/teacher/static/core_62c0700cc15bd051f36fa48b7a5c1a26.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/encryptWeb/teacher/static/pt_newpages_course_learn.css">
    <style type="text/css">
        thead th{
            font-weight: bold;
            background-color: #2d89ef;
            text-align: center;
        }
        table{
            text-align: center;
        }
    </style>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pager/pager.css">
    <style type="text/css">
        .lightbox{
            position: fixed;
            top: 0px;
            left: 0px;
            height: 100%;
            width: 100%;
            z-index: 7;
            opacity: 0.3;
            display: block;
            background-color: rgb(0, 0, 0);
            display: none;
        }
        .pop,iframe{
            position: absolute;
            left: 50%;
            top:0;
            width: 893px;
            height: 100%;
            margin-left: -446.5px;
            z-index: 9;
        }
    </style>
</head>


<body style="background-color: #EEEEEE">
<div id="g-container">
    <!--头部-->
    <div class="f-pf g-headwrap" id="j-fixed-head">
        <div class="g-hd f-bg1 m-yktNav " id="j-topnav">
            <div class="g-flow">
                <div class="f-pr f-cb">
                    <div style="position: absolute;top:2px;bottom:2px;">
                        <a class="f-fl" hidefocus="true" target="_self" data-index="logo" href="${pageContext.request.contextPath}/encryptWeb/teacher/teaHome.jsp">
                            <img class="f-fl img" src="${pageContext.request.contextPath}/encryptWeb/teacher/static/hitwh_logo_white.png" title="教师主页" width="540px"
                                 style="margin-top: 2px;margin-bottom: 1px">
                        </a>
                    </div>
                    <div class="m-navrgt f-fr f-cb f-pr j-navright">
                        <div class="userinfo f-fr f-cb f-pr">
                            <div class="login f-cb">
                                <div class="u-mystudy f-pr f-cb f-fr">
                                    <a class="mystudy nitem f-f0" data-index="用户退出" target="_self"
                                       href="${pageContext.request.contextPath}/encryptWeb/teacher/exit.jsp" hidefocus="true">退出</a>
                                </div>
                                <a class="username self f-thide" target="_self" data-index="点击用户名"
                                   href="${pageContext.request.contextPath}/encryptWeb/teacher/setting.jsp">
                                    <span class=" f-fs1 f-f0">${Teacher.tea_name}</span>
                                </a>
                                <i class="line" style="padding-top: 2%"></i>
                                <a data-index="消息" class="mes f-pr f-cb j-nav-mescenter"
                                   href="${pageContext.request.contextPath}/encryptWeb/teacher/forumMessage.jsp" title="查看更多消息" target="_blank">
                                    <span>消息</span>
                                    <em class="num hidddenClass j-nav-msgnum">0</em>
                                </a>
                                <div class="u-mystudy f-pr f-cb f-fr">
                                    <a class="mystudy nitem f-f0" id="j-nav-my-class" data-index="讨论区" target="_self"
                                       href="${pageContext.request.contextPath}/encryptWeb/teacher/forum.jsp" hidefocus="true">讨论区</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--网页主体-->
    <!--网页主体-->
    <div id="g-body">
        <div class="m-cbg"></div>
        <div class="g-wrap f-cb">
            <c:choose>
                <c:when test="${studentPageBean eq null}">
                <!--左侧边栏-->
                <div class="g-sd1">
                    <div class="m-learnleft">
                        <div >
                            <ul class="tab u-tabul">

                            </ul>
                        </div>
                    </div>
                </div>

                <!--中间-->
                <div class="g-mn1">
                    <div class="m-learnbox" style="margin-left: 300px;">
                        <div style="width: 96%">
                                <%--<ul class="nav nav-tabs">--%>
                                <%--<li class="active"><a href="#stuLog" data-toggle="tab">日志</a></li>--%>
                                <%--<li><a href="#stuProject" data-toggle="tab">项目</a></li>--%>
                                <%--</ul>--%>

                            <div class="row">
                                <div class="col-lg-12">
                                    <br>
                                    <div class="tab-content">
                                        <h4>您还未分配该阶段的学生!</h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:when>
                <c:otherwise>
                    <!--左侧边栏-->
                    <div class="g-sd1">
                        <div class="m-learnleft">
                            <div id="j-courseTabList">
                                <ul class="tab u-tabul">
                                    <c:forEach items="${studentPageBean.beanList}" var="student">
                                        <c:choose>
                                            <c:when test="${stu.stu_id eq student.stu_id}">
                                                <li class="u-greentab j-tabitem f-f0 first u-curtab">
                                                    <a class="f-thide f-fc3" href="${pageContext.request.contextPath}/teacherServlet?method=findAllStudentLevelInfo&stuid=${student.stu_id}&stulevelid=${student.stu_level_id}">${student.stu_num}&nbsp;&nbsp;${student.stu_name}</a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="u-greentab j-tabitem f-f0">
                                                    <a class="f-thide f-fc3" href="${pageContext.request.contextPath}/teacherServlet?method=findAllStudentLevelInfo&stuid=${student.stu_id}&stulevelid=${student.stu_level_id}">${student.stu_num}&nbsp;&nbsp;${student.stu_name}</a>
                                                </li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <!--中间-->
                    <div class="g-mn1">

                        <div class="m-learnbox" style="margin-left: 300px;">
                            <div style="width: 96%">
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#stuLog" data-toggle="tab">毕设日志</a></li>
                                    <li><a href="#stuProject" data-toggle="tab">毕设详情</a></li>
                                </ul>

                                <div class="row">
                                    <div class="col-lg-12">
                                        <br>
                                        <div id="myTabContent" class="tab-content">
                                                <div class="tab-pane active in" style="width: 100%;" id="stuLog">
                                                    <!--帖子展示-->
                                                        <c:choose>
                                                            <c:when test="${pb.totalRecords eq 0}">
                                                                <div class="ttitle">
                                                                    <h4 class="f-fl f-fc3">该生还没有写日志</h4>
                                                                    <div class="f-fl u-coursecate j-lessonuit"></div>
                                                                </div>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <div class="m-flwrap">
                                                                    <div class="ttitle">
                                                                        <h4 class="f-fl f-fc3">全部日志</h4>
                                                                        <br/>
                                                                        <hr/>
                                                                        <div class="f-fl u-coursecate j-lessonuit"></div>
                                                                    </div>
                                                                    <div class="f-cb auto-1523950289417-parent">
                                                                        <div class="m-basepool f-cb auto-1523950289417">
                                                                            <div class="j-list" style="">
                                                                                <div class="m-data-lists f-cb f-pr j-data-list">
                                                                                    <!--第一帖-->
                                                                                    <c:forEach items="${pb.beanList}" var="stulogs">
                                                                                        <li class="u-forumli">
                                                                                            <div class="f-cb cnt">
                                                                                                <a></a><a class="f-fc3 f-f0 lb10 j-link" href="${pageContext.request.contextPath}/teacherServlet?method=findLogById&logid=${stulogs.stu_log_id}" target="_self">${stulogs.stu_log_title}</a>
                                                                                            </div>
                                                                                            <span>
                                                                                                <span class="j-txt">
                                                                                                    <span class="lb10 f-fc9">于${stulogs.stu_log_time}发表</span>
                                                                                                </span>
                                                                                            </span>
                                                                                                <p class="f-fc9 f-pa" style="width:110px; bottom: 20px; right:110px;">
                                                                                                <c:choose>
                                                                                                    <c:when test="${stulogs.tea_status eq 3}">
                                                                                                        老师评价：<span><img style="width: 1.2em" src="${pageContext.request.contextPath}/encryptWeb/student/static/praise.png"></span>
                                                                                                    </c:when>
                                                                                                    <c:when test="${stulogs.tea_status eq 2}">
                                                                                                        老师评价：<span><img style="width: 1.2em" src="${pageContext.request.contextPath}/encryptWeb/student/static/remind.png"></span>
                                                                                                    </c:when>
                                                                                                    <c:when test="${stulogs.tea_status eq 1}">
                                                                                                        老师评价：<span><img style="width: 1.2em" src="${pageContext.request.contextPath}/encryptWeb/student/static/warn.png"></span>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>&nbsp;</c:otherwise>
                                                                                                </c:choose>
                                                                                            </p>
                                                                                            &nbsp;
                                                                                            <p class="f-fc9 f-pa" style="width:100px; bottom: 20px; right: 0;">
                                                                                                <c:choose>
                                                                                                    <c:when test="${stulogs.emp_status eq 3}">
                                                                                                        导师评价：<span><img style="width: 1.2em" src="${pageContext.request.contextPath}/encryptWeb/student/static/praise.png"></span>
                                                                                                    </c:when>
                                                                                                    <c:when test="${stulogs.emp_status eq 2}">
                                                                                                        导师评价：<span><img style="width: 1.2em" src="${pageContext.request.contextPath}/encryptWeb/student/static/remind.png"></span>
                                                                                                    </c:when>
                                                                                                    <c:when test="${stulogs.emp_status eq 1}">
                                                                                                        导师评价：<span><img style="width: 1.2em" src="${pageContext.request.contextPath}/encryptWeb/student/static/warn.png"></span>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>&nbsp;</c:otherwise>
                                                                                                </c:choose>
                                                                                            </p>
                                                                                        </li>
                                                                                    </c:forEach>
                                                                                </div>
                                                                                <!--分页-->
                                                                                <div style="float:left; width: 100%; text-align: center;" >
                                                                                    <%@include file="/pager/pager.jsp"%>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </div>

                                                <div class="tab-pane fade" id="stuProject">
                                                    <c:choose>
                                                        <c:when test="${project eq null}">
                                                            <div class="ttitle">
                                                                <h4 class="f-fl f-fc3">该生还没有添加毕设！</h4>
                                                                <div class="f-fl u-coursecate j-lessonuit"></div>
                                                            </div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <div class="m-flwrap">
                                                                <%--<div style="height: 36px;font-weight: bold">--%>
                                                                    <%--&lt;%&ndash;<h4 class="f-fl f-fc3" style="font-weight: bold">项目列表</h4>&ndash;%&gt;--%>
                                                                <%--</div>--%>
                                                                <div style="margin-top: 10px;padding-left: 0;">
                                                                    <table class="table table-bordered" style="text-align: left">
                                                                        <tbody>
                                                                        <tr>
                                                                            <td style="width: 6em;text-align: center;font-weight: bold">项目名称</td>
                                                                            <td colspan="3">${project.project_name}
                                                                                <c:choose>
                                                                                    <c:when test="${project.isEnd eq 0}">
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <span style="color: red">&nbsp(已结束)</span>
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td style="width: 6em;text-align: center;font-weight: bold">所属课程</td>
                                                                            <td>${project.course}</td>
                                                                            <td style="width: 6em;text-align: center;font-weight: bold">负责教师</td>
                                                                            <td>${project.teacher}</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td style="width: 6em;text-align: center;font-weight: bold">开始时间</td>
                                                                            <td>${project.project_start_time}</td>
                                                                            <td style="width: 6em;text-align: center;font-weight: bold">结束时间</td>
                                                                            <td>${project.project_stop_time}</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td style="width: 6em;text-align: center;font-weight: bold">地点</td>
                                                                            <td>${project.project_place}</td>
                                                                            <td style="width: 6em;text-align: center;font-weight: bold">成员</td>
                                                                            <td>${project.project_member}</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td style="height:10em;width: 6em;text-align: center;font-weight: bold;vertical-align: middle">备<br/>注</td>
                                                                            <td colspan="3">${project.project_about}</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td style="height:12em;width: 6em;text-align: center;font-weight: bold;vertical-align: middle">项<br/>目<br/>开<br/>题<br/>汇<br/>报</td>
                                                                            <td colspan="1" style="width: 25em;">
                                                                                <c:choose>
                                                                                    <c:when test="${project.start_paper eq null}">
                                                                                        <p>该生尚未上传报告！</p>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <a class="btn btn-info"  target="pdfContainer" onclick="showPdf(true)"
                                                                                           href="${pageContext.request.contextPath}/upload/${project.start_paper}">查看开题报告</a><br/>
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </td>
                                                                            <td style="height:12em;width: 6em;text-align: center;font-weight: bold;vertical-align: middle">导<br/>师<br/>评<br/>价</td>
                                                                            <td>
                                                                                    ${project.start_paperF}
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td style="height:12em;width: 6em;text-align: center;font-weight: bold;vertical-align: middle">项<br/>目<br/>中<br/>期<br/>汇<br/>报</td>
                                                                            <td colspan="1">
                                                                                <c:choose>
                                                                                    <c:when test="${project.mid_paper eq null}">
                                                                                        <p>该生尚未上传中期报告！</p>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <a class="btn btn-info"  target="pdfContainer" onclick="showPdf(true)"
                                                                                           href="${pageContext.request.contextPath}/upload/${project.mid_paper}">查看中期报告</a><br/>
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </td>
                                                                            <td style="height:12em;width: 6em;text-align: center;font-weight: bold;vertical-align: middle">导<br/>师<br/>评<br/>价</td>
                                                                            <td>
                                                                                    ${project.mid_paperF}
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td style="height:12em;width: 6em;text-align: center;font-weight: bold;vertical-align: middle">项<br/>目<br/>终<br/>期<br/>汇<br/>报</td>
                                                                            <td colspan="1">
                                                                                <c:choose>
                                                                                    <c:when test="${project.end_paper eq null}">
                                                                                        <p>该生尚未上传终期报告！</p>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <a class="btn btn-info"  target="pdfContainer" onclick="showPdf(true)"
                                                                                           href="${pageContext.request.contextPath}/upload/${project.end_paper}">查看终期报告</a><br/>
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </td>
                                                                            <td style="height:12em;width: 6em;text-align: center;font-weight: bold;vertical-align: middle">导<br/>师<br/>评<br/>价</td>
                                                                            <td colspan="1">
                                                                                    ${project.end_paperF}
                                                                            </td>
                                                                        </tr>
                                                                        </tbody>
                                                                    </table>
                                                                </div>

                                                            </div>
                                                            <div>
                                                                <script src="${pageContext.request.contextPath}/pdfjs/build/pdf.js"></script>
                                                                <script src="${pageContext.request.contextPath}/pdfjs/build/pdf.worker.js"></script>
                                                                <script type="text/javascript">
                                                                    function showPdf(isShow){
                                                                        var state = "";
                                                                        if(isShow){
                                                                            state = "block";
                                                                        }else{
                                                                            state = "none";
                                                                        }
                                                                        var pop = document.getElementById("pop");
                                                                        pop.style.display = state;
                                                                        var lightbox = document.getElementById("lightbox");
                                                                        lightbox.style.display = state;
                                                                    }
                                                                    function close(){
                                                                        showPdf(false);
                                                                    }
                                                                </script>
                                                                <div>
                                                                    <div class="lightbox" id="lightbox"></div>
                                                                    <div id="pop" class="pop" style="display: none;">
                                                                        <a href="javascript:close()" style="
                                                                            position: absolute;
                                                                            right: -90px;
                                                                            display: inline-block;
                                                                            width: 80px;
                                                                            height: 30px;
                                                                        " id="close"><img src="${pageContext.request.contextPath}/encryptWeb/student/static/close.png" width="25px"></a>
                                                                        <iframe src="" frameborder="0" id="pdfContainer" name="pdfContainer"></iframe>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>

                                        <small>${msgUpdateTeacher}</small>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
</body>
</html>