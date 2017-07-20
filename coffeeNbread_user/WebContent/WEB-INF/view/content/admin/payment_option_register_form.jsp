<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>



<br><br>
<h1>지원 결제 수단 등록</h1>
<hr>
<br><br><br>
<div class="col-sm-1"></div>
	
		<div class="col-sm-10"><div class="col-sm-2"></div>
	<div class="col-sm-8">
<form action="${initParam.rootPath }/admin/addPaymentOptionListController.do"
	method="post">
	<sec:csrfInput />
	
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
	<button type="submit" class="btn btn-default btn-circle">
		<i class="glyphicon glyphicon-ok"></i> 등록
	</button>
</form></div><div class="col-sm-2"></div>

</div>

<div class="col-sm-1"></div>

