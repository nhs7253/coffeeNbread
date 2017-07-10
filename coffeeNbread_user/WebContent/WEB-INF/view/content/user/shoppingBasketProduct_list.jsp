<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>









     <h2>장바구니 목록 </h2>


	<form action="${initParam.rootPath }/user/ViewShoppingBasketProductController.do" method="post">
		<sec:csrfInput/><%-- csrf 토큰 --%>
	
		<table class="w3-table-all">
			<thead>
				<tr class="w3-blue"> 
					<th>아이디</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>이메일</th>
					<th>조회수</th>
					<th>여는 시간</th>
					<th>닫는 시간</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
	
				<%-- ######################################################
																조회된 item 출력 
					###################################################### --%>
				<c:forEach items="${requestScope.list }" var="list">
	
					<tr>
						<td>${list.store.storeId}</td>
						<td><a href="${initParam.rootPath }/common/viewStoreController.do?storeId=${list.store.storeId}">${list.store.storeName}</a></td>
						<td>${list.store.storePhone}</td>
						<td>${list.store.storeAddress}</td>
						<td>${list.store.storeEmail}</td>
						<td>${list.store.storeHits}</td>
						<td>${list.store.storeOpenFormat}</td>
						<td>${list.store.storeCloseFormat}</td>
						<td><input type="checkbox" name="storeIdList" value="${list.store.storeId}"></td>
					</tr>
				</c:forEach>
	
			</tbody>
		</table>
		<input type="submit" value="삭제" />
	</form>










