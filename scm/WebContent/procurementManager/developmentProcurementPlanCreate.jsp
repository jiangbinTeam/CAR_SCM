<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
		当前位置：采购管理>>制定全年采购计划>>创建全年采购计划
		</td>

	</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		<td width="100%" align="center"><input type="button" style="width:100px" class="Submit"  value="返回" onclick="window.location='yearProcurementPlanPage'"></td>
	</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<thead class="thead">
    	<tr>
		<th width="6%">序号</th>
		<th width="10%">年份</th>
		<th width="16%">品牌</th>
		<th width="16%">车型编码</th>	
		<th width="19%">车型特征</th>	
		<th width="15%">当前库存</th>	 
		<th width="18%">计划数量</th>
		<th>操作</th>	
		</tr>
		</thead>
		<tbody class="tbody" align="center" >
			<c:forEach items="${ypp}" var="add" varStatus="i">
				<form action="yearProcurementPlanCreate" method="post">
				<%-- <c:if test="${empty add.yearProcurementPlanCount}"> --%>
					 <tr>
						<td>${i.index+1}</td>
						<td><%-- <input name="yearProcurementPlanYear" required="required"  type="text"  value="${yppy}" style="border:none;background-color:#f7f8f9;" readonly= "true "> --%>
							${yppy}
						<input type="hidden" name="yearProcurementPlanYear" value="${yppy}">
						</td>
						<td>${add.brand}</td>
						<td>${add.typeCode}
						<input type="hidden" name="typeCode" value="${add.typeCode}">
						</td>
						<td>${add.carCharacter}</td>
						<td><a style="color:#CC0000">${add.carProcurementListCount}</a></td>
						<td>
							<input name="yearProcurementPlanCount" style="width:50px;" required="required"  type="text"  onkeyup="this.value=this.value.replace(/[^\d]/g,'');">
						</td> <!-- 不能为空 只能输入数字 -->
						<!-- <input type="hidden" name="ifDecomposition" value="0"> -->
						<td width="100%" align="center"><button type="submit" class="Submit"  style="width:100px">保存采购计划</button></td>
					 </tr>
					<%-- </c:if> --%>
					</form>
				</c:forEach>
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
</body>
</html>
