<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>采购管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
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
}); 

</script> 
<script type="text/javascript">
$().ready(function(){
	$("#selectYear").click(function(){ //click() 点击事件
		var slv = $("#selectYear").val(); // .val 返回第一个匹配元素的 value 属性的值
		$("#selectYear").empty();
		$.ajax({
			url:"selectYear", //请求的地址
			type:"get", //请求方式为get
			success:function(data){ //success指的是请求并成功返回信息 data返回的内容
				var type =eval("(" + data + ")"); //转换为json对象 
				/* $("#selectYear").empty();  */// empty() 删除匹配的元素集合中所有的子节点。
				$.each(type,function(key,value){	// each() 循环 //遍历处理data(type)
				var op="<option value="+value.yearProcurementPlanYear+">"+value.yearProcurementPlanYear+"</option>";
				 $("#selectYear").append(op); // .append 向每个匹配的元素内部追加内容。
				 $("#selectYear").val(slv); //.val(slv) 设置 Value 属性的值
				});
			}
		});
	});
	$("#selectYear").change(
				function() {
					var params = $("#selectYear").val();
					$.ajax( {
						type : "post",
						url : "selectType",
						data : "yearProcurementPlanYear=" + params,
						cache : false,
						dataType : "json",
						success : function(json) {
							var str = "<option>请选择</option>";
							$("#city").html("");
							for ( var i = 0; i < json.length; i++) {
								str += "<option value='" + json[i].typeCode+ "'>" + json[i].brand+ json[i].typeCode+"</option>";
							}
							$("#city").append(str);
						},
						error : function() {
							alert("请与管理员联系");
						}
				});
			});
})
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

  </head>
  
  <body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif"><img src="${pageContext.request.contextPath}/resources/images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="${pageContext.request.contextPath}/resources/images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">采购管理</div></td>
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
		当前位置：采购管理>>全年采购计划分解
		</td>

	</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<form action="procurementPlanSelect" method="post">
		<tr>
			<td width="8%" align="center" height="30"><span class="left_bt2">请选择年份：</span></td>
			<td width="8%" align="left">
				<select  name="yearProcurementPlanYear"  class="sec2" style="width:100px">
					<c:if test="${!empty yearProcurementPlanYear}">
						
					    <c:forEach items="${years}" var="y">
							 <c:if test="${y.yearProcurementPlanYear==yearProcurementPlanYear}">  
								<option value="${yearProcurementPlanYear}">${yearProcurementPlanYear}年</option>
							 </c:if> 
						</c:forEach>
						
						 <c:forEach items="${years}" var="y">
							<c:if test="${y.yearProcurementPlanYear!=yearProcurementPlanYear}">
								<option value="${y.yearProcurementPlanYear}">${y.yearProcurementPlanYear}年</option>
							</c:if>
						</c:forEach> 
						<option value="0" >请选择</option>
					</c:if>
					<c:if test="${empty yearProcurementPlanYear}">
						<option value="0" >请选择</option>
						<c:forEach items="${years}" var="y">
								<option value="${y.yearProcurementPlanYear}">${y.yearProcurementPlanYear}年</option>
						</c:forEach>
					</c:if> 
				</select>
	    	</td>
			<td width="8%" align="center"><span class="left_bt2">请选择车型：</span></td>
			<td width="22%" align="left">
        		 <select  name="typeCode"  class="sec2" style="width:200px">
        		 	<c:if test="${!empty typeCode}">
						<c:forEach items="${typeDictionarys}" var="t">
							<c:if test="${t.typeCode==typeCode}">
								<option value="${t.typeCode}">${t.brand}</option>
							</c:if>
						</c:forEach>
						
						<c:forEach items="${typeDictionarys}" var="t">
							<c:if test="${t.typeCode!=typeCode}">
								<option value="${t.typeCode}">${t.brand}</option>
							</c:if>
						</c:forEach> 
						<option value="0" >请选择</option>
					</c:if>
					<c:if test="${empty typeCode}">
						<option value="0" >请选择</option>
						 <c:forEach items="${typeDictionarys}" var="t">
								<option value="${t.typeCode}">${t.brand}</option>
						</c:forEach> 
					</c:if>
        	 	</select>
        	 </td> 
		  	<td width="52%"><input type="submit" class="Submit" value="查看" style="width:100px"/></td>
		</tr>
		</form>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<thead class="thead">
    	<tr>
		<th>序号</th>
		<th>品牌</th>
		<th>车辆编码</th>
		<th>年份</th>	
		<th>月份</th>	
		<th>计划数量</th>	
		<th>已采购</th>	
		<th>操作</th>
		</tr>
		</thead>
		<tbody class="tbody" align="center" >
		<c:if test="${empty yp}">
			<tr><td colspan="8">该车型的年采购计划未分解</td></tr>
		</c:if>
		<c:if test="${!empty yp}">
		<c:forEach items="${yp}" var="car" varStatus="i">
		 <tr>
			<td>${i.index+1}</td>
			<td>${car.brand}</td>
			<td>${car.typeCode}</td>
			<td>${car.yearProcurementPlanYear}</td>
			<td>${car.procurementPlanAnalyzeMonth}</td>
			<td>${car.procurementPlanAnalyzeCount}</td>
			<td><a style="color:#CC0000">${car.carProcurementListCount}</a></td>	
			<td><a href="procurementPlanupdates?yearProcurementPlanYear=${car.yearProcurementPlanYear}&yearProcurementPlanId=${car.yearProcurementPlanId}"
				 style="color:#000099">修改</a></td>
		 </tr>
		 </c:forEach>
		 </c:if>
		</tbody>						
    </table>
   
    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		  <td width="869">&nbsp;</td>
		   <td width="63" align="right">
		   	<a href="findProcurementPlanBypage?currPage=1&yearProcurementPlanYear=${yearProcurementPlanYear}&typeCode=${typeCode}">
		   	<span class="left_ts">首页</span></a></td>
		  <td width="63" align="right">
		  <a href="findProcurementPlanBypage?currPage=${currPage-1}&yearProcurementPlanYear=${yearProcurementPlanYear}&typeCode=${typeCode}">
		  <span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left">
		  <a href="findProcurementPlanBypage?currPage=${currPage+1}&yearProcurementPlanYear=${yearProcurementPlanYear}&typeCode=${typeCode}">
		  <span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left">
		  <a href="findProcurementPlanBypage?currPage=${totalPage}&yearProcurementPlanYear=${yearProcurementPlanYear}&typeCode=${typeCode}">
		  <span class="left_ts">尾页</span></a></td>
		</tr>
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
