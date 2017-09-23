<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>采购管理</title>
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
    <td valign="top" background="${pageContext.request.contextPath}/resources/images/content-bg.gif">
    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">采购管理</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="/mail_rightbg.gif">
    	<img src="${pageContext.request.contextPath}/resources/images/nav-right-bg.gif" width="16" height="29" />
    </td>
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
		当前位置：采购管理>>制定全年采购计划
		</td>

	</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		<td width="100%" align="center">
		<input type="submit" class="Submit" value="创建本年计划" onclick="window.location='yearProcurementPlanafind'"/>
		<input type="button" class="Submit" value="查看历史记录" onclick="window.location='yearProcurementPlanSelect'"/>
		 </td>

	</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<thead class="thead">
    	<tr>
		<th width="7%">序号</th>
		<th width="7%">年份</th>
		<th width="13%">品牌</th>
		<th width="15%">车型编码</th>	
		<th width="19%">车型特征</th>	
		<th width="13%">计划数量</th>	
		<th width="13%">已采购</th>
		<th width="13%">操作</th>
		</tr>
		</thead>
		<tbody class="tbody">
				<c:forEach items="${list}" var="list" varStatus="i">
					 <tr>
						<td>${i.index+1}</td>
						<td>${list.yearProcurementPlanYear}</td>
						<td>${list.brand}</td>
						<td>${list.typeCode}</td>
						<td>${list.carCharacter}</td>
						<td>${list.yearProcurementPlanCount}</td>
						<td><a style="color:#CC0000">${list.carProcurementListCount}</a></td>
						<td>
							<a href="yearProcurementPlanafindId?yearProcurementPlanId=${list.yearProcurementPlanId}" style="color:#000099">修改</a>
							<c:if test="${(list.ifDecomposition)==1}">
							<a href="procurementPlanSelect?yearProcurementPlanYear=${list.yearProcurementPlanYear}&yearProcurementPlanId=${list.yearProcurementPlanId}" style="color:#000099">查看</a>
							</c:if>
							<c:if test="${(list.ifDecomposition)==0}">
							<a href="procurementPlanYear?yearProcurementPlanId=${list.yearProcurementPlanId}" style="color:#000099">分解计划</a>
							</c:if>
						</td>
					 </tr>
				</c:forEach>
			</tbody>	
    </table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		  <td width="869">&nbsp;</td>
		   <td width="63" align="right"><a href="yearProcurementPlanPage?currPage=1"><span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="yearProcurementPlanPage?currPage=${currPage-1}"><span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left"><a href="yearProcurementPlanPage?currPage=${currPage+1}"><span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="yearProcurementPlanPage?currPage=${totalPage}"><span class="left_ts">尾页</span></a></td>
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
