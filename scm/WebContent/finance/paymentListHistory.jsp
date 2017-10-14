<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/My97DatePicker/WdatePicker.js"></script>


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
	    <td width="17" valign="top" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">
	    	<img src="${pageContext.request.contextPath}/resources/images/left-top-right.gif" width="17" height="29" />
	    </td>
	    <td valign="top" background="${pageContext.request.contextPath}/resources/images/content-bg.gif">
	   	<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
	      <tr>
	        <td height="31"><div class="titlebt">打款记录</div></td>
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
			<td>当前位置：财务管理>>打款管理>>打款记录</td>
		</tr>
	</table>
	<form action="paymentListAdd" method="get">
		<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tbody class="tbody2">
			<tr>
				<td width="5%" align="left"><strong><span>打款金额(单位:万)</span></strong></td>
				<td width="12%" align="left">
					<input type="text" name="paymentListMoney" id="sumMoney" value="${paymentList.paymentListMoney}" readonly="readonly" 
						style="color: red;font-weight: bold;border: 0;width:80px;">万元(人民币)
				</td>
				<td width="5%" align="left"><strong><span>车辆数</span></strong></td>
				<td width="12%" align="left">
					<input type="text" id="sumCar" value="${paymentList.paymentListCount}" readonly="readonly" name="paymentListCount" 
						style="color: red;font-weight: bold;border: 0;width:80px;">(辆)
				</td>
			</tr>
			<!-- <tr>
				<td width="5%" align="left"><strong><span>汇率</span></strong></td>
				<td width="12%" align="left">
					<input name="mydate2" type="text" style="width:200px" value="" class="text_2000"/>
				</td>
				<td width="5%" align="left"></td>
				<td width="12%" align="left"></td>
				
			</tr> 
						
			<tr>
				<td width="5%" height="27" align="left">&nbsp;</td>
				<td width="12%" align="left">&nbsp;</td>
				<td width="5%" align="left">&nbsp;</td>
				<td width="12%" align="left">
				  <input type="submit" class="Submit" style="width:100px" value="保存"/>
				</td>
			</tr>-->
			</tbody>
		</table>
	
	<table width="98%" border="0" style="text-align: center;" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<thead class="thead">
		<!-- <tr>
			
			<td align="left" colspan="5">
				 <input id="checkAll" name="checkAll" class="check" type="checkbox"/>全选
			</td>
				
		</tr> -->
    	<tr>
			<th width="4%">序号</th>
			<th width="14%">VIN号</th>
			<th width="16%">实际打款日期</th>	
			<th width="15%">打款金额(单位:万)</th>	
		</tr>
		</thead>
		<tbody class="tbody">
		<c:forEach items="${vins}" var="v" varStatus="i">
			<tr>
				<td height="29">${i.index+1}</td>
				<td>
					<input type="text" name="vinNumber" value="${v.vinNumber}" readonly="readonly" 
						style="border: 0;width:150px;text-align: center;">
				</td>
				<td><fmt:formatDate value="${v.actualPaymentDate}" pattern="yyyy-M-d"/></td>
				<td>${v.stockPrice}</td>
			</tr>
		</c:forEach>	
	  </tbody>						
    </table>
    </form>
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