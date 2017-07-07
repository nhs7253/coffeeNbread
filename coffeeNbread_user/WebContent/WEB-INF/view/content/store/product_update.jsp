<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>제품 정보 수정</h2>
<form action="${initParam.rootPath }/modifyProductController.do" method="POST">
	<sec:csrfInput/><%-- csrf 토큰 --%>
		<table>
			<tr>
				<th>제품 ID</th>
				<td><input type="text" name="productId" value="${requestScope.productUpdate.productId }"></td>
			</tr>
			<tr>
				<th>제품 이름</th>
				<td><input type="text" name="productName" value="${requestScope.product.productName }"></td>
			</tr>
			<tr>
				<th>제품 가격</th>
				<td><input type="number" min="100" name="productPrice" value="${requestScope.product.productPrice }"></td>
			</tr>
			<tr>
				<th>제품 상세</th>
				<td><textarea name="productDetail" rows="5" cols="50" value="${requestScope.product.productDetail }"></textarea></td>
			</tr>
			<tr>
				<th>판매 여부</th>
				<td>
				<input type="checkbox" name="sellingOption" value="Y">판매함
				<input type="checkbox" name="sellingOption" value="N">판매안함
				</td>
			</tr>
			<tr>
				<th>금일 제품 개수</th>
				<td><input type="number" min="0" name="todayProductCount" value="${requesetScope.product.todayProductCount }"></td>
			</tr>
			<tr>
				<th>추천 제품 개수</th>
				<td><input type="number" min="0" name="recommendProductCount" value="${requestScope.product.recommendProductCount }"></td>
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
				<td><input type="file" name="productPictureList" multiple></td>
			<tr>
				<td colspan="2"><input type="submit" value="등록"></td>
			</tr>
		</table>
</form>