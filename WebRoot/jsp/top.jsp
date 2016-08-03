<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/top.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/top.js"></script>

<div id="top">
	<div id="top-top">
		今天是：<SPAN id="Clock"></SPAN>
	</div>
	<div id="top-center"></div>
	<div id="top-bottom">
		<div id="top-title">
			<div id="top-bottom-firstpage" class="top-bottom-title" onclick="titleChoice(this)" onmouseout="titleOnmouseout(this)" onmouseover="titleOnmouseover(this)" >首页</div>
			<c:forEach items="${firstCategoryList}" var="firstCategory">
				<div id="top-bottom-page${firstCategory.id}" class="top-bottom-title" onmouseout="titleOnmouseout(this)" onmouseover="titleOnmouseover(this)">${firstCategory.name }</div>
			</c:forEach>
		</div>
	</div>
</div>

