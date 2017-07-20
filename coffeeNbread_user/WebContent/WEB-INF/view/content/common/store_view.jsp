<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<style>

form {
	display: inline
}
th{
	 width:30%;
}
td{
	 width:70%;
}
</style>


</head>
<body>
	
	<div class="col-sm-1"></div>
	
	<div class="col-sm-4">
	<h1>STORE_DETAIL</h1>
	<hr>
	<br>
		<c:if
			test="${!empty requestScope.store.storePictureList[0].storePicture }">
			<img
				src="${initParam.rootPath }/up_image/${requestScope.store.storePictureList[0].storePicture }"
				alt="" width="100%" />
			
		</c:if>
		<div id="map" style="width: 100%; height: 250px;"></div>

	</div>
	
	<div style="float:none">

		<form
			action="${initParam.rootPath }/user/userFindProductListController.do"
			method="post">
			<sec:csrfInput />
			<input type="hidden" name="storeId"
				value="${requestScope.store.storeId }" />
				<button type="submit" class="btn btn-link btn-lg">
					<i class="glyphicon glyphicon-list"></i>&nbsp;제품 목록
				</button>
		</form>
		
		<form action="${initParam.rootPath }/common/findQnaBoardContentsBySelectToKeywordController.do" method="post">
			<sec:csrfInput/>
			<input type="hidden" name="storeId" value="${requestScope.store.storeId }" />
			<button type="submit" class="btn btn-link btn-lg">
					<i class="glyphicon glyphicon-list"></i>&nbsp;매장  Q&A 
			</button>
		</form>
		
		
	</div>
	<div class="col-sm-6">
	<br><br><br><br><br><br>
		<table class="table" width="100%">
			<tr class="form-group">
				<th>매장명</th>
				<td><div class="col-xs-10">
						${requestScope.store.storeName }
					</div></td>
			</tr>

			<tr class="form-group">
			<th>매장 주소</th>
				
				<td><div class="col-xs-10">
						${requestScope.store.storeAddress }
					</div></td>
			</tr>
			<tr class="form-group">
			<th>매장 이메일</th>
				
				<td><div class="col-xs-10">
						${requestScope.store.storeEmail }
					</div></td>
			</tr>
			<tr class="form-group">
			<th>매장 여는 시간</th>
				
				<td><div class="col-xs-10">
						${requestScope.store.storeOpenFormat }
					</div></td>
			</tr>
			<tr class="form-group">
			<th>매장 닫는 시간</th>
				
				<td width="60%">
					<div class="col-xs-10">
						${requestScope.store.storeCloseFormat }
					</div>
				</td>
			</tr>

			<tr class="form-group">
			<th>매장 소개</th>
				
				<td>
				<div class="col-xs-10">
						<textarea rows="15" cols="55" disabled style="background-color:transparent">${requestScope.store.storeIntro }
						</textarea>
				</div>
					</td>
			</tr>
		</table>
	
	<div style="float:right">
		<!-- 회원만 보임 -->
		<sec:authorize access="hasAnyRole('ROLE_CNB_USER', 'CNB_STORE')">
			<form
				action="${initParam.rootPath }/user/addStoreBookmarkController.do"
				method="post">
				<sec:csrfInput />
				<input type="hidden" name="storeId"
					value="${requestScope.store.storeId }" /> <input type="hidden"
					name="userId"
					value="<sec:authentication property="principal.userId"/>" />
				<button type="submit" class="btn btn-warning">
					<i class="glyphicon glyphicon-plus"></i>&nbsp;북마크추가
				</button>
			</form>
		</sec:authorize>
		
		<br>
		
		<!-- 본인만 보임 -->
		<c:if test="${requestScope.authority }">
		
			<form action="${initParam.rootPath}/user/callStoreModifyController.do"  >
				<button type="submit" class="btn btn-info"><i class="glyphicon glyphicon-pencil"></i>&nbsp;수정</button>
			</form>
			
			<form action="${initParam.rootPath }/removeStoreController.do">
					<button type="submit" class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i>&nbsp;삭제</button>
			</form>
			
			<form action="${initParam.rootPath }/findProductListController.do" method="post">
				<sec:csrfInput />
				<input type="hidden" name="storeId" value="${requestScope.store.storeId }" /> 
				<button type="submit" class="btn"><i class="glyphicon glyphicon-list"></i>&nbsp;제품 관리</button><br>
			</form>
			
		</c:if>

	</div>

</div>
	
	<div class="col-sm-1"></div>

	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=414b7d7551adbb016aef1956f977d20f"></script>
	<script>

		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = { 
		        center: new daum.maps.LatLng(${requestScWope.store.storePosition.x }, ${requestScope.store.storePosition.y }), // 지도의 중심좌표
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