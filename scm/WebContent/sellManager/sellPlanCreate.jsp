<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>My JSP 'sellPlanCreate.jsp' starting page</title>

<link
	href="${pageContext.request.contextPath}/resources/images/skin.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css"
	rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" language="JavaScript">


	$(function() { //文档加载 
		$(".tbody tr").hover(
			function() {
				$(this).addClass("hover"); //鼠标经过添加hover样式 
			},
			function() {
				$(this).removeClass("hover"); //鼠标离开移除hover样式 
			}
		);
	});
</script>
<style type="text/css">
.hover {
	background-color: #CACACA;
} /*这里是鼠标经过时的颜色*/
</style>
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
			<td width="17" valign="top"
				background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif"><img
				src="${pageContext.request.contextPath}/resources/images/left-top-right.gif"
				width="17" height="29" /></td>
			<td valign="top"
				background="${pageContext.request.contextPath}/resources/images/content-bg.gif"><table
					width="100%" height="31" border="0" cellpadding="0" cellspacing="0"
					class="left_topbg" id="table2">
					<tr>
						<td height="31"><div class="titlebt">销售管理</div></td>
					</tr>
				</table></td>
			<td width="16" valign="top"
				background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif"><img
				src="${pageContext.request.contextPath}/resources/images/nav-right-bg.gif"
				width="16" height="29" /></td>
		</tr>
		<tr>
			<td valign="middle"
				background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">&nbsp;</td>
			<td valign="top" bgcolor="#F7F8F9">
				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0" class="line_table">
					<tr>
						<td width="20"><img
							src="${pageContext.request.contextPath}/resources/images/icon-login-seaver.gif"
							width="16" height="16" /></td>
						<td>当前位置：销售管理>>制定全年销售计划>>创建全年销售计划</td>

					</tr>
				</table>

				
					<table width="98%" border="0" align="center" cellpadding="0"
						cellspacing="0" class="line_table">
						<tr>
							<td width="100%" align="center"><input type="button"
								value="返回" style="width:100px" onclick="window.location.href='${pageContext.request.contextPath}/yearSellPlan_page'" /></td>
							
						</tr>
					</table>
					<table width="98%" border="0" align="center" cellpadding="0"
						cellspacing="0" class="line_table">
						<thead class="thead">
							<tr>
								<th width="6%">序号</th>
								<th width="10%">年份</th>
								<th width="16%">品牌</th>
								<th width="16%">车型编码</th>
								<th width="19%">车型特征</th>
								<th width="15%">计划采购</th>
								<th width="10%">计划销售数量</th>
							</tr>
							<c:if test="${empty yearSellPlanList}">
								<tr height="100px" >
									<td align="center" colspan="6"><h1>暂无 未创建计划</h1></td>
								</tr>
							</c:if> 
						</thead>
						<tbody class="tbody">
							<c:if test="${!empty yearSellPlanList }">
								<c:forEach items="${yearSellPlanList }" var="list" varStatus="i">
								<form action="${pageContext.request.contextPath}/yearSellPlan_add">
									<tr>
										<td>${i.index+1 }</td>
										<c:if test="${empty list.year}">
											<td>${year}</td>
											<input type="hidden" name="year" value="${year}">
										</c:if>
										<c:if test="${!empty list.year}">
											<td>${list.year}</td>
											<input type="hidden" name="year" value="${list.year}">
										</c:if>
										<td>${list.brand }</td>
										<td>${list.typeCode}</td>
										<input type="hidden" name="typeCode" value="${list.typeCode}">
										<td>${list.carCharacter }</td>
										<td><a style="color:#CC0000">${list.yearProcurementPlanCount }</a></td>
										<td width="20%"><input type="text" class="login_text" name="sellcount" style="width: 100px" /><input type="Submit" value="保存"  /> 
										</td>	
									</tr>
									</form>
								</c:forEach>
							</c:if>
					</table>
				
			</td>
			<td
				background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">&nbsp;</td>
		</tr>
		<tr>
			<td valign="bottom"
				background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif"><img
				src="${pageContext.request.contextPath}/resources/images/buttom_left2.gif"
				width="17" height="17" /></td>
			<td
				background="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif"><img
				src="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif"
				width="17" height="17"></td>
			<td valign="bottom"
				background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif"><img
				src="${pageContext.request.contextPath}/resources/images/buttom_right2.gif"
				width="16" height="17" /></td>
		</tr>
	</table>
</body>
</html>
