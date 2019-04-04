<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报名表</title>
<link rel="shortcut icon" href="images/timg.ico" type="image/X-icon"/>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Studeon Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<link href='http://fonts.useso.com/css?family=Oswald:400,700,300|Open+Sans:300italic,400italic,600italic,400,300,600,700' rel='stylesheet' type='text/css'>
<!--//webfont-->
<!--Animation-->
<script src="js/wow.min.js"></script>
<link href="css/animate.css" rel='stylesheet' type='text/css' />
<script>
	new WOW().init();
</script>
</head>
<body>
<div class="container">
		<div class="content">
		
<div class="single-content">
<div class="single">
<div class="comments1">
		<h4>报名详情</h4>
		<div class="comments-main wow fadeInLeft animated" data-wow-delay="0.4s">
			<div class="col-md-3 cmts-main-left">
				<img src="images/${requestScope.register.registerPicture}" alt="${requestScope.register.registerName}">
			</div>
			<div class="col-md-9 cmts-main-right">
				<a href="#"><h5>${requestScope.register.registerName}</h5></a>
				<p>${requestScope.register.registerIntroduction}</p>
				<div class="cmts">
					<div class="col-md-8 cmnts-left">
						<p>${requestScope.register.registerHometown}</p>
					</div>
					<div class="col-md-4 cmnts-right">
						<a href="register_search">返回</a>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	</div>
	</div>
	</div>
	</div>
</body>
</html>