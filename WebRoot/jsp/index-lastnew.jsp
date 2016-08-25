<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/index-lastnew.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index-lastnew.js"></script>

<div id="lastnews">

<c:forEach items="${articleStyle1List}" var="articleStyle1">
	<div class="lastnew" >
		<img class="lastnew-category-logo"
			src="${articleStyle1.secondcategoryimage}"></img> <label
			class="lastnew-title pointerHand"
			articleid="${articleStyle1.article.id}"
			onclick="goArticleDetail(this)" onmouseover="this.style.color='red';"
			onmouseout="this.style.color='';">${articleStyle1.article.name}</label>
		<br /> <br />
		<c:if test="${articleStyle1.contextimage!=null}">
			<img class="lastnew-pic"
				src="${articleStyle1.contextimage}"></img>
		</c:if>
		<c:if test="${articleStyle1.contextimage==null}">
			<img class="lastnew-pic"
				src="${pageContext.request.contextPath}/pictures/nopicture.png"></img>
		</c:if>
		<div class="lastnew-context">${articleStyle1.text}</div>
		<div class="lastnew-othermsg">
			发表日期：
			<fmt:formatDate value="${articleStyle1.article.time}"
				pattern="yyyy-MM-dd HH:mm:ss" />
			&nbsp;&nbsp;浏览：${articleStyle1.article.browse}次&nbsp;&nbsp;
			<input type="button" articleid="${articleStyle1.article.id}"
				class="pointerHand floatleft goArticleDetail" onmouseover="this.style.color='red';"
				onmouseout="this.style.color='';" onclick="goArticleDetail(this)" value="阅读全文"></input>
		</div>
	</div>
</c:forEach>

</div>



