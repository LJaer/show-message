$(document).ready(function(){
	//初始化导航栏
	initNavigation();
	tick();
});

//初始化导航栏
function initNavigation(){
	var firstcategoryid = getCookie("firstcategoryid");
	$.post(
		'/show-message/queryFirstCategoryList.action',
		function(data){
			var firstCategoryList = data;
			var html = "";
			for (var i = 0; i < firstCategoryList.length; i++) {
				if(firstcategoryid==firstCategoryList[i].id){
					html += "<div firstcategoryid='"+firstCategoryList[i].id+"' onclick='goArticleList(this)' class='top-bottom-title' style='background-color:red'>"+firstCategoryList[i].name+"</div>";
				}else{
					html += "<div firstcategoryid='"+firstCategoryList[i].id+"' onclick='goArticleList(this)' class='top-bottom-title'>"+firstCategoryList[i].name+"</div>";
				}
			}
			$("#top-title-firstcategory").html(html);
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

//Cookies操作
function setCookie(name,value)
{
  var Days = 30; //此 cookie 将被保存 30 天
  var exp  = new Date();    //new Date("December 31, 9998");
  exp.setTime(exp.getTime() + Days*24*60*60*1000);
  document.cookie = name + "="+ escape(value) +";expires="+ exp.toGMTString();
}
function getCookie(name)
{
  var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
  if(arr != null) return unescape(arr[2]); return null;
}
function delCookie(name)
{
  var exp = new Date();
  exp.setTime(exp.getTime() - 1);
  var cval=getCookie(name);
  if(cval!=null) document.cookie=name +"="+cval+";expires="+exp.toGMTString();
}











