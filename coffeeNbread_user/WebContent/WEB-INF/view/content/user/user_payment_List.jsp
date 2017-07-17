<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!--맨처음 제품 수령시간 적고  -->
<!--그다음 카드 적고  -등록-->
<!--결제하기 누르면 결제내역에 등록  -->

<style type="text/css">


table {
	width: 500px;
	border-collapse: collapse;
}

td {
	padding: 5px; /*td 간 간격 */
}
</style>






	
	<h2>${requestScope.userName }님의 결제 현황</h2>

  

<div class="col-sm-1"></div>
<div class="col-sm-10">
<br>

	
	<table class="table table-hover">
		<thead>
			<tr >
				<th>결제번호</th>
				<th>매장이름 </th>
				<th>제품이름</th>
				<th>판매방식</th>
				<th>결제방식</th>
				<th>결제개수</th>
				<th>제품가격</th>
				<th>제품거래시간</th>
				
				
			</tr>
		</thead>
		<tbody>

			<%-- ######################################################
															조회된 item 출력 
				###################################################### --%>
			<c:forEach items="${requestScope.list }" var="list">

				<tr>
					<td>${list.paymentNo}</td>
				 	<td>${list.store.storeName}</td>		
					<td>${list.product.productName}</td>
					<td>${list.sellMethod}</td> 
					<td>${list.paymentOption}</td>
					<td>${list.reservationOrderCount}</td>
					<td>${list.product.productPrice}</td>
					<td>${list.tradeDate }</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	




	<p>
		<%--######################################################
															페이징 처리
				###################################################### --%>
		<!-- 첫페이지로 이동 -->
		<a
			href="${initParam.rootPath }/user/findPaymentDetailsController.do?page=1">첫페이지</a>


		<!--
			이전 페이지 그룹 처리.
			만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
		 -->
		<c:choose>
			<c:when test="${requestScope.pageBean.previousPageGroup}">
				<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
				<a
					href="${initParam.rootPath }/user/findPaymentDetailsController.do?page=${requestScope.pageBean.beginPage-1}">◀</a>
			</c:when>
			<c:otherwise>
				◀
			</c:otherwise>
		</c:choose>





		<!-- 
		현재 page가 속한 page 그룹내의 페이지들 링크.
		현재 pageGroup의 시작page ~ 끝 page
	 -->
		<!-- 만약에 page가 현재페이지면 링크처리를 하지 않고 page가 현재페이지가 아니라면 링크처리. -->

		<c:forEach begin="${requestScope.pageBean.beginPage }"
			end="${requestScope.pageBean.endPage }" var="page">
			<c:choose>
				<c:when test="${page != requestScope.pageBean.page}">
					<!-- 현재페이지가 아니라면 -->
					<a
						href="${initParam.rootPath }/user/findPaymentDetailsController.do?page=${page}">${page }&nbsp;&nbsp;</a>
				</c:when>
				<c:otherwise>
				[${page}]&nbsp;&nbsp;
			</c:otherwise>
			</c:choose>

		</c:forEach>



		<!-- 
		다음페이지 그룹으로 이동
		만약에 다음페이지 그룹이 있으면 링크 처리 없으면 화살표만 나오도록 처리
	 -->
		<c:choose>
			<c:when test="${requestScope.pageBean.nextPageGroup}">
				<a
					href="${initParam.rootPath }/user/findPaymentDetailsController.do?page=${requestScope.pageBean.endPage+1}">▶</a>
			</c:when>
			<c:otherwise>
			▶
		</c:otherwise>
		</c:choose>




		<!-- 마지막 페이지로 이동 -->
		<a
			href="${initParam.rootPath }/user/findPaymentDetailsController.do?page=${requestScope.pageBean.totalPage}">마지막
			페이지</a>
</div>
<div class="col-sm-1"></div>
