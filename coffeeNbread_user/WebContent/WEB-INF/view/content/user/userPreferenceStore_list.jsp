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
@font-face {
	font-family: 'title';
	src: local(※), url(http://127.0.0.1:8088/coffeeNbread_user/resource/font/a시나리오.woff) format('woff');
}

h2 {
	font-family: 'title';
	font-size: 60px
}
</style>

</head>
<body>

<div class="col-sm-1"></div>
<div class="col-sm-10">
<br><br>
	<center><h2><img src="http://127.0.0.1:8088/coffeeNbread_user/resource/css/house.png">&nbsp;자주 방문하는 매장</h2></center>
	<br><br><br>
		<table class="table table-hover">
			<thead>
				<tr > 
					<th style="font-weight:bold; background-color:lightyellow">이름</th>
					<th style="font-weight:bold; background-color:lightyellow">전화번호</th>
					<th style="font-weight:bold; background-color:lightyellow">주소</th>
					<th style="font-weight:bold; background-color:lightyellow">이메일</th>
					<th style="font-weight:bold; background-color:lightyellow">조회수</th>
					<th style="font-weight:bold; background-color:lightyellow">여는 시간</th>
					<th style="font-weight:bold; background-color:lightyellow">닫는 시간</th>
				</tr>
			</thead>
			<tbody>
	
				<%-- ######################################################
																조회된 item 출력 
					###################################################### --%>
				<c:forEach items="${requestScope.list }" var="list">
					<tr>
						<td style="text-align:center;"><a href="${initParam.rootPath }/common/viewStoreController.do?storeId=${list.store.storeId}">${list.store.storeName}</a></td>
						<td style="text-align:center;">${list.store.storePhone}</td>
						<td>${list.store.storeAddress}</td>
						<td style="text-align:center;">${list.store.storeEmail}</td>
						<td style="text-align:center;">${list.store.storeHits}</td>
						<td style="text-align:center;">${list.store.storeOpenFormat}</td>
						<td style="text-align:center;">${list.store.storeCloseFormat}</td>
					</tr>
				</c:forEach>
	
			</tbody>
		</table>
		</div>
<div class="col-sm-1"></div>

