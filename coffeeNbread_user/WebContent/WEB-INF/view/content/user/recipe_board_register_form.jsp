<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%-- <script type="text/javascript" src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.js"></script>

<script type="text/javascript"> --%>

<h1>게시글 작성</h1><hr><br>


<form action="${initParam.rootPath }/user/addRecipeBoardContents.do" method="post" enctype="multipart/form-data">
	<sec:csrfInput/>
	  
	제목 : <input type="text" name="recipeBoardTitle" required> <br>
	대표 사진:<input type="file" name="recipeBoardPicture" >
	내용<br>
	 <textarea rows="20" cols="100" name="recipeBoardContent" required></textarea>
	 <input type="hidden" name="storeId" value="${param.storeId }"/>
	<p>
	<input type="submit" id="btn" value="등록">
	</p>
	
</form>

