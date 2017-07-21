<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
   uri="http://www.springframework.org/security/tags"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Simplest jQuery Dropdown Nav Demo</title>
<style type="text/css">
@font-face {
	font-family: 'menu';
	src: local(※), url(${initParam.rootPath }/resource/font/a동네목욕탕.woff) format('woff');
}

li {
	font-family: 'menu';
}
@font-face {
	font-family: 'headTitle';
	src: local(※), url(${initParam.rootPath }/resource/font/MASQUE.woff) format('woff');
}
.headTitle{
	font-family: 'headTitle';
}
</style>

<script type="text/javascript">
	window.onload = function() {
		var display = document.getElementById('display');
		
		setInterval(function () {
			var time = new Date();
			var hours = time.getHours();  // 시
			var minutes = time.getMinutes();  // 분
			var seconds = time.getSeconds();  // 초
			
			 // 삼항연산자를 이용하여 시, 분, 초를  두 자리로 유지
			var clock = '';
			clock += ((hours <10)? '0' : '') + hours;
			clock += ((minutes <10)? ':0' : ':')+minutes;
			clock += ((seconds <10)? ':0' : ':')+seconds;
			
			display.innerHTML = clock;
		}, 1000);
	}

</script>

</head>

<body>
   <header class="cd-main-header">
	<img src="${initParam.rootPath }/resource/css/Coffee-Cup-icon.png" width="30" height="30">
	<input class="headTitle" size=14 type="text" value=" Coffee&Bread" disabled style="border:0; background-color:transparent; font-size:20px; color:#ffffff">
	<img src="${initParam.rootPath }/resource/css/bread.png" width="30" height="30">
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
                  <!-- 인증 안된(로그인 안한) 사용자 메뉴 : 인증되면 안보여야 하는 메뉴 -->
                  <sec:authorize access="!isAuthenticated()">
                     <li><a href="${initParam.rootPath }/login_form.do">로그인</a></li>
                     <li><a href="${initParam.rootPath }/add_user_form.do">회원가입</a></li>
                  </sec:authorize>
                  <!-- 인증된(로그인한) 사용자 메뉴 : 인증 안된상태에서 안보여야 하는 메뉴  -->
                  <sec:authorize access="isAuthenticated()">
                     <li><a href="javascript:logout()">로그아웃</a>
                  </sec:authorize>
                  <sec:authorize access="hasAnyRole('ROLE_CNB_USER', 'CNB_STORE')">
                     <li><a href="${initParam.rootPath }/user/mypage.do">내 정보 조회</a></li>
                     <li><a href="${initParam.rootPath }/user/update_profile_form.do">내 정보 수정</a></li>
                  	 <li><a href="${initParam.rootPath }/user/findStoreBookmarkListByKeywordController.do">즐겨찾기</a></li>
            		 <li><a href="${initParam.rootPath }/user/findStoreVisitHistoryListByKeywordController.do">매장 방문 내역</a></li>
            		 <li><a href="${initParam.rootPath }/user/viewUserPreferenceStoreListController.do">자주 방문하는 매장</a></li>
              		 <li><a href="${initParam.rootPath }/user/findPaymentDetailsController.do">결제내역 조회</a></li>   
            		 <li><a href="${initParam.rootPath }/user/findReservationDetailsController.do">예약내역 조회</a></li>   
                     <li><a href="${initParam.rootPath }/user/remove_user_form.do">탈퇴하기</a></li>
                  </sec:authorize>
               </ul></li>
         </ul>
      </nav>
   </header>
   <!-- .cd-main-header -->


</body>
</html>