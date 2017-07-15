<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%-- <div class="container" style="font-size: 20px;">
	<div class="row">
		<div class="col-sm-12">
			<h1>본인정보 조회결과</h1>
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-2">사용자 ID</div>
		<div class="col-sm-10"><sec:authentication property="principal.userId"/></div>
	</div>
	<div class="row">
		<div class="col-sm-2">이름</div>
		<div class="col-sm-10"><sec:authentication property="principal.userName"/></div>
	</div>
	<div class="row">
		<div class="col-sm-2">생일</div>
		<div class="col-sm-10"><sec:authentication property="principal.birthFormat"/></div>
	</div>
	<div class="row">
		<div class="col-sm-2">성별</div>
		<div class="col-sm-10"><sec:authentication property="principal.userGender"/></div>
	</div>
	<div class="row">
		<div class="col-sm-2">이메일주소</div>
		<div class="col-sm-10"><sec:authentication property="principal.userEmail"/></div>
	</div>
	<div class="row">
		<div class="col-sm-2">전화번호</div>
		<div class="col-sm-10"><sec:authentication property="principal.userPhone"/></div>
	</div>
	<div class="row">
		<div class="col-sm-2">주소</div>
		<div class="col-sm-10"><sec:authentication property="principal.userAddress"/></div>
	</div>
	
	<div class="row" style="margin-top:20px">
		<div class="col-sm-12">
			<a href="${initParam.rootPath }/user/update_profile_form.do" class="btn pull-left"><i class="glyphicon glyphicon-pencil"></i>정보수정</a>
		</div>
	</div>
</div> --%>
<div class="col-sm-1"></div>
	
		<div class="col-sm-10">
<table class="table" style="width:300px">
	
	<tr class="form-group">
		<th>사용자 ID</th>
		<td><div class="col-xs-10"><sec:authentication property="principal.userId"/></div><td>
	</tr>
	
	<tr class="form-group">
		<th>이름</th>
		<td><div class="col-xs-10"><sec:authentication property="principal.userName"/></div><td>
	</tr>
	
	<tr class="form-group">
		<th>생일</th>
		<td><div class="col-xs-10"><sec:authentication property="principal.birthFormat"/></div></td>
	</tr>
	<tr class="form-group">
		<th>성별</th>
		<td><div class="col-xs-10"><sec:authentication property="principal.userGender"/></div></td>
	</tr>
	<tr class="form-group">
		<th>이메일주소</th>
		<td><div class="col-xs-10"><sec:authentication property="principal.userEmail"/></div></td>
	</tr>
	<tr class="form-group">
		<th>전화번호</th>
		<td><div class="col-xs-10"><sec:authentication property="principal.userPhone"/></div>
	</tr>
	<tr class="form-group">
		<th>주소</th>
		<td><div class="col-xs-10"><sec:authentication property="principal.userAddress"/></div>
	</tr>
	






</table>
		</div>
			<div class="col-sm-1"></div>


