<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/show-pictures.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/show-pictures.js"></script>


<div id="show-pictures">
	<div id="show-pictures-page">
		<c:forEach items="${showPicturesList}" var="picture" varStatus="status">
			<div class="show-pictures-page" onmouseover="showPicturesChange(this)" name="${picture.name}" page="${status.count}"><font>${status.count}</font></div>
		</c:forEach>
	</div>
</div>


