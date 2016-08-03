//点击数字切换图片
function indexCenterLeftPicChange(obj){
	$(".index-center-left-pic-page").css("background-color","");
	var page = $(obj).attr("page");
	$(obj).css("background-color","red");
	$("#index-center-left-pic").css("background-image","url(pictures/showImg/"+page+".jpg)");
}