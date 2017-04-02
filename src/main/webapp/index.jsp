<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<title>SPH Code Challenge</title>
	
	<!-- basic styles -->
	
	<link rel="stylesheet" href="resources/css/bootstrap.min.css" />
	<link rel="stylesheet" href="resources/css/font-awesome.min.css" />
	
	<!--[if IE 7]>
		  <link rel="stylesheet" href="resources/css/font-awesome-ie7.min.css" />
		<![endif]-->
	
	<!-- page specific plugin styles -->
	
	<!-- fonts -->
	
	<link rel="stylesheet" href="resources/css/ace-fonts.css" />
	
	<!-- ace styles -->
	
	<link rel="stylesheet" href="resources/css/ace.min.css" />
	<link rel="stylesheet" href="resources/css/ace-rtl.min.css" />
	<link rel="stylesheet" href="resources/css/ace-skins.min.css" />
	
	<!--[if lte IE 8]>
		  <link rel="stylesheet" href="resources/css/ace-ie.min.css" />
		<![endif]-->
	
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
	</head>
	
	<body class="login-layout">
		<div class="main-container">
			<div class="main-content" ng-controller="ArticleCtrl">
				<div class="row">
					<div class="col-xs-12">
						<div class="">
							<div class="center">
								<h1>
									<i class="icon-leaf green"></i>
									<span class="red">Article</span>
									<span class="white">Application</span>
								</h1>
								<h4 class="blue">© Singapore Press Holdings Ltd</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
														
								<jsp:include page="message-panel.jsp"/>
																						
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body hide" id="article-list" ng-show="showArticleList">
										<jsp:include page="article-list.jsp"/>
									</div>
									<div class="widget-body hide" id="article-form" ng-show="showArticleForm">
										<jsp:include page="article-form.jsp"/>
									</div>													
								</div><!-- /login-box -->
							</div><!-- /position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
		</div>	
		<script type="text/javascript">
		    var contextPath='${pageContext.request.contextPath}';
		</script>		
		<script src="resources/app/assets/js/require.js" data-main='resources/app/main'></script>		
	</body>
</html>

