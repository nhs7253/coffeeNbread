<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
form{

display:inline;
}

</style>

<div class="col-sm-2"></div>
	
		<div class="col-sm-8">

<h1>공지사항<i class="glyphicon glyphicon-pencil"></i></h1><hr><br>


<form action="${initParam.rootPath }/admin/addNoticeBoardContentsController.do" method="post">
	<sec:csrfInput/><br>
	제목 : <input type="text" name="noticeBoardTitle" required size="60">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<div  style="float:right">
	<button type="submit" class="btn" style="background-color:#01a207" >
			<i class="glyphicon glyphicon-ok"></i>&nbsp;등록
		</button>
	</div>
	<br><br><br>
	 <textarea rows="18" cols="116" name="noticeBoardContent" required ></textarea>
	
	
</form></div><div class="col-sm-2"></div>
	
	

