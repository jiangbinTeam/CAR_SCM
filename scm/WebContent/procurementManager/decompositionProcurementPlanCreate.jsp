<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>采购管理</title>
    
	<link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
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
		当前位置：采购管理>>全年采购计划分解>>全年分解采购计划(decompositionProcurementPlanCreate.html)
		</td>

	</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		
		<td width="9%"><span class="left_bt2">全年计划总量</span></td>
		<td width="32%"><span class="left_txt">100</span></td>
		<td width="59%">
		<input type="button" class="Submit" value="保存" style="width:100px"/>
		<input type="button" class="Submit" value="返回" style="width:100px" onclick="javascript:history.back()"/>
		</td>
	</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<thead class="thead">
	    <tr>
		<th width="10%">序号</th>
		<th width="19%">品牌</th>
		<th width="22%">车辆编码</th>
		<th width="15%">年份</th>	
		<th width="12%">月份</th>	
		<th width="22%">计划数量</th>	
		</tr>
		</thead>
		<tbody class="tbody">
		 <tr>
		<td >1</td>
		<td >大切诺基</td>
		<td >BJ2021V8</td>
		<td >2009</td>
		<td >1</td>	
		<td ><input type="text" class="editbox4" value="提交"/></td>	
		</tr>
		 <tr>
		<td >2</td>
		<td >大切诺基</td>
		<td >BJ2021V8</td>
		<td >2009</td>
		<td >2</td>	
		<td ><input type="text" class="editbox4" value="提交"/></td>	
		</tr>
		 <tr>
		<td >3</td>
		<td >大切诺基</td>
		<td >BJ2021V8</td>
		<td >2009</td>
		<td >3</td>	
		<td ><input type="text" class="editbox4" value="提交"/></td>	
		</tr>
		 <tr>
		<td >4</td>
		<td >大切诺基</td>
		<td >BJ2021V8</td>
		<td >2009</td>
		<td >4</td>	
		<td ><input type="text" class="editbox4" value="提交"/></td>	
		</tr>
		 <tr>
		<td >5</td>
		<td >大切诺基</td>
		<td >BJ2021V8</td>
		<td >2009</td>
		<td >5</td>	
		<td ><input type="text" class="editbox4" value="提交"/></td>	
		</tr>
		 <tr>
		<td >6</td>
		<td >大切诺基</td>
		<td >BJ2021V8</td>
		<td >2009</td>
		<td >6</td>	
		<td ><input type="text" class="editbox4" value="提交"/></td>	
		</tr>
		<tr>
		<td >7</td>
		<td >大切诺基</td>
		<td >BJ2021V8</td>
		<td >2009</td>
		<td >7</td>	
		<td ><input type="text" class="editbox4" value="提交"/></td>	
		</tr>
		 <tr>
		<td >8</td>
		<td >大切诺基</td>
		<td >BJ2021V8</td>
		<td >2009</td>
		<td >8</td>	
		<td ><input type="text" class="editbox4" value="提交"/></td>	
		</tr>	
		 <tr>
		<td >9</td>
		<td >大切诺基</td>
		<td >BJ2021V8</td>
		<td >2009</td>
		<td >9</td>	
		<td ><input type="text" class="editbox4" value="提交"/></td>	
		</tr>
		 <tr>
		<td >10</td>
		<td >大切诺基</td>
		<td >BJ2021V8</td>
		<td >2009</td>
		<td >10</td>	
		<td ><input type="text" class="editbox4" value="提交"/></td>	
		</tr>	
		 <tr>
		<td >11</td>
		<td >大切诺基</td>
		<td >BJ2021V8</td>
		<td >2009</td>
		<td >11</td>	
		<td ><input type="text" class="editbox4" value="提交"/></td>	
		</tr>	
		 <tr>
		<td >12</td>
		<td >大切诺基</td>
		<td >BJ2021V8</td>
		<td >2009</td>
		<td >12</td>	
		<td ><input type="text" class="editbox4" value="提交"/></td>	
		</tr>
		</tbody>						
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
页面说明：<br />
1.这里显示的是本年度某车型在12个月内的计划分解。<br />
2.对于输入的数字要做验证，输入的必须是数字。<br />
3.在某月每输入一个数字那么全年计划数量将会减少。<br />

</body>
</html>
