<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<style>
form{
display:inline;


}



</style>


</head>
<body>



	
	<div class="col-sm-2"></div>
	<div class="col-sm-8">
	<h1>공지사항</h1>
	<hr>
	<br>
<table class="table">
<tr>
<th>제목</th>
<td  colspan="2">${requestScope.noticeBoardContents.noticeBoardTitle }</td>
<td></td>
</tr>
<tr>
<td width="25%">작성일시</td>
<td width="25%">${requestScope.noticeBoardContents.noticeBoardDateFormat}</td>
<td width="25%">조회수</td>
<td width="25%">${requestScope.noticeBoardContents.noticeBoardHits}</td>

</tr>
</table>
<table>
<tr>

<td><textarea rows="20" cols="120" disabled style="background-color:#FFFFFF">${requestScope.noticeBoardContents.noticeBoardContent }</textarea></td>
</tr>


</table>
	<p />

<sec:authorize access="hasRole('ROLE_CNB_ADMIN')">
<div style="float:right">
	<form
		action="${initParam.rootPath }/admin/modifySettingNoticeBoardContentsController.do"
		method="post">
		<sec:csrfInput />
		<input type="hidden" name="noticeBoardNo"
			value="${requestScope.noticeBoardContents.noticeBoardNo }" />
		<button type="submit" class="btn">
			<i class="glyphicon glyphicon-pencil"></i>수정
		</button>

	</form>

	<form
		action="${initParam.rootPath }/admin/removeNoticeBoardContentsController.do"
		method="post">
		<sec:csrfInput />
		<input type="hidden" name="noticeBoardNo"
			value="${requestScope.noticeBoardContents.noticeBoardNo }" />
		<button type="submit" class="btn">
			<i class="glyphicon glyphicon-trash"></i>삭제
		</button>
	</form>&nbsp;&nbsp;&nbsp;&nbsp;</div></sec:authorize>	</div><div class="col-sm-2"></div>
	

