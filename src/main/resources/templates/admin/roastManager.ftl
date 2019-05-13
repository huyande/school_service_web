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
		<link href="${ctx}/css/mystyle.css" rel="stylesheet">
		<link href="${ctx}/css/style-responsive.css" rel="stylesheet" />
		
		<!--dynamic table-->
		<link href="${ctx}/assets/advanced-datatable/media/css/demo_page.css" rel="stylesheet" />
		<link href="${ctx}/assets/advanced-datatable/media/css/demo_table.css" rel="stylesheet" />
		<link rel="stylesheet" href="${ctx}/assets/data-tables/DT_bootstrap.css" />
		
	</head>

	<body>

			<!--main content start-->
			<section id="main-content">
				<section class="wrapper">
					<!--吐槽统计相关信息-->
					<div>
						<div class="row">
	                      <div class="col-lg-4">
	                      	<section class="panel">
	                      		<header class="panel-heading">
	                                	 <h2>吐槽总数</h2>
	                            </header>
	                            <div class="panel-body">
		                      		<div class="col-lg-12" style="height:305px";>
		                      			<span class="my_span_user"> 
		                      				${currentCount}
		                      			</span>
		                     		 </div>
	                     		 </div>
	                     	</section>
	                      </div>
	                      
	                      <div class="col-lg-4">
	                      	<section class="panel">
	                      		<header class="panel-heading">
	                                	<h2>吐槽新增数</h2>
	                            </header>
	                            <div class="panel-body">
		                     		 <div class="col-lg-12" style="height:305px";>
		                     		 	<span class="my_span_user_count"> 
		                      				${increaseCount}
		                      			</span>
		                     		 </div>
	                     		 </div>
	                     	</section>
	                      </div>
                      
	                      <div class="col-lg-4">
	                          <section class="panel">
	                              <header class="panel-heading">
	                                	  吐槽信息男女比例
	                              </header>
	                              <div class="panel-body">
	                                  <div id="roast_male" class="graph"></div>
	                              </div>
	                          </section>
	                      </div>
                  </div>
				</div>
				
				<!--表白信息管理表格 start-->
				<div class="row">
					<div class="col-sm-12">
						<section class="panel">
							<header class="panel-heading">
								吐槽信息
							</header>
							<div class="panel-body">
								<div class="adv-table">
									<table class="display table table-bordered" id="roast-table-info">
										<thead>
											<tr>
												<th>发布者头像</th>
												<th>昵称</th>
												<th>发布内容</th>
												<th class="hidden-phone">状态</th>
												<th class="hidden-phone">发布时间</th>
												<th class="hidden-phone">操作</th>
											</tr>
										</thead>
										<tbody>
											
										</tbody>
									</table>

								</div>
							</div>
						</section>
					</div>
					</div>
				<!--end-->
				</section>
			</section>
		<!--main content end-->
		<script src="${ctx}/js/jquery.js"></script>
		<script src="${ctx}/js/jquery-ui-1.9.2.custom.min.js"></script>
		<script src="${ctx}/js/jquery-migrate-1.2.1.min.js"></script>
		<script src="${ctx}/js/bootstrap.min.js"></script>
		<script class="include" type="text/javascript" src="${ctx}/js/jquery.dcjqaccordion.2.7.js"></script>
		<script src="${ctx}/js/jquery.scrollTo.min.js"></script>
		<script src="${ctx}/js/jquery.nicescroll.js" type="text/javascript"></script>
		<script type="text/javascript" language="javascript" src="${ctx}/assets/advanced-datatable/media/js/jquery.dataTables.js"></script>
		<script src="${ctx}/assets/morris.js-0.4.3/morris.min.js" type="text/javascript"></script>
		<script src="${ctx}/assets/morris.js-0.4.3/raphael-min.js" type="text/javascript"></script>
		<script type="text/javascript" src="${ctx}/assets/data-tables/DT_bootstrap.js"></script>
		<script src="${ctx}/js/respond.min.js"></script>
		<script src="${ctx}/js/slidebars.min.js"></script>
		
		<!--common script for all pages-->
		<script src="${ctx}/js/common-scripts.js"></script>
		
		<!-- 创建图表的js -->
   		<script src="${ctx}/js/schroast_morris-script.js"></script>
   		
   		<!--表白管理表格-->
		<script src="${ctx}/js/schroast_table_init.js"></script>
		
	</body>

</html>
