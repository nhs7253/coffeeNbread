<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 내 매장 정보
<table>
			<tr>
				<th>매장 분류</th>
				<td>
				<c:forEach items="${requestScope.sclist}" var="storeCategory">
					${storeCategory.storeCategory}
				</c:forEach>
				</td>
			</tr>
			
			<tr>
				<th>옵션 카테고리</th>
				<td>
				<c:forEach items="${requestScope.oplist}" var="optionCategory">
					${optionCategory.optionCategory}
				</c:forEach>
				</td>
			</tr>
			
			<tr>
				<th>매장 ID</th>

				<td>${requestScope.store.storeId}</td>
			</tr>
			<tr>
				<th>매장 이름</th>
				<td>${requestScope.store.storeName}</td>
			</tr>
			<tr>
				<th>매장 번호</th>
				<td>${requestScope.store.storePhone}</td>
			</tr>
			<tr>
				<th>매장 메일</th>
				<td>${requestScope.store.storeEmail }</td>
			</tr>
			<tr>
				<th>open 시간</th>
				<td>${requestScope.store.storeOpen }</td>
			</tr>
			<tr>
				<th>close 시간</th>
				<td>${requestScope.store.storeClose }</td>
			</tr>
			<tr>
				<th>매장 사진</th>
				<td>
				<c:forEach items="${requestScope.store.storePictureList}" var="fileName">
					<img src="/coffeeNbread_user/up_image/${fileName}" width="300px">
				</c:forEach>
			</tr>
			<tr>
				<th>매장 위치</th>
				<td></td>
			</tr>
			<tr>
				<th>매장 소개</th>
				<td>${requestScope.store.storeIntro }</td>
			</tr>

			<tr>
				<td colspan="2"><input type="button" value="확인"></td>
			</tr>
		</table>
</body>
</html>