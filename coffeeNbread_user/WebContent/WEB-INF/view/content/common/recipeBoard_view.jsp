<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<style>
form{
display:inline;
}
</style>
</head>
<body>



	<h1>RECIPE</h1>
	<hr>
	 
	<div class="col-sm-2"></div>
<div class="col-sm-8">
		<div class="col-sm-2"></div>
<div class="col-sm-8">
	<c:forEach items="${requestScope.content.recipeBoardPicture }"
		var="fileName">
		<img src="${initParam.rootPath }/up_image/${fileName }" width="350px"
			height="200px">
	</c:forEach>
<br><br>
	제목 :
	<input type="text" value="${requestScope.content.recipeBoardTitle }"
		disabled>
	<br> 
	<br>
	<textarea rows="10" cols="50" disabled>${requestScope.content.recipeBoardContent }</textarea>

	<p /></div>	<div class="col-sm-2"></div>

<div style="float:right">
	<form
		action="${initParam.rootPath }/user/settingRecipeBoardContentsController.do">
		<sec:csrfInput />
		<input type="hidden" name="recipeBoardNo"
			value="${requestScope.content.recipeBoardNo }" /> <input
			type="hidden" name="recipeBoardPicture"
			value="${requestScope.content.recipeBoardPicture }" /> <input
			type="hidden" name="userId" value="${requestScope.content.userId }" />
		<button type="submit" class="btn">
			<i class="glyphicon glyphicon-pencil"></i>수정
		</button>
	</form>

	<form
		action="${initParam.rootPath }/user/removeRecipeBoardContentsController.do">
		<sec:csrfInput />
		<input type="hidden" name="recipeBoardNo"
			value="${requestScope.content.recipeBoardNo }" /> <input
			type="hidden" name="storeId" value="${requestScope.content.storeId }" />
		<input type="hidden" name="userId"
			value="${requestScope.content.userId }" />
		<button type="submit" class="btn">
			<i class="glyphicon glyphicon-trash"></i>삭제
		</button>
	</form>

</div>




	<table class="table table-hover">
		<tbody>

			<c:forEach items="${requestScope.list }" var="list">
				<tr>
					<td>${list.replyNo}</td>
					<td>${list.replyContent}</td>
					<td>${list.replyName}</td>
					<td>${list.replyRegDateFormat}</td>
					<td>
						<form
							action="${initParam.rootPath }/user/modifyBoardReplySettigToRecipeController.do">
							<sec:csrfInput />
							<input type="hidden" name="replyNo" value=" ${list.replyNo }" />
							<input type="hidden" name="recipeBoardNo"
								value="${requestScope.content.recipeBoardNo }" /> <input
								type="hidden" name="storeId"
								value=" ${requestScope.content.storeId }" /> <input
								type="hidden" name="replyName" value="${list.replyName }" />
							<button type="submit" class="btn-custom">
								<i class="glyphicon glyphicon-pencil"></i>수정
							</button>
						</form>
					</td>
					<td>
						<form
							action="${initParam.rootPath }/user/removeRecipeBoardContents.do">
							<sec:csrfInput />
							<input type="hidden" name="replyNo" value=" ${list.replyNo }" />
							<input type="hidden" name="recipeBoardNo"
								value="${requestScope.content.recipeBoardNo }" /> <input
								type="hidden" name="storeId"
								value="${requestScope.content.storeId }" /> <input
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
	<form
		action="${initParam.rootPath }/user/addBoardReplyToRecipeBoardNoController.do">
		<sec:csrfInput />
		<textarea rows="2" cols="80" name="replyContent" required></textarea>
		<input type="hidden" name="recipeBoardNo"
			value=" ${requestScope.content.recipeBoardNo }" /> <input
			type="hidden" name="storeId"
			value=" ${requestScope.content.storeId }" /> <input type="submit"
			value="댓글 쓰기">
	</form>
<center>
	<p>
		<%--######################################################
															페이징 처리
				###################################################### --%>
		<!-- 첫페이지로 이동 -->
		<a
			href="${initParam.rootPath }/common/viewRecipeBoardContentsByReplyListController.do?page=1&recipeBoardNo=${requestScope.content.recipeBoardNo}">첫페이지</a>


		<!--
			이전 페이지 그룹 처리.
			만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
		 -->
		<c:choose>
			<c:when test="${requestScope.pageBean.previousPageGroup}">
				<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
				<a
					href="${initParam.rootPath }/common/viewRecipeBoardContentsByReplyListController.do?page=${requestScope.pageBean.beginPage-1}&recipeBoardNo=${requestScope.content.recipeBoardNo}">◀</a>
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
						href="${initParam.rootPath }/common/viewRecipeBoardContentsByReplyListController.do?page=${page}&recipeBoardNo=${requestScope.content.recipeBoardNo}">${page }&nbsp;&nbsp;</a>
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
					href="${initParam.rootPath }/common/viewRecipeBoardContentsByReplyListController.do?page=${requestScope.pageBean.endPage+1}&recipeBoardNo=${requestScope.content.recipeBoardNo}">▶</a>
			</c:when>
			<c:otherwise>
			▶
		</c:otherwise>
		</c:choose>




		<!-- 마지막 페이지로 이동 -->
		<a
			href="${initParam.rootPath }/common/viewRecipeBoardContentsByReplyListController.do?page=${requestScope.pageBean.totalPage}&qnaBoardNo=${requestScope.content.recipeBoardNo}">마지막
			페이지</a>
	<p /></center>
	</div><div class="col-sm-2"></div>
