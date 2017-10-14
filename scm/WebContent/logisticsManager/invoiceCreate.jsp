<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'invoiceCreate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/js/jquery-ui.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

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

</script> 
<script type="text/javascript">
function addd(){
if($("#invoiceNumber1").val()==null||$("#invoiceNumber1").val()==""){
alert("请填写发车单号！！！");
return false;
}
if($("#dealerId1").val()=='0'||$("#logisticsId1").val()=='0'){
alert("请把经销商与物流公司填写完整！！！");
return false;
}

if($("#carriageCharge1").val()==""||$("#carriageCharge1").val()==null){
alert("请填写运费！！！");
return false;
}
 if(isNaN($("#carriageCharge1").val())){
		 alert("非数字类型!!!");
		return false;
}

var ce=0;
$("input:checkbox[name=startAccountingId]:checked").each(function(){
ce=$(this).val();

});
if(ce==0){
alert("至少勾选一个vin号！！！")
return false;
}

 if(confirm("确定创建发车单？")){
 $("#myform1").submit();
 }
}
</script>           
<script type="text/javascript">
function cke(){
var ss=false;
if ($("#checkAll").val()==1){
$("#checkAll").val(2);
ss=true;
}else{
$("#checkAll").val(1);
ss=false;
}



 //$(":checkbox").attr("checked","checked");
if(ss==true){
$("input:checkbox[name='startAccountingId']").attr("checked","checked");
		
}else{
$("input:checkbox[name='startAccountingId']").removeAttr("checked")
			
}
}
</script>
<style type="text/css"> 
.hover{background-color:#CACACA;}  /*这里是鼠标经过时的颜色*/ 

</style>
<style type="text/css">

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
        <td height="31"><div class="titlebt">物流管理</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">
    <img src="${pageContext.request.contextPath}/resources/images/nav-right-bg.gif" width="16" height="29" /></td>
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
		当前位置：物流管理>>发货单管理>>发货单维护</td>

	</tr>
	</table>
	<form action="createInv" method="post" id="myform1">
	<table width="98%" border="0"  style="text-align: center;" align="center" cellpadding="0" cellspacing="0" class="line_table">
	<tbody class="tbody2">
			<tr>
		<td width="5%" align="left"><span>发货单号</span></td>
		<td width="12%" align="left">
		<input name="invoiceNumber" type="text" id="invoiceNumber1" maxlenght="16" style="width:200px;height: 20px;" value="" class="text_2000"/></td>
				<td width="5%" align="left"><span>经销商</span></td>
	          <td width="12%" align="left"><select name="dealerId" id="dealerId1" class="sec2" style="width:200px">
		  <option value="0" selected="selected">请选择</option>
         <c:forEach items="${sessionScope.dealers}" var="inv" varStatus="st">
          <option value="${inv.dealerId }">${inv.dealerName}(${inv.principalName})</option>
         </c:forEach>
        </select></td>
		</tr>
	<tr>
		<td width="5%" align="left"><span>运输公司</span></td>
		<td width="12%" align="left"><select name="logisticsId" id="logisticsId1" class="sec2">
          <option value="0" selected="selected">请选择</option>
          <c:forEach items="${logistics }" var="log">
          <option value="${log.logisticsId}">${log.logisticsName}</option>
          </c:forEach>
          
        </select></td>
		<td width="5%" align="left"><span>运输费用</span></td>
		<td width="12%" align="left">
		 <input name="carriageCharge" id="carriageCharge1" type="text" maxlenght="8"
		  onkeyup="this.value=this.value.replace(/[^\d.]/g,'');" style="width:200px;height: 20px;" class="text_2000"/>(单位：万)
		 </td>
	</tr>
		
		<tr>
		  <td align="left">全选<input type="checkbox"  id="checkAll" value="1" onclick="cke()"></td>
		  <td align="left">&nbsp;</td>
		  <td width="5%" align="left"></td>
                        <td width="12%" align="left"><input id="button" type="button" class="Submit" style="width:100px" value="保存" onclick="addd()"/></td>
		</tr>
		</tbody>
	</table>
	
	<table width="98%" border="0" style="text-align: center;" align="center" cellpadding="0" cellspacing="0" class="line_table">
      <thead class="thead">
        <tr>
          <th width="5%">请选择</th>
          <th width="7%">序号</th>
          <th width="11%">订单号</th>
          <th width="18%">VIN号</th>
          <th width="23%">车型</th>
        </tr>
      </thead>
      <tbody class="tbody">
      <c:if test="${!empty invoice3s}">
      <c:forEach items="${invoice3s}" var="invs" varStatus="sta">
        <tr>
          <td height="29">${sta.count }</td>
          <td><input name="startAccountingId" value="${invs.startAccountingId }" type="checkbox"/></td>
          <td>${invs.orderNumber }</td>
          <td>${invs.vinNumber }</td>
          <td>${invs.brand }(${invs.carCharacter })</td>
        </tr>
        </c:forEach>
        </c:if>
      </tbody>
    </table>
    </form>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
	<c:if test="${!empty invoice3s}">
    	<tr>
		<td width="869">&nbsp;</td>
		  <td width="63" align="right"><a href="fyCinv?currPage=1">
		  <span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="fyCinv?currPage=${currPage-1}">
		  <span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left"><a href="fyCinv?currPage=${currPage+1}">
		  <span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="fyCinv?currPage=${totalPage}">
		  <span class="left_ts">尾页</span></a></td>
		</tr>
		</c:if>
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
