<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


	
<style type="text/css">
table, td {
   border: 1px solid black;
}

table {
   width: 700px;
   border-collapse: collapse;
}

td {
   padding: 5px; /* //td 간 간격 */
}
</style>
<link rel="stylesheet" href="/coffeeNbread_user/css/search_style.css">

	<h2>STORE LIST</h2>


<div class="container">
<div id="quick-access">
	<form action="${initParam.rootPath }/common/findStorePagingListController.do" method="post" class="form-inline quick-search-form" role="form">
		<div class="form-group">
		<select name="select" class="form-control">
			<option value="storeName" ${param.select eq "storeName" ? "selected" :""}>이름</option>
			<option value="storeIntro" ${param.select eq "storeIntro" ? "selected" :""}>소개</option>
			<option value="storeAddress" ${param.select eq "storeAddress" ? "selected" :""}>주소</option>
			<option value="storeCategory" ${param.select eq "storeCategory" ? "selected" :""}>카테고리</option>
		</select> <input type="text" name="keyword" class="form-control"/></div><button type="submit" class="btn btn-custom"><i class="glyphicon glyphicon-search"></i>검색</button>
		<sec:csrfInput/><%-- csrf 토큰 --%>
	</form>
	</div>
</div>
	<br>


	
	<table class="table">
		<thead>
			<tr class="form-group">
				<th>매장이름</th>
				<th>주소</th>
				<th>카테고리</th>
				<th>여는 시간</th>
				<th>닫는 시간</th>
			</tr>
		</thead>
		<tbody>

			<%-- ######################################################
															조회된 item 출력 
				###################################################### --%>
			<c:forEach items="${requestScope.list }" var="list">

				<tr class="form-group">
					<td><a href="${initParam.rootPath }/common/viewStoreController.do?storeId=${list.storeId}">${list.storeName}</a></td>
					<td>${list.storeAddress}</td>
					<td>${list.storeCategory}</td>
					<td>${list.storeOpenFormat}</td>
					<td>${list.storeCloseFormat}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	




	<p>
		<%--######################################################
															페이징 처리
				###################################################### --%>
		<!-- 첫페이지로 이동 -->
		<a
			href="${initParam.rootPath }/common/findStorePagingListController.do?page=1&select=${requestScope.select}&keyword=${requestScope.keyword}">첫페이지</a>


		<!--
			이전 페이지 그룹 처리.
			만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
		 -->
		<c:choose>
			<c:when test="${requestScope.pageBean.previousPageGroup}">
				<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
				<a
					href="${initParam.rootPath }/common/findStorePagingListController.do?page=${requestScope.pageBean.beginPage-1}&select=${requestScope.select}&keyword=${requestScope.keyword}">◀</a>
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
						href="${initParam.rootPath }/common/findStorePagingListController.do?page=${page}&select=${requestScope.select}&keyword=${requestScope.keyword}">${page }&nbsp;&nbsp;</a>
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
					href="${initParam.rootPath }/common/findStorePagingListController.do?page=${requestScope.pageBean.endPage+1}&select=${requestScope.select}&keyword=${requestScope.keyword}">▶</a>
			</c:when>
			<c:otherwise>
			▶
		</c:otherwise>
		</c:choose>




		<!-- 마지막 페이지로 이동 -->
		<a
			href="${initParam.rootPath }/common/findStorePagingListController.do?page=${requestScope.pageBean.totalPage}&select=${requestScope.select}&keyword=${requestScope.keyword}">마지막
			페이지</a>

		<p/>
		
		<!-- mvc 로 등록한 뷰패턴은 get 방식으로만 이동이 가능함 -->
		<sec:authorize access="hasRole('ROLE_CNB_ADMIN')">
			<form action="${initParam.rootPath }/admin/notice_board_register_form.do">
				<sec:csrfInput/>
				<input type="submit" value="등록">
			</form>
		</sec:authorize>
