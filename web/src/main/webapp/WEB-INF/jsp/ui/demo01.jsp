<%@ page language="java" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Basic Window By JQuery EasyUI 1.3.2</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery/themes/icon.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
  </head>
  
  <body>
  	<h2>Basic Window</h2>
  	<div>
  		<a href="javascript:void(0)" onclick="$('#w').window('open')">Open</a>
  		<a href="javascript:void(0)" onclick="$('#w').window('close')">Close</a> 
  	</div>
  	<div id="w" class="easyui-window" title="Basic Window" data-opetions="iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
  		The Window Content.
  	</div>
  </body>
</html>
