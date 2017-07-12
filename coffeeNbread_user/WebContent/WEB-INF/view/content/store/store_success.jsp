<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
				<c:forEach items="${sessionScope.store.optionCategoryList}" var="optionCategoryList">
							${optionCategoryList}
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
				<button type="submit" >수정</button>
			</form>
			<form action="${initParam.rootPath }/removeStoreController.do">
			
				<button type="submit" >삭제</button>
		
			</form>
			
</body>
</html>