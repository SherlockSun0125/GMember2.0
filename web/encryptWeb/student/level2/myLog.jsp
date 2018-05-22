<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的日志</title>
    <!--三个重要的CSS文件-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/encryptWeb/student/static/core_62c0700cc15bd051f36fa48b7a5c1a26.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/encryptWeb/student/static/pt_newpages_course_learn.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pager/pager.css">
</head>
<body>
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
                                <a class="mystudy nitem f-f0" data-index="用户退出" target="_blank"
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
<div id="g-body">
    <!--为右侧定义背景-->
    <div class="m-cbg"></div>

    <div class="g-wrap f-cb">
        <!--左侧侧边栏-->
        <div class="g-sd1">
            <div class="m-learnleft">
                <div id="j-courseTabList">
                    <a class="u-learnProgress-tab j-tabitem f-f0 f-fc3 f-cb u-curtab"  data-type="30">
                        <div class="ic f-fl"></div>
                        <span class="f-fl">学习日志</span>
                    </a>
                    <ul class="tab u-tabul">
                        <li class="u-greentab j-tabitem f-f0 first last" data-name="我的课程" data-type="1">
                            <a class="f-thide f-fc3" href="myProject.jsp">我的项目</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <!--右侧主体-->
        <div class="g-mn1">
            <div class="g-mn1c m-learnbox" id="courseLearn-inner-box">

                <div class="m-forumindex">
                    <!--发帖按钮-->
                    <div class="f-cb">
                        <a class="j-newTopicBtn f-fl" style="margin-bottom:40px;margin-top: 12px;"
                           href="${pageContext.request.contextPath}/encryptWeb/student/level2/newLog.jsp"><img src="${pageContext.request.contextPath}/encryptWeb/student/static/addLog.png" style="width: 120px"></a>
                    </div>

                    <!--帖子展示-->
                    <div class="u-forumlistwrap j-alltopiclist">
                        <c:choose>
                            <c:when test="${pb.totalRecords eq 0}">
                                <div class="ttitle">
                                    <h4 class="f-fl f-fc3">你还没有写日志</h4>
                                    <div class="f-fl u-coursecate j-lessonuit"></div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="m-flwrap">
                                    <div class="ttitle">
                                        <h4 class="f-fl f-fc3">全部日志</h4>
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
                                                                <a></a><a class="f-fc3 f-f0 lb10 j-link" href="${pageContext.request.contextPath}/studentServlet?method=findLogById&logid=${stulogs.stu_log_id}" target="_self">${stulogs.stu_log_title}</a>
                                                            </div>
                                                            <span>
                                                            <span class="j-txt">
                                                                <span class="lb10 f-fc9">于${stulogs.stu_log_time}发表</span>
                                                            </span>
                                                        </span>
                                                            <p class="f-fc9 f-pa watch">
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
                                                            <p class="f-fc9 f-pa reply">
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
                                                <small>${msgDeleteLog}</small>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
