$(document).ready(function(){
	//初始化导航栏
	initNavigation();
	tick();
});

//初始化导航栏
function initNavigation(){
	$.post(
		'/show-message/queryFirstCategoryList.action',
		function(data){
			var firstCategoryList = data;
			var html = "";
			for (var i = 0; i < firstCategoryList.length; i++) {
				html += "<div firstcategoryid='"+firstCategoryList[i].id+"' onclick='goArticleList(this)' class='top-bottom-title'>"+firstCategoryList[i].name+"</div>";
			}
			$("#top-title-firstcategory").html(html);
		}
	);
}


//文章列表
function goArticleList(obj){
	$(".top-bottom-title").css("background-color","");
	$(obj).css("background-color","red");
	var firstcategoryid = $(obj).attr("firstcategoryid");
	$.post(
		'/show-message/queryArticleList.action',
		{
			firstcategoryid:firstcategoryid,
			secondcategoryid:-1,
			page:1
		},
		function(data){
			$("#index-center-left").html(data);
		}
	);
}

function tick() {
	var years, months, days, hours, minutes, seconds;
	var intYears, intMonths, intDays, intHours, intMinutes, intSeconds;
	var today;
	today = new Date(); // 系统当前时间
	intYears = today.getFullYear(); // 得到年份,getFullYear()比getYear()更普适
	intMonths = today.getMonth() + 1; // 得到月份，要加1
	intDays = today.getDate(); // 得到日期
	intHours = today.getHours(); // 得到小时
	intMinutes = today.getMinutes(); // 得到分钟
	intSeconds = today.getSeconds(); // 得到秒钟
	years = intYears + "年";
	if (intMonths < 10) {
		months = "0" + intMonths + "月";
	} else {
		months = intMonths + "月";
	}
	if (intDays < 10) {
		days = "0" + intDays + "日";
	} else {
		days = intDays + "日";
	}
	if (intHours == 0) {
		hours = "00:";
	} else if (intHours < 10) {
		hours = "0" + intHours + ":";
	} else {
		hours = intHours + ":";
	}
	if (intMinutes < 10) {
		minutes = "0" + intMinutes + ":";
	} else {
		minutes = intMinutes + ":";
	}
	if (intSeconds < 10) {
		seconds = "0" + intSeconds + " ";
	} else {
		seconds = intSeconds + " ";
	}
	timeString = years + months + days + hours + minutes + seconds;
	$("#Clock").html(timeString);
	window.setTimeout("tick();", 1000);
}

function titleChoice(obj){
	$(".top-bottom-title").css("background-color","");
	$(obj).css("background-color",'red');
	 window.location="/show-message/index.jsp"; 
}











