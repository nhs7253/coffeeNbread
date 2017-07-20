<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<div class="col-sm-2"></div>
	
		<div class="col-sm-8">
<h1>게시글 수정</h1><hr><br>


<form action="${initParam.rootPath }/admin/modifyNoticeBoardContentsController.do" method="post">
	<sec:csrfInput/>
	<div class="col-sm-12">
	제목 : <input type="text" name="noticeBoardTitle" value="${requestScope.noticeBoardContents.noticeBoardTitle }" size="70"><br>
	<br>
	 <textarea rows="20" cols="100" name="noticeBoardContent" style="background-color:transparent">${requestScope.noticeBoardContents.noticeBoardContent }
	 </textarea>
	 <input type="hidden" name="noticeBoardNo" value="${requestScope.noticeBoardContents.noticeBoardNo }"/>
	 <br>
	
	<button type="submit" class="btn" style="float:right">
			<i class="glyphicon glyphicon-pencil"></i>수정
		</button>
	</div>
</form></div><div class="col-sm-2"></div>


