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
		当前位置：仓库管理>>仓库管理(warehouse.html)
		</td>

	</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		  <td width="40%" align="center"><input type="button" class="Submit" style="width:100px" value="创建仓库" onclick="window.location='WarehousefindByid'"/></td>
	</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<thead class="thead">
    	<tr>
		<th>序号</th>
		<th>仓库名称</th>
		<th>仓库地址</th>
		<th>在库车辆</th>	
		<th>操作</th>
		</tr>
		</thead>
		<tbody class="tbody">
		 <c:forEach var="war" items="${requestScope.wars}" varStatus="i">
		 <tr>
		<td>${i.index+1}</td>
		<td>${war.warehouseName}</td>
		<td>${war.warehouseAddress}</td>
		<td>${war.vinnumbercount}</td> 
		<td>
		<a href="WarehousefindByid?warehouseId=${war.warehouseId}" style="color:#000099" name="createCheckBox">修改</a>		
		</td>
		</tr>
		</c:forEach>
		</tbody>					
    </table>
				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
			<td width="869">&nbsp;</td>
		  <td width="63" align="right"><a href="WarehouseByPage?currPage=1"><span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="WarehouseByPage?currPage=${currPage-1}"><span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left"><a href="WarehouseByPage?currPage=${currPage+1}"><span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="WarehouseByPage?currPage=${totalPage}"><span class="left_ts">尾页</span></a></td>
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

页面要求：<br />
1.这是列表界面每页显示15条数据<br/>
</body>
</html>