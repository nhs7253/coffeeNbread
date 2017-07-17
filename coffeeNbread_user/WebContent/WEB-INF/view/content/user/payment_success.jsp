<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>









<!--맨처음 제품 수령시간 적고  -->
<!--그다음 카드 적고  -등록-->
<!--결제하기 누르면 결제내역에 등록  -->

<style type="text/css">
table, td,th{
	border: 4px solid black;
	
}

table{
	width:700px;
	border-collapse: collapse;
}
td{
	padding: 5px; /* //td 간 간격 */
	
}
select{
	width:150px;
	height: 35px;
	padding: 5px;
}
</style>



<h2>결제성공</h2>


<h2>${requestScope.userName }님의예약 현황</h2>



<br>


<table class="w3-table-all" width="90%" border="1" align="center" >
	<thead>
		<tr class="w3-blue">
			<th>예약번호</th>
			<th>예약매장</th>
			<th>예약시간</th>
			<th>예약한 제품</th>
			<th>예약개수</th>
			<th>제품수령희망시간</th>
			<th>예약확인유무</th>

		</tr>
	</thead>
	<tbody>

		<%-- ######################################################
															조회된 item 출력 
				###################################################### --%>
		<c:forEach items="${requestScope.reservationList }" var="list">

			<tr>
				<td>${list.reservationNo}</td>
				<td>${list.store.storeName }</td>
				<td><fmt:formatDate value="${list.reservationTime}"
						pattern="yyyy년 MM월 dd일 hh시mm분" /></td>
				<td>${list.product.productName}</td>
				<td>${list.reservationCount}</td>
				<td><fmt:formatDate value="${list.productHopeTime}"
						pattern="yyyy년 MM월 dd일 hh시mm분" /></td>
				<td><fmt:formatDate value="${list.reservationConfirm}"
						pattern="yyyy년 MM월 dd일 hh시mm분" /></td>
			</tr>
		</c:forEach>

	</tbody>
</table>

  


