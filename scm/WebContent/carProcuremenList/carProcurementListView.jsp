<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/js/jquery-ui.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/myjs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
<script type="text/javascript" language="JavaScript">
$(function(){

	$('input[name=mydate]').makeDate();
	
});


</script> 
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
        <td height="31"><div class="titlebt">采购管理</div></td>
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
		<img src="${pageContext.request.contextPath}/resources/images/icon-login-seaver.gif" width="16" height="16" />		</td>
		<td>
		当前位置：采购管理>>车辆采购单管理>>采购单查看(carProcurementListView)</td>
	</tr>
	</table>
	        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
              <tbody class="tbody2">
              
              <td width="5%" align="left"><span>采购单号</span></td>
              <td width="12%" align="left"><span >${lv.carProcurementListId}</span></td>
              <td width="4%" align="left"><span>采购数量</span></td>
              <td width="12%" align="left"><span>${lv.carProcurementListCount}</span></td>
              <tr>
              <td width="5%" align="left"><span>采购单价</span></td>
              <td width="12%" align="left"><span>${lv.procurementPrice}</span> </td>
              <td width="4%" align="left"><span>创建时间</span></td>
              <td width="12%" align="left"><span><fmt:formatDate value="${lv.carProcurementListDate}" pattern="yyyy-MM-dd"/></span></td>
              </tr>
              <tr>
              <td width="4%" align="left"><span>采购车型</span></td>
              <td width="12%" align="left"><span>${lv.brand}</span></td>
              <td width="5%" align="left"><span>预计打款日期</span></td>
              <td width="12%" align="left"><span><fmt:formatDate value="${lv.carProcurementListDate}" pattern="yyyy-MM-dd"/></span></td>
              </tr>
              <tr>
              <td width="5%" align="left"><span>外饰颜色</span></td>
              <td width="12%" align="left"><span>${lv.COLORNAME}</span></td>
              <td width="4%" align="left"><span>采购总额</span></td>
                  <td width="12%" align="left"><span>${lv.carProcurementAmount}</span></td>
              
              </tr>
              
              
                
              </tbody>
            </table>
			
	        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
              <thead class="thead">
                <tr>
                  <th width="14%"></th>
                  <th width="26%"></th>
                  <th width="20%"></th>
                  <th width="20%"></th>
                  <th width="20%"></th>
                </tr>
              </thead>
              <tbody class="tbody">
               
              </tbody>
            </table>
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
			<td width="869">&nbsp;</td>
		  <td width="63" align="right"><a href="#"><span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="#"><span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">1/15</span></td>
		  <td width="66" align="left"><a href="#"><span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="#"><span class="left_ts">尾页</span></a></td>
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

</body>
</html>