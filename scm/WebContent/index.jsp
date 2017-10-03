<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理中心</title>
</head>

 <c:if test="${empty user}">
	<script type="text/javascript">
		top.location.href="login.jsp";
	</script>
 </c:if>  
<frameset rows="64,*"  frameborder="NO" border="0" framespacing="0">
	<frame src="admin_top.jsp" noresize="noresize" frameborder="NO" name="topFrame" scrolling="no" marginwidth="0" marginheight="0" target="main" />
  	<frameset cols="200,*"  rows="800,*" id="frame">
	<frame src="left.jsp" name="leftFrame" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0" scrolling="no" target="main" />
	<frame src="right.jsp" name="main" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto" target="_self" />
</frameset>
</html>