<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<style type="text/css">


table {
	width: 700px;
	border-collapse: collapse;
}
th{
text-align:center;
}
td {
	padding: 5px; /* //td 간 간격 */
}
</style>

</head>
<body>

<br><br>
	
<div class="col-sm-1"></div>
	
		<div class="col-sm-10">
		<h2>지원 결제 수단</h2>
	<br><br><br>
	<table class="table">
		<thead>
			<tr >
				<th>아이디</th>
				<th>방법</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>

			<%-- ######################################################
																조회된 item 출력 
					###################################################### --%>
			<c:forEach items="${requestScope.list }" var="list">
				<tr>
					<td style="text-align:center;">${list.paymentId}</td>
					<td>${list.paymentMethod}</td>
					<td style="text-align:center;">
						<form
							action="${initParam.rootPath }/admin/removePaymentOptionListController.do"
							method="post">
							<input type="hidden" value="${list.paymentId }" name="paymentId" />
							
							<button type="submit" class="btn btn-danger" >
								<i class="glyphicon glyphicon-trash"></i>&nbsp;삭제
							</button>
							<sec:csrfInput />
							<%-- csrf 토큰 --%>
						</form>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
<center>
	<form action="${initParam.rootPath }/admin/payment_option_register_form.do">

		<button type="submit" class="btn btn-default btn-circle" style="background-color:#01a207"
		>
			<i class="glyphicon glyphicon-ok"></i>&nbsp;등록
		</button>
		<sec:csrfInput />
		<%-- csrf 토큰 --%>
	</form>
	</center>
	</div>
	<div class="col-sm-1"></div>