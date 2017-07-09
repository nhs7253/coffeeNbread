<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



</head>
<body>
	

	
	<h1>공지사항 내용</h1><hr><br>
	
		제목 : <input type="text" value="${requestScope.noticeBoardContents.noticeBoardTitle }" disabled><br>
		내용<br>
		 <textarea rows="20" cols="100" disabled>
		 	${requestScope.noticeBoardContents.noticeBoardContent }
		 </textarea>
		
		<p/>
		
		<form action="${initParam.rootPath }/admin/modifySettingNoticeBoardContentsController.do" method="post">
			<sec:csrfInput/>
			<input type="hidden" name="noticeBoardNo" value="${requestScope.noticeBoardContents.noticeBoardNo }"/>
			<input type="submit" value="수정">
		</form>
		
		<form action="${initParam.rootPath }/admin/removeNoticeBoardContentsController.do" method="post">
			<sec:csrfInput/>
			<input type="hidden" name="noticeBoardNo" value="${requestScope.noticeBoardContents.noticeBoardNo }"/>
			<input type="submit" value="삭제">
		</form>
	

	