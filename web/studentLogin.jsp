<%@page contentType="text/html; charset=utf-8" %>
<html>
<head>
    <title>学生用户登陆</title>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
    <!-- 引入Bootstrap -->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <style>
        .bottom {
            width: 100%;
            position: absolute;
            bottom: 0px;
        }

        .container {
            padding-top: 20px;
        }

        #footer-menu {
            background-color: #002a80;
            color: #C3C0B9;
            font-size: 12px;
            padding-bottom: 10px;
            padding-top: 10px;
            width: 100%;
        }

        #footer-menu ul {
            list-style-type: none;
        }

        #footer-menu li {
            float: left;
            margin-left: 10px;
        }

        #footer-menu a {
            color: #C3C0B9;
        }

        #footer-menu a:hover {
            color: #E84807;
        }

        .auth_bg img {
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            margin: auto;
            min-width: 50%;
            min-height: 50%;
        }

        .auth_login_left .auth_others a {
            float: left;
            height: 34px;
            background-color: rgba(255, 255, 255, .8);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#C8ffffff, endColorstr=#C8ffffff);
        }

        .auth_login_left .auth_others a .auth_icon_bg:hover {
            background-color: #ffffff;
        }

        .auth_login_left .auth_others a i {
            width: 34px;
            height: 34px;
            display: inline-block;
        }

        .auth_icon_user {
            background: url("/images/myimg/icons.png") 6px -73px no-repeat;
        }

        .auth_icon_pwd {
            background: url("images/myimg/icons.png") -19px -73px no-repeat;
        }

        .auth_login_left .auth_others h4 {
            font-size: 16px;
            color: #fff;
            padding-bottom: 5px;
            font-weight: 600;
        }

        .auth_login_left .auth_others ul, .auth_tab_links ul {
            list-style: none;
            margin: 0;
            padding: 0;
        }

        .auth_login_left .auth_others li {
            margin-top: 15px;
            height: 34px;
            line-height: 34px;
        }

        .auth_login_left .auth_others li a {
            text-decoration: none;
        }

        .auth_tab {
            width: 339px;
            margin-left: 125px;
            background-color: rgba(255, 255, 255, 0.1);
            position: fixed;
            top: 100px;
            right: 50px;
        }

        .auth_tab_links li {
            width: 50%;
            height: 35px;
            line-height: 35px;
            text-align: center;
            display: block;
            float: left;
            background-color: rgba(138, 138, 137, .8);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#998A8A89, endColorstr=#998A8A89);
            cursor: pointer;
        }

        .auth_tab_links li span {
            color: #ffffff;
        }

        .auth_tab_links li.selected {
            background-color: rgba(255, 255, 255, .9);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#E5ffffff, endColorstr=#E5ffffff);
        }

        .auth_tab_links li.selected span {
            color: #676a6c;
        }

        .auth_tab_content {
            padding: 25px 35px 22px 35px;
            background-color: rgba(255, 255, 255, .9);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#E5ffffff, endColorstr=#E5ffffff);
            min-height: 205px;
        }

        .auth_tab_content_item {
            position: relative;
        }

        .auth_tab_content_item p {
            position: relative;
            margin-top: 0;
            margin-bottom: 17px;
        }

        .auth_tab_content_item p label {
            font-size: 12px;
            margin-left: 5px;
        }

        .auth_icon {
            background-color: rgb(242, 242, 242);
            border: 1px solid #ccc;
            border-right: none;
            width: 32px;
            height: 32px;
            float: left;
        }

        .auth_input {
            border: 1px solid #ccc;
            padding: 8px 12px;
            font-size: 14px;
            width: 209px;
            margin: 0;
            color: #676a6c;
            height: 32px;
            width: 230px;
        }

        .auth_input:focus {
            outline: none;
        }

        .auth_login_btn {
            color: #fff;
            padding: 6px 12px;
            font-size: 14px;
            font-weight: 400;
            line-height: 1.42857143;
            text-align: center;
            white-space: nowrap;
            vertical-align: middle;
            border-radius: 3px;
            text-decoration: none;
            border: 1px solid transparent;
            /*width: 100%;*/
            width: 262px;
        }

        .primary {
            background-color: #1ab394;
            border-color: #1ab394;
        }

        .primary:hover {
            background-color: #18a689;
            border-color: #18a689;
        }

        .full_width {
            display: block;
        }

        .auth_login_forgetp {
            text-decoration: none;
            /*
                color: #676a6c;
            */
        }

        .auth_login_forgetp:hover {
            color: #333;
        }

        .auth_login_forgetp small {
            font-size: 12px;
        }

        .auth_error {
            position: absolute;
            color: #ED5565;
            font-size: 12px;
            top: 33px;
            left: 45px;
        }

        .clearfloat {
            clear: both;
        }

        .auth_login_footer span {
            color: #f3f3f3;
            font-size: 12px;
        }


    </style>
    <script>
        function checkForm() {
            if(!$("#stunum").val()){
                alert("学号不能为空!");
                return false;
            }
            if(!$("#stupwd").val()){
                alert("密码不能为空！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div style="position:absolute;bottom:0px;width: 100%;height: 100%">
    <div class="span5 logo" style="width: 100%;background-color: #002a80;">
        <a class="logo-img" href="${pageContext.request.contextPath}/home.jsp" title="responsive template"
           style="margin-left: 10px;margin-top: 3px;margin-bottom: 3px;"><img src="${pageContext.request.contextPath}/images/myimg/hitwh_logo.png" alt="哈工大威海校徽"/></a>
    </div>
    <div>
        <img src="${pageContext.request.contextPath}/images/myimg/hit_silde3.jpg" width="100%" height="85%">
    </div>
</div>

<div class="auth_tab">
    <div class="auth_tab_links">
        <ul>
            <li id="accountLogin" style="width:100%;" class="selected" tabid="01"><span>学生用户登录</span></li>
        </ul>
    </div>
    <div class="clearfloat"></div>
    <div class="auth_tab_content">
        <div tabid="01" class="auth_tab_content_item">
            <form class="fm-v clearfix amp-login-form" role="form" method="post"
                  action="${pageContext.request.contextPath}/studentServlet" onsubmit="return checkForm()">
                <input type="hidden" name="method" value="studentLogin"/>
                <p>
                    <i class="auth_icon auth_icon_user"></i>
                    <input id="stunum" name="stunum" placeholder="账号" class="auth_input" type="text"/>
                </p>

                <p>
                    <i class="auth_icon auth_icon_pwd"></i>
                    <input id="stupwd" name="stupwd" placeholder="密码" class="auth_input" type="password"
                           value="" autocomplete="off"/>
                </p>

                <p id="cpatchaDiv"></p>
                <p>
                    <br/>
                    <small>${msgStudentLogin}</small>
                <%--<label onmousedown=""> <input type="checkbox" name="rememberMe" id="rememberMe"/> 一周内免登录</label>--%>
                </p>

                <p>
                    <input type="submit" value="登录" class="auth_login_btn primary full_width"/>
                </p>
                <div style="text-align: right">
                    <a id="getBackPasswordMainPage" href="${pageContext.request.contextPath}/studentServlet?method=toApply" class="auth_login_forgetp">
                        <small>尚未加入？点击申请</small>
                    </a>
                    <br/>
                    <br/>
                </div>
                <div>
                    <small>1、帐号为学号。</small>
                </div>
                <div>
                    <small>2、初始密码默认身份证号后6位。</small>
                </div>
                <div>
                    <small>3、如忘记密码请尽快联系管理员。</small>
                </div>
                <div><br></div>
                <div>
                    <small>温馨提示：个人应妥善保管个人帐号密码，不能随意告诉他人，由帐号密码管理不善造成的不良后果由个人负责。</small>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="bottom">
    <!--footer menu-->
    <section id="footer-menu">
        <div class="container">
            <p align="center">
                山东省威海市环翠区文化西路2号&nbsp;&nbsp;&nbsp;&nbsp;邮政编码：264209&nbsp;&nbsp;&nbsp;&nbsp;哈尔滨工业大学（威海）版权所有 |
                <a class="my_a_link" href="${pageContext.request.contextPath}/adminLogin.jsp" style="color: #1a1a1a">登陆</a>
            </p>
        </div>
    </section>
</div>
</body>
</html>

