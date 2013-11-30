<div style="margin-bottom:10px">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="addTab('google','http://www.google.com.hk')">baidu</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="addTab('jquery','http://jquery.com')">jquery</a>
	<a href="avascript:void(0)" class="easyui-linkbutton" onclick="addTab('easyui','http://http://www.jeasyui.com/')">easyui</a>
</div>
<div id="tt" class="easyui-tabs" style="width:800px;height:600px;;">
	<div title="Home"></div>
</div>
<script>
	function addTab(title, url){
		if($('#tt').tabs('exists',title)){
			$('#tt').tabs('select',title);
		}else{
			var content = '<iframe scrolling="auto" frameborder="0" src="'+url+'" style="width:100%;height:100%;"></iframe>';
			$('#tt').tabs('add',{
				title:title,
				content:content,
				closable:true
			});
		}
	}
</script>