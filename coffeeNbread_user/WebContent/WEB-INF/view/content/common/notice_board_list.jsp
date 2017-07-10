<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

</head>
<body>
	
<style type="text/css">
table, td {
   border: 1px solid black;
}

table {
   width: 700px;
   border-collapse: collapse;
}

td {
   padding: 5px; /* //td 간 간격 */
}
</style>
	<h2>공지사항 게시판</h2>



	<form action="${initParam.rootPath }/common/findNoticeBoardContentsPagingListController.do" method="post">
		<select name="select">
			<option value="title" ${param.select eq "title" ? "selected" :""}>제목</option>
			<option value="content" ${param.select eq "content" ? "selected" :""}>내용</option>
			<option value="titleAndcontent" ${param.select eq "titleAndcontent" ? "selected" :""}>제목+내용</option>
		</select> <input type="text" name="keyword" /> <input type="submit" value="검색" />
		<sec:csrfInput/><%-- csrf 토큰 --%>
	</form>
	<br>


	
	<table class="w3-table-all">
		<thead>
			<tr class="w3-blue">
				<th>글번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성일시</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>

			<%-- ######################################################
															조회된 item 출력 
				###################################################### --%>
			<c:forEach items="${requestScope.list }" var="list">

				<tr>
					<td>${list.noticeBoardNo}</td>
					<td>${list.noticeBoardTitle}</td>
					<td><a href="${initParam.rootPath }/common/viewNoticeBoardContentsController.do?noticeBoardNo=${list.noticeBoardNo}">${list.noticeBoardContent}</a></td>
					<td>${list.noticeBoardDateFormat}</td>
					<td>${list.noticeBoardHits}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	




	<p>
		<%--######################################################
															페이징 처리
				###################################################### --%>
		<!-- 첫페이지로 이동 -->
		<a
			href="${initParam.rootPath }/common/findNoticeBoardContentsPagingListController.do?page=1&select=${requestScope.select}&keyword=${requestScope.keyword}">첫페이지</a>


		<!--
			이전 페이지 그룹 처리.
			만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
		 -->
		<c:choose>
			<c:when test="${requestScope.pageBean.previousPageGroup}">
				<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
				<a
					href="${initParam.rootPath }/common/findNoticeBoardContentsPagingListController.do?page=${requestScope.pageBean.beginPage-1}&select=${requestScope.select}&keyword=${requestScope.keyword}">◀</a>
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
						href="${initParam.rootPath }/common/findNoticeBoardContentsPagingListController.do?page=${page}&select=${requestScope.select}&keyword=${requestScope.keyword}">${page }&nbsp;&nbsp;</a>
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
					href="${initParam.rootPath }/common/findNoticeBoardContentsPagingListController.do?page=${requestScope.pageBean.endPage+1}&select=${requestScope.select}&keyword=${requestScope.keyword}">▶</a>
			</c:when>
			<c:otherwise>
			▶
		</c:otherwise>
		</c:choose>




		<!-- 마지막 페이지로 이동 -->
		<a
			href="${initParam.rootPath }/common/findNoticeBoardContentsPagingListController.do?page=${requestScope.pageBean.totalPage}&select=${requestScope.select}&keyword=${requestScope.keyword}">마지막
			페이지</a>

		<p/>
		
		<!-- mvc 로 등록한 뷰패턴은 get 방식으로만 이동이 가능함 -->
		<sec:authorize access="hasRole('ROLE_CNB_ADMIN')">
			<form action="${initParam.rootPath }/admin/notice_board_register_form.do">
				<sec:csrfInput/>
				<input type="submit" value="등록">
			</form>
		</sec:authorize>
