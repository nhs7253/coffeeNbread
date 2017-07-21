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


<br>
<div class="col-sm-1"></div>
	
		<div class="col-sm-10">

<form
	action="${initParam.rootPath }/user/addQnaBoardContentsController.do"
	method="post"><div class="col-sm-1"></div>
		<div class="col-sm-10">
		<h1>Q&A <i class="glyphicon glyphicon-pencil"></i></h1>
		<br>
			<sec:csrfInput />
			
			제목 : <input type="text" name="qnaBoardTitle" required size="60"> <img src="${initParam.rootPath }/resource/css/locked.png">&nbsp;비밀글&nbsp;<input
				type="checkbox" name="qnaBoardSecret" value="Y">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" class="btn btn-custom" style="background-color:#01A207">
					<i class="glyphicon glyphicon-ok"></i>&nbsp;등록
				</button>
			
				<br><br>
			<textarea rows="13" cols="100" name="qnaBoardContent" required></textarea>
			<input type="hidden" name="qnaStoreId" value="${param.storeId }" />
			<br><br>
			
		</div>
		<div class="col-sm-1"></div>
</form></div>
<div class="col-sm-1"></div>
