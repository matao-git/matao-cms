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
<title>天涯何处无芳草</title>
</head>
<body >
<!-- 导航条 -->
<nav class="navbar navbar-default  navbar-light bg-light">
	<div class="container-fluid">
		<!-- logo -->
		<div class="navbar-header">
			<a class="navbar-brand" href="#">
				<img alt="Brand" src="/resource/images/logo.png">
			</a>
		</div>
		
		 <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" > 
		   <!-- 输出条 -->
		  <form class="navbar-form navbar-left">
        <div class="form-group" >
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
		 <ul class="nav navbar-nav navbar-right">
        
        <li><a href="#"><img src="/resource/images/avatar1.jpg" height="50px" weight="50px"/> </a></li>
        
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
		 
		 </div>
	</div> 
</nav>
<div class="container-fluid" style="min-height: 50px">
		<div class="container" style="min-height: 10px" >
			<div class="row"></div>
			
			<div class="col-md-2" style=" min-height:200px">
				<!-- bootstrap列表组 -->
				<ul class="list-group">
				      <li class="list-group-item">Cras justo odio</li>
					  <li class="list-group-item">Dapibus ac facilisis in</li>
					  <li class="list-group-item">Morbi leo risus</li>
					  <li class="list-group-item">Porta ac consectetur ac</li>
					  <li class="list-group-item">Vestibulum at eros</li>
				</ul>
			</div>
			
			<div class="col-md-8" style="min-height:100px">
				<!-- 轮播图 -->
				<div id="myCarousel" class="carousel slide">
				    <!-- 轮播（Carousel）指标 -->
				    <ol class="carousel-indicators">
				        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				        <li data-target="#myCarousel" data-slide-to="1"></li>
				        <li data-target="#myCarousel" data-slide-to="2"></li>
				    </ol>   
				    <!-- 轮播（Carousel）项目 -->
				    <div class="carousel-inner">
				        <div class="item active" align="center">
				            <img src="/resource/img/51fa1474c1dcf.jpg" alt="First slide">
				            <div class="carousel-caption">标题 1</div>
				        </div>
				        <div class="item"  align="center">
				            <img src="/resource/img/51fa147d9f7b9.jpg" alt="Second slide">
				            <div class="carousel-caption">标题 2</div>
				        </div>
				        <div class="item"  align="center">
				            <img src="/resource/img/5785ae6027ecf.jpg" alt="Third slide">
				            <div class="carousel-caption">标题 3</div>
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
				<!-- 多媒体对象 -->
				<div class="col-md-15" style="   min-height:300px" >
				<!-- 左对齐 -->
				<div class="media">
				  <div class="media-left">
				    <img src="/resource/images/bg01.jpg" class="media-object" style="width:50px;height: 50px">
				  </div>
				  <div class="media-body">
				   	 <h4 class="media-heading">刘吉飞</h4>
				   	 	<p>好帅啊</p>
				  </div>
				</div>
					<!-- 置顶 -->
				<div class="media">
				  	<div class="media-left media-top">
				   	 <img src="/resource/images/bg01.jpg" class="media-object" style="width:50px;height: 50px">
				  	</div>
				  	<div class="media-body">
					    <h4 class="media-heading">置顶</h4>
					    	<p>这是一些示例文本...</p>
				  </div>
			</div>
		</div>
			</div>
			
	<div class="col-md-2" style="min-height:300px">
			<!-- 带语境色彩的面板 -->
		<div class="panel panel-primary">
 			<div class="panel-heading">
     	 				<h3 class="panel-title">面板标题</h3>
	    	</div>
		    <div class="panel-body">
		        	这是一个基本的面板
		    </div>
		</div>
			<div class="panel panel-success">
			    <div class="panel-heading">
			        <h3 class="panel-title">面板标题</h3>
			    </div>
			    <div class="panel-body">
			      	  这是一个基本的面板
			    </div>
			</div>
			<div class="panel panel-info">
			    <div class="panel-heading">
			        <h3 class="panel-title">面板标题</h3>
			    </div>
			    <div class="panel-body">
			      	  这是一个基本的面板
			    </div>
			</div>
			<div class="panel panel-warning">
			    <div class="panel-heading">
			        <h3 class="panel-title">面板标题</h3>
			    </div>
			    <div class="panel-body">
			       	 这是一个基本的面板
			    </div>
			</div>
			<div class="panel panel-danger">
			    <div class="panel-heading">
			        <h3 class="panel-title">面板标题</h3>
			    </div>
			    <div class="panel-body">
			       	 这是一个基本的面板
			    </div>
			</div>
						
			</div>
			
		</div>
		
</div>
<nav class="navbar navbar-default navbar-fixed-bottom   navbar-light bg-light">

</nav>

</body>
</html>