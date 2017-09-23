<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理页面</title>

<script src="${pageContext.request.contextPath}/resources/js/prototype.lite.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/moo.fx.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/moo.fx.pack.js" type="text/javascript"></script>
<style>
body {
	font:12px Arial, Helvetica, sans-serif;
	color: #000;
	background-color: #EEF2FB;
	margin: 0px;
}
#container {
	width: 182px;
}
H1 {
	font-size: 12px;
	margin: 0px;
	width: 182px;
	cursor: pointer;
	height: 30px;
	line-height: 20px;	
}
H1 a {
	display: block;
	width: 182px;
	color: #000;
	height: 30px;
	text-decoration: none;
	moz-outline-style: none;
	background-image: url(${pageContext.request.contextPath}/resources/images/menu_bgs.gif);
	background-repeat: no-repeat;
	line-height: 30px;
	text-align: center;
	margin: 0px;
	padding: 0px;
}
.content{
	width: 182px;
	height:26px;
	
}
.MM ul {
	list-style-type: none;
	margin: 0px;
	padding: 0px;
	display: block;
}
.MM li {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	list-style-type: none;
	display: block;
	text-decoration: none;
	height: 26px;
	width: 182px;
	padding-left: 0px;
}
.MM {
	width: 182px;
	margin: 0px;
	padding: 0px;
	left: 0px;
	top: 0px;
	right: 0px;
	bottom: 0px;
	clip: rect(0px,0px,0px,0px);
}
.MM a:link {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(${pageContext.request.contextPath}/resources/images/menu_bg1.gif);
	background-repeat: no-repeat;
	height: 26px;
	width: 182px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}
.MM a:visited {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(${pageContext.request.contextPath}/resources/images/menu_bg1.gif);
	background-repeat: no-repeat;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 182px;
	text-decoration: none;
}
.MM a:active {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(${pageContext.request.contextPath}/resources/images/menu_bg1.gif);
	background-repeat: no-repeat;
	height: 26px;
	width: 182px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}
.MM a:hover {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	font-weight: bold;
	color: #006600;
	
	background-repeat: no-repeat;
	text-align: center;
	display: block;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 182px;
	text-decoration: none;
}
</style>
</head>

<body>

<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
  <tr>
    <td width="182" valign="top"><div id="container">
	
      <h1 class="type"><a href="javascript:void(0)">采购管理</a></h1>
	  <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="${pageContext.request.contextPath}/resources/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="yearProcurementPlanPage" target="main">制定全年采购计划</a></li>
          <li><a href="procurementPlanPage" target="main">全年采购计划分解</a></li>
		  <li><a href="procurementManager/carProcurementListMain.html" target="main">车辆采购单管理</a></li>
        </ul>
      </div>
	  
	  
	   <h1 class="type"><a href="javascript:void(0)">销售管理</a></h1>
	   <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="${pageContext.request.contextPath}/resources/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="sellManager/sellPlan.html" target="main">制定全年销售计划</a></li>
          <li><a href="sellManager/sellPlanSelectByMouth.html" target="main">全年销售计划查询</a></li>
          <li><a href="sellManager/sellPlanSelectByDealer.html" target="main">全年经销商销售计划查询</a></li>
          <li><a href="sellManager/dealerOrderManager.html" target="main">经销商订单管理</a></li>
          <li><a target="main" href="sellManager/startAccountingManager.html">发车台帐管理</a></li>
          <li><a href="sellManager/dealerSellPlanCensor.html" target="main">经销商销售计划审查</a></li>
		  <li><a href="sellManager/dealerChargeBalance.html" target="main">经销商费用结算</a></li>
        </ul>
      </div>
	  
	  
      <h1 class="type"><a href="javascript:void(0)">接车管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="${pageContext.request.contextPath}/resources/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
		  <li><a href="accessCarManager/licenseNumber.html" target="main">许可证管理</a></li>
		  <li><a href="accessCarManager/arrivalCustoms.html" target="main">报关管理</a></li>
		  <li><a href="accessCarManager/checkBox.html" target="main">开箱检查</a></li>
          <li><a href="accessCarManager/checkPDI.html" target="main">车辆PDI检查</a></li>
        </ul>
      </div>
	  
	  
	   <h1 class="type"><a href="javascript:void(0)">物流管理</a></h1>
	   <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="${pageContext.request.contextPath}/resources/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
		  <li><a target="main" href="logisticsManager/sailingPlan.html">船期安排</a></li>
          <li><a href="logisticsManager/groupNumber.html" target="main">批次管理</a></li>
          <li><a href="logisticsManager/waybill.html" target="main">提单管理</a></li>
          <li><a href="logisticsManager/invoice.html" target="main">发车管理</a></li>
        </ul>
      </div>
	  
	  
	   <h1 class="type"><a href="javascript:void(0)">仓库管理</a></h1>
	   <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="${pageContext.request.contextPath}/resources/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="warehouseManager/warehouse.html" target="main">仓库管理</a></li>
          <li><a href="warehouseManager/storageAreas.html" target="main">库位管理</a></li>
          <li><a href="warehouseManager/carOutManager.html" target="main">汽车出库管理</a></li>
		  <li><a href="warehouseManager/carInManager.html" target="main">汽车入库管理</a></li>
        </ul>
      </div>
	  
	  
      <h1 class="type"><a href="javascript:void(0)">加装管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="${pageContext.request.contextPath}/resources/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="addAccessorizeManager/addAccessorize.html" target="main">车辆加装</a></li>
          <li><a href="addAccessorizeManager/partsInventory.html" target="main">零件库存</a></li>
          <li><a href="addAccessorizeManager/accessoryStock.html" target="main">零件采购</a></li>
        </ul>
      </div>
	  
	  
	   <h1 class="type"><a href="javascript:void(0)">基础资料</a></h1>
      <div class="content">
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><img src="${pageContext.request.contextPath}/resources/images/menu_topline.gif" width="182" height="5" /></td>
            </tr>
          </table>
        <ul class="MM">
          <li><a href="logistics" target="main">物流公司</a></li>
		  <li><a href="colorChange" target="main">颜色转换对照表</a></li>
          <li><a href="tdyPage" target="main">车型字典表</a></li>
		  <li><a href="baseManager/employee.html" target="main">员工管理</a></li>
		  <li><a href="baseManager/dealer.html" target="main">经销商管理</a></li>
		  <li><a href="baseManager/" target="main">权限权限管理</a></li>
        </ul>
      </div>
	  
	  
	  <h1 class="type"><a href="javascript:void(0)">财务管理</a></h1>
	  <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="${pageContext.request.contextPath}/resources/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="finance/paymentList.html" target="main">打款管理</a></li>
          <li><a href="finance/dealerAwards.html" target="main">经销商奖励</a></li>
		  <li><a href="finance/paymentCarriageCharge.html" target="main">经销商运费管理</a></li>
		  <li><a href="finance/dealerPaymentCar.html" target="main">经销商付车款</a></li>
		  <li><a href="finance/invoiceNumber.html" target="main">开票</a></li>
        </ul>
      </div>
	
	  
    </div>
	
	  
    <script type="text/javascript">
    
		var contents = document.getElementsByClassName('content');
		var toggles = document.getElementsByClassName('type');
	
		var myAccordion = new fx.Accordion(
			toggles, contents, {opacity: true, duration: 400}
		);
		myAccordion.showThisHideOpen(contents[0]);
	</script>
    </td>
  </tr>
</table>
</body>
</html>
