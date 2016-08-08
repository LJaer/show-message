<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/index-lastnew2.css">
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/show-pictures.js"></script> --%>

<c:forEach items="${articleStyle2List}" var="articleStyle2">
	<div class="index-lastnew2-category">
		<img class="index-lastnew2-category-categoryimg"
			src="${pageContext.request.contextPath}/${articleStyle2.firstCategory.img}" />
		<div class="index-lastnew2-category-categoryname">${articleStyle2.firstCategory.name}</div>
		<div class="index-lastnew2-catgory-more">更多</div>
		<hr>
		<img class="index-lastnew2-category-contextimg"
			src="${pageContext.request.contextPath}/${articleStyle2.firstArticleImg}">
			<div class="index-lastnew2-category-lastarticle">2016年10月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${articleStyle2.articleList[0].name}</div>
		<div class="index-lastnew2-category-context">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${articleStyle2.firstArticleContext}</div>
		<hr>
		<c:forEach items="${articleStyle2.articleList}" var="article">
			<div class="index-lastnew2-category-point"></div>
			<div class="index-lastnew2-category-articlename">${article.name}&nbsp;&nbsp;&nbsp;&nbsp;08/05</div>
			<hr>
		</c:forEach>
	</div>
</c:forEach>
