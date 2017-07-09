<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>내 제품 정보</h2>
	<table>
			<tr>
				<th>제품 ID</th>
				<td>${requestScope.product.productId }</td>
			</tr>
			<tr>
				<th>제품 이름</th>
				<td>${requestScope.product.productName}></td>
			</tr>
			<tr>
				<th>제품 가격</th>
				<td>${requestScope.product.productPrice}</td>
			</tr>
			<tr>
				<th>제품 상세</th>
				<td>${requestScope.product.productDetail}</td>
			</tr>
			<tr>
				<th>판매 여부</th>
				<td>${requestScope.product.sellingOption}</td>
			</tr>

			<tr>
				<th>금일 제품 개수</th>
				<td>${requestScope.product.todayProductCount}</td>
			</tr>
			<tr>
				<th>추천 제품 개수</th>
				<td>${requestScope.product.recommendProductCount}</td>
			</tr>
			<tr>
				<th>옵션</th>
				<td>${requestScope.product.productCategory}</td>
			</tr>
			<tr>
				<th>제품 사진</th>
				<td><img src="/coffeeNbread_user/up_image/${requestScope.fileName}" width="300px"></td>
			</tr>
		</table>
