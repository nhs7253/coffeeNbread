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
th,td{
	text-align:center;
}
@font-face {
	font-family: 'title';
	src: local(※), url(${initParam.rootPath }/resource/font/a시나리오.woff) format('woff');
}

h2 {
	font-family: 'title';
	font-size: 60px
}
</style>
<link rel="stylesheet" href="/coffeeNbread_user/resource/css/search_style.css">

</head>
<body>

<div class="col-sm-11">
	<br><br>
	<h2><img src="${initParam.rootPath }/resource/css/management.png">&nbsp;매장 관리</h2>
			<form action="${initParam.rootPath }/admin/userManagementListController.do"
				method="post" class="form-inline quick-search-form" role="form">
				<div style="float:right">
				<div class="form-group">
					<select name="select" class="form-control">
						<option value="userId"
							${param.select eq "userId" ? "selected" :""}>유저 아이디</option>
						<option value="userName"
							${param.select eq "userName" ? "selected" :""}>유저 이름</option>
						<option value="storeId"
							${param.select eq "storeId" ? "selected" :""}>매장 아이디</option>
						<option value="storeName"
							${param.select eq "storeName" ? "selected" :""}>매장 이름</option>
					</select> <input type="text" name="keyword" class="form-control" />
				</div>
				
				<button type="submit" class="btn" style="background-color:#b6009f">
					<i class="glyphicon glyphicon-search"></i>&nbsp;검색
				</button>						<br>
<br><br>
</div>
				<sec:csrfInput />
				<%-- csrf 토큰 --%>

			</form>
	

	<table class="table">

		<thead>
			<tr class="form-group">
				<th style="font-weight:bold; background-color:lightyellow">유저 아이디</th>
				<th style="font-weight:bold; background-color:lightyellow">유저 이름</th>
				<th style="font-weight:bold; background-color:lightyellow">매장아이디</th>
				<th style="font-weight:bold; background-color:lightyellow">매장 이름</th>
				<th style="font-weight:bold; background-color:lightyellow">매장 전화번호</th>
				<th style="font-weight:bold; background-color:lightyellow">매장 주소</th>
				<th style="font-weight:bold; background-color:lightyellow">매장 이메일</th>
				<th style="font-weight:bold; background-color:lightyellow">매장 카테고리</th>
				<th style="font-weight:bold; background-color:lightyellow">매장 허가 여부</th>
				<th style="font-weight:bold; background-color:lightyellow">권한 변경</th>
			</tr>
		</thead>
		<tbody>

			<%-- ######################################################
															조회된 item 출력 
				###################################################### --%>
			<c:forEach items="${requestScope.list }" var="list">

				<tr class="form-group">
					<td>${list.userId}</td>
					<td>${list.userName}</td>
					<td>${list.storeId}</td>
					<td>${list.store.storeName }</td>
					<td>${list.store.storePhone }</td>
					<td>${list.store.storeAddress }</td>
					<td>${list.store.storeEmail }</td>
					<td>${list.store.storeCategory }</td>
					<td>${list.store.storePermission }</td>
					<td>
						<form action="${initParam.rootPath }/admin/storeApproveController.do"
							method="post">
							<input type="hidden" value="${list.userId }" name="userId" /> <input
								type="hidden" value="${list.storeId }" name="storeId" /> <input
								type="hidden" value="${list.store.storePermission }"
								name="storePermission" />
							<button type="submit" class="btn btn-info" >
								<i class="glyphicon glyphicon-pencil"></i>&nbsp;변경
							</button>

							<sec:csrfInput />
							<%-- csrf 토큰 --%>
						</form>
					</td>
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
			href="${initParam.rootPath }/admin/userManagementListController.do?page=1&select=${requestScope.select}&keyword=${requestScope.keyword}">첫페이지</a>


		<!--
			이전 페이지 그룹 처리.
			만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
		 -->
		<c:choose>
			<c:when test="${requestScope.pageBean.previousPageGroup}">
				<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
				<a
					href="${initParam.rootPath }/admin/userManagementListController.do?page=${requestScope.pageBean.beginPage-1}&select=${requestScope.select}&keyword=${requestScope.keyword}">◀</a>
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
						href="${initParam.rootPath }/admin/userManagementListController.do?page=${page}&select=${requestScope.select}&keyword=${requestScope.keyword}">${page }&nbsp;&nbsp;</a>
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
					href="${initParam.rootPath }/admin/userManagementListController.do?page=${requestScope.pageBean.endPage+1}&select=${requestScope.select}&keyword=${requestScope.keyword}">▶</a>
			</c:when>
			<c:otherwise>
			▶
		</c:otherwise>
		</c:choose>




		<!-- 마지막 페이지로 이동 -->
		<a
			href="${initParam.rootPath }/admin/userManagementListController.do?page=${requestScope.pageBean.totalPage}&select=${requestScope.select}&keyword=${requestScope.keyword}">마지막
			페이지</a></p></center></div>
	<div class="col-sm-1"></div>
