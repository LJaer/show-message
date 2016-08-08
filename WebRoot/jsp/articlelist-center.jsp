<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/articlelist-center.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/articlelist-center.js"></script>

<c:forEach items="${articleStyle1List}" var="articleStyle1">
	<div class="articlelist-article">
		<div class="articlelist-article-name">${articleStyle1.article.name}</div>
		<img class="articlelist-article-contextimg"
			src="${pageContext.request.contextPath}/${articleStyle1.contextimage}"></img>
		<div class="articlelist-article-context">${articleStyle1.text}</div>
		<div class="articlelist-article-othermsg">所属分类：随心而记 浏览：96次 评论：0次</div>
	</div>
</c:forEach>



