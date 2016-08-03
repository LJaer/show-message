
var CurrentShowPicturesPage = 0;

$(document).ready(function(){
	var randomPage = parseInt(Math.random()*10);//随机一个展示的图片
	CurrentShowPicturesPage=randomPage;
	var page = $(".show-pictures-page")[CurrentShowPicturesPage];
	showPicturesChange(page);
});


//点击数字切换图片
function showPicturesChange(obj){
	$(".show-pictures-page").css("background-color","");
	var name = $(obj).attr("name");
	var page = $(obj).attr("page");
	CurrentShowPicturesPage=page-1;
	$(obj).css("background-color","red");
	$("#show-pictures").css("background-image","url(pictures/showImg/"+name+")");
}

//定时改变展示图片
setInterval(function(){
	var page = $(".show-pictures-page")[CurrentShowPicturesPage];
	showPicturesChange(page);
	CurrentShowPicturesPage++;
	if(CurrentShowPicturesPage>9){
		CurrentShowPicturesPage=0;
	}
},2000);
