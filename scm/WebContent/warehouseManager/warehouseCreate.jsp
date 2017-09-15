<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../images/skin.css" rel="stylesheet" type="text/css" />
<link href="../images/fox.css" rel="stylesheet" type="text/css" />
<link href="../js/jquery-ui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/myjs.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
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

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}

</style>
</head>

<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="../images/mail_leftbg.gif"><img src="../images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="../images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">仓库管理</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="../images/mail_rightbg.gif"><img src="../images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td valign="middle" background="../images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		<td width="20">
		<img src="../images/icon-login-seaver.gif" width="16" height="16" />
		</td>
		<td>
		当前位置：仓库管理>>仓库管理>>创建仓库(warehouseCreate.html)</td>

	</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
	<tbody class="tbody2">
			<tr>
		<td width="8%" align="left"><span>仓库名称</span></td>
		<td width="26%" align="left"><input name="mydate2" type="text" style="width:200px" value="" class="text_2000"/></td>
				<td width="10%" align="left"><span>仓库地址</span></td>
		        <td width="56%" align="left"><input  type="text" style="width:300px" value="" class="text_2000"/></td>
		</tr>
					
										<tr>
		<td width="8%" height="27" align="left">&nbsp;</td>
		<td width="26%" align="left">&nbsp;</td>
		<td width="10%" align="left">&nbsp;</td>
		        <td width="56%" align="center"><input name="button" type="button" class="Submit" style="width:100px" value="保存" onclick="window.location='warehouse.html'"/></td>
					</tr>
		</tbody>
	</table>
	</td>
    <td background="../images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="../images/mail_leftbg.gif"><img src="../images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="../images/buttom_bgs.gif"><img src="../images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="../images/mail_rightbg.gif"><img src="../images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
<p>页面要求：<br />
1.这是添加界面和修改界面。<br />

</body>
</html>