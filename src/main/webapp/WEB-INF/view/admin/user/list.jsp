<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	function updateStatus(userId,status) {
		$.post("/admin/lockuser",
			{userId:userId,status:status},
			function (data) {
				if(data.result==1){
					alert("恭喜处理成功")
					$("#content").load("/admin/users");
				}else{
					alert("data.erroMsg");
				}
			},"json")
	}
</script>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">输入姓名</a>
    </div>
    <div>
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    </div>
</nav>

<div class="table-responsive">
  <table class="table">
    <caption>用户列表</caption>
    <thead>
      <tr>
        <th>用户id</th>
        <th>用户名称</th>
        <th>注册日期</th>
        <th>生日</th>
        <th>角色</th>
        <th>状态</th>
        <th>操作<th>
        </tr>
    </thead>
    <tbody>
    
    	<c:forEach items="${info.list}" var="user">
    		<c:if test="${user.locked==1}">
    			<tr class="active">
    		</c:if>
    		<c:if test="${user.locked!=1}">
    			<tr>
    		</c:if>
    		 <td>${user.id}</td>
	         <td>${user.username}</td>
	         <td><fmt:formatDate pattern="YYYY年MM月dd号" value="${user.createTime}"/></td>
	         <td><fmt:formatDate pattern="YYYY年MM月dd号" value="${user.birthday}"/></td>
	         <td>
	         	<c:choose>
	         		<c:when test="${user.role==1}">
	         			管理员
	         		</c:when>
	         		<c:when test="${user.role==0}">
	         			注册用户
	         		</c:when>
	         		<c:otherwise>
	         			未知
	         		</c:otherwise>
	         	</c:choose>
	         </td>
	         <td>${user.locked==1?"禁用":"正常"}</td>
	         <td>
	         	<c:if test="${user.locked==1 }">
	         		<input type="button" class="btn btn-success" onclick="updateStatus(${user.id},0)" value="解禁">
	         	</c:if>
	         	<c:if test="${user.locked!=1 }">
	         		<input type="button" class="btn btn-info" onclick="updateStatus(${user.id},1)" value="封禁">
	         	</c:if>
	         </td>
	         <td></td>
	        <td></td>
    	</c:forEach>
    </tbody>
  </table>
</div>
<ul class="pagination">
    <li><a href="#">&laquo;</a></li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">&raquo;</a></li>
</ul>
    
</body>
</html>