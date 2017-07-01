<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Image 업로드</h2>
<form action="/coffeeNbread_user/uploadImage2.do" method="post" enctype="multipart/form-data"> <!-- method, enctype 값은 고정 -->
	<sec:csrfInput/><%--csrf 토큰 생성 --%>
	제품이름 : <input type="text" name="productId"><br>
	이미지 : <input type="file" name="productPictureList" ><br>
	매장이름<br>
	<textarea name="storeId" rows="5" cols="50"></textarea><br>
	<input type="submit" value="등록">
</form>

</body>
</html>