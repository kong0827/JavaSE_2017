<%@page import="com.hsd.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/new_file.css"/>
		<title></title>
		<!-- Basic page needs -->
<meta charset="utf-8">
<!--[if IE]>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <![endif]-->
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>MyStore premium HTML5 &amp; CSS3 template</title>
<meta name="description" content="">

<!-- Mobile specific metas  -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Favicon  -->
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico">

<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Poppins:400,300,500,600,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>



<!-- CSS Style -->

<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

<!-- font-awesome & simple line icons CSS -->
<link rel="stylesheet" type="text/css" href="css/font-awesome.css" media="all">
<link rel="stylesheet" type="text/css" href="css/simple-line-icons.css" media="all">

<!-- owl.carousel CSS -->
<link rel="stylesheet" type="text/css" href="css/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="css/owl.theme.css">
<link rel="stylesheet" type="text/css" href="css/owl.transitions.css">

<!-- animate CSS  -->
<link rel="stylesheet" type="text/css" href="css/animate.css" media="all">

<!-- flexslider CSS -->
<link rel="stylesheet" type="text/css" href="css/flexslider.css" >

<!-- jquery-ui.min CSS  -->
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css">

<!-- Revolution Slider CSS -->
<link href="css/revolution-slider.css" rel="stylesheet">

<!-- style CSS -->
<link rel="stylesheet" type="text/css" href="css/style.css" media="all">
<link rel="stylesheet" type="text/css" href="css/new_file.css"/>

  <script type="text/javascript">
	  function changeCode(){
		  var img_code=document.getElementById("img_code");
		  var time=new Date().getTime();
		  img_code.src="checkCode?r="+time;
		  
	  }
	 </script>
	</head>
	<body>
	<%-- <jsp:include page="header.jsp"></jsp:include> --%>
	<div class="box">
		<div class="register">
			<div class="title">
				<span>登录</span>
				<a href="register.jsp">没有账号&gt;&gt;去注册&nbsp;&nbsp;</a>
			</div>
			<form action="${pageContext.request.contextPath}/user?method=login" method="post">
				<%
					String username = "";
					String password = "";
					
					String checked="";
					//如果上次选择记住账号密码，则获取session域中的账号密码
					if(session.getAttribute("remeber")!=null){
						//设置checked属性，保证上次勾选后，下次能自动选中 
						 checked= "checked=";
						 if(session.getAttribute("username")!=null){
								username = (String)session.getAttribute("username");
								
							}
						 if(session.getAttribute("password")!=null){
								password = (String)session.getAttribute("password");				
							} 
					}
					
				
				%>
				<div style="color: red">&nbsp;&nbsp;&nbsp;${requestScope.msg }</div>
				<div class="name">
					<input type="text" id="username" value="<%=username %>" name="username" placeholder="&nbsp;&nbsp;用户名" />
				</div>
				<div class="password">
					<input type="password" id="password"  value="<%=password %>" name="password" placeholder="&nbsp;&nbsp;密码" />
				</div>
				
				
			
				
				<div class="submit">
					<span id="remeber_1">
						<!-- 设置checked属性，保证上次勾选后，下次能自动选中 -->
						<input type="checkbox" name="remeber" <%=checked %> id="remeber">记住账号密码
					</span>
					<span id="">
						<!-- <a href="#">忘记密码</a> -->
					</span>
					<input type="submit"  data-form="submit" id="btn" class="s_hover" id="btn" value="登陆" />
					<!-- <button class="s_hover" data-form="submit" id="btn">登录</button> -->
				</div>
				
			</form>
			
			<div class="other_login">
				<div class="line1 left"></div>
				<div class="word left">账号登陆</div>
				<div class="line2 left"></div>
				 <div class="icon left">
				 	<div class="QQ left">
				 		<a href="#"><img src="img/register/qq.png" width="32px" height="32px"/></a>
				 	</div>
				 	<div class="wexin left">
				 		<a href="#"><img src="img/register/wx.png" width="32px" height="32px"/></a>
				 	</div>
				 	<div class="weibo left">
				 		<a href="#"><img src="img/register/wb.png" width="32px" height="32px"/></a>
				 	</div>
				 </div>
				 
			</div>
		</div>
		</div>
		<!-- End Footer --> 
<!-- JS --> 

<!-- jquery js --> 
<script type="text/javascript" src="js/jquery.min.js"></script> 

<!-- bootstrap js --> 
<script type="text/javascript" src="js/bootstrap.min.js"></script> 

<!-- owl.carousel.min js --> 
<script type="text/javascript" src="js/owl.carousel.min.js"></script> 

<!-- bxslider js --> 
<script type="text/javascript" src="js/jquery.bxslider.js"></script> 

<!--jquery-slider js --> 
<script type="text/javascript" src="js/slider.js"></script> 

<!-- megamenu js --> 
<script type="text/javascript" src="js/megamenu.js"></script> 
<script type="text/javascript">
        /* <![CDATA[ */   
        var mega_menu = '0';
        
        /* ]]> */
        </script> 

<!-- jquery.mobile-menu js --> 
<script type="text/javascript" src="js/mobile-menu.js"></script> 

<!--jquery-ui.min js --> 
<script type="text/javascript" src="js/jquery-ui.js"></script> 

<!-- main js --> 
<script type="text/javascript" src="js/main.js"></script> 
		
	</body>
</html>
