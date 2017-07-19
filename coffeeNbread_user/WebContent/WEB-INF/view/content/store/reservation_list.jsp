<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ko" xml:lang="ko" xmlns="http://www.w3.org/1999/xhtml">
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	

<style type="text/css">
table, td {
   border: 1px solid black;
}

table {
   width: 700px;
   border-collapse: collapse;
}

td {
   padding: 5px; /*td 간 간격 */
}
</style>

<script type="text/javascript" src="/coffeeNbread_user/resource/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".alarm").on("click", function(to, text){
		var btn = this;
		var to = $(".alarm").prev().prev().prev().val();
		var text = $(".alarm").prev().prev().val();
		$.ajax({
			"url":"/coffeeNbread_user/changeReservationConfirmByClickButtonController.do",
			"type":"GET",
			"data":{"userId":$(".alarm").prev().prev().prev().prev().val(), "reservationTime":$(".alarm").prev().val()},
			"success":function(value){
				$(btn).parent().text(value);
				$(btn).remove();
				var url = "http://api.coolsms.co.kr/sendmsg?user=nhs7253&password=zhtmxk156&to=" + to + "&from=01037962472&text=" + text;
				window.open(url,"alarmMessage","width=500, height=400 resizable=no").close();
			}
		}); 
	});
});

</script>

</head>
	<body>

<h2 id="h2">예약 현황 조회</h2> 
<br>

<form action="${initParam.rootPath }/selectRemoveReservationDetailsController.do" method="post">
	<sec:csrfInput/><%-- csrf 토큰 --%>
<table id="table">
	<tbody>
		<tr>
			<td align="center" style="font-weight:bold; background-color:LemonChiffon"><button type="submit" class="btn" style="float:right"><i class="glyphicon glyphicon-trash"></i></button></td>
			<td align="center" style="font-weight:bold; background-color:LemonChiffon">예약 번호</td>		
			<td align="center" style="font-weight:bold; background-color:LemonChiffon">예약자</td>		
			<td align="center" style="font-weight:bold; background-color:LemonChiffon">예약 시간</td>
			<td align="center" style="font-weight:bold; background-color:LemonChiffon">제품 수령 희망 시간</td>
			<td align="center" style="font-weight:bold; background-color:LemonChiffon">확인 유무</td>
		</tr>
	
		<%-- 전체 예약 목록 --%>
		<c:forEach items="${requestScope.list }" var="reservationDetails" varStatus="status">
		<tr>
			<td align="center" id="td2">
				<input type="checkbox" name="reservationNoList" value="${reservationDetails.reservationNo }"/>	
			</td>
			<td align="center">${reservationDetails.reservationNo }<input id="confirm" type="hidden" value="${reservationDetails.userId}"/></td>
			<td align="center"><a href="${initParam.rootPath }/findReservationDetailController.do?userId=${reservationDetails.userId}&reservationTime=<fmt:formatDate value="${reservationDetails.reservationTime }" pattern="yyyy-MM-dd HH:mm"/>">${userNameList[status.index] }</a></td>
			<td align="center"><fmt:formatDate value="${reservationDetails.reservationTime }" pattern="yyyy-MM-dd HH:mm"/></td>
			<td align="center"><fmt:formatDate value="${reservationDetails.productHopeTime }" pattern="yyyy-MM-dd HH:mm"/></td>
			<td id="timeTd${status.index}" align="center">
				<input type="hidden" id="to" value="${userIdList[status.index] }"/>
				<input type="hidden" id="to" value="${phoneNumList[status.index] }"/>
				<input type="hidden" id="text" value="${userNameList[status.index] }님의 예약이 확인되었습니다"/>
				<input type="hidden" id="time" value="<fmt:formatDate value="${reservationDetails.reservationTime }" pattern="yyyy-MM-dd HH:mm"/>"/>
				<c:if test="${empty reservationDetails.reservationConfirm}">
					<input class="alarm" type="button" value="알림 전송"/>
				</c:if>
				<c:if test="${!empty reservationDetails.reservationConfirm}">
					<fmt:formatDate value="${reservationDetails.reservationConfirm }" pattern="yyyy-MM-dd HH:mm"/>
				</c:if>
			</td>			
		</tr>
		</c:forEach>
	</tbody>
</table>
</form>

<br><br>

	<%--######################################################
						전체 조회 페이징 처리
		###################################################### --%>
	<!-- 첫페이지로 이동 -->
	<a href="${initParam.rootPath }/findReservationDetailsController.do?page=1&storeId=${requestScope.storeId}">첫페이지</a>

	<!--
		이전 페이지 그룹 처리.
		만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
	-->
	<c:choose>
		<c:when test="${requestScope.pageBean.previousPageGroup}">
			<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
			<a href="${initParam.rootPath }/findReservationDetailsController.do?page=${requestScope.pageBean.beginPage-1}&storeId=${requestScope.storeId}">◀</a>
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
				<a href="${initParam.rootPath }/findReservationDetailsController.do?page=${page}&storeId=${requestScope.storeId}">${page }&nbsp;&nbsp;</a>
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
			<a href="${initParam.rootPath }/findReservationDetailsController.do?page=${requestScope.pageBean.endPage+1}&storeId=${requestScope.storeId}">▶</a>
		</c:when>
		<c:otherwise>
			▶
		</c:otherwise>
	</c:choose>

	<!-- 마지막 페이지로 이동 -->
	<a href="${initParam.rootPath }/findReservationDetailsController.do?page=${requestScope.pageBean.totalPage}&storeId=${requestScope.storeId}">마지막페이지</a>


</body>
</html>
