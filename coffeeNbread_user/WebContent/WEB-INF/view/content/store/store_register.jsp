<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="/coffeeNbread_user/resource/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#storeCategoryList").on("click",function(){
		
	
		var p2 = document.createElement("input");
		p2.setAttribute("name","storeCategoryList");
		var txt = document.createTextNode($("#storeCategory").val());
		p2.appendChild(txt);
	
		var input = document.getElementById("selectSC");
		input.appendChild(p2);
		
	
		});//end of storeCategoryList

	
		$("#optionCategoryList").on("click",function(){
			
		
			var p2 = document.createElement("input");
			p2.setAttribute("name","optionCategoryList");
			var txt = document.createTextNode($("#optionCategory").val());
			p2.appendChild(txt);
		
			var input = document.getElementById("selectOC");
			input.appendChild(p2);
			
		
			});//end of optionCategoryList
		
	});//end of document
	



</script>
<body>
	<form action="${initParam.rootPath }/addStoreController.do" method="post" enctype="multipart/form-data">
		<sec:csrfInput/><%-- csrf 토큰 --%>
		<table >
			<tr >
				<th>매장 분류</th>
				<td><input type="text" name="storeCategoryList" id="storeCategory"><button type="button"  id="storeCategoryList">추가하기</button></td>
			</tr>
			<tr><th></th>
				<td id="selectSC">
				
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<th>옵션 카테고리</th>
				<td><input type="text" name="optionCategoryList" id="optionCategory"><button type="button" id="optionCategoryList">추가하기</button></td>
			</tr>
			<tr><th></th>
				<td id="selectOC">
				
				
				</td>
			</tr>
		</table>
		<table>	
			<tr>
				<th>매장 ID</th>

				<td><input type="text" name="storeId" value="${param.id}"></td>
			</tr>
			<tr>
				<th>매장 이름</th>
				<td><input type="text" name="storeName" ></td>
			</tr>
			<tr>
				<th>매장 번호</th>
				<td><input type="tel" name="storePhone" ></td>
			</tr>
			<tr>
				<th>매장 메일</th>
				<td><input type="email" name="storeEmail"></td>
			</tr>
			<tr>
				<th>open 시간</th>
				<td><input type="date" name="storeOpen" ></td>
			</tr>
			<tr>
				<th>close 시간</th>
				<td><input type="date" name="storeClose"  ></td>
			</tr>
			<tr>
				<th>매장 사진</th>
				<td><input type="file" name="storePictureList" multiple></td>
			</tr>
			<tr>
				<th>매장 위치</th>
				<td><input type="text" name="storeAddress"></td>
			</tr>
			<tr>
				<th>매장 소개</th>
				<td><textarea name="storeIntro" rows="5" cols="50"></textarea></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="등록"></td>
			</tr>
		</table>
	</form>
</body>
</html>