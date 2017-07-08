<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
				<c:forEach items="${sessionScope.store.storeCategoryList}" var="storeCategoryList">
							${storeCategoryList}
				</c:forEach>
				</td>
			</tr>			
			<tr>
				<th>매장 ID</th>

				<td>${sessionScope.store.storeId}</td>
			</tr>
			<tr>
				<th>매장 이름</th>
				<td>${sessionScope.store.storeName}</td>
			</tr>
			<tr>
				<th>매장 번호</th>
				<td>${sessionScope.store.storePhone}</td>
			</tr>
			<tr>
				<th>매장 메일</th>
				<td>${sessionScope.store.storeEmail }</td>
			</tr>
			<tr>
				<th>open 시간</th>
				<td><fmt:formatDate value="${sessionScope.store.storeOpen }" type = "time" pattern="hh:mm"/></td>
			</tr>
			<tr>
				<th>close 시간</th>
				<td><fmt:formatDate value="${sessionScope.store.storeClose }" type = "time" pattern="hh:mm"/></td>
			</tr>
			<tr>
				<th>매장 사진</th>
				<td>
				<c:forEach items="${sessionScope.store.storePictureList}" var="fileName">
					<img src="/coffeeNbread_user/up_image/${fileName}" width="300px">
				</c:forEach>
			</tr>
			<tr>
				<th>매장 위치</th>
				<td></td>
			</tr>
			<tr>
				<th>매장 소개</th>
				<td>${sessionScope.store.storeIntro }</td>
			</tr>

			<tr>
				<td colspan="2"><input type="button" value="확인"></td>
			</tr>
		</table>
			<form action="${initParam.rootPath}/store/store_modify.do"  >
				<input type="submit" value="수정">
			</form>
			<form action="${initParam.rootPath }/removeStoreController.do" method="post" >
				<input type="submit" value="삭제">
			</form>
</body>
</html>