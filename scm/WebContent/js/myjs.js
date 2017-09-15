var monthArray=["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"];
var weekArray=["日","一","二","三","四","五","六"];
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