<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


	<table class="table" style="width:300px">
			<tr class="form-group"><!-- colspan="6" -->
				<th style="text-align:center;vertical-align:top"  >MY PRODUCT</th>
			</tr>
			<tr class="form-group">
				<th>제품 ID</th>
				<td><div class="col-xs-10">${requestScope.product.productId }</div></td>
			</tr>
			<tr class="form-group">
				<th>제품 이름</th>
				<td><div class="col-xs-10">${requestScope.product.productName}></div></td>
			</tr>
			<tr class="form-group">
				<th>제품 가격</th>
				<td><div class="col-xs-10">${requestScope.product.productPrice}</div></td>
			</tr>
			<tr class="form-group">
				<th>제품 상세</th>
				<td><div class="col-xs-10">${requestScope.product.productDetail}</div></td>
			</tr>
			<tr class="form-group">
				<th>판매 여부</th>
				<td><div class="col-xs-10">${requestScope.product.sellingOption}</div></td>
			</tr>

			<tr class="form-group">
				<th>금일 제품 개수</th>
				<td><div class="col-xs-10">${requestScope.product.todayProductCount}</div></td>
			</tr>
			<tr class="form-group">
				<th>추천 제품 개수</th>
				<td><div class="col-xs-10">${requestScope.product.recommendProductCount}</div></td>
			</tr>
			<tr class="form-group">
				<th>옵션</th>
				<td><div class="col-xs-10">${requestScope.product.productCategory}</div></td>
			</tr>
			<tr class="form-group">
				<th>제품 사진</th>
				<td><img src="/coffeeNbread_user/up_image/${requestScope.fileName}" width="300px"></td>
			</tr>
		</table>
