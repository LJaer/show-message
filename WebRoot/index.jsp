<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  	<div id="index-top"><%@ include file="jsp/top.jsp"%></div>
  	<div id="index-center">center</div>
  	<div id="index-bottom">bottom</div>
  <body>
  	
  </body>
</html>
