<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>采购管理</title>
    
	<link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css" rel="stylesheet" type="text/css" />

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
  }); 

$("#selectYear").click(function(){ //click() 点击事件
	var slv = $("#selectYear").val(); // .val 返回第一个匹配元素的 value 属性的值
		$("#selectYear").empty();
		$.ajax({
			url:"selectYear", //请求的地址
			type:"get", //请求方式为get
			success:function(data){ //success指的是请求并成功返回信息 data返回的内容
				var type =eval("(" + data + ")"); //转换为json对象 
				/* $("#selectYear").empty();  */// empty() 删除匹配的元素集合中所有的子节点。
				$.each(type,function(key,value){	// each() 循环 //遍历处理data(type)
				var op="<option value="+value.yearProcurementPlanYear+">"+value.yearProcurementPlanYear+"</option>";
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
	<form action="yearProcurementPlanSelect" method="post">
		<tr>
		<td width="4%"><span class="left_bt2">年份</span></td>
		<td width="10%">
	  	<select  name="yearProcurementPlanYear"  class="sec2" style="width:100px">
			<c:if test="${!empty yearProcurementPlanYear}">
				
			    <c:forEach items="${years}" var="y">
					 <c:if test="${y.yearProcurementPlanYear==yearProcurementPlanYear}">  
						<option value="${yearProcurementPlanYear}">${yearProcurementPlanYear}年</option>
					 </c:if> 
				</c:forEach>
				
				 <c:forEach items="${years}" var="y">
					<c:if test="${y.yearProcurementPlanYear!=yearProcurementPlanYear}">
						<option value="${y.yearProcurementPlanYear}">${y.yearProcurementPlanYear}年</option>
					</c:if>
				</c:forEach> 
				<option value="0" >请选择</option>
			</c:if>
			<c:if test="${empty yearProcurementPlanYear}">
				<option value="0" >请选择</option>
				<c:forEach items="${years}" var="y">
						<option value="${y.yearProcurementPlanYear}">${y.yearProcurementPlanYear}年</option>
				</c:forEach>
			</c:if> 
		</select>
	  </td>
		<td width="11%"><input type="submit" class="Submit" value="查看全年计划"/></td>
		<td width="75%"></td>
	</tr>
	</form>
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
		<tbody class="tbody" align="center" >
		 <tr>
			<c:forEach items="${list}" var="list" varStatus="i">
					 <tr>
						<td>${i.index+1}</td>
						<td>${list.yearProcurementPlanYear}</td>
						<td>${list.brand}</td>
						<td>${list.typeCode}</td>
						<td>${list.carCharacter}</td>
						<td>${list.yearProcurementPlanCount}</td>
						<td><a style="color:#CC0000">${list.carProcurementListCount}</a></td>
						<td align="center">
							<c:if test="${(list.carProcurementListCount/list.yearProcurementPlanCount)*100==100}">完成</c:if>
							<c:if test="${(list.carProcurementListCount/list.yearProcurementPlanCount)*100!=100}">
								<fmt:formatNumber type="number" value="${(list.carProcurementListCount/list.yearProcurementPlanCount)*100}"
									pattern="0.00" maxFractionDigits="2"/>
							%</c:if>
						</td>
					 </tr>
				</c:forEach>
		</tr>
		</tbody>	
    </table>
		<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		  <td width="869">&nbsp;</td>
		   <td width="63" align="right"><a href="yearProcurementPlanSelect?currPage=1&yearProcurementPlanYear=${yearProcurementPlanYear}"><span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="yearProcurementPlanSelect?currPage=${currPage-1}&yearProcurementPlanYear=${yearProcurementPlanYear}"><span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left"><a href="yearProcurementPlanSelect?currPage=${currPage+1}&yearProcurementPlanYear=${yearProcurementPlanYear}"><span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="yearProcurementPlanSelect?currPage=${totalPage}&yearProcurementPlanYear=${yearProcurementPlanYear}"><span class="left_ts">尾页</span></a></td>
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
