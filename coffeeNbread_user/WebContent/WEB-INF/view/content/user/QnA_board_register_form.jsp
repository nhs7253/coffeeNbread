<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>




<h1>게시글 작성</h1><hr><br>


<form action="${initParam.rootPath }/user/addQnaBoardContents.do">
	<sec:csrfInput/>
	제목 : <input type="text" name="qnaBoardTitle" required> 비밀글<input type="checkbox" name="qnaBoardSecret" value="Y"><br>
	내용<br>
	 <textarea rows="20" cols="100" name="qnaBoardContent" required></textarea>
	 <input type="hidden" name="qnaStoreId" value="${param.storeId }"/>
	<p>
	<input type="submit" value="등록">
	</p>
</form>

