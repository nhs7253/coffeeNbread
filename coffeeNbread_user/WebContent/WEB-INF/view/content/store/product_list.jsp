<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>제품 목록</h2>

<table>
	<thead>
		<tr>
			<th>종류&nbsp;&nbsp;</th>
			<th>제품명&nbsp;&nbsp;</th>
			<th>가격&nbsp;&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.list }" var="product">
			<tr>
				<td>${product.productCategory }</td>
				<td><a href="${initParam.rootPath}/findProductDetailController?storeId=${requestScope.storeId }&productId=${product.productId }">${product.productName }</a></td>
				<td>${product.productPrice }</td>
			</tr>
		</c:forEach>	
	</tbody>
</table>
