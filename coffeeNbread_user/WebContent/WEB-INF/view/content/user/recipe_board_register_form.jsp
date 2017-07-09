<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>




<h1>레시피 게시글 목록</h1><hr><br>


<form action="${initParam.rootPath }/user/addRecipeBoardContents.do">
	<sec:csrfInput/>
	제목 : <input type="text" name="recipeBoardTitle" required> <br>
	내용<br>
	 <textarea rows="20" cols="100" name="qnaBoardContent" required></textarea>
	 <input type="hidden" name="qnaStoreId" value="${param.storeId }"/>
	<p>
	<input type="submit" value="등록">
	</p>
</form>

