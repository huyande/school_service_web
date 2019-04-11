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
<!-- Bootstrap core CSS -->
<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/bootstrap-reset.css" rel="stylesheet">
<!--external css-->
<link href="${ctx}/assets/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link
	href="${ctx}/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css"
	rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="${ctx}/css/owl.carousel.css"
	type="text/css">
<!--right slidebar-->
<link href="${ctx}/css/slidebars.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${ctx}/css/style.css" rel="stylesheet">
<link href="${ctx}/css/style-responsive.css" rel="stylesheet" />
</head>
<body>
	<section id="container">
		<!--header start-->
		<#include "header.ftl"/>

		<#include "menu.ftl"/>

		<div id="content">
			<iframe align="center" style="padding: 0px; width: 100%; height: 800px;" src="/admin/user/userm" frameborder="no"></iframe>				
		</div>
		<!--footer start-->
		<#include "footer.ftl"/>
	</section>
</body>
<!-- js placed at the end of the document so the pages load faster -->

<script src="${ctx}/js/jquery.js"></script>
<script src="${ctx}/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${ctx}/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript"
	src="${ctx}/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="${ctx}/js/jquery.scrollTo.min.js"></script>
<script src="${ctx}/js/jquery.nicescroll.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="${ctx}/assets/advanced-datatable/media/js/jquery.dataTables.js"></script>
<script src="${ctx}/assets/morris.js-0.4.3/morris.min.js"
	type="text/javascript"></script>
<script src="${ctx}/assets/morris.js-0.4.3/raphael-min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${ctx}/assets/data-tables/DT_bootstrap.js"></script>
<script src="${ctx}/js/respond.min.js"></script>

<!--right slidebar-->
<script src="${ctx}/js/slidebars.min.js"></script>

<!--用户管理表格-->
<script src="${ctx}/js/schusermanager_table_init.js"></script>


<!--common script for all pages-->
<script src="${ctx}/js/common-scripts.js"></script>

<!-- 创建图表的js -->
<script src="${ctx}/js/schusermanger_morris-script.js"></script>

</html>