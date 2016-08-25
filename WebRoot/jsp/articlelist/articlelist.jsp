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

<title>文章列表</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/pagenav1.1.min.js"></script>
<script type="text/javascript" src="js/articlelist/articlelist.js"></script>

<link rel="stylesheet" type="text/css"
	href="css/articlelist/articlelist.css">

</head>
<body>
	<div id="top">
		<div id="top-bottom">
			<div id="top-title">
				<div firstcategoryid="top-bottom-firstpage" class="top-bottom-title"
					onclick="titleChoice(this)"
					onmouseout="this.style.backgroundColor=''"
					onmouseover="this.style.backgroundColor='red';this.style.cursor='hand';">首页</div>
				<div id="top-title-firstcategory"></div>
			</div>
		</div>
	</div>
	<div id="center">
		<div id="center-left">
			<div id="center-left-article"></div>
			<!-- page -->
			<div id="pageNavBorder">
				<div id="pageNav"></div>
			</div>
		</div>
		<div id="center-right">
			<jsp:include page="/jsp/index-center-right.jsp"></jsp:include>
		</div>
	</div>
	<%@ include file="/jsp/bottom.jsp"%>
	<div>
		<%@ include file="/jsp/share/jiathis.jsp" %>
	</div>
</body>
</html>
