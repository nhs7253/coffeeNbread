<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript"
	src="/coffeeNbread_user/resource/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('input[type="checkbox"]').on("click", function() {
			$('input[type="checkbox"]').not(this).prop("checked", false);
		});
	});
</script>

<br><br><br><br><br>

	<div class="col-sm-2"></div>


<form action="${initParam.rootPath }/modifyProductController.do"
	method="POST" enctype="multipart/form-data">
	<sec:csrfInput />
	<%-- csrf 토큰 --%>
	<div class="col-sm-4">
			<h2>제품 수정&nbsp;<i class="glyphicon glyphicon-erase"></i></h2>
	<br><br><br><br><br>
	<img
				src="/coffeeNbread_user/up_image/${requestScope.product.productPicture}"
				width="300px"> <input type="hidden"
				name="OriginalProductPicture"
				value="${requestScope.product.productPicture}" />
			<input type="file" name="productPicture">
		</div>
		<div class="col-sm-4">
		<br><br><br>
	<table class="table">
		<tr class="form-group">
			<th>제품 ID</th>
			<td>${requestScope.product.productId }</td>
			<td><div class="col-xs-5">
					<input type="hidden" name="productId"value="${requestScope.product.productId }" class="form-control">
				</div></td>
		</tr>
		<tr class="form-group">
			<th>제품 이름</th>
			<td><input type="text" name="productName"value="${requestScope.product.productName }" class="form-control"></td>
		</tr>
		<tr>
			<th>옵션</th>
			<td><select name="optionCategoryString"
				id="optionCategoryString">
					<option>${requestScope.product.productCategory }</option>
					<c:forEach items="${requestScope.optionCategoryList }"
						var="optionCategory">
						<c:if
							test="${requestScope.product.productCategory ne optionCategory.optionCategory}">
							<option>${optionCategory.optionCategory }</option>
						</c:if>
					</c:forEach>
			</select></td>
		</tr>
		<tr class="form-group">
			<th>제품 가격</th>
			<td>
					<input type="number" min="100" name="productPrice"
						value="${requestScope.product.productPrice }" class="form-control">
				</td>
		</tr>
		
		<tr>
			<th>판매 여부</th>
			<td><input type="checkbox" name="sellingOption" value="Y"
				<c:if test="${requestScope.product.sellingOption eq 'Y'}">checked="checked"</c:if>>판매함
				<input type="checkbox" name="sellingOption" value="N"
				<c:if test="${requestScope.product.sellingOption eq 'N'}">checked="checked"</c:if>>판매안함
			</td>
		</tr>
		<tr class="form-group">
			<th>금일 제품 개수</th>
			<td><input type="number" min="0" name="todayProductCount"
				value="${requestScope.product.todayProductCount }"
				class="form-control"></td>
		</tr>
		<tr class="form-group">
			<th>추천 제품 개수</th>
			<td><input type="number" min="0" name="recommendProductCount"
				value="${requestScope.product.recommendProductCount }"
				class="form-control"></td>
		</tr>
		
		<tr>
			<th>제품 상세</th>
			<td><textarea name="productDetail" rows="5" cols="30">${requestScope.product.productDetail }</textarea></td>
		</tr>
		<tr><th></th>
			<td style="text-align:right">
				<button type="submit" class="btn" style="background-color:#01A207;">
					<i class="glyphicon glyphicon-ok"></i>&nbsp;수정완료
				</button>
			</td>
		</tr>
	</table></div>
</form>
<div class="col-sm-1"></div>