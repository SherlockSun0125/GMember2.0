<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>就业推荐阶段</title>
    <!--三个重要的CSS文件-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/encryptWeb/student/static/core_62c0700cc15bd051f36fa48b7a5c1a26.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/encryptWeb/student/static/pt_newpages_course_learn.css">
    <style type="text/css">
        .u-learnProgress-tab .ic_2 {
            width: 16px;
            height: 16px;
            margin: 12px 0 0 10px;
            background-image: url("/encryptWeb/student/static/icon9.png");
            background-position: -48px 0px;
        }
    </style>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #EEEEEE">
<!--头部-->
<div class="f-pf g-headwrap" id="j-fixed-head">
    <div class="g-hd f-bg1 m-yktNav " id="j-topnav">
        <div class="g-flow">
            <div class="f-pr f-cb">
                <div style="position: absolute;top:2px;bottom:2px;">
                    <a class="f-fl" hidefocus="true" href="${pageContext.request.contextPath}/encryptWeb/student/stuHome.jsp" target="_self" data-index="logo">
                        <img class="f-fl img" src="${pageContext.request.contextPath}/encryptWeb/student/static/hitwh_logo_white.png" title="学生主页" width="540px"
                             style="margin-top: 2px;margin-bottom: 1px">
                    </a>
                </div>
                <div class="m-navrgt f-fr f-cb f-pr j-navright">
                    <div class="userinfo f-fr f-cb f-pr">
                        <div class="login f-cb">
                            <div class="u-mystudy f-pr f-cb f-fr">
                                <a class="mystudy nitem f-f0" data-index="用户退出" target="_self"
                                   href="${pageContext.request.contextPath}/encryptWeb/student/exit.jsp" hidefocus="true">退出</a>
                            </div>
                            <a class="username self f-thide" target="_self" data-index="点击用户名"
                               href="${pageContext.request.contextPath}/encryptWeb/student/setting.jsp">
                                <span class=" f-fs1 f-f0">${Student.stu_name}</span>
                            </a>
                            <i class="line" style="padding-top: 2%"></i>
                            <a data-index="消息" class="mes f-pr f-cb j-nav-mescenter"
                               href="${pageContext.request.contextPath}/encryptWeb/student/messageT.jsp" title="查看更多消息" target="_blank">
                                <span>消息</span>
                                <em class="num hidddenClass j-nav-msgnum">0</em>
                            </a>
                            <div class="u-mystudy f-pr f-cb f-fr">
                                <a class="mystudy nitem f-f0" id="j-nav-my-class" data-index="我的学习" target="_self"
                                   href="${pageContext.request.contextPath}/encryptWeb/student/forum.jsp" hidefocus="true">讨论区</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--网页主体-->
<div id="g-body" >
    <!--为右侧定义背景-->
    <div class="m-cbg"></div>

    <div class="g-wrap f-cb">
        <!--左侧侧边栏-->
        <div class="g-sd1">
            <div class="m-learnleft">
                <div id="j-courseTabList">
                    <a class="u-learnProgress-tab j-tabitem f-f0 f-fc3 f-cb  u-curtab" data-type="30"
                        href="${pageContext.request.contextPath}/studentServlet?method=findResumeByStuId&stuid=${Student.stu_id}">
                        <div class="ic_2 f-fl"></div>
                        <span class="f-fl">我的简历</span>
                    </a>
                    <%--<ul class="tab u-tabul">--%>
                        <%--<li class="u-greentab j-tabitem f-f0 first" data-name="导师推荐" data-type="1">--%>
                            <%--<a class="f-thide f-fc3" href="${pageContext.request.contextPath}/encryptWeb/student/level4/empRecommend.jsp">导师推荐</a>--%>
                        <%--</li>--%>
                        <%--<li class="u-greentab j-tabitem f-f0 last" data-name="我的投递" data-type="7"--%>
                            <%--data-id="2001487096" id="auto-id-1523950289741">--%>
                            <%--<a class="f-thide f-fc3"  href="${pageContext.request.contextPath}/encryptWeb/student/level4/myDelivery.jsp">我的投递</a>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                </div>
            </div>
        </div>

        <!--右侧主体-->
        <div class="g-mn1">
            <div class="g-mn1c m-learnbox" id="courseLearn-inner-box">

                <div class="m-forumindex">
                    <!--发帖按钮-->
                    <div  style="margin-bottom:40px;margin-top: 12px" >
                        <c:choose>
                            <c:when test="${resume eq null}">
                                <form class="form-group" method="post" enctype="multipart/form-data"
                                      action="${pageContext.request.contextPath}/studentServlet?method=addResume&stuid=${Student.stu_id}">
                                    <input type="file" name="resume"><br/>
                                    <button style="margin-right: 20px;border: none" type="submit">
                                        <img src="${pageContext.request.contextPath}/encryptWeb/student/static/uploadResume.png" style="width: 120px">
                                    </button>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <form class="form-group" method="post" enctype="multipart/form-data"
                                      action="${pageContext.request.contextPath}/studentServlet?method=updateResume&resumeid=${resume.resume_id}">
                                    <input type="file" name="resume"><br/>
                                    <button style="margin-right: 20px;border: none" type="submit">
                                        <img src="${pageContext.request.contextPath}/encryptWeb/student/static/reUploadResume.png" style="width: 120px">
                                    </button>
                                    <a  href="${pageContext.request.contextPath}/upload/${resume.resume_path}" target="pdfContainer" onclick="showPdf(true)" style="width: 120px;padding-right: 20px">
                                        <img src="${pageContext.request.contextPath}/encryptWeb/student/static/lookResume.png" style="width: 120px">
                                    </a>
                                </form>


                            </c:otherwise>
                        </c:choose>
                        <small>${msgAddResume}</small>
                    </div>

                    <!--帖子展示-->
                    <div class="u-forumlistwrap j-alltopiclist">
                        <div class="m-flwrap">
                            <%--<div class="ttitle">--%>
                                <%--<h4 class="f-fl f-fc3">导师反馈</h4>--%>
                                <%--<div class="f-fl u-coursecate j-lessonuit"></div>--%>
                            <%--</div>--%>
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
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
