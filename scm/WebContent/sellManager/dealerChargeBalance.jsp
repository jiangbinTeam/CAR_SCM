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
    <td width="17" valign="top" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">
    	<img src="${pageContext.request.contextPath}/resources/images/left-top-right.gif" width="17" height="29" />
    </td>
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
			<td>当前位置：销售管理>>经销商费用结算</td>
		</tr>
	</table>
	<form action="dealerSettlementByid" method="post">
	 	<input type="hidden" name="currPage" value="1">
		<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
			<td width="9%" height="30" align="left"><span class="left_bt2">请选择经销商</span></td>
			<td width="25%">
				<c:if test="${dealerId==''}">
				  <select id="dealerId" name="dealerId"   class="sec2" style="width:200px">
		           <option  value="0" selected="selected">请选择</option>
			           <c:forEach var="wc" items="${warName}" > 
		              	  <option value="${wc.dealerId}">${wc.storefrontName}(${wc.principalName})</option>
			           </c:forEach>    
		          </select>   
		        </c:if>
           
         		<c:if test="${dealerId!=''}">
				<select id="dealerId" name="dealerId" class="sec2" style="width:250px">
					<c:forEach items="${warName}" var="wc">
						 <c:if test="${dealerId==wc.dealerId}"> 
							 <option value="${wc.dealerId}" >${wc.storefrontName}(${wc.principalName})</option>	 
						</c:if> 
					</c:forEach>	  
					<option value="0">请选择</option>	
			      <c:forEach items="${warName}" var="wc">
				  <c:if test="${dealerId!=wc.dealerId}"> 
						<option value="${wc.dealerId}">${wc.storefrontName}(${wc.principalName})</option>	 
				  </c:if> 
		          </c:forEach>
					   
			  </select>
			</c:if>  
        </td>
		  
		  
		  <td width="66%">
		  <input type="submit" class="Submit" value="查看" style="width:100px"/>
		  	<input type="button" id="exportData" class="Submit"  value="导出" style="width:100px"/>		
		  </td>
	</tr>
	</table>
	</form>
	<script type="text/javascript" language="JavaScript">
		$(function() {
			var dealerId=document.getElementById("dealerId").value;
			$("#exportData").click(function(){
				$.post("exportPayData", {"dealerId":dealerId},function(data){
					alert("导出成功！");
				})
			});
		});
	</script>
	
	<table width="98%" border="0" align="center" style="text-align: center;" cellpadding="0" cellspacing="0" class="line_table">
		<thead class="thead">
    	<tr>
		<th width="5%">序号</th>
		<th width="16%">订单号</th>
		<th width="20%">汽车VIN号</th>
		<th width="10%">车款</th>	
		<th width="12%">加装款</th>	
		<th width="22%">合计</th>
		</tr>
		</thead>
		<tbody class="tbody">
			<c:if test="${empty requestScope.wars}">
				<tr><td colspan="6" style="color: red;text-align: center;">没有符合条件的数据</td></tr>
			</c:if>
			<c:if test="${!empty requestScope.wars}">
			<c:forEach var="dea" items="${requestScope.wars}" varStatus="i">
				 <tr>
				<td>${i.index+1}</td>
				<td>${dea.orderNumber}</td>
				<td>${dea.vinNumber}</td>
				<td>${dea.sellPrice}万</td>
				<c:if test="${empty dea.addAccessorizeCharge}">
					<td>${dea.addAccessorizeCharge}</td>
				</c:if>
				<c:if test="${!empty dea.addAccessorizeCharge}">
					<td>${dea.addAccessorizeCharge}万</td>
				</c:if>	
				<td>${dea.sellPrice+dea.addAccessorizeCharge}万</td>
				</tr>
				</c:forEach>
			</c:if>
		</tbody>						
    </table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
			<td width="869">&nbsp;</td>
		  <td width="63" align="right"><a href="dealerSettlementByid?currPage=1&dealerId=${dealerId}"><span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="dealerSettlementByid?currPage=${currPage-1}&dealerId=${dealerId}"><span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage}/${totalPage}</span></td>
		  <td width="66" align="left"><a href="dealerSettlementByid?currPage=${currPage+1}&dealerId=${dealerId}"><span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="dealerSettlementByid?currPage=${totalPage}&dealerId=${dealerId}"><span class="left_ts">尾页</span></a></td>
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