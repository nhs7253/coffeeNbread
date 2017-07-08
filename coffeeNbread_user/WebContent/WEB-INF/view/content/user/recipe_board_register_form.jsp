<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script type="text/javascript" src="${initParam.rootPath }/resource/jquery/jquery-3.2.1.js"></script>

<script type="text/javascript">
	
	
$("#tbody").on("click", "tr", function(){//tr에 event 처리
	
	$("#tbody tr").css("background-color", "white");
	$(this).css("background-color", "lightgray");
	
	
	$.ajax({
		type:"POST",
		url:"/coffeeNbread_user/recipeBoard_view.do",
		data:{"recipeBoardNo":$("#btn").val()}, 
		dataType:"JSON",
		success:function(obj){
			
		},
		error:errorCallback
	});
});















/* $(document).ready(function() {

	$("input#btn").on("click", function() {

     
             var confirmflag=comfin("게시글을 등록하였습니다.")
              if(confirmflag){
            	  
            	
              }








function confirmtest(){
    var confirmflag = confrim("confirm 테스트 확인");
  if(confirmflag){
     //확인 버튼 클릭 true 
  }else{
    //취소 버튼 클릭 false
  }
}
















	$(document).ready(function() {

		$("button").on("click", function() {

			
		 	$.ajax({
				
				
				url : "/spring_mvc_ajax/searchMemberList_JSON.do",
				dataType:"json",			/*생략은 해도 받아지는데  확실하게 json 형태로 넘어온다.(api등록했기에) text로하면  생략해도 받아지는 json을 변환못하게해서  객체를 분류해서 따로 받을수 없다. */
				                           
  		/* 		success:function(jsonData){
					
					
					//thead 구성
					$("#thead").empty().append("<tr><td>ID</td><td>이름</td><td>나이</td><td>생일</td></tr>");
					//tbody 구성
					var trs = "";
					$.each(jsonData, function(){
						trs = trs+"<tr><td>"+this.id+"</td><td>"+this.name+"</td><td>"+this.age+"</td><td>"+this.birthday+"</td></tr>";
					});
					$("#tbody").html(trs);
					
				},
				"error":function(){
					alert("에러발생");
				}
                  
			}); 
		})
	}); */
	 
		
	
</script>
<style type="text/css">











</style>
<h1>게시글 작성</h1><hr><br>


<form action="${initParam.rootPath }/user/addRecipeBoardContents.do" method="post" enctype="multipart/form-data">
	<sec:csrfInput/>
	
	제목 : <input type="text" name="recipeBoardTitle" required> <br>
	대표 사진:<input type="file" name="recipeBoardPicture" >
	내용<br>
	 <textarea rows="20" cols="100" name="recipeBoardContent" required></textarea>
	 <input type="hidden" name="storeId" value="${param.storeId }"/>
	<p>
	<input type="submit" id="btn" value="등록">
	</p>
	
</form>

