<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

</head>
<body>
	

	<h2>유저 추천 가게 목록</h2>

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
				</tr>
			</thead>
			<tbody>
	
				<%-- ######################################################
																조회된 item 출력 
					###################################################### --%>
				<c:forEach items="${requestScope.list }" var="preference">
	
					<tr>
						<td>${preference.store.storeId}</td>
						<td>${preference.store.storeName}</td>
						<td>${preference.store.storePhone}</td>
						<td>${preference.store.storeAddress}</td>
						<td>${preference.store.storeEmail}</td>
						<td>${preference.store.storeHits}</td>
						<td>${preference.store.storeOpenFormat}</td>
						<td>${preference.store.storeCloseFormat}</td>
					</tr>
				</c:forEach>
	
			</tbody>
		</table>


