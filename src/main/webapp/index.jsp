<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link href="/resource/bootstrap/css/bootstrap.css" rel="stylesheet">  
 <script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script> 
 <script type="text/javascript" src="/resource/bootstrap/js/bootstrap.js"></script>
 <title>有花堪折直须折</title>
<style type="text/css">
	.menu li{
		font-size:26px;
		text-align:center;
	}
	.menu li:hover{
		background:gray;
	}
	
	
</style>

</head>

<body>
<audio src="/resource/audio/jmszl.mp3"  autoplay="autoplay"> </audio>	
<bgsound src="/resource/audio/jmszl.mp3" loop="-1">

</head>

<body>
<audio src="/resource/audio/jmszl.mp3" id="aud" autoplay="autoplay" controls="controls" preload="auto"></audio>
<audio autoplay="" loop=""><source src="/resource/audio/jmszl.mp3"></audio>
<!-- 导航条 -->
<nav class="navbar navbar-default">
 
  	
  	<!-- logo -->
  	<div class="navbar-header">
      <a class="navbar-brand" href="#">
        <img alt="Brand" src="/resource/images/logo.png">
      </a>
      
      
      
    </div>
    
      <form class="navbar-form"  style="float:none;text-align:center;">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      
    <!-- 搜索框和右侧登录信息 -->
    <div class="collapse navbar-collapse" style="float:none;text-align:right;"  id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        
      </ul>
      
    
      
      <ul class="nav navbar-nav navbar-right" >
        <li><a href="#"><img width="40px" height="40px" src="/resource/img/577cb4b220fab.jpg"/> </a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
          		张三 <span class="caret"></span></a>
          <ul class="dropdown-menu ">
            <li><a href="#">个人中心</a></li>
            <li><a href="#">个人设置</a></li>
            <li><a href="#">修改头像</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">退出登录</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
    
 
</nav>

<div class="container-fluid" >
	<div class="container" style="minheight:200px" margin-top:20px">
		<div class="row">
			<!-- 左侧菜单 -->
			<div class="col-md-2" style="max:200px;margin-top:20px" >
				
					<ul class="list-group menu">
						<li class="list-group-item active" >热门文章</li>
						<c:forEach items="${channels}" var="channel" varStatus="index">
					    	<li class="list-group-item" data="/indexchn?id=${channel.id}">${channel.name}</li>
					    </c:forEach>
					</ul>
			</div>
			
			<!-- 中间的内容 -->
			<div class="col-md-8" style="background:white;minheight:200px" >
				<div>
						<hr>
						
				</div>
				
				<div id="myCarousel" class="carousel slide" style="minheight:200px">
						<!-- 轮播（Carousel）指标 -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
						</ol>   
						<!-- 轮播（Carousel）项目 -->
						<div class="carousel-inner">
							<div class="item active">
								<img height="300px" src="/resource/img/5785ae6027ecf.jpg" alt="First slide">
							</div>
							<div  class="item">
								<img height="300px" src="/resource/img/565e8fd37714a.jpg" alt="Second slide">
							</div>
							<div class="item">
								<img height="300px" src="/resource/img/57b28699235ca.jpg" alt="Third slide">
							</div>
						</div>
						<!-- 轮播（Carousel）导航 -->
						<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
							<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a>
						<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
					</div>
					
					<!-- 放文章的列表 -->
					<div >
						<c:forEach items="${hotList.list}" var="article" >
						<div class=row>
							<hr>
							<div class="col-md-2"><img height="80px" width="80px" src="/pic/${article.picture}"></div>
							<div class="col-md-10">
								<a href="javascript:showArticle(${article.id})">${article.title}</a>
								<br>
								 频道：<a>${article.channel.name}</a> &nbsp;&nbsp;
								 分类：<a>${article.category.name}</a>
								<br>
								<br>
								${article.user.username} 发布于  <fmt:formatDate value="${article.created}" pattern="yyyy-MM-dd"/> 
							</div>
							
						</div>
						</c:forEach>
						<div class="row">
							<ul class="pagination">
								    <li><a href="/index?page=${hotList.prePage}">&laquo;</a></li>
								    <c:forEach begin="${hotList.pageNum-2 > 1 ? hotList.pageNum-2:1}" end="${hotList.pageNum+2 > hotList.pages ? hotList.pages:hotList.pageNum+2}" varStatus="index">    		
								    	<c:if test="${hotList.pageNum!=index.index}">
								    		<li><a href="/index?page=${index.index}">${index.index}</a></li>
								    	</c:if>
								    	<c:if test="${hotList.pageNum==index.index}">
								    		<li><a href="/index?page=${index.index}"><strong> ${index.index} </strong> </a></li>
								    	</c:if>
								    	
								    </c:forEach>
								    <li><a href="/index?page=${hotList.nextPage}">&raquo;</a></li>
								</ul>
						</div>
					</div>
					 
			</div>
			<!-- 中间的内容结束 -->
			
			
			<div class="col-md-2" style="minheight:200px" >
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">面板标题</h3>
					</div>
					<div class="panel-body">
						这是一个基本的面板
					</div>
				</div>
				
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">最新文章</h3>
					</div>
					<div class="panel-body">
						<c:forEach items="${newArticles}" var="article" varStatus="index">
							${index.index+1} . <a>${article.title}</a>
							<br/>
						</c:forEach>
					</div>
				</div>
			
			</div>
		</div>
		
	</div>

</div>



<!-- 底部 -->
<nav class="navbar navbar-default">
  <div class="container-fluid">
  </div>
</nav>
<script type="text/javascript" src="/resource/js/cms_index.js"></script>


</body>
</html>