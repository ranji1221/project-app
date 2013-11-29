<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Update Form</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/test.css">
  </head> 
  <body>
	  <center>
	    <h2>Update User</h2>
	    <hr color="red">
	    <c:set var="contextPath"  scope="page" value="<%=request.getContextPath()%>"/>
	    <form:form action="${contextPath}/user/update"  method="POST"  modelAttribute="user">
	    	<form:hidden path="id"/>
	    	UserName:<form:input path="uname"/><br/>
	    	PassWord:<form:password path="pwd" showPassword="true"/><br/>
	    	<input type="submit" value="Update User"/>
	    </form:form>
	  </center>
  </body>
</html>
