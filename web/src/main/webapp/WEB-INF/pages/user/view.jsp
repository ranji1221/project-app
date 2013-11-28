<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Add Form</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/test.css">
  </head> 
  <body>
	  <center>
	    <h2>View User</h2>
	    <hr color="red">
	    <table>
	    	<tr>
	    		<td>ID</td>
	    		<td>${user.id }</td>
	    	</tr>
	    	<tr>
	    		<td>uName</td>
	    		<td>${user.uname}</td>
	    	</tr>
	    	<tr>
	    		<td>pwd</td>
	    		<td>${user.pwd }</td>
	    	</tr>
	    </table>
	  </center>
  </body>
</html>
