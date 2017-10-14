<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
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
    	<img src="${pageContext.request.contextPath}/resources/images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="${pageContext.request.contextPath}/resources/images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">财务管理</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif"><img src="../images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td valign="middle" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		<td width="20">
		<img src="${pageContext.request.contextPath}/resources/images/icon-login-seaver.gif" width="16" height="16" />		</td>
		<td>当前位置：财务管理>>经销商付车款>>添加付款记录</td>
	</tr>
	</table>
	<form method="post" enctype="multipart/form-data" id="form1" action="/scm/uploadExcel">
	     <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
            <tbody class="tbody2">
              <tr>
                <td width="9%" align="left"><span>经销商付款</span></td>
                <td width="91%" align="left">
                  	<input type="file" name="upfile" id="upfile" required="required" class="file_2000" />
                    <input name="button" type="submit" onclick="return checkData()" class="Submit" style="width:100px" value="导入"/>             
				    <input name="button" type="button" class="Submit" style="width:100px" value="返回" onclick="javascript:history.back()"/>
			    </td>
               </tr>
              </tbody>
            </table>
	</form>	
            <table width="98%" border="0" align="center" style="text-align: center;" cellpadding="0" cellspacing="0" class="line_table">
              <thead class="thead">
                <tr>
                  <th width="5%">序号</th>
                  <th width="9%">vin号</th>
                  <th width="9%">汽车型号</th>
                 
                  <th width="11%">发动机号</th>
                  <th width="11%">外饰颜色</th>
                  <th width="11%">因付车款(单位:万)</th
				   >
                  <th width="11%">经销商付款(单位:万)</th>
                  <th width="19%">未导入成功原因</th>
                </tr>
              </thead>
              <tbody class="tbody">
              	<c:forEach items="${errors}" var="car" varStatus="i">
                <tr>
                  <td>${i.index+1}</td>
                  <td>${car.vinNumber}</td>
                  <td>${car.brand}</td>
                  <td>${car.engineCode}</td>
                  <td>${car.colorName}</td>
                  <td>${car.sellPrice}</td>
                  <td>${car.sellPrice}</td>
                  <td>${car.info}</td>
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