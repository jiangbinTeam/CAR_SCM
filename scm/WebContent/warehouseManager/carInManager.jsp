<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>  
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/js/jquery-ui.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/myjs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
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
}); 



$(function(){	
				$('#dialog').dialog({
					autoOpen: false,
					width: 500,
					height:200,
					closeText:"",
					buttons: {
						"取消": function() { 
							
							$(this).dialog("close"); 
						}, 
						"确定": function() { 
							$("#form2").submit();
							$(this).dialog("close");
							 
						} 
					}
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
        <td height="31"><div class="titlebt">仓库管理</div></td>
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
		当前位置：仓库管理>>车辆出库管理</td>

	</tr>
	</table>
	<form action="CarInManagerByPage" method="post"> 
	<input type="hidden" name="currPage" value="1">
	        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		<td width="16%" align="center" height="30"><span class="left_bt2">仓库名</span></td>
		<td width="21%">
		
				<c:if test="${warehouseId==''}">
		  <select name="warehouseId"   class="sec2" style="width:200px">
                <option  value="0" selected="selected">请选择</option>
	           <c:forEach var="war" items="${warName}" >
              <option value="${war.warehouseId}">${war.warehouseName}</option>
	             </c:forEach>    
         </select>   
         </c:if>
         
         <c:if test="${warehouseId!=''}">
				<select name="warehouseId" class="sec2" style="width:250px">
				<!-- 回显选择项 -->
				<c:forEach items="${warName}" var="war">
					 <c:if test="${warehouseId==war.warehouseId}"> 
						 <option value="${war.warehouseId}" >${war.warehouseName}</option>	 
					</c:if> 
				</c:forEach>	 
				
		      <c:forEach items="${warName}" var="war">
			  <c:if test="${warehouseId!=war.warehouseId}"> 
					<option value="${war.warehouseId}">${war.warehouseName}</option>	 
			  </c:if>  
	          </c:forEach>
				  
			  </select>
			</c:if>
        
        </td>
		  <td width="63%"><input name="button" type="submit" class="Submit" style="width:100px" value="查看"/></td>
	</tr>
	</table>
	</form>
	<table width="98%" border="0" style="text-align: center;" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<thead class="thead">
    	<tr>
		<th width="10%">序号</th>
		<th width="18%">仓库名称</th>
		<th width="20%">库位名称</th>
		<th width="26%">操作</th>
		</tr>
		</thead>
		<tbody class="tbody">
		<c:if test="${!empty requestScope.wars}">
		<c:forEach var="cog" items="${requestScope.wars}" varStatus="i">
		 <tr>
		<td>${i.index+1}</td> 
		<td>${cog.warehouseName}</td>
		<td>${cog.storageAreasName}</td> 	 
		<td>     
		<a href="javascript:;"  style="color:#000099" name="storage" 
		 onclick="confirmDel('${cog.storageAreasId}')"/>入库</a></td>
		</tr>
		</c:forEach>
		</c:if>
		</tbody>						
    </table>
                   <script type="text/javascript" language="JavaScript">
 	         function confirmDel(i){
    		
    		$('#dialog').dialog('open');
    		document.getElementById("storageAreasId").value=i;
    	}
           </script> 
      
    
		<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
			<td width="869">&nbsp;</td>
	       <td width="63" align="right"><a href="CarInManagerByPage?currPage=1&warehouseId=${warehouseId}"><span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="CarInManagerByPage?currPage=${currPage-1}&warehouseId=${warehouseId}"><span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left"><a href="CarInManagerByPage?currPage=${currPage+1}&warehouseId=${warehouseId}"><span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="CarInManagerByPage?currPage=${totalPage}&warehouseId=${warehouseId}"><span class="left_ts">尾页</span></a></td>
		</tr>
	</table>
	</td>
    <td background="../images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif"><img src="${pageContext.request.contextPath}/resources/images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif"><img src="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif"><img src="${pageContext.request.contextPath}/resources/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
<div id="dialog" title="车辆入库">
       <form id="form2" action="CarInManagerfindmodifa" method="post">    
        <input name="storageAreasId" id="storageAreasId" type="hidden"  value=""/> 
	     <table> 
		    <tr>
				<td width="178"><a class="message"><strong>VIN号</strong></a></td>
				<td width="546">
				<input name="vinNumber" type="text"  required="required" style="width:200px"  class="text_2000" /></td>
			</tr>
		</table>
		</form>
</div>


</body>
</html>