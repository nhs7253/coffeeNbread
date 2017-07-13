<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h2>예약 상세 내용</h2>

<table>	
	<tr>
		<th>예약자</th>
		<td>&nbsp;&nbsp;${requestScope.userName }</td>
	</tr>
	<tr>
		<th>예약 시간</th>
		<td>&nbsp;&nbsp;<fmt:formatDate value="${requestScope.time }" pattern="yyyy-MM-dd"/></td>
	</tr>
	<tr>
		<th>제품명</th>
		<c:forEach items="${productNameList}" varStatus="status">
			<td align="center">&nbsp;&nbsp;${productNameList[status.index]}</td>
		</c:forEach>
	</tr>			
	<tr>
		<th>제품 개수</th>
		<c:forEach items="${countList}" varStatus="status">
			<td align="center">&nbsp;&nbsp;${countList[status.index]}</td>
		</c:forEach>
	</tr>		
	<tr>
		<th>수령 희망 시간</th>
		<td>&nbsp;&nbsp;<fmt:formatDate value="${requestScope.hopeTime }" pattern="yyyy-MM-dd"/></td>
	</tr>
</table>

<br>

<form method=get action="${initParam.rootPath }/findReservationDetailsController.do">
	<sec:csrfInput/><%-- csrf 토큰 --%>
	<input type="submit" value="되돌아가기" />
</form>