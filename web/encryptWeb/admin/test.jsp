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
<table class="table">
    <thead>
    <tr>
        <th>id</th>
        <th>工号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>院系</th>
        <th>手机号</th>
        <th>邮箱</th>
        <th>密码</th>
        <th>谨慎操作</th>
    </tr>
    </thead>
    <tbody>
    <%--<c:set var="num" value="0"></c:set>--%>
    <c:forEach items="${pb.beanList}" var="tea">
        <tr>
            <td>${tea.tea_id}</td>
            <td>${tea.tea_num}</td>
            <td>${tea.tea_name}</td>
            <td>${tea.tea_sex}</td>
            <td>${tea.tea_age}</td>
            <td>
                <c:forEach items="${departmentPageBean.beanList}" var="dep">
                    <c:choose>
                        <c:when test="${tea.dep_id eq dep.dep_id}">
                            ${dep.dep_name}
                        </c:when>
                    </c:choose>
                </c:forEach>
            </td>
            <td>${tea.tea_phone}</td>
            <td>${tea.tea_mail}</td>
            <td>${tea.tea_pwd}</td>
            <td style="text-align: center">
                <a href="${pageContext.request.contextPath}/teacherServlet?method=findTeacherById&teacherid=${tea.tea_id}"><i
                        class="fa fa-pencil"></i></a>
                &nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/teacherServlet?method=deleteTeacher&teacherid=${tea.tea_id}&teachername=${tea.tea_name}"
                   role="button"><i class="fa fa-trash-o"></i></a>
                    <%--<a href="#myModal" role="button" data-toggle="modal" data-target="myModal"><i class="fa fa-trash-o"></i></a>--%>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
