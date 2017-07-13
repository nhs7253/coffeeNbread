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

<body> 


<table  class="table" style="width:300px">
			<tr><!-- colspan="6" -->
				<th style="text-align:center;vertical-align:top"  >MY STORE</th>
			</tr>
			<tr class="form-group">
				<th>매장 분류</th>
				<td ><div class="col-xs-5">
				<c:forEach items="${sessionScope.store.optionCategoryList}" var="optionCategoryList">
							${optionCategoryList}
				</c:forEach></div>
				</td>
			</tr>			
			<tr class="form-group">
				<th>매장 ID</th>

				<td><div class="col-xs-5">${sessionScope.store.storeId}</div></td>
				
			</tr>
			<tr class="form-group">
				<th>매장 이름</th>
				<td><div class="col-xs-5">${sessionScope.store.storeName}</div></td>
			</tr>
			<tr class="form-group">
				<th>매장 번호</th>
				<td><div class="col-xs-5">${sessionScope.store.storePhone}</div></td>
			</tr>
			<tr class="form-group">
				<th>매장 메일</th>
				<td><div class="col-xs-5">${sessionScope.store.storeEmail }</div></td>
			</tr>
			<tr class="form-group">
				<th>open 시간</th>
				<td><div class="col-xs-5"><fmt:formatDate value="${sessionScope.store.storeOpen }" type = "time" pattern="hh:mm"/></div></td>
			</tr>
			<tr class="form-group">
				<th>close 시간</th>
				<td><div class="col-xs-5"><fmt:formatDate value="${sessionScope.store.storeClose }" type = "time" pattern="hh:mm"/></div></td>
			</tr>
			<tr class="form-group">
				<th>매장 사진</th>
				<td><div class="col-xs-5">
				<c:forEach items="${sessionScope.store.storePictureList}" var="fileName">
					<img src="/coffeeNbread_user/up_image/${fileName}" width="300px">
				</c:forEach></div>
			</tr>
			<tr class="form-group">
				<th>매장 위치</th>
				<td><div class="col-xs-5"></div></td>
			</tr>
			<tr class="form-group">
				<th>매장 소개</th>
				<td><div class="col-xs-5">${sessionScope.store.storeIntro }</div></td>
			</tr>

			<tr class="form-group">
				<td colspan="2"><button type="submit" class="btn"><i class="glyphicon glyphicon-ok"></i>확인</button></td>
			</tr>
		</table>
		
		
			<form action="${initParam.rootPath}/store/store_modify.do"  >
				
				<button type="submit" class="btn"><i class="glyphicon glyphicon-pencil"></i>수정</button>
				
			</form>
			<form action="${initParam.rootPath }/removeStoreController.do">
			
				<button type="submit" class="btn"><i class="glyphicon glyphicon-trash"></i>삭제</button>
		
			</form>
			
</body>
</html>