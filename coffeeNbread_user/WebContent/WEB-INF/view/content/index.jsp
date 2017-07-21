<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 
<%-- sec:authoize - 현 사용자가 특정 권한이 있으면 몸체의 내용을 처리한다.
	   access속성에 어떤 권한인지를 표현한다. - 스프링 시큐리티의 sprint EL  이용--%>
<%-- <sec:authorize access="isAuthenticated()"> -->
	 <!-- Authentication의 getPrincipal() 호출 - User 리턴 -->
	<sec:authentication property="principal.userName"/> 님 환영합니다.<br>
</sec:authorize>

 --%>
<%--  	<sec:authentication property="authorities"/> 님 환영합니다.<br> --%>
<style type='text/css'>
body{

background-image:url(up_image/main2.jpg);
background-size: cover;
background-position: center center;
background-repeat: no-repeat;

}


@font-face {
	font-family: 'index';
	src: local(※), url(${initParam.rootPath }/resource/font/BLKCHCRY.woff) format('woff');
}

h2 {
	font-family: 'index';
	font-size: 170px;
}
</style>

<body>
<br><br><br><br><br><br><br><br><br><br>
<h2 align="center" style="color:#FFFFFF">Coffee & Bread</h2>
</body>



