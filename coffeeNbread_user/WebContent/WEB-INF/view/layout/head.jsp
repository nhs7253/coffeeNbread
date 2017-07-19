<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Simplest jQuery Dropdown Nav Demo</title>





</head>

<body>
	<header class="cd-main-header">

		
		<a href="#0" class="cd-nav-trigger">Menu<span></span></a>

		<nav class="cd-nav">

			<ul class="cd-top-nav">
				<li><a href="${initParam.rootPath }/index.do"><span class="glyphicon glyphicon-home"></span>&nbsp;HOME</a></li>
				<li><a> <%-- sec:authoize - 현 사용자가 특정 권한이 있으면 몸체의 내용을 처리한다. access속성에 어떤 권한인지를 표현한다. - 스프링 시큐리티의 sprint EL  이용--%>
						<sec:authorize access="isAuthenticated()">
							<!-- Authentication의 getPrincipal() 호출 - User 리턴 -->
							<span class="glyphicon glyphicon-user"></span>&nbsp;
							<sec:authentication property="principal.userName" /> 님 환영합니다.
						</sec:authorize>(<sec:authentication property="authorities" />)
				</a></li>
				<li><a href="${initParam.rootPath }/user/mypage.do"><span class="glyphicon glyphicon-file"></span>&nbsp;MY PAGE</a></li>
				<!-- 	<li><a href="#0">Support</a></li> -->
				<li class="has-children account"><a><span class="glyphicon glyphicon-bell"></span>&nbsp;USER</a>

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
						<sec:authorize access="hasAnyRole('ROLE_CNB_USER', 'CNB_STORE')">
							<li><a href="${initParam.rootPath }/user/mypage.do">사용자
									정보조회</a></li>
							<li><a
								href="${initParam.rootPath }/user/remove_user_form.do">사용자
									탈퇴</a></li>
							<li><a
								href="${initParam.rootPath }/user/update_profile_form.do">내
									정보 수정</a></li>
							  
               	<li><a href="${initParam.rootPath }/user/findStoreBookmarkListByKeywordController.do">북마크 목록 조회</a></li>
				
					<li><a href="${initParam.rootPath }/user/findStoreVisitHistoryListByKeywordController.do">유저 방문 내역 조회</a></li>
				
					<li><a href="${initParam.rootPath }/user/viewUserPreferenceStoreListController.do">유저 추천 매장 조회</a></li>
              
              		<li><a href="${initParam.rootPath }/user/findPaymentDetailsController.do"> 회원 결제내역 조회</a></li>	
				
					<li><a href="${initParam.rootPath }/user/findReservationDetailsController.do"> 회원 예약내역 조회</a></li>	
              

						</sec:authorize>
					</ul></li>
			</ul>
		</nav>
	</header>
	<!-- .cd-main-header -->


</body>
</html>
