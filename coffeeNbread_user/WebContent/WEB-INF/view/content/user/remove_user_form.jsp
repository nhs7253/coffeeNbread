<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<h2>coffeeNbread_user 회원 탈퇴</h2>
<br>
<br>
<br>
<div class="col-sm-2"></div>

<div class="col-sm-8">
	<form action="${initParam.rootPath }/user/removeUserController.do"
		method="post">
		<div class="form-group">
			<label for="password">탈퇴를 위해 패스워드를 입력하세요</label> 
			<input
				type="password" name="password" id="password" class="form-control">
		</div><div style="float:right">
		<button type="submit" class="btn btn-custom">탈퇴</button></div>
		<sec:csrfInput />
		<%-- csrf 토큰 --%>
	</form>
</div>
<div class="col-sm-2"></div>












