<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>




<h1>게시글 수정</h1><hr><br>


<form action="${initParam.rootPath }/user/modifyRecipeBoardContents.do">
	<sec:csrfInput/>
	제목 : <input type="text" name="recipeBoardTitle" value="${requestScope.content.recipeBoardTitle }"> 
	내용<br>
	 <textarea rows="20" cols="100" name="recipeBoardContent">
	 	${requestScope.content.recipeBoardContent }
	 </textarea>
	 <input type="hidden" name="recipeBoardNo" value="${requestScope.content.recipeBoardNo }"/>
	 
	<p>
	<input type="submit" value="수정">
	</p>
</form>

