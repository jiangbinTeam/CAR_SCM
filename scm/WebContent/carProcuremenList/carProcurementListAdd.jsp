<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/js/jquery-ui.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/myjs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/My97DatePicker/My97DatePicker/WdatePicker.js"></script>
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
        <td height="31"><div class="titlebt">物流管理</div></td>
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
		当前位置：物流管理>>车辆VIN号管理
		</td>

	</tr>
	</table>
	<form action="save1" method="post">
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
	<tbody class="tbody2">
			<tr>
		<td width="5%" align="left"><span>采购单号</span></td>
		<td width="12%" align="left"><input name="carProcurementNumber" type="text" value="${lv.carProcurementNumber}" class="text_2000"/></td>
				<td width="4%" align="left"><span>采购数量</span></td>
		        <td width="12%" align="left"><input name="carProcurementListCount" type="${lv.carProcurementListCount}" style="width:200px" value="100" class="text_2000"/></td>
		</tr>
		<tr>
		<td width="5%" align="left"><span>采购单价</span></td>
		<td width="12%" align="left"><input name="procurementPrice" type="${lv.procurementPrice}" style="width:200px" value="100" class="text_2000"/>
		(单位:万)</td>
				<td width="4%" align="left"><span>创建时间</span></td>
		<td width="12%" align="left">
		<input name="carProcurementListDate" type="text"  style="width:200px"  class="Wdate"  onclick="WdatePicker()"/></td>
		</tr>
		<tr>
									<td width="4%" align="left"><span>采购车型</span></td>
		                            <td width="12%" align="left"><select id="selJob" name="typeCode">
		       
        </select></td>
		                            <td width="5%" align="left"><span>预计打款日期</span></td>
		<td width="12%" align="left">
		<input name="expectedPaymentDate" type="text" style="width:200px"  class="Wdate" onclick="WdatePicker()"/></td>

		</tr>
		<tr>
								<td width="5%" align="left"></td>
                                <td width="12%" align="left">
		  </td>
                                <td width="4%" align="left"></td>
                        <td width="12%" align="left"><input name="button" type="Submit" class="Submit" style="width:100px" value="保存采购单"/></td>
		</tr>
		</tbody>
	</table>
</form>
	</td>
    <td background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif"><img src="${pageContext.request.contextPath}/resources/images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif"><img src="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif"><img src="${pageContext.request.contextPath}/resources/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>

页面要求：<br />
1.因为在数据库“汽车采购单表”中仅有采购总额和采购数量，所以单价需要手动算出。<br />
2.如果该采购单已经上报物流部门，并形成提单，那么该采购单不允许修改，在修改列显示为空。<br />
3.分页每页显示15条数据。按照日期排序。
<script type="text/javascript">
  $(function() {$.ajax({
		url:"find",
		dataType:"json",
		type:"GET",
		success:function(data){	
			$.each(data,function(){
				var op=$("<option value="+this.typeCode+">"+this.brand+"</option>");
				$("#selJob").append(op);
			})
		}
	});
	})
  
	

</script>
</body>
</html>