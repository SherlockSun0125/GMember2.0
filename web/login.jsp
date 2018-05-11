<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>login</title>
    <script>
        function doit(){
            alert("${pageContext.request.contextPath}");
        }
    </script>
</head>
<body>

<%--<p>${message}</p>--%>
<%--${pageContext.request.contextPath}/adminServlet"--%>
<form onclick="doit()" action="${pageContext.request.contextPath}/testServlet" method="post">
    学号：<input type="text" name="num"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="登录" >
    <%--<a href="${pageContext.request.contextPath}/toRegisterServlet">注册</a>--%>
</form>
</body>
</html>
