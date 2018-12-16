<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>注册页面</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/regist" method="post" enctype="multipart/form-data">
		<input type="text" name="username"><br>
		<input type="file" name="filename"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>