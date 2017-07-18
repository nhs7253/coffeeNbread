<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>




<h1>게시글 수정_</h1>
<hr>
<br>


<div class="col-sm-1"></div>
	
		<div class="col-sm-10">
<form
	action="${initParam.rootPath }/user/modifyQnaBoardContentsController.do"
	method="post">
	<sec:csrfInput />
	제목 : <input type="text" name="qnaBoardTitle"
		value="${requestScope.content.qnaBoardTitle }"> 비밀글<input
		type="checkbox" name="qnaBoardSecret" value="Y"
		${requestScope.content.qnaBoardSecret eq "Y" ? "checked='checked'" :""}><br>
	내용<br>
	<textarea rows="20" cols="100" name="qnaBoardContent">
	 	${requestScope.content.qnaBoardContent }
	 </textarea>
	<input type="hidden" name="qnaBoardNo"
		value="${requestScope.content.qnaBoardNo }" />

	<p>
		<button type="submit" class="btn btn-custom">
			<i class="glyphicon glyphicon-pencil"></i>수정
		</button>
	</p>
</form>
</div>
<div class="col-sm-1"></div>