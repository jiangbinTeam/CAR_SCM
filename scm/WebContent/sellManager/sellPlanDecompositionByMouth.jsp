<%@page import="com.scm.pojo.YearPlanMonthAnalyze"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
<title>My JSP 'sellPlanDecompositionByMouth.jsp' starting page</title>
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
		当前位置：销售管理>>制定全年销售计划>>全年销售计划按月份分解
		</td>

	</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		
		<td width="9%"><span class="left_bt2">全年计划销售总量</span></td>
		<td width="22%">
			<span class="left_txt" id="carSum">${selectSell.sellcount }</span>&nbsp;&nbsp;&nbsp;&nbsp;
			<span>待分配数量：</span>
			<input type="text" readonly="readonly" style="width: 30px;text-align: center; border: none; color: red"
			 value="${selectSell.sellcount }" id="total">
		</td>
		<td>
		</td>
	</tr>
	</table>
	<table width="98%" border="0" align="center" style="text-align: center;"  cellpadding="0" cellspacing="0" class="line_table">
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
		<form action="${pageContext.request.contextPath}/yearSellPlan_addMonth" method="post" onsubmit="return check()"> 
		<c:forEach begin="0" end="11" varStatus="i">
		 <tr>
		<td >${i.index+1 }</td>
		<td >${selectSell.brand }</td>
		<td >${selectSell.typeCode }</td>
		<td >${selectSell.year }</td>
		<td >${i.index+1 }</td>	
		<input type="hidden"  name="ypmas[${i.index }].yearSellPlanId" value="${selectSell.yearSellPlanId  }"/>
		<input type="hidden"  name="ypmas[${i.index }].yearPlanMouth" value="${i.index+1 }"/>
		<td >
			<input type="text" class="planNumber" name="ypmas[${i.index }].yearPlanCount" required="required" 
			 style="width: 40px;text-align: center;" value="0" onkeyup="this.value=this.value.replace(/[^\d]/g,'');"/>
	    </td>	
		</tr>	
		</c:forEach> 
		<p  align="center"><input type="submit" class="Submit" value="保存" style="width:100px">
		<input type="button" class="Submit" value="返回"  style="width:100px" onclick="javascript:history.back()"/>
		</p>
		</form>
		</tbody>						
    </table>
     <script type="text/javascript">
	     $(function(){
	    	
			 var total=document.getElementById("carSum").innerHTML;
			 total=parseInt(total);
		
			$(".planNumber").change(function(){
				
				var sum=0;
				var n=document.getElementsByClassName("planNumber");
				$.each(n,function(key,value){

					sum+=parseInt(value.value);
				
				});
			document.getElementById("total").value=(total-sum);
			});
		  
		});
		
		function check(){
			var total=document.getElementById("total").value;
			 if(total!='0'){
				 alert("分配总数与计划数量不符！");
				 return false;
			 }else{
				 return true;
			 }
		}
    </script>
	</td>
    <td background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">
    <img src="${pageContext.request.contextPath}/resources/images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif">
    <img src="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">
    <img src="${pageContext.request.contextPath}/resources/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>

</body>
</html>
