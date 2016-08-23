$(document).ready(function(){
	appInit();//应用初始化
});

//应用初始化
function appInit(){
	tick();//日期初始化
	delCookie("firstcategoryid","");
	$(".goArticleDetail").jqxButton({ width: 60, height: 25 });
}

//转向articledetail页面
function goArticleDetail(obj){
	var articleid = $(obj).attr("articleid");
	//根据articleid查询firstcategory，并存入cookie
	queryFirstCategory(articleid);
}

//根据articleid查询firstcategory，并存入cookie
function queryFirstCategory(articleid){
	$.post(
		'/show-message/queryFirstCategoryByArticleId.action',
		{
			articleid:articleid
		},
		function(data){
			var firstcategoryid = data.id;
			setCookie("firstcategoryid",firstcategoryid);
			var pathName=window.document.location.pathname; 
			var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);  
			window.location.href= projectName+'/articleDetail.action?articleId='+articleid;
		}
	);
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