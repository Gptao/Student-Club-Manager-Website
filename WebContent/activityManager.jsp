<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>活动管理</title>
<link rel="shortcut icon" href="images/timg.ico" type="image/X-icon"/>
<link rel="stylesheet" href="css/mainDD.css">
<link rel="stylesheet" href="css/bootstrap.minDD.css">
<link rel="stylesheet" href="css/demoDD.css">
<link rel="stylesheet" href="css/animateDD.css" type='text/css' />
<link rel="stylesheet" href="css/styleDD.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/bootstrapDD.css" type='text/css' />
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
<script language="javascript">
	<% 
	String activity=(String)request.getAttribute("activity");
	if(activity!=null&&activity.equals("delete"))
	{		 
	%>
		alert("删除成功！");
	<%} %>
	
</script>
<!-- 页面拦截器，进入这个页面，先检查有没有登录 -->
<% 	Integer memberId=(Integer)session.getAttribute("username");     
    if(memberId==null)
    {
    	 request.setAttribute("msg", "您尚未登录，请先登录");
%>
   <jsp:forward page="login.jsp"></jsp:forward>
<%} %>
<!-- 进入首页之前，先从数据库拿数据 -->
<c:if test="${empty requestScope.actPage.dataList}">
	<jsp:forward page="Act_showAllForManager"></jsp:forward>
</c:if>
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
<!-- 表格部分 -->
<div class="header box css3-shadow" id="head">
	<div class="slider-bg">
		<div class="row">
			<div class="panel">
				<div class="panel-heading">
					<h2 class="panel-title">活动管理
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="Activity.jsp">发布活动</a>
					</h2>
				</div>
				<div class="panel-body">
					<table class="table table-striped">
						<tr>
							<th>活动编号</th>
							<th>活动名称</th>
							<th>活动时间</th>
							<th>活动地点</th>
							<th>主办单位</th>
							<th></th>
							<th></th>
						</tr>
						<c:forEach items="${requestScope.actPage.dataList}" var="act">
							<tr>
								<td>${act.activityId}</td>
								<td>${act.activityName}</td>
								<td>${act.activityTime}</td>
								<td>${act.activityLocation}</td>
								<td>${act.organization.organizationName}</td>
								<td><a href="Act_findActivityById?activityId=${act.activityId}" style="color: blue;">修改</a></td>
								<td><a href="Act_delete?activityId=${act.activityId}" style="color: blue;">删除</a></td>
							</tr>
						</c:forEach>
					</table>
					 总共${requestScope.actPage.totalPage}页	
					当前：第${requestScope.actPage.currentPage} / ${requestScope.actPage.totalPage}页
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
					请选择：第
					<c:forEach begin="1" end="${requestScope.actPage.totalPage}" step="1" var="i">
						<c:if test="${i==requestScope.actPage.currentPage}">
							【${i}】
						</c:if>
						<c:if test="${i!= requestScope.actPage.currentPage}">
							<a href="Act_showAllForManager?currentPage=${i}">${i}</a>
						</c:if>
					</c:forEach>
					页
				</div>
			</div>
		</div>
	</div>
</div>

<!--尾注部分--><!--/start-copyright-section-->
	<div class="clearfix"></div>
		<div class="copyright">
			<div class="container">
				<div class="logo2  wow bounceInLeft" data-wow-delay="0.4s"><a href="index.html"><img src="images/logo2.png" alt=""/ title="logo" /></a></div>
				<p class="write  wow bounceInRight" data-wow-delay="0.4s">Copyright &copy; 2015<a href="http://nankai.edu.cn" target="_blank" title="南开大学">南开大学社团联合会</a></p>
			</div>
			<div class="clearfix"></div>
		</div>
</body>
</html>