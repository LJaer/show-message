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

<title>首页</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
<body>
<div id="index-top"><jsp:include page="/queryFirstCategoryList.action"></jsp:include></div>
<div id="index-center"><%@ include file="jsp/index-center.jsp" %>
<p><img src="ueditor/jsp/upload/image/20160804/1470278118744005470.jpg" title="1470278118744005470.jpg" alt="8c3e2bafa40f4bfb63cd7782034f78f0f6361887.jpg" width="373" height="355"/>
 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;??????????
 &nbsp; &nbsp; &nbsp; &nbsp;</p>
</div>
<div id="index-bottom">bottom</div>
</body>
</html>
