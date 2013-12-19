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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/user/action.js" charset="UTF-8"></script>