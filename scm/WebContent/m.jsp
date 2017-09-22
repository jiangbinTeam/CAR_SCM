<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css">
<script>
 $(function() {
   $( "#dialog-confirm" ).dialog({
	 autoOpen: true,
     resizable: false,
     height:140,
     modal: true,
//按钮
     buttons: {
       "取消": function() {
//关闭按钮
         $( this ).dialog( "close" );
       },
       "确定": function() {
         $( this ).dialog( "close" );
alert("确定");
       },
  "删除": function() {
         $( this ).dialog( "close" );
alert("删除");
       }
     }
   });
   $("a[name='storage']").click(function(){
		 alert("1111");
		$('#dialog-confirm').dialog('open');
			return false;
	 });
 });
 </script>
</head>
<body>
<a href="#" style="color:#000099" name="storage">入库</a>
<div id="dialog-confirm" title="jquery ui演示弹出层">
 <p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>jquery ui弹出层内容测试中</p>
</div>
<p>jquery ui弹出层使用</p>
</body>
</html>