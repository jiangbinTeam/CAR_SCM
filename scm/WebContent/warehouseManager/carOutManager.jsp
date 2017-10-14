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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>

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

 function confirmDel(paramcc,vinNumber)  {  
		
         if(confirm("您确定要出库吗？")){  
   window.location.href="findBychukuku?storageAreasId="+paramcc+"&vinNumber="+vinNumber;
	}  
}    

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
	<form action="findBychuku" method="post">
	   <input type="hidden" name="currPage" value="1">
	     <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		<td width="5%" align="center" height="30"><span class="left_bt2">仓库名</span></td>
		<td width="20%"> 
		
		                  
		    <c:if test="${warehouseId==''}">
		  <select name="warehouseId"   class="sec2" style="width:200px">
           <option  value="0" selected="selected">请选择</option>
	           <c:forEach var="wc" items="${win}" > 
              <option value="${wc.warehouseId}">${wc.warehouseName}</option>
	             </c:forEach>    
         </select>   
         </c:if>
           
         <c:if test="${warehouseId!=''}">
				<select name="warehouseId" class="sec2" style="width:250px">
				<c:forEach items="${win}" var="wc">
					 <c:if test="${warehouseId==wc.warehouseId}"> 
						 <option value="${wc.warehouseId}" >${wc.warehouseName}</option>	 
					</c:if> 
				</c:forEach>	  
				
			<option value="0">请选择</option>	
		      <c:forEach items="${win}" var="wc">
			  <c:if test="${warehouseId!=wc.warehouseId}"> 
					<option value="${wc.warehouseId}">${wc.warehouseName}</option>	 
			  </c:if> 
	          </c:forEach>
				  
			  </select>
			</c:if>
            </td>
            
		  <td width="7%" align="left"><span class="left_bt2">请选择车型</span></td>
		  <td width="26%" align="left">
		  
		    <c:if test="${typeCode=='0'}">
		  <select name="typeCode"   class="sec2" style="width:200px">
                <option  value="0" selected="selected">请选择</option>
	           <c:forEach var="wa" items="${toye}" > 
              <option value="${wa.typeCode}">${wa.brand}${wa.carCharacter}</option>
	             </c:forEach>    
         </select>   
         </c:if>
         
         <c:if test="${typeCode!='0'}">
				<select name="typeCode" class="sec2" style="width:250px">
				<c:forEach items="${toye}" var="wa">
					 <c:if test="${typeCode==wa.typeCode}"> 
						 <option value="${wa.typeCode}" >${wa.brand}${wa.carCharacter}</option>	 
					</c:if> 
				</c:forEach>	  
				
			<option value="0">请选择</option>
		      <c:forEach items="${toye}" var="wa">
			  <c:if test="${typeCode!=wa.typeCode}"> 
					<option value="${wa.typeCode}">${wa.brand}${wa.carCharacter}</option>	 
			  </c:if> 
	          </c:forEach>
				  
			  </select>
			</c:if>
          </td>
		  <td width="4%" align="left"><span class="left_bt2">VIN号</span></td>
		  
		<td width="27%">
			<input name="vinNumber"  type="text"  class="text_2000" style="width:300px" value=""/>
		</td>
		  <td width="11%"><input name="button" type="submit" class="Submit" style="width:100px" value="查看"/></td>
	</tr>
	</table>
	</form>
	<table width="98%" border="0" style="text-align: center;" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<thead class="thead">
    	<tr>
		<th width="10%">序号</th>
		<th width="18%">仓库名称</th>
		<th width="20%">库位名称</th>
		<th width="26%">在库车辆</th>	
		<th width="26%">操作</th>
		</tr>
		</thead>
		<tbody class="tbody">
		 <c:if test="${empty requestScope.wars}">
		 	<tr><td colspan="5" style="color: red;">没有符合条件的数据！</td></tr>
		 </c:if>
		 <c:if test="${!empty requestScope.wars}">
		 	<c:forEach var="co" items="${requestScope.wars}" varStatus="i">
			 <tr>
			<td>${i.index+1}</td>
			<td>${co.warehouseName}</td>
			<td>${co.storageAreasName}</td>
			<td>${co.vinNumber}</td>
			<td>
			<%-- confirmDel(${co.storageAreasId},${co.vinNumber}) --%>
			<a href="JavaScript:;" style="color:#000099" onclick="confirmDel(${co.storageAreasId},'${co.vinNumber}')"/>出库</a>
			</td> 
        	 </tr>
         </c:forEach>   
        
   
		 </c:if>
		
	 </tbody>						
    </table>
		<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
			<td width="869">&nbsp;</td>
		  <td width="63" align="right">
		           
		  <a href="findBychuku?currPage=1&warehouseId=${warehouseId}&typeCode=${typeCode}&vinNumber=${vinNumber}"><span class="left_ts">首页</span></a></td>
		  <td width="63" align="right">
		  <a href="findBychuku?currPage=${currPage-1}&warehouseId=${warehouseId}&typeCode=${typeCode}&vinNumber=${vinNumber}&dealerID=${dealerID}"><span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"
		  ><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left">
		  <a href="findBychuku?currPage=${currPage+1}&warehouseId=${warehouseId}&typeCode=${typeCode}&vinNumber=${vinNumber}"><span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left">
		  <a href="findBychuku?currPage=${totalPage}&warehouseId=${warehouseId}&typeCode=${typeCode}&vinNumber=${vinNumber}"><span class="left_ts">尾页</span></a></td>
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