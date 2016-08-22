var pageFlag = 1;//记录是否已经初始化pagenav


$(document).ready(function() {
	// 初始化导航栏
	initNavigation();
	tick();
	// 初始化文章
	initArticle(1);
});

// 初始化导航栏
function initNavigation() {
	var firstCategoryId = getCookie("firstcategoryid");
	$
			.post(
					'/show-message/queryFirstCategoryList.action',
					function(data) {
						var firstCategoryList = data;
						var html = "";
						for (var i = 0; i < firstCategoryList.length; i++) {
							if (firstCategoryId == firstCategoryList[i].id) {
								html += "<div firstcategoryid='"
										+ firstCategoryList[i].id
										+ "' onclick='goArticleList(this)' class='top-bottom-title' style='background-color:red'  onmouseover='this.style.backgroundColor=\"red\";this.style.cursor=\"hand\"'>"
										+ firstCategoryList[i].name + "</div>";
							} else {
								html += "<div firstcategoryid='"
										+ firstCategoryList[i].id
										+ "' onclick='goArticleList(this)' class='top-bottom-title' onmouseout='this.style.backgroundColor=\"\"' onmouseover='this.style.backgroundColor=\"red\";this.style.cursor=\"hand\"' >"
										+ firstCategoryList[i].name + "</div>";
							}
						}
						$("#top-title-firstcategory").html(html);
					});
}

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
									+ "</div><div class='articlelist-article-othermsg'>所属分类：随心而记 浏览：96次评论：0次</div></div>";
						}
						$("#center-left-article").html(html);
						initPageNav(data.page,data.totalPage);
					});
}

// 文章列表
function goArticleList(obj) {
	pageFlag = 1;
	var firstcategoryid = $(obj).attr("firstcategoryid");
	setCookie("firstcategoryid", firstcategoryid);
	initArticle(1);
	initNavigation();
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

function titleChoice(obj) {
	$(".top-bottom-title").css("background-color", "");
	$(obj).css("background-color", 'red');
	window.location = "/show-message/index.jsp";
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

// Cookies操作
function setCookie(name, value) {
	var Days = 30; // 此 cookie 将被保存 30 天
	var exp = new Date(); // new Date("December 31, 9998");
	exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
	document.cookie = name + "=" + escape(value) + ";expires="
			+ exp.toGMTString();
}
function getCookie(name) {
	var arr = document.cookie
			.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
	if (arr != null)
		return unescape(arr[2]);
	return null;
}
function delCookie(name) {
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval = getCookie(name);
	if (cval != null)
		document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}
