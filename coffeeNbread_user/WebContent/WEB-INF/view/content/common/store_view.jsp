<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>



</head>
<body>


	<h1>매장 상세</h1><hr><br>
	
		매장명 : <input type="text" value="${requestScope.store.storeName }" disabled class="form-control"><br>
		<c:if test="${!empty requestScope.store.storePictureList[0].storePicture }">
			<img src="${initParam.rootPath }/up_image/${requestScope.store.storePictureList[0].storePicture }" alt="" /><br />
		</c:if>
		매장 소개 :<br>
		 <textarea rows="10" cols="60" disabled>
		 	${requestScope.store.storeIntro }
		 </textarea> <br />
		매장 주소 : <input type="text" value="${requestScope.store.storeAddress }" disabled class="form-control"><br>
		매장 이메일 : <input type="text" value="${requestScope.store.storeEmail }" disabled class="form-control"><br>
		매장 여는 시간 : <input type="text" value="${requestScope.store.storeOpenFormat }" disabled class="form-control"><br>
		매장 닫는 시간 : <input type="text" value="${requestScope.store.storeCloseFormat }" disabled class="form-control"><br>
		매장 위치 : <br />
		<div id="map" style="width:100%;height:350px;"></div>
		<p/>
		
		<form action="${initParam.rootPath}/user/callStoreModifyController.do"  >
				<button type="submit" class="btn"><i class="glyphicon glyphicon-pencil"></i>수정</button>
		</form>
		<form action="${initParam.rootPath }/removeStoreController.do">
				<button type="submit" class="btn"><i class="glyphicon glyphicon-trash"></i>삭제</button>
		</form>
		
		<sec:authorize access="hasAnyRole('ROLE_CNB_USER', 'CNB_STORE')">
			<form action="${initParam.rootPath }/user/addStoreBookmarkController.do" method="post">
				<sec:csrfInput/>
				<input type="hidden" name="storeId" value="${requestScope.store.storeId }"/>
				<input type="hidden" name="userId" value="<sec:authentication property="principal.userId"/>"/>
				<button type="submit" class="btn"><i class="glyphicon glyphicon-plus"></i>북마크추가</button>
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
		
		
		
		
		
		<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=e734ba3c1ac8600bcc1f96d038d46ae6"></script>
		<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = { 
		        center: new daum.maps.LatLng(${requestScope.store.storePosition.x }, ${requestScope.store.storePosition.y }), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };
		
		var map = new daum.maps.Map(mapContainer, mapOption);
		
		// 마커가 표시될 위치입니다 
		var markerPosition  = new daum.maps.LatLng(${requestScope.store.storePosition.x }, ${requestScope.store.storePosition.y }); 
		
		// 마커를 생성합니다
		var marker = new daum.maps.Marker({
		    position: markerPosition
		});
		
		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);
		
		var iwContent = '<div style="padding:5px; text-align:center;">${requestScope.store.storeName }</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		    iwPosition = new daum.maps.LatLng(${requestScope.store.storePosition.x }, ${requestScope.store.storePosition.y }); //인포윈도우 표시 위치입니다
		
		// 인포윈도우를 생성합니다
		var infowindow = new daum.maps.InfoWindow({
		    position : iwPosition, 
		    content : iwContent 
		});
		  
		// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
		infowindow.open(map, marker); 
		</script>

