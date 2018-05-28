<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>毕业设计阶段管理</title>
    <!--三个重要的CSS文件-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/encryptWeb/employee/static/core_62c0700cc15bd051f36fa48b7a5c1a26.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/encryptWeb/employee/static/pt_newpages_course_learn.css">
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
                        <a class="f-fl" hidefocus="true" target="_self" data-index="logo" href="${pageContext.request.contextPath}/encryptWeb/employee/empHome.jsp">
                            <img class="f-fl img" src="${pageContext.request.contextPath}/encryptWeb/employee/static/hitwh_logo_white.png" title="教师主页" width="540px"
                                 style="margin-top: 2px;margin-bottom: 1px">
                        </a>
                    </div>
                    <div class="m-navrgt f-fr f-cb f-pr j-navright">
                        <div class="userinfo f-fr f-cb f-pr">
                            <div class="login f-cb">
                                <div class="u-mystudy f-pr f-cb f-fr">
                                    <a class="mystudy nitem f-f0" data-index="用户退出" target="_self"
                                       href="${pageContext.request.contextPath}/encryptWeb/employee/exit.jsp" hidefocus="true">退出</a>
                                </div>
                                <a class="username self f-thide" target="_self" data-index="点击用户名"
                                   href="${pageContext.request.contextPath}/encryptWeb/employee/setting.jsp">
                                    <span class=" f-fs1 f-f0">${Employee.emp_name}</span>
                                </a>
                                <i class="line" style="padding-top: 2%"></i>
                                <a data-index="消息" class="mes f-pr f-cb j-nav-mescenter"
                                   href="${pageContext.request.contextPath}/encryptWeb/employee/forumMessage.jsp" title="查看更多消息" target="_blank">
                                    <span>消息</span>
                                    <em class="num hidddenClass j-nav-msgnum">0</em>
                                </a>
                                <div class="u-mystudy f-pr f-cb f-fr">
                                    <a class="mystudy nitem f-f0" id="j-nav-my-class" data-index="讨论区" target="_self"
                                       href="${pageContext.request.contextPath}/encryptWeb/employee/forum.jsp" hidefocus="true">讨论区</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

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
                                                   <a class="f-thide f-fc3" href="${pageContext.request.contextPath}/employeeServlet?method=findAllStudentLevelResumesEmp&stuid=${student.stu_id}">${student.stu_num}&nbsp;&nbsp;${student.stu_name}</a>
                                               </li>
                                           </c:when>
                                           <c:otherwise>
                                               <li class="u-greentab j-tabitem f-f0">
                                                   <a class="f-thide f-fc3" href="${pageContext.request.contextPath}/employeeServlet?method=findAllStudentLevelResumesEmp&stuid=${student.stu_id}">${student.stu_num}&nbsp;&nbsp;${student.stu_name}</a>
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
                                   <li class="active"><a href="#stuLog" data-toggle="tab">简历</a></li>
                                       <%--<li><a href="#stuProject" data-toggle="tab">毕设详情</a></li>--%>
                               </ul>

                               <div class="row">
                                   <div class="col-lg-12">
                                       <br>
                                       <div id="myTabContent" class="tab-content">
                                           <div class="tab-pane active in" style="width: 100%;" id="stuLog">
                                               <!--帖子展示-->
                                               <c:choose>
                                                   <c:when test="${resume eq null}">
                                                       <div class="ttitle">
                                                           <h4 class="f-fl f-fc3">该生还没有上传简历！</h4>
                                                           <div class="f-fl u-coursecate j-lessonuit"></div>
                                                       </div>
                                                   </c:when>
                                                   <c:otherwise>
                                                       <div class="m-flwrap">
                                                               <%--<div class="ttitle">--%>
                                                               <%--&lt;%&ndash;<h4 class="f-fl f-fc3">全部日志</h4>&ndash;%&gt;--%>
                                                               <%--<br/>--%>
                                                               <%--<hr/>--%>
                                                               <%--<div class="f-fl u-coursecate j-lessonuit"></div>--%>
                                                               <%--</div>--%>
                                                           <div class="f-cb auto-1523950289417-parent">
                                                               <div class="m-basepool f-cb auto-1523950289417">
                                                                   <div class="j-list" style="">
                                                                       <div class="m-data-lists f-cb f-pr j-data-list">
                                                                           <div>
                                                                               <a  href="${pageContext.request.contextPath}/upload/${resume.resume_path}" target="pdfContainer" onclick="showPdf(true)" style="width: 120px;padding-right: 20px">
                                                                                   <img src="${pageContext.request.contextPath}/encryptWeb/student/static/lookResume.png" style="width: 120px">
                                                                               </a>
                                                                           </div>

                                                                       </div>
                                                                   </div>
                                                               </div>
                                                           </div>
                                                       </div>
                                                   </c:otherwise>
                                               </c:choose>
                                           </div>
                                               <%--<div class="tab-pane fade" id="stuProject">--%>
                                               <%----%>
                                               <%--</div>--%>
                                       </div>

                                       <small>${msgUpdateTeacher}</small>
                                   </div>
                               </div>

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

                   </div>
               </c:otherwise>
           </c:choose>
        </div>
    </div>
</div>
</body>
</html>