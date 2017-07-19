<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%-- <script type="text/javascript" src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.js"></script>

<script type="text/javascript"> --%>





<div class="col-sm-1"></div>
	
		<div class="col-sm-10">
		
<br><div class="col-sm-2"></div>
	
		<div class="col-sm-8">
		<h1>게시글 작성_</h1>
		<hr>
<form action="${initParam.rootPath }/user/addRecipeBoardContents.do"
	method="post" enctype="multipart/form-data">
	
	<sec:csrfInput />

	제목  <input type="text" name="recipeBoardTitle" required size="90"> <br>
	사진<input type="file" name="recipeBoardPicture"> 
	<textarea rows="20" cols="92" name="recipeBoardContent" required></textarea>
	<input type="hidden" name="storeId" value="${param.storeId }" />
	<br>
		<button type="submit" class="btn btn-custom" style="float:right">
			<i class="glyphicon glyphicon-ok"></i>등록
		</button>
	
	
	
</form>
</div>
<div class="col-sm-2"></div>
</div>
<div class="col-sm-1"></div>