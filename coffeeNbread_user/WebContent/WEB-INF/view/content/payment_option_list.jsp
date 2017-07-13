<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

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

</head>
<body>


	<h2>플랫폼 지원 결제 목록</h2>

	<table class="w3-table-all">
		<thead>
			<tr class="w3-blue">
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
					<td>${list.paymentId}</td>
					<td>${list.paymentMethod}</td>
					<td>
						<form
							action="${initParam.rootPath }/removePaymentOptionListController.do"
							method="post">
							<input type="hidden" value="${list.paymentId }" name="paymentId" />
							<button type="submit" class="btn">
								<i class="glyphicon glyphicon-trash"></i>삭제
							</button>
							<sec:csrfInput />
							<%-- csrf 토큰 --%>
						</form>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<form action="${initParam.rootPath }/payment_option_register_form.do">

		<button type="submit" class="btn btn-default btn-circle">
			<i class="glyphicon glyphicon-ok"></i> 등록
		</button>
		<sec:csrfInput />
		<%-- csrf 토큰 --%>
	</form>