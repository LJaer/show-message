$(document).ready(function(){
	appInit();//应用初始化
});

//应用初始化
function appInit(){
	tick();//日期初始化
	dataInit();//数据初始化
}

//数据初始化
function dataInit(){
	$.post(
		'queryFirstCategoryList.action'
	);
}