<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>




<br>
<div class="col-sm-1"></div>
	
		<div class="col-sm-10">

<form
	action="${initParam.rootPath }/user/addQnaBoardContentsController.do"
	method="post"><div class="col-sm-1"></div>
		<div class="col-sm-10">
		<h1>Q&A <i class="glyphicon glyphicon-pencil"></i></h1>
		<br><br><br>
			<sec:csrfInput />
			
			제목 : <input type="text" name="qnaBoardTitle" required size="60"> 비밀글<input
				type="checkbox" name="qnaBoardSecret" value="Y">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" class="btn btn-custom" style="background-color:#01A207">
					<i class="glyphicon glyphicon-ok"></i>&nbsp;등록
				</button>
			
				<br> 
			<textarea rows="13" cols="100" name="qnaBoardContent" required></textarea>
			<input type="hidden" name="qnaStoreId" value="${param.storeId }" />
			<br><br>
			
		</div>
		<div class="col-sm-1"></div>
</form></div>
<div class="col-sm-1"></div>
