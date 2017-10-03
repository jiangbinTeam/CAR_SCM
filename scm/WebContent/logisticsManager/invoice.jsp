<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'invoice.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link
	href="${pageContext.request.contextPath}/resources/images/skin.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/js/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/myjs.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
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


$(function(){	
				$('#dialogReceive').dialog({
					autoOpen: false,
					width: 500,
					height:200,
					buttons: {
						"取消": function() { 
							$(this).dialog("close"); 
						}, 
						"确定": function() { 
						if($("#namety").val()!=null,$("#namety").val()!=''){
						$("#myformty").submit();
						$(this).dialog("close"); 
						}else{
						alert("请选择接车日期！！！");
						return false;
						}
						} 
					}
				});
			/* 				$("a[name='receive']").click(function(){
					 
					$('#dialogReceive').dialog('open');
					return false;
				}); */
				}); 
				
				$(function(){	
				$('#dialog').dialog({
					autoOpen: false,
					width: 500,
					height:200,
					buttons: {
						"取消": function() { 
							$(this).dialog("close"); 
						}, 
						"确定": function() { 
						if($("#nametx").val()!=null && $("#nametx").val()!=''){
						$("#myformtx").submit();
						$(this).dialog("close"); 
						}else{
						alert("请选择发车日期！！！");
						return false;
						}
							
						} 
					}
				});
				/* 			$("a[name='invoice']").click(function(){
					 
					$('#dialog').dialog('open');
					return false;
				}); */
				}); 
</script> 
<script type="text/javascript">
function addx(ts){
$("#invoiceId1").val(ts);
var fg1=$("#dealerid1").val();
var fg2=$("#fczt1").val();
$("#dealerid2").val(fg1);
$("#fczt2").val(fg2);
$('#dialog').dialog('open');
}

function addy(ts,st){
$("#invoiceId2").val(ts);
$("#carriageCharge1").val(st);
var fg1=$("#dealerid1").val();
var fg2=$("#fczt1").val();
$("#dealerid3").val(fg1);
$("#fczt3").val(fg2);
$('#dialogReceive').dialog('open');
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
		当前位置：物流管理>>发货单管理</td>

	</tr>
	</table>
	<form action="InvoiceTwo" method="post">
	<table width="98%" border="0" align="center"  style="text-align: center;" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		<td width="10%" align="center" height="30"><span class="left_bt2">请选择经销商</span></td>
		<td width="19%"><select name="dealerId" id="dealerid1" class="sec2" style="width:200px">
		  <option value="-1" >请选择</option>
		  <c:forEach items="${sessionScope.dealers}" var="inv" varStatus="st">
          <option value="${inv.dealerId }" ${inv.dealerId ==dealerId ? 'selected':''}>
                       ${inv.dealerName}(${inv.principalName})</option>
         </c:forEach>
        </select></td>
		<td width="8%" align="left"><span class="left_bt2">发车状态</span></td>
		<td width="20%"><select name="fczt" id="fczt1" class="sec2" style="width:100px">
          <option value="0">请选择</option>
          <option value="1" ${fczt ==1  ? 'selected':''}>未发车</option>
          <option value="2" ${fczt ==2  ? 'selected':''}>已发车</option>
		  <option value="3" ${fczt ==3  ? 'selected':''}>已接车</option>
        </select></td>
		<td width="43%" height="30" align="center">
		<input name="button" type="submit" class="Submit" style="width:100px" value="查询" />
		<input id="button" type="button" class="Submit" style="width:100px" value="创建发车单" onclick="javascript:window.location.href='createInvoice1'"/>		 </td>
	</tr>
	</table>
	</form>
	<table width="98%" border="0" align="center" style="text-align: center;" cellspacing="0" class="line_table">
		<thead class="thead">
    	<tr>
		<th width="3%">序号</th>
		<th width="11%">发车单号</th>
		<th width="12%">物流公司名称</th>
		<th width="19%">收货经销商名称</th>	
		<th width="11%">运输费用（单位:万）</th>	
		<th width="15%">发车日期</th>
		<th width="16%">接车日期</th>
		<th width="13%">操作</th>
		</tr>
		</thead>
		<tbody class="tbody">
		<c:forEach items="${invoice2s}" var="ins" varStatus="vt" >
		 <tr>
		<td>${vt.index+1}</td>
		<td>${ins.invoiceNumber}</td>
		<td>${ins.logisticsName}</td>
		<td>${ins.dealerName}(${ins.principalName})</td>
		<td>${ins.carriageCharge}</td>	
		<td><fmt:formatDate value="${ins.startDate}" pattern="yyyy-MM-dd" /></td>
		<td><fmt:formatDate value="${ins.accessCarDate}" pattern="yyyy-MM-dd" /></td>
		<td>
		<c:if test="${empty ins.startDate && empty ins.accessCarDate}">
		<a href="inUpdInv?invoiceId=${ins.invoiceId}" style="color:#000099">修改</a>
		<a href="findStaInv?invoiceId=${ ins.invoiceId}" style="color:#000099">查看</a>		
		<a  style="color:#000099" name="invoice" onclick="javascript:addx(${ins.invoiceId})">确认发车</a>	
		</c:if>
		
		<c:if test="${!empty ins.startDate && empty ins.accessCarDate}">
		<a href="findStaInv?invoiceId=${ ins.invoiceId}" style="color:#000099">查看</a>		
		<a style="color:#000099" name="receive" onclick="javascript:addy('${ins.invoiceId}','${ins.carriageCharge}')">确认接车</a>
		</c:if>
		
		<c:if test="${!empty ins.startDate && !empty ins.accessCarDate}">
		<a href="findStaInv?invoiceId=${ ins.invoiceId}" style="color:#000099">查看</a>		
		</c:if>
		</td>
		</tr>
		</c:forEach>
	

		</tbody>						
    </table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
	<c:if test="${!empty invoice2s}">
    	<tr>
		<td width="869">&nbsp;</td>
		  <td width="63" align="right"><a href="fyInvoice?currPage=1&dealerId=${dealerId}&fczt=${fczt}">
		  <span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="fyInvoice?currPage=${currPage-1}&dealerId=${dealerId}&fczt=${fczt}">
		  <span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left"><a href="fyInvoice?currPage=${currPage+1}&dealerId=${dealerId}&fczt=${fczt}">
		  <span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="fyInvoice?currPage=${totalPage}&dealerId=${dealerId}&fczt=${fczt}">
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
<div id="dialog" title="确认发车">
		<form action="addStartDate" method="post" id="myformtx">
		<table>
		    <tr>
				<td width="178"><a class="message"><strong>确认发车日期</strong></a></td>
				<td width="335"><a class="message">
				  <input name="startDate" id="nametx" type="text" style="width:200px"  class="Wdate" onclick="WdatePicker()"/>
				</a>
				<input type="hidden" name="dealerId" id="dealerid2">
				<input type="hidden" name="fczt" id="fczt2">
				<input type="hidden" name="invoiceId" id="invoiceId1">
				<input type="hidden" name="currPage" value="${currPage}">
				</td>
		  </tr>
		</table>
		</form>
</div>
<div id="dialogReceive" title="确认接车">
<form action="addAccessCarDate" method="post" id="myformty">
		<table>
		    <tr>
				<td width="178"><a class="message"><strong>确认接车日期</strong></a></td>
				<td width="335"><a class="message">
				  <input name="accessCarDate" id="namety" type="text" style="width:200px"  class="Wdate" onclick="WdatePicker()"/>
				</a>
				<input type="hidden" name="dealerId" id="dealerid3">
				<input type="hidden" name="fczt" id="fczt3">
				<input type="hidden" name="invoiceId" id="invoiceId2">
				<input type="hidden" name="currPage" value="${currPage}">
				<input type="hidden" name="carriageCharge" id="carriageCharge1">
				</td>
		  </tr>
		</table>
		</form>
</div>

</body>
  </body>
</html>
