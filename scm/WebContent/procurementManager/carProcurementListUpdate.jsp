<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript" language="JavaScript">
	$(function() {

		$('input[name=mydate]').makeDate();
		//$('input[name=mydate]').datepicker({duration:"fast",altFormat:"yy-mm-dd",dateFormat:"yy-mm-dd"});

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
			<td width="17" valign="top" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif"><img
				src="${pageContext.request.contextPath}/resources/images/left-top-right.gif" width="17" height="29" /></td>
			<td valign="top" background="${pageContext.request.contextPath}/resources/images/content-bg.gif"><table
					width="100%" height="31" border="0" cellpadding="0" cellspacing="0"
					class="left_topbg" id="table2">
					<tr>
						<td height="31"><div class="titlebt">物流管理</div></td>
					</tr>
				</table></td>
			<td width="16" valign="top" background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif"><img
				src="${pageContext.request.contextPath}/resources/images/nav-right-bg.gif" width="16" height="29" /></td>
		</tr>
		<tr>
			<td valign="middle" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">&nbsp;</td>
			<td valign="top" bgcolor="#F7F8F9">
				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0" class="line_table">
					<tr>
						<td width="20"><img src="${pageContext.request.contextPath}/resources/images/icon-login-seaver.gif"
							width="16" height="16" /></td>
						<td>当前位置：采购管理>>车辆采购单管理>>采购单信息维护</td>

					</tr>
				</table>
				<form action="carProcurementListModify" method="post" onsubmit="return formChick()">
				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0" class="line_table">
					<tbody class="tbody2">
						<tr>
							<td width="5%" align="left"><span>采购单号${carProcurementList.carProcurementListId}</span></td>
							<td width="12%" align="left">
								<input type="hidden" name="carProcurementListId" value="${carProcurementList.carProcurementListId}">
								<input name="carProcurementNumber" type="text" value="${carProcurementList.carProcurementNumber}"
									style="border: none; "
									required="required" readonly="readonly" class="text_2000" />
							</td>
							<td width="4%" align="left"><span>采购数量</span></td>
							<td width="12%" align="left">
								<input name="carProcurementListCount" type="text" required="required" 
									value="${carProcurementList.carProcurementListCount}"
									style="width: 200px" onkeyup="this.value=this.value.replace(/[^\d]/g,'');"  class="text_2000" />
							</td>
						</tr>
						<tr>
							<td width="5%" align="left"><span>采购单价</span></td>
							<td width="12%" align="left">
								<input name="procurementPrice" type="text" required="required"
									value="${carProcurementList.procurementPrice}"
									style="width: 200px" onkeyup="this.value=this.value.replace(/[^\d]/g,'');"
									class="text_2000" /> (单位:万)
							</td>
							<td width="4%" align="left"><span>创建时间</span></td>
							<td width="12%" align="left">
								<input name="carProcurementListDate" required="required" onClick="WdatePicker()" class="Wdate"
									value="${createDate}"
									type="text" style="width: 200px" class="text_2000" />
							</td>
						</tr>
						<tr>
							<td width="4%" align="left"><span>采购车型</span></td>
							<td width="12%" align="left">
								<select name="typeCode" id="carType">
									<c:forEach items="${typeDictionaries}" var="t">
										<c:if test="${t.typeCode==carProcurementList.typeCode}">
											<option value="${t.typeCode}">${t.brand}(${t.carCharacter})</option> 
										</c:if>
									</c:forEach>
									<c:forEach items="${typeDictionaries}" var="t">
										<c:if test="${t.typeCode!=carProcurementList.typeCode}">
											<option value="${t.typeCode}">${t.brand}(${t.carCharacter})</option> 
										</c:if>
									</c:forEach>								
								</select>
							</td>
							<td width="5%" align="left"><span>预计打款日期</span></td>
							<td width="12%" align="left">
								<input name="expectedPaymentDate" required="required" onClick="WdatePicker()" class="Wdate"
									value="${payDate}" type="text" style="width: 200px" class="text_2000" />
							</td>

						</tr>
						<tr>
							<td width="4%" align="left"><span>外饰颜色</span></td>
							<td width="12%" align="left">
								<select name="colorCode" id="carColor">
									<c:forEach items="${colorChanges}" var="color">
										<c:if test="${color.colorCode==carProcurementList.colorCode}">
											<option value="${color.colorCode}">${color.colorName}</option>							
										</c:if>
									</c:forEach>
									<c:forEach items="${colorChanges}" var="color">
										<c:if test="${color.colorCode!=carProcurementList.colorCode}">
											<option value="${color.colorCode}">${color.colorName}</option>							
										</c:if>
									</c:forEach>
								</select>
							</td>
							<td width="5%" align="left"></td>
							<td width="12%" align="left"></td>

						</tr>
						<tr>
						
							<td colspan="4" >
							<input type="submit" class="Submit" style="width: 100px;margin-left: 40%;" value="保存采购单" /></td>
						</tr>
					</tbody>
				</table>
				</form>
				<script type="text/javascript">
					function formChick(){
						var carType=document.getElementById("carType").value;
						if(carType=="0"){
							alert("请完善采购的车型信息！");
							return false;
						}else{
							if(confirm("确认修改该采购单吗？")){
								return true;
							}else{
								return false;
							}
						}
					}
				
					$(function(){
						
						$("#carType").click(function(){
							var carType=document.getElementById("carType").value;
							
							$.post("listColorByTCode",{"typeCode":carType},function(data){
								$.each(data,function(){
									var op="<option value="+this.colorCode+">"+this.colorName+"</option>";
									$("#carColor").empty();
									$("#carColor").append(op);
								});
							},"json")
						});
						
			
						$("#carColor").click(function(){
							var carType=document.getElementById("carType").value;
						
							if(carType=="0"){
								alert("请先选择车型！");
							}
						});
					})
				</script>
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