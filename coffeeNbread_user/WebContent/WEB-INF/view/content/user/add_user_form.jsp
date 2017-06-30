<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<h2> coffeeNbread_user 회원 가입</h2>
<form action="${initParam.rootPath }/addUser.do" method="post">

	<div class="form-group">
		<label for="id">사용자 ID</label>
		<input type="text" name="userId" id="id" class="form-control">
	</div>
	
	<div class="form-group">
		<label for="password">패스워드</label>
		<input type="password" name="userPw" id="password" class="form-control">
	</div>
	
	<div class="form-group">
		<label for="name">이름</label>
		<input type="text" name="userName" id="name" class="form-control">
	</div>
	
	<div class="form-group">
		<label for="birth">생일</label>
		<input type="Date" name="userBirth" id="birth" class="form-control">
	</div>
	
	<div class="form-group">
		<label for="gender">성별</label>
		<input type="text" name="userGender" id="gender" class="form-control">
	</div>
	
	<div class="form-group">
		<label for="email">이메일 주소</label>
		<input type="text" name="userEmail" id="email" class="form-control">
	</div>
	
	<div class="form-group">
		<label for="phone">전화번호</label>
		<input type="text" name="userPhone" id="phone" class="form-control">
	</div>
	
	<div class="form-group">
		<label for="address">주소</label>
		<input type="text" name="userAddress" id="address" class="form-control">
	</div>
	
	<button type="submit" class="btn btn-default">가입</button>
	<sec:csrfInput/><%-- csrf 토큰 --%>
</form>












