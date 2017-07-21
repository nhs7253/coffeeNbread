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
td, th{
  text-align:center;
}
td {
	padding: 5px; /*td 간 간격 */
}
@font-face {
	font-family: 'title';
	src: local(※), url(${initParam.rootPath }/resource/font/a시나리오.woff) format('woff');
}

h2 {
	font-family: 'title';
	font-size: 60px
}
@font-face {
	font-family: 'method';
	src: local(※), url(${initParam.rootPath }/resource/font/HoonTop_Bold.woff) format('woff');
}

.method {
	font-family: 'method';
}
</style>

<div class="col-sm-11">
		<br><br>

	<center>
		<h2><img src="${initParam.rootPath }/resource/css/payment.png">&nbsp;${requestScope.userName }의 결제페이지</h2>
	</center>

<br><br>
	<table class="table">
		<thead>
			<tr>
				<th style="font-weight:bold; background-color:lightyellow">제품카테고리</th>
				<th style="font-weight:bold; background-color:lightyellow">제품사진</th>
				<th style="font-weight:bold; background-color:lightyellow">제품명</th>
				<th style="font-weight:bold; background-color:lightyellow">가격</th>
				<th style="font-weight:bold; background-color:lightyellow">개수</th>
			</tr>
		</thead>
		<tbody>


			<c:forEach items="${requestScope.sbpList }" var="list">

				<tr id="sbp_id">
					<td>${list.product.productCategory}</td>
					<td><img src="${initParam.rootPath }/up_image/${list.product.productPictureList[0].productPicture}"
						alt="" width="150" height="150" /></td>
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
			size="20" name="cardNum" id="card" placeholder="카드번호를 입력해주세요." value="">
		<button type="submit" id="registerBtn" style="background-color:#01a207">
			<i class="glyphicon glyphicon-plus"></i>&nbsp;카드번호 등록
		</button>
	
	
	<br>
    <div>
    <select name="bookMarkCardNum" id="card_id">
	<c:forEach var="list" items="${requestScope.bmlist }">
		<option value="${list.cardNum }">${list.cardNum }</option>
	</c:forEach>
     </select>
  
        <button type="submit" name="findCardNumList" id="findCardNum" style="background-color:#10e69c">		
         <i class="glyphicon glyphicon-list"></i>&nbsp;등록한 카드번호 목록
        </button> 
        
   <div style="float: right">
<img src="${initParam.rootPath }/resource/css/piggy-bank.png">&nbsp;<input type="text" value=" 총 금액 : " size=8 disabled style="border:0; background-color:transparent; font-size:20px"> <input type="text" value="${requestScope.totalPrice }" disabled style="border:0; background-color:transparent; font-size:20px"></span>		
</div></div>
    

<br><br>


<div style="float: right">
<form action="${initParam.rootPath }/user/addPaymentDetailsController.do" id="payForm">
	<sec:csrfInput />
	<input class="method" type="text" value="결제 방법 선택 " disabled style="border:0; background-color:transparent; font-size:20px">
	<select id="payment_method" name="paymentOption">
				<c:forEach var="list" items="${requestScope.spoList }">
					<option value="${list.paymentOptionList.paymentId }">${list.paymentOptionList.paymentMethod}</option>
				</c:forEach>
	</select>
	
	
	<c:forEach items="${requestScope.sbpList }" var="list">
		<input type="hidden" name="productIdList"
				value="${list.product.productId }" />
		<input type="hidden" name="reservationOrderCount"
				value="${list.productCount }" />
	</c:forEach>
	     <br>
	     <br>
 


	 <input class="method" type="text" value="제품수령 희망시간" disabled style="border:0; background-color:transparent; font-size:20px">
	  <label> <input type="text" name="productHopeTime"
			id="paytime" placeholder="ex)2017-07-21 10:30"></label>
	    <br>
	    <hr>
	  
		<button type="submit" id="payment" class="btn"
			onclick="myFunction()" style="float: right; background-color:#ffb6c1">
		<i class="glyphicon glyphicon-credit-card"></i>&nbsp;결제
	   </button>
	   <br><br>
</div>
</form>	
        






<form
		action="${initParam.rootPath }/user/addBookMarkCardNumController.do"
		id="addCardNum">
	<sec:csrfInput />
	<input type="hidden" name="cardNum" />
</form>

</div>
<div class="col-sm-1"></div>

