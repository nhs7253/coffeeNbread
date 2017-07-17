<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript"
	src="/coffeeNbread_user/resource/jquery/jquery-3.2.1.js"></script>
	
<script type="text/javascript">

$(document).ready(function(){
	$("#optionCategoryList").on("click",function(){
		
		
		var p2 = document.createElement("input");
		p2.setAttribute("name","optionCategoryList");
		p2.setAttribute("class", "form-control");
		var txt = document.createTextNode($("#optionCategory").val());
		p2.appendChild(txt);
	
		var input = document.getElementById("selectSC");
		input.appendChild(p2);
		
	

		});//end of storeCategoryList

	});//end of document
</script>
<style>
body{

background-image:url(up_image/main2.jpg);
background-size: cover;
background-position: center center;
background-repeat: no-repeat;

}


</style>
<body>
<h2>STORE_REGISTER</h2>
<div class="col-sm-2"></div>
<div class="col-sm-8">
	<form action="${initParam.rootPath }/addStoreController.do"
		method="post" enctype="multipart/form-data">
		<sec:csrfInput />
		<%-- csrf 토큰 --%>
	
		<table >
			<tr class="form-group">
				<th>매장 분류 </th>
				<td><input type="text" name="optionCategoryList"
					id="optionCategory" class="form-control">
					
				</td>
				<td>
				<button type="button" id="optionCategoryList"
					class="btn btn-default btn-circle">
					<i class="glyphicon glyphicon-plus"></i>
				</button>
				</td>
				

			</tr>
		
			<tr class="form-group">
				<th></th>
				<td id="selectSC"></td>
			</tr>
		</table>


		
		
		결제 방식 선택<br />
		<c:forEach items="${requestScope.paymentOptionList }" var="list">
			<input type="checkbox" name="paymentIdList" value="${list.paymentId }"/>${list.paymentMethod }&nbsp;&nbsp;&nbsp;
		</c:forEach>
		
	
		<table>	
			<tr  class="form-group">
				<th>매장 ID</th>

				<td><div class="col-xs-10"><input type="text" name="storeId" class="form-control "></div></td>
			</tr>
			<tr class="form-group">
				<th>매장 이름</th>
				<td><div class="col-xs-10"><input type="text" name="storeName" class="form-control"></div></td>
			</tr>
			<tr class="form-group">
				<th>매장 번호</th>
				<td><div class="col-xs-10"><input type="tel" name="storePhone" class="form-control"></div></td>
			</tr>
			<tr class="form-group">
				<th>매장 메일</th>
				<td><div class="col-xs-10"><input type="email" name="storeEmail" class="form-control"></div></td>
			</tr>
			<tr class="form-group">
				<th>open 시간</th>
				<td><div class="col-xs-5">
				<input type="text" name="storeOpen" class="form-control">
					</div></td>
			</tr>
			<tr class="form-group">
				<th>close 시간</th>
				<td><div class="col-xs-5"><input type="text" name="storeClose" class="form-control"></div></td>
			</tr>
			<tr>
				<th>매장 사진</th>
				<td><input type="file" name="storePictureList"></td>
			</tr>
			<tr class="form-group">
				<th>매장 위치</th>
				<td><input type="text" name="storeAddress" class="form-control"></td>
			</tr>
			<tr>
				<th>매장 좌표</th>
				<td>
					<div id="map" style="width:100%;height:350px;"></div>
					<div id="clickLatlng"></div>
					<input type="hidden" name="X" id="X" value="">
					<input type="hidden" name="Y" id="Y" value="">
				</td>
			</tr>
			<tr>
				<th>매장 소개</th>
				<td><textarea name="storeIntro" rows="5" cols="50"></textarea></td>
			</tr>

			<tr>
				<td colspan="2">
				<button type="submit"
						class="btn btn-custom">
						<i class="glyphicon glyphicon-ok"></i> 등록
				</button></td>
			</tr>
		</table>

	</form></div>
<div class="col-sm-2"></div>

</body>


<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=e734ba3c1ac8600bcc1f96d038d46ae6"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new daum.maps.LatLng(37.40207145053021, 127.10662597538649), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new daum.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

//HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
if (navigator.geolocation) {
    
    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
    navigator.geolocation.getCurrentPosition(function(position) {
        
        var lat = position.coords.latitude, // 위도
            lon = position.coords.longitude; // 경도
        
        var locPosition = new daum.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
            message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다
        
        // 마커와 인포윈도우를 표시합니다
        displayMarker(locPosition, message);
            
      });
    
} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
    
    var locPosition = new daum.maps.LatLng(37.40207145053021, 127.10662597538649),    
        message = 'geolocation을 사용할수 없어요..'
        
    displayMarker(locPosition, message);
}

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
    
    // 지도 중심좌표를 접속위치로 변경합니다
    map.setCenter(locPosition);      
}  

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
daum.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
    document.getElementById('X').setAttribute('value', latlng.getLat());
    document.getElementById('Y').setAttribute('value', latlng.getLng());
    
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('clickLatlng'); 
    resultDiv.innerHTML = message;
    
});
</script>

</html>