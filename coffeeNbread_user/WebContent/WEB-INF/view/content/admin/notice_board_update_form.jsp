<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>




<h1>게시글 수정_</h1>
<hr>
<br>

<div class="col-sm-2"></div>

<div class="col-sm-8">

	<form
		action="${initParam.rootPath }/admin/modifyNoticeBoardContentsController.do"
		method="post">
		<sec:csrfInput />
		<table class="table">
			<tr>
				<th>제목</th>
				<td><input type="text" name="noticeBoardTitle"
					value="${requestScope.noticeBoardContents.noticeBoardTitle }" size="70"></td>
			</tr>

			<tr>
			<th>내용</th>
			<td>
			<textarea rows="20" cols="100" name="noticeBoardContent">
	 	${requestScope.noticeBoardContents.noticeBoardContent }
	 </textarea></td>
			
			
				
			</table>
			<input type="hidden" name="noticeBoardNo"
				value="${requestScope.noticeBoardContents.noticeBoardNo }" />
			<div style="float:right">
			<button type="submit" class="btn">
			<i class="glyphicon glyphicon-pencil"></i>수정
		</button>
			</div>
			</form>
			</div>
			<div class="col-sm-2"></div>