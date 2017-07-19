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
   <br><br>
      <ul>
     	<li class="cd-label">Main</li>
		<li class="has-children comments" ><a href="#0" style="font-size:20px"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;STORE</a>
        <ul>
        	<!-- 유저 권한 -->
     		<sec:authorize access="hasAnyRole( 'CNB_USER')">
           		<li><a href="${initParam.rootPath }/common/findStorePagingListController.do">STORE LIST</a></li>
				<li><a href="${initParam.rootPath }/user/callStoreRegisterController.do">매장 등록</a></li>
			</sec:authorize>
			
			<!-- 매장 관리자 권한 -->
			<sec:authorize access="hasAnyRole('CNB_STORE')">
				<%--<li><a href="${initParam.rootPath }/user/QnA_board_register_form.do">Q&A 글쓰기</a></li>
					<li><a href="${initParam.rootPath }/user/QnA_board_register_form.do?storeId=s-1">매장 Q&A 글쓰기</a></li> --%>
				<li><a href="${initParam.rootPath }/common/findStorePagingListController.do">STORE LIST</a></li>
				<li><a href="${initParam.rootPath }/common/viewStoreController.do?storeId=<sec:authentication property='principal.storeId'/>">내 매장 보기</a></li>						
				<li><a href="${initParam.rootPath }/findOptionCategoryController.do">제품 등록</a></li>
               	<li><a href="${initParam.rootPath }/findProductListController.do?storeId=<sec:authentication property='principal.storeId'/>">제품  목록</a></li>
				<li><a href="${initParam.rootPath }/common/findQnaBoardContentsBySelectToKeywordController.do?storeId=s-1">매장 Q&A 게시판</a></li>
				<li><a href="${initParam.rootPath }/store/findProductListToPOSController.do">POS</a></li>
				<li><a href="${initParam.rootPath }/findSalesVolumeTodayController.do">판매량 조회</a></li>
				<li><a href="${initParam.rootPath }/findReservationDetailsController.do">예약 현황 조회</a></li>
			</sec:authorize>
		</ul>
		</li>

		<li class="cd-label">Secondary</li>
      	<br>
      	<li class="has-children bookmarks"><a href="${initParam.rootPath }/common/findRecipeBoardContentsByMethod.do" style="font-size:20px"><span class="glyphicon glyphicon-cutlery"></span>&nbsp;&nbsp;RECIPE</a></li>
        <br>
      	<li class="has-children images"><a href="${initParam.rootPath }/common/findNoticeBoardContentsPagingListController.do" style="font-size:20px"><span class="glyphicon glyphicon-bullhorn"></span>&nbsp;&nbsp;공지사항</a>
		<br>
      	<li class="has-children users"><a href="${initParam.rootPath }/common/findQnaBoardContentsBySelectToKeywordController.do" style="font-size:20px"><span class="glyphicon glyphicon-question-sign"></span>&nbsp;&nbsp;QnA</a></li>
		<br>
		
		<li class="has-children users"><a href="#0" style="font-size:20px"><span class="glyphicon glyphicon-tower"></span>&nbsp;&nbsp;ADMIN</a>
		<ul>
			<!-- 전체 관리자 권한 -->
			<sec:authorize access="hasRole('ROLE_CNB_ADMIN')">
    			<li><a href="${initParam.rootPath }/admin/userManagementListController.do">관리자 - 유저 매장 관리 목록</a></li>
	            <li><a href="${initParam.rootPath }/admin/findpaymentOptionListController.do">플렛폼 지원 결제 목록</a></li>
	            <li><a href="${initParam.rootPath }/admin/findUserListBySelectToKeywordController.do">사용자 목록</a></li>
		    </sec:authorize>
	    </ul>
	    </li>
  
     </ul>
   </nav>
 
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