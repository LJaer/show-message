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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jqwidgets-4.1.2/jqxbuttons.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jqwidgets-4.1.2/jqxwindow.js"></script>
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
								<li id="secondcategorymanager" item-expanded='true'><img
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
	<div id="admin-right">
		<!-- 修改用户密码 -->
		<div id="editUser">
			<form action="/show-message/updateUser" method="post">
				<table id="editUser-table">
					<tr>
						<td>用户名：</td>
						<td><input name="name" id="editUser-table-username"
							readOnly="true"></td>
					</tr>
					<tr>
						<td>旧密码：</td>
						<td><input name="password" type="password" id="password-old" /></td>
					</tr>
					<tr>
						<td>新密码:</td>
						<td><input name="password" type="password" id="password-new1" /></td>
					</tr>
					<tr>
						<td>新密码:</td>
						<td><input name="password" type="password" id="password-new2" /></td>
					</tr>
				</table>
			</form>
			<input type="submit" onclick="updateUser()">
		</div>
		<!-- 一级分类管理 -->
		<div id="firstCategoryManager">
			<input type="button" value="新增一级分类" id='addFirstCategoryManager' />
			<div id="firstCategoryTable"></div>
		</div>
		
		<div id="addFirstCategoryWindow">
			<div id="addFirstCategoryWindow-header">
				<span>
					<img src="http://www.jqwidgets.com/jquery-widgets-demo/images/movie.png" alt="" style="margin-right: 15px" />
					新增一级分类
				</span>
			</div>
			<div id="addFirstCategoryWindow-content">
				<table id="addFirstCategoryTable">
					<tr>
						<td>名称：</td>
						<td>
							<input>
						</td>
					</tr>
					<tr>
						<td>图片:</td>
						<td>
							<input type="button" value="选择图片" id="choiceFirstCategoryImg">
						</td>
					</tr>
				</table>
			</div>
		</div>
		
	</div>
</body>

</html>











