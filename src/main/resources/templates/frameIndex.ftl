<!DOCTYPE html>
<#assign ctx=request.contextPath />
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="huyande">
<meta name="keyword" content="">
<link rel="shortcut icon" href="${ctx}/img/favicon.png">
<title>校园墙服务后台</title>
<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/bootstrap-reset.css" rel="stylesheet">
<link href="${ctx}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="${ctx}/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="${ctx}/css/owl.carousel.css" type="text/css">
<link href="${ctx}/css/slidebars.css" rel="stylesheet">
<link href="${ctx}/css/style.css" rel="stylesheet">
<link href="${ctx}/css/style-responsive.css" rel="stylesheet" />
</head>
<body>
	<section id="container">
		<!--header start-->
		<#include "./common/header.ftl"/>

		<#include "./common/menu.ftl"/>

		<div id="content">
			<iframe align="center" style="padding: 0px; width: 100%; height: 800px;" src="/admin/index" frameborder="no"></iframe>				
		</div>
		<!--footer start-->
		<#include "./common/footer.ftl"/>
	</section>
</body>

<!--右侧菜单相关 start-->
<script src="${ctx}/js/jquery.js"></script> 
<script src="${ctx}/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="${ctx}/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="${ctx}/js/jquery.scrollTo.min.js"></script>
<script src="${ctx}/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="${ctx}/js/slidebars.min.js"></script>
<script src="${ctx}/js/common-scripts.js"></script>
<!-end-->


<script>
$('.ifm_switch_meau').click(function(){
	$('li .active').removeAttr("class")
	$(this).parent('li').attr("class","active")
	//获取到当前点击菜单的data-meau 将此数据设置到 iframes 的src 属性中  
	$('#content').children('iframe').attr('src',$(this).attr('data-meau'));
});

</script>

</html>