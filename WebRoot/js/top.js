$(document).ready(function() {
	// 初始化导航栏
	initNavigation();
});

// 初始化导航栏
function initNavigation() {
	$.post(
		'/show-message/queryFirstCategoryList.action',
		function(data) {
			var firstCategoryList = data;
			var html = "";
			for (var i = 0; i < firstCategoryList.length; i++) {
				html += "<div firstcategoryid='"
						+ firstCategoryList[i].id
									+ "' onclick='goArticleList(this)' class='top-bottom-title' onmouseout='this.style.backgroundColor=\"\"' onmouseover='this.style.backgroundColor=\"red\"' > "
						+ firstCategoryList[i].name + "</div>";
			}
			$("#top-title-firstcategory").html(html);
		}
	);
}

// 文章列表
function goArticleList(obj) {
	var firstcategoryid = $(obj).attr("firstcategoryid");
	setCookie("firstcategoryid", firstcategoryid);
	var pathName=window.document.location.pathname; 
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);  
	window.location.href = projectName+"/ArticleList";
}

function titleChoice(obj) {
	$(".top-bottom-title").css("background-color", "");
	$(obj).css("background-color", 'red');
	window.location = "/show-message/index.jsp";
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
