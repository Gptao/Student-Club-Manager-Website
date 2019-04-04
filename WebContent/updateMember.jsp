<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新成员</title>
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
<!-- 进入之前，先从数据库把部门信息给找出来 -->


<c:if test="${empty sessionScope.DepartmentList}">
	<jsp:forward page="Department_findAllForUpdateMember"></jsp:forward>
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
<!--报名表部分-->
		<div class ="contact-section">
			<div class="container">
				<div class="contact">
					<h3 class="wow bounceIn" data-wow-delay="0.4s">修改成员</h3>
						<form class="wow bounceIn" data-wow-delay="0.4s" action="Member_update" method="post">
						 学&nbsp;&nbsp;&nbsp;&nbsp;号 <input type="text" style="width: 45%;" name="memberId" value="${requestScope.member.memberId}">
							姓名 <input type="text" style="width: 45%;" name="memberName" value="${requestScope.member.memberName}"><br/>
						
							性&nbsp;&nbsp;&nbsp;&nbsp;别 <input type="text" style="width: 45%;" list="itemlist1"  name="memberGender" value="${requestScope.member.memberGender}">
							        <datalist id="itemlist1">
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                    </datalist>
							籍贯<input type="text" style="width: 45%;" list="itemlist2"  name="memberHometown" value="${requestScope.member.memberHometown}">
                                    <datalist id="itemlist2">
                                    <option value="北京">北京</option>
                                    <option value="天津">天津</option>
                                    <option value="山东">山东</option>
                                    <option value="福建">福建</option>
                                    <option value="浙江">浙江</option>
                                    <option value="重庆">重庆</option>
                                    <option value="四川">四川</option>
                                    <option value="云南">云南</option>
                                    <option value="贵州">贵州</option>
                                    <option value="安徽">安徽</option>
                                    <option value="广东">广东</option>
                                    <option value="江苏">江苏</option>
                                    <option value="山西">山西</option>
                                    <option value="陕西">陕西</option>
                                    <option value="宁夏">宁夏</option>
                                    <option value="西藏">西藏</option>
                                    <option value="台湾">台湾</option>
                                    </datalist> <br/>
							
								联系电话 <input type="text"  style="width: 45%;" name="memberPhone" value="${requestScope.member.memberPhone}">
							专业 <input type="text" list="itemlist4"  style="width: 45%;" name="memberMajor" value="${requestScope.member.memberMajor}"><br/>
							       <datalist id="itemlist4">
                                    <option value="计算机科学与技术">计算机科学与技术</option>
                                    <option value="物联网">物联网</option>
                                    <option value="信息安全">信息安全</option>
                                    <option value="自动化">自动化</option>
                                    <option value="智能科学与技术">智能科学与技术</option>
                                    
                                    </datalist> <br/>
							<!--  <input type="text" placeholder="报名时间（2017-07-19）" required=" " name="time">-->
							报名时间 <input type="date" style="border: 1px solid #DCDCDF;
								    color: #000;
								    height: 50px;
								  outline:none;
								  padding:0.8em 1em;
								  margin-top: 2em;
								  background:#EDEDED;
								  -webkit-appearance: none;
								  width: 45%;
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
								  -weblit-border-radius: 0.3em;" name="time" />
							生日 <input type="date" style="border: 1px solid #DCDCDF;
									    color: #000;
									    height: 50px;
									  outline:none;
									  padding:0.8em 1em;
									  margin-top: 2em;
									  background:#EDEDED;
									  -webkit-appearance: none;
									  width: 45%;
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
									  -weblit-border-radius: 0.3em;" name="memberBirthday" value="${requestScope.register.registerBirthday}"><br/><br/>
						
						
							部门 <input type="text"  required=" " list="itemlist5" style="width: 100%;" name="department.departmentId">
							        <datalist id="itemlist5">
                                    <c:forEach items="${sessionScope.DepartmentList}" var="dpt">
										     <option value="${dpt.departmentId}">${dpt.organization.organizationName}${dpt.departmentName}</option>
										</c:forEach>
                                    
                                    </datalist>
							<br/><br/>
							职位 <input type="text"  required=" " list="itemlist6" style="width: 100%;" name="memberPosition"><br/><br/>
							        <datalist id="itemlist6">
                                    <option value="高层">高层</option>
                                    <option value="中层">中层</option>
                                    <option value="干事">干事</option>
                                    
                                    </datalist>
							<input type="submit" value="确认修改">
							<a href="member_delete?memberId=${member.memberId}">删除</a>
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
		</div></body> 
</html>