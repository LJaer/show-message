<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/index-lastnew.css">
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/show-pictures.js"></script> --%>


<c:forEach items="${articleStyle1List}" var="articleStyle1">
	<div class="lastnew">
		<img class="lastnew-category-logo" src="${articleStyle1.secondcategoryimage}"></img>
		<label class="lastnew-title">${articleStyle1.name}</label>
		<img class="lastnew-pic" src="${articleStyle1.contextimage}"></img>
		<div class="lastnew-context">${articleStyle1.text}</div>
		<div class="lastnew-othermsg">发表日期：${articleStyle1.time}&nbsp;&nbsp;浏览：${articleStyle1.browse}次&nbsp;&nbsp;评论：${articleStyle1.review}&nbsp;&nbsp;阅读全文</div>
	</div>
</c:forEach>

