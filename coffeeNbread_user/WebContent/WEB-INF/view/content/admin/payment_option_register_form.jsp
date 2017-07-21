<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<style type="text/css">
@font-face {
	font-family: 'title';
	src: local(※), url(${initParam.rootPath }/resource/font/a시나리오.woff) format('woff');
}

h1 {
	font-family: 'title';
	font-size: 60px
}
</style>

	
		<div class="col-sm-11">
		<br><br>
<h1><img src="${initParam.rootPath }/resource/css/note.png">&nbsp;지원 결제 수단 등록</h1>

<br><br><br>
<div class="col-sm-1"></div>
	
		<div class="col-sm-10"><div class="col-sm-2"></div>
	<div class="col-sm-8">
	<center>
	<form action="${initParam.rootPath }/admin/addPaymentOptionListController.do" method="post">
	<sec:csrfInput />
	
	<table>	
	<tr class="form-group">
	<th>코드&nbsp;&nbsp;</th>
	<td><input type="text" name="paymentId" required class="form-control"></td>
	</tr>
	 <tr class="form-group">
	 <th>방법&nbsp;&nbsp;</th>
	  <td><input type="text" name="paymentMethod" required class="form-control"></td>
	  </tr>
	</table>
	<br>
	<div class="col-sm-4"></div>
	<div class="col-sm-4">
	<button type="submit" class="btn btn-default btn-circle" style="background-color:#01a207">
		<i class="glyphicon glyphicon-ok"></i>등록
	</button>
	</div>
</form></center></div><div class="col-sm-2"></div>

</div>

<div class="col-sm-1"></div>

