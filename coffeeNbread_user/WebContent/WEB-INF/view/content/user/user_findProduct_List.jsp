<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

<div class="col-sm-11">
<br><br>
<h2><img src="http://127.0.0.1:8088/coffeeNbread_user/resource/css/list.png">&nbsp;제품 목록</h2>
		
<div style="float:right">
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
			 <button type="submit" class="btn" style="background-color:#FFCC33">
				<i class="glyphicon glyphicon-search"></i>&nbsp;검색
			</button>
		</form>
		<form
	action="${initParam.rootPath }/user/ViewShoppingBasketProductController.do"
	method="post">
	<sec:csrfInput />
	<%-- csrf 토큰 --%>
	<input type="hidden" value="${sessionScope.storeId }"
		name="storeId" /> 
	<button type="submit" class="btn" style="background-color:#ffb6c1">
		<i class="glyphicon glyphicon-list"></i>&nbsp;장바구니 목록
	</button>
   </form></div></div>





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
					<td align="center">
					<img src="${initParam.rootPath }/up_image/${product.productPictureList[0].productPicture }"
						alt="" width="150" height="150" title="${product.productDetail }"/></td>
				</tr>
				<tr>
					<td align="center">${product.productName }&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td align="center"><fmt:formatNumber value="${product.productPrice }" pattern="#,###" /></td>
				</tr>
				<tr>
					<td align="center">

					<input type="number" name="productCount" class="productCount" min="0"  value="0" />
					</td>
				</tr>

				<tr>
					<td align="center">
						<input  type="hidden" name="productId" value="${product.productId }"/>
						<input  type="hidden" name="storeId" value="${product.storeId }"/>
						<button type="submit" class="btn" style="background-color:#ff4500">
							<i class="glyphicon glyphicon-shopping-cart"></i>&nbsp;장바구니
						</button>

					</td>
				</tr>
			</table>



		</div>
</form>

	</c:forEach>

  

</div>
<div class="col-sm-1"></div>



<p>