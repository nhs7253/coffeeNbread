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
<link rel="stylesheet"
   href="${initParam.rootPath }/resource/bootstrap/css/demo.css">
<link rel="stylesheet"
   href="${initParam.rootPath }/resource/bootstrap/css/material-dashboard.css">
<link rel="stylesheet"
   href="${initParam.rootPath }/resource/bootstrap/css/bootstrap.min.css">

<script
   src="${initParam.rootPath }/resource/bootstrap/js/jquery-3.1.0.min.js"></script>
<script src="${initParam.rootPath }/resource/bootstrap/js/demo.js"></script>
<script
   src="${initParam.rootPath }/resource/bootstrap/js/material.min.js"></script>
<script
   src="${initParam.rootPath }/resource/bootstrap/js/material-dashboard.js"></script>
<script
   src="${initParam.rootPath }/resource/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
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
            class="count">1</span></a> <%-- <<<<<<< HEAD
         <ul>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
               <li><a
                  href="${initParam.rootPath }/admin/register_admin_form.do">관리자
                     등록</a></li>
            </sec:authorize>
         </ul></li>
      <ul>
         <li class="has-children comments"><a href="#0">회원/관리자 공통 메뉴
         </a> =======
         <li data-toggle="collapse" data-target="#common"
            class="collapsed active"><a href="#"> 관리자 공통메뉴 <span
               class="arrow"></span></a></li>
         <ul class="sub-menu collapse" id="common">
            회원/관리자 공통 메뉴 /member로 시작
            <sec:authorize
               access="hasAnyRole('ROLE_CNB_USER', 'ROLE_CNB_STORE')">
               <li><a href="${initParam.rootPath }/user/mypage.do">사용자
                     정보조회</a></li>
               <li><a href="${initParam.rootPath }/user/remove_user_form.do">사용자
                     탈퇴</a></li>
               <li><a
                  href="${initParam.rootPath }/user/findStoreBookmarkListByKeywordController.do">북마크
                     목록 조회</a></li>
               <li><a
                  href="${initParam.rootPath }/user/findStoreVisitHistoryListByKeywordController.do">유저
                     방문 내역 조회</a></li>
               <li><a
                  href="${initParam.rootPath }/user/viewUserPreferenceStoreListController.do">유저
                     추천 매장 조회</a></li>
               <li><a
                  href="${initParam.rootPath }/user/QnA_board_register_form.do">Q&A
                     글쓰기</a></li>
               <li><a
                  href="${initParam.rootPath }/user/QnA_board_register_form.do?storeId=s-1">매장
                     Q&A 글쓰기</a></li>
               <li><a
                  href="${initParam.rootPath }/user/callStoreRegisterController.do">매장
                     등록</a></li>

               <li><a
                  href="${initParam.rootPath }/store/findProductListToPOSController.do">POS</a></li>
            </sec:authorize>


            인증 관련 없는 메뉴 (로그인 하던 말던 똑같이 나올 메뉴)
            <li><a
               href="${initParam.rootPath }/findUserListBySelectToKeywordController.do">사용자
                  목록</a></li>
            <li><a
               href="${initParam.rootPath }/common/findQnaBoardContentsBySelectToKeywordController.do">Q&A
                  게시판 목록</a></li>
            <li><a
               href="${initParam.rootPath }/common/findQnaBoardContentsBySelectToKeywordController.do?storeId=service-qna-s-1">매장
                  Q&A 게시판 목록</a></li>
            <li><a
               href="${initParam.rootPath }/common/findNoticeBoardContentsPagingListController.do">공지사항
                  게시판 목록</a></li>


            매장 관리자
            매장만의 권한으로 바꿔줘야함
            <sec:authorize access="hasAnyRole('ROLE_CNB_USER')">
               <li><a
                  href="${initParam.rootPath }/findOptionCategoryController.do">제품
                     등록</a></li>
               <li><a
                  href="${initParam.rootPath }/findProductListController.do">제품
                     목록</a></li>
               <li><a
                  href="${initParam.rootPath }/findSalesVolumeTodayController.do">판매량
                     조회</a></li>
               <li><a
                  href="${initParam.rootPath }/findReservationDetailsController.do">예약
                     현황 조회</a></li>
               <li><a
                  href="${initParam.rootPath }/findProductListForPosController.do">현장
                     판매 시스템</a></li>
            </sec:authorize>


            <li><a
               href="${initParam.rootPath }/common//findRecipeBoardContentsBySelectToKeyword.do">전체
                  레시피 게시판 </a></li>
            <li><a href="${initParam.rootPath }/addStoreController.do">매장
                  등록</a></li>
            <li><a href="${initParam.rootPath}/ selectStoreController.do">매장
                  조회</a></li>
         </ul>
         >>>>>>> branch 'master' of
         https://github.com/nhs7253/coffeeNbread.git
 --%>
      <li class="has-children comments"><a href="#0">회원/관리자 공통 메뉴 </a>
         <ul>
            <!--             회원/관리자 공통 메뉴 /member로 시작
 -->

				<sec:authorize access="hasAnyRole('ROLE_CNB_USER', 'CNB_STORE')">
					<li><a href="${initParam.rootPath }/user/mypage.do">사용자 정보조회</a></li>
					
					<li><a href="${initParam.rootPath }/user/update_profile_form.do">내 정보 수정</a></li>
					
					<li><a href="${initParam.rootPath }/user/remove_user_form.do">사용자 탈퇴</a></li>
					
					<li><a href="${initParam.rootPath }/user/findStoreBookmarkListByKeywordController.do">북마크 목록 조회</a></li>
				
					<li><a href="${initParam.rootPath }/user/findStoreVisitHistoryListByKeywordController.do">유저 방문 내역 조회</a></li>
				
					<li><a href="${initParam.rootPath }/user/viewUserPreferenceStoreListController.do">유저 추천 매장 조회</a></li>
				
					<li><a href="${initParam.rootPath }/user/QnA_board_register_form.do">Q&A 글쓰기</a></li>
				
					<li><a href="${initParam.rootPath }/user/QnA_board_register_form.do?storeId=s-1">매장 Q&A 글쓰기</a></li>
				
					<li><a href="${initParam.rootPath }/user/callStoreRegisterController.do">매장 등록</a></li>
					
					<li><a href="${initParam.rootPath }/store/findProductListToPOSController.do">POS</a></li>
				
					<li><a href="${initParam.rootPath }/findSalesVolumeTodayController.do">판매량 조회</a></li>
					
					<li><a href="${initParam.rootPath }/findReservationDetailsController.do">예약 현황 조회</a></li>
					
					<li><a href="${initParam.rootPath }/user/findPaymentDetailsController.do"> 회원 결제내역 조회</a></li>	
				
					<li><a href="${initParam.rootPath }/user/findReservationDetailsController.do"> 회원 예약내역 조회</a></li>				
				</sec:authorize>
			</ul></li>


      <li class="cd-label">Secondary</li>
      <li class="has-children bookmarks"><a href="#0">인증관련없는 메뉴</a>

         <ul>
            <li><a
               href="${initParam.rootPath }/common/findQnaBoardContentsBySelectToKeywordController.do">Q&A
                  게시판 목록</a></li>
            <li><a
               href="${initParam.rootPath }/common/findQnaBoardContentsBySelectToKeywordController.do?storeId=s-1">매장
                  Q&A 게시판 목록</a></li>
            <li><a
               href="${initParam.rootPath }/common/findNoticeBoardContentsPagingListController.do">공지사항
                  게시판 목록</a></li>
            <li><a
               href="${initParam.rootPath }/common/findStorePagingListController.do">매장
                  목록</a></li>

         </ul></li>
      <li class="has-children images"><a href="#0">매장관리자</a>

         <ul>
            <sec:authorize access="hasAnyRole('ROLE_CNB_USER', 'CNB_STORE')">
               <li><a
                  href="${initParam.rootPath }/findOptionCategoryController.do">제품
                     등록</a></li>
               <li><a
                  href="${initParam.rootPath }/findProductListController.do?storeId=<sec:authentication property='principal.storeId'/>">제품
                     목록</a></li>
               
            </sec:authorize>


            <li><a
               href="${initParam.rootPath }/common/findRecipeBoardContentsByMethod.do">전체
                  레시피 게시판 </a></li>
            
         </ul></li>

      <li class="has-children users"><a href="#0">일단 무시해주세요~~~~</a>

         <ul>
            <li><a href="#0">All Users</a></li>
            <li><a href="#0">Edit User</a></li>
            <li><a href="#0">Add User</a></li>
            <sec:authorize access="hasRole('ROLE_CNB_ADMIN')">
            <li><a href="${initParam.rootPath }/admin/userManagementListController.do">관리자 - 유저 매장 관리 목록</a></li>
            <li><a href="${initParam.rootPath }/admin/findpaymentOptionListController.do">플렛폼 지원 결제 목록</a></li>
            <li><a href="${initParam.rootPath }/admin/findUserListBySelectToKeywordController.do">사용자 목록</a></li>
            </sec:authorize>
            
         </ul></li>
      </ul>

      <!-- <<<<<<< HEAD -->
      <ul>
         <li class="cd-label">Action</li>
         <li class="action-btn"><a href="#0">+ Button</a></li>
      </ul>
   </nav>
   <%-- =======

<li  data-toggle="collapse" data-target="#store" class="collapsed active">
                  <a href="#"> 매장관리자  <span class="arrow"></span></a>
</li>
<ul class="sub-menu collapse" id="store">
매장 관리자
<sec:authorize access="hasAnyRole('ROLE_CNB_USER', 'ROLE_CNB_STORE')">
   <li><a href="${initParam.rootPath }/findOptionCategoryController.do">제품 등록</a></li>
   <li><a href="${initParam.rootPath }/findProductListController.do">제품 목록</a></li>
   <li><a href="${initParam.rootPath}/selectStoreController.do?storeId=<sec:authentication property="principal.storeId"/>">내 제품 목록 조회</a></li>
</sec:authorize>
>>>>>>> branch 'master' of https://github.com/nhs7253/coffeeNbread.git
 --%>
   <div class="content-wrapper">
      <h1></h1>
   </div>
   <!-- .content-wrapper --> </main>
   <!-- .cd-main-content -->
   <script type="text/javascript">
      function logout() {
         document.getElementById("logoutForm").submit();
      }
   </script>
   <form id="logoutForm" action="${initParam.rootPath }/logout.do"
      method="post" style="display: none">
      <sec:csrfInput />
   </form>

</body>
</html>