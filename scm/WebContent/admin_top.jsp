<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理页面</title>
<base target="main">
<link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css">
<script language=JavaScript>
function logout(){
	if (confirm("您确定要退出控制面板吗？"))
	top.location = "quit";
	return false;
}
</script>
</head>
<body leftmargin="0" topmargin="0">

<table width="100%" height="64" border="0" cellpadding="0" cellspacing="0" class="admin_topbg">
  <tr>
    <td width="61%" height="64">
    	<img src="${pageContext.request.contextPath}/resources/images/logo1.gif" width="262" height="64">
    </td>
    <td width="39%" valign="top">
	    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="74%" height="38" class="admin_txt" align="right">管理员：<span style="color: red;font-weight: bold;">${user.username}</span> 您好,感谢登陆使用！</td>
	        <td width="22%">
	        	<a href="#" target="_self" onClick="logout();">
	        		<img src="${pageContext.request.contextPath}/resources/images/out.gif" alt="安全退出" width="46" height="20" border="0">
	        	</a>
	        </td>
	        <td width="4%">&nbsp;</td>
	      </tr>
	      <tr>
	        <td height="19" colspan="3">&nbsp;</td>
	      </tr>
	    </table>
    </td>
  </tr>
</table>
</body>
</html>