<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理页面</title>
<base target="main">

<link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css" />

<link href="${pageContext.request.contextPath}/resources/js/jquery-ui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/myjs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script language=JavaScript>
$(function(){
	//时钟
	myDate();

});

function modifyPwd(){
		$('#dialog').dialog('open');
		return false;
}

function logout(){
	if (confirm("您确定要退出控制面板吗？"))
	top.location = "quit";
	return false;
}
function myDate(){
	var days=new  Array ("日", "一", "二", "三", "四", "五", "六");
	
	var today=new Date();//获取当前时间
	var year=today.getFullYear();//年
	var month=today.getMonth()+1;//月
	var day=today.getDate();//日
	var week=today.getDay();//星期
	var hh=today.getHours();//时
	var mm=today.getMinutes();//分
	var ss=today.getSeconds();//秒
	
	if(month<10){month="0"+month};
	if(day<10){day="0"+day};
	if(hh<10){hh="0"+hh};
	if(mm<10){mm="0"+mm};
	if(ss<10){ss="0"+ss};
	
	document.getElementById("clock").innerHTML=year+"年"+month+"月"+day+"日"+"&nbsp;星期"+days[week]+"&nbsp;"+hh+":"+mm+":"+ss;
	
	 var newTime=setTimeout(myDate, 1000)
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
	        <td width="74%" height="38" style="color: #FFFFFF;font-size: 13px;" align="right">
	        	
	        	${authorityInfo.authority}<span style="color: red;font-weight: bold;">${authorityInfo.employeeName}</span> 您好,感谢登陆使用！
	        </td>
	        <td width="12%">
	        	<a href="#" target="_self" onClick="logout();">
	        		<img src="${pageContext.request.contextPath}/resources/images/out.gif" style="margin-top: 8px;"
	        		  alt="安全退出" width="46" height="20" border="0">
	        	</a>
	        </td>
	        <td width="14%">
	        	<a href="modifyPwd.jsp" target="main" style="color: white;font-size: 13px;">修改密码</a>
	        </td>
	      </tr>
	      <tr>
	        <td height="19" colspan="3">
	        	<span id="clock" style="float: right;margin-right: 10px; font-size: 14px;"></span>
	        </td>
	      </tr>
	    </table>
    </td>
  </tr>
</table>
</body>
</html>