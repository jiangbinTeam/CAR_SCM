<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">

<title>My JSP 'createSellList.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link
	href="${pageContext.request.contextPath}/resources/images/skin.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/js/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/myjs.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
	$(function() {
		var i = 2;
		var ttp = '<option value="0" selected="selected">请选择车型</option>';
		var ttg = '<option value="0" selected="selected">请选择颜色</option>';
		var tty = '<option value="';
		var ttm = '<option value="';

		var ttf = '</option>';
		$.post("addDealOrder2", {}, function(data) {
			// ttk= json.parse(data);
			$.each(data, function() {
				ttp = ttp + tty + this.typeCode + '">' + this.brand + '&nbsp' + this.typeCode + '(' + this.carCharacter + ')' + ttf;

			});
		}, "json");
		//alert(ttp);
		$.post("addDealOrder3", {}, function(data) {
			$.each(data, function() {
				ttg = ttg + ttm + this.colorCode + '">' + this.colorName + ttf;
			//alert(this.colorName);
			});
		}, "json");

		$('#add').click(function() {


			$('<tr><td>' + i + '</td><td><select name="typeCode" class="sec2" style="width:250px">' + ttp + '</select></td><td><select name="colorCode" class="sec2" style="width:100px">' + ttg + '</select></td><td><input type="text" name="addAccessorizeNote" class="login_text" style="width:500px"/></td><td id="line' + i + '"><a  onclick="delRow(line' + i + ');" id="delete" class="nav">删除</a></td></tr>').appendTo("#projectmodule").find("#delete").click(function() {
				--i;
				$(this).parent().parent().remove();

				$("#projectmodule tbody tr td:first-child").each(function(i) {
					if (i + 1 != 1) {
						this.innerHTML = (i + 1);

					}

				});
			// a();
			});

			i++;
		});
	});
</script>
<script type="text/javascript">
	function tianjia() {
		if ($("#date11").val() == null||$("#date11").val()=='') {
			alert("请选择下单时间");
			return false;
		}
		
		if ($("#dealerId").val() == '0') {
			alert("请选择经销商！");
			return false;
		}
		var falg =1;
		$("select").each(function(key, value) {


			if ($(this).val() == '0') {
			    
				alert("请选择车型与颜色！");
				
				falg = 0;
				return false;
			}
		
			
		});
		if(falg == 1){
		
		/* $('#typeCodes').val($('select[name="typeCode"]').map(function(){return this.value}).get().join(','))
		$('#colorCodes').val($('select[name="colorCode"]').map(function(){return this.value}).get().join(','))
		$('#addAccessorizeNotes').val($('input[name="addAccessorizeNote"]').map(function(){return this.value}).get().join(','))
		 a lert($('#typeCodes').val())*/
			if (confirm("确认添加订单？")) {
			$("#myform1").submit();
		       }
			
	        }


	}
</script>
<style type="text/css">
.hover {
	background-color: #CACACA;
} /*这里是鼠标经过时的颜色*/
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
			<td width="17" valign="top"
				background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">
				<img
				src="${pageContext.request.contextPath}/resources/images/left-top-right.gif"
				width="17" height="29" />
			</td>
			<td valign="top"
				background="${pageContext.request.contextPath}/resources/images/content-bg.gif">
				<table width="100%" height="31" border="0" cellpadding="0"
					cellspacing="0" class="left_topbg" id="table2">
					<tr>
						<td height="31"><div class="titlebt">销售管理</div></td>
					</tr>
				</table>
			</td>
			<td width="16" valign="top"
				background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">
				<img
				src="${pageContext.request.contextPath}/resources/images/nav-right-bg.gif"
				width="16" height="29" />
			</td>
		</tr>
		<tr>
			<td valign="middle"
				background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">&nbsp;</td>
			<td valign="top" bgcolor="#F7F8F9">
				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0" class="line_table">
					<tr>
						<td width="20"><img
							src="${pageContext.request.contextPath}/resources/images/icon-login-seaver.gif"
							width="16" height="16" /></td>
						<td>当前位置：销售管理>>经销商订单管理>>订单维护</td>
					</tr>
				</table>
				<form action="addDealOrder4" method="get" id="myform1">
					<table width="98%" border="0" align="center" cellpadding="0"
						cellspacing="0" class="line_table">
						<tbody class="tbody2">
							<tr>
								<td width="6%" align="left"><span>下单时间</span></td>
								<td width="24%" align="left"><input name="certificateDate"
									type="text" style="width:200px" class="Wdate"
									onclick="WdatePicker()" required="required" id="date11" /></td>
								<td width="10%" align="left"><span>请选择经销商</span></td>
								<td width="28%" align="left"><select name="dealerId"
									class="sec2" style="width:200px" id="dealerId">
										<option value="0" selected="selected">请选择</option>
										<c:forEach items="${dealers}" var="dealer">
											<option value="${dealer.dealerId }">
												${dealer.storefrontName}&nbsp(${dealer.principalName })</option>

										</c:forEach>
								</select></td>
								<td width="32%" align="left"><input name="button"
									type="button" class="Submit" style="width:100px"
									onclick="tianjia()" value="保存" /></td>
							</tr>
						</tbody>
					</table>
					<table width="98%" border="0" align="center" cellpadding="0"
						cellspacing="0" class="line_table" id="projectmodule">
						<thead class="thead">
							<tr>
								<th width="6%">序号</th>

								<th width="26%">汽车车型</th>
								<th width="10%">车型颜色</th>
								<th width="46%">加装说明</th>
								<th width="12%"><a id="add">添加一行</a></th>
							</tr>
						</thead>
						<tbody class="tbody">
							<tr>
								<td>1</td>
								<td><select name="typeCode" class="sec2"
									style="width:250px">
										<option value="0" selected="selected">请选择车型</option>

										<c:forEach items="${typeDictionaries }" var="types">
											<option value="${types.typeCode }">${types.brand}${types.typeCode}(${types.carCharacter})</option>
										</c:forEach>
								</select></td>
								<td><select name="colorCode"
									class="sec2" style="width:100px">
										<option value="0" selected="selected">请选择颜色</option>
										<c:forEach items="${colorChanges }" var="color">
											<option value="${color.colorCode}">${color.colorName}</option>
										</c:forEach>
								</select></td>
								<td><input type="text" class="login_text"
									style="width:500px"
									name="addAccessorizeNote" />
									
									<!-- <input type="hidden" id="colorCodes"  name="colorCodes"/>
									<input type="hidden" id="addAccessorizeNotes" name="addAccessorizeNotes"> 
									<input  type="hidden" id="typeCodes" name="typeCodes"> -->
									</td>
								<td id="line'+i+'">&nbsp; </td>
							</tr>
						</tbody>
					</table>
				</form>
			</td>

			<td
				background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">&nbsp;</td>

		</tr>

		<tr>
			<td valign="bottom"
				background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">
				<img
				src="${pageContext.request.contextPath}/resources/images/buttom_left2.gif"
				width="17" height="17" />
			</td>
			<td
				background="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif">
				<img
				src="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif"
				width="17" height="17">
			</td>
			<td valign="bottom"
				background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">
				<img
				src="${pageContext.request.contextPath}/resources/images/buttom_right2.gif"
				width="16" height="17" />
			</td>
		</tr>
	</table>
</body>
</html>
