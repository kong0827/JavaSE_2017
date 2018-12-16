<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>JSP Page</title>
</head>
<body>
	<%
		//先判断缓存中是否存在，不存在去数据库查找
		GetUser users = new GetUser();
		List<User> list = users.getUser();
		//将查找到 的list集合以json形式存入缓存
		Gson gson = new Gson();
		String listJson = gson.toJson(list);
		
		request.setAttribute("list", listJson);
	%>

</body>
</html>