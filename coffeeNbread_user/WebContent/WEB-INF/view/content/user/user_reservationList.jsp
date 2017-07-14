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



<h2>결제성공</h2>

<form
	action="${initParam.rootPath }/user/findReservationDetailsController.do">
	<input type="hidden" name="storeId"> <input type="hidden"
		name="productId">
	<sec:csrfInput />
</form>
결제할 목록
<table class="w3-table-all">
	<thead>
		<tr class="w3-blue">
			<th>제품카테고리</th>
			<th>제품사진</th>
			<th>제품명</th>
			<th>가격</th>
			<th>개수</th>

		</tr>
	</thead>
	<tbody>

		###################################################### 조회된 item 출력
		######################################################
		<c:forEach items="${requestScope.shoppingBasketProductList }"
			var="list">

			<tr id="sbp_id">
				<td>${list.product.productCategory}</td>
				<td>${list.product.productPicture}</td>
				<td>${list.product.productName}</td>
				<td>${list.product.productPrice}</td>
				<td>${list.productCount}</td>

			</tr>
		</c:forEach>
	</tbody>
</table>

<br>
<br>

<p>

	총금액<input type="text" value="${requestScope.totalPrice }">
</p>


즐겨찾는 카드번호



<form
	action="${initParam.rootPath }/user/addBookMarkCardNumController.do">
	<sec:csrfInput />
	<input type="tel" size="20" name="cardNum"
		value="${requestScope.cardNum }" /> 
	<button type="submit" class="btn-custom">
		<i class="glyphicon glyphicon-plus"></i>카드번호 등록
	</button>
</form>


<form
	action="${initParam.rootPath }/user/findBookMarkCardNumController.do">
	<sec:csrfInput />
	<button type="submit" class="btn-custom">
		<i class="glyphicon glyphicon-search"></i>등록한 카드번호 조회
	</button>
</form>

<select name="bookMarkCardNum" id="card_id">

	<c:forEach var="list" items="${requestScope.bookMarkCardNumList }">
		<!--속성넘어온값의 변수명이 firstCategory라서.이건 list이므로 forEach  -->
		<option value="${list.cardNum }">${list.cardNum }</option>
	</c:forEach>
</select>






<form
	action="${initParam.rootPath }/user/addPaymentDetailsController.do">
	<sec:csrfInput />
	<c:forEach items="${requestScope.shoppingBasketProductList }"
		var="list">
		<input type="hidden" name="productIdList"
			value="${list.product.productId }" />
		<input type="hidden" name="reservationOrderCount"
			value="${list.productCount }" />
		<input type="hidden" name="storeId" value="${list[0].storeId}">
	</c:forEach>
	<button type="submit" class="btn-custom">
		<i class="glyphicon glyphicon-credit-card"></i>결제
	</button>
</form>
--%>