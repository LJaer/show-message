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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jqwidgets-4.1.2/jqxcore.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jqwidgets-4.1.2/jqxtree.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jqwidgets-4.1.2/styles/jqx.base.css"
	type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/admin/admin.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/admin/admin.css">

</head>
<body>
	<div id="admin-left">
		<div id="personInfor">
			<div id="username-title">用户名：</div>
			<div id="username-value">${user.name}</div>
			<div id="signout">登出</div>
		</div>
		<div style="border: none;" id='jqxTree'>
			<ul>
				<li id="systemmanager" item-expanded='true'><img
					style='float: left; margin-right: 5px;'
					src='http://www.jqwidgets.com/jquery-widgets-demo/images/folder.png' /><span
					item-title="true">系统管理</span>
					<ul>
						<li id="usermanager" item-expanded='true'><img
							style='float: left; margin-right: 5px;'
							src='http://www.jqwidgets.com/jquery-widgets-demo/images/folder.png' /><span
							item-title="true">用户管理</span>
							<ul>
								<li id="updateUser" item-expanded='true'><img
									style='float: left; margin-right: 5px;'
									src='http://www.jqwidgets.com/jquery-widgets-demo/images/folder.png' /><span
									item-title="true">修改密码</span></li>
							</ul></li>
						<li id="categorymanager" item-expanded='true'><img
							style='float: left; margin-right: 5px;'
							src='http://www.jqwidgets.com/jquery-widgets-demo/images/folder.png' /><span
							item-title="true">分类管理</span>
							<ul>
								<li id="firstcategorymanager" item-expanded='true'><img
									style='float: left; margin-right: 5px;'
									src='http://www.jqwidgets.com/jquery-widgets-demo/images/folder.png' /><span
									item-title="true">一级分类管理</span></li>
								<li id="firstcategorymanager" item-expanded='true'><img
									style='float: left; margin-right: 5px;'
									src='http://www.jqwidgets.com/jquery-widgets-demo/images/folder.png' /><span
									item-title="true">二级分类管理</span></li>
							</ul></li>
						<li id="articlemanager" item-expanded='true'><img
							style='float: left; margin-right: 5px;'
							src='http://www.jqwidgets.com/jquery-widgets-demo/images/folder.png' /><span
							item-title="true">文章管理</span>
							<ul>
								<li id="firstcategory" item-expanded='true'><img
									style='float: left; margin-right: 5px;'
									src='http://www.jqwidgets.com/jquery-widgets-demo/images/folder.png' /><span
									item-title="true">一级分类</span>
									<ul>
										<li id="secondcategory" item-expanded='true'><img
											style='float: left; margin-right: 5px;'
											src='http://www.jqwidgets.com/jquery-widgets-demo/images/folder.png' /><span
											item-title="true">二级分类</span></li>
										<li id="secondcategory" item-expanded='true'><img
											style='float: left; margin-right: 5px;'
											src='http://www.jqwidgets.com/jquery-widgets-demo/images/folder.png' /><span
											item-title="true">二级分类</span></li>
										<li id="secondcategory" item-expanded='true'><img
											style='float: left; margin-right: 5px;'
											src='http://www.jqwidgets.com/jquery-widgets-demo/images/folder.png' /><span
											item-title="true">二级分类</span></li>
									</ul></li>
								<li id="firstcategory" item-expanded='true'><img
									style='float: left; margin-right: 5px;'
									src='http://www.jqwidgets.com/jquery-widgets-demo/images/folder.png' /><span
									item-title="true">一级分类</span></li>
								<li id="firstcategory" item-expanded='true'><img
									style='float: left; margin-right: 5px;'
									src='http://www.jqwidgets.com/jquery-widgets-demo/images/folder.png' /><span
									item-title="true">一级分类</span></li>
							</ul></li>
					</ul></li>
			</ul>
		</div>
	</div>
</body>

</html>