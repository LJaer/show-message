$(document).ready(function(){
	appInit();//应用初始化
});

//应用初始化
function appInit(){
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

