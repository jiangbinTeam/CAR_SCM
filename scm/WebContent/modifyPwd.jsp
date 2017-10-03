<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>密码修改</title>
<link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/js/jquery-ui.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/myjs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script language=JavaScript>

function check() {
	var pwd=document.getElementById("pwd").value;
	var repeatPwd=document.getElementById("repeatPwd").value;
	if(pwd.length<6||pwd.length>12){
		alert("密码长度不符合要求！");
		return false;
	}
	if(pwd==repeatPwd){	
		return true;
	}else{
		alert("两次输入的密码不一致！")
		return false;
	}
	
}
</script>
<style type="text/css"> 
.hover{background-color:#CACACA;}  /*这里是鼠标经过时的颜色*/ 

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

   <div style="font-size:14px;color:red; width: 100px;height: 30px;position: absolute;right: 400px;top: 50px;">
	<p>${error}</p>
   </div>
   
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">
    	<img src="${pageContext.request.contextPath}/resources/images/left-top-right.gif" width="17" height="29" />
    </td>
    <td valign="top" background="${pageContext.request.contextPath}/resources/images/content-bg.gif">
    	<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
	      <tr>
	        <td height="31"><div class="titlebt">密码修改</div></td>
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
					<img src="${pageContext.request.contextPath}/resources/images/icon-login-seaver.gif" width="16" height="16" /></td>
					<td>当前位置：密码修改</td>
				</tr>
			</table>
		<c:if test="${empty success}">
		<form action="modifyPwd" method="post" onsubmit="return check()">
			<table border="0" style="text-align: center;" align="center">
				 <tr>
					<td colspan="2">
						<input name="password" maxlength="18" placeholder="原始密码" type="password" 
							style="width: 300px;height: 30px;">
					</td>
			    </tr>
			    <c:if test="${empty newpassword}">
				     <tr>
						<td colspan="2">
							<input id="pwd" name="newpassword" maxlength="18" placeholder="新密码（长度6-12）" type="password" 
								style="width: 300px;margin-top:20px;height: 30px;">
						</td>
				    </tr>
					<tr>
						<td colspan="2">
							<input id="repeatPwd"  name="pwd" maxlength="18" placeholder="确认密码（长度6-12）"  type="password" 
							style="width: 300px;margin-top:20px;height: 30px;"></td>
					</tr>
			    </c:if>
			    
			    <c:if test="${!empty newpassword}">
				    <tr>
						<td colspan="2">
							<input id="pwd" value="${newpassword}" name="newpassword" maxlength="18" placeholder="新密码（长度6-12）" type="password" 
								style="width: 300px;margin-top:20px;height: 30px;">
						</td>
				    </tr>
					<tr>
						<td colspan="2">
							<input id="repeatPwd" value="${newpassword}"  name="pwd" maxlength="18" placeholder="确认密码（长度6-12）"  type="password" 
							style="width: 300px;margin-top:20px;height: 30px;"></td>
					</tr>
				</c:if>
				<tr>
					<td>
						<input type="submit" value="修改" 
							style="margin-top:20px;height: 30px;width: 70px;border-radius: 5px;">
					</td>
					<td>
						<input type="reset" value="重置" 
							style="margin-top:20px;height: 30px;width: 70px;border-radius: 5px;">
					</td>
				</tr>
			</table>
		</form>
		</c:if>
		<c:if test="${!empty success}">
			<script type="text/javascript">
				alert("密码修改 成功！");
			</script>
			<p style="width: 100%; text-align: center;font-size: 14px;color: red">${success}</p>
		</c:if>
	</td>
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