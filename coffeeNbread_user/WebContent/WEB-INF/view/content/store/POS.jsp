<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css">
table {
	/* width: 500px; */
	border-collapse: collapse;
}

td {
	padding: 5px; /*td 간 간격 */
}
form {
	display: inline
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
<link rel="stylesheet" href="/coffeeNbread_user/resource/css/search_style.css">

	<script type="text/javascript">
			$(document).ready(function(){
				$(".curruntProductCount").on("change",function(){
			
				});
			});//ready 
		</script>

<div class="col-sm-11">
		<br><br>
<h2><img src="${initParam.rootPath }/resource/css/for-sale.png">&nbsp;판매 시스템</h2> 
	<div style="float:right;">
<form action="${initParam.rootPath }/store/findProductListToPOSController.do" method="post" class="form-inline quick-search-form" role="form">
   <sec:csrfInput/><%-- csrf 토큰 --%>
   
   <div class="form-group"  >
   <select name="select" class="form-control">
      <option value="productName" ${param.select eq "productName" ? "selected" :""}>제품 이름</option>
      <option value="productCategory" ${param.select eq "productCategory" ? "selected" :""}>제품 종류</option>
   </select>
   <input type="hidden" name="storeId" value="${param.storeId}"/>
   <input type="text" name="keyword" class="form-control"/>
   </div>
   
   <button type="submit" class="btn" style="background-color:#b6009f"><i class="glyphicon glyphicon-search"></i>&nbsp;검색</button>
    
</form>





<div style="float:right;">
<p>
<form action="${initParam.rootPath }/store/movePaymentPageController.do" method="post" class="form-inline quick-search-form" role="form">
	<sec:csrfInput/><%-- csrf 토큰 --%>

	
	<c:forEach items="${requestScope.list }" var="product">
		<div style="width: 25%; height: 280px; float: left;">
			<table>
				<tr>
					<td align="center">
						<img src="${initParam.rootPath }/up_image/${product.productPictureList[0].productPicture }" alt="" width="150" height="150"/>
					</td>
				</tr>
				<tr>
					<td align="center">
						${product.productName }&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td align="center">
						${product.productPrice }&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="number" name="productTradeCountList" class="curruntProductCount" min="0" value="0"/>
					</td>
				</tr>
				
			</table>
			<input type="hidden" name="productIdList" value="${product.productId }"/>
			<input type="hidden" name="productNameList" value="${product.productName }"/>
			<input type="hidden" name="productPriceList" value="${product.productPrice }"/>
		</div>
	</c:forEach>
	

	
	<button type="submit" class="btn glyphicon glyphicon-credit-card" style="background-color:#4682b4">&nbsp;결제</button>

</form></div>
	<!-- </div>
	<div class="col-sm-1"></div> -->


