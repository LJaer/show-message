$(document).ready(function(){
	//初始化导航栏
	initNavigation();
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
					html += "<div firstcategoryid='"+firstCategoryList[i].id+"' onclick='goArticleList(this)' class='top-bottom-title' style='background-color:red' onmouseover='this.style.cursor=\"hand\"'>"+firstCategoryList[i].name+"</div>";
				}else{
					html += "<div firstcategoryid='"+firstCategoryList[i].id+"' onclick='goArticleList(this)' class='top-bottom-title' onmouseout='this.style.backgroundColor=\"\"' onmouseover='this.style.backgroundColor=\"red\";this.style.cursor=\"hand\"'> "+firstCategoryList[i].name+"</div>";
				}
			}
			$("#top-title-firstcategory").html(html);
		}
	);
}

//文章列表
function goArticleList(obj) {
	var firstcategoryid = $(obj).attr("firstcategoryid");
	setCookie("firstcategoryid", firstcategoryid);
	var pathName=window.document.location.pathname; 
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);  
	window.location.href = projectName+"/ArticleList";
}

function titleChoice(obj){
	$(".top-bottom-title").css("background-color","");
	$(obj).css("background-color",'red');
	var realPath = getRealPath();
	 window.location= realPath+"/index.jsp"; 
}










