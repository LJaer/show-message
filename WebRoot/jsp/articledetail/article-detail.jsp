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
<link rel="shortcut icon" href="${pageContext.request.contextPath}/pictures/logo/favicon.ico" type="image/x-icon" />
<base href="<%=basePath%>">

<title>文章详情</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/articledetail/articledetail.js"></script>
<script type="text/javascript" src="js/share/sharemethod.js"></script>

<link rel="stylesheet" type="text/css"
	href="css/articledetail/articledetail.css">

</head>
<body>
	<%@ include file="/jsp/top.jsp"%>
	<div id="articledetail-center">
		<div id="articledetail-center-left">
			<c:out value="${article.name}" />
			<c:out value="${article.html}" escapeXml="false" />
		</div>
		<div id="articledetail-center-right">
			<jsp:include page="/jsp/index-center-right.jsp"></jsp:include>
		</div>
	</div>
	<%@ include file="/jsp/bottom.jsp"%>
	<div>
		<%@ include file="/jsp/share/jiathis.jsp" %>
	</div>
</body>
</html>
