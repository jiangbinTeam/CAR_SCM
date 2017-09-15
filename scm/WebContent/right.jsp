<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css" />
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
	        <td height="31"><div class="titlebt">欢迎界面</div></td>
	      </tr>
   		</table>
   	</td>
    <td width="16" valign="top" background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">
    	<img src="${pageContext.request.contextPath}/resources/images/nav-right-bg.gif" width="16" height="29" />
    </td>
  </tr>
  <tr>
    <td valign="middle" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td colspan="2" valign="top">&nbsp;</td>
        <td>&nbsp;</td>
        <td valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="2" valign="top"><span class="left_bt">感谢您使用 供应链管理信息化系统</span>
        <br>
        <br>
         <span class="left_txt">&nbsp;
         	<img src="${pageContext.request.contextPath}/resources/images/ts.gif" width="16" height="16">开发团队介绍<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         </span>
         <span class="left_txt"><br></span></td>
        <td width="7%">&nbsp;</td>
        <td width="40%" valign="top"><table width="100%" height="144" border="0" cellpadding="0" cellspacing="0" class="line_table">
          <tr>
            <td width="7%" height="27" background="${pageContext.request.contextPath}/resources/images/news-title-bg.gif">
           		<img src="${pageContext.request.contextPath}/resources/images/news-title-bg.gif" width="2" height="27">
            </td>
            <td width="93%" background="${pageContext.request.contextPath}/resources/images/news-title-bg.gif" class="left_bt2">系统介绍</td>
          </tr>
          <tr>
            <td height="102" valign="top">&nbsp;</td>
            <td height="102" valign="top"></td>
          </tr>
          <tr>
            <td height="5" colspan="2">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td colspan="2">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td colspan="2" valign="top"><!--JavaScript部分-->
              <script language=javascript>
				function secboard(n)
				{
				for(i=0;i<sectable.cells.length;i++){
				sectable.cells[i].classname="sec1";
				 alert(sectable.cells.name);
				}
				sectable.cells[n].classname="sec2";
				for(i=0;i<maintable.tbodies.length;i++){
				maintable.tbodies[i].style.display="none";
				alert(sectable.tbodies.name);
				}
				maintable.tbodies[n].style.display="block";
				}
         	 </script>
              <!--HTML部分-->
              
		</td>
        <td>&nbsp;</td>
        <td valign="top">
	        <table width="100%" height="144" border="0" cellpadding="0" cellspacing="0" class="line_table">
	          <tr>
	            <td width="7%" height="27" background="${pageContext.request.contextPath}/resources/images/news-title-bg.gif">
	            	<img src="${pageContext.request.contextPath}/resources/images/news-title-bg.gif" width="2" height="27">
	            </td>
	            <td width="93%" background="${pageContext.request.contextPath}/resources/images/news-title-bg.gif" class="left_bt2">模块划分</td>
	          </tr>
	          <tr>
	            <td height="102" valign="top">&nbsp;</td>
	            <td height="102" valign="top"><label></label><label></label></td>
	          </tr>
	          <tr>
	            <td height="5" colspan="2">&nbsp;</td>
	          </tr>
	        </table>
	     </td>
      </tr>
      <tr>
        <td height="40" colspan="4">
	        <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
	          <tr>
	            <td></td>
	          </tr>
	        </table>
        </td>
      </tr>
      <tr>
        <td width="2%">&nbsp;</td>
        <td width="51%" class="left_txt">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table>
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