<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css">
table, td {
   border: 1px solid black;
}

table {
   border-collapse: collapse;
}

td {
   padding: 10px; /*td 간 간격 */
}
</style>

<h4 style="font-weight:bold">판매량</h4>

<script type="text/javascript" src="/coffeeNbread_user/resource/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('input[type="checkbox"]').on("click", function(){
		$('input[type="checkbox"]').not(this).prop("checked", false);
	});
	
	$("#total").on("click", function(){
		$("#br2").prevAll("#optionId").remove();
		$("#br2").prevAll("#optionName").remove();
		$("#br2").prevAll('input[type="button"]').remove();
		$("#br3").prevAll('input[type="button"]').remove();
		$("#br3").prevAll("#productName").remove();
		$("#br1").prevAll('input[type="button"]').remove();
		$("#br1").prevAll('input[type="date"]').remove();
		
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeTotalController.do",
			"success":function(list){
				$("#tbody").remove();
				$("#table").append("<tbody id='tbody'><tr id='tr1'><td id='td1' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>제품명</td>");
				values = list.productNameList;
	
				var txt = "";
				$.each(values, function(index, value){
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td1").after(txt);
				
				$("#table").append("<tr id='tr2'><td id='td2' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>판매량</td>");
				values = list.countList;
				
				var txt = "";
				$.each(values, function(index, value) {
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td2").after(txt);
			}
		});
	});
	
	$("#date").on("click", function(){
		$("#br2").prevAll("#optionId").remove();
		$("#br2").prevAll("#optionName").remove();
		$("#br3").prevAll('input[type="button"]').remove();
		$("#br3").prevAll("#productName").remove();
		$("#br1").prevAll('input[type="button"]').remove();
		$("#br1").prevAll('input[type="date"]').remove();
		
		$("#br1").before("<input type='button' value='1주일' id='1주일'/> ");
		$("#br1").before("<input type='button' value='1개월' id='1개월'/> ");
		$("#br1").before("<input type='button' value='3개월' id='3개월'/> ");
		$("#br1").before("<input type='button' value='6개월' id='6개월'/> ");
		$("#br1").before("<input type='button' value='12개월' id='12개월'/> ");
		$("#br1").before("<input id='start' type='date' name='startDate'/>");
		$("#br1").before("<input id='end' type='date' name='endDate'/>");
		$("#br1").before("<input id='searchDate' type='button' value='검색'/>");
	});
	
	$("#category").on("click", function(){
		$("#br1").prevAll('input[type="button"]').remove();
		$("#br1").prevAll('input[type="date"]').remove();
		$("#br3").prevAll('input[type="button"]').remove();
		$("#br3").prevAll("#productName").remove();
		$("#br2").prevAll("#optionId").remove();
		$("#br2").prevAll("#optionName").remove();
		$("#br2").before("<select name='optionId' id='optionId'><option id='option'>종류</option> ");
		
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findOptionController.do",
			"success":function(list){
				values = list.optionList;
	
				var txt = "";
				$.each(values, function(index, value){
					txt += "<option id='optionName'>" + value + "</option>";
				});
				$("#option").after(txt);
				$("#option").after("</select>");
			}
		});
	});
	
	$("#name").on("click", function(){
		$("#br1").prevAll('input[type="button"]').remove();
		$("#br1").prevAll('input[type="date"]').remove();
		$("#br2").prevAll("#optionId").remove();
		$("#br2").prevAll("#optionName").remove();
		$("#br3").prevAll('input[type="button"]').remove();
		$("#br3").prevAll("#productName").remove();
		
		$("#br3").before("<input id='productName' type='text'/> ");
		$("#br3").before("<input id='searchName' type='button' value='검색'/>");
	});
	
	$(document).on("click", "#1주일",  function(){
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeByMethodController.do",
			"type":"GET",
			"data":{"method":"1주일"},
			"success":function(list){
				$("#tbody").remove();
				$("#table").append("<tbody id='tbody'><tr id='tr1'><td id='td1' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>제품명</td>");
				values = list.productNameList;
	
				var txt = "";
				$.each(values, function(index, value){
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td1").after(txt);
				
				$("#table").append("<tr id='tr2'><td id='td2' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>판매량</td>");
				values = list.countList;
				
				var txt = "";
				$.each(values, function(index, value) {
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td2").after(txt);
			}
		});
	});
	
	$(document).on("click", "#1개월",  function(){
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeByMethodController.do",
			"type":"GET",
			"data":{"method":"1개월"},
			"success":function(list){
				$("#tbody").remove();
				$("#table").append("<tbody id='tbody'><tr id='tr1'><td id='td1' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>제품명</td>");
				values = list.productNameList;
	
				var txt = "";
				$.each(values, function(index, value){
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td1").after(txt);
				
				$("#table").append("<tr id='tr2'><td id='td2' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>판매량</td>");
				values = list.countList;
				
				var txt = "";
				$.each(values, function(index, value) {
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td2").after(txt);
			}
		});
	});
	
	$(document).on("click", "#3개월",  function(){
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeByMethodController.do",
			"type":"GET",
			"data":{"method":"3개월"},
			"success":function(list){
				$("#tbody").remove();
				$("#table").append("<tbody id='tbody'><tr id='tr1'><td id='td1' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>제품명</td>");
				values = list.productNameList;
	
				var txt = "";
				$.each(values, function(index, value){
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td1").after(txt);
				
				$("#table").append("<tr id='tr2'><td id='td2' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>판매량</td>");
				values = list.countList;
				
				var txt = "";
				$.each(values, function(index, value) {
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td2").after(txt);
			}
		});
	});
	
	$(document).on("click", "#6개월",  function(){
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeByMethodController.do",
			"type":"GET",
			"data":{"method":"6개월"},
			"success":function(list){
				$("#tbody").remove();
				$("#table").append("<tbody id='tbody'><tr id='tr1'><td id='td1' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>제품명</td>");
				values = list.productNameList;
	
				var txt = "";
				$.each(values, function(index, value){
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td1").after(txt);
				
				$("#table").append("<tr id='tr2'><td id='td2' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>판매량</td>");
				values = list.countList;
				
				var txt = "";
				$.each(values, function(index, value) {
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td2").after(txt);
			}
		});
	});
	
	$(document).on("click", "#12개월",  function(){
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeByMethodController.do",
			"type":"GET",
			"data":{"method":"12개월"},
			"success":function(list){
				$("#tbody").remove();
				$("#table").append("<tbody id='tbody'><tr id='tr1'><td id='td1' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>제품명</td>");
				values = list.productNameList;
	
				var txt = "";
				$.each(values, function(index, value){
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td1").after(txt);
				
				$("#table").append("<tr id='tr2'><td id='td2' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>판매량</td>");
				values = list.countList;
				
				var txt = "";
				$.each(values, function(index, value) {
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td2").after(txt);
			}
		});
	});
	
	$(document).on("click", "#searchDate", function(){
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeByStartEndDateController.do",
			"type":"GET",
			"data":{"startDate":$("#start").val(), "endDate":$("#end").val()},
			"success":function(list){
				$("#tbody").remove();
				$("#table").append("<tbody id='tbody'><tr id='tr1'><td id='td1' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>제품명</td>");
				values = list.productNameList;
	
				var txt = "";
				$.each(values, function(index, value){
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td1").after(txt);
				
				$("#table").append("<tr id='tr2'><td id='td2' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>판매량</td>");
				values = list.countList;
				
				var txt = "";
				$.each(values, function(index, value) {
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td2").after(txt);
			}
		});
	});
	
	$(document).on("click", "#searchName",  function(){
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeByNameController.do",
			"type":"GET",
			"data":{"productName":$("#productName").val()},
			"success":function(list){
				$("#tbody").remove();
				$("#table").append("<tbody id='tbody'><tr id='tr1'><td id='td1' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>제품명</td>");
				values = list.productNameList;
	
				var txt = "";
				$.each(values, function(index, value){
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td1").after(txt);
				
				$("#table").append("<tr id='tr2'><td id='td2' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>판매량</td>");
				values = list.countList;
				
				var txt = "";
				$.each(values, function(index, value) {
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td2").after(txt);
			}
		});
	});

	$(document).on("change", "#optionId",  function(){
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeByCategoryController.do",
			"type":"GET",
			"data":{"productCategory":$("#optionId option:selected").val()},
			"success":function(list){
				$("#tbody").remove();
				$("#table").append("<tbody id='tbody'><tr id='tr1'><td id='td1' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>제품명</td>");
				values = list.productNameList;
	
				var txt = "";
				$.each(values, function(index, value){
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td1").after(txt);
				
				$("#table").append("<tr id='tr2'><td id='td2' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>판매량</td>");
				values = list.countList;
				
				var txt = "";
				$.each(values, function(index, value) {
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td2").after(txt);
			}
		});
	});
	
});
</script>

<input type="checkbox" name="choice" id="total" value="total">오늘 전체&nbsp;&nbsp;<br id=br0>
<input type="checkbox" name="choice" id="date" value="date">날짜별&nbsp;&nbsp;<br id=br1>
<input type="checkbox" name="choice" id="category" value="category">종류별&nbsp;&nbsp;<br id=br2>
<input type="checkbox" name="choice" id="name" value="name">제품명&nbsp;&nbsp;<br id=br3>
<p><p>

<table id="table">
	<tbody id="tbody">
		<tr id="tr1">
			<td width="70" align="center" style="font-weight:bold; background-color:LemonChiffon">제품명</td>
			<c:forEach items="${requestScope.productNameList }" var="string">
				<td align="center">${string }</td>
			</c:forEach>
		</tr>
		<tr id="tr2">
			<td width="70" align="center" style="font-weight:bold; background-color:LemonChiffon">판매량</td>
			<c:forEach items="${requestScope.countList }" var="string">
				<td align="center">${string }</td>
			</c:forEach>
		</tr>
	</tbody>
</table>

<br><br>

<h4 style="font-weight:bold">상승세 / 하락세</h4>

<table>
	<tbody>
		<tr>
			<td width="70" align="center" style="font-weight:bold; background-color:LemonChiffon">상승세</td>
			<c:forEach items="${requestScope.upProductList }" var="product">
				<td align="center">${product.productName }</td>
			</c:forEach>
		</tr>
	</tbody>
</table>

<br>

<table>
	<tbody>
		<tr>
			<td width="70" align="center" style="font-weight:bold; background-color:LemonChiffon">하락세</td>
			<c:forEach items="${requestScope.downProductList }" var="product">
				<td align="center">${product.productName }</td>
			</c:forEach>
		</tr>
	</tbody>
</table>

<br>

<table>
	<tbody>
		<tr>
			<td width="70" align="center" style="font-weight:bold; background-color:LemonChiffon">유지중</td>
			<c:forEach items="${requestScope.keepProductList }" var="product">
				<td align="center">${product.productName }</td>
			</c:forEach>
		</tr>
	</tbody>
</table>
<br><br>

<h4 style="font-weight:bold">예상 생산량</h4>

<table>
	<tbody>
		<tr>
			<td width="100" align="center" style="font-weight:bold; background-color:LemonChiffon">제품명</td>
			<c:forEach items="${requestScope.allProductNameList }" var="string1">
				<td align="center">${string1}</td>
			</c:forEach>
		</tr>
		<tr>
			<td width="100" align="center" style="font-weight:bold; background-color:LemonChiffon">예상 생산량</td>
			<c:forEach items="${requestScope.todayCountList }" var="string2">
				<td align="center">${string2}</td>
			</c:forEach>
		</tr>
	</tbody>
</table>

			