<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!--맨처음 제품 수령시간 적고  -->
<!--그다음 카드 적고  -등록-->
<!--결제하기 누르면 결제내역에 등록  -->



<script type="text/javascript">
	var newWindow;

	function myFunction() {
		var txt;
		if (confirm("등록하시겠습니까?") == true) {
			txt = "카드번호가 등록이 되었습니다.";
		} else {
			txt = "카드번호를 적어주세요!!";
		}
	}

	function popupCardNumList() {

		window.open("/coffeeNbread_user/view/content/user/cardNumList.jsp",
				"카드번호 리스트",
				"top=300,left=300,width=400,height=400,resizable=no"); //링크걸때 URL과 같다. 여기서는 그냥 절대경로로 넣은거고 상대경로로 해도 상관없음 
	}

	function myFunction() {
		confirm("결제하시겠습니까? ");
	}

	$(document).ready(function() {
		/* $(".count").on("change",function(){
			
			document.getElementById( "productCount" ).setAttribute( 'value', this.value);
		}); */
		$("#registerBtn").on("click", function() {

			var aForm = document.getElementById("addCardNum");
			document.getElementById("card").setAttribute('value', this.value);
			aForm.cardNum.value = $(this).prev().val();
			aForm.submit();
		});

		/* 카드번호 등록 */
		$("#card_id").on("change", function() {
			document.getElementById("card").setAttribute('value', this.value);
		});



	});
</script>
<style type="text/css">
table {
	width: 500px;
	border-collapse: collapse;
}

td {
	padding: 5px; /*td 간 간격 */
}
</style>

<div class="col-sm-1"></div>
<div class="col-sm-10">


	<center>
		<h2>${requestScope.userName }의결제페이지</h2>
	</center>

	<hr>

	<table class="table">
		<thead>
			<tr>
				<th>제품카테고리</th>
				<th>제품사진</th>
				<th>제품명</th>
				<th>가격</th>
				<th>개수</th>

			</tr>
		</thead>
		<tbody>


			<c:forEach items="${requestScope.sbpList }" var="list">

				<tr id="sbp_id">
					<td>${list.product.productCategory}</td>
					<td>${list.product.productPicture}</td>
					<td>${list.product.productName}</td>
					<td>${list.product.productPrice}</td>
					<td>${list.productCount}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

	
	

		<%--  
  제품수령 희망 시간:
     --%>
	<div>
		<br> <br> <br> 
		<hr> 
		<input type="text"
			size="20" name="cardNum" id="card" placeholder="카드번호를 입력해주세요."
			value="">
		<button type="submit" id="registerBtn">
			<i class="glyphicon glyphicon-plus"></i>카드번호 등록
		</button>
	
	
	<br>
    <div>
    <select name="bookMarkCardNum" id="card_id">
	<c:forEach var="list" items="${requestScope.bmlist }">
		<option value="${list.cardNum }">${list.cardNum }</option>
	</c:forEach>
     </select>
  
        <button type="submit" name="findCardNumList" id="findCardNum">		
         <i class="glyphicon glyphicon-list"></i>등록한 카드번호 목록
        </button> 
   <div style="float: right">
		총금액 :<input type="text" value="${requestScope.totalPrice }" disabled>
</div></div>
    

   

   

<form  	action="${initParam.rootPath }/user/addPaymentDetailsController.do"
		id="payForm">
	<sec:csrfInput />
		<div style="float: right">
	결제 방법 선택 <select id="payment_method" name="paymentOption">
				<c:forEach var="list" items="${requestScope.spoList }">
					<option value="${list.paymentOptionList.paymentId }">${list.paymentOptionList.paymentMethod}</option>
				</c:forEach>
			</select></div>
     </div>
	
	
	<c:forEach items="${requestScope.sbpList }" var="list">
		<input type="hidden" name="productIdList"
				value="${list.product.productId }" />
		<input type="hidden" name="reservationOrderCount"
				value="${list.productCount }" />
	</c:forEach>
	     <br>
	     <br>
 

 <div style="float: right">
	 제품수령 희망시간
	  <label> <input type="text" name="productHopeTime"
			id="paytime" placeholder="ex)2017-07-21 10:30"></label>
			</div>
	    <br>
	    <hr>
	  
		<button type="submit" id="payment" class="btn"
			onclick="myFunction()" style="float: right">
		<i class="glyphicon glyphicon-credit-card"></i>결제
	   </button>
	   <br><br>
</form>	
        






<form
		action="${initParam.rootPath }/user/addBookMarkCardNumController.do"
		id="addCardNum">
	<sec:csrfInput />
	<input type="hidden" name="cardNum" />
</form>

</div>
<div class="col-sm-1"></div>

