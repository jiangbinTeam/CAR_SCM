var monthArray=["һ��","����","����","����","����","����","����","����","����","ʮ��","ʮһ��","ʮ����"];
var weekArray=["��","һ","��","��","��","��","��"];
$.fn.makeDate=function(){
	this.each(function(){
			$(this).datepicker({
				showOn:'button',
				buttonImage:'../images/calendar.gif',
				buttonImageOnly:true,
				duration:"fast",
				navigationAsDateFormat:true,
				altFormat:"yy-mm-dd",
				dateFormat:"yy-mm-dd",
				changeMonth:true,
				changeYear:true,
				monthNamesShort:monthArray,
				dayNamesMin:weekArray,
				firstDay:1
				});
			//$(this).addClass("date");
		})
	};