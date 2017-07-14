<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript"
	src="/coffeeNbread_user/resource/jquery/jquery-3.2.1.js"></script>

<script type="text/javascript">
 /* $(document).ready(function(){
	 $("#btn_delete").on("click", function(){
	
	 $.ajax({
			alert('aaaa');

			"url":"/coffeeNbread_user/user/removeShoppingBasketProductController.do",
			"data":{"productId":$("#btn_delete").val()},
			/* "success":function(){
				$(btn).parent.remove(); */
			
		}); 
	 });
	});
	 
 
	 
});  */
 
/* 	$("#btn_delete").on("click", function(){
		alert("성공");
		//var btn = this;
		var $this = $(this);
		var id = $(this).parent().prev().prev().text();
		alert('확인');
		alert(id);	 */
		
		
		 

	/*   $(document).ready(function() {

		$("input#btn").on("click", function() {

			alert('aaaaa');
			$.ajax({
				url : "/coffeeNbread_user/user/removeShoppingBasketProductController.do",
				
				data : {"id" : $("#id").val()},
				beforeSend:function(){
				   if(!$("#id").val()){
					   alert("값을 넣으세요");
					   return false;
				   }	
				},
				success: function(txt){
					alert(txt);
				//	$("#result").html();//기존거 지우고 변경
				    $("#result").empty().append(txt);
					//$("#result").append(txt);//추가
				},
				error:function(){
					alert("오류가 발생했습니다.");
				}
			

			});
		})
	}); */
	

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




	<table class="w3-table-all">
		<thead>
			<tr class="w3-blue">
				<td>제품카테고리</td>
				<td>제품사진</td>
				<td>제품명</td>
				<td>가격</td>
				<td>개수</td>
				<td>삭제</td>
			</tr>
		</thead>
		<tbody>

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
					<td><input type="number" min="0" name="productCount"
						value="${list.productCount}"></td>
					<td>
						<form
							action="${initParam.rootPath }/user/removeShoppingBasketProductController.do"
							method="post">
							<sec:csrfInput />
							<%-- csrf 토큰 --%>
							<%-- <input type="hidden" value="${product.storeId }" name="storeId"> --%>
							<button id="btn_delete" name="productId"
								value="${list.product.productId }">삭제</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<form
		action="${initParam.rootPath }/user/findAllProductPriceController.do"
		method="post">
		<sec:csrfInput />
		<%-- csrf 토큰 --%>
		<input type="hidden"
			value="${requestScope.shoppingBasketProductList[0].storeId }"
			name="storeId" />
		<c:forEach items="${requestScope.shoppingBasketProductList }"
			var="List">
			<input type="hidden" name="productId"
				value="${requestScope.product.productId }">
		</c:forEach>
		<input type="text" name="id" id="id">
		<button type="button" id="btn">결제페이지로 이동</button>
	</form>


</body>


