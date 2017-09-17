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
		当前位置：采购管理>>全年采购计划分解(decompositionProcurementPlanSelect.html)
		</td>

	</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		
		<td width="10%" align="center" height="30"><span class="left_bt2">请选择年份</span></td>
		<td width="9%"><select name="projectname" class="sec2" style="width:100px">
		<option value="0" selected="selected">请选择</option>
	  	<option value="2009">2009</option>
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
		<td width="7%" align="left"><span class="left_bt2">请选择车型</span></td>
		<td width="22%"><select name="select" class="sec2" style="width:250px">
		  <option value="0" selected="selected">请选择</option>
          <option value="2009">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2010">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2011">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2012">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2013">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2014">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2015">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2016">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2017">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2018">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2019">大切诺基BJ2021V8(4.7 自动 四驱)</option>
          <option value="2020">大切诺基BJ2021V8(4.7 自动 四驱)</option>
        </select></td>
		  
		  <td width="52%"><input type="button" class="Submit" value="查看" style="width:100px"/></td>
	</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<thead class="thead">
    	<tr>
		<th>序号</th>
		<th>品牌</th>
		<th>车辆编码</th>
		<th>年份</th>	
		<th>月份</th>	
		<th>计划数量</th>	
		<th>已采购</th>	
		<th>操作</th>
		</tr>
		</thead>
		<tbody class="tbody">
		 <tr>
		<td>1</td>
		<td>大切诺基</td>
		<td>BJ2021V8</td>
		<td>2009</td>
		<td>1</td>	
		<td>100</td>	
		<td><a style="color:#CC0000">80</a></td>	
		<td><a href="#" style="color:#000099">修改</a></td>
		</tr>
		 <tr>
		<td>2</td>
		<td>大切诺基</td>
		<td>BJ2021V8</td>
		<td>2009</td>
		<td>2</td>	
		<td>100</td>	
		<td><a style="color:#CC0000">80</a></td>
		<td><a href="#" style="color:#000099">修改</a></td>
		</tr>
		 <tr>
		<td>3</td>
		<td>大切诺基</td>
		<td>BJ2021V8</td>
		<td>2009</td>
		<td>3</td>	
		<td>100</td>	
		<td><a style="color:#CC0000">80</a></td>
		<td><a href="#" style="color:#000099">修改</a></td>
		</tr>
		 <tr>
		<td>4</td>
		<td>大切诺基</td>
		<td>BJ2021V8</td>
		<td>2009</td>
		<td>4</td>	
		<td>100</td>	
		<td><a style="color:#CC0000">80</a></td>
		<td><a href="#" style="color:#000099">修改</a></td>
	    </tr>
		 <tr>
		<td>5</td>
		<td>大切诺基</td>
		<td>BJ2021V8</td>
		<td>2009</td>
		<td>5</td>	
		<td>100</td>	
		<td><a style="color:#CC0000">80</a></td>
		<td><a href="#" style="color:#000099">修改</a></td>
	    </tr>
		 <tr>
		<td>6</td>
		<td>大切诺基</td>
		<td>BJ2021V8</td>
		<td>2009</td>
		<td>6</td>	
		<td>100</td>	
		<td><a style="color:#CC0000">80</a></td>
		<td><a href="#" style="color:#000099">修改</a></td>
	    </tr>
		<tr>
		<td>7</td>
		<td>大切诺基</td>
		<td>BJ2021V8</td>
		<td>2009</td>
		<td>7</td>	
		<td>100</td>	
		<td><a style="color:#CC0000">80</a></td>
		<td><a href="#" style="color:#000099">修改</a></td>
		</tr>
		 <tr>
		<td>8</td>
		<td>大切诺基</td>
		<td>BJ2021V8</td>
		<td>2009</td>
		<td>8</td>	
		<td>100</td>	
		<td><a style="color:#CC0000">80</a></td>
		<td><a href="#" style="color:#000099">修改</a></td>
	    </tr>	
		 <tr>
		<td>9</td>
		<td>大切诺基</td>
		<td>BJ2021V8</td>
		<td>2009</td>
		<td>9</td>	
		<td>100</td>	
		<td><a style="color:#CC0000">80</a></td>
		<td><a href="#" style="color:#000099">修改</a></td>
	    </tr>
		 <tr>
		<td>10</td>
		<td>大切诺基</td>
		<td>BJ2021V8</td>
		<td>2009</td>
		<td>10</td>	
		<td>100</td>	
		<td><a style="color:#CC0000">80</a></td>
		<td><a href="#" style="color:#000099">修改</a></td>
	    </tr>	
		 <tr>
		<td>11</td>
		<td>大切诺基</td>
		<td>BJ2021V8</td>
		<td>2009</td>
		<td>11</td>	
		<td>100</td>	
		<td><a style="color:#CC0000">80</a></td>
		<td><a href="#" style="color:#000099">修改</a></td>
	    </tr>	
		 <tr>
		<td>12</td>
		<td>大切诺基</td>
		<td>BJ2021V8</td>
		<td>2009</td>
		<td>12</td>	
		<td>100</td>	
		<td><a style="color:#CC0000">80</a></td>	
		<td><a href="#" style="color:#000099">修改</a></td>
	    </tr>
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
页面要求：<br />
1.年份下拉框是根据“全年采购计划表”中的年份来。如果系统还没有创建过全年采购计划，那么请选择年份下拉框中数据有一条为“无”。<br />
2.根据选择的年份来确定车型，这要使用AJAX省市互动来做，要完成根据选择年份的查询出本年份内已经分解过的车型信息并显示到请选择车型下拉框中，<br/>
如果查询出来的信息为空那么在“请选择车型下拉框”中显示一条记录为空。<br/>
3.如果2个下拉框中只要有一个下拉框中的值未选择，那么给予提示，并且不能进行查询操作，直到2个查询条件全部正确选择了值。<br />
4.点击修改后，计划数量变为文本框并且将原先的数字默认输入到文本框内，同事修改变为保存，当点击保存后需要做非空和有效性验证。
</body>
</html>
