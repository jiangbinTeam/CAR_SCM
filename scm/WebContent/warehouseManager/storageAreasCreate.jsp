<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/js/jquery-ui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/myjs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>


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

$(function(){

	$('input[name=mydate]').makeDate();
	//$('input[name=mydate]').datepicker({duration:"fast",altFormat:"yy-mm-dd",dateFormat:"yy-mm-dd"});
	
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
        <td height="31"><div class="titlebt">仓库管理</div></td>
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
		当前位置：仓库管理>>仓库管理>></td>

	</tr>
	</table>
	<form action="Warehousekumodifa"  method="post">
	<input type="hidden" name="storageAreasId" value="${warsk.storageAreasId}"> 
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
	<tbody class="tbody2">
			<tr>
		<td width="8%" align="left"><span>仓库名</span></td>
		<td width="26%" align="left"><select name="warehouseId" id="warehouseId"  class="sec2" style="width:200px">
	           <c:if test="${!empty warsk}">
	          	<option value="${warsk.warehouseId}" >${warsk.warehouseName}</option>
	           </c:if>    
	           
	           	<c:if test="${!empty wdk}">
	           	<c:forEach var="wc" items="${wdk}" >
	          	<option value="${wc.warehouseId}" >${wc.warehouseName}</option>
	          	</c:forEach>
	           </c:if>    
        </select></td>
				<td width="10%" align="left"><span>库位名称</span></td>
			
		        <td idth="56%" align="left">
                 <c:if test="${!empty warsk}">
		             <input   type="text" required="required" name="storageAreasName" value="${warsk.storageAreasName}" style="width:300px" value="" class="text_2000"/>
		         </c:if>
		          <c:if test="${empty warsk}"> 
		             <input   type="text" required="required" name="storageAreasName"  style="width:300px" value="" class="text_2000"/>
		         </c:if>
		        </td>
        
		</tr>
	<tr>
		<td width="8%" height="27" align="left">&nbsp;</td>
		<td width="26%" align="left">&nbsp;</td>
		<td width="10%" align="left">&nbsp;</td>
		        <td width="56%" align="left">
		        <input name="button" type="submit" class="Submit" style="width:100px" value="保存" /></td>
					</tr>
		</tbody>
	</table>
	</form>
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