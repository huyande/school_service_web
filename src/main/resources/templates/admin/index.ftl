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
		<link href="${ctx}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
		<link href="${ctx}/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen" />
		<link rel="stylesheet" href="${ctx}/css/owl.carousel.css" type="text/css">
		<!--right slidebar-->
		<link href="${ctx}/css/slidebars.css" rel="stylesheet">
		<!-- Custom styles for this template -->
		<link href="${ctx}/css/style.css" rel="stylesheet">
		<link href="${ctx}/css/style-responsive.css" rel="stylesheet" />
	</head>

	<body>

			<!--main content start-->
			<section id="main-content">
				<section class="wrapper">
					<!--state overview start-->
					<div class="row state-overview">
						<div class="col-lg-3 col-sm-6">
							<section class="panel">
								<div class="symbol terques">
									<i class="fa fa-user"></i>
								</div>
								<div class="value">
									<h1 class="count1">0</h1>
									<p>新增用户</p>
								</div>
							</section>
						</div>
						<div class="col-lg-3 col-sm-6">
							<section class="panel">
								<div class="symbol blue">
									<i class="fa fa-bar-chart-o"></i>
								</div>
								<div class="value">
									<h1 class=" count4">
                                  		0
                              		</h1>
									<p>总用户数</p>
								</div>
							</section>
						</div>
						<div class="col-lg-3 col-sm-6">
							<section class="panel">
								<div class="symbol red">
									<i class="fa  fa-heart"></i>
								</div>
								<div class="value">
									<h1 class=" count2">
	                                  0
	                               </h1>
									<p>新增表白</p>
								</div>
							</section>
						</div>
						<div class="col-lg-3 col-sm-6">
							<section class="panel">
								<div class="symbol yellow">
									<i class="fa fa-frown-o"></i>
								</div>
								<div class="value">
									<h1 class="count3">
                                 		 0
                              		</h1>
									<p>新增吐槽</p>
								</div>
							</section>
						</div>
					</div>
					<!--state overview end-->

					<div class="row">
						<div class="col-lg-6">
							<!--custom chart start-->
							<div class="border-head">
								<h3>表白点赞前十</h3>
							</div>
							<div class="custom-bar-chart">
								<ul class="y-axis">
									<li><span>100</span></li>
									<li><span>80</span></li>
									<li><span>60</span></li>
									<li><span>40</span></li>
									<li><span>20</span></li>
									<li><span>0</span></li>
								</ul>
								
								<#list confList as item>  
									<div class="bar">
										<div class="title"	>
											<img alt="${item.user.fromuser}" src="${item.user.avatar}" title="${item.user.fromuser}" style="width: 25px;height: 25px;">
										</div>
										<div class="value tooltips" data-original-title="点赞数：${item.numCount} 内容:${item.content}" data-toggle="tooltip" data-placement="top">${item.numCount}%</div>
									</div>
								</#list>  
							</div>
							<!--custom chart end-->
						</div>

						<div class="col-lg-6">
							<!--custom chart start-->
							<div class="border-head">
								<h3>吐槽点赞前十</h3>
							</div>
							<div class="custom-bar-chart">
								<ul class="y-axis">
									<li><span>100</span></li>
									<li><span>80</span></li>
									<li><span>60</span></li>
									<li><span>40</span></li>
									<li><span>20</span></li>
									<li><span>0</span></li>
								</ul>
								<#list roastList as item>  
									<div class="bar">
										<div class="title">
											<img alt="${item.user.fromuser}" src="${item.user.avatar}" title="${item.user.fromuser}" style="width: 25px;height: 25px;">
										</div>
										<div class="value tooltips" data-original-title="点赞数：${item.numCount} 内容:${item.content}" data-toggle="tooltip" data-placement="top">${item.numCount}%</div>
									</div>
								</#list>  
							</div>
							<!--custom chart end-->
						</div>
					</div>
				</section>
				</section>
				
			<!-- js placed at the end of the document so the pages load faster -->
			<script src="${ctx}/js/jquery.js"></script>
			<script src="${ctx}/js/bootstrap.min.js"></script>
			<script class="include" type="text/javascript" src="${ctx}/js/jquery.dcjqaccordion.2.7.js"></script>
			<script src="${ctx}/js/jquery.scrollTo.min.js"></script>
			<script src="${ctx}/js/jquery.nicescroll.js" type="text/javascript"></script>
			<script src="${ctx}/js/jquery.sparkline.js" type="text/javascript"></script>
			<script src="${ctx}/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
			<script src="${ctx}/js/owl.carousel.js"></script>
			<script src="${ctx}/js/jquery.customSelect.min.js"></script>
			<script src="${ctx}/js/respond.min.js"></script>

			<!--right slidebar-->
			<script src="${ctx}/js/slidebars.min.js"></script>

			<!--common script for all pages-->
			<script src="${ctx}/js/common-scripts.js"></script>

			<!--script for this page-->
			<script src="${ctx}/js/sparkline-chart.js"></script>
			<script src="${ctx}/js/easy-pie-chart.js"></script>
			<script src="${ctx}/js/count.js"></script>

			<script>
				//owl carousel

				$(document).ready(function() {
					$("#owl-demo").owlCarousel({
						navigation: true,
						slideSpeed: 300,
						paginationSpeed: 400,
						singleItem: true,
						autoPlay: true

					});
				});

				//custom select box

				/*$(function() {
					$('select.styled').customSelect();
				});*/

				/*$(window).on("resize", function() {
					var owl = $("#owl-demo").data("owlCarousel");
					owl.reinit();
				});*/
			</script>
	</body>

</html>