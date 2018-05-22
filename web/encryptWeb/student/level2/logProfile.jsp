<%@page contentType="text/html; charset=utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>发帖</title>

    <!--样式-->
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/encryptWeb/student/static/c999847cabf4398b84d69b7ef2f1ef78.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/encryptWeb/student/static/core_62c0700cc15bd051f36fa48b7a5c1a26.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/encryptWeb/student/static/pt_newpages_course_learn.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/encryptWeb/student/static/wangEditor.min.js"></script>
    <style type="text/css">
        .u-learnProgress-tab .ic_2 {
            width: 16px;
            height: 16px;
            margin: 12px 0 0 10px;
            background-image: url("../static/icon9.png");
            background-position: -48px 0px;
        }
        .file {
            position: relative;
            display: inline-block;
            background: #D0EEFF;
            border: 1px solid #99D3F5;
            border-radius: 4px;
            padding: 8px 24px;
            overflow: hidden;
            color: #1E88C7;
            text-decoration: none;
            text-indent: 0;
            line-height: 20px;
        }
        .file input {
            position: absolute;
            font-size: 100px;
            right: 0;
            top: 0;
            opacity: 0;
        }
        .file:hover {
            background: #AADFFD;
            border-color: #78C3F3;
            color: #004974;
            text-decoration: none;
        }
    </style>
</head>

<body style="background-color: #EEEEEE;">
<div id="g-container">
    <!--头部-->
    <div class="f-pf g-headwrap" id="j-fixed-head">
        <div class="g-hd f-bg1 m-yktNav " id="j-topnav">
            <div class="g-flow">
                <div class="f-pr f-cb">
                    <div style="position: absolute;top:2px;bottom:2px;">
                        <a class="f-fl" hidefocus="true" target="_self" data-index="logo" href="${pageContext.request.contextPath}/encryptWeb/student/stuHome.jsp">
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

                                <div class="name j-userinfo" id="auto-id-1523840858750">
                                    <div class="f-pr">
                                        <div class="face">
                                            <img class="j-nav-myimg"
                                                 src="${pageContext.request.contextPath}/encryptWeb/student/static/head1.jpg"
                                                 width="30px" height="30px" alt="头像">
                                        </div>
                                    </div>
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
                                    <a class="mystudy nitem f-f0" id="j-nav-my-class" data-index="讨论区" target="_self"
                                       href="${pageContext.request.contextPath}/encryptWeb/student/forum.jsp" hidefocus="true">讨论区</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div id="g-body">
        <!--右大半段的背景-->
        <div class="m-cbg"></div>

        <div class="g-wrap f-cb">
            <!--左侧边栏-->
            <div class="g-sd1">
                <div class="m-learnleft">
                    <div id="j-courseTabList">
                        <a class="u-learnProgress-tab j-tabitem f-f0 f-fc3 f-cb u-curtab" data-type="30"
                           href="${pageContext.request.contextPath}/studentServlet?method=findLogsOfStudentLevel&stuid=${Student.stu_id}&stulevelid=${Student.stu_level_id}">
                            <div class="ic f-fl"></div>
                            <span class="f-fl ">学习日志</span>
                        </a>
                        <ul class="tab u-tabul">
                            <li class="u-greentab j-tabitem f-f0 first" data-name="我的课程" data-type="1">
                                <a class="f-thide f-fc3" href="myCourse.jsp">我的课程</a>
                            </li>
                            <li class="u-greentab j-tabitem f-f0 last" data-name="我的项目" data-type="7"
                                data-id="2001487096" id="auto-id-1523950289741">
                                <a class="f-thide f-fc3" href="myProject.jsp">我的项目</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <!--右部-->
            <div class="g-mn1">
                <div class="g-mn1c m-learnbox" id="courseLearn-inner-box">
                    <div class="m-forumtopic f-cb">
                        <form action="${pageContext.request.contextPath}/studentServlet?method=updateLog&logid=${stuLog.stu_log_id}" method="post">
                            <div class="form-group">
                                <label style="font-size: 1.25em" for="logtitle">日志主题</label>
                                <input class="form-control" style="width: 40%" id="logtitle" name="logtitle" value="${stuLog.stu_log_title}">
                            </div>
                            <div class="form-group">
                                <label style="font-size: 1.25em" for="editor">日志内容</label>
                                <div id="editor">
                                    <p>${stuLog.stu_log_content}</p>
                                </div>
                                <textarea id="logcontent" name="logcontent" style="width:100%; height:200px;display: none"></textarea>
                            </div>
                            <input type="submit" class="btn btn-success" value="更新日志" id="uppdateLog">
                        </form>
                    </div>
                    <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
                    <script type="text/javascript">
                        var E = window.wangEditor;
                        var editor = new E('#editor');
                        // var editor = new E( document.getElementById('editor') )

                        editor.customConfig.uploadImgShowBase64 = true;  // 使用 base64 保存图片
                        editor.customConfig.showLinkImg = false;    // 隐藏“网络图片”tab
                        editor.customConfig.menus = [
                            'head',  // 标题
                            'bold',  // 粗体
                            'fontSize',  // 字号
                            'fontName',  // 字体
                            'italic',  // 斜体
                            'underline',  // 下划线
                            'strikeThrough',  // 删除线
                            'foreColor',  // 文字颜色
                            'backColor',  // 背景颜色
                            'link',  // 插入链接
                            'list',  // 列表
                            'justify',  // 对齐方式
                            'quote',  // 引用
                            'emoticon',  // 表情
                            'image',  // 插入图片
                            'table',  // 表格
                            'code',  // 插入代码
                            'undo',  // 撤销
                            'redo'  // 重复
                        ]

                        var logcontent=$("#logcontent");
                        editor.customConfig.onchange=function (html) {
                            logcontent.val(html);
                        }

                        editor.create();
                        logcontent.val(editor.$txt.html);
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

</body>
</html>