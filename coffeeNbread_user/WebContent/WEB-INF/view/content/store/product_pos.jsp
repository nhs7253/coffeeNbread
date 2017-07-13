<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css">
table, td {
   border: 1px solid black;
}

table {
   border-collapse: collapse;
}

td {
   padding: 10px; /*td 간 간격 */
}
</style>

<h3 style="font-weight:bold">포스 (현장 판매 시스템)</h3>

<br>

<table>
		<tbody>
			<%-- 전체 제품 목록 --%>
			<c:forEach items="${requestScope.list }" var="product">
			<tr>
				<td align="center">${product.productName }&nbsp;&nbsp;</td>
			</tr>
			</c:forEach>
		</tbody>
</table>

<br>

<c:if test="${requestScope.method eq null}">
	<%--######################################################
						전체 조회 페이징 처리
		###################################################### --%>
	<!-- 첫페이지로 이동 -->
	<a href="${initParam.rootPath }/findProductListForPosController.do?page=1&storeId=${requestScope.storeId}">첫페이지</a>

	<!--
		이전 페이지 그룹 처리.
		만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
	-->
	<c:choose>
		<c:when test="${requestScope.pageBean.previousPageGroup}">
			<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
			<a href="${initParam.rootPath }/findProductListForPosController?page=${requestScope.pageBean.beginPage-1}&storeId=${requestScope.storeId}">◀</a>
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
	<c:forEach begin="${requestScope.pageBean.beginPage }" end="${requestScope.pageBean.endPage }" var="page">
		<c:choose>
			<c:when test="${page != requestScope.pageBean.page}">
			<!-- 현재페이지가 아니라면 -->
				<a href="${initParam.rootPath }/findProductListForPosController.do?page=${page}&storeId=${requestScope.storeId}">${page }&nbsp;&nbsp;</a>
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
			<a href="${initParam.rootPath }/findProductListForPosController.do?page=${requestScope.pageBean.endPage+1}&storeId=${requestScope.storeId}">▶</a>
		</c:when>
		<c:otherwise>
			▶
		</c:otherwise>
	</c:choose>

	<!-- 마지막 페이지로 이동 -->
	<a href="${initParam.rootPath }/findProductListForPosController.do?page=${requestScope.pageBean.totalPage}&storeId=${requestScope.storeId}">마지막페이지</a>
</c:if>