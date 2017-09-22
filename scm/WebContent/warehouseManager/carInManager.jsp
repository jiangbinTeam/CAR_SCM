y<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/js/jquery-ui.css" rel="stylesheet" type="text/css" />


<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/myjs.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
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
	$('#dialog').dialog({
		autoOpen: false,
		width: 500,
		height:200,
		closeText:"",
		buttons: {
			"取消": function() { 
				$(this).dialog("close"); 
			 }, 
			"确定": function() { 
				$(this).dialog("close"); 
			} 
		    }
	  });
	 $("a[name='storage']").click(function(){
					 
		$('#dialog').dialog('open');
			return false;
	 });
})
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
-->
</style>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">
   	 <img src="${pageContext.request.contextPath}/resources/images/left-top-right.gif" width="17" height="29" />
    </td>
    <td valign="top" background="${pageContext.request.contextPath}/resources/images/content-bg.gif">
    	<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">仓库管理</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">
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
				<td>当前位置：仓库管理>>车辆出库管理</td>
			</tr>
		</table>
	        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		<td width="16%" align="center" height="30"><span class="left_bt2">仓库名</span></td>
		<td width="21%"><select name="projectname" class="sec2" style="width:200px">
          <option value="0" selected="selected">请选择</option>
          <option value="2009">嘉庆仓库</option>
          <option value="2010">嘉庆仓库</option>
        </select></td>
		  <td width="63%"><input name="button" type="button" class="Submit" style="width:100px" value="查看"/></td>
	</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<thead class="thead">
    	<tr>
			<th width="10%">序号</th>
			<th width="18%">仓库名称</th>
			<th width="20%">库位名称</th>
			<th width="26%">操作</th>
		</tr>
		</thead>
		<tbody class="tbody">
		<tr>
			<td>1</td>
			<td>嘉庆仓库</td>
			<td>A4</td>
			<td>
			<a href="#" style="color:#000099" name="storage">入库</a></td>
		</tr>
		</tbody>						
    </table>
		<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		  <td width="869">&nbsp;</td>
		  <td width="63" align="right"><a href="#"><span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="#"><span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">1/15</span></td>
		  <td width="66" align="left"><a href="#"><span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="#"><span class="left_ts">尾页</span></a></td>
		</tr>
	</table>
	</td>
    <td background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">
    	<img src="${pageContext.request.contextPath}/resources/images/buttom_left2.gif" width="17" height="17" />
    </td>
    <td background="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif">
    	<img src="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif" width="17" height="17">
    </td>
    <td valign="bottom" background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">
    	<img src="${pageContext.request.contextPath}/resources/images/buttom_right2.gif" width="16" height="17" />
    </td>
  </tr>
</table>
<div id="dialog" title="车辆入库">
		<table>
		    <tr>
				<td width="178"><a class="message"><strong>VIN号</strong></a></td>
				<td width="546"><input type="text" style="width:200px; height:30px;"  class="text_2000" value="自动补全做"/></td>
			</tr>
		</table>
</div>
</body>
</html>