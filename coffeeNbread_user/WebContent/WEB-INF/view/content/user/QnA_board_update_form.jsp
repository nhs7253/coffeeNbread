<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<style type="text/css">

@font-face {
	font-family: 'title';
	src: local(※), url(${initParam.rootPath }/resource/font/a시나리오.woff) format('woff');
}

h1 {
	font-family: 'title';
	font-size: 60px
}
</style>




<div class="col-sm-1"></div>
	
		<div class="col-sm-10">

<br><div class="col-sm-1"></div>
	
		<div class="col-sm-10">
				<h1><img src="${initParam.rootPath }/resource/css/qa.png">&nbsp;Q&A 수정</h1>
		<br><br>
<form
	action="${initParam.rootPath }/user/modifyQnaBoardContentsController.do"
	method="post">
	<sec:csrfInput />
	
	제목 : <input type="text" name="qnaBoardTitle"
		value="${requestScope.content.qnaBoardTitle }" style="background-color:transparent" size="60"><img src="${initParam.rootPath }/resource/css/locked.png">&nbsp;비밀글&nbsp;<input
		type="checkbox" name="qnaBoardSecret" value="Y"
		${requestScope.content.qnaBoardSecret eq "Y" ? "checked='checked'" :""}>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="submit" class="btn btn-info">
			<i class="glyphicon glyphicon-pencil"></i>&nbsp;수정
		</button>
	<br>
	<br>
	<textarea rows="20" cols="100" name="qnaBoardContent" style="background-color:transparent">${requestScope.content.qnaBoardContent }
	 </textarea><br>
	<input type="hidden" name="qnaBoardNo"
		value="${requestScope.content.qnaBoardNo }" />
	<input type="hidden" name="qnaBoardWriter"
		value="${requestScope.content.qnaBoardWriter }" />
	
		
</form></div><div class="col-sm-1"></div>
	
</div>
<div class="col-sm-1"></div>