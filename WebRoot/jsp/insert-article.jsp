<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>新增文章</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/insert-article.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/insert-article.js"></script>

</head>

<body>

	<form action="insertArticle.action" method="post">
		<label>名称:</label> <input type="text" name="name" /><br> <label>所属分类</label><br>
		<label>一级分类:</label>
		<select id="insert-article-firstcategorylist" onchange="insertArticleFirstCategoryChange()"></select>
		<label class="insert-article-secondcategory">二级分类:</label>
		<select id="insert-article-secondcategorylist" class="insert-article-secondcategory" onchange="recordSecondCategoryId()"></select>
		<input type="text" id="insert-article-secondcategoryid" name="secondcategoryid"></input>
		<hr>
		<!-- 配置文件 -->
		<script type="text/javascript" src="ueditor/ueditor.config.js"></script>
		<!-- 编辑器源码文件 -->
		<script type="text/javascript" src="ueditor/ueditor.all.js"></script>
		<!-- 实例化编辑器 -->
		<script type="text/javascript">
			var editor = UE.getEditor('container');
		</script>
		<!-- 加载编辑器的容器 -->
		<script id="container" name="html" type="text/plain">
            这里写你的初始化内容
        </script>
		<input type="submit" value="提交">
	</form>
	
</body>
</html>
