<%@page contentType="text/html; charset=utf-8" %>
<html>
<head>
    <%--#E848077--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>导师主页</title>
    <!--样式-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/encryptWeb/employee/static/pt_newpages_cp_user_homepage.css">
    <style type="text/css">
        *[hidefocus] {
            outline: none;
        }

        body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, form, fieldset, input, textarea, p, blockquote, th, td {
            padding: 0;
            margin: 0;
        }

        fieldset, img, html, body, iframe {
            border: 0;
        }

        table {
            border-collapse: collapse;
            border-spacing: 0;
        }

        li {
            list-style: none;
        }

        caption, th {
            font-weight: normal;
            font-style: normal;
            text-align: left;
        }

        em {
            font-style: normal;
        }

        strong {
            font-weight: bold;
        }

        body, textarea, select, input {
            font-family: "Arial", "Hiragino Sans GB", \5fae\8f6f\96c5\9ed1, "Helvetica", "sans-serif";
            outline: none;
            border: 0;
        }

        textarea {
            resize: none;
        }

        input {
            vertical-align: baseline;
            margin: 0px;
        }

        body {
            background-color: #fff;
        }

        h1, h2, h3, h4, h5, h6 {
            font-weight: normal;
        }

        a, button {
            cursor: pointer;
        }

        html, body {
            width: 100%;
            height: 100%;
        }

        html {
            overflow: auto;
        }

        body {
            text-align: left;
            background: #fff;
        }

        textarea {
            overflow: auto;
        }

        .g-hd:after, .m-nav ul:after {
            clear: both;
            content: '.';
            display: block;
            height: 0;
            visibility: hidden;
        }

        .g-hd, .m-nav ul {
            zoom: 1;
        }

        body {
            min-width: 1205px;
            position: relative;
            height: auto !important;
            min-height: 100%;
        }

        @keyframes fadeInOut {
            0% {
                opacity: 0;
            }
            50% {
                opacity: 0;
            }
            100% {
                opacity: 1;
            }
        }

        .x-zoomImg img {
            vertical-align: middle;
            -webkit-transition: all, 1s, ease;
            -moz-transition: all, 1s, ease;
            transition: all, 1s, ease;
        }

        .x-zoomImg img:hover {
            -webkit-transform: scale(1.2);
            -moz-transform: scale(1.2);
            -ms-transform: scale(1.2);
            -o-transform: scale(1.2);
            transform: scale(1.2);
        }

        .x-hoverItem {
            -webkit-transition-property: opacity, -webkit-transform;
            -moz-transition-property: opacity, -webkit-transform;
            -ms-transition-property: opacity, -webkit-transform;
            -o-transition-property: opacity, -webkit-transform;
            transition-property: opacity, -webkit-transform;
            -webkit-transition-duration: 0.15s;
            -moz-transition-duration: 0.15s;
            -ms-transition-duration: 0.15s;
            -o-transition-duration: 0.15s;
            transition-duration: 0.15s;
            -webkit-transition-timing-function: ease-out;
            -moz-transition-timing-function: ease-out;
            -ms-transition-timing-function: ease-out;
            -o-transition-timing-function: ease-out;
            transition-timing-function: ease-out;
            -webkit-transform: scale(0.9);
            opacity: 0;
            pointer-events: none;
            display: none \9;
            visibility: hidden;
        }

        .x-hoverItem:hover {
            opacity: 1;
            -webkit-transform: scale(1);
            pointer-events: all;
            display: block \9;
            visibility: visible;
        }

        .f-f0 {
            font-family: "Arial", "Hiragino Sans GB", \5fae\8f6f\96c5\9ed1, "Helvetica", "sans-serif";
        }

        a {
            color: #859295;
            text-decoration: none;
        }

        a:hover {
            color: #e84807;
            text-decoration: none;
        }

        a.f-fcgreen:hover, a.f-fcg:hover {
            text-decoration: underline;
        }

        .f-fl {
            float: left;
        }

        .f-fr {
            float: right;
        }

        .f-cb:after, .f-cbli li:after {
            display: block;
            clear: both;
            visibility: hidden;
            height: 0;
            overflow: hidden;
            content: ".";
        }

        .f-cb, .f-cbli li {
            zoom: 1;
        }

        .f-thide {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .f-pf {
            position: fixed;
        }

        .f-lsi > * {
            letter-spacing: normal;
        }

        .f-richEditorText em {
            font-style: italic;
        }

        .f-richEditorText p {
            margin: 0;
            padding: 0;
        }

        .f-richEditorText div {
            margin: 10px 0;
            padding: 0;
        }

        .f-richEditorText blockquote {
            border-left: 3px solid #D0E5F2;
            font-style: normal;
            padding: 0 0 0 10px;
            vertical-align: baseline;
            margin: 0;
            font-size: 14px;
        }

        .f-richEditorText img {
            max-height: 520px;
            max-width: 520px;
        }

        .f-richEditorText a {
            text-decoration: underline;
        }

        .f-richEditorText ul li {
            list-style: disc inside;
        }

        .f-richEditorText ol li {
            list-style: decimal inside;
        }

        .f-richEditorText table {
            border-collapse: collapse;
            border-spacing: 0;
            border: 1px solid #E4E4E4;
        }

        .f-richEditorText table th, .f-richEditorText table td {
            border: 1px solid #E4E4E4;
            padding: 5px;
        }


         .f-unselectable * {
            -moz-user-select: none;
            -webkit-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        body {
            padding: 60px 0 396px 0;
        }


        a:hover {
            text-decoration: none;
        }

        body {
            background: #f4f4f4;
        }


        .ux-user-info {
            background: url(/encryptWeb/employee/static/user-bg.png) center center no-repeat;
            height: 220px;
        }

        .ux-user-info-center {
            width: 1205px;
            margin: 0 auto;
            padding-top: 29px;
        }

        .ux-user-info-top_img {
            width: 80px;
            height: 80px;
            margin: 0 auto;
            border: 4px solid rgba(250, 250, 250, 0.6);
            border-radius: 50%;
            overflow: hidden;
        }

        .ux-user-info-top_img img {
            width: 100%;
        }

        .ux-user-info-bottom {
            font-family: MicrosoftYaHei;
            color: #FFFFFF;
            text-align: center;
        }

        .ux-user-info-bottom_name {
            font-size: 20px;
            margin: 20px 0 10px;
        }

        .ux-user-info-bottom_description {
            font-size: 14px;
            line-height: 22px;
        }

        .ux-user-info_show {
            width: 1205px;
            margin: 90px auto 0;
            text-align: center;
        }

        .ux-user-info_show img {
            width: 100%;
        }
    </style>
    <link href="${pageContext.request.contextPath}/css/bootstrap-2.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet"/>
</head>

<body style="padding-bottom: 0px;">
<!--头部-->
<div class="f-pf g-headwrap" id="j-fixed-head">
    <div class="g-hd f-bg1 m-yktNav " id="j-topnav">
        <div class="g-flow">
            <div class="f-pr f-cb">
                <div style="position: absolute;top:2px;bottom:2px;">
                    <a class="f-fl" hidefocus="true" target="_self" data-index="logo" href="${pageContext.request.contextPath}/index.jsp">
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
                               href="${pageContext.request.contextPath}/employeeServlet?method=toUpdateSetting&empid=${Employee.emp_id}">
                                <span class=" f-fs1 f-f0">${Employee.emp_name}</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 中间部分-->
<div class="ux-user-info" style="margin:0;padding:0;">
    <div class="ux-user-info-center">
        <div class="ux-user-info-top">
            <div class="ux-user-info-top_img">
                <img src="${pageContext.request.contextPath}/encryptWeb/employee/static/head1.jpg">
            </div>
        </div>
        <div class="ux-user-info-bottom">
            <div class="ux-user-info-bottom_name">${Employee.emp_name}</div>
            <div class="ux-user-info-bottom_description f-pr">
                <span>${Employee.emp_note}</span>
            </div>
        </div>
    </div>
    <div class="ux-user-info_show">
        <div class="container">
            <!-- !important -->
            <div class="row highlights">
                <div class="span4">
                    <div class="hl-circle">
                        <a class="hl-icon2" href="${pageContext.request.contextPath}/employeeServlet?method=findAllStudentsByEmp&empid=${Employee.emp_id}&stulevelid=2">校企合作阶段管理</a>
                    </div>

                    <div class="highlights-content clearfix">
                        <br/>
                        <h5>校企合作阶段管理</h5>

                        <p>
                            <%--显示一些进度信息--%>
                        </p>

                        <a class="btn-small btn-hl" href="${pageContext.request.contextPath}/employeeServlet?method=findAllStudentsByEmp&empid=${Employee.emp_id}&stulevelid=2">
                            <span>进入管理</span>
                        </a><!-- button small end -->
                    </div>
                </div>
                <div class="span4">
                    <div class="hl-circle">
                        <a class="hl-icon3" href="${pageContext.request.contextPath}/employeeServlet?method=findAllStudentsByEmp&empid=${Employee.emp_id}&stulevelid=3">毕业设计阶段管理</a>
                    </div>

                    <div class="highlights-content clearfix">
                        <br/>
                        <h5>毕业设计阶段管理</h5>

                        <p>
                            <%--显示一些进度信息--%>
                        </p>

                        <a class="btn-small btn-hl" href="${pageContext.request.contextPath}/employeeServlet?method=findAllStudentsByEmp&empid=${Employee.emp_id}&stulevelid=3">
                            <span>进入管理</span>
                        </a><!-- button small end -->
                    </div>
                </div>
                <div class="span4 highlights">
                    <div class="hl-circle">
                        <a class="hl-icon4" href="${pageContext.request.contextPath}/employeeServlet?method=findAllStudentsByEmp&teaid=${Employee.emp_id}&stulevelid=4">就业推荐阶段管理</a>
                    </div>

                    <div class="highlights-content clearfix">
                        <br/>
                        <h5>就业推荐阶段管理</h5>

                        <p>
                            <%--显示一些进度信息--%>
                        </p>

                        <a class="btn-small btn-hl" href="${pageContext.request.contextPath}/employeeServlet?method=findAllStudentsResumesByEmp&empid=${Employee.emp_id}">
                            <span>进入管理</span>
                        </a><!-- button small end -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="g-ft" id="j-footer" style="position: absolute;bottom:0;">
    <div class="m-yktFoot" id="j-yktfoot" style="height: 50px;margin-top: 30px;margin-bottom: 0;padding-bottom: 0">
        <div class="g-flow ftwrapper f-cb">
            <p class="txt f-fs0" style="text-align: center;position: relative;top:50%;transform: translateY(60%)">
                山东省威海市环翠区文化西路2号&nbsp;&nbsp;&nbsp;&nbsp;邮政编码：264209&nbsp;&nbsp;&nbsp;&nbsp;哈尔滨工业大学（威海）版权所有
            </p>
        </div>
    </div>
</div>
</body>
</html>