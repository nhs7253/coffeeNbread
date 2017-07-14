<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<h1>게시글 수정</h1>
<hr>
<br>


<form action="${initParam.rootPath }/user/modifyRecipeBoardContents.do"
	method="post" enctype="multipart/form-data">
	<sec:csrfInput />
	대표 사진:
	<c:forEach items="${requestScope.content.recipeBoardPicture }"
		var="fileName">
		<img src="${initParam.rootPath }/up_image/${fileName }" width="200px"
			height="200px">
	</c:forEach>
	<input type="file" name="recipeBoardPicture"> 제목 : <input
		type="text" name="recipeBoardTitle"
		value="${requestScope.content.recipeBoardTitle }"> 내용<br>
	<textarea rows="20" cols="100" name="recipeBoardContent">
	 	${requestScope.content.recipeBoardContent }
	 </textarea>
	<input type="hidden" name="recipeBoardNo"
		value="${requestScope.content.recipeBoardNo }" />

	<p>
		<button type="submit" class="btn-custom">
			<i class="glyphicon glyphicon-pencil"></i>수정
		</button>
	</p>
</form>

