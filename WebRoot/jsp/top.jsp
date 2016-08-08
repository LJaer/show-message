<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/top.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/top.js"></script>

<div id="top">
	<div id="top-top">
		今天是：<SPAN id="Clock"></SPAN>
	</div>
	<div id="top-center"></div>
	<div id="top-bottom">
		<div id="top-title">
			<div firstcategoryid="top-bottom-firstpage" class="top-bottom-title" onclick="titleChoice(this)" style="background-color:red">首页</div>
			<div id="top-title-firstcategory"></div>
		</div>
	</div>
</div>

