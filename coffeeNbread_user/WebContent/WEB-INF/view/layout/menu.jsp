<%@ page contentType="text/html;charset=UTF-8" %>
<%--Spring Security 커스텀태그 --%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
   sec:authorize access="Spring Security EL"  : EL 표현식의 인증/권한 상태의 사용자에게만 보여질 
   									내용을 태그의 content로 넣는다.
 --%>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

 <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
 <body>
 <div class="nav-side-menu">
    <div class="brand">Brand Logo</div>
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
  
        <div class="menu-list">
  
            <ul id="menu-content" class="menu-content collapse out">
               

 


<li  data-toggle="collapse" data-target="#user" class="collapsed active">
                  <a href="#"><i class="fa fa-gift fa-lg"></i> USER <span class="arrow"></span></a>
</li>
<ul class="sub-menu collapse" id="user">
 <%--인증 안된(로그인 안한) 사용자 메뉴 : 인증되면 안보여야 하는 메뉴 --%>
<sec:authorize access="!isAuthenticated()">
	<li><a href="${initParam.rootPath }/login_form.do">로그인</a></li>
	<li><a href="${initParam.rootPath }/add_user_form.do">회원가입</a></li>
</sec:authorize>

<%--인증된(로그인한) 사용자 메뉴 : 인증 안된상태에서 안보여야 하는 메뉴 --%>
<sec:authorize access="isAuthenticated()">
	<li><a href="javascript:logout()">로그아웃</a>
</sec:authorize>
</ul>

<li  data-toggle="collapse" data-target="#admin" class="collapsed active">
                  <a href="#"> admin <span class="arrow"></span></a>
</li>
<ul class="sub-menu collapse" id="admin">
<%--관리자 메뉴 /admin 으로 시작--%>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<li><a href="${initParam.rootPath }/admin/register_admin_form.do">관리자 등록</a></li>
</sec:authorize>
</ul>

<li  data-toggle="collapse" data-target="#common" class="collapsed active">
                  <a href="#"> 관리자 공통메뉴  <span class="arrow"></span></a>
</li>
<ul class="sub-menu collapse" id="common">
<%--회원/관리자 공통 메뉴 /member로 시작 --%>
<sec:authorize access="hasAnyRole('ROLE_CNB_USER', 'CNB_STORE')">
	<li><a href="${initParam.rootPath }/user/mypage.do">사용자 정보조회</a></li>
	<li><a href="${initParam.rootPath }/user/remove_user_form.do">사용자 탈퇴</a></li>
	<li><a href="${initParam.rootPath }/user/findStoreBookmarkListByKeywordController.do">북마크 목록 조회</a></li>
	<li><a href="${initParam.rootPath }/user/findStoreVisitHistoryListByKeywordController.do">유저 방문 내역 조회</a></li>
	<li><a href="${initParam.rootPath }/user/viewUserPreferenceStoreListController.do">유저 추천 매장 조회</a></li>
	<li><a href="${initParam.rootPath }/user/QnA_board_register_form.do">Q&A 글쓰기</a></li>
	<li><a href="${initParam.rootPath }/user/QnA_board_register_form.do?storeId=s-1">매장 Q&A 글쓰기</a></li>
	<li><a href="${initParam.rootPath }/user/callStoreRegisterController.do">매장 등록</a></li>
</sec:authorize>
</ul>

<li  data-toggle="collapse" data-target="#no" class="collapsed active">
                  <a href="#"> 인증 관련 없는 메뉴  <span class="arrow"></span></a>
</li>
<ul class="sub-menu collapse" id="no">
<li><a href="${initParam.rootPath }/findpaymentOptionListController.do">플렛폼 지원 결제 목록</a></li>
<li><a href="${initParam.rootPath }/userManagementListController.do">관리자 - 유저 매장 관리 목록</a></li>
<li><a href="${initParam.rootPath }/findUserListBySelectToKeywordController.do">사용자 목록</a></li>
<li><a href="${initParam.rootPath }/common/findQnaBoardContentsBySelectToKeywordController.do">Q&A 게시판 목록</a></li>
<li><a href="${initParam.rootPath }/common/findQnaBoardContentsBySelectToKeywordController.do?storeId=s-1">매장 Q&A 게시판 목록</a></li>
<li><a href="${initParam.rootPath }/common/findNoticeBoardContentsPagingListController.do">공지사항 게시판 목록</a></li>
<li><a href="${initParam.rootPath }/common/findStorePagingListController.do">매장 목록</a></li>

<%--인증 관련 없는 메뉴 (로그인 하던 말던 똑같이 나올 메뉴) --%>
</ul>

<li  data-toggle="collapse" data-target="#store" class="collapsed active">
                  <a href="#"> 매장관리자  <span class="arrow"></span></a>
</li>
<ul class="sub-menu collapse" id="store">
<%-- 매장 관리자 --%>
<sec:authorize access="hasAnyRole('ROLE_CNB_USER', 'CNB_STORE')">
	<li><a href="${initParam.rootPath }/findOptionCategoryController.do">제품 등록</a></li>
	<li><a href="${initParam.rootPath }/findProductListController.do">제품 목록</a></li>
	<li><a href="${initParam.rootPath}/selectStoreController.do?storeId=<sec:authentication property="principal.storeId"/>">내 제품 목록 조회</a></li>
</sec:authorize>


<li><a href="${initParam.rootPath }/common/findRecipeBoardContentsBySelectToKeyword.do">전체 레시피 게시판 </a></li>
<li><a href="${initParam.rootPath }/addStoreController.do">매장 등록</a></li>
</ul>

</ul>
</div>
</div>

<script type="text/javascript">
	function logout(){
		document.getElementById("logoutForm").submit();
	}
</script>
<form id="logoutForm" action="${initParam.rootPath }/logout.do" method="post" style="display:none">
    <sec:csrfInput/>
</form>
</body>
</html>












