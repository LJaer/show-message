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

<title>首页</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jqwidgets-4.1.2/styles/jqx.base.css"
	type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/share/sharemethod.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/jqwidgets-4.1.2/jqxcore.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jqwidgets-4.1.2/jqxscrollbar.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jqwidgets-4.1.2/jqxbuttons.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jqwidgets-4.1.2/jqxpanel.js"></script>


<link rel="stylesheet" type="text/css" href="css/index.css">

</head>
<body>
	<div id="index-top"><%@ include file="jsp/top.jsp"%></div>
	<div id="index-center"><%@ include file="jsp/index-center.jsp"%></div>
	<div id="index-bottom"><%@ include file="jsp/bottom.jsp"%></div>
	<div>
		<%@ include file="jsp/share/jiathis.jsp" %>
	</div>
</body>
</html>


