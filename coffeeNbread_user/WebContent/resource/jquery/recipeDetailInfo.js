
	
$(document).ready(function(){
	//alert("aaaaaaaaaa")
	//대분류 선택시 중분류 조회
	$("#first_category").on("change", function(){
		var idx = this.selectedIndex; //this는 셀렉트된 노드객체.
		
		$.ajax({
			type:"POST",
			url:"/_category_jquery_mvc/category/getSecond",
			data:{"firstCategoryId":$("#first_category").val()}, 
			dataType:"JSON",
			beforeSend:function(){
				//선택된 것이 0번 index면 전송하지 않는다.
				
				//this.selectedIndex를 여기서 하면 안된다. -> this는 함수의 소유 객체 이므로 ajax메소드 전달인자 객체이다.
				
				
				if(idx==0){ //함수안에 this쓰면 안된다.
					//기존 선택(나와있는것들) 초기화-중분류, 소분류, 제품List, 제품정보
					$("#second_category").empty().append("<option>중분류</option>");
					$("#third_category").empty().append("<option>소분류</option>");
					$("#thead").empty();
					$("#tbody").empty();
					$("#product_info_layer").hide();
					return false;
				}
			},
			success:function(jsonData){
				//기존 나와있는 정보 초기화 - 소분류, 제품List, 제품정보
				$("#third_category").empty().append("<option>소분류</option>");
				$("#thead").empty();
				$("#tbody").empty();
				$("#product_info_layer").hide();
				
				//중분류 추가ss
				var str = "<option>중분류</option>"; 
				$.each(jsonData, function(){
					  //str+="<option value="+this.categoryId+">"+this.categoryName+"</option>";
					str = str+"<option value='"+this.categoryId+"'>"+this.categoryName+"</option>";
				});

				$("#second_category").html(str); 
			},
			error:errorCallback// error에는 함수가 와야한다.현재는 변수가 와있는상태이므로 무엇대신에 쓰여있는지 보기 // 만약 뒤에()이 있으면  함수를 호출해서 리턴하는 값을 넣는것. 
		});
	});

	//중분류 선택시 소분류 조회
	$("#second_category").on("change", function(){
		$.ajax({
			type:"POST",
			url:"/_category_jquery_mvc/category/getThird",
			data:{"secondCategoryId":$("#second_category").val()},
			dataType:"JSON",
			beforeSend:function(){
				//선택된 것이 0번 index면 전송하지 않는다.
				//$(셀렉터1).index($(셀렉터2)||Node객체) -> 셀렉터1로 조회한 것들중 매개변수로 전달한 셀렉터2 또는 Node객체가 몇번째 Node인지 index리턴
				if($("#second_category option").index($("#second_category option:selected"))==0){
					alert("중분류 선택하세요");
					//기존 선택(나와있는것들) 초기화-소분류, 제품List, 제품정보
					$("#third_category").empty().append("<option>소분류</option>");
					$("#thead").empty();
					$("#tbody").empty();
					$("#product_info_layer").hide();
					return false;
				}
			},
			success:function(jsonData){
				//기존 나와있는 정보 초기화 - 제품List, 제품정보
				$("#thead").empty();
				$("#tbody").empty();
				$("#product_info_layer").hide();
				
				//소분류 추가.
				var str = "<option>소분류</option>";
				$.each(jsonData, function(){
					str = str +"<option value='"+this.categoryId+"'>"+this.categoryName+"</option>";
				});
				
				$("#third_category").html(str);
			},
			error:errorCallback
		});
	});
	
	//소분류 선택시 상품 목록 조회
	$("#third_category").on("change", function(){
		$.ajax({
			type:"POST", 
			url:"/_category_jquery_mvc/product/getList",
			data:{"command":"get_product_list", "thirdCategoryId":$("#third_category").val()},
			dataType:"JSON",
			/*beforeSend:function(){
				if($("#third_category option").index($("#third_category option:selected"))==0){
					alert("소분류 선택하세요");
					//기존 선택(나와있는것들) 초기화-제품List, 제품정보
					$("#thead").empty();
					$("#tbody").empty();
					$("#product_info_layer").hide();
					return false;
				}
			},*/
			success:function(jsonData){
				//기존 나와있는 정보 초기화 - 제품정보
				$("#product_info_layer").hide();
				
				//thead 구성
				$("#thead").empty().append("<tr><td>제품ID</td><td>제품명</td><td>제조사</td><td>제품가격</td></tr>");
				//tbody 구성
				var trs = "";
				$.each(jsonData, function(){
					trs = trs+"<tr><td>"+this.productId+"</td><td>"+this.productName+"</td><td>"+this.productMaker+"</td><td>"+this.productPrice+" 원</td></tr>";
				});
				$("#tbody").html(trs);
				
			},
			error:errorCallback
		});
	});

	//상품 정보 조회 처리
	$("#tbody").on("click", "tr", function(){//tr에 event 처리
		
		$("#tbody tr").css("background-color", "white");
		$(this).css("background-color", "lightgray");
		
		
		$.ajax({
			type:"POST",
			url:"/_category_jquery_mvc/product/getInfoByProductId",
			data:{"productId":$(this).find(":first").text()}, //this : event 소스(tr) - 함수내에서의 this가 아니므로 this는 event 소스가 된다. ///firstchild해도 상관없다.
			dataType:"JSON",
			success:function(obj){
				//div에 조회한 제품 정보 넣기
				$("#product_info_layer").text(obj.productInfo);
				//div 보이도록하기
				$("#product_info_layer").show();
			},
			error:errorCallback
		});
	});
});
//서버에서 오류 발생시 실행할 callback 함수 - 모든 ajax 처리에서 같은 방식으로 처리하므로 함수를 선언해 놓고 등록하도록 한다.
function errorCallback(xhr, status, err){
		alert(status+", "+xhr.readyState+" "+err);
}

