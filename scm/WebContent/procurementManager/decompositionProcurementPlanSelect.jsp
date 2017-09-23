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
		<tr>
		
		<td width="10%" align="center" height="30"><span class="left_bt2">请选择年份</span></td>
		<td width="9%"><select name="projectname" class="sec2" style="width:100px">
		<option value="0" selected="selected">请选择</option>
	  	<option value="2009">2009</option>
		<option value="2010">2010</option>
		<option value="2011">2011</option>
		<option value="2012">2012</option>
		<option value="2013">2013</option>
		<option value="2014">2014</option>
		<option value="2015">2015</option>
		<option value="2016">2016</option>
		<option value="2017">2017</option>
		<option value="2018">2018</option>
		<option value="2019">2019</option>
		<option value="2020">2020</option>
	  </select></td>
		<td width="7%" align="left"><span class="left_bt2">请选择车型</span></td>
		<td width="22%"><select name="select" class="sec2" style="width:250px">
		  <option value="0" selected="selected">请选择</option>
          <option value="2009">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2010">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2011">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2012">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2013">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2014">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2015">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2016">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2017">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2018">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2019">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2020">大切诺基BJ2021V8(4.7 自动 四驱)</option>
        </select></td>
		  
		  <td width="52%"><input type="button" class="Submit" value="查看" style="width:100px"/></td>
	</tr>
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
		<tbody class="tbody">
		<c:forEach items="${list}" var="car" varStatus="i">
		 <tr>
			<td>${i.index+1}</td>
			<td>${car.brand}</td>
			<td>${car.typeCode}</td>
			<td>${car.yearProcurementPlanYear}</td>
			<td>${car.procurementPlanAnalyzeMonth}</td>
			<td>${car.procurementPlanAnalyzeCount}</td>
			<td><a style="color:#CC0000">${car.carProcurementListCount}</a></td>	
			<td><a href="procurementPlanupdates?yearProcurementPlanYear=${car.yearProcurementPlanYear}&yearProcurementPlanId=${car.yearProcurementPlanId}" style="color:#000099">修改</a></td>
		 </tr>
		 </c:forEach>
		</tbody>						
    </table>
    <c:if test="${!empty currPage}">
    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		  <td width="869">&nbsp;</td>
		   <td width="63" align="right"><a href="procurementPlanPage?currPage=1"><span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="procurementPlanPage?currPage=${currPage-1}"><span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left"><a href="procurementPlanPage?currPage=${currPage+1}"><span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="procurementPlanPage?currPage=${totalPage}"><span class="left_ts">尾页</span></a></td>
		</tr>
	</table>
	</c:if>
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
