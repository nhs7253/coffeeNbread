<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript"
	src="/coffeeNbread_user/resource/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#optionCategoryList").on("click", function() {

			var p2 = document.createElement("input");
			p2.setAttribute("name", "optionCategoryList");
			p2.setAttribute("class", "form-control");
			var txt = document.createTextNode($("#optionCategory").val());
			p2.appendChild(txt);

			var input = document.getElementById("selectSC");
			input.appendChild(p2);

		});//end of storeCategoryList

		$("#modifystorePicture").on("click", function() {

			$("#storePicture").empty();

			var p2 = document.createElement("input");
			p2.setAttribute("type", "file");
			p2.setAttribute("name", "storePictureList");
			var input = document.getElementById("storePicture");
			input.appendChild(p2);

		})//end of storePicture

	});//end of document
</script>



<body>
<div class="col-sm-1"></div>
	
		<div class="col-sm-10">
	<form action="${initParam.rootPath }/modifyStoreController.do"
		method="post" enctype="multipart/form-data">
		<sec:csrfInput />
		<table>
			<tr class="form-group">
				<th>매장 분류</th>
				<td><c:forEach
						items="${sessionScope.storeInfo.optionCategoryList}"
						var="optionCategoryList">
						<input type="text" name="optionCategoryList" id="optionCategory"
							value="${optionCategoryList.optionCategory}" class="form-control">
					</c:forEach></td>
				<td>
					<button type="button" id="optionCategoryList"
						class="btn btn-default btn-circle">
						<i class="glyphicon glyphicon-plus"></i>
					</button>
				</td>
			<tr>
				<th></th>
				<td id="selectSC"></td>
			</tr>
			<tr>
				<th></th>
				<td id="selectOC"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="storeId"
					value="${sessionScope.storeInfo.storeId}"></td>
				<td><input type="hidden" name="storePermission"
					value="${sessionScope.storeInfo.storePermission}"></td>
			</tr>

			결제 방식 선택
			<br />
			<c:forEach items="${requestScope.paymentOptionList }" var="list">
				<c:forEach items="${sessionScope.storeInfo.storePaymentOptionList }"
					var="storeInfo">
					<c:if test="${list.paymentId  == storeInfo.paymentId }">
						<c:set scope="page" var="checked" value="true" />
					</c:if>
				</c:forEach>
				<input type="checkbox" name="paymentIdList"
					value="${list.paymentId }"
					${pageScope.checked == 'true' ? "checked='checked'" :""} />${list.paymentMethod }&nbsp;&nbsp;&nbsp;
				<c:set scope="page" var="checked" value="false" />
			</c:forEach>

       
         <tr class="form-group">
            <th>매장 이름</th>
            <td><div class="col-xs-10">
                  <input type="text" name="storeName"
                     value="${sessionScope.storeInfo.storeName}" class="form-control">
               </div></td>
         </tr>
         <tr class="form-group">
            <th>매장 번호</th>
            <td><div class="col-xs-10">
                  <input type="tel" name="storePhone"
                     value="${sessionScope.storeInfo.storePhone}" class="form-control">
               </div></td>
         </tr>
         <tr class="form-group">
            <th>매장 메일</th>
            <td><div class="col-xs-10">
                  <input type="email" name="storeEmail"
                     value="${sessionScope.storeInfo.storeEmail }" class="form-control">
               </div></td>
         </tr>
         <tr class="form-group">
            <th>open 시간</th>
            <td><div class="col-xs-5">
                  <input type="text" name="storeOpen"
                     value="<fmt:formatDate value="${sessionScope.storeInfo.storeOpen }"
                  type="time" pattern="hh:mm" />"
                     class="form-control">
               </div></td>
         </tr>
         <tr class="form-group">
            <th>close 시간</th>
            <td><div class="col-xs-5">
                  <input type="text" name="storeClose"
                     value="<fmt:formatDate value="${sessionScope.storeInfo.storeClose }"
                  type="time" pattern="hh:mm" />"
                     class="form-control">
               </div></td>
         </tr>
         <tr>
            <th id="selectSP">매장 사진</th>
            <td id="storePicture">
	            <c:if test="${!empty sessionScope.storeInfo.storePictureList[0].storePicture }">
					<img src="${initParam.rootPath }/up_image/${sessionScope.storeInfo.storePictureList[0].storePicture }" alt="" /><br />
				</c:if>
	           
	            <button type="button" id="modifystorePicture">수정하기</button>
            </td>
         </tr>
         
       	 <tr class="form-group">
			<th>매장 위치</th>
			<td><input type="text" name="storeAddress" class="form-control" value="${sessionScope.storeInfo.storeAddress}"></td>
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
            <td><textarea name="storeIntro" rows="5" cols="50" >${sessionScope.storeInfo.storeIntro}</textarea></td>
         </tr>


			<tr>
				<td colspan="2"><button type="submit" class="btn btn-custom">
						<i class="glyphicon glyphicon-ok"></i>확인
					</button></td>
			</tr>
		</table>
	</form></div><div class="col-sm-1"></div>
</body>

<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=e734ba3c1ac8600bcc1f96d038d46ae6"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new daum.maps.LatLng(${sessionScope.storeInfo.storePosition.x}, ${sessionScope.storeInfo.storePosition.y}), // 지도의 중심좌표
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