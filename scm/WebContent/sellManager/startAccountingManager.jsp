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
				$('#dialog').dialog({
					autoOpen: false,
					closeOnEscape:false,
					open:function(event,ui){$(".ui-dialog-titlebar-close").hide();} ,
					width: 500,
					height:350,
					buttons: {
						"取消": function() { 
						$("#vinNumbers").empty();
							$(this).dialog("close"); 
							var $ts=$("<option value='0' selected='selected'>请选择</option>");
							$("#vinNumbers").append($ts);
						}, 
						"确定": function() { 
						
						 if($("#sellPrices").val()==null){
						   alert("请填写销售价格!!!");
						   return false;
						   }
						   if(isNaN($("#sellPrices").val())){
						   alert("非数字类型!!!");
						   return false;
						     }
						 if($("#vinNumber").val()==0){
						 alert("请选择VIN号!!!");
						 return false;
						 }
						$("#xgtz").submit();
						
							$(this).dialog("close"); 
						} 
					}
				});
					/* 		$("a[name='addVin']").click(function(){
					 
					$('#dialog').dialog('open');
					return false;
				}); */
				});
</script> 
<script type="text/javascript">
function sddd(tt1,tt2,tt3,tt4,tt5){
$("#skt2").val(tt3);
$("#skt3").val(tt2);
var radios = document.getElementsByName("ifRetrofitting");
if(tt4!='无'){
radios[0].checked= false;
radios[1].checked= true;
}
$("#sellPrices").val(tt5);
$("#asss").val(tt4);

$.post("findVinct",{"typeCode":tt1},function(data){
$.each(data,function(i,val){
var ta="<option value='"+val+"'>"+val+"</option>";
$("#vinNumbers").append(ta);
});
alert($("#vinNumbers").find("option").length);
},"json");


$('#dialog').dialog('open');
	return false;
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
-->
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
		<img src="${pageContext.request.contextPath}/resources/images/icon-login-seaver.gif" width="16" height="16" />		</td>
		<td>
		当前位置：销售管理>>发车台帐管理</td>
	</tr>
	</table>
	<form action="startTwo" method="post">
	        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
              <tbody class="tbody2">
                <tr>
                  <td width="8%" align="left"><span >经销商订单号</span></td>
                  <c:if test="${empty dealerOrderId}">
                  <td width="17%" align="left"><input name="dealerOrderId" type="text" 
                   maxlenght="8"  class="login_text" style="width:160px " /></td>
                  </c:if>
                  <c:if test="${!empty dealerOrderId}">
                  <td width="17%" align="left"><input name="dealerOrderId" type="text" 
                  value="${ dealerOrderId}" maxlenght="8" 
                   class="login_text" style="width:160px" /></td>
                  </c:if>
                  <c:if test="${empty vinNumber}">
                  <td width="6%" align="left"><span>汽车Vin号</span></td>
                  <td width="15%" align="left"><input name="vinNumber" type="text" 
                   maxlenght="18"  class="login_text"  style="width:160px"/></td>
				  </c:if>
				   <c:if test="${!empty vinNumber}">
                  <td width="6%" align="left"><span>汽车Vin号</span></td>
                  <td width="15%" align="left"><input name="vinNumber" type="text" 
                  maxlenght="8"   value="${ vinNumber}" class="login_text"  style="width:160px"/></td>
				  </c:if>
	      <c:if test="${empty startAccountingStates }">
		  <td width="6%" align="left"><span>发车状态</span></td>
          <td width="22%" align="left"><select name="startAccountingStates" class="sec2" >
		  <option value="22" selected="selected">请选择</option>
          <option value="0">未发车</option>
          <option value="1">汽车出库</option>
          <option value="2">已发车</option>
          <option value="3">已接车</option>
		  <option value="4">信息有误</option>
          </select></td>
          </c:if>
         
          <c:if test="${!empty startAccountingStates }">
	      <td width="6%" align="left"><span>发车状态</span></td>
          <td width="22%" align="left"><select name="startAccountingStates" class="sec2" >
		  <option value="22">请选择</option>
          <option value="0" ${startAccountingStates ==0 ? 'selected':'' }>未发车</option>
          <option value="1" ${startAccountingStates ==1 ? 'selected':'' }>汽车出库</option>
          <option value="2" ${startAccountingStates ==2 ? 'selected':'' }>已发车</option>
          <option value="3" ${startAccountingStates ==3 ? 'selected':'' }>已接车</option>
		  <option value="4" ${startAccountingStates ==4 ? 'selected':'' }>信息有误</option>
          </select></td>
          </c:if>
         
		<td width="26%" align="left"><input type="submit" class="Submit" value="查看" style="width:100px"/></td>
                </tr>
              </tbody>
            </table>
          </form>  
	        <table width="98%" border="0" style="text-align: center;" align="center" cellpadding="0" cellspacing="0" class="line_table">
              <thead class="thead">
                <tr>
                  <th width="6%">序号</th>
                  <th width="26%">汽车车型</th>
                  <th width="9%">车型颜色</th>
                  <th width="47%">加装说明</th>
				  <th width="12%">发车状态</th>
                </tr>
              </thead>
              <tbody class="tbody">
              <c:if test="${empty stas2}">
              	<tr><td colspan="5" style="font-size: 16px;color: red;">没有符合条件的数据</td></tr>
              </c:if>
              <c:if test="${!empty stas2}">
              <c:forEach items="${stas2}" var="sta" varStatus="ct">
              <tr>
              <td>${ct.count}</td>
              <td>${sta.brand}&nbsp${sta.typeCode }(${sta.carCharacter})</td>
              <td>${sta.colorName}</td>
              <td>${sta.addAccessorizeNote}</td>
			  <td><c:choose>
			  <c:when test="${sta.startAccountingStates ==0 }">未发车</c:when>
			  <c:when test="${sta.startAccountingStates ==1 }">汽车出库</c:when>
			  <c:when test="${sta.startAccountingStates ==2 }">已发车</c:when>
			  <c:when test="${sta.startAccountingStates ==3 }">已接车</c:when>
			  <c:when test="${sta.startAccountingStates ==4 }">
			  <a name="addVin"  onclick="javascript:sddd('${sta.typeCode}','${sta.startAccountingId}','${sta.vinNumber}','${sta.addAccessorizeNote}','${sta.sellPrice}')" 
			  style="color:#000099">修改发车台帐</a>
			  </c:when>
			  </c:choose></td>
              </tr>
              </c:forEach>
              </c:if>    
              </tbody>
            </table>
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
	 <c:if test="${!empty stas2 }"> 
    	<c:if test="${!empty dealerOrderId && !empty vinNumber && !empty startAccountingStates}">
    	<tr>
		<td width="869">&nbsp;</td>
		  <td width="63" align="right"><a href="fyStart?currPage=1&dealerOrderId=${dealerOrderId}&vinNumber=${vinNumber}&startAccountingStates=${startAccountingStates}">
		  <span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="fyStart?currPage=${currPage-1}&dealerOrderId=${dealerOrderId}&vinNumber=${vinNumber}&startAccountingStates=${startAccountingStates}">
		  <span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left"><a href="fyStart?currPage=${currPage+1}&dealerOrderId=${dealerOrderId}&vinNumber=${vinNumber}&startAccountingStates=${startAccountingStates}">
		  <span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="fyStart?currPage=${totalPage}&dealerOrderId=${dealerOrderId}&vinNumber=${vinNumber}&startAccountingStates=${startAccountingStates}">
		  <span class="left_ts">尾页</span></a></td>
		</tr>
		</c:if>
		
		<c:if test="${empty dealerOrderId && !empty vinNumber && !empty startAccountingStates}">
    	<tr>
		<td width="869">&nbsp;</td>
		  <td width="63" align="right"><a href="fyStart?currPage=1&dealerOrderId=0&vinNumber=${vinNumber}&startAccountingStates=${startAccountingStates}">
		  <span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="fyStart?currPage=${currPage-1}&dealerOrderId=0&vinNumber=${vinNumber}&startAccountingStates=${startAccountingStates}">
		  <span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left"><a href="fyStart?currPage=${currPage+1}&dealerOrderId=0&vinNumber=${vinNumber}&startAccountingStates=${startAccountingStates}">
		  <span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="fyStart?currPage=${totalPage}&dealerOrderId=0&vinNumber=${vinNumber}&startAccountingStates=${startAccountingStates}">
		  <span class="left_ts">尾页</span></a></td>
		</tr>
		</c:if>
		
	<c:if test="${!empty dealerOrderId && empty vinNumber && !empty startAccountingStates}">
    	<tr>
		<td width="869">&nbsp;</td>
		  <td width="63" align="right"><a href="fyStart?currPage=1&dealerOrderId=${dealerOrderId}&vinNumber=sbs&startAccountingStates=${startAccountingStates}">
		  <span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="fyStart?currPage=${currPage-1}&dealerOrderId=${dealerOrderId}&vinNumber=sbs&startAccountingStates=${startAccountingStates}">
		  <span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left"><a href="fyStart?currPage=${currPage+1}&dealerOrderId=${dealerOrderId}&vinNumber=sbs&startAccountingStates=${startAccountingStates}">
		  <span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="fyStart?currPage=${totalPage}&dealerOrderId=${dealerOrderId}&vinNumber=sbs&startAccountingStates=${startAccountingStates}">
		  <span class="left_ts">尾页</span></a></td>
		</tr>
		</c:if>	
		
		<c:if test="${!empty dealerOrderId && !empty vinNumber && empty startAccountingStates}">
    	<tr>
		<td width="869">&nbsp;</td>
		  <td width="63" align="right"><a href="fyStart?currPage=1&dealerOrderId=${dealerOrderId}&vinNumber=${vinNumber}&startAccountingStates=22">
		  <span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="fyStart?currPage=${currPage-1}&dealerOrderId=${dealerOrderId}&vinNumber=${vinNumber}&startAccountingStates=22">
		  <span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left"><a href="fyStart?currPage=${currPage+1}&dealerOrderId=${dealerOrderId}&vinNumber=${vinNumber}&startAccountingStates=22">
		  <span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="fyStart?currPage=${totalPage}&dealerOrderId=${dealerOrderId}&vinNumber=${vinNumber}&startAccountingStates=22">
		  <span class="left_ts">尾页</span></a></td>
		</tr>
		</c:if>	
		
		<c:if test="${empty dealerOrderId && empty vinNumber && empty startAccountingStates}">
    	<tr>
		<td width="869">&nbsp;</td>
		  <td width="63" align="right"><a href="fyStart?currPage=1&dealerOrderId=0&vinNumber=sbs&startAccountingStates=22">
		  <span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="fyStart?currPage=${currPage-1}&dealerOrderId=0&vinNumber=sbs&startAccountingStates=22">
		  <span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left"><a href="fyStart?currPage=${currPage+1}&dealerOrderId=0&vinNumber=sbs&startAccountingStates=22">
		  <span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="fyStart?currPage=${totalPage}&dealerOrderId=0&vinNumber=sbs&startAccountingStates=22">
		  <span class="left_ts">尾页</span></a></td>
		</tr>
		</c:if>	
		<c:if test="${!empty dealerOrderId && empty vinNumber && empty startAccountingStates}">
    	<tr>
		<td width="869">&nbsp;</td>
		  <td width="63" align="right"><a href="fyStart?currPage=1&dealerOrderId=${dealerOrderId}&vinNumber=sbs&startAccountingStates=22">
		  <span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="fyStart?currPage=${currPage-1}&dealerOrderId=${dealerOrderId}&vinNumber=sbs&startAccountingStates=22">
		  <span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left"><a href="fyStart?currPage=${currPage+1}&dealerOrderId=${dealerOrderId}&vinNumber=sbs&startAccountingStates=22">
		  <span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="fyStart?currPage=${totalPage}&dealerOrderId=${dealerOrderId}&vinNumber=sbs&startAccountingStates=22">
		  <span class="left_ts">尾页</span></a></td>
		</tr>
		</c:if>	
			<c:if test="${empty dealerOrderId && !empty vinNumber && empty startAccountingStates}">
    	<tr>
		<td width="869">&nbsp;</td>
		  <td width="63" align="right"><a href="fyStart?currPage=1&dealerOrderId=0&vinNumber=${vinNumber}&startAccountingStates=22">
		  <span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="fyStart?currPage=${currPage-1}&dealerOrderId=0&vinNumber=${vinNumber}&startAccountingStates=22">
		  <span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left"><a href="fyStart?currPage=${currPage+1}&dealerOrderId=0&vinNumber=${vinNumber}&startAccountingStates=22">
		  <span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="fyStart?currPage=${totalPage}&dealerOrderId=0&vinNumber=${vinNumber}&startAccountingStates=22">
		  <span class="left_ts">尾页</span></a></td>
		</tr>
		</c:if>	
	
		<c:if test="${empty dealerOrderId && empty vinNumber && !empty startAccountingStates}">
    	<tr>
		<td width="869">&nbsp;</td>
		  <td width="63" align="right"><a href="fyStart?currPage=1&dealerOrderId=0&vinNumber=sbs&startAccountingStates=${startAccountingStates}">
		  <span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="fyStart?currPage=${currPage-1}&dealerOrderId=0&vinNumber=sbs&startAccountingStates=${startAccountingStates}">
		  <span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left"><a href="fyStart?currPage=${currPage+1}&dealerOrderId=0&vinNumber=sbs&startAccountingStates=${startAccountingStates}">
		  <span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="fyStart?currPage=${totalPage}&dealerOrderId=0&vinNumber=sbs&startAccountingStates=${startAccountingStates}">
		  <span class="left_ts">尾页</span></a></td>
		</tr>
		</c:if>	
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
<div id="dialog" title="修改发车台账">
		<form action="xgtz" method="post" id="xgtz">
		<table>
		
			<tr>
				<td width="178"><a class="message"><strong>销售价格</strong></a></td>
				<td width="546"><input type="text" name="sellPrice" id="sellPrices"
				class="login_text" maxlenght="8" onkeyup="this.value=this.value.replace(/[^\d].1/g,'');" style="width:240px"/></td>
			</tr>
			<tr>
				<td width="178"><a class="message"><strong>请选择VIN号</strong></a></td>
				<td width="546"><select name="vinNumber" id="vinNumbers" class="sec2" style="width:250px">
		  <option value="0" selected="selected">请选择</option>
  
        </select></td>
			</tr>
						<tr>
				<td width="178"><a class="message"><strong>是否加装</strong></a></td>
				<td width="546"><input type="radio" value="0" checked="checked" name="ifRetrofitting"/>
				<strong>不需要</strong> <input type="radio" value="1" name="ifRetrofitting"/><strong>需要</strong>
        </select></td>
			</tr>
		<tr>
				<td width="178"><a class="message"><strong>加装说明</strong></a></td>
				<td width="546"><input name="addAccessorizeNote" type="text" 
				id="asss" maxlenght="60"  class="login_text" style="width:240px"/>
				<!-- <input type="hidden" id="skt1" name="typeCode"> -->
				<input type="hidden" id="skt2" name="vinNumberg">
				<input type="hidden" id="skt3" name="startAccountingId">
				</td>
			</tr>
		</table>
		</form>
</div>
</body>
</html>
