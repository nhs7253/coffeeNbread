<%@page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style type="text/css">
table, td {
   border: 1px solid black;
}

table {
   border-collapse: collapse;
}

td {
   padding: 10px; /*td 간 간격 */
}
@font-face {
	font-family: 'title';
	src: local(※), url(http://127.0.0.1:8088/coffeeNbread_user/resource/font/a시나리오.woff) format('woff');
}

h4 {
	font-family: 'title';
	font-size: 35px
}
</style>

<!-- JQPLOT보다 jquery가 먼저 지정되야함 -->
<script type="text/javascript" src="/coffeeNbread_user/resource/jquery/jquery-3.2.1.js"></script>
<!-- JQ-PLOT의 CSS를 설정 -->  
<link rel="stylesheet" type="text/css" href="/coffeeNbread_user/resource/jqplot/jquery.jqplot.css"/>  
<!-- JQ-PLOT의 기본 설정 -->  
<script type="text/javascript" src="/coffeeNbread_user/resource/jqplot/jquery.jqplot.js"/></script>
<script type="text/javascript" src="/coffeeNbread_user/resource/jqplot/excanvas.js"></script>
<!-- Highlighter(마우스 접근시 데이터정보 표시) 설정 -->  
<script type="text/javascript" src="/coffeeNbread_user/resource/jqplot/jqplot.highlighter.js"/></script>  
<!-- 좌표에 관한 정보나 Zoom 기능 사용시 설정 -->  
<script type="text/javascript" src="/coffeeNbread_user/resource/jqplot/jqplot.cursor.js"/></script> 
<!-- 막대그래프 -->
<script type="text/javascript" src="/coffeeNbread_user/resource/jqplot/jqplot.barRenderer.js"/></script>
<!-- 축의 데이터를 날짜형태로 입력하기 위해서 설정 -->  
<script type="text/javascript" src="/coffeeNbread_user/resource/jqplot/jqplot.dateAxisRenderer.js"/></script>  
<!-- 축의 데이터의 Label Option을 설정 -->  
<script type="text/javascript" src="/coffeeNbread_user/resource/jqplot/jqplot.canvasAxisLabelRenderer.js"/></script>  
<!-- Legend(Line에대한 간단한 범례)의 Option을 설정  -->  
<script type="text/javascript" src="/coffeeNbread_user/resource/jqplot/jqplot.enhancedLegendRenderer.js"/></script>  
<!-- 축의 데이터를 순서에 상관없이 자동정렬을 설정 -->  
<script type="text/javascript" src="/coffeeNbread_user/resource/jqplot/jqplot.categoryAxisRenderer.js"/></script>  
<!-- 축의 데이터 표현설정과 그래프위의 점의 Option을 설정 -->  
<script type="text/javascript" src="/coffeeNbread_user/resource/jqplot/jqplot.canvasAxisTickRenderer.js"/></script> 
<script type="text/javascript">
$(document).ready(function(){
	$('input[type="checkbox"]').on("click", function(){
		$('input[type="checkbox"]').not(this).prop("checked", false);
	});
	
	$("#total").on("click", function(){
		$("#graph").nextAll("#chart").remove();
		$("#graph1").nextAll("#chart1").remove();
		$("#br2").prevAll("#optionId").remove();
		$("#br2").prevAll("#optionName").remove();
		$("#br2").prevAll('input[type="button"]').remove();
		$("#br3").prevAll('input[type="button"]').remove();
		$("#br3").prevAll("#productName").remove();
		$("#br1").prevAll('input[type="button"]').remove();
		$("#br1").prevAll('input[type="date"]').remove();
		
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeTotalController.do",
			"success":function(list){
				$("#tbody").remove();
				$("#table").append("<tbody id='tbody'><tr id='tr1'><td id='td1' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>제품명</td>");
				values = list.productNameList;
								
				var txt = "";
				$.each(values, function(index, value){
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td1").after(txt);
				
				$("#table").append("<tr id='tr2'><td id='td2' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>판매량</td>");
				values = list.countList;
				
				var txt = "";
				$.each(values, function(index, value) {
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td2").after(txt);
				
				var name = list.productNameList;
				var count = list.countList;
				
				$("#graph").nextAll("#chart").remove();
				
				$("#graph1").nextAll("#chart1").remove();
				$("#graph1").after("<div id='chart1'></div>");
				
				if(name.length != 0){
					$("#graph").after("<div id='chart'></div>");
					
					var graph = [];
					for(var i=0; i<name.length; i++) {
						graph.push([name[i], count[i]]);
					}
					var plot = $.jqplot('chart', [graph],{
						animate: true,
						animateReplot: true,
						title: "판매량 그래프",
						series: [
							{
								label : "판매량",
								renderer: $.jqplot.BarRenderer,
								pointLabels: {
									show: true
								},
								rendererOptions: {
									animation: {
										speed:2500
									},
									barWidth: 40,
									barPadding: -15,
									barMagin: 0,
									varyBarColor: true
								}
							}
						],
						axes: {
							xaxis: {
								renderer:$.jqplot.CategoryAxisRenderer,
								label: "제품명"
							},
							yaxis: {
								min: 0,
								max: 50,
	 							tickOptions: {
									formatString: '%d'
								},
								label: "판매량"
							}
						},
						highlighter: {
							show: false
						}		
					});
				}
			}
		});
	});
	
	$("#date").on("click", function(){
		$("#graph").nextAll("#chart").remove();
		$("#graph1").nextAll("#chart1").remove();
		$("#br2").prevAll("#optionId").remove();
		$("#br2").prevAll("#optionName").remove();
		$("#br3").prevAll('input[type="button"]').remove();
		$("#br3").prevAll("#productName").remove();
		$("#br1").prevAll('input[type="button"]').remove();
		$("#br1").prevAll('input[type="date"]').remove();
		
		$("#br1").before("<input type='button' value='1주일' id='1주일'/> ");
		$("#br1").before("<input type='button' value='1개월' id='1개월'/> ");
		$("#br1").before("<input type='button' value='3개월' id='3개월'/> ");
		$("#br1").before("<input type='button' value='6개월' id='6개월'/> ");
		$("#br1").before("<input type='button' value='12개월' id='12개월'/> ");
		$("#br1").before("<input id='start' type='date' name='startDate'/>");
		$("#br1").before("<input id='end' type='date' name='endDate'/>");
		$("#br1").before("<input id='searchDate' type='button' value='검색'/>");
	});
	
	$("#category").on("click", function(){
		$("#graph").nextAll("#chart").remove();
		$("#graph1").nextAll("#chart1").remove();
		$("#br1").prevAll('input[type="button"]').remove();
		$("#br1").prevAll('input[type="date"]').remove();
		$("#br3").prevAll('input[type="button"]').remove();
		$("#br3").prevAll("#productName").remove();
		$("#br2").prevAll("#optionId").remove();
		$("#br2").prevAll("#optionName").remove();
		$("#br2").before("<select name='optionId' id='optionId'><option id='option'>종류</option> ");
		
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findOptionController.do",
			"success":function(list){
				values = list.optionList;
	
				var txt = "";
				$.each(values, function(index, value){
					txt += "<option id='optionName'>" + value + "</option>";
				});
				$("#option").after(txt);
				$("#option").after("</select>");
			}
		});
	});
	
	$("#name").on("click", function(){
		$("#graph").nextAll("#chart").remove();
		$("#graph1").nextAll("#chart1").remove();
		$("#br1").prevAll('input[type="button"]').remove();
		$("#br1").prevAll('input[type="date"]').remove();
		$("#br2").prevAll("#optionId").remove();
		$("#br2").prevAll("#optionName").remove();
		$("#br3").prevAll('input[type="button"]').remove();
		$("#br3").prevAll("#productName").remove();
		
		$("#br3").before("<input id='productName' type='text'/> ");
		$("#br3").before("<input id='searchName' type='button' value='검색'/>");
	});
	
	$(document).on("click", "#1주일",  function(){
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeByMethodController.do",
			"type":"GET",
			"data":{"method":"1주일"},
			"success":function(list){
				$("#tbody").remove();
				$("#table").append("<tbody id='tbody'><tr id='tr1'><td id='td1' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>제품명</td>");
				values = list.productNameList;
	
				var txt = "";
				$.each(values, function(index, value){
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td1").after(txt);
				
				$("#table").append("<tr id='tr2'><td id='td2' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>판매량</td>");
				values = list.countList;
				
				var txt = "";
				$.each(values, function(index, value) {
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td2").after(txt);
				
				var name = list.productNameList;
				var count = list.countList;
				
				$("#graph").nextAll("#chart").remove();
				
				$("#graph1").nextAll("#chart1").remove();
				$("#graph1").after("<div id='chart1'></div>");
				
				if(name.length != 0){
					$("#graph").after("<div id='chart'></div>");
			
					var graph = [];
					for(var i=0; i<name.length; i++) {
						graph.push([name[i], count[i]]);
					}
					var plot = $.jqplot('chart', [graph],{
						animate: true,
						animateReplot: true,
						title: "판매량 그래프",
						series: [
							{
								label : "판매량",
								renderer: $.jqplot.BarRenderer,
								pointLabels: {
									show: true
								},
								rendererOptions: {
									animation: {
										speed:2500
									},
									barWidth: 40,
									barPadding: -15,
									barMagin: 0,
									varyBarColor: true
								}
							}
						],
						axes: {
							xaxis: {
								renderer:$.jqplot.CategoryAxisRenderer,
								label: "제품명"
							},
							yaxis: {
								min: 0,
								max: 150,
	 							tickOptions: {
									formatString: '%d'
								},
								label: "판매량"
							}
						},
						highlighter: {
							show: false
						}
					});
				}
			}
		});
	});
	
	$(document).on("click", "#1개월",  function(){
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeByMethodController.do",
			"type":"GET",
			"data":{"method":"1개월"},
			"success":function(list){
				$("#tbody").remove();
				$("#table").append("<tbody id='tbody'><tr id='tr1'><td id='td1' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>제품명</td>");
				values = list.productNameList;
	
				var txt = "";
				$.each(values, function(index, value){
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td1").after(txt);
				
				$("#table").append("<tr id='tr2'><td id='td2' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>판매량</td>");
				values = list.countList;
				
				var txt = "";
				$.each(values, function(index, value) {
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td2").after(txt);
				
				var name = list.productNameList;
				var count = list.countList;
				
				$("#graph").nextAll("#chart").remove();
				
				$("#graph1").nextAll("#chart1").remove();
				$("#graph1").after("<div id='chart1'></div>");
				
				if(name.length != 0){
					$("#graph").after("<div id='chart'></div>");
			
					var graph = [];
					for(var i=0; i<name.length; i++) {
						graph.push([name[i], count[i]]);
					}
					var plot = $.jqplot('chart', [graph],{
						animate: true,
						animateReplot: true,
						title: "판매량 그래프",
						series: [
							{
								label : "판매량",
								renderer: $.jqplot.BarRenderer,
								pointLabels: {
									show: true
								},
								rendererOptions: {
									animation: {
										speed:2500
									},
									barWidth: 40,
									barPadding: -15,
									barMagin: 0,
									varyBarColor: true
								}
							}
						],
						axes: {
							xaxis: {
								renderer:$.jqplot.CategoryAxisRenderer,
								label: "제품명"
							},
							yaxis: {
	 							tickOptions: {
									formatString: '%d'
								},
								label: "판매량"
							}
						},
						highlighter: {
							show: false
						}
					});
				}
			}
		});
	});
	
	$(document).on("click", "#3개월",  function(){
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeByMethodController.do",
			"type":"GET",
			"data":{"method":"3개월"},
			"success":function(list){
				$("#tbody").remove();
				$("#table").append("<tbody id='tbody'><tr id='tr1'><td id='td1' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>제품명</td>");
				values = list.productNameList;
	
				var txt = "";
				$.each(values, function(index, value){
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td1").after(txt);
				
				$("#table").append("<tr id='tr2'><td id='td2' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>판매량</td>");
				values = list.countList;
				
				var txt = "";
				$.each(values, function(index, value) {
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td2").after(txt);
				
				var name = list.productNameList;
				var count = list.countList;
				
				$("#graph").nextAll("#chart").remove();
				
				$("#graph1").nextAll("#chart1").remove();
				$("#graph1").after("<div id='chart1'></div>");
				
				if(name.length != 0){
					$("#graph").after("<div id='chart'></div>");
				
					var graph = [];
					for(var i=0; i<name.length; i++) {
						graph.push([name[i], count[i]]);
					}
					var plot = $.jqplot('chart', [graph],{
						animate: true,
						animateReplot: true,
						title: "판매량 그래프",
						series: [
							{
								label : "판매량",
								renderer: $.jqplot.BarRenderer,
								pointLabels: {
									show: true
								},
								rendererOptions: {
									animation: {
										speed:2500
									},
									barWidth: 40,
									barPadding: -15,
									barMagin: 0,
									varyBarColor: true
								}
							}
						],
						axes: {
							xaxis: {
								renderer:$.jqplot.CategoryAxisRenderer,
								label: "제품명"
							},
							yaxis: {
	 							tickOptions: {
									formatString: '%d'
								},
								label: "판매량"
							}
						},
						highlighter: {
							show: false
						}
						
					});
				}
			}
		});
	});
	
	$(document).on("click", "#6개월",  function(){
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeByMethodController.do",
			"type":"GET",
			"data":{"method":"6개월"},
			"success":function(list){
				$("#tbody").remove();
				$("#table").append("<tbody id='tbody'><tr id='tr1'><td id='td1' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>제품명</td>");
				values = list.productNameList;
	
				var txt = "";
				$.each(values, function(index, value){
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td1").after(txt);
				
				$("#table").append("<tr id='tr2'><td id='td2' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>판매량</td>");
				values = list.countList;
				
				var txt = "";
				$.each(values, function(index, value) {
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td2").after(txt);
				
				var name = list.productNameList;
				var count = list.countList;
				
				$("#graph").nextAll("#chart").remove();
				
				$("#graph1").nextAll("#chart1").remove();
				$("#graph1").after("<div id='chart1'></div>");
				
				if(name.length != 0){
					$("#graph").after("<div id='chart'></div>");
			
					var graph = [];
					for(var i=0; i<name.length; i++) {
						graph.push([name[i], count[i]]);
					}
					var plot = $.jqplot('chart', [graph],{
						animate: true,
						animateReplot: true,
						title: "판매량 그래프",
						series: [
							{
								label : "판매량",
								renderer: $.jqplot.BarRenderer,
								pointLabels: {
									show: true
								},
								rendererOptions: {
									animation: {
										speed:2500
									},
									barWidth: 40,
									barPadding: -15,
									barMagin: 0,
									varyBarColor: true
								}
							}
						],
						axes: {
							xaxis: {
								renderer:$.jqplot.CategoryAxisRenderer,
								label: "제품명"
							},
							yaxis: {
	 							tickOptions: {
									formatString: '%d'
								},
								label: "판매량"
							}
						},
						highlighter: {
							show: false
						}
						
					});
				}
			}
		});
	});
	
	$(document).on("click", "#12개월",  function(){
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeByMethodController.do",
			"type":"GET",
			"data":{"method":"12개월"},
			"success":function(list){
				$("#tbody").remove();
				$("#table").append("<tbody id='tbody'><tr id='tr1'><td id='td1' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>제품명</td>");
				values = list.productNameList;
	
				var txt = "";
				$.each(values, function(index, value){
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td1").after(txt);
				
				$("#table").append("<tr id='tr2'><td id='td2' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>판매량</td>");
				values = list.countList;
				
				var txt = "";
				$.each(values, function(index, value) {
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td2").after(txt);
				
				var name = list.productNameList;
				var count = list.countList;
				
				$("#graph").nextAll("#chart").remove();
				
				$("#graph1").nextAll("#chart1").remove();
				$("#graph1").after("<div id='chart1'></div>");
				
				if(name.length != 0){
					$("#graph").after("<div id='chart'></div>");
			
					var graph = [];
					for(var i=0; i<name.length; i++) {
						graph.push([name[i], count[i]]);
					}
					var plot = $.jqplot('chart', [graph],{
						animate: true,
						animateReplot: true,
						title: "판매량 그래프",
						series: [
							{
								label : "판매량",
								renderer: $.jqplot.BarRenderer,
								pointLabels: {
									show: true
								},
								rendererOptions: {
									animation: {
										speed:2500
									},
									barWidth: 40,
									barPadding: -15,
									barMagin: 0,
									varyBarColor: true
								}
							}
						],
						axes: {
							xaxis: {
								renderer:$.jqplot.CategoryAxisRenderer,
								label: "제품명"
							},
							yaxis: {
	 							tickOptions: {
									formatString: '%d'
								},
								label: "판매량"
							}
						},
						highlighter: {
							show: false
						}
					});
				}
			}
		});
	});
	
	$(document).on("click", "#searchDate", function(){
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeByStartEndDateController.do",
			"type":"GET",
			"data":{"startDate":$("#start").val(), "endDate":$("#end").val()},
			"success":function(list){
				$("#tbody").remove();
				$("#table").append("<tbody id='tbody'><tr id='tr1'><td id='td1' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>제품명</td>");
				values = list.productNameList;
	
				var txt = "";
				$.each(values, function(index, value){
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td1").after(txt);
				
				$("#table").append("<tr id='tr2'><td id='td2' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>판매량</td>");
				values = list.countList;
				
				var txt = "";
				$.each(values, function(index, value) {
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td2").after(txt);
				
				var name = list.productNameList;
				var count = list.countList;
				
				$("#graph").nextAll("#chart").remove();
				
				$("#graph1").nextAll("#chart1").remove();
				$("#graph1").after("<div id='chart1'></div>");
				
				if(name.length != 0){
					$("#graph").after("<div id='chart'></div>");
			
					var graph = [];
					for(var i=0; i<name.length; i++) {
						graph.push([name[i], count[i]]);
					}
					var plot = $.jqplot('chart', [graph],{
						animate: true,
						animateReplot: true,
						title: "판매량 그래프",
						series: [
							{
								label : "판매량",
								renderer: $.jqplot.BarRenderer,
								pointLabels: {
									show: true
								},
								rendererOptions: {
									animation: {
										speed:2500
									},
									barWidth: 40,
									barPadding: -15,
									barMagin: 0,
									varyBarColor: true
								}
							}
						],
						axes: {
							xaxis: {
								renderer:$.jqplot.CategoryAxisRenderer,
								label: "제품명"
							},
							yaxis: {
	 							tickOptions: {
									formatString: '%d'
								},
								label: "판매량"
							}
						},
						highlighter: {
							show: false
						}
						
					});
				}
			}
		});
	});
	
	$(document).on("click", "#searchName",  function(){
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeByNameController.do",
			"type":"GET",
			"data":{"productName":$("#productName").val()},
			"success":function(list){
				$("#tbody").remove();
				$("#table").append("<tbody id='tbody'><tr id='tr1'><td id='td1' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>제품명</td>");
				values = list.productNameList;
	
				var txt = "";
				$.each(values, function(index, value){
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td1").after(txt);
				
				$("#table").append("<tr id='tr2'><td id='td2' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>판매량</td>");
				values = list.countList;
				
				var txt = "";
				$.each(values, function(index, value) {
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td2").after(txt);
				
				var name = list.productNameList;
				var count = list.countList;
				
				$("#graph").nextAll("#chart").remove();
				
				$("#graph1").nextAll("#chart1").remove();
				$("#graph1").after("<div id='chart1'></div>");
				
				if(name.length != 0){
					$("#graph").after("<div id='chart'></div>");
			
					var graph = [];
					for(var i=0; i<name.length; i++) {
						graph.push([name[i], count[i]]);
					}
					var plot = $.jqplot('chart', [graph],{
						animate: true,
						animateReplot: true,
						title: "판매량 그래프",
						series: [
							{
								label : "판매량",
								renderer: $.jqplot.BarRenderer,
								pointLabels: {
									show: true
								},
								rendererOptions: {
									animation: {
										speed:2500
									},
									barWidth: 40,
									barPadding: -15,
									barMagin: 0,
									varyBarColor: true
								}
							}
						],
						axes: {
							xaxis: {
								renderer:$.jqplot.CategoryAxisRenderer,
								label: "제품명"
							},
							yaxis: {
								min: 0,
								max: 50,
	 							tickOptions: {
									formatString: '%d'
								},
								label: "판매량"
							}
						},
						highlighter: {
							show: false
						}
						
					});
				}
			}
		});
	});

	$(document).on("change", "#optionId",  function(){
		var values = [];
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeByCategoryController.do",
			"type":"GET",
			"data":{"productCategory":$("#optionId option:selected").val()},
			"success":function(list){
				$("#tbody").remove();
				$("#table").append("<tbody id='tbody'><tr id='tr1'><td id='td1' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>제품명</td>");
				values = list.productNameList;
	
				var txt = "";
				$.each(values, function(index, value){
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td1").after(txt);
				
				$("#table").append("<tr id='tr2'><td id='td2' width='70' align='center' style='font-weight:bold; background-color:LemonChiffon'>판매량</td>");
				values = list.countList;
				
				var txt = "";
				$.each(values, function(index, value) {
					txt += "<td align='center'>" + value + "</td>";
				});
				$("#td2").after(txt);
				
				var name = list.productNameList;
				var count = list.countList;
				
				$("#graph").nextAll("#chart").remove();
				
				$("#graph1").nextAll("#chart1").remove();
				$("#graph1").after("<div id='chart1'></div>");
				
				if(name.length != 0){
					$("#graph").after("<div id='chart'></div>");
			
					var graph = [];
					for(var i=0; i<name.length; i++) {
						graph.push([name[i], count[i]]);
					}
					var plot = $.jqplot('chart', [graph],{
						animate: true,
						animateReplot: true,
						title: "판매량 그래프",
						series: [
							{
								label : "판매량",
								renderer: $.jqplot.BarRenderer,
								pointLabels: {
									show: true
								},
								rendererOptions: {
									animation: {
										speed:2500
									},
									barWidth: 40,
									barPadding: -15,
									barMagin: 0,
									varyBarColor: true
								}
							}
						],
						axes: {
							xaxis: {
								renderer:$.jqplot.CategoryAxisRenderer,
								label: "제품명"
							},
							yaxis: {
	 							tickOptions: {
									formatString: '%d'
								},
								label: "판매량"
							}
						},
						highlighter: {
							show: false
						}
						
					});
				}
			}
		});
	});
	
	$(".down").on("click", function(){
		var btn = this;
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeWeekController.do",
			"type":"GET",
			"data":{"productId":$(btn).prev().val()},
			"success":function(list){
				$("#graph").nextAll("#chart").remove();
				$("#graph").after("<div id='chart'></div>");
				$("#graph1").nextAll("#chart1").remove();
				$("#graph1").after("<div id='chart1'></div>");
				
				var count = list.countList;
				var date = list.dateList;
				
				var graph = [];
				for(var i=0; i<date.length; i++) {
					graph.push([date[i], count[i]]);
				}
			
				var plot = $.jqplot('chart1', [graph],{
					animate: true,
					animateReplot: true,
					title: "상승세/하락세 그래프",
					series: [
						{
							label: "하락세",					
							color: 'red',
							pointLabels: {
								show: true
							},
							rendererOptions: {
								animation: {
									speed:2500
								},
								barWidth: 40,
								barPadding: -15,
								barMagin: 0,
								varyBarColor: true
							}
						}
					],
					axes: {
						xaxis: {
							renderer:$.jqplot.CategoryAxisRenderer,
							label: "판매날짜"
						},
						yaxis: {
							min: 0,
 							tickOptions: {
								formatString: '%d'
							},
							label: "판매량"
						}
					},
					highlighter: {
						show: false
					},
					legend : { 
					    renderer : $.jqplot.EnhancedLegendRenderer,
					    show : true, 
					    placement : 'outside',
					    textColor : 'black',
					    rowSpacing : '0px', 
					    location : 'ne' 
					}
				});
			}
		});
	});
	$(".up").on("click", function(){
		var btn = this;
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeWeekController.do",
			"type":"GET",
			"data":{"productId":$(btn).prev().val()},
			"success":function(list){
				$("#graph").nextAll("#chart").remove();
				$("#graph").after("<div id='chart'></div>");
				$("#graph1").nextAll("#chart1").remove();
				$("#graph1").after("<div id='chart1'></div>");
				
				var count = list.countList;
				var date = list.dateList;
				
				var graph = [];
				for(var i=0; i<date.length; i++) {
					graph.push([date[i], count[i]]);
				}
			
				var plot = $.jqplot('chart1', [graph],{
					animate: true,
					animateReplot: true,
					title: "상승세/하락세 그래프",
					series: [
						{
							label: "상승세",
							color : 'blue',
							pointLabels: {
								show: true
							},
							rendererOptions: {
								animation: {
									speed:2500
								},
								barWidth: 40,
								barPadding: -15,
								barMagin: 0,
								varyBarColor: true
							}
						}
					],
					axes: {
						xaxis: {
							renderer:$.jqplot.CategoryAxisRenderer,
							label: "판매날짜"
						},
						yaxis: {
							min: 0,
							max: 50,
 							tickOptions: {
								formatString: '%d'
							},
							label: "판매량"
						}
					},
					highlighter: {
						show: false
					},
					legend : { 
					    renderer : $.jqplot.EnhancedLegendRenderer,
					    show : true, 
					    placement : 'outside',
					    textColor : 'black',
					    rowSpacing : '0px', 
					    location : 'ne' 
					}
				});
			}
		});
	});
	$(".keep").on("click", function(){
		var btn = this;
		$.ajax({
			"url":"/coffeeNbread_user/findSalesVolumeWeekController.do",
			"type":"GET",
			"data":{"productId":$(btn).prev().val()},
			"success":function(list){
				$("#graph").nextAll("#chart").remove();
				$("#graph").after("<div id='chart'></div>");
				$("#graph1").nextAll("#chart1").remove();
				$("#graph1").after("<div id='chart1'></div>");
				
				var count = list.countList;
				var date = list.dateList;
				
				var graph = [];
				for(var i=0; i<date.length; i++) {
					graph.push([date[i], count[i]]);
				}
			
				var plot = $.jqplot('chart1', [graph],{
					animate: true,
					animateReplot: true,
					title: "상승세/하락세 그래프",
					series: [
						{
							label: "유지중",
							color : 'green',
							pointLabels: {
								show: true
							},
							rendererOptions: {
								animation: {
									speed:2500
								},
								barWidth: 40,
								barPadding: -15,
								barMagin: 0,
								varyBarColor: true
							}
						}
					],
					axes: {
						xaxis: {
							renderer:$.jqplot.CategoryAxisRenderer,
							label: "판매날짜"
						},
						yaxis: {
							min: 0,
							max: 50,
 							tickOptions: {
								formatString: '%d'
							},
							label: "판매량"
						}
					},
					highlighter: {
						show: false
					},
					legend : { 
					    renderer : $.jqplot.EnhancedLegendRenderer,
					    show : true, 
					    placement : 'outside',
					    textColor : 'black',
					    rowSpacing : '0px', 
					    location : 'ne' 
					}
				});
			}
		});
	});
	
	$(".up").on("mouseover", function() {
		 $(this).css("background-color", "LightSalmon");
	});
	$(".up").on("mouseout", function() {
		 $(this).css("background-color", "white");
	});
	
	$(".down").on("mouseover", function() {
		 $(this).css("background-color", "LightSalmon");
	});
	$(".down").on("mouseout", function() {
		 $(this).css("background-color", "white");
	}); 
	
	$(".keep").on("mouseover", function() {
		 $(this).css("background-color", "LightSalmon");
	});
	$(".keep").on("mouseout", function() {
		 $(this).css("background-color", "white");
	}); 
});

</script>

<h4 style="font-weight:bold"><span class="glyphicon glyphicon-stats"></span>&nbsp;&nbsp;판매량</h4>

<input type="checkbox" name="choice" id="total" value="total">오늘 전체&nbsp;&nbsp;<br id=br0>
<input type="checkbox" name="choice" id="date" value="date">날짜별&nbsp;&nbsp;<br id=br1>
<input type="checkbox" name="choice" id="category" value="category">종류별&nbsp;&nbsp;<br id=br2>
<input type="checkbox" name="choice" id="name" value="name">제품명&nbsp;&nbsp;<br id=br3>
<p><p>

<table id="table">
	<tbody id="tbody">
		<tr id="tr1">
			<td id="productNameList" width="70" align="center" style="font-weight:bold; background-color:LemonChiffon"><input type="hidden" value="${requestScope.productNameList }"/>제품명</td>
			<c:forEach items="${requestScope.productNameList }" var="string">
				<td align="center">${string }</td>
			</c:forEach>
		</tr>
		<tr id="tr2">
			<td id="countList" width="70" align="center" style="font-weight:bold; background-color:LemonChiffon"><input type="hidden" value="${requestScope.countList }"/>판매량</td>
			<c:forEach items="${requestScope.countList }" var="string">
				<td align="center">${string }</td>
			</c:forEach>
		</tr>
	</tbody>
</table>

<br id="graph">
<div id="chart"></div>  


<br><br>

<h4 style="font-weight:bold"><span class="glyphicon glyphicon-sort"></span>&nbsp;&nbsp;상승세 / 하락세</h4>

<table>
	<tbody>
		<tr>
			<td width="80" align="center" style="font-weight:bold; background-color:LemonChiffon">상승세<i class="glyphicon glyphicon-arrow-up"></i></td>
			<c:forEach items="${requestScope.upProductList }" var="product">
				<input type="hidden" value="${product.productId}"/>
				<td class="up" align="center" style="cursor:pointer">
				${product.productName }
				</td>
			</c:forEach>
		</tr>
	</tbody>
</table>

<br>

<table>
	<tbody>
		<tr>
			<td width="80" align="center" style="font-weight:bold; background-color:LemonChiffon">하락세<i class="glyphicon glyphicon-arrow-down"></i></td>
			<c:forEach items="${requestScope.downProductList }" var="product">
				<input type="hidden" value="${product.productId}"/>
				<td class="down" align="center" style="cursor:pointer">
				${product.productName }
				</td>
			</c:forEach>
		</tr>
	</tbody>
</table>

<br>

<table>
	<tbody>
		<tr>
			<td width="80" align="center" style="font-weight:bold; background-color:LemonChiffon">유지중<i class="glyphicon glyphicon-resize-horizontal"></i></td>
			<c:forEach items="${requestScope.keepProductList }" var="product">
				<input type="hidden" value="${product.productId}"/>
				<td class="keep" align="center" style="cursor:pointer">
				${product.productName }
				</td>
			</c:forEach>
		</tr>
	</tbody>
</table>

<br id="graph1">
<div id="chart1"></div>  

<br><br>

<h4 style="font-weight:bold"><span class="glyphicon glyphicon-th"></span>&nbsp;&nbsp;예상 생산량</h4>

<table>
	<tbody>
		<tr>
			<td width="100" align="center" style="font-weight:bold; background-color:LemonChiffon">제품명</td>
			<c:forEach items="${requestScope.allProductNameList }" var="string1">
				<td align="center">${string1}</td>
			</c:forEach>
		</tr>
		<tr>
			<td width="100" align="center" style="font-weight:bold; background-color:LemonChiffon">예상 생산량</td>
			<c:forEach items="${requestScope.todayCountList }" var="string2">
				<td align="center">${string2}</td>
			</c:forEach>
		</tr>
	</tbody>
</table>

<br><br><br>