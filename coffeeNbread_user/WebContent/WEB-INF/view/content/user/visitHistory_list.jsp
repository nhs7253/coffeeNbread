<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<style type="text/css">
th{

text-align:center;
}


table {
	width: 700px;
	border-collapse: collapse;
	
}

td {
	padding: 5px; /* //td 간 간격 */
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

</head>
<body>

<br><br>
	<h2><img src="${initParam.rootPath }/resource/css/shopping-store.png">&nbsp;방문 내역</h2>
	
		<div class="col-sm-12">
			<form
				action="${initParam.rootPath }/user/findStoreVisitHistoryListByKeywordController.do"
				method="post" class="form-inline quick-search-form" role="form">
				<div style="float:right">
				<div class="form-group">
					<input type="text" name="keyword" class="form-control" />
				</div>
				<button type="submit" class="btn" style="background-color:#FFCC33">
					<i class="glyphicon glyphicon-search"></i>&nbsp;검색
				</button>
				</div>
				<sec:csrfInput />
				<%-- csrf 토큰 --%>
			</form>
	
	<br>
		<table class="table table-hover">
			<thead>
				<tr class="form-group">
					<th style="font-weight:bold; background-color:lightyellow">이름</th>
					<th style="font-weight:bold; background-color:lightyellow">전화번호</th>
					<th style="font-weight:bold; background-color:lightyellow">주소</th>
					<th style="font-weight:bold; background-color:lightyellow">이메일</th>
					<th style="font-weight:bold; background-color:lightyellow">조회수</th>
					<th style="font-weight:bold; background-color:lightyellow">여는 시간</th>
					<th style="font-weight:bold; background-color:lightyellow">닫는 시간</th>
				</tr>
			</thead>
			<tbody>

				<%-- ######################################################
																조회된 item 출력 
					###################################################### --%>
				<c:forEach items="${requestScope.list }" var="list">
					<tr class="">
						<td style="text-align:center;"><a
							href="${initParam.rootPath }/common/viewStoreController.do?storeId=${list.store.storeId}">${list.store.storeName}</a></td>
						<td style="text-align:center;">${list.store.storePhone}</td>
						<td>${list.store.storeAddress}</td>
						<td style="text-align:center;">${list.store.storeEmail}</td>
						<td style="text-align:center;">${list.store.storeHits}</td>
						<td style="text-align:center;">${list.store.storeOpenFormat}</td>
						<td style="text-align:center;">${list.store.storeCloseFormat}</td>
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
			href="${initParam.rootPath }/user/findStoreVisitHistoryListByKeywordController.do?page=1&keyword=${requestScope.keyword}">첫페이지</a>


		<!--
			이전 페이지 그룹 처리.
			만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
		 -->
		<c:choose>
			<c:when test="${requestScope.pageBean.previousPageGroup}">
				<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
				<a
					href="${initParam.rootPath }/user/findStoreVisitHistoryListByKeywordController.do?page=${requestScope.pageBean.beginPage-1}&keyword=${requestScope.keyword}">◀</a>
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
						href="${initParam.rootPath }/user/findStoreVisitHistoryListByKeywordController.do?page=${page}&keyword=${requestScope.keyword}">${page }&nbsp;&nbsp;</a>
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
					href="${initParam.rootPath }/user/findStoreVisitHistoryListByKeywordController.do?page=${requestScope.pageBean.endPage+1}&keyword=${requestScope.keyword}">▶</a>
			</c:when>
			<c:otherwise>
			▶
		</c:otherwise>
		</c:choose>




		<!-- 마지막 페이지로 이동 -->
		<a
			href="${initParam.rootPath }/user/findStoreVisitHistoryListByKeywordController.do?page=${requestScope.pageBean.totalPage}&keyword=${requestScope.keyword}">마지막
			페이지</a></center>
			</div>
			