<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
 	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript">
		window.onload = function(){
			second = document.getElementById("second").innerHTML;
			time = window.setInterval("subSecond()",1000);
			
		}
		
		function subSecond(){
			second = second - 1;
			document.getElementById("second").innerHTML = second;
			
			if(second==0){
				clearInterval(time);
				window.location.href = "${pageContext.request.contextPath}/login.jsp"
			}
		}
		</script>
	</head>
	<body>
		<p>注册成功，<span id="second">3</span>秒后自动跳转登录界面</p>
	</body>
</html>