<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<style type="text/css">
.centertext {
	text-align: center;
}
</style>



<br>
<br>
<br>
<div class="col-sm-2"></div>

<div class="col-sm-8">
	<div class="content">
		<div class="container-fluid">
			<div class="row">

				<div class="card">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<br>
						<br>

						<div class="card-header" data-background-color="purple">
							<h4 class="title" style="text-align: center;">내 정보 조회</h4>
							
						</div>
					
					
					
						
						
						
							<br>
							<br>
							<table class="table">

								<tr class="form-group">
									<th>사용자 ID</th>
									<td><sec:authentication property="principal.userId" /></td>
								</tr>

								<tr class="form-group">
									<th>이름</th>
									<td><sec:authentication property="principal.userName" />
									</td>
								</tr>

								<tr class="form-group">
									<th>생일</th>
									<td><sec:authentication property="principal.birthFormat" /></td>
								</tr>
								<tr class="form-group">
									<th>성별</th>
									<td><sec:authentication property="principal.userGender" /></td>
								</tr>
								<tr class="form-group">
									<th>이메일주소</th>
									<td><sec:authentication property="principal.userEmail" /></td>
								</tr>
								<tr class="form-group">
									<th>전화번호</th>
									<td><sec:authentication property="principal.userPhone" /></td>
								</tr>
								<tr class="form-group">
									<th>주소</th>
									<td><sec:authentication property="principal.userAddress" /></td>
								</tr>







							</table>
						</div>
						
					</div>
					<div class="col-md-2"></div>
				</div>


			</div>
		</div>
	</div>
</div>
<div class="col-sm-2"></div>

<!-- 원래거 
					<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<style type="text/css">
table {
	width: 800;
	border-collapse: collapse;
}

th {
	width: 200px;
	text-ailgn:center;
}

td {
	width: 400px;
	/* padding: 10px; */ /*td 간 간격 */
}
</style>
<h2>MY PAGE</h2>
<br><br><br>
<div class="col-sm-1"></div>

<div class="col-sm-10">
	<table class="table"  >

		<tr class="form-group">
			<th >사용자 ID</th>
			<td ><sec:authentication property="principal.userId" />
			</td>
		</tr>

		<tr class="form-group">
			<th >이름</th>
			<td ><sec:authentication property="principal.userName" />
			</td>
		</tr>

		<tr class="form-group">
			<th >생일</th>
			<td ><sec:authentication property="principal.birthFormat" /></td>
		</tr>
		<tr class="form-group">
			<th >성별</th>
			<td ><sec:authentication property="principal.userGender" /></td>
		</tr>
		<tr class="form-group">
			<th >이메일주소</th>
			<td ><sec:authentication property="principal.userEmail" /></td>
		</tr>
		<tr class="form-group">
			<th >전화번호</th>
			<td ><sec:authentication property="principal.userPhone" /></td>
		</tr>
		<tr class="form-group">
			<th >주소</th>
			<td ><sec:authentication property="principal.userAddress" /></td>
		</tr>







	</table>
</div>
<div class="col-sm-1"></div>


					
					
					 -->