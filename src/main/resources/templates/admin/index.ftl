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

		<section id="container">
			<!--header start-->
			<header class="header white-bg">
				<div class="sidebar-toggle-box">
					<div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
				</div>
				<!--logo start-->
				<a href="index.html" class="logo">校园<span>表白墙</span></a>
				<!--logo end-->

				<div class="top-nav ">
					<ul class="nav pull-right top-menu">
						<!-- user login dropdown start-->
						<li class="dropdown">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<img alt="" src="${ctx}/img/avatar1_small.jpg">
								<span class="username">Jhon Doue</span>
								<b class="caret"></b>
							</a>
							<ul class="dropdown-menu extended logout">
								<div class="log-arrow-up"></div>
								<li>
									<a href="login.html"><i class="fa fa-key"></i> Log Out</a>
								</li>
							</ul>
						</li>
						<!-- user login dropdown end -->
					</ul>
				</div>
			</header>
			<!--header end-->

			<!--sidebar start-->
			<aside>
				<div id="sidebar" class="nav-collapse ">
					<!-- sidebar menu start-->
					<ul class="sidebar-menu" id="nav-accordion">
						<li>
							<a class="active" href="/admin/index">
								<i class="fa fa-dashboard"></i>
								<span>概览</span>
							</a>
						</li>

						<li class="sub-menu">
							<a href="javascript:;">
								<i class="fa fa-laptop"></i>
								<span>用户管理</span>
							</a>
							<ul class="sub">
								<li>
									<a href="/admin/user/userManager">用户列表</a>
								</li>
								<!-- <li>
									<a href="#">黑名单</a>
								</li> -->
							</ul>
						</li>

						<li class="sub-menu">
							<a href="javascript:;">
								<i class="fa fa-book"></i>
								<span>表白墙信息</span>
							</a>
							<ul class="sub">
								<li>
									<a href="general.html">一般组件</a>
								</li>
								<li>
									<a href="buttons.html">按钮</a>
								</li>
								<li>
									<a href="modal.html">弹窗</a>
								</li>
								<li>
									<a href="toastr.html">弹窗自动消失</a>
								</li>
								<li>
									<a href="widget.html">小部件</a>
								</li>
								<li>
									<a href="slider.html">滑块</a>
								</li>
								<li>
									<a href="nestable.html">可拖拽树结构</a>
								</li>
								<li>
									<a href="tree.html">树菜单</a>
								</li>
								<li>
									<a href="font_awesome.html">图标</a>
								</li>
							</ul>
						</li>

					</ul>
					<!-- sidebar menu end-->
				</div>
			</aside>
			<!--sidebar end-->

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
								
								<!-- <div class="bar ">
									<div class="title">FEB</div>
									<div class="value tooltips" data-original-title="50%" data-toggle="tooltip" data-placement="top">50%</div>
								</div>
								<div class="bar ">
									<div class="title">MAR</div>
									<div class="value tooltips" data-original-title="40%" data-toggle="tooltip" data-placement="top">40%</div>
								</div>
								<div class="bar ">
									<div class="title">APR</div>
									<div class="value tooltips" data-original-title="55%" data-toggle="tooltip" data-placement="top">55%</div>
								</div>
								<div class="bar">
									<div class="title">MAY</div>
									<div class="value tooltips" data-original-title="20%" data-toggle="tooltip" data-placement="top">20%</div>
								</div>
								<div class="bar ">
									<div class="title">JUN</div>
									<div class="value tooltips" data-original-title="39%" data-toggle="tooltip" data-placement="top">39%</div>
								</div>
								<div class="bar">
									<div class="title">JUL</div>
									<div class="value tooltips" data-original-title="75%" data-toggle="tooltip" data-placement="top">75%</div>
								</div>
								<div class="bar ">
									<div class="title">AUG</div>
									<div class="value tooltips" data-original-title="45%" data-toggle="tooltip" data-placement="top">45%</div>
								</div>
								<div class="bar ">
									<div class="title">SEP</div>
									<div class="value tooltips" data-original-title="50%" data-toggle="tooltip" data-placement="top">50%</div>
								</div>
								<div class="bar ">
									<div class="title">OCT</div>
									<div class="value tooltips" data-original-title="42%" data-toggle="tooltip" data-placement="top">42%</div>
								</div>
								<div class="bar ">
									<div class="title">NOV</div>
									<div class="value tooltips" data-original-title="60%" data-toggle="tooltip" data-placement="top">60%</div>
								</div>
								<div class="bar ">
									<div class="title">DEC</div>
									<div class="value tooltips" data-original-title="90%" data-toggle="tooltip" data-placement="top">90%</div>
								</div> -->
							</div>
							<!--custom chart end-->
						</div>
					</div>
				</section>
				</section>
				<!--main content end-->
				
				<!--footer start-->
				<footer class="site-footer" style="margin-top: 80px;">
					<div class="text-center" >
						2019 &copy; By Huyande.
						<a href="#" class="go-top">
							<i class="fa fa-angle-up"></i>
						</a>
					</div>
				</footer>
				<!--footer end-->
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