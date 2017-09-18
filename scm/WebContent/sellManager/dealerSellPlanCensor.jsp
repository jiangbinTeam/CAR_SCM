<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
    <td width="17" valign="top" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">
    	<img src="${pageContext.request.contextPath}/resources/images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="${pageContext.request.contextPath}/resources/images/content-bg.gif">
	    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
	      <tr>
	        <td height="31"><div class="titlebt">销售管理</div></td>
	      </tr>
	    </table>
    </td>
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
		<td>当前位置：销售管理>>经销商销售计划审查</td>
	</tr>
  </table>
	<form action="listPage" method="get">
	<input type="hidden" name="currPage" value="1">
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		<td width="7%" align="center" height="30"><span class="left_bt2">请选择年份</span></td>
		<td width="9%">
			<c:if test="${year==0}">
			  <select name="year" class="sec2" style="width:100px">
				<option value="0">请选择</option>
				 <c:forEach items="${years}" var="y">
						 <option value="${y}">${y}年</option>	 
				</c:forEach>	  
			  </select>
			</c:if>
			<c:if test="${year!=0}">
				<select name="year" class="sec2" style="width:100px">
					<option value="${year}" selected="selected">${year}年</option>
					<option value="0">请选择</option>
					 <c:forEach items="${years}" var="y">
					  	<c:if test="${year!=y}"> 
							 <option value="${y}">${y}年</option>	 
						</c:if> 
					</c:forEach>	  
			  </select>
			</c:if>
		</td>
	  
	  	<td width="7%" align="center" height="30"><span class="left_bt2">请选择月份</span></td>
		<td width="9%">
			<select name="mouth" class="sec2" style="width:100px">
				<c:if test="${mouth==0}">
					<option value="0">请选择</option>
				  	<option value="1">1月</option>
					<option value="2">2月</option>
					<option value="3">3月</option>
					<option value="4">4月</option>
					<option value="5">5月</option>
					<option value="6">6月</option>
					<option value="7">7月</option>
					<option value="8">8月</option>
					<option value="9">9月</option>
					<option value="10">10月</option>
					<option value="11">11月</option>
					<option value="12">12月</option>
				</c:if>
				<c:if test="${mouth!=0}">
					<option value="${mouth}" selected="selected">${mouth}月</option>
				  	<option value="0">请选择</option>
				  	<option value="1">1月</option>
					<option value="2">2月</option>
					<option value="3">3月</option>
					<option value="4">4月</option>
					<option value="5">5月</option>
					<option value="6">6月</option>
					<option value="7">7月</option>
					<option value="8">8月</option>
					<option value="9">9月</option>
					<option value="10">10月</option>
					<option value="11">11月</option>
					<option value="12">12月</option>
				</c:if>
			  </select>
		</td>
		
		<td width="6%" align="left"><span class="left_bt2">请选择车型</span></td>
		<td width="22%">
			<c:if test="${carType=='0'}">
			 <select name="carType" class="sec2" style="width:250px">
				<option value="0" selected="selected">请选择</option>
				 <c:forEach items="${typeDictionarys}" var="t">
					<option value="${t.typeCode}">${t.brand}</option>	 
				</c:forEach>	  
			  </select>
			</c:if>
			<c:if test="${carType!='0'}">
				<select name="carType" class="sec2" style="width:250px">
				<!-- 回显选择项 -->
				<c:forEach items="${typeDictionarys}" var="type">
					 <c:if test="${carType==type.typeCode}"> 
						 <option value="${type.typeCode}" selected="selected">${type.brand}</option>	 
					</c:if> 
				</c:forEach>	
				  
				<option value="0">请选择</option>
				<c:forEach items="${typeDictionarys}" var="t">
					 <c:if test="${carType!=t.typeCode}"> 
						 <option value="${t.typeCode}">${t.brand}</option>	 
					</c:if> 
				</c:forEach>	
				  
			  </select>
			</c:if>
	    </td>
		
		<td width="8%" align="left"><span class="left_bt2">请选择经销商</span></td>
		<td width="23%">
			<c:if test="${dealerID==''}">
			<select name="dealerID" class="sec2" style="width:250px">
				<option value="0" selected="selected">请选择</option>
				 <c:forEach items="${dealers}" var="d">
					<option value="${d.dealerId}">${d.storefrontName}</option>	 
				</c:forEach>	  
			  </select>
			</c:if>
			<c:if test="${dealerID!=''}">
				<select name="dealerID" class="sec2" style="width:250px">
					<!-- 回显选择项 -->
					<c:forEach items="${dealers}" var="d">
						 <c:if test="${dealerID==d.dealerId}"> 
							 <option value="${d.dealerId}">${d.storefrontName}</option>	 
						</c:if> 
					</c:forEach>
					<option value="0">请选择</option>
					<c:forEach items="${dealers}" var="d">
						 <c:if test="${dealerID!=d.dealerId}"> 
							 <option value="${d.dealerId}">${d.storefrontName}</option>	 
						</c:if> 
					</c:forEach>	  
			  </select>
			</c:if>
        </td>
		<td width="9%"><input type="submit" class="Submit" value="查看" style="width:100px"/></td>
	</tr>
	</table>
	</form>
	<table width="98%" border="0" style="text-align: center;" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<thead class="thead">
	    	<tr>
				<th width="8%">序号</th>
				<th width="27%">经销商</th>
				<th width="12%">品牌</th>
				<th width="17%">车辆编码</th>
				<th width="13%">年份</th>	
				<th width="10%">月份</th>	
				<th width="13%">计划数量</th>	
				
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach items="${dealerSellPlanCs}" var="d" varStatus="i">
				 <tr>
					<td>${i.index+1}</td>
					<td>${d.storefrontName }</td>
					<td>${d.brand }</td>
					<td>${d.typeCode }</td>
					<td>${d.year }</td>
					<td>${d.yearPlanMouth }</td>	
					<td>${d.yearPlanDealerCount }</td>	
					<!-- <td><a href="dealerSellPlanCensorList.html" style="color:#000099">80</a></td>	 -->
				</tr>
			</c:forEach>
		</tbody>						
    </table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
			<td width="869">&nbsp;</td>
			<td width="63" align="right">
				<a href="listPage?currPage=1&year=${year}&mouth=${mouth}&carType=${carType}&dealerID=${dealerID}">
					<span class="left_ts">首页</span>
				</a>
			</td>
			<td width="63" align="right">
				<a href="listPage?currPage=${currPage-1}&year=${year}&mouth=${mouth}&carType=${carType}&dealerID=${dealerID}">
					<span class="left_ts">上一页</span>
				</a>
			</td>
			<td width="63" align="center">
				<span class="admin_toptxt">${currPage }/${totalPage }</span></td>
			<td width="66" align="left">
				<a href="listPage?currPage=${currPage+1}&year=${year}&mouth=${mouth}&carType=${carType}&dealerID=${dealerID}">
					<span class="left_ts">下一页</span>
				</a>
			</td>
			<td width="63" align="left">
				<a href="listPage?currPage=${totalPage}&year=${year}&mouth=${mouth}&carType=${carType}&dealerID=${dealerID}">
					<span class="left_ts">尾页</span>
				</a>
			</td>
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
</body>
</html>