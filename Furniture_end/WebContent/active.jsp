<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
	<%
		String code = request.getParameter("code");
		//System.out.print(code);
	%>
		<p>恭喜你领取优惠券成功，优惠券编号为<span style="color: red; font-size: 15px"><%=code %></span></p>
		<p>使用优惠券<a href="http://localhost:8080/Furniture_end/index.jsp">点击这里，立即前往商城首页</a></p>
	</body>
</html>