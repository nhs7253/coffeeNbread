<%@ page contentType="text/html;charset=UTF-8" %>
<%--Spring Security 커스텀태그 --%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
   sec:authorize access="Spring Security EL"  : EL 표현식의 인증/권한 상태의 사용자에게만 보여질 
   									내용을 태그의 content로 넣는다.
 --%>
<ul class="nav nav-stacked">
<%--인증 안된(로그인 안한) 사용자 메뉴 : 인증되면 안보여야 하는 메뉴 --%>
<sec:authorize access="!isAuthenticated()">
	<li><a href="${initParam.rootPath }/login_form.do">로그인</a></li>
	<li><a href="${initParam.rootPath }/add_user_form.do">회원가입</a></li>
</sec:authorize>


<%--인증된(로그인한) 사용자 메뉴 : 인증 안된상태에서 안보여야 하는 메뉴 --%>
<sec:authorize access="isAuthenticated()">
	<li><a href="javascript:logout()">로그아웃</a>
</sec:authorize>


<%--관리자 메뉴 /admin 으로 시작--%>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<li><a href="${initParam.rootPath }/admin/register_admin_form.do">관리자 등록</a></li>
</sec:authorize>


<%--회원/관리자 공통 메뉴 /member로 시작 --%>
<sec:authorize access="hasAnyRole('CNB_USER', 'CNB_STORE')">
	<li><a href="${initParam.rootPath }/user/mypage.do">사용자 정보조회</a></li>
	<li><a href="${initParam.rootPath }/user/remove_user_form.do">사용자 탈퇴</a></li>
	<li><a href="${initParam.rootPath }/user/findStoreBookmarkListByKeywordController.do">북마크 목록 조회</a></li>
	<li><a href="${initParam.rootPath }/user/findStoreVisitHistoryListByKeywordController.do">유저 방문 내역 조회</a></li>
	<li><a href="${initParam.rootPath }/user/viewUserPreferenceStoreListController.do">유저 추천 매장 조회</a></li>
	<li><a href="${initParam.rootPath }/user/QnA_board_register_form.do">Q&A 글쓰기</a></li>
	<li><a href="${initParam.rootPath }/user/QnA_board_register_form.do?storeId=service-qna-s-1">매장 Q&A 글쓰기</a></li>
</sec:authorize>

<li><a href="${initParam.rootPath }/findUserListBySelectToKeywordController.do">사용자 목록</a></li>
<li><a href="${initParam.rootPath }/common/findQnaBoardContentsBySelectToKeywordController.do">Q&A 게시판 목록</a></li>
<li><a href="${initParam.rootPath }/common/findQnaBoardContentsBySelectToKeywordController.do?storeId=service-qna-s-1">매장 Q&A 게시판 목록</a></li>
<%--인증 관련 없는 메뉴 (로그인 하던 말던 똑같이 나올 메뉴) --%>

<li><a href="${initParam.rootPath }/findOptionCategoryController.do">메뉴 등록</a></li>
<li><a href="${initParam.rootPath }/common//findRecipeBoardContentsBySelectToKeyword.do">전체 레시피 게시판 </a></li>

<li><a href="${initParam.rootPath }/addStoreController.do">매장 등록</a></li>
</ul>



<script type="text/javascript">
	function logout(){
		document.getElementById("logoutForm").submit();
	}
</script>
<form id="logoutForm" action="${initParam.rootPath }/logout.do" method="post" style="display:none">
    <sec:csrfInput/>
</form>














