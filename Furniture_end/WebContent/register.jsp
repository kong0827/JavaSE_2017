<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>-用户注册</title>

<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="css/new_file2.css"/>
		
		<script type="text/javascript">
		//自定义校验规则
		$.validator.addMethod(
			//规则的名称
			"checkUsername",
			//校验的函数
			function(value,element,params){
				
				//定义一个标志
				var flag = false;
				
				//value:输入的内容
				//element:被校验的元素对象
				//params：规则对应的参数值
				//目的：对输入的username进行ajax校验
				$.ajax({
					"async":false,
					"url":"${pageContext.request.contextPath}/checkUsername",
					"data":{"username":value},
					"type":"POST",
					"dataType":"json",
					"success":function(data){
						flag = data.isExist;
					}
				});
				
				
				//返回false代表该校验器不通过
				return !flag;
			}
			
		);
		
			$(function(){
				$("#registerForm").validate({
					rules:{
						"username":{
							"required":true,
							"checkUsername":true
							
						},
						"password":{
							"required":true,
							"rangelength":[6,12]
						},
						"repassword":{
							"required":true,
							"equalTo":"#password"
						},
						"email":{
							"required":true,
							"email":true
						}
					},
					messages:{
						"username":{
							"required":"用户名不能为空",
							"checkUsername":"用户名已存在"
						},
						"password":{
							"required":"密码不能为空",
							"rangelength":"密码长度6-12位"
						},
						"repassword":{
							"required":"确认密码不能为空",
							"equalTo":"两次密码不一致"
						},
						"email":{
							"required":"邮箱必填",
							"email":"邮箱格式不正确"
						}
					}, 
					errorPlacement:function(error, element) {//错误的显示。显示到输入框的实现。
				        element.val('');
				        element.attr("placeholder",error.html())
				    },
				    onkeyup: false //禁止keyup.
					
				});
			});
		</script>
		
</head>
<body>
	<div>
	
		<div class="register" >
			<div class="title">
				<span>注册</span>
				<a href="login.jsp">已有账号&gt;&gt;去登录&nbsp;&nbsp;</a>
			</div>
			<form action="${pageContext.request.contextPath }/user?method=register" onsubmit="" method="post"  id="registerForm">
					
				<div class="name">
					<input type="text" id="username" name="username" placeholder="&nbsp;&nbsp;用户名/手机" />
				</div>
				
				<div>
					<input type="password" id="password" name="password" placeholder="&nbsp;&nbsp;密码" />
				</div>
				<div >
					<input type="password" id="repassword" name="repassword" placeholder="&nbsp;&nbsp;确认密码" />
				</div>
				<div  >
					<input type="text" id="email" name="email" placeholder="&nbsp;&nbsp;邮箱" />
				</div>
				<div class="submit">
					<span id="">
						<a href="#">忘记密码</a>
					</span>
					
					<input type="submit" class="s_hover"  id="btn" value="注册"> 
				</div>
				
			</form>
			<div class="other_login">
				<div class="line1 left"></div>
				<div class="word left">社交账号登陆</div>
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
		
		
		<!-- JS --> 


	</body>
</html>