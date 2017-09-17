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
		当前位置：采购管理>>制定全年采购计划>>查看年度采购计划
		</td>

	</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		
		<td width="4%"><span class="left_bt2">输入</span></td>
		<td width="10%"><select name="projectname" class="sec2" style="width:100px">
	  	<option value="2009" selected="selected">2009</option>
		<option value="2010">2010</option>
		<option value="2011">2011</option>
		<option value="2012">2012</option>
		<option value="2013">2013</option>
		<option value="2014">2014</option>
		<option value="2015">2015</option>
		<option value="2016">2016</option>
		<option value="2017">2017</option>
		<option value="2018">2018</option>
		<option value="2019">2019</option>
		<option value="2020">2020</option>
	  </select></td>
		<td width="11%"><input type="submit" class="Submit" value="查看全年计划"/></td>
		<td width="75%"></td>
	</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<thead class="thead">
		<tr>
		<th height="20" >序号</th>
		<th >年份</th>
		<th >品牌</th>
		<th >车型编码</th>	
		<th >车型特征</th>	
		<th >计划数量</th>	
		<th >已采购</th>
		<th >完成情况</th>
		</tr>
		</thead>
		<tbody class="tbody">
		 <tr>
		<td >1</td>
		<td>2009</td>
		<td>大切诺基</td>
		<td>BJ2021V8</td>	
		<td>4.7 自动 四驱</td>	
		<td>100</td>	
		<td><a style="color:#CC0000">80</a></td>
		<td>80%</td>
		</tr>
		 <tr>
		<td>2</td>
		<td>2009</td>
		<td>大切诺基</td>
		<td>BJ2021V8</td>	
		<td>4.7 自动 四驱</td>	
		<td>100</td>	
		<td><a style="color:#CC0000">80</a></td>
		<td>80%</td>
		</tr>
		 <tr>
		<td>3</td>
		<td>2009</td>
		<td>大切诺基</td>
		<td>BJ2021V8</td>	
		<td>4.7 自动 四驱</td>	
		<td>100</td>
		<td><a style="color:#CC0000">80</a></td>
		<td>80%</td>	
		</tr>
		 <tr>
		<td>4</td>
		<td>2009</td>
		<td>大切诺基</td>
		<td>BJ2021V8</td>	
		<td>4.7 自动 四驱</td>	
		<td>100</td>
		<td><a style="color:#CC0000">80</a></td>
		<td>80%</td>	
		</tr>
		 <tr>
		<td>5</td>
		<td>2009</td>
		<td>大切诺基</td>
		<td>BJ2021V8</td>	
		<td>4.7 自动 四驱</td>	
		<td>100</td>
		<td><a style="color:#CC0000">80</a></td>
		<td>80%</td>	
		</tr>
		 <tr>
		<td>6</td>
		<td>2009</td>
		<td>大切诺基</td>
		<td>BJ2021V8</td>	
		<td>4.7 自动 四驱</td>	
		<td>100</td>
		<td><a style="color:#CC0000">80</a></td>
		<td>80%</td>	
		</tr>			
		</tbody>	
    </table>
		<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		
		<td width="89%">&nbsp;</td>
		<td width="11%" align="center">
			<a href="javascript:history.back()" class="red">
		  <input type="submit" class="Submit" value="返  回" onclick="javascript:history.back()"/></a>		</td>
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
1.此界面为租赁船期界面，其中租赁费用为每趟的价格，单位是万。<br />
2.分页每页显示15条数据。<br />
3.船期编号10位<br />
</body>
</html>
