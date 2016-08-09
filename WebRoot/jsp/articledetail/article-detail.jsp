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

<title>文章详情</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/articledetail/articledetail.js"></script>

<link rel="stylesheet" type="text/css" href="css/articledetail/articledetail.css">

</head>
<body>
<div id="articledetail-top">
<div id="top">
	<div id="top-top">
		今天是：<SPAN id="Clock"></SPAN>
	</div>
	<div id="top-center"></div>
	<div id="top-bottom">
		<div id="top-title">
			<div firstcategoryid="top-bottom-firstpage" class="top-bottom-title" onclick="titleChoice(this)">首页</div>
			<div id="top-title-firstcategory"></div>
		</div>
	</div>
</div>
</div>
<div id="articledetail-center">
	<div id="articledetail-center-left">
	<c:out value="${article.name}"/>
<c:out value="${article.html}" escapeXml="false" />
	</div>
</div>
</body>
</html>
