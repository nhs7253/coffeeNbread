<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<style type="text/css">
table, td {
	
}

table {
	width: 700px;
	border-collapse: collapse;
}

td {
	padding: 5px; /* //td 간 간격 */
}
</style>

</head>
<body>


	<h2>USER_LIST _</h2>
<br><br>
<div class="col-sm-1"></div>
	
		<div class="col-sm-10">
			<form
				action="${initParam.rootPath }/findUserListBySelectToKeywordController.do"
				method="post" class="form-inline quick-search-form" role="form">
				<div style="float:right">
				
				<div class="form-group">
					<select name="select" class="form-control">
						<option value="userId"
							${param.select eq "userId" ? "selected" :""}>아이디</option>
						<option value="userName"
							${param.select eq "userName" ? "selected" :""}>이름</option>
					</select> <input type="text" name="keyword" class="form-control" />
				</div>
				<button type="submit" class="btn btn-custom">
					<i class="glyphicon glyphicon-search"></i>검색
				</button></div>
				<sec:csrfInput />
				<%-- csrf 토큰 --%>
			</form>
		
	
	<br>

	<table class="table">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>생년월일</th>
				<th>성별</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>활동 상태</th>
				<th>매장아이디</th>
			</tr>
		</thead>
		<tbody>

			<%-- ######################################################
															조회된 item 출력 
				###################################################### --%>
			<c:forEach items="${requestScope.list }" var="user">

				<tr>
					<td>${user.userId}</td>
					<td>${user.userName}</td>
					<td>${user.birthFormat}</td>
					<td>${user.userGender}</td>
					<td>${user.userEmail}</td>
					<td>${user.userPhone}</td>
					<td>${user.userAddress}</td>
					<td>${user.userActiveState}</td>
					<td>${user.storeId}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>




<center>

	<p>
		<%--######################################################
															페이징 처리
				###################################################### --%>
		<!-- 첫페이지로 이동 -->
		<a
			href="${initParam.rootPath }/findUserListBySelectToKeywordController.do?page=1&select=${requestScope.select}&keyword=${requestScope.keyword}">첫페이지</a>


		<!--
			이전 페이지 그룹 처리.
			만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
		 -->
		<c:choose>
			<c:when test="${requestScope.pageBean.previousPageGroup}">
				<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
				<a
					href="${initParam.rootPath }/findUserListBySelectToKeywordController.do?page=${requestScope.pageBean.beginPage-1}&select=${requestScope.select}&keyword=${requestScope.keyword}">◀</a>
			</c:when>
			<c:otherwise>
				◀
			</c:otherwise>
		</c:choose>





		<!-- 
		현재 page가 속한 page 그룹내의 페이지들 링크.
		현재 pageGroup의 시작page ~ 끝 page
	 -->
		<!-- 만약에 page가 현재페이지면 링크처리를 하지 않고 page가 현재페이지가 아니라면 링크처리. -->

		<c:forEach begin="${requestScope.pageBean.beginPage }"
			end="${requestScope.pageBean.endPage }" var="page">
			<c:choose>
				<c:when test="${page != requestScope.pageBean.page}">
					<!-- 현재페이지가 아니라면 -->
					<a
						href="${initParam.rootPath }/findUserListBySelectToKeywordController.do?page=${page}&select=${requestScope.select}&keyword=${requestScope.keyword}">${page }&nbsp;&nbsp;</a>
				</c:when>
				<c:otherwise>
				[${page}]&nbsp;&nbsp;
			</c:otherwise>
			</c:choose>

		</c:forEach>



		<!-- 
		다음페이지 그룹으로 이동
		만약에 다음페이지 그룹이 있으면 링크 처리 없으면 화살표만 나오도록 처리
	 -->
		<c:choose>
			<c:when test="${requestScope.pageBean.nextPageGroup}">
				<a
					href="${initParam.rootPath }/findUserListBySelectToKeywordController.do?page=${requestScope.pageBean.endPage+1}&select=${requestScope.select}&keyword=${requestScope.keyword}">▶</a>
			</c:when>
			<c:otherwise>
			▶
		</c:otherwise>
		</c:choose>




		<!-- 마지막 페이지로 이동 -->
		<a
			href="${initParam.rootPath }/findUserListBySelectToKeywordController.do?page=${requestScope.pageBean.totalPage}&select=${requestScope.select}&keyword=${requestScope.keyword}">마지막
			페이지</a>
			</div></center>
			<div class="col-sm-1"></div></body>