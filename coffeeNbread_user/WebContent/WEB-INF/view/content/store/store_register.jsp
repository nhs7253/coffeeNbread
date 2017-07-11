<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript"
	src="/coffeeNbread_user/resource/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#optionCategoryList").on("click", function() {

			var p2 = document.createElement("input");
			p2.setAttribute("name", "optionCategoryList");
			p2.setAttribute("class", "form-control");
			var txt = document.createTextNode($("#optionCategory").val());
			p2.appendChild(txt);

			var input = document.getElementById("selectSC");
			input.appendChild(p2);

		});//end of storeCategoryList

	});//end of document
</script>
<body>
	<form action="${initParam.rootPath }/addStoreController.do"
		method="post" enctype="multipart/form-data">
		<sec:csrfInput />
		<%-- csrf 토큰 --%>
		<table>
			<tr class="form-group">
				<th>매장 분류 </th>
				<td><input type="text" name="optionCategoryList"
					id="optionCategory" class="form-control">
					
				</td>
				<td>
				<button type="button" id="optionCategoryList"
					class="btn btn-default btn-circle">
					<i class="glyphicon glyphicon-plus"></i>
				</button>
				</td>
				

			</tr>
		
			<tr class="form-group">
				<th></th>
				<td id="selectSC"></td>
			</tr>
		</table>

		<table>
			<tr class="form-group">
				<th>매장 ID</th>

				<td><div class="col-xs-10"><input type="text" name="storeId" class="form-control"></div></td>
			</tr>
			<tr class="form-group">
				<th>매장 이름</th>
				<td><div class="col-xs-10"><input type="text" name="storeName" class="form-control"></div></td>
			</tr>
			<tr class="form-group">
				<th>매장 번호</th>
				<td><div class="col-xs-10"><input type="tel" name="storePhone" class="form-control"></div></td>
			</tr>
			<tr class="form-group">
				<th>매장 메일</th>
				<td><div class="col-xs-10"><input type="email" name="storeEmail" class="form-control"></div></td>
			</tr>
			<tr class="form-group">
				<th>open 시간</th>
				<td><div class="col-xs-5">
				<input type="date" name="storeOpen" class="form-control">
					</div></td>
			</tr>
			<tr class="form-group">
				<th>close 시간</th>
				<td><div class="col-xs-5"><input type="date" name="storeClose" class="form-control"></div></td>
			</tr>
			<tr>
				<th>매장 사진</th>
				<td><input type="file" name="storePictureList"></td>
			</tr>
			<tr class="form-group">
				<th>매장 위치</th>
				<td><input type="text" name="storeAddress" class="form-control"></td>
			</tr>
			<tr>
				<th>매장 소개</th>
				<td><textarea name="storeIntro" rows="5" cols="50"></textarea></td>
			</tr>

			<tr>
				<td colspan="2"><button type="submit"
						class="btn btn-default btn-circle">
						<i class="glyphicon glyphicon-ok"></i> 등록
					</button></td>
			</tr>
		</table>

	</form>
</body>
</html>