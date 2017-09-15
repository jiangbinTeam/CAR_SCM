$(function(){
	loadDept();

	$("#cha").on("click",function(){
		var k3="k3";
		var dp=$("#sec1").val();
		$.get("chashan",{"action":k3,"deptno":dp},function(data){
			if($("#tab1").length>0){
				$("#tab1").remove();
			}
			
			var $tab1=$("<table border='1' id='tab1'></table>");
			//将表格添加到层div3
			$("#dv1").append($tab1);
			var b=0;
			var id="id";
			var k2="k2";
			var $tr1=$("<tr style='background-color:pink;'><th>员工编号</th><th>员工姓名</th><th>工作种类</th><th>月薪</th>" +
					"<th>入职时间</th><th>奖金</th><th>工作部门</th><th>操作</th></tr>");
			$tab1.append($tr1);
			$.each(data,function(){
				b+=1;
				id+=b;
				var $tt=$("<tr id='"+this.empno+"'><td>"+this.empno+"</td>"+"<td>"+this.ename+"</td>"+
						"<td>"+this.job+"</td>"+"<td>"+this.sal+"</td>"
						+"<td>"+this.hiredate+"</td>"+"<td>"+this.comm+"</td>"
						+"<td>"+this.deptno+"</td>"+
						"<td><input type='button' value='删除' id="+id+"></td>"+"</tr>");
				var gg=this.empno;
				$("#tab1").append($tt);
				//给每个删除按钮添加click事件
				$("#"+id).on("click",function(){
					if(confirm("确定删除？")){
					$.get("chashan",{"action":k2,"empno":gg},function(data){				     
						if(data.suc){
							$("#"+gg).remove();}
					},"json");
					
					}
				});//ss
			});
			bt();
			
		},"json");
		
		
	});
	
	
	function bt(){
		var content="#tab1 tr:not(:first)";
		//斑马线效果
		$(content+":even").css("background","#ccc");
		
		//光棒效果
		var bgColor=undefined;
		$(content).mouseover(function(){
			bgColor=$(this).css("background-color");
			$(this).css("background-color","yellow");
		}).mouseout(function(){
			$(this).css("background-color",bgColor);
		});
}
});
function loadDept(){
	
	var k1="k1";
	$.get("chashan",{"action":k1},function(data){
		$.each(data,function(){
			
			var op=$("<option value='"+this.deptno+"'>"+this.deptName+"</option>");
			$("#sec1").append(op);
		});
	},"json");
	
}