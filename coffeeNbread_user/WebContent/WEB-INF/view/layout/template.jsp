<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="${initParam.rootPath }/resource/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${initParam.rootPath }/resource/bootstrap/css/bootstrap-theme.min.css">
<script src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.min.js"></script>
<script src="${initParam.rootPath }/resource/bootstrap/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
.whole {
	height: 600px;
	margin-top: 20px;
}
.side, .content{
	height:100%;
	padding: 10px;
}
.side{
	background-color: #E0FFFF;
}

@media screen and (max-width: 750px){ /*화면이 웹 스크린이고 width가 750px 이하가 되면*/
	.side, .whole {
		height: auto;
	}
}
</style>
</head>
<body>

<div class="container">
	<div class="page-header text-center">
		<h1>Spring Security 예제</h1>
		<p>Spring Security, Tiles를 이용한 예제</p>
	</div>
	<%--메인 body --%>
	<div class="row whole">
		<%-- 메뉴 --%>
		<nav class="col-sm-3 side">
			<tiles:insertAttribute name="menu"/>
		</nav>
		<!-- 내용 -->
		<section class="col-sm-9 content">
			<tiles:insertAttribute name="content"/>
		</section>
	</div>

</div>
</body>
</html>