<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>







<div class="col-sm-1"></div>
	
		<div class="col-sm-10">
		<h1>게시글 수정_</h1>
<hr>
<br><div class="col-sm-1"></div>
	
		<div class="col-sm-10">
<form
	action="${initParam.rootPath }/user/modifyQnaBoardContentsController.do"
	method="post">
	<sec:csrfInput />
	
	제목 : <input type="text" name="qnaBoardTitle"
		value="${requestScope.content.qnaBoardTitle }" style="background-color:transparent"> 비밀글<input
		type="checkbox" name="qnaBoardSecret" value="Y"
		${requestScope.content.qnaBoardSecret eq "Y" ? "checked='checked'" :""}><br>
	내용<br>
	<textarea rows="20" cols="100" name="qnaBoardContent" style="background-color:transparent">${requestScope.content.qnaBoardContent }
	 </textarea><br>
	<input type="hidden" name="qnaBoardNo"
		value="${requestScope.content.qnaBoardNo }" />
	<input type="hidden" name="qnaBoardWriter"
		value="${requestScope.content.qnaBoardWriter }" />
	<div style="float:right">
		<button type="submit" class="btn btn-custom">
			<i class="glyphicon glyphicon-pencil"></i>수정
		</button>
	</div>
		
</form></div><div class="col-sm-1"></div>
	
</div>
<div class="col-sm-1"></div>