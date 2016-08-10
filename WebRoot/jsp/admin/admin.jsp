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

<title>后台管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<!-- <script type="text/javascript" src="js/index.js"></script> -->

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/admin.css">

</head>
<body>
	<div id="admin-left">
		<div id="personInfor">
			<div id="username-title">用户名：</div><div id="username-value">${user.name}</div>
			<div id="signout">登出</div>
		</div>
	</div>
</body>
</html>
