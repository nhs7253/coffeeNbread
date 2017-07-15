<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>




<h1>게시글 작성</h1>
<hr>
<br>
<div class="col-sm-1"></div>
	
		<div class="col-sm-10">

<form
	action="${initParam.rootPath }/user/addQnaBoardContentsController.do"
	method="post">
	<sec:csrfInput />
	제목 : <input type="text" name="qnaBoardTitle" required> 비밀글<input
		type="checkbox" name="qnaBoardSecret" value="Y"><br> 내용<br>
	<textarea rows="15" cols="100" name="qnaBoardContent" required></textarea>
	<input type="hidden" name="qnaStoreId" value="${param.storeId }" />
	<p>
		<button type="submit" class="btn btn-custom">
			<i class="glyphicon glyphicon-ok"></i>등록
		</button>
	</p>
</form></div>
<div class="col-sm-1"></div>
