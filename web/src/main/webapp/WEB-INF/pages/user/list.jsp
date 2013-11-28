<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>List Form</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/test.css">
  </head> 
  <body>
	  <center>
	    <h2>List Users</h2>
	    <hr color="red">
	    <table>
	    	<tr>
	    		<th>ID</th>
	    		<th>uName</th>
	    		<th>Pwd</th>
	    		<th>Operation</th>
	    	</tr>
	    	<c:forEach items="${users }" var="user">
	    		<tr>
	    			<td>${user.id }</td>
	    			<td>${user.uname }</td>
	    			<td>${user.pwd }</td>
	    			<td>
	    				<a href="<%=request.getContextPath()%>/user/view/${user.id}">View</a>
	    				<a href="<%=request.getContextPath()%>/user/update/${user.id}">Edit</a>
	    				<a href="<%=request.getContextPath()%>/user/delete/${user.id}">Delete</a>
	    			</td>
	    		</tr>
	    	</c:forEach>
	    </table>
	  </center>
  </body>
</html>
