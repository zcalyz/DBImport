<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>测试</title>  
  </head>  
    
  <body>
  <table border="1" align="center" >
 	<tr>
 		<th>用户名</th>
 		<th>年龄</th>
 	</tr>
  	<c:forEach items="${users}" var="user">
  		<tr>
  			<td>${user.name}</td>
  			<td>${user.age}</td>
  		</tr>
  	</c:forEach>
	</table>
  </body>  
</html> 