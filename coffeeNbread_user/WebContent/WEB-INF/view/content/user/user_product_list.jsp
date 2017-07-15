<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css">
table, td {
	border: 1px solid black;
}

table {
	width: 500px;
	border-collapse: collapse;
}

td {
	padding: 5px; /*td 간 간격 */
}
</style>

<h2>PRODUCT_LIST</h2>



<p>
<table>
	<thead>
		<tr>
			<th>&nbsp;&nbsp;종류&nbsp;&nbsp;</th>
			<th>&nbsp;&nbsp;제품명&nbsp;&nbsp;</th>
			<th>&nbsp;&nbsp;가격&nbsp;&nbsp;</th>
			<th>&nbsp;&nbsp;제품개수&nbsp;&nbsp;</th>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<%-- 전체 제품 목록 --%>
		<c:forEach items="${requestScope.list }" var="product">
			<tr>
				<td>${product.productCategory }&nbsp;</td>
				<td><a
					href="${initParam.rootPath }/findProductDetailController.do?productId=${product.productId}">${product.productName }&nbsp;</a></td>
				<td>${product.productPrice }&nbsp;&nbsp;</td>

				<td>
                 <form
						action="${initParam.rootPath }/user/addShoppingBasketProductController.do" onsubmit="return confirm('장바구니에 넣으시겠습니까?');"
						id=form method="post">						
						<sec:csrfInput />
						<%-- csrf 토큰 --%>
						<input type="number" min="0" name="productCount"> <input
							type="hidden" value="${product.storeId }" name="storeId">
						<input type="hidden" value="${product.productId }"
							name="productId"> 
							<button type="submit" class="btn-custom">
								<i class="glyphicon glyphicon-shopping-cart"></i>장바구니
							</button>
			 <input type="hidden" name="productIdList" value="${product.productId }"/>
			 <input type="hidden" name="productNameList" value="${product.productName }"/>
			<input type="hidden" name="productPriceList" value="${product.productPrice }"/>	
							
					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<form
	action="${initParam.rootPath }/user/ViewShoppingBasketProductController.do"
	method="post">
	<sec:csrfInput />
	<%-- csrf 토큰 --%>
	<input type="hidden" value="${requestScope.list[0].storeId }"
		name="storeId" /> 
	<button type="submit" class="btn-custom">
		<i class="glyphicon glyphicon-search"></i>장바구니 목록 조회
	</button>
</form>

<p>

	<c:if test="${requestScope.method ne null}">
		<%--######################################################
				종류/이름/판매여부로 조회할 때 페이징 처리
		###################################################### --%>
		<!-- 첫페이지로 이동 -->
		<a
			href="${initParam.rootPath }/findProductListByMethod.do?page=1&method=${requestScope.method }&methodContent=${requestScope.methodContent }&storeId=${requestScope.storeId}">첫페이지</a>

		<!--
		이전 페이지 그룹 처리.
		만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
	-->
		<c:choose>
			<c:when test="${requestScope.pageBean.previousPageGroup}">
				<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
				<a
					href="${initParam.rootPath }/findProductListByMethod.do?page=${requestScope.pageBean.beginPage-1}&method=${requestScope.method }&methodContent=${requestScope.methodContent }&storeId=${requestScope.storeId}">◀</a>
			</c:when>
			<c:otherwise>
			◀
		</c:otherwise>
		</c:choose>

		<!-- 
		현재 page가 속한 page 그룹내의 페이지들 링크.
		현재 pageGroup의 시작page ~ 끝 page
	 -->
		<!-- 만약에 page가 현재페이지면 링크처리를 하지 않고 page가 현재페이지가 아니라면 링크처리. -->
		<c:forEach begin="${requestScope.pageBean.beginPage }"
			end="${requestScope.pageBean.endPage }" var="page">
			<c:choose>
				<c:when test="${page != requestScope.pageBean.page}">
					<!-- 현재페이지가 아니라면 -->
					<a
						href="${initParam.rootPath }/findProductListByMethod.do?page=${page}&method=${requestScope.method }&methodContent=${requestScope.methodContent }&storeId=${requestScope.storeId}">${page }&nbsp;&nbsp;</a>
				</c:when>
				<c:otherwise>
				[${page}]&nbsp;&nbsp;
			</c:otherwise>
			</c:choose>
		</c:forEach>

		<!-- 
		다음페이지 그룹으로 이동
		만약에 다음페이지 그룹이 있으면 링크 처리 없으면 화살표만 나오도록 처리
	 -->
		<c:choose>
			<c:when test="${requestScope.pageBean.nextPageGroup}">
				<a
					href="${initParam.rootPath }/findProductListByMethod.do?page=${requestScope.pageBean.endPage+1}&method=${requestScope.method }&methodContent=${requestScope.methodContent }&storeId=${requestScope.storeId}">▶</a>
			</c:when>
			<c:otherwise>
			▶
		</c:otherwise>
		</c:choose>

		<!-- 마지막 페이지로 이동 -->
		<a
			href="${initParam.rootPath }/findProductListByMethod.do?page=${requestScope.pageBean.totalPage}&method=${requestScope.method }&methodContent=${requestScope.methodContent }&storeId=${requestScope.storeId}">마지막페이지</a>
	</c:if>

	<c:if test="${requestScope.method eq null}">
		<%--######################################################
						전체 조회 페이징 처리
		###################################################### --%>
		<!-- 첫페이지로 이동 -->
		<a
			href="${initParam.rootPath }/findProductListController.do?page=1&storeId=${requestScope.storeId}">첫페이지</a>

		<!--
		이전 페이지 그룹 처리.
		만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
	-->
		<c:choose>
			<c:when test="${requestScope.pageBean.previousPageGroup}">
				<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
				<a
					href="${initParam.rootPath }/findProductListController.do?page=${requestScope.pageBean.beginPage-1}&storeId=${requestScope.storeId}">◀</a>
			</c:when>
			<c:otherwise>
			◀
		</c:otherwise>
		</c:choose>

		<!-- 
		현재 page가 속한 page 그룹내의 페이지들 링크.
		현재 pageGroup의 시작page ~ 끝 page
	 -->
		<!-- 만약에 page가 현재페이지면 링크처리를 하지 않고 page가 현재페이지가 아니라면 링크처리. -->
		<c:forEach begin="${requestScope.pageBean.beginPage }"
			end="${requestScope.pageBean.endPage }" var="page">
			<c:choose>
				<c:when test="${page != requestScope.pageBean.page}">
					<!-- 현재페이지가 아니라면 -->
					<a
						href="${initParam.rootPath }/findProductListController.do?page=${page}&storeId=${requestScope.storeId}">${page }&nbsp;&nbsp;</a>
				</c:when>
				<c:otherwise>
				[${page}]&nbsp;&nbsp;
			</c:otherwise>
			</c:choose>
		</c:forEach>

		<!-- 
		다음페이지 그룹으로 이동
		만약에 다음페이지 그룹이 있으면 링크 처리 없으면 화살표만 나오도록 처리
	 -->
		<c:choose>
			<c:when test="${requestScope.pageBean.nextPageGroup}">
				<a
					href="${initParam.rootPath }/findProductListController.do?page=${requestScope.pageBean.endPage+1}&storeId=${requestScope.storeId}">▶</a>
			</c:when>
			<c:otherwise>
			▶
		</c:otherwise>
		</c:choose>

		<!-- 마지막 페이지로 이동 -->
		<a
			href="${initParam.rootPath }/findProductListController.do?page=${requestScope.pageBean.totalPage}&storeId=${requestScope.storeId}">마지막페이지</a>
	</c:if>