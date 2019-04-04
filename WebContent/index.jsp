<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Home</title>
<link rel="shortcut icon" href="images/timg.ico"
 type="image/X-icon"/>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
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
<script language="javascript">
	<% 
	String succe=(String)request.getAttribute("succe");
	if(succe!=null)
	{
		 
	%>
	alert("登录成功!");
	<%} %>
	<% 
	String success=(String)request.getAttribute("success");
	if(success!=null)
	{
		 
	%>
	alert("报名成功!");
	<%} %>
</script>
<!-- 进入首页之前，先从数据库拿数据 -->
<c:if test="${empty requestScope.orgPage.dataList}">
	<jsp:forward page="Org_showAll"></jsp:forward>
</c:if>
<c:if test="${empty sessionScope.actPage.dataList}">
	<jsp:forward page="Act_showAll"></jsp:forward>
</c:if>
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
					<div style="position: absolute;top: 22px;right: 50px;">
						<c:if test="${sessionScope.username == null}">
							<a href="login.jsp">登录</a>
						</c:if>
						<a href="exit.jsp" style="align-self: auto;">${sessionScope.name}</a>
					</div>
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
	
	<!--start-slider 登录部分-->
	<div class="slider-bg">
		<div class="container">
			<div class="grid-1">
				<div class="col-md-5 left-grid-1 wow bounceInLeft" data-wow-delay="0.4s">
					<h1>南开大学</h1>	
					<h2>学生组织</h2>
					<h3>管理系统</h3>
				</div>
				<div class="col-md-7 right-grid-1 wow bounceInRight" data-wow-delay="0.7s">
					<div class="slider">
						<div class="callbacks_container">
								<ul class="rslides" id="slider">
									<li>
									<img src="images/slide1.png" class="img-responsive" alt="" />
									</li>
									<li>
									<img src="images/slide2.png" class="img-responsive" alt="" />
									</li>
									<li>
									<img src="images/slide3.png" class="img-responsive" alt="" />
									</li>
									<li>
									<img src="images/slide4.png" class="img-responsive" alt="" />
									</li>
								 </ul>
							</div>
						</div>
					</div>
					<script src="js/responsiveslides.min.js"></script>
					<script>
					    $(function () {
					      $("#slider").responsiveSlides({
					      	auto: true,
					      	nav: true,
					      	speed: 500,
					        namespace: "callbacks",
					        pager: true,
					      });
					    });
					 </script>
                    </div>
				<div class="clearfix"> </div>
			</div>
		</div>
	<!--//end-slider-->

	<!-- 各部门简介部分 -->
	<div class="slider-bg">
		<div id="about" class="service-section">
			<div class="container">
				<h1>部门介绍</h1><br>
				<!-- 三个作为一行进行显示 -->
				<div class="serve-grids wow bounceIn animated" data-wow-delay="0.4s">
					<c:forEach items="${requestScope.orgPage.dataList}" var="org">
						<div class="col-md-4 services-section-grid">
							<div class="services-section-grid-head">
								<div class="service-icon">
									<i class="rocket"></i>
								</div>
								<div class="service-icon-heading">
								<!-- 部门名是超链接 这里是同一个内容页-->
									<h4><a href="OrganizationIntroduction.jsp?testid=${org.organizationId}">${org.organizationName}</a></h4>
									<p>${org.organizationIntroduction}</p><!-- 部门介绍 -->
								</div>
								<div class="clearfix"></div>
							</div>
							<br><br>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>	
	</div>
	
	<!-- 近期活动介绍 --><!--/port-section-->
	<div id="features" class="port-section">
		<div class="container">
			<h1>近期活动</h1><br>
			<div class="port-grids">
			<c:forEach items="${sessionScope.actPage.dataList}" var="act">
				<div class="col-md-3 port-grid wow zoomInLeft animated">
					<a href="Act_findById?activityId=${act.activityId}"><img src="images/${act.activityPicture}" class="img-responsive" alt="" /></a>
					<div class="box_type">${act.activityTime}</div>
					<div class="box-hover">
						<ul class="port-icons">
							<li><i class="per"></i></li>
							<li><i class="loca"></i></li>
						</ul>
					</div>
					<div class="text">
						<a href="#"><h3>${act.activityName}</h3></a>
						<p>${act.activityIntroduction}</p>
					</div>		
				</div>
			</c:forEach>	
			<div class="clearfix"></div>
			</div>
		</div>
	</div>
	
	<!--/start-footer-section-->
			<div class="footer-section">
				<div class="container">
					<div class="footer-grids wow bounceIn animated" data-wow-delay="0.4s">
						<div class="col-md-3 footer-grid">
						<h4>关于我们</h4>
						<div class="border2"></div>
						  <p>南开大学<br>计算机与控制工程学院<br>2015级<br>充满激情的程序员</p>
						  <p class="sub">希望进入这个网站的每一个人，<br>美丽，漂亮，帅气，逼人</p>
						</div>
						<div class="col-md-3 footer-grid tags">
								<h4>我们的标签</h4>
								<div class="border2"></div>
							<ul class="tag">
								<li><a href="#">疯狂的</a></li>
								<li><a href="#">码代码</a></li>
								<li><a href="#">激情</a></li>
								<li><a href="#">迎娶白富美</a></li>
								<li><a href="#">追求</a></li>
								<li><a href="#">游戏人生</a></li>
								<li><a href="#">勤劳的码农</a></li>
								<li><a href="#">阳光</a></li>
								<li><a href="#">呵呵呵</a></li>
								<li><a href="#">成为CEO</a></li>
								<li><a href="#">逗逼</a></li>
							</ul>
						</div>
						<div class="col-md-3 footer-grid tweet">
								<h4>团队成员</h4>
								<div class="border2"></div>
								<div class="icon-3-square">
										<a href="#"><i class="square-3"></i></a>
									</div>
							<div class="icon-text">
								<p>张一尘</p>
								<p>陈毅明</p>
							</div>
								<div class="clearfix"></div>
								<div class="icon-3-square">
										<a href="#"><i class="square-3"></i></a>
								</div>
								<div class="icon-text">
								    <p>陶光品</p>
								</div>
								<div class="clearfix"></div>
						</div>
						<div class="col-md-3 footer-grid flickr">
								
								<div class="border2"></div>
								<div class="flickr-grids">
										<div class="flickr-grid">
											<a href="#"><img src="images/f1.png" alt=" " title="CEO" /></a>
										</div>
										<div class="flickr-grid">
											<a href="#"><img src="images/f2.png" alt=" " title="GM" /></a>
										</div>
										<div class="flickr-grid">
											<a href="#"><img src="images/f3.png" alt=" " title="CEO" /></a>
										</div>
										<div class="clearfix"> </div>
										
										<div class="flickr-grid">
											<a href="#"><img src="images/f4.png" alt=" " title="GM" /></a>
										</div>
										<div class="flickr-grid">
											<a href="#"><img src="images/f5.png" alt=" " title="CEO" /></a>
										</div>
										<div class="flickr-grid">
											<a href="#"><img src="images/f6.png" alt=" " title="GM" /></a>
										</div>
								<div class="clearfix"> </div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
			</div>
		</div>
	<!--//end-footer-section-->
	
	<a href="#head" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
				<!--尾注部分--><!--/start-copyright-section-->
				<div class="copyright">
					<div class="container">
					<div class="logo2  wow bounceInLeft" data-wow-delay="0.4s"><a href="index.html"><img src="images/logo2.png" alt=""/ title="logo" /></a></div>
						<p class="write  wow bounceInRight" data-wow-delay="0.4s">Copyright &copy; 2015<a href="http://nankai.edu.cn" target="_blank" title="南开大学">南开大学社团联合会</a></p>
					</div>
					<div class="clearfix"></div>
				</div>	
</body>
</html>