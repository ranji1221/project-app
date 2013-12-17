<%@ page language="java" pageEncoding="UTF-8"%>
<div id="dlg" class="easyui-dialog" style="with:400px;height:280px;padding:10px 20px;top:200px"
	closed="true" buttons="#dlg-buttons">
	<div class="ftitle">User Information</div>
	<form id="fm" method="post" novalidate>
		<div class="fitem">
			<label>User Name:</label>
			<input name="uname" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>Password:</label>
			<input name="pwd" class="easyui-validatebox" required="true">
		</div>
	</form>
</div>
<div id="dlg-buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">Save User</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
</div>
<script type="text/javascript">
<!--
	var url;
	function addUser(){
		$('#dlg').dialog('open').dialog('setTitle','New User');
		$('#updateIDHiddenInput').remove();
		$('#fm').form('clear');
		url = '${pageContext.request.contextPath}/user/add';
	}
	function saveUser(){
		$('#fm').form('submit',{
			url:url,
			onSubmit:function(){
				return $(this).form('validate');
			},
			success:function(result){
				var result = eval('('+result+')');
				if(result.success){
					$('#dlg').dialog('close');			//close the dialog
					$('#dg').datagrid('reload');		//reload the user data
				}else{
					$.messager.show({
						title:'Error',
						msg:result.msg
					});
				}
			}
		});
	}
	function editUser(){
		var row = $('#dg').datagrid('getSelected');
		if(row){
			$('#dlg').dialog('open').dialog('setTitle','Edit User');
			$('#fm').form('load',row);
			$('#updateIDHiddenInput').remove();
			$('#fm').append('<input id="updateIDHiddenInput" type="hidden" name="id" value="'+row.id+'">');
			url = '${pageContext.request.contextPath}/user/update';
		}
	}
	function removeUser(){
		var row = $('#dg').datagrid('getSelected');
		if(row){
			$.messager.confirm('Confirm','Are you sure you want to remove this user?',function(r){
				if(r){
					$.post('${pageContext.request.contextPath}/user/delete/'+row.id,function(result){
						if(result.success){
							$('#dg').datagrid('reload');
							$('#dg').datagrid('clearSelections');
						}else{
							$.messager.show({
								title:'Error',
								msg:result.msg
							});
						}
					},'json');
				}
			});
		}
	}
//-->
</script>
