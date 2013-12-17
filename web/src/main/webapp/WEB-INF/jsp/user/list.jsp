<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery/themes/gray/easyui.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery/themes/icon.css">
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
	</head>
	<body>
		<!-- list users start -->
		<table id="dg" title="My Users"  toolbar="#toolbar">
			<thead>
				<tr>
					<th field="uname" >User Name</th>
					<th field="pwd" >Password</th>
					<th field="enabled" >Enabled</th>
					<th field="description" >Description</th>
				</tr>
			</thead>
		</table>
		<div id="toolbar">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addUser()">Add User</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeUser()">Remove User</a>
		</div>
		<script>
				//-- set datagrid
				$('#dg').datagrid({
					title:'User List',
					iconCls:'icon-edit', //图标,
					nowrap:false,
					striped:true,
					border:true,
					collapsible:true, //是否可折叠
					idField:'id',
					rownumbers:true, 
					fitColumns:true,
					singleSelect:true,
					pagination:true, //分页控件
					url:'${pageContext.request.contextPath}/user/getusers',
					frozenColumns:[[
						{field:'ck',checkbox:true}
					]],
					//queryparams:{},
					loadMsg:'Data Loading......'
				});
				//-- set pagination
				var p = $('#dg').datagrid('getPager');
				$(p).pagination({
					pageSize:10,  //每页显示的记录条数，默认为10
					pageList:[5,10,15], //可以设置每页记录条数的列表
					beforePageText: '第', //页数文本框前显示的汉字
					afterPageText: '页	    共 {pages} 页',
					displayMsg: '当前显示 {from} - {to} 条记录 		共 {total} 条记录'
				});
		</script>
		<!-- list users end -->
		
		<!-- user form start -->
		<%@include file="form.jsp" %>
		<!-- user form end -->
	</body>
</html>
