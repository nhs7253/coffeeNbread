<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h2>제품 상세</h2>

<form  action="${initParam.rootPath }/findProductListController.do" method="post" >
	<sec:csrfInput/><%-- csrf 토큰 --%>
	 <button type="submit" class="btn-custom"><i class="glyphicon glyphicon-list"></i>제품 목록</button>
	
</form>

<table class="table">
	<tr class="form-group">
		<th>제품 이름</th>
		<td>${requestScope.product.productName }</td>
	</tr>	
	<tr class="form-group">
		<th>제품 종류</th>
		<td>${requestScope.product.productCategory }</td>
	</tr>
	<tr class="form-group">
		<th>제품 가격</th>
		<td>${requestScope.product.productPrice }</td>
	</tr>
	<tr class="form-group">
		<th>제품 상세</th>
		<td>${requestScope.product.productDetail }</td>
	</tr>			
	<tr class="form-group">
		<th>판매 여부</th>
		<td>${requestScope.product.sellingOption }</td>
	</tr>	
		<tr class="form-group">
		<th>금일 제품 개수</th>
		<td>${requestScope.product.todayProductCount }</td>
	</tr>	
	<tr class="form-group">
		<th>추천 제품 개수</th>
		<td>${requestScope.product.recommendProductCount }</td>
	</tr>
	<tr class="form-group">
		<th>제품 사진</th>
		<td><img id="productImage" src="/coffeeNbread_user/up_image/${requestScope.product.productPicture}" width="300px"></td>
	</tr>		
</table>

<form method=get action="${initParam.rootPath }/findOptionCategoryController.do">
	<sec:csrfInput/><%-- csrf 토큰 --%>
	<input type="hidden" name="productId" value="${requestScope.product.productId}"/>
	<button type="submit" class="btn-custom"><i class="glyphicon glyphicon-pencil"></i>수정하기</button>

</form>