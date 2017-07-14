<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
<link rel="stylesheet" href="/coffeeNbread_user/resource/css/search_style.css">
<h2>PRODUCT LIST</h2> 

${requestScope.list }
<div class="container">
<div id="quick-access">
<form action="${initParam.rootPath }/findProductListByMethod.do" method="post" class="form-inline quick-search-form" role="form">
   <sec:csrfInput/><%-- csrf 토큰 --%>
   <div class="form-group">
   <select name="method" class="form-control">
      <option value="productCategory">제품 종류</option>
      <option value="productName">제품 이름</option>
      <option value="sellingOption">판매 여부(Y/N)</option>
   </select>
   <input type="hidden" name="storeId" value="${param.storeId}"/>
   <input type="text" name="methodContent" class="form-control"/>
   </div>
   <button type="submit" class="btn btn-custom"><i class="glyphicon glyphicon-search"></i>검색</button>
</form>
</div>
</div>

<form  action="${initParam.rootPath }/findProductListController.do" method="post">
   <sec:csrfInput/><%-- csrf 토큰 --%>
   <button type="submit" class="btn-custom"><i class="glyphicon glyphicon-list"></i>전체조회</button>
   
</form>

<p>


<form action="${initParam.rootPath }/selectRemoveProductController.do" method="post">
	<sec:csrfInput/><%-- csrf 토큰 --%>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>&nbsp;&nbsp;종류&nbsp;&nbsp;</th>
				<th>&nbsp;&nbsp;제품명&nbsp;&nbsp;</th>
				<th>&nbsp;&nbsp;가격&nbsp;&nbsp;</th>
				<th>&nbsp;&nbsp;판매여부&nbsp;&nbsp;</th>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<%-- 전체 제품 목록 --%>
			<c:forEach items="${requestScope.list }" var="product">
			<tr>
				<td align="center">${product.productCategory }&nbsp;</td>
				<td align="center"><a href="${initParam.rootPath }/findProductDetailController.do?productId=${product.productId}">${product.productName }&nbsp;</a></td>
				<td align="center">${product.productPrice }&nbsp;&nbsp;</td>
				<td align="center">&nbsp;&nbsp;&nbsp;&nbsp;${product.sellingOption }&nbsp;</td>
				<td align="center"><input type="checkbox" name="productIdList" value="${product.productId}"></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
      <button type="submit" class="btn-custom"><i class="glyphicon glyphicon-trash"></i>삭제</button>

</form>

<p>

<c:if test="${requestScope.method ne null}">
   <%--######################################################
            종류/이름/판매여부로 조회할 때 페이징 처리
      ###################################################### --%>
   <!-- 첫페이지로 이동 -->
   <a href="${initParam.rootPath }/findProductListByMethod.do?page=1&method=${requestScope.method }&methodContent=${requestScope.methodContent }&storeId=${requestScope.storeId}">첫페이지</a>

   <!--
      이전 페이지 그룹 처리.
      만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
   -->
   <c:choose>
      <c:when test="${requestScope.pageBean.previousPageGroup}">
         <!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
         <a href="${initParam.rootPath }/findProductListByMethod.do?page=${requestScope.pageBean.beginPage-1}&method=${requestScope.method }&methodContent=${requestScope.methodContent }&storeId=${requestScope.storeId}">◀</a>
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
            <a href="${initParam.rootPath }/findProductListByMethod.do?page=${page}&method=${requestScope.method }&methodContent=${requestScope.methodContent }&storeId=${requestScope.storeId}">${page }&nbsp;&nbsp;</a>
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
         <a href="${initParam.rootPath }/findProductListByMethod.do?page=${requestScope.pageBean.endPage+1}&method=${requestScope.method }&methodContent=${requestScope.methodContent }&storeId=${requestScope.storeId}">▶</a>
      </c:when>
      <c:otherwise>
         ▶
      </c:otherwise>
   </c:choose>

   <!-- 마지막 페이지로 이동 -->
   <a href="${initParam.rootPath }/findProductListByMethod.do?page=${requestScope.pageBean.totalPage}&method=${requestScope.method }&methodContent=${requestScope.methodContent }&storeId=${requestScope.storeId}">마지막페이지</a>
</c:if>

<c:if test="${requestScope.method eq null}">
   <%--######################################################
                  전체 조회 페이징 처리
      ###################################################### --%>
   <!-- 첫페이지로 이동 -->
   <a href="${initParam.rootPath }/findProductListController.do?page=1&storeId=${requestScope.storeId}">첫페이지</a>

   <!--
      이전 페이지 그룹 처리.
      만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
   -->
   <c:choose>
      <c:when test="${requestScope.pageBean.previousPageGroup}">
         <!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
         <a href="${initParam.rootPath }/findProductListController.do?page=${requestScope.pageBean.beginPage-1}&storeId=${requestScope.storeId}">◀</a>
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
            <a href="${initParam.rootPath }/findProductListController.do?page=${page}&storeId=${requestScope.storeId}">${page }&nbsp;&nbsp;</a>
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
         <a href="${initParam.rootPath }/findProductListController.do?page=${requestScope.pageBean.endPage+1}&storeId=${requestScope.storeId}">▶</a>
      </c:when>
      <c:otherwise>
         ▶
      </c:otherwise>
   </c:choose>

   <!-- 마지막 페이지로 이동 -->
   <a href="${initParam.rootPath }/findProductListController.do?page=${requestScope.pageBean.totalPage}&storeId=${requestScope.storeId}">마지막페이지</a>
</c:if>