<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<title>My JSP 'dealerOrderManager.jsp' starting page</title>   
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/js/jquery-ui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/myjs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/My97DatePicker/WdatePicker.js"></script>
 
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
<!-- 
<script type="text/javascript">
	function ctot(){
		var c=$("#sttud").val();
		if(c==0){
		alert("请选择经销商!")
		return false;
		}else{ return true;}
	 
	}
</script> -->
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
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">
   		<img src="${pageContext.request.contextPath}/resources/images/left-top-right.gif" width="17" height="29" />
    </td>
    <td valign="top" background="${pageContext.request.contextPath}/resources/images/content-bg.gif">
	    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
	      <tr><td height="31"><div class="titlebt">销售管理</div></td></tr>
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
				<td>当前位置：销售管理>>经销商订单管理</td>
			</tr>	
		</table>
	<form action="FindListDealerOrder" method="post">
		<table width="98%" border="0"  style="text-align: center;" align="center" cellpadding="0" cellspacing="0" class="line_table">
			<tr>
				<td width="15%" align="center" height="30"><span class="left_bt2">请选择经销商</span></td>
				<td width="21%">
					<select name="dealerId" id="sttud" class="sec2" style="width:200px" >
						<c:if test="${empty requestScope.dealerId}">
				          	<option value="0">请选择</option>
				          	<c:forEach items="${dealers}" var="dealer">
				        		<option value="${dealer.dealerId }">${dealer.storefrontName}(${dealer.principalName })</option>
							</c:forEach>
				        </c:if>
				        
				        <c:if test="${!empty requestScope.dealerId}">
				          	<c:forEach items="${dealers}" var="dealer">
				          		<c:if test="${dealer.dealerId==dealerId}">
				        			<option value="${dealer.dealerId }">${dealer.storefrontName}(${dealer.principalName })</option>
				        		</c:if>
							</c:forEach>
							<c:forEach items="${dealers}" var="dealer">
				          		<c:if test="${dealer.dealerId!=dealerId}">
				        			<option value="${dealer.dealerId }">${dealer.storefrontName}(${dealer.principalName })</option>
				        		</c:if>
							</c:forEach>
							<option value="0">请选择</option>
				        </c:if>
					</select>
		        </td>
		 	 	<td width="7%" align="left"><span class="left_bt2">订单编号</span></td>
		 	
				<td width="22%">
				<c:if test="${! empty orderNumber}">
				<input name="orderNumber" value="${orderNumber}" style="height: 30px;" type="text" maxlenght="8"  class="text_2000"/>
				</c:if>
				<c:if test="${empty orderNumber}">
				<input name="orderNumber"  type="text" style="height: 20px; maxlenght="8"  class="text_2000"/>
				</c:if>
				</td>
			</tr>
			<tr>
			<td width="15%" align="center"><span class="left_bt2">开始日期</span></td>
			<td width="21%">
			<c:if test="${! empty beginDate}">
			<input name="beginDate" type="text" value="${ requestScope.beginDate}" style="width:200px" 
			 class="Wdate" onclick="WdatePicker()"/>
			</c:if>
			<c:if test="${ empty beginDate}">
			<input name="beginDate" type="text"  style="width:200px"  class="Wdate" onclick="WdatePicker()"/>
			</c:if>
			</td>
			<td width="7%"><span class="left_bt2">结束日期</span></td>
			
			<td width="22%">
			<c:if test="${! empty endDate}">
			<input name="endDate" type="text" value="${ requestScope.endDate}" style="width:200px" 
	        class="Wdate" onclick="WdatePicker()"/>
			</c:if>
			<c:if test="${ empty endDate}">
			<input name="endDate" type="text"  style="width:200px"  class="Wdate" onclick="WdatePicker()"/>
			</c:if>
			</td> 
			<td width="35%"><input  type="submit" class="Submit" style="width:100px" value="查询"/>
			  <input type="button" class="Submit" value="创建销售订单" style="width:100px" onclick="window.location='addDealOrder1'"/></td>
		</tr>
		</table>
		</form>
	<table width="98%" border="0" align="center" style="text-align: center;" cellpadding="0" cellspacing="0" class="line_table">
		<thead class="thead">
    	<tr>
		<th width="7%">序号</th>
		<th width="10%">订单编号</th>
		<th width="20%">店面地址</th>
		<th width="11%">经销商名称</th>	
		<th width="16%">下单日期</th>	
		<th width="28%">收货地址</th>	
		<th width="8%">操作</th>
		</tr>
		</thead>
		<tbody class="tbody">
			<c:if test="${empty dealerOrders}">
			<tr>
				<td colspan="7" align="center" style="color: red;font-size: 16px;">没有相关数据</td>
			</tr>
			</c:if>
		 <c:if test="${!empty dealerOrders}"> 
		
			<c:forEach items="${requestScope.dealerOrders}" var="dod" varStatus="st">
			 <tr>	
			<td>${st.count }</td>
			<td>${dod.orderNumber}</td>
			<td>${dod.dealer.storefrontAddress}</td>
			<td>${dod.dealer.principalName}</td>
			<td>
			<fmt:formatDate value="${dod.certificateDate}" pattern="yyyy-MM-dd" />
			</td>
			<td>${dod.dealer.portAddress}</td>
			<td><a href="findDetails?dealerOrderId=${dod.dealerOrderId }" style="color:#000099">查看</a>
			</tr>
			</c:forEach>	
	  </c:if>  
		</tbody>						
    </table>

	</td>
    <td background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">
    <img src="${pageContext.request.contextPath}/resources/images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif">
    <img src="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">
    <img src="${pageContext.request.contextPath}/resources/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
</body>
</html>
