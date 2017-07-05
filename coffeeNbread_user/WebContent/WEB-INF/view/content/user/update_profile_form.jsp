<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h2>정보 수정 가입</h2>
<form action="${initParam.rootPath }/user/modifyUserController.do" method="post">
	<div class="form-group">
		<label for="id">사용자 ID</label>
		<input type="text" name="userId" id="id" class="form-control" value='<sec:authentication property="principal.userId"/>'>
	</div>
	<div class="form-group">
		<label for="oldPassword">기존 패스워드</label>
		<input type="password" name="oldUserPassword" id="oldPassword" class="form-control">
	</div>
	<div class="form-group">
		<label for="password">변경할 패스워드</label>
		<input type="password" name="userPw" id="password" class="form-control">
	</div>
	<div class="form-group">
		<label for="name">이름</label>
		<input type="text" name="userName" id="name" class="form-control" value='<sec:authentication property="principal.userName"/>'>
	</div>
	<div class="form-group">
		<label for="name">생일</label>
		<input type="text" name="userBirth" id="birth" class="form-control" value='<sec:authentication property="principal.birthFormat"/>'>
	</div>
	<div class="form-group">
		<label for="name">성별</label>
		<input type="text" name="userGender" id="gender" class="form-control" value='<sec:authentication property="principal.userGender"/>'>
	</div>
	<div class="form-group">
		<label for="email">이메일 주소</label>
		<input type="text" name="userEmail" id="email" class="form-control" value='<sec:authentication property="principal.userEmail"/>'>
	</div>
	<div class="form-group">
		<label for="name">전화번호</label>
		<input type="text" name="userPhone" id="phone" class="form-control" value='<sec:authentication property="principal.userPhone"/>'>
	</div>
	<div class="form-group">
		<label for="name">주소</label>
		<input type="text" name="userAddress" id="address" class="form-control" value='<sec:authentication property="principal.userAddress"/>'>
	</div>
	<button type="submit" class="btn btn-default">수정</button>
	<sec:csrfInput/><%-- csrf 토큰 --%>
</form>