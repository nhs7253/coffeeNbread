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
    document.getElementById("demo").innerHTML = txt;
}

function popupOpen(){
    var popUrl = "/coffeeNbread_user/user/popup.html";    //팝업창에 출력될 페이지 URL
    var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no,top=250,left=500;";    //팝업창 옵션(optoin)
        window.open(popUrl,"",popOption);
    }
	


$(document).ready(function(){
	/* $(".count").on("change",function(){
		
		document.getElementById( "productCount" ).setAttribute( 'value', this.value);
	}); */
	$("#registerBtn").on("click", function(){
		alert("aaaa");
		var aForm = document.getElementById("addCardNum");
		alert(aForm);
		document.getElementById( "card" ).setAttribute('value', this.value);
		aForm.cardNum.value = $(this).prev().val();
		alert(aForm.cardNum.value);
		aForm.submit();
	});
	
	$("#findCardList").on("click",function(){
	
		 alert("등록-1");
	})
  
	/* 카드번호 등록 */
	$("#card_id").on("change", function(){
		document.getElementById( "card" ).setAttribute('value', this.value);
	});
	
	
	
	
	
});


</script>
<style type="text/css" >
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



<center><h2>${requestScope.userName }의 결제페이지</h2></center>

<hr>
 <h4 >결제할 목록</h4>
<table class="w3-table-all"   >
	<thead>
		<tr class="w3-blue" >
			<th>제품카테고리</th>
			<th>제품사진</th>
			<th>제품명</th>
			<th>가격</th>
			<th>개수</th>

		</tr>
	</thead>
	<tbody>


		<c:forEach items="${requestScope.sbpList }"
			var="list">

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

<br>
<br>

<p>
	총금액<input type="text"  value="${requestScope.totalPrice }">
</p>


<p>
   결제 방법 선택 
   
   <c:forEach var="list" items="${requestScope.spoList }">
		<li value="${list }">${list}</li>
	</c:forEach>

</p>



  즐겨찾는 카드번호

   <br>
    <p>  
      <input type="text" size="20" name="cardNum" id="card" value="${requestScope.cardNum }">
       <button type="submit" onclick="myFunction()" id="registerBtn" >
           <i class="glyphicon glyphicon-plus"></i>카드번호 등록 
      </button>
    </p>    

   
   <p>		

       <i class="glyphicon glyphicon-search"></i>등록한 카드번호 조회 
   
   </p>
   

   <p>
    <select name="bookMarkCardNum" id="card_id">
	<c:forEach var="list" items="${requestScope.bmlist }">
		<option value="${list.cardNum }">${list.cardNum }</option>
	</c:forEach>
     </select>
   </p>





<form
	action="${initParam.rootPath }/user/addPaymentDetailsController.do">
	<sec:csrfInput />
	<c:forEach items="${requestScope.shoppingBasketProductList }"
		var="list">
		<input type="hidden" name="productIdList"
			value="${list.product.productId }" />
		<input type="hidden" name="reservationOrderCount"
			value="${list.productCount }" />
		<input type="hidden" name="storeId" value="${list[0].storeId}">
	</c:forEach>
	<button type="submit" class="btn-custom">
		<i class="glyphicon glyphicon-credit-card"></i>결제
	</button>
</form>



<form
	action="${initParam.rootPath }/user/addBookMarkCardNumController.do" id="addCardNum">
	<sec:csrfInput />
	<input type="hidden" name="cardNum"/>
</form>


<form
	action="${initParam.rootPath }/user/findBookMarkCardNumController.do">
	<sec:csrfInput />
	
 </form>
