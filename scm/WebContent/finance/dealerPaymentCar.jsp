<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title><link href="${pageContext.request.contextPath}/resources/images/skin.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/images/fox.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/js/jquery-ui.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/myjs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
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

	$(function(){	
		$('#dialog').dialog({
			autoOpen: false,
			width: 500,
			height:200,
			buttons: {
				"取消": function() { 
					$(this).dialog("close"); 
				}, 
				"确定": function() { 
					$(this).dialog("close"); 
				} 
			}
		});
		
		$("a[name='payment']").click(function(){
			 
			$('#dialog').dialog('open');
			return false;
		});
	}); 
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
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="${pageContext.request.contextPath}/resources/images/mail_leftbg.gif">
    	<img src="${pageContext.request.contextPath}/resources/images/left-top-right.gif" width="17" height="29" />
    </td>
    <td valign="top" background="${pageContext.request.contextPath}/resources/images/content-bg.gif">
    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">财务管理</div></td>
      </tr>
    </table></td>
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
			<img src="${pageContext.request.contextPath}/resources/images/icon-login-seaver.gif" width="16" height="16" />
		</td>
		<td>当前位置：财务管理>>经销商付车款</td>
		</tr>
	</table>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		  <td width="36%" align="center">
			 <input type="button" class="Submit" style="width:100px" value="经销商付款" onclick="window.location='finance/dealerPaymentCarCreate.jsp'"/>
		  </td>
		  
	</tr>
	</table>
	<table width="98%" border="0" style="text-align: center;" align="center" cellpadding="0" cellspacing="0" class="line_table">
      <thead class="thead">
        <tr>
          <th width="7%">序号</th>
          <th width="14%">VIN号</th>
          <th width="12%">汽车型号</th>
		  <th width="8%">颜色</th>
		  <th width="18%">经销商付款（单位：万）</th>
          <th width="27%">操作</th>
          </tr>
      </thead>
      <tbody class="tbody">
      	<c:forEach items="${dPcars}" var="car" varStatus="i">
	        <tr>
	          <td>${i.index+1}</td>
	          <td>${car.vinNumber }</td>
	          <td>${car.brand }</td>
			  <td>${car.colorName }</td>
	          <td>${car.sellPrice }</td>
			   <td><a  href="javascript:void(0);" onclick="confirmDel('${car.vinNumber}')" style="color:#000099">付款</a></td>
	         </tr>
        </c:forEach>
      </tbody>
    </table>
    <script type="text/javascript">
	    function confirmDel(vinNumber)  {  
			
	         if(confirm("确定付款吗？")){  
	  		 window.location.href="payDealerPaymentCar?vinNumber="+vinNumber;
	         }
		}  
   </script>
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		<td width="869">&nbsp;</td>
		  <td width="63" align="right"><a href="dPCarByPage?currPage=1"><span class="left_ts">首页</span></a></td>
		  <td width="63" align="right"><a href="dPCarByPage?currPage=${currPage-1}"><span class="left_ts">上一页</span></a></td>
		  <td width="63" align="center"><span class="admin_toptxt">${currPage }/${totalPage }</span></td>
		  <td width="66" align="left"><a href="dPCarByPage?currPage=${currPage+1}"><span class="left_ts">下一页</span></a></td>
		  <td width="63" align="left"><a href="dPCarByPage?currPage=${totalPage}"><span class="left_ts">尾页</span></a></td>
		</tr>
	</table>
	</td>
    <td background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="${pageContext.request.contextPath}/images/mail_leftbg.gif">
    	<img src="${pageContext.request.contextPath}/resources/images/buttom_left2.gif" width="17" height="17"/></td>
    <td background="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif">
    	<img src="${pageContext.request.contextPath}/resources/images/buttom_bgs.gif" width="17" height="17">
    </td>
    <td valign="bottom" background="${pageContext.request.contextPath}/resources/images/mail_rightbg.gif">
    	<img src="${pageContext.request.contextPath}/resources/images/buttom_right2.gif" width="16" height="17" />
    </td>
  </tr>
</table>
<div id="dialog" title="经销商付款">
		<table>
		<tr>
				<td width="178"><a class="message"><strong>销售价格（单位：万）</strong></a></td>
				<td width="335"><a class="message">20.0</a></td>
		  </tr>
		    <tr>
				<td width="178"><a class="message"><strong>欠款（单位：万）</strong></a></td>
				<td width="335"><a class="message">10.0</a></td>
		  </tr>
				<tr>
				<td width="178"><a class="message"><strong>经销商补交</strong></a></td>
				<td width="335"><input name="mydate" type="text" style="width:200px"  class="text_2000"/></td>
			</tr>
			<tr>
				<td width="178"><a class="message"><strong>付款方式</strong></a></td>
				<td width="335"><select name="select" class="sec2" style="width:200px">
                  <option selected="selected" >请选择</option>
                  <option>现金付款</option>
                  <option>经销商余额付款</option>
                </select></td>
			</tr>
		</table>
</div>
</body>
</html>