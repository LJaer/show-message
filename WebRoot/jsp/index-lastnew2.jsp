<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/index-lastnew2.css">
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/show-pictures.js"></script> --%>

<c:forEach items="${articleStyle2List}" var="articleStyle2">
	<div class="index-lastnew2-category">
		<img class="index-lastnew2-category-categoryimg"
			src="${pageContext.request.contextPath}/${articleStyle2.categoryImgSrc}" />
		<div class="index-lastnew2-category-categoryname pointerHand"
			onmouseover="this.style.color='red'" onmouseout="this.style.color=''"
			firstcategoryid="${articleStyle2.firstCategory.id}"
			onclick="goArticleList(this)">${articleStyle2.firstCategory.name}</div>
		<div class="index-lastnew2-catgory-more pointerHand"
			onmouseover="this.style.color='red'" onmouseout="this.style.color=''"
			onclick="goArticleList(this)"
			firstcategoryid="${articleStyle2.firstCategory.id}">更多</div>
		<br> <br>
		<c:if test="${articleStyle2.firstArticleImg==null}">
			<img class="index-lastnew2-category-contextimg"
				src="${pageContext.request.contextPath}/pictures/nopicture.png">
		</c:if>
		<c:if test="${articleStyle2.firstArticleImg!=null}">
			<img class="index-lastnew2-category-contextimg"
				src="${articleStyle2.firstArticleImg}">
		</c:if>
		<div class="index-lastnew2-category-lastarticle pointerHand"
			onmouseover="this.style.color='red'" onmouseout="this.style.color=''"
			onclick="goArticleDetail(this)"
			articleid="${articleStyle2.articleList[0].id}">${articleStyle2.articleList[0].name}</div>
		<div class="index-lastnew2-category-context">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${articleStyle2.firstArticleContext}</div>
		<hr>
		<c:forEach items="${articleStyle2.articleList}" var="article"
			varStatus="status">
			<c:if test="${status.index!=0}">
				<div class="index-lastnew2-catgory-article">
					<div class="index-lastnew2-category-point"></div>
					<div class="index-lastnew2-category-articlename pointerHand"
						onmouseover="this.style.color='red'"
						onmouseout="this.style.color=''"
						onmouseover="this.style.color='red'"
						onmouseout="this.style.color=''" onclick="goArticleDetail(this)"
						articleid="${article.id}">${article.name}&nbsp;&nbsp;&nbsp;&nbsp;08/05</div>
					<hr>
				</div>
			</c:if>
		</c:forEach>
	</div>
</c:forEach>
