<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript"
	src="/coffeeNbread_user/resource/jquery/jquery-3.2.1.js"></script>

<script type="text/javascript">
/*   $(document).ready(function(){
	
	  $(".submitBtn").on("click",function() {
			
		  var btn = this;
   		  var productId= $(btn).prev().val();
	        alert(productId);	
   		    $.ajax({
				
				 url : "/coffeeNbread_user/user/removeShoppingBasketProductController.do",
				data : {"productId" :productId} 
				
				
			}); 
		});
  }); */

</script>
	<script type="text/javascript">
			$(document).ready(function(){
				/* $(".count").on("change",function(){
					
					document.getElementById( "productCount" ).setAttribute( 'value', this.value);
				}); */
				$(".updateBtn").on("click", function(){
					
					var uForm = document.getElementById("updateForm");
					uForm.productCount.value = $(this).parent().prev().children(".count").val();
					uForm.productId.value = $(this).prev().text();
					uForm.submit();
				});
			});//ready 
		</script>

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
<body>

	<h2>장바구니 목록</h2>




	<table class="table table-hover">
		<thead>

			<tr class="w3-blue">
				<td>제품카테고리</td>
				<td>제품사진</td>
				<td>제품명</td>
				<td>가격</td>
				<td>개수</td>
				<td>수정</td>
				<td>삭제</td>

			</tr>
		</thead>
		<tbody id="tbody">

			<%-- ######################################################
																조회된 item 출력 
					###################################################### --%>
			<c:forEach items="${requestScope.shoppingBasketProductList }"
				var="list">

				<tr id="sbp_id">
					<td>${list.product.productCategory}</td>
					<td>${list.product.productPicture}</td>
					<td>${list.product.productName}</td>
					<td>${list.product.productPrice}</td>
					<td><input type="number" min="0" value="${list.productCount}" class="count"></td>
					<td>
						  <span style="display: none;">${list.product.productId }</span>
						  <button type="button" class="updateBtn">
						  	<i class="glyphicon glyphicon-trash"></i>수정
						  </button>
					</td>
					
					<td>
						<form
							action="${initParam.rootPath }/user/removeShoppingBasketProductController.do"
							method="post">
							<sec:csrfInput />
							<%-- csrf 토큰 --%>
						<input  type="hidden" name="productId" value="${list.product.productId }"/>
						<button type="submit" class="submitBtn">
						<i class="glyphicon glyphicon-trash"></i>삭제
						
						</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<hr>
<hr>
<br>
  <br>
  <br>
  <br>
  
	
    <button type="submit" class="productBtn">총금액</button>
		   <input type="text" value="${requestScope.totalPrice }">
    
    <hr>
    <br>
       
           
           
          
     <button type="button" id="btn">결제페이지로 이동</button>
     <form action="${initParam.rootPath }/user/modifyShoppingBasketProductCount.do" method="post" id="updateForm">
		<sec:csrfInput />
		<%-- csrf 토큰 --%>
	  <input  type="hidden" name="productCount" />
	  <input  type="hidden" name="productId" />
	</form>
</body>


