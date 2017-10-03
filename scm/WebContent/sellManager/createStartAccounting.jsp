<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">

<title>My JSP 'createStartAccounting.jsp' starting page</title>

 <meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page"> 

<link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/js/jquery-ui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/myjs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>

<script type="text/javascript">
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

	$( "#dialog" ).dialog({
		autoOpen: false,
		width: 500,
		height:350,
		closeText:"",
		buttons: {
			"取消": function() { 
				$(this).dialog("close"); 
			}, 
			"确定": function() { 
		     var gve=$("#dealerOrderIds").val();
			 var gvb=$("#dealerOrderDetailsIds").val();
			 var gvc=$("#sellPrices").val();
			 var gvd=$("#vinNumbers").val();		                 
                var gvh = $('input:radio[name="ifRetrofitting"]:checked').val();
                var gvf=$("#asss").val();
			 if(gvc!=null && gvd!='0'){
			// $("#myform2").submit();
			$.post("fctz",{"dealerOrderId":gve,"dealerOrderDetailsId":gvb,
			"sellPrice":gvc,"vinNumber":gvd,"ifRetrofitting":gvh,
			"addAccessorizeNote":gvf},function(data){
			
			 $("#dialog").dialog("close"); 
			 $("#"+gvb).remove();
			},"json")
			
			/*  $(this).dialog("close"); 
			 $("#"+gvb).remove(); */
			 }else{
			 alert("请选择VIN号，填写销售价格!!");
			 }
						
				
			} 
		}
	});
	
}); 
</script>
<!-- <script type="text/javascript">
function sddd(dealerOrderId){
$("#dialog").window({
		title:"生产发车台帐",
		width:500,
		height:400,
		minimizable:false,
		modal:true,
		href:"findVins?dealerOrderId="+dealerOrderId,
		onClose:function(){
			//重新加载和显示当前页
			//$("#demp").datagrid('reload');
		  }
		});
}
</script> -->
<script type="text/javascript">
function sddd(advg){
	var radios = document.getElementsByName("ifRetrofitting");
	$("#dealerOrderDetailsIds").val(advg);
	
	var cc=12121;
	var cx=advg;
	var fgg=cx+cc;
	var yy= $("#"+fgg).val();
	var ct="无";
	
	if(yy!=ct){
		radios[0].checked= false;
		radios[1].checked= true;
	}	
	
	$("#asss").val(yy);
		 
	$('#dialog').dialog('open');
		return false;
}
			

</script>
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
			<td width="17" valign="top"
				background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">
				<img
				src="${pageContext.request.contextPath}/resources/images/left-top-right.gif"
				width="17" height="29" />
			</td>
			<td valign="top"
				background="${pageContext.request.contextPath}/resources/images/content-bg.gif">
				<table width="100%" height="31" border="0" cellpadding="0"
					cellspacing="0" class="left_topbg" id="table2">
					<tr>
						<td height="31"><div class="titlebt">采购管理</div></td>
					</tr>
				</table>
			</td>
			<td width="16" valign="top"
				background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">
				<img
				src="${pageContext.request.contextPath}/resources/images/nav-right-bg.gif"
				width="16" height="29" />
			</td>
		</tr>
		<tr>
			<td valign="middle"
				background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">&nbsp;</td>
			<td valign="top" bgcolor="#F7F8F9">
				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0" class="line_table">
					<tr>
						<td width="20"><img
							src="${pageContext.request.contextPath}/resources/images/icon-login-seaver.gif"
							width="16" height="16" /></td>
						<td>当前位置：销售管理>>发车台帐管理</td>
					</tr>
				</table>
				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0" class="line_table">
					<tbody class="tbody2">
						<tr>
							<td width="5%" align="left"><span>经销商订单号</span></td>
							<td width="12%" align="left"><span>${dealerOrder.orderNumber}</span></td>
							<td width="4%" align="left"><span>经销商店面地址</span></td>
							<td width="12%" align="left"><span>${dealerOrder.dealer.storefrontAddress}</span></td>
						</tr>
						<tr>
							<td width="5%" align="left"><span>经销商名称</span></td>
							<td width="12%" align="left"><span>${dealerOrder.dealer.principalName}</span>
							</td>
							<td width="4%" align="left"><span>下单时间</span></td>
							<td width="12%" align="left"><span> <fmt:formatDate
										value="${dealerOrder.certificateDate}" pattern="yyyy-MM-dd" /></span></td>
						</tr>
						<tr>
							<td width="4%" align="left"><span>收货地址</span></td>
							<td width="12%" align="left"><span>${dealerOrder.dealer.portAddress}</span></td>
							<td width="4%" align="left">&nbsp;</td>
							<td width="12%" align="center"><input type="button"
								class="Submit" value="返回" style="width:100px"
								onclick="javascript:history.back()" /></td>
						</tr>
					</tbody>
				</table>
				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0" class="line_table">
					<thead class="thead">
						<tr>
							<th width="6%">序号</th>
							<th width="26%">汽车车型</th>
							<th width="9%">车型颜色</th>
							<th width="47%">加装说明</th>
							<th width="12%">操作</th>
							
						</tr>
					</thead>
					<tbody class="tbody">
						
						<c:forEach items="${requestScope.details2}" var="dt"
							varStatus="st">
							<tr id="${dt.dealerOrderDetailsId}">
								<td>${st.count} </td>
								<td>${dt.brand}&nbsp${dt.typeCode}&nbsp(${dt.carCharacter})</td>
								<td>${dt.colorName} </td>
								<td>${dt.addAccessorizeNote} <input type="hidden"  id="${dt.dealerOrderDetailsId+12121}"  value="${dt.addAccessorizeNote}">
								<td>
									<c:if test="${dt.ifCreateStartAccounting==0}">
										<input  type="button" style="color:#000099" id="addVin" 
										onclick="javascript:sddd(${dt.dealerOrderDetailsId})" value="生成发车台帐"/>
									</c:if>
									<c:if test="${dt.ifCreateStartAccounting==1}">
										<span>已经生成发车台账</span>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0" class="line_table">
					<c:if test="${!empty requestScope.details2}">
					<tr>
						<td width="869">&nbsp; 			
						
						</td>
						<td width="63" align="right"><a
							href="fydods2?currPage=1&dealerOrderId=${dealerOrderId}"><span
								class="left_ts">首页</span></a></td>
						<td width="63" align="right"><a
							href="fydods2?currPage=${currPage-1}&dealerOrderId=${dealerOrderId}"><span
								class="left_ts">上一页</span></a></td>
						<td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
						<td width="66" align="left"><a
							href="fydods2?currPage=${currPage+1}&dealerOrderId=${dealerOrderId}"><span
								class="left_ts">下一页</span></a></td>
						<td width="63" align="left"><a
							href="fydods2?currPage=${totalPage}&dealerOrderId=${dealerOrderId}"><span
								class="left_ts">尾页</span></a></td>
					</tr>
					</c:if>
				</table>
			</td>
			<td
				background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">&nbsp;</td>
		</tr>
		<tr>
			<td valign="bottom"
				background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">
				<img
				src="${pageContext.request.contextPath}/resources/images/buttom_left2.gif"
				width="17" height="17" />
			</td>
			<td
				background="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif">
				<img
				src="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif"
				width="17" height="17" />
			</td>
			<td valign="bottom"
				background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">
				<img
				src="${pageContext.request.contextPath}/resources/images/buttom_right2.gif"
				width="16" height="17" />
			</td>
		</tr>
	</table>
	<div id="dialog" title="生产发车台帐">
		<form action="fctz" method="post" id="myform2">
		<table  style="text-align: center;">
			<tr>
				<td width="178"><a class="message"><strong></strong></a>
				<input type="hidden"  value="${dealerOrderId}" name="dealerOrderId" id="dealerOrderIds">
				<input type="hidden"  id="dealerOrderDetailsIds" name="dealerOrderDetailsId"  ></td>
				<td width="546">&nbsp</td>
			</tr>
			<tr>
				<td width="178"><a class="message"><strong>销售价格</strong></a></td>
				<td width="546"><input type="text" class="login_text" name="sellPrice" id="sellPrices"
				 maxlenght="8"   required="required" onkeyup="this.value=this.value.replace(/[^\d.]/g,'');"style="width:240px" /></td>
			</tr>
			<tr>
				<td width="178"><a class="message"><strong>请选择VIN号</strong></a></td>
				<td width="546"><select name="vinNumber" class="sec2" id="vinNumbers"
					style="width:250px">
						<option value="0" selected="selected">请选择</option>
						<c:forEach items="${requestScope.vins}" var="vin">
							<option value="${vin}">${vin}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td width="178"><a class="message"><strong>是否加装</strong></a></td>
				<td width="546"><input type="radio" checked="checked"   name="ifRetrofitting"  value="0"/><strong>不需要</strong>
					<input type="radio" name="ifRetrofitting"  value="1"/><strong>需要</strong></td>
			</tr>
			<tr>
				<td width="178"><a class="message"><strong>加装说明</strong></a></td>
				<td width="546"><input name="addAccessorizeNote" type="text" id="asss"
				maxlenght="60" 	class="login_text" style="width:240px" /></td>
			</tr>
			<!-- <tr><td>&nbsp</td><td><input type="reset"  value="重置" ></td></tr> -->
		</table>
		</form>
	</div>
</body>
</html>
