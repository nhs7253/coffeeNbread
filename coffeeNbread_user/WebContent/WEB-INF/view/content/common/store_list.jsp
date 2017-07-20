<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


	
<style type="text/css">
@font-face {
	font-family: 'title';
	src: local(※), url(http://127.0.0.1:8088/coffeeNbread_user/resource/font/a시나리오.woff) format('woff');
}

h2 {
	font-family: 'title';
	font-size: 45px
}

table, td {
   
}

table {
   width: 700px;
   border-collapse: collapse;
}

td {
   padding: 5px; /* //td 간 간격 */
}
</style>


<style>
    .wrap {text-align: left; overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
    .wrap * {padding: 0;margin: 0;}
    .wrap .info {width: 286px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
    .wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
    .info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
    .info .body {position: relative;overflow: hidden;}
    .info .desc {position: relative;margin: 13px 0 0 90px;}
    .desc .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
    .desc .jibun {font-size: 11px;color: #888;margin-top: -2px;}
    .info .img {position: absolute;top: 6px;left: 5px;width: 73px;height: 71px;border: 1px solid #ddd;color: #888;overflow: hidden;}
    .info .link {color: #5085BB;}
</style>

<div class="col-sm-1"></div>

<div class="col-sm-10">
<br><br>
<h2>매장 목록</h2>
<div style="float:right">
	<form action="${initParam.rootPath }/common/findStorePagingListController.do" method="post" class="form-inline quick-search-form" role="form">
		<div style="flaot:right">
		<div class="form-group">
		<select name="select" class="form-control">
			<option value="storeName" ${param.select eq "storeName" ? "selected" :""}>이름</option>
			<option value="storeIntro" ${param.select eq "storeIntro" ? "selected" :""}>소개</option>
			<option value="storeAddress" ${param.select eq "storeAddress" ? "selected" :""}>주소</option>
			<option value="storeCategory" ${param.select eq "storeCategory" ? "selected" :""}>카테고리</option>
		</select>
		 <input type="text" name="keyword" class="form-control"/></div>
		 <button type="submit" class="btn" style="background-color:#b6009f"><i class="glyphicon glyphicon-search"></i>&nbsp;검색</button>
		</div>
		<sec:csrfInput/><%-- csrf 토큰 --%>
	</form>
</div>
	<div id="map" style="width:600px;height:300px;margin:auto;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=414b7d7551adbb016aef1956f977d20f"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new daum.maps.LatLng(37.40207145053021, 127.10662597538649),
			level: 3
		};

		var map = new daum.maps.Map(container, options);
		
		// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
		if (navigator.geolocation) {
		    
		    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
		    navigator.geolocation.getCurrentPosition(function(position) {
		        
		        var lat = position.coords.latitude, // 위도
		            lon = position.coords.longitude; // 경도
		        
		        var locPosition = new daum.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
		            message = '<div style="padding:5px;">현재 위치</div>'; // 인포윈도우에 표시될 내용입니다
		        
		        // 마커와 인포윈도우를 표시합니다
		        displayMarker(locPosition, message);
		            
		      });
		    
		} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
		    
		    var locPosition = new daum.maps.LatLng(37.40207145053021, 127.10662597538649),    
		        message = '현재 위치를 파악할 수 없습니다'
		        
		    displayMarker(locPosition, message);
		}
			
		
		var positions = [
			<c:forEach items="${requestScope.list }" var="list" begin="0" varStatus="status">
				<c:choose>
					<c:when test="${status.last}">
						{
							content: '<div class="wrap">' + 
				            '    <div class="info">' + 
				            '        <div class="title">' + 
				            '            ${list.storeName}' + 
				            '        </div>' + 
				            '        <div class="body">' + 
				            '            <div class="img">' +
				            '                <img src="${initParam.rootPath }/up_image/${list.storePictureList[0].storePicture }" width="73" height="70">' +
				            '           </div>' + 
				            '            <div class="desc">' + 
				            '                <div class="ellipsis">${list.storeIntro}</div>' + 
				            '                <div class="jibun ellipsis">${list.storeCategory}</div>' + 
				            '                <div class="jibun ellipsis">${list.storeAddress}</div>' + 
				            '                <div class="jibun ellipsis">${list.storePhone}</div>' + 
				            '                <div class="jibun ellipsis">${list.storeEmail}</div>' + 
				            '            </div>' + 
				            '        </div>' + 
				            '    </div>' +    
				            '</div>', 
					        latlng: new daum.maps.LatLng(${list.storePosition.x}, ${list.storePosition.y})
				 		}   
					</c:when>
					<c:otherwise>
						{
							content: '<div class="wrap">' + 
				            '    <div class="info">' + 
				            '        <div class="title">' + 
				            '            ${list.storeName}' + 
				            '        </div>' + 
				            '        <div class="body">' + 
				            '            <div class="img">' +
				            '                <img src="${initParam.rootPath }/up_image/${list.storePictureList[0].storePicture }" width="73" height="70">' +
				            '           </div>' + 
				            '            <div class="desc">' + 
				            '                <div class="ellipsis">${list.storeIntro}</div>' + 
				            '                <div class="jibun ellipsis">${list.storeCategory}</div>' + 
				            '                <div class="jibun ellipsis">${list.storeAddress}</div>' + 
				            '                <div class="jibun ellipsis">${list.storePhone}</div>' + 
				            '                <div class="jibun ellipsis">${list.storeEmail}</div>' + 
				            '            </div>' + 
				            '        </div>' + 
				            '    </div>' +    
				            '</div>', 
						    latlng: new daum.maps.LatLng(${list.storePosition.x}, ${list.storePosition.y})
					 	}, 
					</c:otherwise>
				</c:choose>
			</c:forEach>
		];
		
		
		// 지도에 마커와 인포윈도우를 표시하는 함수입니다
		function displayMarker(locPosition, message) {

		    // 마커를 생성합니다
		    var marker = new daum.maps.Marker({  
		        map: map, 
		        position: locPosition
		    }); 
		    
		    var iwContent = message, // 인포윈도우에 표시할 내용
		        iwRemoveable = true;

		    // 인포윈도우를 생성합니다
		    var infowindow = new daum.maps.InfoWindow({
		        content : iwContent,
		        removable : iwRemoveable
		    });
		    
		    // 인포윈도우를 마커위에 표시합니다 
		    infowindow.open(map, marker);
		    
		    for (var i = 0; i < positions.length; i ++) {
			    // 마커를 생성합니다
			    var marker = new daum.maps.Marker({
			        map: map, // 마커를 표시할 지도
			        position: positions[i].latlng // 마커의 위치
			    });

			    // 마커에 표시할 인포윈도우를 생성합니다 
			    var infowindow = new daum.maps.InfoWindow({
			        content: positions[i].content, // 인포윈도우에 표시할 내용
				    position: marker.getPosition()  
			    });
			    
		

			    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
			    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
			    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
			    daum.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
			    daum.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
			}
		    
		    // 지도 중심좌표를 접속위치로 변경합니다
		    map.setCenter(locPosition);      
		}    	
		// 마커 위에 커스텀오버레이를 표시합니다
		// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
			
		// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
		function makeOverListener(map, marker, infowindow) {
		    return function() {
		        infowindow.open(map, marker);
		    };
		}

		// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
		function makeOutListener(infowindow) {
		    return function() {
		        infowindow.close();
		    };
		}
		
	</script>
	
	<p/>
	
	
	


	
	<table class="table">
		<thead>
			<tr class="form-group">
				<th>매장이름</th>
				<th>주소</th>
				<th>카테고리</th>
				<th>여는 시간</th>
				<th>닫는 시간</th>
			</tr>
		</thead>
		<tbody>

			<%-- ######################################################
															조회된 item 출력 
				###################################################### --%>
			<c:forEach items="${requestScope.list }" var="list">

				<tr class="form-group">
					<td><a href="${initParam.rootPath }/common/viewStoreController.do?storeId=${list.storeId}">${list.storeName}</a></td>
					<td>${list.storeAddress}</td>
					<td>${list.storeCategory}</td>
					<td>${list.storeOpenFormat}</td>
					<td>${list.storeCloseFormat}</td>
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
			href="${initParam.rootPath }/common/findStorePagingListController.do?page=1&select=${requestScope.select}&keyword=${requestScope.keyword}">첫페이지</a>


		<!--
			이전 페이지 그룹 처리.
			만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
		 -->
		<c:choose>
			<c:when test="${requestScope.pageBean.previousPageGroup}">
				<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
				<a
					href="${initParam.rootPath }/common/findStorePagingListController.do?page=${requestScope.pageBean.beginPage-1}&select=${requestScope.select}&keyword=${requestScope.keyword}">◀</a>
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
						href="${initParam.rootPath }/common/findStorePagingListController.do?page=${page}&select=${requestScope.select}&keyword=${requestScope.keyword}">${page }&nbsp;&nbsp;</a>
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
					href="${initParam.rootPath }/common/findStorePagingListController.do?page=${requestScope.pageBean.endPage+1}&select=${requestScope.select}&keyword=${requestScope.keyword}">▶</a>
			</c:when>
			<c:otherwise>
			▶
		</c:otherwise>
		</c:choose>




		<!-- 마지막 페이지로 이동 -->
		<a
			href="${initParam.rootPath }/common/findStorePagingListController.do?page=${requestScope.pageBean.totalPage}&select=${requestScope.select}&keyword=${requestScope.keyword}">마지막
			페이지</a>

		<p/></center>
		
		<!-- mvc 로 등록한 뷰패턴은 get 방식으로만 이동이 가능함 -->
		<sec:authorize access="hasRole('ROLE_CNB_ADMIN')">
			<form action="${initParam.rootPath }/admin/notice_board_register_form.do">
				<sec:csrfInput/>
				<input type="submit" value="등록">
			</form>
		</sec:authorize></div>
<div class="col-sm-1"></div>