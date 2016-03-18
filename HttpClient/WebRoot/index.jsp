<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="jquery-1.9.0.js"></script>
	<script type="text/javascript">
	var serverName="蓬莱仙境,普陀仙境,水晶宫,太初幻境,太初幻境,雾隐云居,星河云海,烟雨斜阳,一生所爱,玉堂春,再爱一次,珠联璧合,百鸟朝凤,乘风破浪,尘缘未了,汉乐府,河北新区,鹤舞云天,雷动九天,六桥烟柳,怒海龙吟,齐云灵脉,山西新区,生如夏花,仙履奇缘,洗剑录,缘定三生,紫芝仙苑,傲雪凌霜,翠微山,花间月,华山论剑,剑烛沧海,佳期良年,龙的传人,南窗幽梦,琼树芳华,陕西专区,踏雪寻芳,天上人间,烟雨楼台,忆长安,易水歌,一叶知秋,一战顷城,月牙泉,碧波潭,钓鱼岛,风雨同舟,红颜知己,花前月下,剑胆琴心,剑侠风骨,开元盛世,凌烟阁,情人岛,似水流年,天若有情,一生一世,一生有你,月光爱人,月下爱人";

	function addServer(serverName){
		$.ajax({
			dataType:'json',
			ajax:true,
			data:{
				question:serverName
			},
			url:'publicTime!queryMessage.action',
			success:function(jsons){
				var indexof=jsons.answer.indexOf("最早开服时间");
				console.log(jsons);
				if(indexof!=-1){
					var endof=jsons.answer.indexOf("注：");
					if(endof!=-1){
						$('#'+serverName).html(jsons.answer.substring(indexof,endof));
					}else{
						$('#'+serverName).html(jsons.answer.substring(indexof));
					}
					
				}else{
					var flag=$("#flag").is(':checked')
					if(!flag){
						$('#2'+serverName).remove();
					}else{
						$('#'+serverName).html(jsons.answer);
					}
					
				}
			},
			});		
		
	}
	function reloadServer(){
		$('#content').html('');
		 var serverNames=$('#serverList').val().split(",");
		 for(var i=0;i<serverNames.length;i++){
			 var server=serverNames[i];
			 var div=$("<div id='2"+server+"' style=\"height:200px;width:250px;overflow:auto;float:left;border:1px solid red\"><span>"+server+"</span><div id='"+server+"' ></div></div>");
			 div.appendTo($('#content'));
			 addServer(server);
		 }
	}
	 $(document).ready(function() {
		 reloadServer();
		});
	</script>
  </head>
  <body>
  <input type="text" id="serverList" value="蓬莱仙境,普陀仙境,水晶宫,太初幻境,雾隐云居,星河云海,烟雨斜阳,一生所爱,玉堂春,再爱一次,珠联璧合,百鸟朝凤,乘风破浪,尘缘未了,汉乐府,河北新区,鹤舞云天,雷动九天,六桥烟柳,怒海龙吟,齐云灵脉,山西新区,生如夏花,仙履奇缘,洗剑录,缘定三生,紫芝仙苑,傲雪凌霜,翠微山,花间月,华山论剑,剑烛沧海,佳期良年,龙的传人,南窗幽梦,琼树芳华,陕西专区,踏雪寻芳,天上人间,烟雨楼台,忆长安,易水歌,一叶知秋,一战顷城,月牙泉,碧波潭,钓鱼岛,风雨同舟,红颜知己,花前月下,剑胆琴心,剑侠风骨,开元盛世,凌烟阁,情人岛,似水流年,天若有情,一生一世,一生有你,月光爱人,月下爱人" style="width: 100%;float: left">
  <span>显示无开服时间服务器</span><input type="checkbox" id="flag"><input type="button" value="再来一次" onclick="reloadServer()">
  <div id="content" style="height: 100%;width: 100%"></div>
  </body>
</html>
