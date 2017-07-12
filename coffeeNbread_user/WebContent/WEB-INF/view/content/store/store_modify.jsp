<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

		$("#modifystorePicture").on("click", function() {

			$("#storePicture").empty();

			var p2 = document.createElement("input");
			p2.setAttribute("type", "file");
			p2.setAttribute("name", "storePictureList");
			var input = document.getElementById("storePicture");
			input.appendChild(p2);

		})//end of storePicture

	});//end of document
</script>
<body>
	<form action="${initParam.rootPath }/modifyStoreController.do"
		method="post" enctype="multipart/form-data">
		<sec:csrfInput />
		<table>
			<tr class="form-group">
				<th>매장 분류</th>

				<td><c:forEach items="${sessionScope.store.optionCategoryList}"
						var="optionCategoryList">
						<input type="text" name="optionCategoryList" id="optionCategory"
							value="${optionCategoryList}" class="form-control">
					</c:forEach></td>
				<td>
					<button type="button" id="optionCategoryList"
						class="btn btn-default btn-circle">
						<i class="glyphicon glyphicon-plus"></i>
					</button>
				</td>
			<tr>
				<th></th>
				<td id="selectSC"></td>
			</tr>
			<tr>
				<th></th>
				<td id="selectOC"></td>
			</tr>

		</table>
			<br />
			결제 방식 선택<br />
			<c:forEach items="${requestScope.paymentOptionList }" var="list">
				<input type="checkbox" name="paymentIdList" value="${list.paymentId }"/>${list.paymentMethod }&nbsp;&nbsp;&nbsp;
			</c:forEach>
			
			<table>
			<tr>
				<th>매장 이름</th>
				<td><input type="text" name="storeName"
					value="${sessionScope.storeInfo.storeName}"></td>
			</tr>
			<tr>
				<th>매장 번호</th>
				<td><input type="tel" name="storePhone"
					value="${sessionScope.storeInfo.storePhone}"></td>
			</tr>
			<tr>
				<th>매장 메일</th>
				<td><input type="email" name="storeEmail"
					value="${sessionScope.storeInfo.storeEmail }"></td>
			</tr>
			<tr>
				<th>open 시간</th>
				<td><input type="date" name = "storeOpen" value="<fmt:formatDate value="${sessionScope.storeInfo.storeOpen }"
						type="time" pattern="hh:mm" />"></td>
			</tr>
			<tr>
				<th>close 시간</th>
				<td><input type="date" name="storeClose" value="<fmt:formatDate value="${sessionScope.storeInfo.storeClose }"
						type="time" pattern="hh:mm" />"></td>
			</tr>
			<tr>
				<th id = "selectSP">매장 사진</th>
				<td id = "storePicture">
			<img src="/coffeeNbread_user/up_image/${sessionScope.storeInfo.storePictureList}" width="300px">
				<button type="button" id="modifystorePicture">수정하기</button>


				</td>
			</tr>
			<tr class="form-group">
				<th>매장 이름</th>
				<td><div class="col-xs-10">
						<input type="text" name="storeName"
							value="${sessionScope.store.storeName}" class="form-control">
					</div></td>
			</tr>
			<tr class="form-group">
				<th>매장 번호</th>
				<td><div class="col-xs-10">
						<input type="tel" name="storePhone"
							value="${sessionScope.store.storePhone}" class="form-control">
					</div></td>
			</tr>
			<tr class="form-group">
				<th>매장 메일</th>
				<td><div class="col-xs-10">
						<input type="email" name="storeEmail"
							value="${sessionScope.store.storeEmail }" class="form-control">
					</div></td>
			</tr>
			<tr class="form-group">
				<th>open 시간</th>
				<td><div class="col-xs-5">
						<input type="date" name="storeOpen"
							value="<fmt:formatDate value="${sessionScope.store.storeOpen }"
						type="time" pattern="hh:mm" />"
							class="form-control">
					</div></td>
			</tr>
			<tr class="form-group">
				<th>close 시간</th>
				<td><div class="col-xs-5">
						<input type="date" name="storeClose"
							value="<fmt:formatDate value="${sessionScope.store.storeClose }"
						type="time" pattern="hh:mm" />"
							class="form-control">
					</div></td>
			</tr>
			<tr>
				<th id="selectSP">매장 사진</th>
				<td id="storePicture"><img
					src="/coffeeNbread_user/up_image/${sessionScope.store.storePictureList}"
					width="300px">
					<button type="button" id="modifystorePicture">수정하기</button></td>
			</tr>
			<tr class="form-group">
				<th>매장 위치</th>
				<td></td>
			</tr>
			<tr>
				<th>매장 소개</th>
				<td><textarea name="storeIntro" rows="5" cols="50" >${sessionScope.storeInfo.storeIntro}</textarea></td>
			</tr>

			<tr>
				<td colspan="2"><button type="submit">확인</button></td>
			</tr>
		</table>
	</form>
</body>
</html>