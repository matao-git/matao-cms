<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link href="/resource/bootstrap/css/bootstrap.css" rel="stylesheet">  
 <script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script> 
 <script type="text/javascript" src="/resource/bootstrap/js/bootstrap.js"></script>
<title>CMS管理平台</title>
</head>
<body style="background:url(/pic/39.jpg) ">
	
	
	<!-- 导航条 --> 
<nav class="navbar navbar-default" style="background:white">
	<%@include  file="/WEB-INF/view/common/top.jsp"%>
</nav>
<div class="row">
	<div class="col-md-2">
		<div style="margin-left:20px ">
			<ul class="nav nav-pills nav-stacked" id="menu">
			  <li class="active"><a href="javascript:showFuction('/admin/articles')">文章管理</a></li>
			  <li><a href="javascript:showFuction('/admin/users')">用户管理</a></li>
			  <li><a href="#">轮播图管理</a></li>
			  <li><a href="#">公告管理</a></li>
			  <li><a href="#">投票管理</a></li>
			</ul>
		</div>
	</div>
	<div class="col-md-10"  style=" min-height:500px; border-left: solid">
		<div id="content">
			
		</div>
	</div>
</div>
	<nav class="navbar navbar-inverse navbar-fixed-bottom" 
	role="navigation">
	<div align="center"> <font > ----八维大数据学院1707D--- </font> </div>
</nav>
	<script type="text/javascript">
	function showFuction(url){
		//$("#menu").children().removeClass('active');
		//$("li").removeClass('active');
		/* console.log(obj.attr("href"))
		obj.parent().children().removeClass('active');
		obj.addClass('active');  */
		$("#content").load(url)
	}
</script>
	
</body>
</html>