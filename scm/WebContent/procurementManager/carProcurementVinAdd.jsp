<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script type="text/javascript" language="JavaScript">
$(function(){

	$('input[name=mydate]').makeDate();
	
});


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
    <td width="17" valign="top" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">
    	<img src="${pageContext.request.contextPath}/resources/images/left-top-right.gif" width="17" height="29" />
    </td>
    <td valign="top" background="${pageContext.request.contextPath}/resources/images/content-bg.gif">
	    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
	      <tr>
	        <td height="31"><div class="titlebt">采购管理</div></td>
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
			<td>当前位置：采购管理>>车辆采购单管理>>添加VIN号</td>
			</tr>
		</table>
		<form action="/scm/uploadVins" method="post" enctype="multipart/form-data">
        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
             <tbody class="tbody2">
               <tr>
                 <td width="5%" align="left"><span>采购单号</span></td>
                 <td width="12%" align="left"><span >
                 	<input type="hidden" name="carProcurementListId" value="${carProcurementList.carProcurementListId}">
                 	${carProcurementList.carProcurementListId}
                 </span></td>
                 <td width="4%" align="left"><span>采购数量</span></td>
                 <td width="12%" align="left"><span>
	                 <input type="hidden" name="carProcurementListCount" value=" ${carProcurementList.carProcurementListCount}">
	                 ${carProcurementList.carProcurementListCount}
                 </span></td>
               </tr>
               <tr>
                 <td width="5%" align="left"><span>采购单价</span></td>
                 <td width="12%" align="left"><span>
	                 ${carProcurementList.procurementPrice}(万/辆)
	                  <input type="hidden" name="procurementPrice" value="${carProcurementList.procurementPrice}">
                 </span> </td>
                 <td width="4%" align="left"><span>创建时间</span></td>
                 <td width="12%" align="left"><span>
                 	<fmt:formatDate value="${carProcurementList.carProcurementListDate}" pattern="yyyy-MM-dd"/> </span>
				 </span></td>
               </tr>
               <tr>
                 <td width="4%" align="left"><span>采购车型</span></td>
                 <td width="12%" align="left"><span>
                 	<c:forEach items="${typeDictionaries}" var="type">
						<c:if test="${type.typeCode==carProcurementList.typeCode}">
							<input type="hidden" name="typeCode" value="${type.typeCode}">
							${type.brand}${type.typeCode}(${type.carCharacter})							
						</c:if>
					</c:forEach>
                 </span></td>
                 <td width="5%" align="left"><span>预计打款日期</span></td>
                 <td width="12%" align="left"><span>
                 	<fmt:formatDate value="${carProcurementList.expectedPaymentDate}" pattern="yyyy-MM-dd"/>
				 </span></td>
               </tr>
               <tr>
                 <td width="5%" align="left"><span>外饰颜色</span></td>
                 <td width="12%" align="left"><span>
                 	<c:forEach items="${colorChanges}" var="color">
						<c:if test="${color.colorCode==carProcurementList.colorCode}">
							<input type="hidden" name="colorCode" value="${color.colorCode}">
							${color.colorName}								
						</c:if>
					</c:forEach>
				 </span></td>
                 <td width="4%" align="left"><span>采购总额</span></td>
                 <td width="12%" align="left"><span>${carProcurementList.carProcurementAmount}万</span></td>
               </tr>
               <tr>
                 <td width="5%" align="left"><span>导入VIN号</span></td>
                 <td width="12%" align="left">
                 	 <input type="file" name="vinFile" id="vinFile" required="required"  class="file_2000" />
                     <input  type="submit" class="Submit" onclick="return checkData()" style="width:100px" value="导入"/> 
                 </td>
               </tr>
             </tbody>
           </table>
		   </form>
	        <table width="98%" border="0" style="text-align: center;" align="center" cellpadding="0" cellspacing="0" class="line_table">
              <thead class="thead">
                <tr>
                  <th width="5%">序号</th>
                  <th width="9%">vin号</th>
                  <th width="16%">车辆简码</th>
                  <th width="11%">发动机号</th>
                  <th width="11%">外饰颜色</th>
                  <th width="9%">未导入成功原因</th>
                </tr>
              </thead>
              <tbody class="tbody">
              	<c:forEach items="${errors}" var="error" varStatus="i">
	                <tr>
	                  <td>${i.index+1 }</td>
	                  <td>${error.vinNumber}</td>
	                  <td>${error.vinLast}</td>
	                  <td>${error.engineCode}</td>
	                  <td>
	                  	<c:forEach items="${colorChanges}" var="color">
							<c:if test="${color.colorCode==error.colorCode}">
								${color.colorName}								
							</c:if>
						</c:forEach>
	                  </td>
	                  <td>${error.addAccessorizeNote}</td>
	                </tr>
               </c:forEach>
              </tbody>
            </table></td>
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