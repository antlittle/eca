<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path+ "/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录界面</title>
<!--------------------------------------------------------------------------------->
<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/user/login.css">
<script src="<%=basePath%>js/user/login.js"></script>
<!-------------------------------------------z-------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/toastr.css">
<script src="<%=basePath%>js/toastr.js"></script>
<!--------------------------------------------------------------------------------->
</head>
<body>
<div class="contain center-block">
	<!-- 导航 -->
	<nav id="navbar" class="navbar navbar-default navbar-fixed-top" 
	 style=" background-color: #202a45;">
		<div style="width: auto; float: left; line-height: 78px; margin: 0 0 0 30px; font-size: 30px; color: white;">
			ECA-企业考勤系统</div>
	</nav>
	
	<!-- 左DIV -->
	<div class="left">
		<div class="login-left center-block">
		<h1 style="color: #202a45; font-size: 50px;">用户登录</h1>
		<h2 style="color: #202a45; font-size: 30px;"> ——<B> 企业考勤系统</B></h2>
	<br>
	<!-- 输入组 -->
		<div class="login-input-area ">
			<div class="input-group input-group-lg" >
			  	<span class="input-group-addon" id="basic-addon1" style="color: #202a45;"><span class=" glyphicon glyphicon-user "></span> 账户：</span>
			 	<input id="login_username" type="text" class="form-control"  placeholder="请输入用户名">
			</div>
	<br>
			<div class="input-group input-group-lg">
				<span class="input-group-addon" id="basic-addon2" style="color: #202a45;"><span class="glyphicon glyphicon-lock"></span> 密码：</span>
				<input id="login_password" type="password" class="form-control" placeholder="请输入密码">
			</div>
		</div>
	<br>
	<!-- 按钮组 -->
	 	<div class="login-button" style="left: -10px">
	 		<button style="margin: 10px;" class="btn btn-default btn-lg " onclick="login()">确认登录</button>
	 		<button style="margin: 10px;" class="btn btn-default btn-lg " onclick=$('#login_username,#login_password').val(''),toastr.info("已重置");>重置信息</button>
	 	</div>
	    </div>		
	</div>
	
	<!-- 右DIV -->
	<div class="right">
		<div class="login-right center-block">	
			<div class="picture"><img src="<%=basePath%>img/login-bg.png"></div>
		</div>
	</div>
</div>
</body>
</html>