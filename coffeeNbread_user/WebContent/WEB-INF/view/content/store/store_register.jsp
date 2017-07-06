<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${initParam.rootPath }/addStoreController.do" method="post">
		<sec:csrfInput/><%-- csrf 토큰 --%>
		<table>
			<tr>
				<th>매장 분류</th>
				<td><input type="text" name="storeCategoryList"><input type="button" value="추가하기"></td>
			</tr>
			
			<tr>
				<th>옵션 카테고리</th>
				<td><input type="text" name="optionCategoryList"><input type="button" value="추가하기"></td>
			</tr>
			
			<tr>
				<th>매장 ID</th>

				<td><input type="text" name="storeId" value="${param.id}"></td>
			</tr>
			<tr>
				<th>매장 이름</th>
				<td><input type="text" name="storeName" value="${param.name}"></td>
			</tr>
			<tr>
				<th>매장 번호</th>
				<td><input type="text" name="storePhone" value="${param.maker}"></td>
			</tr>
			<tr>
				<th>매장 메일</th>
				<td><input type="text" name="storeEmail"></td>
			</tr>
			<tr>
				<th>open 시간</th>
				<td><input type="date" name="storeOpen"></td>
			</tr>
			<tr>
				<th>close 시간</th>
				<td><input type="date" name="storeClose"></td>
			</tr>
			<tr>
				<th>매장 사진</th>
				<td><input type="file" name="storePictureList" multiple></td>
			</tr>
			<tr>
				<th>매장 위치</th>
				<td><input type="text" name="storeAddress"></td>
			</tr>
			<tr>
				<th>매장 소개</th>
				<td><textarea name="storeIntro" rows="5" cols="50"></textarea></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="등록"></td>
			</tr>
		</table>
	</form>
</body>
</html>