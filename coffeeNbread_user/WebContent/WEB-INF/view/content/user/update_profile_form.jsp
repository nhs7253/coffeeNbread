<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h2>정보 수정 가입</h2>
<form action="${initParam.rootPath }/user/modifyUserController.do" method="post">
	<table>
	<tr class="form-group">
		<th>사용자 ID</th>
		<td><div class="col-xs-10"><input type="text" name="userId" id="id" class="form-control" value='<sec:authentication property="principal.userId"/>' ></div><td>
	</tr>
	
	<tr class="form-group">
		<th>기존 패스워드</th>
		<td><div class="col-xs-10"><input type="password" name="oldUserPassword" id="oldPassword" class="form-control"></div><td>
	</tr>
	
	<tr class="form-group">
		<th>변경할 패스워드</th>
		<td><div class="col-xs-10"><input type="password" name="userPw" id="password" class="form-control"></div></td>
	</tr>
	<tr class="form-group">
		<th>이름</th>
		<td><div class="col-xs-10"><input type="text" name="userName" id="name" class="form-control" value='<sec:authentication property="principal.userName"/>'></div></td>
	</tr>
	<tr class="form-group">
		<th>생일</th>
		<td><div class="col-xs-10"><input type="text" name="userBirth" id="birth" class="form-control" value='<sec:authentication property="principal.birthFormat"/>'></div></td>
	</tr>
	<tr class="form-group">
		<th>성별</th>
		<td><div class="col-xs-5"><input type="text" name="userGender" id="gender" class="form-control" value='<sec:authentication property="principal.userGender"/>'></div></td>
	</tr>
	<tr class="form-group">
		<th>이메일 주소</th>
		<td><div class="col-xs-10"><input type="text" name="userEmail" id="email" class="form-control" value='<sec:authentication property="principal.userEmail"/>'></div><td>
	</tr>
	<tr class="form-group">
		<th>전화번호</th>
		<td><div class="col-xs-10"><input type="text" name="userPhone" id="phone" class="form-control" value='<sec:authentication property="principal.userPhone"/>'></div></td>
	</tr>
	<tr class="form-group">
		<th>주소</th>
		<td><div class="col-xs-10"><input type="text" name="userAddress" id="address" class="form-control" value='<sec:authentication property="principal.userAddress"/>'></div></td>
	</tr>
	</table>
	<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-ok"></i>수정 완료</button>
	<sec:csrfInput/><%-- csrf 토큰 --%>
</form>