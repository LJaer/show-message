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
<!-- saved from url=(0049)http://www.jq22.com/demo/bootstrap-moban20150917/ -->
<html lang="ch">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<title>后台管理</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/admin/common.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
</head>

<body>
	<div id="wrap">
		<!-- 左侧菜单栏目块 -->
		<div class="leftMeun" id="leftMeun">
			<div id="logoDiv">
				<p id="logoP">
					<img id="logo" alt="左右结构项目"
						src="${pageContext.request.contextPath}/pictures/admin/logo.png"><span>左右结构项目</span>
				</p>
			</div>
			<div id="personInfor">
				<p id="userName">杨鹏</p><br>
				<p>
					<a>退出登录</a>
				</p>
			</div>
			<div class="meun-title">账号管理</div>
			<div class="meun-item" href="#user" aria-controls="user" role="tab"
				data-toggle="tab">
				<img
					src="${pageContext.request.contextPath}/pictures/admin/icon_user_grey.png">用户管理
			</div>
		</div>
		<!-- 右侧具体内容栏目 -->
		<div id="rightContent">
			<a class="toggle-btn" id="nimei"> <i
				class="glyphicon glyphicon-align-justify"></i>
			</a>
			<!-- Tab panes -->
			<div class="tab-content">
				<!--用户管理模块-->
				<div role="tabpanel" class="tab-pane" id="user">
					<div class="data-div">
						<div class="row tableHeader">
							<div class="col-xs-2 ">用户名</div>
							<div class="col-xs-2">地区</div>
							<div class="col-xs-2">真实姓名</div>
							<div class="col-xs-2">电话</div>
							<div class="col-xs-2">状态</div>
							<div class="col-xs-2">操作</div>
						</div>
						<div class="tablebody">

							<div class="row">
								<div class="col-xs-2 ">goodmoning</div>
								<div class="col-xs-2">国际关系地区</div>
								<div class="col-xs-2">李豆豆</div>
								<div class="col-xs-2">13688889999</div>
								<div class="col-xs-2">状态</div>
								<div class="col-xs-2">
									<button class="btn btn-success btn-xs" data-toggle="modal"
										data-target="#reviseUser">修改</button>
									<button class="btn btn-danger btn-xs" data-toggle="modal"
										data-target="#deleteUser">删除</button>
								</div>
							</div>

						</div>

					</div>
					<!--页码块-->
					<footer class="footer">
					<ul class="pagination">
						<li><select>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
								<option>7</option>
								<option>8</option>
								<option>9</option>
								<option>10</option>
						</select> 页</li>
						<li class="gray">共20页</li>
						<li><i class="glyphicon glyphicon-menu-left"> </i></li>
						<li><i class="glyphicon glyphicon-menu-right"> </i></li>
					</ul>
					</footer>

				</div>
			</div>
</body>
</html>
