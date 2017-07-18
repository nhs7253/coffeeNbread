<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>



</head>
<body>



	<h1>공지사항 내용</h1>
	<hr>
	<br> 제목 :
	<input type="text"
		value="${requestScope.noticeBoardContents.noticeBoardTitle }" disabled>
	<br> 내용
	<br>
	<textarea rows="20" cols="100" disabled>
		 	${requestScope.noticeBoardContents.noticeBoardContent }
		 </textarea>

	<p />
	
	<sec:authorize access="hasRole('ROLE_CNB_ADMIN')">
	     <form
			action="${initParam.rootPath }/admin/modifySettingNoticeBoardContentsController.do"
			method="post">
			<sec:csrfInput />
			<input type="hidden" name="noticeBoardNo"
				value="${requestScope.noticeBoardContents.noticeBoardNo }" />
			<button type="submit" class="btn-custom">
				<i class="glyphicon glyphicon-pencil"></i>수정
			</button>
	
		</form>
	
		<form
			action="${initParam.rootPath }/admin/removeNoticeBoardContentsController.do"
			method="post">
			<sec:csrfInput />
			<input type="hidden" name="noticeBoardNo"
				value="${requestScope.noticeBoardContents.noticeBoardNo }" />
			<button type="submit" class="btn-custom">
				<i class="glyphicon glyphicon-trash"></i>삭제
			</button>
		</form>
    </sec:authorize>

	