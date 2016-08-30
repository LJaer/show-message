var pageFlag = 1;//记录是否已经初始化pagenav


$(document).ready(function() {
	// 初始化文章
	initArticle(1);
});

// 初始化文章
function initArticle(page) {
	var firstCategoryId = getCookie("firstcategoryid");
	$
			.post(
					'/show-message/queryArticleListByFirstCategoryIdAndPage',
					{
						firstCategoryId : firstCategoryId,
						page : page
					},
					function(data) {
						var articleStyle1List = data.list;
						var html = "";
						for (var i = 0; i < articleStyle1List.length; i++) {
							var articleStyle1 = articleStyle1List[i];
							html += "<div class='articlelist-article'><a class='articlelist-article-name' articleid='"
									+ articleStyle1.article.id
									+ "' "
									+ "onclick='choiceArticle(this)' onmouseover='onmouseoverArticle(this)' "
									+ "onmouseout='onmouseoutArticle(this)' href='articleDetail.action?articleId="
									+ articleStyle1.article.id 
									+ "'>"
									+ articleStyle1.article.name
									+ "</a> <img class='articlelist-article-contextimg' src='";
							if(articleStyle1.contextimage==null){
								html += "pictures/nopicture.png"; 
							}else{
								html += articleStyle1.contextimage;
							}
								html += "'></img>"
									+ "<div class='articlelist-article-context'>"
									+ articleStyle1.text
									+ "</div><div class='articlelist-article-othermsg'>所属分类：随心而记 浏览："+articleStyle1.article.browse+"次</div></div>";
						}
						$("#center-left-article").html(html);
						initPageNav(data.page,data.totalPage);
					});
}

//初始化分页功能
function initPageNav(page,pageTotal) {
	// pageNav
	// optional set
	pageNav.pre = "上一页";
	pageNav.next = "下一页";
	// goto the page 3 of 33.
	if(pageFlag==1){
		pageNav.go(1, pageTotal);
		pageFlag++;
	}
	 //  p:current page number.  
	 //  pn: page sum.
	pageNav.fn = function(page,pageTotal){
		initArticle(page);
		//$("#test").text("Page:"+p+" of "+pn + " pages."); //for jquery
	};
}

/**
 * 当鼠标移动到文章标题
 */
function onmouseoverArticle(obj) {
	$(obj).css("color", "red");
	$(obj).css("cursor", 'hand');
}

/**
 * 当鼠标从文章标题移开时
 */
function onmouseoutArticle(obj) {
	$(obj).css("color", "");
}

/**
 * 当鼠标点击文章标题时
 */
function choiceArticle(obj) {
	var id = $(obj).attr("articleid");
}


