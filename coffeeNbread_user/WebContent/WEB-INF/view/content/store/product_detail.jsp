<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
form{
 display:inline;
}
td {
	padding: 5px; /* //td 간 간격 */
}
@font-face {
	font-family: 'title';
	src: local(※), url(${initParam.rootPath }/resource/font/a시나리오.woff) format('woff');
}

h2 {
	font-family: 'title';
	font-size: 60px
}
</style>

<br><br><br><br><br>
<div class="col-sm-2"></div>
<div class="col-sm-5">
<h2><img src="${initParam.rootPath }/resource/css/information1.png">&nbsp;제품 정보</h2>
<br><br><br><br><br>
		<img id="productImage" src="/coffeeNbread_user/up_image/${requestScope.product.productPicture}" width="300px">

</div>
<div class="col-sm-4">
<br><br><br><br><br>
<table class="table">
	<tr >
		<th style="font-weight:bold">제품 이름</th>
		<td>${requestScope.product.productName }</td>
	</tr>	
	<tr >
		<th style="font-weight:bold">제품 종류</th>
		<td>${requestScope.product.productCategory }</td>
	</tr>
	<tr>
		<th style="font-weight:bold">제품 가격</th>
		<td>${requestScope.product.productPrice }</td>
	</tr>
			
	<tr >
		<th style="font-weight:bold">판매 여부</th>
		<td>${requestScope.product.sellingOption }</td>
	</tr>	
		<tr>
		<th style="font-weight:bold">금일 제품 개수</th>
		<td>${requestScope.product.todayProductCount }</td>
	</tr>	
	<tr >
		<th style="font-weight:bold">추천 제품 개수</th>
		<td>${requestScope.product.recommendProductCount }</td>
	</tr>
	<tr >
		<th style="font-weight:bold">제품 상세</th>
		<td>${requestScope.product.productDetail }</td>
	</tr>			
</table>
<div style="float:right">
<form method=get action="${initParam.rootPath }/findOptionCategoryController.do">
	<sec:csrfInput/><%-- csrf 토큰 --%>
	<input type="hidden" name="productId" value="${requestScope.product.productId}"/>
	<button type="submit" class="btn btn-info"><i class="glyphicon glyphicon-pencil"></i>&nbsp;수정하기</button>

</form>
<form  action="${initParam.rootPath }/findProductListManagerController.do" method="post" >
	<sec:csrfInput/><%-- csrf 토큰 --%>
	 <button type="submit" class="btn" style="background-color:#ffb6c1"><i class="glyphicon glyphicon-list"></i>&nbsp;제품 목록</button>
	
</form></div>
</div>
<div class="col-sm-1"></div>