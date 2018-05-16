<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chong
  Date: 2018/5/16
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>测试</title>
</head>
<body>
    <c:forEach items="${departmentPageBean.beanList}" var="department">
        <c:choose>
            <c:when test="${department.dep_id eq tea.dep_id}">
                <option value="${department.dep_id}" selected="selected">${department.dep_name}</option>
            </c:when>
            <c:otherwise>
                <option value="${department.dep_id}"> ${department.dep_name} </option>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</body>
</html>
