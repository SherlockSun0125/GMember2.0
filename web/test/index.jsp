<%--
  Created by IntelliJ IDEA.
  User: chong
  Date: 2018/5/15
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>页码测试</title>
    <link rel="stylesheet" type="text/css" href="pager.css">
</head>
<body>
    <div>
        <ul class="nav nav-list" style="background-color: green">
           <li>这是一个列表这是一个列表</li>
           <li>这是一个列表这是一个列表</li>
           <li>这是一个列表这是一个列表</li>
           <li>这是一个列表这是一个列表</li>
           <li>这是一个列表这是一个列表</li>
           <li>这是一个列表这是一个列表</li>
           <li>这是一个列表这是一个列表</li>
           <li>这是一个列表这是一个列表</li>
           <li>这是一个列表这是一个列表</li>
           <li>这是一个列表这是一个列表</li>
           <li>这是一个列表这是一个列表</li>
        </ul>
    </div>
    <div style="float:left; width: 100%; text-align: center;">
        <%@include file="pager.jsp"%>
    </div>
</body>
</html>
