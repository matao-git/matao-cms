<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<caption>上下文表格布局</caption>
		<thead>
			<tr>
				<th>产品</th>
		        <th>付款日期</th>
		        <th>状态</th>
			</tr>
		</thead>
		 <tbody>
    <tr class="active">
      <td>产品1</td>
      <td>23/11/2013</td>
      <td>待发货</td></tr>
    <tr class="success">
      <td>产品2</td>
      <td>10/11/2013</td>
      <td>发货中</td></tr>
    <tr class="warning">
      <td>产品3</td>
      <td>20/10/2013</td>
      <td>待确认</td></tr>
    <tr class="danger">
      <td>产品4</td>
      <td>20/10/2013</td>
      <td>已退货</td></tr> 
  </tbody>
	</table>
</body>
</html>