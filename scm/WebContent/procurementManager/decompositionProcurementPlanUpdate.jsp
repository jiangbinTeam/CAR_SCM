<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>采购管理</title>
    
	<link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" language="JavaScript">
$(function(){  //文档加载 
$(".tbody tr").hover( 
  function(){ 
    $(this).addClass("hover");    //鼠标经过添加hover样式 
  }, 
  function(){ 
    $(this).removeClass("hover");   //鼠标离开移除hover样式 
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
		当前位置：采购管理>>全年采购计划分解>>全年分解采购计划
		</td>

	</tr>
	</table>
	<form action="procurementPlanupdate" method="post">
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		<td width="9%"><span class="left_bt2">全年计划总量</span></td>
		<td width="32%"><span class="left_txt">${yp[0].yearProcurementPlanCount}</span></td>
		<td width="59%">
		<input type="submit" class="Submit" value="保存" style="width:100px"/>
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
				<c:forEach  items="${yp}" var="yp" varStatus="i">
				<input type="hidden" name="ppa[${i.index}].procurementPlanAnalyzeId" value="${yp.procurementPlanAnalyzeId}"/>
					 <tr>
						<td>${i.index+1}</td>
						<td>${yp.brand}</td>
						<td>${yp.typeCode}</td>
						<td>${yp.yearProcurementPlanYear}</td>
						<td>${yp.procurementPlanAnalyzeMonth}</td>
						<td><input name="ppa[${i.index}].procurementPlanAnalyzeCount" value="${yp.procurementPlanAnalyzeCount}" required="required"  type="text"  onkeyup="this.value=this.value.replace(/[^\d]/g,'');"/></td> <!-- 不能为空 只能输入数字 -->
					 </tr>
				</c:forEach>
		</tbody>			
    </table>
    </form>	
	</td>
    <td background="${pageContext.request.contextPath}/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif"><img src="${pageContext.request.contextPath}/resources/images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif"><img src="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif"><img src="${pageContext.request.contextPath}/resources/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
</body>
</html>
