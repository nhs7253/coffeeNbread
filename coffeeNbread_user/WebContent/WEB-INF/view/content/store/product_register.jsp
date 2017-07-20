<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style type="text/css">
@font-face {
	font-family: 'title';
	src: local(※), url(http://127.0.0.1:8088/coffeeNbread_user/resource/font/a시나리오.woff) format('woff');
}

h2 {
	font-family: 'title';
	font-size: 45px
}

.form-control{

border-bottom-color : purple;

}
</style>

<script type="text/javascript"
	src="/coffeeNbread_user/resource/jquery/jquery-3.2.1.js"></script>
	
<script type="text/javascript">
	$(document).ready(function() {
		$('input[type="checkbox"]').on("click", function() {
			$('input[type="checkbox"]').not(this).prop("checked", false);
		});
	});
</script>
<link rel="stylesheet" href="${initParam.rootPath }/resource/bootstrap/css/demo.css">
<link rel="stylesheet" href="${initParam.rootPath }/resource/bootstrap/css/material-dashboard.css">  
<link rel="stylesheet" href="${initParam.rootPath }/resource/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${initParam.rootPath }/resource/bootstrap/css/reset.css">
<link rel="stylesheet" href="${initParam.rootPath }/resource/bootstrap/css/style.css">
<link rel="stylesheet" href="${initParam.rootPath }/resource/css/background_style.css">

 <script src="${initParam.rootPath }/resource/bootstrap/js/jquery-3.1.0.min.js"></script>
 <script src="${initParam.rootPath }/resource/bootstrap/js/demo.js"></script>
 <script src="${initParam.rootPath }/resource/bootstrap/js/material.min.js"></script>
  <script src="${initParam.rootPath }/resource/bootstrap/js/material-dashboard.js"></script> 
 <script src="${initParam.rootPath }/resource/bootstrap/js/bootstrap.min.js"></script>
 <script src="${initParam.rootPath }/resource/bootstrap/js/jquery.menu-aim.js"></script>
 <script src="${initParam.rootPath }/resource/bootstrap/js/main.js"></script>
 <script src="${initParam.rootPath }/resource/bootstrap/js/modernizr.js"></script>

<h2>제품 등록</h2>
	<div class="col-sm-1"></div>
<div class="col-sm-10">
<div class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-sm-1"></div>
					<div class="col-md-10">
					<div class="card">
					
<div class="card-content">
<form action="${initParam.rootPath }/addProductController.do"
	method="post" enctype="multipart/form-data">
	<sec:csrfInput />
	<%-- csrf 토큰 --%>
	<div class="row">
	
		<div class="col-md-6">
		<div class="form-group label-floating">
			<label class="control-label" >제품 ID</label>
			<input type="text" name="productId" class="form-control">
		</div></div>
		<div class="col-md-6">
		<div class="form-group label-floating">
		<label class="control-label">제품 이름</label>
			
			<input type="text" name="productName" class="form-control">
		</div></div></div>
			<div class="row">
	
		<div class="col-md-6">
		<div class="form-group label-floating">
			<label class="control-label">제품 가격</label>
			<input type="number" min="100" name="productPrice">
		</div></div>
		<div class="col-md-6">
		<label class="control-label">판매 여부</label>
			<input type="checkbox" name="sellingOption" value="Y">판매함
			<input type="checkbox" name="sellingOption" value="N">판매안함
		</div></div>
			
		<div class="row">
	
		<div class="col-md-6">
		<div class="form-group label-floating">
			<label class="control-label">금일 생산량</label>
			<input type="number" min="0" name="todayProductCount">
		</div></div>
		<div class="col-md-6">
		<div class="form-group label-floating">
			<label class="control-label">추천 제품 개수</label>
			<input type="number" min="0" name="recommendProductCount">
		</div></div></div>
		
		<div class="row">
	
		<div class="col-md-12">
		<div class="form-group label-floating">
		<label class="control-label">옵션</label>
			
			<select name="optionId" id="optionId">
					<option>옵션</option>
					<c:forEach items="${requestScope.optionCategoryList }"
						var="optionCategory">
						<option value="${optionCategory.optionId}">${optionCategory.optionCategory }</option>
					</c:forEach>
			</select></div></div></div>
		<div class="row">
	
		<div class="col-md-12">
		<div class="form-group label-floating">
		<label class="control-label">제품 사진</label>
		<button>사진 추가</button><input type="file" name="productPicture">
		</div></div></div>
		
			<div style="float:right">
				<button type="submit" class="btn btn-custom" >
					<i class="glyphicon glyphicon-ok"></i> 등록
				</button>
</div>
</form>
</div></div></div>
			</div>		</div>
				</div>
<div class="col-sm-1"></div>
		
	</div><div class="col-sm-1"></div>