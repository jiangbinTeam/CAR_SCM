$(function (){
	$("#cs2").on("click",function(){		
		var username=$("#username").val();
		var password=$("#password").val();
		var verifyCode=$("#code").val();
		//$.post("denglu",{"username":username,"password":password,"verifyCode":verifyCode},function(data){

		$.ajax({
			url:"denglu",
			type:"post",
			data:$("#myform").serialize(),
			dataType:"json",
			success	:function(data){
				alert("sss");
				data=$.parseJSON(data);
				alert(data);
				if(data.match("XY")){
					$("#tdd1").val("验证码错误！")
				}
			}	
		})
			
			/*		if(data.equals("OK")){
			window.location.href("index.jsp"); 
		}
		if(data.equals("XY")){
			$("#tdd1").val("验证码错误！")
		}
	if(data.equals("NO")){
		$("#tdd1").val("用户名或密码错误！")
	    }*/
//},"json");
	});		
	});
	



	
