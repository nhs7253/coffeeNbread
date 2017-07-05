<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

제목 : ${requestScope.productPicture.productId }<br>
설명 : ${requestScope.productPicture.storeId }<br>
<c:forEach items="${requestScope.imageName }" var="fileName">
	<img src="/coffeeNbread_user/up_image/${fileName }" width="300px">
</c:forEach>

</body>
</html>