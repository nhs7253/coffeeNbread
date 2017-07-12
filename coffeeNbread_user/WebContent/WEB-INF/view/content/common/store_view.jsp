<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



</head>
<body>
	 
	<h1>매장 상세</h1><hr><br>
	
		매장명 : <input type="text" value="${requestScope.store.storeName }" disabled><br>
		<c:if test="${!empty requestScope.store.storePictureList[0].storePicture }">
			<img src="${initParam.rootPath }/up_image/${requestScope.store.storePictureList[0].storePicture }" alt="" /><br />
		</c:if>
		매장 소개 :<br>
		 <textarea rows="10" cols="60" disabled>
		 	${requestScope.store.storeIntro }
		 </textarea> <br />
		매장 주소 : <input type="text" value="${requestScope.store.storeAddress }" disabled><br>
		매장 이메일 : <input type="text" value="${requestScope.store.storeEmail }" disabled><br>
		매장 여는 시간 : <input type="text" value="${requestScope.store.storeOpenFormat }" disabled><br>
		매장 닫는 시간 : <input type="text" value="${requestScope.store.storeCloseFormat }" disabled><br>
		<p/>
		
		
		<sec:authorize access="hasAnyRole('ROLE_CNB_USER', 'CNB_STORE')">
			<form action="${initParam.rootPath }/user/addStoreBookmarkController.do" method="post">
				<sec:csrfInput/>
				<input type="hidden" name="storeId" value="${requestScope.store.storeId }"/>
				<input type="hidden" name="userId" value="<sec:authentication property="principal.userId"/>"/>
				<input type="submit" value="북마크 추가">
			</form>
		</sec:authorize>
		
		<form action="${initParam.rootPath }/findProductListController.do" method="post">
			<sec:csrfInput/>
			<input type="hidden" name="storeId" value="${requestScope.store.storeId }"/>
			<input type="submit" value="제품 목록">
		</form>
				
		<form action="${initParam.rootPath }/user/userFindProductListController.do" method="post">
			<sec:csrfInput/>
			<input type="hidden" name="storeId" value="${requestScope.store.storeId }"/>
			<input type="submit" value="유저가 보는 제품 목록">
		</form>

	