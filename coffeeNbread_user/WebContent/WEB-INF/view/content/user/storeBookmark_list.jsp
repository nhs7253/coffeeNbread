<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<style type="text/css">

table {
	width: 700px;
	border-collapse: collapse;
}
th,td{

text-align:center;
}

td {
	padding: 5px; /* //td 간 간격 */
}
@font-face {
	font-family: 'title';
	src: local(※), url(http://127.0.0.1:8088/coffeeNbread_user/resource/font/a시나리오.woff) format('woff');
}

h2 {
	font-family: 'title';
	font-size: 60px
}
</style>

</head>
<body>

<br><br>
	<h2><img src="http://127.0.0.1:8088/coffeeNbread_user/resource/css/bookmark.png">&nbsp;즐겨찾기</h2>
	

<div class="col-sm-12">
	
			<form
				action="${initParam.rootPath }/user/findStoreBookmarkListByKeywordController.do"
				method="post" >
				<div style="float:right">
				<div class="form-group col-xs-8" >
					<input type="text" name="keyword" class="form-control" /></div>
				<button type="submit" class="btn form-group col-xs-4" style="background-color:#FFCC33">
					<i class="glyphicon glyphicon-search"></i>&nbsp;검색
				</button>
				</div>
				<sec:csrfInput />
				<%-- csrf 토큰 --%>
			</form>
	
	<br>
	<form
		action="${initParam.rootPath }/user/selectRemoveStoreBookmarkController.do"
		method="post">
		<sec:csrfInput />
		<%-- csrf 토큰 --%>

		<table class="table table-hover">
			<thead>
				<tr>
					<th>이름</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>이메일</th>
					<th>조회수</th>
					<th>여는 시간</th>
					<th>닫는 시간</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>

				<%-- ######################################################
																조회된 item 출력 
					###################################################### --%>
				<c:forEach items="${requestScope.list }" var="list">

					<tr>
						<td><a
							href="${initParam.rootPath }/common/viewStoreController.do?storeId=${list.store.storeId}">${list.store.storeName}</a></td>
						<td>${list.store.storePhone}</td>
						<td>${list.store.storeAddress}</td>
						<td>${list.store.storeEmail}</td>
						<td>${list.store.storeHits}</td>
						<td>${list.store.storeOpenFormat}</td>
						<td>${list.store.storeCloseFormat}</td>
						<td><input type="checkbox" name="storeIdList"
							value="${list.store.storeId}"></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
				<button type="submit" class="btn btn-danger" style="float:right"><i class="glyphicon glyphicon-trash"></i>&nbsp;삭제</button>
	</form>




<center>
	<p>
		<%--######################################################
															페이징 처리
				###################################################### --%>
		<!-- 첫페이지로 이동 -->
		<a
			href="${initParam.rootPath }/user/findStoreBookmarkListByKeywordController.do?page=1&keyword=${requestScope.keyword}">첫페이지</a>


		<!--
			이전 페이지 그룹 처리.
			만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
		 -->
		<c:choose>
			<c:when test="${requestScope.pageBean.previousPageGroup}">
				<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
				<a
					href="${initParam.rootPath }/user/findStoreBookmarkListByKeywordController.do?page=${requestScope.pageBean.beginPage-1}&keyword=${requestScope.keyword}">◀</a>
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
						href="${initParam.rootPath }/user/findStoreBookmarkListByKeywordController.do?page=${page}&keyword=${requestScope.keyword}">${page }&nbsp;&nbsp;</a>
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
					href="${initParam.rootPath }/user/findStoreBookmarkListByKeywordController.do?page=${requestScope.pageBean.endPage+1}&keyword=${requestScope.keyword}">▶</a>
			</c:when>
			<c:otherwise>
			▶
		</c:otherwise>
		</c:choose>




		<!-- 마지막 페이지로 이동 -->
		<a
			href="${initParam.rootPath }/user/findStoreBookmarkListByKeywordController.do?page=${requestScope.pageBean.totalPage}&keyword=${requestScope.keyword}">마지막
			페이지</a>
				</div></center></body>
			