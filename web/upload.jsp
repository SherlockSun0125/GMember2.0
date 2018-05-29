<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=utf-8" %>

<html>
<head>

</head>
<body>
    <form action="${pageContext.request.contextPath}/testServlet?method=uploadImg" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <button>上传图片</button>
    </form>

    <div>
        <c:choose>
            <c:when test="${fname eq null}">
                未上传图片
            </c:when>
            <c:otherwise>
                <img src="${pageContext.request.contextPath}/upload/company/img/${fname}" style=" width: 166px;">
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>