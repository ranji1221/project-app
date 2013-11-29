<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Add Form</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/test.css">
  </head> 
  <body>
	  <center>
	    <h2>Add User</h2>
	    <hr color="red">
	    <form:form method="POST" modelAttribute="user">
	    	UserName:<form:input path="uname"/><br/>
	    	PassWord:<form:password path="pwd"/><br/>
	    	<input type="submit" value="Add User"/>
	    </form:form>
	    <p>${message}</p>
	  </center>
  </body>
</html>
