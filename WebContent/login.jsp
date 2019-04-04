<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/struts-tags" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录</title>
<link rel="shortcut icon" href="images/timg.ico" type="image/X-icon"/>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Owl Stylesheets -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
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

	<!-- 标题头  -->
	<div class="header box css3-shadow" id="head">
		<div class="container">
			<div class="header-top">
				<div class="logo wow bounceInLeft" data-wow-delay="0.4s">
					<a href="index.jsp"><img src="images/logo.png" alt=""/></a>
				 </div>
			     <div class="h_menu4"><!-- start h_menu4 -->
					<a class="toggleMenu" href="#">Menu</a>
					<ul class="nav">
						<li><a href="index.jsp">首页</a></li>
						<li><a href="register_search">纳新管理</a></li>
						<li><a href="memberManager.jsp">成员管理</a></li>
						<li><a href="memberSearch.jsp">成员查询</a></li>
						<li><a href="activityManager.jsp">活动管理</a></li>
						<li><a href="material_search">物资管理</a></li>
					</ul>

					<script type="text/javascript" src="js/nav.js"></script>
				</div><!-- end h_menu4 -->
				<div class="social_icons wow bounceInRight" data-wow-delay="0.4s">
						<ul>
							<!-- <li><a href="#"><i class="facebook"></i></a></li>
							<li><a href="#"><i class="twitter"></i></a></li>
							<li><a href="#"><i class="rss"></i></a></li>
							<li><a href="#"><i class="viemo"></i></a></li>
							<li><a href="#"><i class="youtube"></i></a></li> -->
							<%-- <li><a href="exit.jsp" name="exit"  style="top: 100px; color: blue;">你好 ${sessionScope.username}</a></li> --%>
						</ul>
				</div>
	
				<div class="clearfix"> </div>
				
			  </div><!-- end header_main4 -->
		</div>
	</div>
	
	
	<!--登录表单-->
	
	<div class ="contact-section">
		<div class="container">
			<div class="contact">
				<h3 class="wow bounceIn" data-wow-delay="0.4s">用户登录</h3>
				<c:actionerror/>
				<p class="wow fadeInUpBig animated" data-wow-delay="0.4s">${requestScope.msg}</p>
				<p class="wow fadeInUpBig animated" data-wow-delay="0.4s">登录后可进行查询、管理等操作</p>
				<form class="wow bounceIn" data-wow-delay="0.4s" action="login" method="post">
					<input type="text" placeholder="UserName" name="memberId"><br>
					<input type="password" 
						style="border: 1px solid #DCDCDF;color: #000;outline:none;padding:0.8em 1em;margin-top: 2em;background:#EDEDED;-webkit-appearance: none;width: 33%;font-weight: 400;font-size: 16px;transition: 0.5s all;-webkit-transition: 0.5s all;-moz-transition: 0.5s all;-o-transition: 0.5s all;-ms-transition: 0.5s all;border-radius: 0.3em;-o-border-radius: 0.3em;-moz-border-radius: 0.3em;-weblit-border-radius: 0.3em;" 
						placeholder="PassWord" name="memberPassword"><br><br><br>
					<input type="submit" value="登录">
				</form>
				<a href="updatePassword.jsp" style="color: blue;"class="wow fadeInUpBig animated" data-wow-delay="0.4s">修改密码</a>
			</div>	
		</div>
	</div>

	<!--尾注部分--><!--/start-copyright-section-->
	<div class="clearfix"></div>
		<div class="copyright">
			<div class="container">
				<div class="logo2  wow bounceInLeft" data-wow-delay="0.4s"><a href="index.html"><img src="images/logo2.png" alt=""/ title="logo" /></a></div>
				<p class="write  wow bounceInRight" data-wow-delay="0.4s">Copyright &copy; 2015<a href="http://www.nankai.edu.cn" target="_blank" title="南开大学">南开大学社团联合会</a></p>
			</div>
			<div class="clearfix"></div>
		</div>
								
</body>
</html>