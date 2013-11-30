<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>后台管理</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery/themes/icon.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
  </head>
  
  <body class="easyui-layout">
    	<div data-options="region:'north'" style="height:100px"></div>
    	<div data-options="region:'west'" title="Navigation" style="width:215px;">
    		<%@include file="../nav/left.jsp" %>
    	</div>
    	<div data-options="region:'center',title:'Main Title'">
    		<%@include file="../content/content.jsp" %>
    	</div>
  </body>
</html>
