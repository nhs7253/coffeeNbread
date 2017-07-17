<%@ page contentType="text/html;charset=UTF-8"%>
<%--Spring Security 커스텀태그 --%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%--
   sec:authorize access="Spring Security EL"  : EL 표현식의 인증/권한 상태의 사용자에게만 보여질 
                              내용을 태그의 content로 넣는다.
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,700'
	rel='stylesheet' type='text/css'>
<style>
</style>


</head>

<body>


	<main class="cd-main-content">
	<nav class="cd-side-nav">
		<ul>
			<li class="cd-label">Main</li>
			<li class="has-children overview"><a href="#0">USER</a>

				<ul>
					<!--                인증 안된(로그인 안한) 사용자 메뉴 : 인증되면 안보여야 하는 메뉴
 -->
					<sec:authorize access="!isAuthenticated()">
						<li><a href="${initParam.rootPath }/login_form.do">로그인</a></li>
						<li><a href="${initParam.rootPath }/add_user_form.do">회원가입</a></li>
					</sec:authorize>
					<!--                인증된(로그인한) 사용자 메뉴 : 인증 안된상태에서 안보여야 하는 메뉴
 -->
					<sec:authorize access="isAuthenticated()">
						<li><a href="javascript:logout()">로그아웃</a>
					</sec:authorize>
				</ul>
		</ul>

		<li class="has-children notifications active"><a href="#0">admin<span
				class="count">1</span></a> 
