<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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








<h2>장바구니 목록</h2>


<form
	action="${initParam.rootPath }/user/ViewShoppingBasketProductController.do"
	method="post">
	<sec:csrfInput />
	<%-- csrf 토큰 --%>

	<table class="w3-table-all">
		<thead>
			<tr class="w3-blue">
				<th>제품카테고리</th>
				<th>제품사진</th>
				<th>제품명</th>
				<th>가격</th>
				<th>개수</th>
				<th>제품당 총가격</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>

			<%-- ######################################################
																조회된 item 출력 
					###################################################### --%>
			<c:forEach items="${requestScope.list }" var="list">

				<tr>
					<td>${list.product.productCategory}</td>
					<td>${list.product.productPicture}</td>
					<td>${list.product.productName}</td>
					<td>${list.product.productPrice}</td>
					<td>${list.shoppingBaketProduct.productCount}</td>
					<td>${list.productPrice}</td>
					<td><button type="submit" class="btn btn-custom">
							<i class="glyphicon glyphicon-trash"></i>삭제
						</button></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<input type="submit" value="삭제" />
</form>










