<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.js"></script>

<style type="text/css">
table {

     width: 100%;
    height: 200px;
    
    border-top: 1px solid #444444;
    border-collapse: collapse;
}
th{
    border-bottom: 1px solid ;
    padding: 10px;
    text-align: center;
}
  
form{
  display:inline;
}
td{
  text-align:center;
}
  <html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>CSS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
      #jb-container {
        width: 940px;
        margin: 10px auto;
        padding: 20px;
        border: 1px solid #bcbcbc;
      }
      #jb-header {
        padding: 20px;
        margin-bottom: 20px;
        border: 1px solid #bcbcbc;
      }
      #jb-content {
        width: 580px;
        padding: 20px;
        margin-bottom: 20px;
        float: left;
        border: 1px solid #bcbcbc;
      }
      #jb-sidebar {
        width: 260px;
        padding: 20px;
        margin-bottom: 20px;
        float: right;
        border: 1px solid #bcbcbc;
      }
      #jb-footer {
        clear: both;
        padding: 20px;
        border: 1px solid #bcbcbc;
      }
      @media ( max-width: 480px ) {
        #jb-container {
          width: auto;
        }
        #jb-content {
          float: none;
          width: auto;
        }
        #jb-sidebar {
          float: none;
          width: auto;
        }
      }
@font-face {
	font-family: 'title';
	src: local(※), url(http://127.0.0.1:8088/coffeeNbread_user/resource/font/a시나리오.woff) format('woff');
}

h2 {
	font-family: 'title';
	font-size: 60px
}
    </style>

</head>
<body>


		<div class="col-sm-11">
		<br><br>
		<h2><img src="http://127.0.0.1:8088/coffeeNbread_user/resource/css/recipe.png">&nbsp;레시피</h2>
	<div style="float:right">
			<form
				action="${initParam.rootPath }/common/findRecipeBoardContentsByMethod.do"
				method="post" class="form-inline quick-search-form" role="form">
				<div class="form-group">
				<select name="select" class="form-control">
					<option value="recipeBoardTitle"
						${param.select eq "recipeBoardTitle" ? "selected" :""}>제목</option>
					<option value="recipeBoardContent"
						${param.select eq "recipeBoardContent" ? "selected" :""}>내용</option>
					<option value="recipeBoardDate"
						${param.select eq "recipeBoardDate" ? "selected" :""}>최신
						날짜순</option>
					<option value="recipeBoardHits"
						${param.select eq "recipeBoardHits" ? "selected" :""}>조회순</option>
					<option value="userId" ${param.select eq "userId" ? "selected" :""}>내가
						쓴글</option>

				</select> <input type="text" name="keyword" class="form-control" />
				</div>
				<button type="submit" class="btn" style="background-color:#FFCC33">
					<i class="glyphicon glyphicon-search"></i>&nbsp;검색
				</button>

				<sec:csrfInput />
				<%-- csrf 토큰 --%>
			</form>
	
		<sec:authorize access="hasAnyRole('ROLE_CNB_USER,ROLE_CNB_STORE')">
			<a href="${initParam.rootPath }/user/recipe_board_register_form.do">
				<button type="submit" class="btn" style="background-color:#fa8072">
					<i class="glyphicon glyphicon-ok"></i>&nbsp;글쓰기
				</button>
			</a>
		</sec:authorize>
	
	</div>
	<br>
	<br>
	<br>
	<br><br>






	<table class="table">
		<thead>
			<tr >
				<th style="font-weight:bold; background-color:lightyellow">글번호</th>
				<th style="font-weight:bold; background-color:lightyellow">사진</th>
				<th style="font-weight:bold; background-color:lightyellow">제목</th>
				<th style="font-weight:bold; background-color:lightyellow">작성자</th>
				<th style="font-weight:bold; background-color:lightyellow">작성일</th>
				<th style="font-weight:bold; background-color:lightyellow">조회수</th>
				<%-- <c:choose>
                <c:when test="${param.userId != null}">
                <th>내가 쓴 글 조회</th>
                </c:when>
            </c:choose> --%>

			</tr>
		</thead>
		<tbody>

			<%-- ######################################################
															조회된 item 출력 
				###################################################### --%>
			<c:forEach items="${requestScope.list }" var="list">

				<tr >
					<td>${list.recipeBoardNo}</td>
					<c:forEach items="${list.recipeBoardPicture }" var="fileName">
						<td><img src="${initParam.rootPath }/up_image/${fileName }"
							width="100px" height="100px"></td>
					</c:forEach>
					<td ><a href="${initParam.rootPath }/common/viewRecipeBoardContentsByReplyListController.do?recipeBoardNo=${list.recipeBoardNo}&userId=${list.userId}">${list.recipeBoardTitle}</a></td>
					<td>${list.userId}</td>
					<td><fmt:formatDate value="${list.recipeBoardDate}" pattern="yyyy-MM-dd "/></td>
					
					<td>${list.recipeBoardHits}</td>




				</tr>
			</c:forEach>

		</tbody>
	</table>
	<center>
	<p>
		<%--######################################################
															페이징 처리
				###################################################### --%>
		<!-- 첫페이지로 이동 -->
		<a
			href="${initParam.rootPath }/common/findRecipeBoardContentsByMethod.do?page=1&select=${requestScope.select}&keyword=${requestScope.keyword}&storeId=${requestScope.storeId}">첫페이지</a>


		<!--
			이전 페이지 그룹 처리.
			만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
		 -->
		<c:choose>
			<c:when test="${requestScope.pageBean.previousPageGroup}">
				<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
				<a
					href="${initParam.rootPath }/common/findRecipeBoardContentsByMethod.do?page=${requestScope.pageBean.beginPage-1}&select=${requestScope.select}&keyword=${requestScope.keyword}&storeId=${requestScope.storeId}">◀</a>
			</c:when>
			<c:otherwise>
				◀
			</c:otherwise>
		</c:choose>





		<!-- 
		현재 page가 속한 page 그룹내의 페이지들 링크.
		현재 pageGroup의 시작page ~ 끝 page
	 -->
		<!-- 만약에 page가 현재페이지면 링크처리를 하지 않고 page가 현재페이지가 아니라면 링크처리. -->

		<c:forEach begin="${requestScope.pageBean.beginPage }"
			end="${requestScope.pageBean.endPage }" var="page">
			<c:choose>
				<c:when test="${page != requestScope.pageBean.page}">
					<!-- 현재페이지가 아니라면 -->
					<a
						href="${initParam.rootPath }/common/findRecipeBoardContentsByMethod.do?page=${page}&select=${requestScope.select}&keyword=${requestScope.keyword}&storeId=${requestScope.storeId}">${page }&nbsp;&nbsp;</a>
				</c:when>
				<c:otherwise>
				[${page}]&nbsp;&nbsp;
			</c:otherwise>
			</c:choose>

		</c:forEach>



		<!-- 
		다음페이지 그룹으로 이동
		만약에 다음페이지 그룹이 있으면 링크 처리 없으면 화살표만 나오도록 처리
	 -->
		<c:choose>
			<c:when test="${requestScope.pageBean.nextPageGroup}">
				<a
					href="${initParam.rootPath }/common/findRecipeBoardContentsByMethod.do?page=${requestScope.pageBean.endPage+1}&select=${requestScope.select}&keyword=${requestScope.keyword}&storeId=${requestScope.storeId}">▶</a>
			</c:when>
			<c:otherwise>
			▶
		</c:otherwise>
		</c:choose>




		<!-- 마지막 페이지로 이동 -->
		<a
			href="${initParam.rootPath }/common/findRecipeBoardContentsByMethod.do?page=${requestScope.pageBean.totalPage}&select=${requestScope.select}&keyword=${requestScope.keyword}&storeId=${requestScope.storeId}">마지막
			페이지</a></p></center></div>
<div class="col-sm-1"></div>