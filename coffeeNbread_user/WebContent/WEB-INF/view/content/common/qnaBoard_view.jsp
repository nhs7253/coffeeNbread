<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<style>
form {
	display: inline;
}
@font-face {
	font-family: 'title';
	src: local(※), url(${initParam.rootPath }/resource/font/a시나리오.woff) format('woff');
}

h1 {
	font-family: 'title';
	font-size: 60px
}
</style>


</head>
<body>



	
	
	<br>
	<div class="col-sm-2"></div>

	<div class="col-sm-8">
	<h1><img src="${initParam.rootPath }/resource/css/qa.png">&nbsp;Q&A</h1>
	<br><br>
		제목 : <input type="text" value="${requestScope.content.qnaBoardTitle }"
			disabled style="background-color:transparent; border:0" size="60">

		
			<c:if test="${requestScope.modifyAuthority }">
				<form
					action="${initParam.rootPath }/user/settingQnaBoardContentsController.do">
					<sec:csrfInput />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
					<input type="hidden" name="qnaBoardNo"
						value="${requestScope.content.qnaBoardNo }" /> <input
						type="hidden" name="qnaBoardWriter"
						value="${requestScope.content.qnaBoardWriter }" />
					<button type="submit" class="btn btn-info" >
						<i class="glyphicon glyphicon-pencil"></i>&nbsp;수정
					</button>
				</form>
			</c:if>
			
			<c:if test="${requestScope.removeAuthority }">
				<form action="${initParam.rootPath }/user/removeQnaBoardContentsController.do">
					<sec:csrfInput />
					<input type="hidden" name="qnaBoardNo"
						value="${requestScope.content.qnaBoardNo }" /> <input
						type="hidden" name="qnaStoreId"
						value="${requestScope.content.qnaStoreId }" /> <input
						type="hidden" name="qnaBoardWriter"
						value="${requestScope.content.qnaBoardWriter }" />
					<button type="submit" class="btn btn-danger" >
						<i class="glyphicon glyphicon-trash"></i>&nbsp;삭제
					</button>
				</form>
			</c:if>

		
<br>내용<br>

		<textarea style="background-color:transparent; border:0" rows="15" cols="100" disabled>${requestScope.content.qnaBoardContent }</textarea>
		
		<table class="w3-table-all">
		
			<tbody>
				<br>댓글 <br>
				<%-- ######################################################
															조회된 item 출력 
				###################################################### --%>
				<c:forEach items="${requestScope.list }" var="list">
					<tr>
						<td>${list.replyNo}&nbsp;&nbsp;&nbsp;</td>
						<td>${list.replyContent}&nbsp;&nbsp;&nbsp;</td>
						<td>${list.replyName}&nbsp;&nbsp;&nbsp;</td>
						<td>${list.replyRegDateFormat}&nbsp;&nbsp;&nbsp;</td>
						<td>
								<form action="${initParam.rootPath }/user/modifyBoardReplySettigController.do">
									<sec:csrfInput />
									<input type="hidden" name="replyNo" value=" ${list.replyNo }" />
									<input type="hidden" name="qnaBoardNo"
										value="${requestScope.content.qnaBoardNo }" /> <input
										type="hidden" name="qnaStoreId"
										value=" ${requestScope.content.qnaStoreId }" /> <input
										type="hidden" name="replyName" value="${list.replyName }" />
										<input
											type="hidden" name="qnaBoardWriter"
										value="${requestScope.content.qnaBoardWriter }" />
									<button type="submit" class="btn-custom">
										<i class="glyphicon glyphicon-pencil"></i>
									</button>
								</form>&nbsp;&nbsp;&nbsp;
						</td>
						<td>
								<form action="${initParam.rootPath }/user/removeBoardReplyToQnaBoardNoController.do">
									<sec:csrfInput />
									<input type="hidden" name="replyNo" value=" ${list.replyNo }" />
									<input type="hidden" name="qnaBoardNo"
										value="${requestScope.content.qnaBoardNo }" /> <input
										type="hidden" name="qnaStoreId"
										value="${requestScope.content.qnaStoreId }" /> <input
										type="hidden" name="replyName" value="${list.replyName }" />
										<input
											type="hidden" name="qnaBoardWriter"
											value="${requestScope.content.qnaBoardWriter }" />
									<button type="submit" class="btn-custom">
										<i class="glyphicon glyphicon-trash"></i>
									</button>
								</form>
							
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

<br><br>

<sec:authorize access="hasAnyRole('ROLE_CNB_USER,ROLE_CNB_STORE,ROLE_CNB_ADMIN')">
			<form
				action="${initParam.rootPath }/user/addBoardReplyToQnaBoardNoController.do">
				<sec:csrfInput />
				<textarea rows="5" cols="80" name="replyContent" required ></textarea>
				<input type="hidden" name="qnaBoardNo"
					value="${requestScope.content.qnaBoardNo }" /> 
				<input
					type="hidden" name="qnaStoreId"
					value="${requestScope.content.qnaStoreId }" />
				<input
					type="hidden" name="qnaBoardWriter"
					value="${requestScope.content.qnaBoardWriter }" />
				<a><button type="submit" class="btn-custom">
					<i class="glyphicon glyphicon-pencil"></i>댓글 쓰기
				</button></a>
			</form>
		</sec:authorize>


<br><br>
		<center>

			<p>
				<%--######################################################
															페이징 처리
				###################################################### --%>
				<!-- 첫페이지로 이동 -->
				<a
					href="${initParam.rootPath }/common/viewQnaBoardContentsByReplyListController.do?page=1&qnaBoardNo=${requestScope.content.qnaBoardNo}&qnaBoardWriter=${requestScope.content.qnaBoardWriter }">첫페이지</a>


				<!--
			이전 페이지 그룹 처리.
			만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
		 -->
				<c:choose>
					<c:when test="${requestScope.pageBean.previousPageGroup}">
						<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
						<a
							href="${initParam.rootPath }/common/viewQnaBoardContentsByReplyListController.do?page=${requestScope.pageBean.beginPage-1}&qnaBoardNo=${requestScope.content.qnaBoardNo}&qnaBoardWriter=${requestScope.content.qnaBoardWriter }">◀</a>
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
								href="${initParam.rootPath }/common/viewQnaBoardContentsByReplyListController.do?page=${page}&qnaBoardNo=${requestScope.content.qnaBoardNo}&qnaBoardWriter=${requestScope.content.qnaBoardWriter }">${page }&nbsp;&nbsp;</a>
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
							href="${initParam.rootPath }/common/viewQnaBoardContentsByReplyListController.do?page=${requestScope.pageBean.endPage+1}&qnaBoardNo=${requestScope.content.qnaBoardNo}&qnaBoardWriter=${requestScope.content.qnaBoardWriter }">▶</a>
					</c:when>
					<c:otherwise>
			▶
		</c:otherwise>
				</c:choose>




				<!-- 마지막 페이지로 이동 -->
				<a
					href="${initParam.rootPath }/common/viewQnaBoardContentsByReplyListController.do?page=${requestScope.pageBean.totalPage}&qnaBoardNo=${requestScope.content.qnaBoardNo}&qnaBoardWriter=${requestScope.content.qnaBoardWriter }">마지막
					페이지</a>
			<p />
		</center>
		
		
	</div>
	<div class="col-sm-2"></div>