<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改活动</title>
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
<!-- 页面拦截器，进入这个页面，先检查有没有登录 -->
<% 	Integer memberId=(Integer)session.getAttribute("username");     
    if(memberId==null)
    {
    	 request.setAttribute("msg", "您尚未登录，请先登录");
%>
   <jsp:forward page="login.jsp"></jsp:forward>
<%} %>
</head>
 <!-- 进入之前，先从数据库把部门信息给找出来 -->
<c:if test="${empty sessionScope.DepartmentList}">
	<jsp:forward page="Department_findAllForActivityUpdate"></jsp:forward>
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
	
	<!-- 内容 -->
	<div class="container">
		<div class="content">
			<div class="col-md-9 single-page">
				
				<!-- 新增活动的表单部分 -->
				<div class="single-content">
					<div class="single">
						<!-- 填写留言的区域 -->
						<div class="leave">
							<h4>修改活动</h4>
						</div>
						<!-- 表单 -->
						<form id="commentform" class="wow fadeInRight animated" data-wow-delay="0.4s" action="Act_update" method="post">
							 <input type="hidden" name="activityId" value="${requestScope.activity.activityId}">
							 <p class="comment-form-author-name"><label for="actname">活动名称</label>
								<input id="actname" name="activityName" type="text"  size="30" aria-required="true" value="${requestScope.activity.activityName}">
							 </p>
							 <p class="comment-form-author-name"><label for="actname">活动主办单位</label>
							 	<input id="actOrg" name="organization.organizationId" type="text" list="itemlist2" size="30" aria-required="true" value="${requestScope.activity.organization.organizationId}">
							 		<datalist id="itemlist2">
                                    	<c:forEach items="${sessionScope.DepartmentList}" var="dpt">
										     <option value="${dpt.departmentId}">${dpt.organization.organizationName}${dpt.departmentName}</option>
										</c:forEach>
                                  	</datalist> <br/>
							 	 
							 </p>
							 <p class="comment-form-email">
								<label for="activityTime">活动时间</label>
								 <input type="date" style="border: 1px solid #DCDCDF;
								   	  color: #000;
								      height: 50px;
									  outline:none;
									  padding:0.8em 1em;
									  margin-top: 2em;
									  background:#EDEDED;
									  -webkit-appearance: none;
									  width: 100%;
									  font-weight: 400;
									  font-size: 16px;
									  transition: 0.5s all;
									  -webkit-transition: 0.5s all;
									  -moz-transition: 0.5s all;
									  -o-transition: 0.5s all;
									  -ms-transition: 0.5s all;
									  border-radius: 0.3em;
									  -o-border-radius: 0.3em;
									  -moz-border-radius: 0.3em;
									  -weblit-border-radius: 0.3em;" 
									  name="activityTime" value="${requestScope.activity.activityTime}" />
							 </p>
							 <p class="comment-form-url">
								<label for="actlocation">活动地点</label>
								<input id="actlocation" name="activityLocation" type="text" onfocus="this.value = '';" value="${requestScope.activity.activityLocation}" onblur="if (this.value == '') {this.value = '待定';}">
							 </p>
							 <p class="comment-form-comment">
								<label for="activityIntroduction">活动简介</label>
								<textarea name="activityIntroduction" style="height: 100px">${requestScope.activity.activityIntroduction}</textarea>
							 </p>
							 <p class="comment-form-comment">
								<label for="activityContent">活动内容介绍</label>
								<textarea name="activityContent" style="height: 800px">${requestScope.activity.activityIntroduction}</textarea>
							 </p>
							 <p class="comment-form-pic">
							 	<label for="activityPicture">选择需要上传的图片</label>							 
								<input id="File1" type="file" name="activityPicture" value="${requestScope.activity.activityPicture}"/>
							</p>
							 <div class="clearfix"></div>
							 <p class="form-submit">
							 	<input name="submit" type="submit" id="submit" value="更新">
							 </p>
							 <div class="clearfix"></div>
						   </form>
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
				
			</div>
		</div>
</body>
</html>