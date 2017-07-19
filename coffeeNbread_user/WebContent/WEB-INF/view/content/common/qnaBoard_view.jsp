<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<style>
form {
	display: inline;
}
</style>


</head>
<body>



	<h1>게시글 내용</h1>
	<hr>
	<br>
	<div class="col-sm-2"></div>

	<div class="col-sm-8">
		제목 : <input type="text" value="${requestScope.content.qnaBoardTitle }"
			disabled><br> 내용<br>
		<textarea rows="15" cols="100" disabled>
		 	${requestScope.content.qnaBoardContent }
		 </textarea>

		<p />
		<div style="float: right">
			<form
				action="${initParam.rootPath }/user/settingQnaBoardContentsController.do">
				<sec:csrfInput />
				<input type="hidden" name="qnaBoardNo"
					value="${requestScope.content.qnaBoardNo }" /> <input
					type="hidden" name="qnaBoardWriter"
					value="${requestScope.content.qnaBoardWriter }" />
				<button type="submit" class="btn">
					<i class="glyphicon glyphicon-pencil"></i>수정
				</button>
			</form>

			<form
				action="${initParam.rootPath }/user/removeQnaBoardContentsController.do">
				<sec:csrfInput />
				<input type="hidden" name="qnaBoardNo"
					value="${requestScope.content.qnaBoardNo }" /> <input
					type="hidden" name="qnaStoreId"
					value="${requestScope.content.qnaStoreId }" /> <input
					type="hidden" name="qnaBoardWriter"
					value="${requestScope.content.qnaBoardWriter }" />
				<button type="submit" class="btn">
					<i class="glyphicon glyphicon-trash"></i>삭제
				</button>
			</form>


		</div>



		<table class="w3-table-all">
			<tbody>

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
							<form
								action="${initParam.rootPath }/user/modifyBoardReplySettigController.do">
								<sec:csrfInput />
								<input type="hidden" name="replyNo" value=" ${list.replyNo }" />
								<input type="hidden" name="qnaBoardNo"
									value="${requestScope.content.qnaBoardNo }" /> <input
									type="hidden" name="qnaStoreId"
									value=" ${requestScope.content.qnaStoreId }" /> <input
									type="hidden" name="replyName" value="${list.replyName }" />
								<button type="submit" class="btn-custom">
									<i class="glyphicon glyphicon-pencil"></i>수정
								</button>

							</form>&nbsp;&nbsp;&nbsp;
						</td>
						<td>
							<form
								action="${initParam.rootPath }/user/removeBoardReplyToQnaBoardNoController.do">
								<sec:csrfInput />
								<input type="hidden" name="replyNo" value=" ${list.replyNo }" />
								<input type="hidden" name="qnaBoardNo"
									value="${requestScope.content.qnaBoardNo }" /> <input
									type="hidden" name="qnaStoreId"
									value="${requestScope.content.qnaStoreId }" /> <input
									type="hidden" name="replyName" value="${list.replyName }" />
								<button type="submit" class="btn-custom">
									<i class="glyphicon glyphicon-trash"></i>삭제
								</button>

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
					href="${initParam.rootPath }/common/viewQnaBoardContentsByReplyListController.do?page=1&qnaBoardNo=${requestScope.content.qnaBoardNo}">첫페이지</a>


				<!--
			이전 페이지 그룹 처리.
			만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
		 -->
				<c:choose>
					<c:when test="${requestScope.pageBean.previousPageGroup}">
						<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
						<a
							href="${initParam.rootPath }/common/viewQnaBoardContentsByReplyListController.do?page=${requestScope.pageBean.beginPage-1}&qnaBoardNo=${requestScope.content.qnaBoardNo}">◀</a>
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
								href="${initParam.rootPath }/common/viewQnaBoardContentsByReplyListController.do?page=${page}&qnaBoardNo=${requestScope.content.qnaBoardNo}">${page }&nbsp;&nbsp;</a>
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
							href="${initParam.rootPath }/common/viewQnaBoardContentsByReplyListController.do?page=${requestScope.pageBean.endPage+1}&qnaBoardNo=${requestScope.content.qnaBoardNo}">▶</a>
					</c:when>
					<c:otherwise>
			▶
		</c:otherwise>
				</c:choose>




				<!-- 마지막 페이지로 이동 -->
				<a
					href="${initParam.rootPath }/common/viewQnaBoardContentsByReplyListController.do?page=${requestScope.pageBean.totalPage}&qnaBoardNo=${requestScope.content.qnaBoardNo}">마지막
					페이지</a>
			<p />
		</center>
		<form
			action="${initParam.rootPath }/user/addBoardReplyToQnaBoardNoController.do">
			<sec:csrfInput />
			<textarea rows="5" cols="80" name="replyContent" required></textarea>
			<input type="hidden" name="qnaBoardNo"
				value=" ${requestScope.content.qnaBoardNo }" /> <input
				type="hidden" name="qnaStoreId"
				value=" ${requestScope.content.qnaStoreId }" />
			<a><button type="submit" class="btn-custom">
				<i class="glyphicon glyphicon-pencil"></i>댓글 쓰기
			</button></a>


		</form>
	</div>
	<div class="col-sm-2"></div>