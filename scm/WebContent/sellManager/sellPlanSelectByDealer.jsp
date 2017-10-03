<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'sellPlanDecompositionByDealer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-ui.min.js"></script>
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
$("#selectYear").click(function(){ //click() 点击事件
	var slv = $("#selectYear").val(); // .val 返回第一个匹配元素的 value 属性的值
		$("#selectYear").empty();
		$.ajax({
			url:"selectYea3", //请求的地址
			type:"get", //请求方式为get
			success:function(data){ //success指的是请求并成功返回信息 data返回的内容
				var type =eval("(" + data + ")"); //转换为json对象 
				/* $("#selectYear").empty();  */// empty() 删除匹配的元素集合中所有的子节点。
				$.each(type,function(key,value){	// each() 循环 //遍历处理data(type)
				var op="<option value="+value.principalName+">"+value.principalName+"</option>";
				 $("#selectYear").append(op); // .append 向每个匹配的元素内部追加内容。
				 $("#selectYear").val(slv); //.val(slv) 设置 Value 属性的值
				});
			}
		});
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
        <td height="31"><div class="titlebt">销售管理</div></td>
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
		当前位置：销售管理>>全年销售计划查询>>按经销商销售计划分解(sellPlanDecompositionByDealer.jsp)</td>
	</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<form action="yearSellPlan_findAlDea2" method="post">
		<tr>
		<td width="4%"><span class="left_bt2">年份</span></td>
		<td width="10%">
	  	<select id="selectYear" name="principalName" class="sec2" style="width:100px">
			 <option value="0" >请选择</option>		          		         	 	        
	  	</select>
	  </td>
	  
		<td width="11%"><input type="submit" class="Submit" value="搜索计划"/></td>
		<td width="75%"></td>
	</tr>
	</form>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<thead class="thead">
	    <tr>
		<th width="10%">序号</th>
		<th width="15%">品牌</th>
		<th width="19%">店面名称</th>
		<th width="19%">经销商姓名</th>
		<th width="12%">年份</th>	
		<th width="12%">月份</th>	
		<th width="10%">计划数量</th>	
		</tr>
		<c:if  test="${empty list}">
		
			<tr height="100px" >
				<td align="center" colspan="6"><h1>请选中经销商点击搜索</h1></td>
			</tr>
		</c:if>
		</thead>		
		<tbody class="tbody">
		
		<c:forEach items="${list }" var="l" varStatus="i">	
		 <tr>
		<td >${i.index+1 }</td>
		<td >${l.brand } （${l.typeCode } ） </td>
		<td >${l.storefrontName }</td>
		<td >${l.principalName } </td>
		<td >${l.year } </td>
		<td >${l.yearPlanMouth } </td>	
		<td >${l.yearPlanDealerCount } </td>			
		</tr>	
		</c:forEach>		
		</p>			 
		</tbody>						
    </table>
    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
    <c:if test="${empty principalName }">
    	<tr>
			<td width="869">&nbsp;</td>
		   <td width="63" align="right"><a href="yearSellPlan_findAlDea?currPage=1&principalName=${principalName }"><span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="yearSellPlan_findAlDea?currPage=${currPage-1}&principalName=${principalName }"><span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left"><a href="yearSellPlan_findAlDea?currPage=${currPage+1}&principalName=${principalName }"><span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="yearSellPlan_findAlDea?currPage=${totalPage}&principalName=${principalName }"><span class="left_ts">尾页</span></a></td>
		</tr>
    </c:if>
    <c:if test="${!empty principalName }">
		<tr>
			<td width="869">&nbsp;</td>
		   <td width="63" align="right"><a href="yearSellPlan_findAlDea2?currPage=1&principalName=${principalName }"><span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="yearSellPlan_findAlDea2?currPage=${currPage-1}&principalName=${principalName }"><span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left"><a href="yearSellPlan_findAlDea2?currPage=${currPage+1}&principalName=${principalName }"><span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="yearSellPlan_findAlDea2?currPage=${totalPage}&principalName=${principalName }"><span class="left_ts">尾页</span></a></td>
		</tr>
		</c:if>
	</table>
    <td background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif"><img src="${pageContext.request.contextPath}/resources/images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif"><img src="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif"><img src="${pageContext.request.contextPath}/resources/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
<p>页面说明:<br/>
1.总量根据对文本框输入的数字可进行加减操作。入在第一行内输入5那么总量动态的减少5变为95。<br/>
2.保存的时候需要验证是否文本框内是否全部输入的是数字。
</body>
</html>
