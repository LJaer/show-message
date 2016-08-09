/**
 * 当鼠标移动到文章标题
 * @param obj
 */
function onmouseoverArticle(obj){
	$(obj).css("color","red");
	$(obj).css("cursor",'hand');
}

/**
 * 当鼠标从文章标题移开时
 * @param obj
 */
function onmouseoutArticle(obj){
	$(obj).css("color","");
}

/**
 * 当鼠标点击文章标题时
 * @param obj
 */
function choiceArticle(obj){
	var id = $(obj).attr("articleid");
	
}
