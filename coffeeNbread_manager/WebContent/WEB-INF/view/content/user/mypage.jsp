<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container" style="font-size: 20px;">
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
			<a href="${initParam.rootPath }/user/update_profile_form.do" class="btn btn-default">정보수정</a>
		</div>
	</div>
</div>








