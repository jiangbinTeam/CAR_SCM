<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/js/jquery-ui.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/myjs.js"></script>
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
    <td width="17" valign="top" background="../images/mail_leftbg.gif"><img src="${pageContext.request.contextPath}/resources/images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="${pageContext.request.contextPath}/resources/images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">基础资料</div></td>
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
		当前位置：基础资料>>员工管理
		</td>

	</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		  <td width="40%" align="center"><input type="button" class="Submit" style="width:100px" value="添加员工" onclick="window.location='ScmEmployeeByid'"/></td>
	</tr>
	</table>
	<table width="98%" border="0" style="text-align: center;" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<thead class="thead">
    	<tr>
		<th width="6%">序号</th>
		<th width="12%">员工姓名</th>
		<th width="18%">电话</th>
		<th width="6%">性别</th>
		<th width="15%">出生日期</th>	
		<th width="20%">工资（单位：元）</th>
		<th width="16%">用户名</th>
		<th width="7%">操作</th>
		</tr>
		</thead>
		<tbody class="tbody">
		<c:forEach var="emp" items="${requestScope.emp}" varStatus="i">
		 <tr> 
		<td>${i.index+1}</td>
		<td>${emp.employeeName}</td>
		<td>${emp.employeeTel}</td> 
		<td>
			<c:if test="${emp.employeeSex==0}">男</c:if>
			<c:if test="${emp.employeeSex==1}">女</c:if>
		</td> 
		<td><fmt:formatDate value="${emp.employeeBirthday}" pattern="yyyy-MM-dd" /></td>
		<td>${emp.employeePay}</td>
		<td>${emp.userName}</td>
		<td><a href="ScmEmployeeByid?employeeId=${emp.employeeId}" style="color:#000099">修改</a></td>
		</tr>
		</c:forEach>
		</tbody>						
    </table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		 <tr>
		   <td width="869">&nbsp;</td>
		   <td width="63" align="right"><a href="listByPage?currPage=1"><span class="left_ts">首页</span></a></td>
		   <td width="63" align="right"><a href="listByPage?currPage=${currPage-1}"><span class="left_ts">上一页</span></a></td>
		   <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		   <td width="66" align="left"><a href="listByPage?currPage=${currPage+1}"><span class="left_ts">下一页</span></a></td>
		   <td width="63" align="left"><a href="listByPage?currPage=${totalPage}"><span class="left_ts">尾页</span></a></td>
		</tr>
	</table>
	</td>
    <td background="../images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif"><img src="${pageContext.request.contextPath}/resources/images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif"><img src="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif"><img src="${pageContext.request.contextPath}/resources	/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
</body>
</html>