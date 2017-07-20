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


<div class="col-sm-2"></div>
<div class="col-sm-8">
<h2>결제 페이지</h2>
<br><br>
<form
	action="${initParam.rootPath }/user/findAllProductPriceController.do">
	<input type="hidden" name="storeId"> <input type="hidden"
		name="productId">
	<sec:csrfInput />
</form>

<table class="table">
	<thead>
		<tr>
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
<br>
<br>
<br>
<br>

<div style="float:right">
	총금액 : <input type="text" value="${sessionScope.posPaymentTotal }" disabled style="border-color:white;background-color:transparent;">




<form action="${initParam.rootPath }/store/PaymentExecuteController.do">
	<sec:csrfInput />
	<select name="select" class="form-control">
		<c:forEach items="${requestScope.storePaymentOptionList }" var="list">
			<option value="${list.paymentId }" ${param.select eq "${list.paymentId }" ? "selected" :""}>${list.paymentOptionList.paymentMethod }</option>
		</c:forEach>
	</select>
	<br>
	
	<div style="float:right">
	<button type="submit" class="btn">
					<i class="glyphicon glyphicon-card"></i>&nbsp;결제하기 
			</button>
</div>
</form></div></div><div class="col-sm-2"></div>

