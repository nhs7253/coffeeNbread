<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript"
	src="/coffeeNbread_user/resource/jquery/jquery-3.2.1.js"></script>

<script type="text/javascript">
function button_event(){
	if (confirm("정말 삭제하시겠습니까??") == true){    
	    document.form.submit();
	}else{   //취소
	    return;
	}
	}



</script>
<script type="text/javascript">
			$(document).ready(function(){
				
				$(".updateBtn").on("click", function(){
					
					var uForm = document.getElementById("updateForm");
					uForm.productCount.value = $(this).parent().prev().children(".count").val();
					uForm.productId.value = $(this).prev().text();
					uForm.submit();
				});  
			});//ready 
		</script>

<style type="text/css">


table {
	width: 500px;
	border-collapse: collapse;
}

td {
	padding: 5px; /*td 간 간격 */
}



hr.animated-gradient {
   height: 3px;
   border: 3px inset #d2d0d1;
   text-align: center;
   background-color: red;
   background: -moz-linear-gradient(left top, red, red);
   background: -webkit-gradient(linear, left top, right bottom, from(red), to(red));
   -webkit-animation-name: animated-gradient;
   -webkit-animation-iteration-count: infinite;
   -webkit-animation-direction: alternate;
   -webkit-animation-duration: 1.0s;
   -webkit-animation-timing-function: ease-in-out;
}

</style>
<body>
	
	<center><h2>SHOPPING_LIST</h2></center>
	<br>
	<br>
  <hr color="red" size="10" class="animated-gradient">

<div class="col-sm-1"></div>
	
		<div class="col-sm-10">

	<table class="table table-hover">
		<thead>
   
			<tr>
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
					<td><img src="${initParam.rootPath }/up_image/${list.product.productPictureList[0].productPicture }" alt="" width="100" height="100"/></td>
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
						<button type="submit" class="submitBtn" onclick="button_event()">
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
  
	<div style="float:right">
    <button type="submit" class="productBtn">총금액</button>
		   <input type="text" value="${requestScope.totalPrice }" disabled>
    </div>
    <hr>
    <br>
       
           
           <div style="float:right">
       <a href="${initParam.rootPath }/user/paymentProcessController.do">
        
		<button type="submit" class="btn-custom">
			<i class="glyphicon glyphicon-ok"></i>결제페이지로 이동
		</button>
	   </a></div>   
 
    
    
    
    
     <form action="${initParam.rootPath }/user/modifyShoppingBasketProductCount.do" method="post" id="updateForm">
		<sec:csrfInput />
		<%-- csrf 토큰 --%>
	  <input  type="hidden" name="productCount" />
	  <input  type="hidden" name="productId" />
	</form>


		</div>
			<div class="col-sm-1"></div>


</body>


