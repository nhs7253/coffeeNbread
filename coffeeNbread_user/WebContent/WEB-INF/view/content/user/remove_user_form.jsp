<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.js"></script>

<style type="text/css">
@font-face {
	font-family: 'title';
	src: local(※), url(http://127.0.0.1:8088/coffeeNbread_user/resource/font/a시나리오.woff) format('woff');
}

h2 {
	font-family: 'title';
	font-size: 60px
}
</style>


<div class="col-sm-11">
<br><br>
<h2><img src="http://127.0.0.1:8088/coffeeNbread_user/resource/css/exit.png">&nbsp;회원 탈퇴</h2>
	<form action="${initParam.rootPath }/user/removeUserController.do"
		method="post">
		<div class="col-sm-2"></div>
<div class="col-sm-8">
<br>
		<div class="form-group">
			<label for="password">탈퇴를 위해 패스워드를 입력하세요</label> 
			<input
				type="password" name="password" id="password" class="form-control">
		</div>
		<div style="float:right">
		<button type="submit" class="btn btn-danger">탈퇴</button>&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<sec:csrfInput />
		<%-- csrf 토큰 --%></div><div class="col-sm-2"></div>
	</form>
</div>
<div class="col-sm-1"></div>












