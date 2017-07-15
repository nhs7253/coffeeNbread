<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css">
table, td {
	border: 1px solid black;
}

table {
	/* width: 500px; */
	border-collapse: collapse;
}

td {
	padding: 5px; /*td 간 간격 */
}
</style>
<link rel="stylesheet" href="/coffeeNbread_user/css/search_style.css">

<script type="text/javascript">
	$(document).ready(function() {
		$(".curruntProductCount").on("change", function() {

		});
		/*
		$(".btn-custom").on("click",function() {
			
		
			 var btn = this;
      		 var productId= $(btn).prev().prev().val();
      		 
      		 var storeId=$(btn).prev().val();
      		 var productCount=$(btn).parent().parent().prev().first().first().val();
      		 alert(productId+' '+storeId);
      		   
	 		$.ajax({
				
			    alert("ajax");
				 url : "/coffeeNbread_user/user/addShoppingBasketProductController.do",
				data : {"productId" :productId,"storeId":storeId ,"productCount":productCount},  
				beforeSend : function() {
					if (productCount.val()==0) {
					alert("제품을 선택해주세요!!");
					return false;
					}
					} 
				
			});
		});
		*/
	});
</script>
<h2>제품목록조회(예약)</h2>

<div class="container">
	<div id="quick-access">
		<form
			action="${initParam.rootPath }/user/userFindProductListController.do"
			method="post" class="form-inline quick-search-form" role="form">
			<sec:csrfInput />
			<%-- csrf 토큰 --%>
			<div class="form-group">
				<select name="select" class="form-control">
					<option value="productName"
						${param.select eq "productName" ? "selected" :""}>제품 이름</option>
					<option value="productCategory"
						${param.select eq "productCategory" ? "selected" :""}>제품
						종류</option>
				</select> <input type="hidden" name="storeId" value="${param.storeId}" /> <input
					type="text" name="keyword" class="form-control" />
			</div>
			<button type="submit" class="btn btn-custom">
				<i class="glyphicon glyphicon-search"></i>검색
			</button>
		</form>
	</div>
</div>

<form
	action="${initParam.rootPath }/user/ViewShoppingBasketProductController.do"
	method="post">
	<sec:csrfInput />
	<%-- csrf 토큰 --%>
	<input type="hidden" value="${sessionScope.storeId }"
		name="storeId" /> 
	<button type="submit" class="btn-custom">
		<i class="glyphicon glyphicon-search"></i>장바구니 목록 조회
	</button>
   </form>


<p>

	<%-- csrf 토큰 --%>



	<c:forEach items="${requestScope.list }" var="product">
	<form
	action="${initParam.rootPath }/user/addShoppingBasketProductController.do"
	method="post" class="form-inline quick-search-form" role="form">
	<sec:csrfInput />
		<div style="width: 25%; height: 320px; float: left;">
			<table>
				<tr>
					<td align="center"><img
						src="${initParam.rootPath }/up_image/${product.productPictureList[0].productPicture }"
						alt="" width="150" height="150" /></td>
				</tr>
				<tr>
					<td align="center">${product.productName }&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td align="center">${product.productPrice }&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td align="center">
					<input type="number" name="productCount" class="productCount" value="0" />
					</td>
				</tr>

				<tr>
					<td align="center">
						<input  type="hidden" name="productId" value="${product.productId }"/>
						<input  type="hidden" name="storeId" value="${product.storeId }"/>
						<button type="submit" class="btn-custom">
							<i class="glyphicon glyphicon-shopping-cart"></i>장바구니
							
						</button>

					</td>
				</tr>
			</table>



		</div>
</form>
	</c:forEach>

  

<p>