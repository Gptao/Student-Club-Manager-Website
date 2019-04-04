<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>组织介绍</title>
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
<meta name="keywords" content="Studeon Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web 

template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function 

hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<link href='http://fonts.useso.com/css?family=Oswald:400,700,300|Open+Sans:300italic,400italic,600italic,400,300,600,700' 

rel='stylesheet' type='text/css'>
<!--//webfont-->
<!--Animation-->
<script src="js/wow.min.js"></script>
<link href="css/animate.css" rel='stylesheet' type='text/css' />
<script>
	new WOW().init();
</script>
</head>
<!-- 进入首页之前，先从数据库拿数据 -->
<c:if test="${empty requestScope.orgPage.dataList}">
	<jsp:forward page="Org_showAllForIntro"></jsp:forward><!-- OrganizationIntroduction -->
</c:if>
<c:if test="${empty requestScope.chatPage.dataList}">
	<jsp:forward page="Chat_search"></jsp:forward>
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
							<%-- <li><a href="exit.jsp" name="exit"  style="top: 100px; color: blue;">你

好 ${sessionScope.username}</a></li> --%>
						</ul>
				</div>
	
				<div class="clearfix"> </div>
				
			  </div><!-- end header_main4 -->
		</div>
	</div>
	
	<!-- 内容 -->
	<!-- 以下的内容都是从数据库里面找出来的，针对科协的记录 -->
	<c:forEach items="${requestScope.orgPage.dataList}" var="org">
		<c:if test="${org.organizationId == 1 and param.testid eq '1'}">	
			<div class="container">
				<div class="content">
					<div class="col-md-9 single-page">
						<!-- 图片和文字介绍部分 -->
						<div class="print-main wow fadeInLeft animated" data-wow-delay="0.4s">
							<h3>南开大学计算机与控制工程学院${org.organizationName}</h3>
		<p class="likes">Posted 06.01.2018  in Web Author By <a href="#">Ergo Chen</a>  / &nbsp;&nbsp;&nbsp;<a href="#">${sessionScope.chatPage.totalCount}</a>&nbsp;&nbsp; comments in total</p>
							<a href="https://cc.nankai.edu.cn/frontend/homepage/index.aspx"><img 

src="images/wrdjt.png" class="img-responsive" alt="" /></a>
							<ul class="single-icons">
								<li><a href="#"><i class="penc"></i></a></li>
								<li><i class="date2"></i></li>
							</ul>
							<p class="span"><a href="#">3D Printing, <a href="#">3D Software,</a><a 

href="#"> Files to Print </a> |  on february 14,2015</p>
							<p class="ptext">微软学生技术俱乐部是微软亚洲研究院与高校合作培养人才的一种

探索。俱乐部本着“学习先进技术，开拓创新思维，体验多元文化，成就一流人才”的宗旨，在各高校校团委、相关学院的指导下，通过学术讲座、技

术沙龙、兴趣小组、大型比赛、参观访问等活动，活跃学生学术气氛，丰富校园活动。目前，全国共有34个微软学生技术俱乐部。2000年10月第一个微

软学生技术俱乐部成立以来，俱乐部成员创新地组织了大量的技术、文化方面的实践活动。同学们自发组成多元化的实践小组，设计明确的实践主题，

通过项目研讨和实施过程，达到集团队合作、项目管理和技术、方法学习为一体的目标，从而潜移默化地培养学子们的“个人职业素养”等技巧。</p>
							<p class="ptext">创新是微软的灵魂，也是微软的文化。微软技术俱乐部的各种活动

，也都把创新作为自己的理念和追求目标，并通过这种方式，不断推陈出新，取得更大的效果。俱乐部讲座：微软技术俱乐部依托微软亚洲研究院的资

源，在所在学校和城市进行了大量形式新颖、反响热烈的讲座和培训。比如东南大学微软技术俱乐部的“七剑下江南”系列活动，南开大学微软技术技

术部的“奥运与微软”系列活动，华中科技大学“IT明灯”系列名师大讲坛等，都得到极高的赞扬。</p>
						</div>
						<!-- 下方留言部分 -->
						<div class="single-content">
							<div class="single">
								<!-- 填写留言的区域 -->
								<div class="leave">
									<h4>留言面板</h4>
								</div>
								<!-- 留言的表单 -->
						<form id="commentform" class="wow fadeInRight animated" data-wow-delay="0.4s" 

action="Chat_add" method="post">
							 <p class="comment-form-author-name"><label for="author">学号</label>
								<input id="author" name="messageAuthor" type="text" value="" 

size="30" aria-required="true">
							 </p>
							 <p class="comment-form-email">
								<label for="email">邮箱</label>
								<input id="email" name="messageMail" type="text" value="" size="30" 

aria-required="true">
							 </p>
							 <p class="comment-form-content">
								<label for="content">内容</label>
								<input id="content" name="messageContent" type="text" value="" 

size="30" aria-required="true">
							 </p>
							  <p class="comment-form-time">
								<input id="time" name="messageTime" type="hidden" value="2016-05-09" 

size="30" aria-required="true">
                                <input id="tag" name="tag" type="hidden" value=1 

size="30" aria-required="true">
							 </p>
							 <div class="clearfix"></div>
							 <p class="form-submit">
							 	<input name="submit" type="submit" id="submit" value="提交">
							 </p>
							 <div class="clearfix"></div>
						   </form>
						</div>
						<div class="comments1">
							<h4>留言墙</h4>
							<!-- 留言部分 -->
							<c:forEach items="${requestScope.chatPage.dataList}" var="chat">
							<c:if test="${chat.tag==1 }">
							<div class="comments-main wow fadeInLeft animated" data-wow-delay="0.4s">
								<div class="col-md-3 cmts-main-left">
									<img src="images/avatar.jpg" alt="">
								</div>
								<div class="col-md-9 cmts-main-right">
									<a href="#"><h5>${chat.messageAuthor}</h5></a>
									<p>${chat.messageContent} </p>
									<div class="cmts">
										<div class="col-md-8 cmnts-left">
										<p>${chat.messageMail} </p>
										<p>${chat.messageTime}</p>
										</div>
										<div class="clearfix"></div>
									</div>
								</div>
								<div class="clearfix"></div>
							</div>
				</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
				<!-- 右方导航部分 -->
				<!--start-right-content-->
				<div class="col-md-3 right-content">
				  	<h5>Blog Search</h5>
					<div class="search">
						<form>
							<input type="text" value="Enter to search..." onfocus="this.value='';" 

onblur="if (this.value == '') {this.value ='';}">
							<input type="submit" value="">
						</form>
					</div>
					<!-- 立即报名按钮，没有用div美化 -->
					
					<a href="register.jsp"><input type="button" value="立即报名" style="font-size: 

40px;background-color: orange;border-bottom-style: solid;"></a>
					
					
					<div class="categories">
						<h4>下属部门</h4>
						<ul class="category">
					
					
								<!-- 找到科技协会的记录，以下列出他的下辖部门-->
								<c:forEach items="${org.departments}" var="deps">
									<li><a href="#">${deps.departmentName}</a></li>
								</c:forEach>
							
						</ul>
					</div>
					<div class="sidebar-bottom">
						<h5>近期活动</h5>
						<ul>
							<li><a href="#">February 2015</a></li>
							<li><a href="#">January 2015</a></li>
							<li><a href="#">December 2015</a></li>
							<li><a href="#">November 2015</a></li>
							<li><a href="#">February 2015</a></li>
							<li><a href="#">December 2015</a></li>
							</ul>
					</div>
					<div class="featured">
						<h4>部门风采</h4>
						<ul>
							<li><a href="single.html"><img src="images/s1.jpg" alt=""/></a></li>
							<li><a href="single.html"><img src="images/s2.jpg" alt=""/></a></li>
							<li><a href="single.html"><img src="images/s3.jpg" alt=""/></a></li>
							<li><a href="single.html"><img src="images/s4.jpg" alt=""/></a></li>
							<li><a href="single.html"><img src="images/s5.jpg" alt=""/></a></li>
							<li><a href="single.html"><img src="images/s6.jpg" alt=""/></a></li>
						</ul>
					</div>
				</div>
				
				<div class="clearfix"></div>				
			</div>
		</div>
		</c:if>
		
		<c:if test="${org.organizationId == 2 and param.testid eq '2'}">	
			<div class="container">
				<div class="content">
					<div class="col-md-9 single-page">
						<!-- 图片和文字介绍部分 -->
						<div class="print-main wow fadeInLeft animated" data-wow-delay="0.4s">
							<h3>南开大学计算机与控制工程学院${org.organizationName}</h3>
		<p class="likes">Posted 06.01.2018  in Web Author By <a 

href="#">Ergo Chen</a>  / &nbsp;&nbsp;&nbsp;<a href="#">${sessionScope.chatPage.totalCount}</a>&nbsp;&nbsp; comments in total</p>
							<a href="https://cc.nankai.edu.cn/frontend/homepage/index.aspx"><img 

src="images/kx.jpg" class="img-responsive" alt="" /></a>
							<ul class="single-icons">
								<li><a href="#"><i class="penc"></i></a></li>
								<li><i class="date2"></i></li>
							</ul>
							<p class="span"><a href="#">3D Printing, <a href="#">3D Software,</a><a 

href="#"> Files to Print </a> |  on february 14,2015</p>
							<p class="ptext">为尽快完善学生会组织建设，推动学院各项工作的顺利进行，2018年4月14日19：00，内江师范学院计算机科学学院第十八届副部竞选大会在一教201、202教室成功拉开帷幕。我院副书记王瑛杰、辅导员杨超及全体学生会成员参加了此次换届选举大会。

会议伊始，学生会主席蒲杰同学就以往学生会工作做了总结与回顾。接着就竞选过程中需要注意的问题给予选手们进行了简明扼要的提醒，并鼓励大家充分发挥自己的能力，争取在竞选过程中有一个出色的表现。

</p>
							<p class="ptext">竞选期间，学生会干事们个个精神饱满，自信从容，充分发表了自己对所竞选职位的认识，介绍了自己在过去的半年中所做的工作内容，也抒发了对未来的美好期望，他们各尽所能，充分施展自己的才华、以昂扬的姿态彰显出自我的优势。现场答辩环节更是值得关注，干事们针对评委们提出的有关学生干部应具备的能力、学习与工作的关系、能力与做人等问题进行了独到的答辩。他们灵活的应变能力、良好的个人素质以及积极进取的精神赢得评委们的一致认可。

竞选结束后，我院副书记王瑛杰和辅导员杨超对此次竞选做出了总结，他们要求新一届副部长以高度的责任感和饱满的热情投入到工作中，认真为同学们服务，不要对自己副部长的职位有特殊态度，严格要求自我，不要止步于此，要有更高的目标。部长之间也要团结协助开拓进取，争做一个团组织信赖、学生满意的组织，以促进学院更好发展。

本次竞选活动，为计科学院带来了新的力量与希望。不仅为同学们充分展示自我提供了一个广阔的平台，也为该院全面落实学院工作的开展提供了保障，打下了坚实的基础。据悉，此次竞选的结果将于下周一公布。</p>
						</div>
						<!-- 下方留言部分 -->
						<div class="single-content">
							<div class="single">
								<!-- 填写留言的区域 -->
								<div class="leave">
									<h4>留言面板</h4>
								</div>
								<!-- 留言的表单 -->
						<form id="commentform" class="wow fadeInRight animated" data-wow-delay="0.4s" 

action="Chat_add" method="post">
							 <p class="comment-form-author-name"><label for="author">学号</label>
								<input id="author" name="messageAuthor" type="text" value="" 

size="30" aria-required="true">
							 </p>
							 <p class="comment-form-email">
								<label for="email">邮箱</label>
								<input id="email" name="messageMail" type="text" value="" size="30" 

aria-required="true">
							 </p>
							 <p class="comment-form-content">
								<label for="content">内容</label>
								<input id="content" name="messageContent" type="text" value="" 

size="30" aria-required="true">
							 </p>
							  <p class="comment-form-time">
							<input id="time" name="messageTime" type="hidden" value="2016-05-09" 

size="30" aria-required="true">
                            <input id="tag" name="tag" type="hidden" value=2 

size="30" aria-required="true">
							 </p>
							 <div class="clearfix"></div>
							 <p class="form-submit">
							 	<input name="submit" type="submit" id="submit" value="提交">
							 </p>
							 <div class="clearfix"></div>
						   </form>
						</div>
						<div class="comments1">
							<h4>留言墙</h4>
							<!-- 留言部分 -->
							<c:forEach items="${requestScope.chatPage.dataList}" var="chat">
							<c:if test="${chat.tag==2 }">
							<div class="comments-main wow fadeInLeft animated" data-wow-delay="0.4s">
								<div class="col-md-3 cmts-main-left">
									<img src="images/avatar.jpg" alt="">
								</div>
								<div class="col-md-9 cmts-main-right">
									<a href="#"><h5>${chat.messageAuthor}</h5></a>
									<p>${chat.messageContent} </p>
									<div class="cmts">
										<div class="col-md-8 cmnts-left">
										<p>${chat.messageMail} </p>
										<p>${chat.messageTime}</p>
										</div>
										<div class="clearfix"></div>
									</div>
								</div>
								<div class="clearfix"></div>
							</div>
							</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
				<!-- 右方导航部分 -->
				<!--start-right-content-->
				<div class="col-md-3 right-content">
				  	<h5>Blog Search</h5>
					<div class="search">
						<form>
							<input type="text" value="Enter to search..." onfocus="this.value='';" 

onblur="if (this.value == '') {this.value ='';}">
							<input type="submit" value="">
						</form>
					</div>
					<!-- 立即报名按钮，没有用div美化 -->
					
					<a href="register.jsp"><input type="button" value="立即报名" style="font-size: 

40px;background-color: orange;border-bottom-style: solid;"></a>
					
					
					<div class="categories">
						<h4>下属部门</h4>
						<ul class="category">
					
					
								<!-- 找到科技协会的记录，以下列出他的下辖部门-->
								<c:forEach items="${org.departments}" var="deps">
									<li><a href="#">${deps.departmentName}</a></li>
								</c:forEach>
							
						</ul>
					</div>
					<div class="sidebar-bottom">
						<h5>近期活动</h5>
						<ul>
							<li><a href="#">February 2015</a></li>
							<li><a href="#">January 2015</a></li>
							<li><a href="#">December 2015</a></li>
							<li><a href="#">November 2015</a></li>
							<li><a href="#">February 2015</a></li>
							<li><a href="#">December 2015</a></li>
							</ul>
					</div>
					<div class="featured">
						<h4>部门风采</h4>
						<ul>
							<li><a href="single.html"><img src="images/s1.jpg" alt=""/></a></li>
							<li><a href="single.html"><img src="images/s2.jpg" alt=""/></a></li>
							<li><a href="single.html"><img src="images/s3.jpg" alt=""/></a></li>
							<li><a href="single.html"><img src="images/s4.jpg" alt=""/></a></li>
							<li><a href="single.html"><img src="images/s5.jpg" alt=""/></a></li>
							<li><a href="single.html"><img src="images/s6.jpg" alt=""/></a></li>
						</ul>
					</div>
				</div>
				
				<div class="clearfix"></div>				
			</div>
		</div>
		</c:if>
						</c:forEach>
<!--尾注部分--><!--/start-copyright-section-->
				<div class="copyright">
					<div class="container">
					<div class="logo2  wow bounceInLeft" data-wow-delay="0.4s"><a href="index.html"><img 

src="images/logo2.png" alt=""/ title="logo" /></a></div>
						<p class="write  wow bounceInRight" data-wow-delay="0.4s">Copyright &copy; 2015<a 

href="http://nankai.edu.cn" target="_blank" title="南开大学">南开大学社团联合会</a></p>
					</div>
					<div class="clearfix"></div>
				</div>
</body>
</html>