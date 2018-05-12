<%@page contentType="text/html; charset=utf-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>管理员登录</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="paul">

    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="encryptWeb/admin/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="encryptWeb/admin/lib/font-awesome/css/font-awesome.css">
    <script src="encryptWeb/admin/lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/theme.css">
    <link rel="stylesheet" type="text/css" href="css/premium.css">
    <script src="encryptWeb/admin/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function () {
            $('.demo-cancel-click').click(function () {
                return false;
            });
        });
    </script>
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
    <script type="text/javascript">
        $(function () {
            var uls = $('.sidebar-nav > ul > *').clone();
            uls.addClass('visible-xs');
            $('#main-menu').append(uls.clone());
        });
    </script>

    <script type="text/javascript">
        function checkForm() {
            if(!$("#adminid").val()){
                alert("管理员账号不能为空");
                return false;
            }
            if(!$("#adminpwd").val()){
                alert("管理员密码不能为空！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body class=" theme-blue">
<div class="navbar navbar-default" role="navigation">
    <a class="" href="home.jsp">
            <span class="navbar-brand" style="padding-top: 2px;height: 45px">
                <img src="images/myimg/hitwh_logo.png" height="45px" style="padding-top: 0;padding-bottom: 0">
            </span>
    </a>
</div>
<div class="dialog" style="padding-top:60px;padding-bottom: 60px">
    <div class="panel panel-default">
        <p class="panel-heading no-collapse" align="center">登录</p>
        <div class="panel-body">
            <div>
                <label><small id="msg">${msgAdminLogin}</small></label>
            </div>
            <form action="${pageContext.request.contextPath}/adminServlet" onsubmit="return checkForm()">
            <%--<form action="<c:url value="/adminServlet"/> " method="post" onclick="return checkForm()">--%>
                <input type="hidden" name="method" value="adminLogin" />
                <div class="form-group">
                    <label for="adminid">账号</label>
                    <input type="text" class="form-control span12"  name="adminid" id="adminid">
                </div>
                <div class="form-group">
                    <label for="adminpwd">密码</label>
                    <input type="password" class="form-controlspan12 form-control"  name="adminpwd" id="adminpwd">
                </div>
                <div class="clearfix form-group">
                    <input type="submit" class="btn btn-primary pull-right" value="登录">
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
