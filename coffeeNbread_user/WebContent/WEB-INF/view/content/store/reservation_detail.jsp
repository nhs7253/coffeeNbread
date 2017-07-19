<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h2>예약 상세 내용</h2>

<br>

<table class="table">
	<tr class="form-group">
		<th style="font-weight:bold">예약자</th>
		<td>${requestScope.userName }</td>
	</tr>
	<tr class="form-group">
		<th style="font-weight:bold">예약 시간</th>
		<td><fmt:formatDate value="${requestScope.time}" pattern="yyyy-MM-dd HH:mm"/></td>
	</tr>
	<tr class="form-group">
		<th style="font-weight:bold">제품명</th>
		<c:forEach items="${productNameList}" varStatus="status">
		<td>${productNameList[status.index]}</td>
		</c:forEach>
	</tr>			
	<tr class="form-group">
		<th style="font-weight:bold">제품 개수</th>
		<c:forEach items="${countList}" varStatus="status">
		<td>${countList[status.index]}</td>
		</c:forEach>
	</tr>		
	<tr class="form-group">
		<th style="font-weight:bold">수령 희망 시간</th>
		<td><fmt:formatDate value="${requestScope.hopeTime}" pattern="yyyy-MM-dd HH:mm"/></td>
	</tr>
</table>

<br>

<form method=get action="${initParam.rootPath }/findReservationDetailsController.do">
	<sec:csrfInput/><%-- csrf 토큰 --%>
	<button type="submit" class="btn" style="float:right"><i class="glyphicon glyphicon-repeat"></i>&nbsp;목록으로</button>
</form>