<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'sellPlanSelectByMouth.jsp' starting page</title>

  </head>
  
  <link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-ui.min.js"></script>

<script type="text/javascript" language="JavaScript">
$(function(){  //文档加载 
$(".tbody tr").hover( 
  function(){ 
    $(this).addClass("hover");    //鼠标经过添加hover样式 
  }, 
  function(){ 
    $(this).removeClass("hover");   //鼠标离开移除hover样式 
  }

); 
$("#selectYear").click(function(){ //click() 点击事件
	var slv = $("#selectYear").val(); // .val 返回第一个匹配元素的 value 属性的值
		$("#selectYear").empty();
		$.ajax({
			url:"selectYea", //请求的地址
			type:"get", //请求方式为get
			success:function(data){ //success指的是请求并成功返回信息 data返回的内容
				var type =eval("(" + data + ")"); //转换为json对象 
				/* $("#selectYear").empty();  */// empty() 删除匹配的元素集合中所有的子节点。
				$.each(type,function(key,value){	// each() 循环 //遍历处理data(type)
				var op="<option value="+value.year+">"+value.year+"</option>";
				 $("#selectYear").append(op); // .append 向每个匹配的元素内部追加内容。
				 $("#selectYear").val(slv); //.val(slv) 设置 Value 属性的值
				});
			}
		});
	});
	$("#selectType").click(function(){ //click() 点击事件
	var slv = $("#selectType").val(); // .val 返回第一个匹配元素的 value 属性的值
		$("#selectType").empty();
		$.ajax({
			url:"selectYea2", //请求的地址
			type:"get", //请求方式为get
			success:function(data){ //success指的是请求并成功返回信息 data返回的内容
				var type =eval("(" + data + ")"); //转换为json对象 
				/* $("#selectType").empty();  */// empty() 删除匹配的元素集合中所有的子节点。
				$.each(type,function(key,value){	// each() 循环 //遍历处理data(type)
				var op="<option value="+value.typeCode+">"+value.brand+"("+value.typeCode+")"+"</option>";
				 $("#selectType").append(op); // .append 向每个匹配的元素内部追加内容。
				 $("#selectType").val(slv); //.val(slv) 设置 Value 属性的值
				});
			}
		});
	});
}); 

</script> 
<style type="text/css"> 
.hover{background-color:#CACACA;}  /*这里是鼠标经过时的颜色*/ 

</style>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
</style>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif"><img src="${pageContext.request.contextPath}/resources/images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="${pageContext.request.contextPath}/resources/images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">销售管理</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif"><img src="${pageContext.request.contextPath}/resources/images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td valign="middle" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		<td width="20">
		<img src="${pageContext.request.contextPath}/resources/images/icon-login-seaver.gif" width="16" height="16" />
		</td>
		<td>
		当前位置：销售管理>>全年销售计划查询
		</td>

	</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<form action="yearSellPlan_findAllMonth" method="post">
		<tr>
		<td width="4%"><span class="left_bt2">年份</span></td>
		<td width="10%">
	  	<select id="selectYear" name="year" class="sec2" style="width:100px">
			 <option value="0" >请选择</option>		          		         	 	        
	  	</select>
	  </td>
	  <td width="4%"><span class="left_bt2">车型</span></td>
	  <td width="10%">
	  	<select id="selectType" name="typeCode" class="sec2" style="width:100px">
			 <option value="0" >请选择</option>		          		         	 	        
	  	</select>
	  </td>
		<td width="11%"><input type="submit" class="Submit" value="搜索计划"/></td>
		<td width="75%"></td>
	</tr>
	</form>
	</table>
	<table width="98%" border="0" align="center" style="text-align: center;" cellpadding="0" cellspacing="0" class="line_table">
		<thead class="thead">
    	<tr>
		<th >序号</th>
		<th width="16%">品牌</th>
		<th width="16%">车辆编码</th>
		<th width="16%">年份</th>	
		<th width="16%">月份</th>	
		<th width="16%">计划数量</th>	
		<th width="16%">操作</th>
		</tr>
		</thead>
		<c:if  test="${empty list}">
		
			<tr height="100px" >
				<td align="center" colspan="6"><h1>尚未建立该类型计划</h1></td>
			</tr>
		</c:if>
		<tbody class="tbody">
		
		
		
		<c:if  test="${!empty list}">
			<c:forEach  items="${list }" var="l" varStatus="i">
		<form action="${pageContext.request.contextPath}/yearSellPlan_findMonthID">
		 <tr>
		<td >${i.index+1 }</td>
		<td >${l.brand }</td>
		<td >${l.typeCode }</td>
		<td >${l.year }</td>
		<td >${l.yearPlanMouth }</td>	
		<td >${l.yearPlanCount }</td>	
		<input type="hidden" name="yearPlanMonthAnalyzeId" value="${l.yearPlanMonthAnalyzeId }">	
		<td><input type="submit" value="修改" style="color:#000099">
		<c:if test="${l.ifDec==0 }">
		<input type="button" value="按经销商分解" onclick="window.location='${pageContext.request.contextPath}/yearSellPlan_Dealer?yearSellPlanId=${l.yearSellPlanId}&yearPlanMouth=${l.yearPlanMouth }'">	
		</c:if>
		<c:if test="${l.ifDec==1 }">
		<input type="button" value="已分解" <%-- onclick="window.location='${pageContext.request.contextPath}/yearSellPlan_Dealer?yearSellPlanId=${l.yearSellPlanId}&yearPlanMouth=${l.yearPlanMouth }'" --%>>	
		</c:if>
			</td>
			</form>
		</c:forEach> 	
		
		</c:if>
		
		</tr>
		</tbody>
				
    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
    <c:if test="${!empty currPage}">
		<tr>
			<td width="869">&nbsp;</td>
		   <td width="63" align="right"><a href="yearSellPlan_findAllMonth?currPage=1&year=${year}&typeCode=${typeCode}"><span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="yearSellPlan_findAllMonth?currPage=${currPage-1}&year=${year}&typeCode=${typeCode}"><span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left"><a href="yearSellPlan_findAllMonth?currPage=${currPage+1}&year=${year}&typeCode=${typeCode}"><span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="yearSellPlan_findAllMonth?currPage=${totalPage}&year=${year}&typeCode=${typeCode}"><span class="left_ts">尾页</span></a></td>
		</tr>
		</c:if>	
	</table>
	
	</td>
    <td background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif"><img src="${pageContext.request.contextPath}/resources/images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif"><img src="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif"><img src="${pageContext.request.contextPath}/resources/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
  
</table>
</body>
</html>
