<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<link href="../images/skin.css" rel="stylesheet" type="text/css" />
<link href="../images/fox.css" rel="stylesheet" type="text/css" />
<link href="../js/jquery-ui.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/myjs.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
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
    <td width="17" valign="top" background="../images/mail_leftbg.gif"><img src="../images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="../images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">采购管理</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="../images/mail_rightbg.gif"><img src="../images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td valign="middle" background="../images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
		<tr>
		<td width="20">
		<img src="../images/icon-login-seaver.gif" width="16" height="16" />		</td>
		<td>
		当前位置：采购管理>>车辆采购单管理>>添加VIN号((carProcurementVinAdd.html))</td>
	</tr>
	</table>
	        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
              <tbody class="tbody2">
                <tr>
                  <td width="5%" align="left"><span>采购单号</span></td>
                  <td width="12%" align="left"><span >1011</span></td>
                  <td width="4%" align="left"><span>采购数量</span></td>
                  <td width="12%" align="left"><span>100</span></td>
                </tr>
                <tr>
                  <td width="5%" align="left"><span>采购单价</span></td>
                  <td width="12%" align="left"><span>50.9(万/辆)</span> </td>
                  <td width="4%" align="left"><span>创建时间</span></td>
                  <td width="12%" align="left"><span>2009-10-19</span></td>
                </tr>
                <tr>
                  <td width="4%" align="left"><span>采购车型</span></td>
                  <td width="12%" align="left"><span>大切诺基BJ2021V8(4.7 自动 四驱)</span></td>
                  <td width="5%" align="left"><span>预计打款日期</span></td>
                  <td width="12%" align="left"><span>2009-10-19</span></td>
                </tr>
                <tr>
                  <td width="5%" align="left"><span>外饰颜色</span></td>
                  <td width="12%" align="left"><span>红</span></td>
                  <td width="4%" align="left"><span>采购总额</span></td>
                  <td width="12%" align="left"><span>5090万</span></td>
                </tr>
                <tr>
                  <td width="5%" align="left"><span>导入VIN号</span></td>
                  <td width="12%" align="left"><input type="file" name="browse"id="browse" class="file_2000" />
                      <input name="button" type="button" class="Submit" style="width:100px" value="导入"/>                  </td>
                </tr>
              </tbody>
            </table>
			
	        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_table">
              <thead class="thead">
                <tr>
                  <th width="5%">序号</th>
                  <th width="9%">vin号</th>
                  <th width="16%">车辆简码</th>
                  <th width="11%">发动机号</th>
                  <th width="11%">外饰颜色</th>
                  <th width="9%">未导入成功原因</th>
                </tr>
              </thead>
              <tbody class="tbody">
                <tr>
                  <td>1</td>
                  <td>1J4GA59128L544704</td>
                  <td>544704</td>
                  <td>DAS324K23</td>
                  <td>红</td>
                  <td>VIN号已存在</td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>1J4GA59128L544704</td>
                  <td>544704</td>
                  <td>DAS324K23</td>
                  <td>红</td>
				  <td>VIN号已存在</td>
                </tr>
                <tr>
                  <td>3</td>
                  <td>1J4GA59128L544704</td>
                  <td>544704</td>
                  <td>DAS324K23</td>
                  <td>红</td>
				  <td>VIN号已存在</td>
                </tr>
                <tr>
                  <td>4</td>
                  <td>1J4GA59128L544704</td>
                  <td>544704</td>
                  <td>DAS324K23</td>
                  <td>蓝</td>
				  <td>VIN号已存在</td>
                </tr>
                <tr>
                  <td>5</td>
                  <td>1J4GA59128L544704</td>
                  <td>544704</td>
                  <td>DAS324K23</td>
                  <td>红</td>
				  <td>VIN号已存在</td>
                </tr>
                <tr>
                  <td>6</td>
                  <td>1J4GA59128L544704</td>
                  <td>544704</td>
                  <td>DAS324K23</td>
                  <td>红</td>
				  <td>VIN号已存在</td>
                </tr>
                <tr>
                  <td>7</td>
                  <td>1J4GA59128L544704</td>
                  <td>544704</td>
                  <td>DAS324K23</td>
                  <td>红</td>
				  <td>VIN号已存在</td>
                </tr>
                <tr>
                  <td>8</td>
                  <td>1J4GA59128L544704</td>
                  <td>544704</td>
                  <td>DAS324K23</td>
                  <td>红</td>
				  <td>VIN号已存在</td>
                </tr>
                <tr>
                  <td>9</td>
                  <td>1J4GA59128L544704</td>
                  <td>544704</td>
                  <td>DAS324K23</td>
                  <td>红</td>
				  <td>VIN号已存在</td>
                </tr>
              </tbody>
            </table></td>
    <td background="../images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="../images/mail_leftbg.gif"><img src="../images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="../images/buttom_bgs.gif"><img src="../images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="../images/mail_rightbg.gif"><img src="../images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
页面要求：<br />
1.基本数据是采购单的数据。<br />
2.导入成功后汽车VIN号、VIN号后六位、车型编码、颜色代码、发动机号、采购价格、汽车采购单保存入数据库，这是一辆汽车的基本数据。<br />
3.导入失败后，将导入失败的，需要给出失败原因。
</body>
</html>