<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>










<!--맨처음 제품 수령시간 적고  -->
<!--그다음 카드 적고  -등록-->
<!--결제하기 누르면 결제내역에 등록  -->

<style type="text/css">
table, td {
	border: 1px solid black;
}

table {
	width: 500px;
	border-collapse: collapse;
}

td {
	padding: 5px; /*td 간 간격 */
}
</style>



<h2>결제 페이지</h2>

<form
	action="${initParam.rootPath }/user/findAllProductPriceController.do">
	<input type="hidden" name="storeId"> <input type="hidden"
		name="productId">
	<sec:csrfInput />
</form>
결제할 목록
<table class="w3-table-all">
	<thead>
		<tr class="w3-blue">
			<th>제품명</th>
			<th>가격</th>
			<th>개수</th>

		</tr>
	</thead>
	<tbody>

		<%-- ######################################################
																조회된 item 출력 
					###################################################### --%>
		<c:forEach items="${sessionScope.posPayment }"
			var="list">

			<tr id="sbp_id">
				<td>${list.productName}</td>
				<td>${list.productPrice}</td>
				<td>${list.productTradeCount}</td>

			</tr>
		</c:forEach>
	</tbody>
</table>

<br>
<br>

<p>

	총금액<input type="text" value="${sessionScope.posPaymentTotal }">
</p>



<form action="${initParam.rootPath }/store/PaymentExecuteController.do">
	<sec:csrfInput />
	<select name="select" class="form-control">
		<c:forEach items="${requestScope.storePaymentOptionList }" var="list">
			<option value="${list.paymentId }" ${param.select eq "${list.paymentId }" ? "selected" :""}>${list.paymentOptionList.paymentMethod }</option>
		</c:forEach>
	</select>
	<br>
	<br>
	<input type="submit" value="결제하기">
</form>
