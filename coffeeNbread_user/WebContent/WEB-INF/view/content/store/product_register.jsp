<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript" src="/coffeeNbread_user/resource/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('input[type="checkbox"]').on("click", function(){
		$('input[type="checkbox"]').not(this).prop("checked", false);
	});
});
</script>

	<form action="${initParam.rootPath }/addProductController.do" method="post" enctype="multipart/form-data">
		<sec:csrfInput/><%-- csrf 토큰 --%>
		<table>
			<tr class="form-group">
				<th>제품 ID</th>
				<td><input type="text" name="productId" class="form-control"></td>
			</tr>
			<tr class="form-group">
				<th>제품 이름</th>
				<td><input type="text" name="productName" class="form-control"></td>
			</tr>
			<tr >
				<th>제품 가격</th>
				<td><input type="number" min="100" name="productPrice"></td>
			</tr>
			<tr >
				<th>제품 상세</th>
				<td><textarea name="productDetail" rows="5" cols="50"></textarea></td>
			</tr>
			<tr >
				<th>판매 여부</th>
				<td>
				<input type="checkbox" name="sellingOption" value="Y">판매함
				<input type="checkbox" name="sellingOption" value="N">판매안함
				</td>
			</tr>

			<tr>
				<th>금일 제품 개수</th>
				<td><input type="number" min="0" name="todayProductCount"></td>
			</tr>
			<tr>
				<th>추천 제품 개수</th>
				<td><input type="number" min="0" name="recommendProductCount"></td>
			</tr>
			<tr>
				<th>옵션</th>
				<td>
				<select name="optionId" id="optionId">
					<option>옵션</option>
					<c:forEach items="${requestScope.optionCategoryList }" var="optionCategory">
						<option value="${optionCategory.optionId}">${optionCategory.optionCategory }</option>
					</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<th>제품 사진</th>
				<td><input type="file" name="productPicture"></td>
			<tr>
				<td colspan="2"><input type="submit" value="등록"></td>
			</tr>
		</table>
	</form>