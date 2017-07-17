<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<body><div class="col-sm-1"></div>
<div class="col-sm-10">
	<br>
	<br>
	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-md-8">
					<div class="card">
						<div class="card-header" data-background-color="purple">
							<h4 class="title" style="text-align: center;">Edit Profile</h4>

						</div>
						<div class="card-content">
							<form
								action="${initParam.rootPath }/user/modifyUserController.do"
								method="post">
								<div class="row">
									<div class="col-md-3">
										<div class="form-group label-floating">
											<label class="control-label">ID</label> <input type="text"
												name="userId" id="id" class="form-control" disabled
												value='<sec:authentication property="principal.userId"/>'>

										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group label-floating">
											<label class="control-label">Username</label> <input
												type="text" name="userName" id="name" class="form-control"
												value='<sec:authentication property="principal.userName"/>'>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group label-floating">
											<label class="control-label">생일</label> <input type="text"
												name="userBirth" id="birth" class="form-control"
												value='<sec:authentication property="principal.birthFormat"/>'>
										</div>

									</div>
									<div class="col-md-3">
										<div class="form-group label-floating">
											<label class="control-label">성별</label> <input type="text"
												name="userGender" id="gender" class="form-control"
												value='<sec:authentication property="principal.userGender"/>'>
										</div>

									</div>
								</div>

								<div class="row">
									<div class="col-md-6">
										<div class="form-group label-floating">
											<label class="control-label">이메일</label> <input type="text"
												name="userEmail" id="email" class="form-control"
												value='<sec:authentication property="principal.userEmail"/>'>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group label-floating">
											<label class="control-label">번호</label> <input type="text"
												name="userPhone" id="phone" class="form-control"
												value='<sec:authentication property="principal.userPhone"/>'>
										</div>
									</div>

								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group label-floating">
											<label class="control-label">기존 패스워드</label> <input
												type="password" name="oldUserPassword" id="oldPassword"
												class="form-control">
										</div>

									</div>
									<div class="col-md-6">
										<div class="form-group label-floating">
											<label class="control-label">변경할 패스워드</label> <input
												type="password" name="userPw" id="password"
												class="form-control">
										</div>
									</div>
								</div>



								<div class="row">
									<div class="col-md-12">
										<div class="form-group label-floating">
											<label class="control-label">주소</label> <input type="text"
												name="userAddress" id="address" class="form-control"
												value='<sec:authentication property="principal.userAddress"/>'>
										</div>
									</div>
								</div>

								<div style="float: right">
									<button type="submit" class="btn btn-custom">
										<i class="glyphicon glyphicon-ok"></i>수정 완료
									</button>
								</div>
								<sec:csrfInput />
								<%-- csrf 토큰 --%>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-2"></div>
		</div>
	</div>
</div>
<div class="col-sm-1"></div>

</body>
