<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>




<h1>공지사항 게시글 작성</h1><hr><br>


<form action="${initParam.rootPath }/admin/addNoticeBoardContentsController.do" method="post">
	<sec:csrfInput/>
	제목 : <input type="text" name="noticeBoardTitle" required><br>
	내용<br>
	 <textarea rows="20" cols="100" name="noticeBoardContent" required></textarea>
	<p>
	<input type="submit" value="등록">
	</p>
</form>

