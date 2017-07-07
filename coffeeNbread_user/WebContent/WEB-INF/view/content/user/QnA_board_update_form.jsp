<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>




<h1>게시글 수정</h1><hr><br>


<form action="${initParam.rootPath }/user/modifyQnaBoardContents.do">
	<sec:csrfInput/>
	제목 : <input type="text" name="qnaBoardTitle" value="${sessionScope.content.qnaBoardTitle }"> 비밀글<input type="checkbox" name="qnaBoardSecret" value="Y"><br>
	내용<br>
	 <textarea rows="20" cols="100" name="qnaBoardContent">
	 	${sessionScope.content.qnaBoardContent }
	 </textarea>
	<p>
	<input type="submit" value="수정">
	</p>
</form>

