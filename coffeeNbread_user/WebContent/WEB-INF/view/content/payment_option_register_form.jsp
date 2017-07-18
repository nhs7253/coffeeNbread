<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>




<h1>플랫폼 지원 결제 목록 등록</h1>
<hr>
<br>
<div class="col-sm-1"></div>
	
		<div class="col-sm-10">
		
<form action="${initParam.rootPath }/addPaymentOptionListController.do"
	method="post">
	<sec:csrfInput />
	<div class="col-sm-3"></div>
	
		<div class="col-sm-6">
	<table>	
	<tr  class="form-group">
	<th>아이디 </th>
	<td><input type="text" name="paymentId" required class="form-control"></td>
	</tr>
	 <tr  class="form-group">
	 <th>방법</th>
	  <td><input type="text" name="paymentMethod" required class="form-control"></td>
	  </tr>
	</table>
<div style="float:right">
	<button type="submit" class="btn btn-default btn-circle">
		<i class="glyphicon glyphicon-ok"></i> 등록
	</button></div></div><div class="col-sm-3"></div>
	
		
</form></div><div class="col-sm-1"></div>

