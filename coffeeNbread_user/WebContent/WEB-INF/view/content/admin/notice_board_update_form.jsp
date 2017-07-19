<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>




<h1>게시글 수정</h1><hr><br>


<form action="${initParam.rootPath }/admin/modifyNoticeBoardContentsController.do" method="post">
	<sec:csrfInput/>
	제목 : <input type="text" name="noticeBoardTitle" value="${requestScope.noticeBoardContents.noticeBoardTitle }"><br>
	내용<br>
	 <textarea rows="20" cols="100" name="noticeBoardContent">
	 	${requestScope.noticeBoardContents.noticeBoardContent }
	 </textarea>
	 <input type="hidden" name="noticeBoardNo" value="${requestScope.noticeBoardContents.noticeBoardNo }"/>
	 
	<p>
	<input type="submit" value="수정">
	</p>
</form>

