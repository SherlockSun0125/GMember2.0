<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>我的课设</title>
    <!--三个重要的CSS文件-->
    <link rel="stylesheet" href="../static/core_62c0700cc15bd051f36fa48b7a5c1a26.css">
    <link rel="stylesheet" href="../static/pt_newpages_course_learn.css">
    <link rel="stylesheet" href="../../../bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="../../../bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../../bootstrap/jquery-2.2.4.min.js"></script>
    <style>
        th{
            font-weight: bold;
        }
    </style>
</head>
<body style="background-color: #EEEEEE">
<!--头部-->
<div class="f-pf g-headwrap" id="j-fixed-head">
    <div class="g-hd f-bg1 m-yktNav " id="j-topnav">
        <div class="g-flow">
            <div class="f-pr f-cb">
                <div style="position: absolute;top:2px;bottom:2px;">
                    <a class="f-fl" hidefocus="true" href="../stuHome.jsp" target="_self" data-index="logo">
                        <img class="f-fl img" src="../static/hitwh_logo_white.png" title="学生主页" width="540px"
                             style="margin-top: 2px;margin-bottom: 1px">
                    </a>
                </div>
                <div class="m-navrgt f-fr f-cb f-pr j-navright">
                    <div class="userinfo f-fr f-cb f-pr">
                        <div class="login f-cb">
                            <div class="u-mystudy f-pr f-cb f-fr">
                                <a class="mystudy nitem f-f0" data-index="用户退出" target="_blank"
                                   href="../exit.jsp" hidefocus="true">退出</a>
                            </div>

                            <div class="name j-userinfo" id="auto-id-1523840858750">
                                <div class="f-pr">
                                    <div class="face">
                                        <img class="j-nav-myimg"
                                             src="../static/head1.jpg"
                                             width="30px" height="30px" alt="头像">
                                    </div>
                                </div>
                            </div>
                            <a class="username self f-thide" target="_self" data-index="点击用户名"
                               href="../setting.jsp">
                                <span class=" f-fs1 f-f0">PaulSuen</span>
                            </a>
                            <i class="line" style="padding-top: 2%"></i>
                            <a data-index="消息" class="mes f-pr f-cb j-nav-mescenter"
                               href="../messageT.jsp" title="查看更多消息" target="_blank">
                                <span>消息</span>
                                <em class="num hidddenClass j-nav-msgnum">0</em>
                            </a>
                            <div class="u-mystudy f-pr f-cb f-fr">
                                <a class="mystudy nitem f-f0" id="j-nav-my-class" data-index="我的学习" target="_self"
                                   href="../forum.jsp" hidefocus="true">讨论区</a>
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
                    <a class="u-learnProgress-tab j-tabitem f-f0 f-fc3 f-cb"  data-type="30"
                       href="${pageContext.request.contextPath}/studentServlet?method=findLogsOfStudentLevel&stuid=${Student.stu_id}&stulevelid=${Student.stu_level_id}">
                        <div class="ic f-fl"></div>
                        <span class="f-fl">学习日志</span>
                    </a>
                    <ul class="tab u-tabul">
                        <li class="u-greentab j-tabitem f-f0 first" data-name="我的课程" data-type="1">
                            <a class="f-thide f-fc3" href="myCourse.jsp">我的课程</a>
                        </li>
                        <li class="u-greentab j-tabitem f-f0 last u-curtab" data-name="我的项目" data-type="7"
                            data-id="2001487096" id="auto-id-1523950289741">
                            <a class="f-thide f-fc3"  href="myProject.jsp">我的项目</a>
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
                           href="newLog.jsp"><img src="../static/addProject.png" style="width: 120px"></a>
                    </div>

                    <!--项目展示-->
                    <div class="u-forumlistwrap j-alltopiclist">
                        <div class="m-flwrap">
                            <div style="height: 36px;font-weight: bold">
                                <h4 class="f-fl f-fc3" style="font-weight: bold">项目列表</h4>
                            </div>
                            <div style="margin-top: 10px;padding-left: 0;">
                                <table class="table table-hover">
                                    <%--<thead>--%>
                                        <%--<th class="col-lg-1">项目名称</th>--%>
                                        <%--<th>所属课程</th>--%>
                                        <%--<th>负责教师</th>--%>
                                        <%--<th>项目语言</th>--%>
                                        <%--<th>项目时间</th>--%>
                                        <%--<th>项目地点</th>--%>
                                        <%--<th>主要成员</th>--%>
                                        <%--<th>项目简介</th>--%>
                                        <%--<th>项目更新</th>--%>
                                    <%--</thead>--%>
                                    <tbody>
                                        <tr style="border-bottom: 1px solid #EEEEEE;border-top: none">
                                            <td width="100%"><a>基于web的工程领军人与卓越工程师管理平台</a></td>
                                        </tr>
                                        <tr style="border-bottom: 1px solid #EEEEEE">
                                            <td width="100%"><a>基于web的工程领军人与卓越工程师管理平台</a>&nbsp;(已结束)</td>
                                        </tr>
                                    </tbody>
                                </table>
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
