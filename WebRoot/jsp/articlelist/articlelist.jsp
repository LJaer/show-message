<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>文章列表</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/articlelist/articlelist.js"></script>

<link rel="stylesheet" type="text/css"
	href="css/articlelist/articlelist.css">

</head>
<body>
	<div id="top">
		<div id="top-top">
			今天是：<SPAN id="Clock"></SPAN>
		</div>
		<div id="top-center"></div>
		<div id="top-bottom">
			<div id="top-title">
				<div firstcategoryid="top-bottom-firstpage" class="top-bottom-title"
					onclick="titleChoice(this)">首页</div>
				<div id="top-title-firstcategory"></div>
			</div>
		</div>
	</div>
	<div id="center">
		<div id="center-left">
			<c:forEach items="${articleStyle1List}" var="articleStyle1">
				<div class="articlelist-article">
					<a class="articlelist-article-name"
						articleid="${articleStyle1.article.id}"
						onclick="choiceArticle(this)"
						onmouseover="onmouseoverArticle(this)"
						onmouseout="onmouseoutArticle(this)"
						href="${pageContext.request.contextPath}/articleDetail.action?articleId=${articleStyle1.article.id}">${articleStyle1.article.name}</a>
					<img class="articlelist-article-contextimg"
						src="${pageContext.request.contextPath}/${articleStyle1.contextimage}"></img>
					<div class="articlelist-article-context">${articleStyle1.text}</div>
					<div class="articlelist-article-othermsg">所属分类：随心而记 浏览：96次
						评论：0次</div>
				</div>
			</c:forEach>
		</div>

	</div>
</body>
</html>
