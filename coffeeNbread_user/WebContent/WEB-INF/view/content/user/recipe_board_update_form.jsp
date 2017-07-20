<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>





<div class="col-sm-2"></div>
	
		<div class="col-sm-8">
				

<form action="${initParam.rootPath }/user/modifyRecipeBoardContents.do"
	method="post" enctype="multipart/form-data">
	<sec:csrfInput />
	<div class="col-sm-6">
		
	<center><h1>레시피 수정&nbsp;<i class="glyphicon glyphicon-erase"></i></h1></center>
	<hr>
<br>
	<c:forEach items="${requestScope.content.recipeBoardPicture }"
		var="fileName">
		<img src="${initParam.rootPath }/up_image/${fileName }" width="350px"
			height="200px">
	</c:forEach>
	
	<input type="file" name="recipeBoardPicture">
	</div>
	<div class="col-sm-6">
	<br>
			<br>
			<br><br>
			
	 제목 : <input	type="text" name="recipeBoardTitle"
		value="${requestScope.content.recipeBoardTitle }"> 내용<br>
	<br>
	<textarea rows="10" cols="54" name="recipeBoardContent" style="background-color:transparent">${requestScope.content.recipeBoardContent }</textarea>
	<input type="hidden" name="recipeBoardNo"
		value="${requestScope.content.recipeBoardNo }" />
	<input type="hidden" name="userId"
	value="${requestScope.userId }" />
</div><br><br><br><br><br><br><br><br><br><br><br>
<div style="float:right">
		<button type="submit" class="btn btn-info">
			<i class="glyphicon glyphicon-pencil"></i>&nbsp;수정
		</button>
</div>
</form>

		</div>
			<div class="col-sm-2"></div>
