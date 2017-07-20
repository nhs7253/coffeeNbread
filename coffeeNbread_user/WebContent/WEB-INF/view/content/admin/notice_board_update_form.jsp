<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<div class="col-sm-2"></div>
	
		<div class="col-sm-8">
<h1>게시글 수정&nbsp;<i class="glyphicon glyphicon-erase"></i></h1><hr><br>


<form action="${initParam.rootPath }/admin/modifyNoticeBoardContentsController.do" method="post">
	<sec:csrfInput/>
	<div class="col-sm-12">
	제목 : <input type="text" name="noticeBoardTitle" value="${requestScope.noticeBoardContents.noticeBoardTitle }" size="70">
	
	<button type="submit" class="btn btn-info" style="float:right">
			<i class="glyphicon glyphicon-pencil"></i>&nbsp;수정
		</button><br><br><br>
	 <textarea rows="18" cols="112" name="noticeBoardContent" style="background-color:transparent">${requestScope.noticeBoardContents.noticeBoardContent }
	 </textarea>
	 <input type="hidden" name="noticeBoardNo" value="${requestScope.noticeBoardContents.noticeBoardNo }"/>
	 <br>
	
	
	</div>
</form></div><div class="col-sm-2"></div>


