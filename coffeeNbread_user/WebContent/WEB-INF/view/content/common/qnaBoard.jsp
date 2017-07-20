<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

</head>
<body>

	<style type="text/css">
form{
display:inline;
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
	src: local(※), url(http://127.0.0.1:8088/coffeeNbread_user/resource/font/a시나리오.woff) format('woff');
}

h2 {
	font-family: 'title';
	font-size: 45px
}
</style>
	
<div class="col-sm-1"></div>
		<div class="col-sm-10">
		<br><br>
		<h2>${sessionScope.storeName }Q&A 게시판</h2>
		
	<div style="float:right">
			<form action="${initParam.rootPath }/common/findQnaBoardContentsBySelectToKeywordController.do"
				method="post" class="form-inline quick-search-form" role="form">
				<div class="form-group">
					<select name="select" class="form-control col-xs-2">
						<option value="title">제목</option>
						<option value="content">내용</option>
						<option value="titleAndcontent">제목+내용</option>
					</select> <input type="text" name="keyword" class="form-control" />
				</div>
				<button type="submit" class="btn" style="background-color:#FFCC33"> 
					<i class="glyphicon glyphicon-search"></i>&nbsp;검색
				</button>
				<sec:csrfInput />
				<%-- csrf 토큰 --%>
			</form>

			
			<form action="${initParam.rootPath }/user/QnA_board_register_form.do">
				<sec:csrfInput/>
				<input type="hidden" name="storeId" value="${requestScope.storeId }"/>
				<button type="submit" class="btn" style="background-color:#fa8072">
						<i class="glyphicon glyphicon-pencil"></i>&nbsp;글쓰기
				</button>
			</form>
</div>

		

			<table class="table table-hover">
				<thead>
					<tr >
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
						<th>비밀글</th>
					</tr>
				</thead>
				<tbody>

					<%-- ######################################################
															조회된 item 출력 
				###################################################### --%>
					<c:forEach items="${requestScope.list }" var="list">
						<tr>
							<td>${list.qnaBoardNo}</td>
							<td><a href="${initParam.rootPath }/common/viewQnaBoardContentsByReplyListController.do?qnaBoardNo=${list.qnaBoardNo}&qnaStoreId=${list.qnaStoreId}&qnaBoardWriter=${list.qnaBoardWriter}">${list.qnaBoardTitle}</a></td>
							<td>${list.qnaBoardWriter}</td>
							<td>${list.qnaBoardDateFormat}</td>
							<td>${list.qnaBoardHits}</td>
							<td>${list.qnaBoardSecret}</td>
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
					href="${initParam.rootPath }/common/findQnaBoardContentsBySelectToKeywordController.do?page=1&select=${requestScope.select}&keyword=${requestScope.keyword}&storeId=${requestScope.storeId}">첫페이지</a>


				<!--
			이전 페이지 그룹 처리.
			만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
		 -->
				<c:choose>
					<c:when test="${requestScope.pageBean.previousPageGroup}">
						<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
						<a
							href="${initParam.rootPath }/common/findQnaBoardContentsBySelectToKeywordController.do?page=${requestScope.pageBean.beginPage-1}&select=${requestScope.select}&keyword=${requestScope.keyword}&storeId=${requestScope.storeId}">◀</a>
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
								href="${initParam.rootPath }/common/findQnaBoardContentsBySelectToKeywordController.do?page=${page}&select=${requestScope.select}&keyword=${requestScope.keyword}&storeId=${requestScope.storeId}">${page }&nbsp;&nbsp;</a>
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
							href="${initParam.rootPath }/common/findQnaBoardContentsBySelectToKeywordController.do?page=${requestScope.pageBean.endPage+1}&select=${requestScope.select}&keyword=${requestScope.keyword}&storeId=${requestScope.storeId}">▶</a>
					</c:when>
					<c:otherwise>
			▶
		</c:otherwise>
				</c:choose>




				<!-- 마지막 페이지로 이동 -->
				<a
					href="${initParam.rootPath }/common/findQnaBoardContentsBySelectToKeywordController.do?page=${requestScope.pageBean.totalPage}&select=${requestScope.select}&keyword=${requestScope.keyword}&storeId=${requestScope.storeId}">마지막
					페이지</a></p></center>
	
		</div>
	<div class="col-sm-1"></div>