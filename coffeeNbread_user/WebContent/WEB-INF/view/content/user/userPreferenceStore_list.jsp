<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<style type="text/css">


table {
   width: 700px;
   border-collapse: collapse;
}
th{
text-align:center;
}
td {
   padding: 5px; /* //td 간 간격 */
}
</style>

</head>
<body>
	
<br>
	<h2>자주 방문하는 매장</h2>
	<br><br><br>

	
		<div class="col-sm-12">
		<table class="table table-hover">
			<thead>
				<tr > 
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
				<c:forEach items="${requestScope.list }" var="list">
					<tr>
						<td style="text-align:center;">${list.store.storeId}</td>
						<td style="text-align:center;"><a href="${initParam.rootPath }/common/viewStoreController.do?storeId=${list.store.storeId}">${list.store.storeName}</a></td>
						<td style="text-align:center;">${list.store.storePhone}</td>
						<td >${list.store.storeAddress}</td>
						<td style="text-align:center;">${list.store.storeEmail}</td>
						<td style="text-align:center;">${list.store.storeHits}</td>
						<td style="text-align:center;">${list.store.storeOpenFormat}</td>
						<td style="text-align:center;">${list.store.storeCloseFormat}</td>
					</tr>
				</c:forEach>
	
			</tbody>
		</table>
		</div>


