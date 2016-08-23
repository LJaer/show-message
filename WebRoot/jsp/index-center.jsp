<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/index-center.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index-center.js"></script>

<div id="index-center-left">
	<div id="index-center-left-pic">
		<jsp:include page="/queryShowPictures.action"></jsp:include>
	</div>
	<div id="index-center-left-lastnew">
		<jsp:include page="/queryLastArticle.action"></jsp:include>
	</div>
	<div id="index-center-left-lastnew2">
		<jsp:include page="/queryLastArticle2.action"></jsp:include>
	</div>
</div>
<div id="index-center-right">
	<jsp:include page="/jsp/index-center-right.jsp"></jsp:include>
</div>

