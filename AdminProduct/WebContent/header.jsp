<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="img/logo2.png" />
	</div>
	<div class="col-md-5">
		<img src="img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
			<c:if test="${empty sessionScope.user }">
				<li><a href="login.jsp">登录</a></li>
				<li><a href="register.jsp">注册</a></li>
			</c:if>
			
			<c:if test="${!empty sessionScope.user }">
				<li><a href="login.jsp">${user.username}</a></li>
				
			</c:if>
			<li><a href="cart.jsp">购物车</a></li>
			<li><a href="order_list.jsp">我的订单</a></li>
		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a  class="navbar-brand" href="index.jsp">首页</a>
			</div>
			
			<script type="text/javascript">
				$(function(){
					var content;
					$.ajax({
						url:"${pageContext.request.contextPath}/categoryList",
						async:true,
						dataType:"json",
						type:"GET",
						success:function(data){
							//<li><a href="#">手机数码<span class="sr-only"></span></a></li>
							//alert(data[0].cname);
							for(var i=0; i<data.length; i++){
								content+="<li><a href='${pageContext.request.contextPath}/productListByCid?cid="+data[i].cid+"'>"+data[i].cname+"</a></li>";
								
							}
							$("#categoryId").html(content);
						}
					});
				});
			
			</script>
			

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" id="categoryId">
					
					
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group" style="position:relative">
						<input  id="search"  type="text" class="form-control" placeholder="Search" id="showWord" onkeyup="searchWord(this)">
						<div id="showDiv" style="display:none;position:absolute;z-index:1000;background:#fff;width:170px; border:1px solid gray"></div>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
				 <script type="text/javascript">
				 
				 function overFn(obj){
						$(obj).css("background","#DBEAF9");
					}
					function outFn(obj){
						$(obj).css("background","#fff");
					}
					
					function clickFn(obj){
						$("#search").val($(obj).html());
						$("#showDiv").css("display","none");
					}
					function searchWord(obj){
						var word = obj.value;
						var content= "";
						$.post(
							"${pageContext.request.contextPath}/searchWord",
							{"word":word},
							function(data){
								for(var i=0; i<data.length; i++){
									content +="<div style='padding:3px;cursor:pointer' onclick='clickFn(this)' onmouseover='overFn(this)' onmouseout='outFn(this)'>"+data[i]+"</div>";
								}
								$("#showDiv").html(content);
								if(data!=null){
									$("#showDiv").css("display","block");
								}
							},
							"json"
						
						);
					}
					
				</script> 
			
			</div>
		</div>
	</nav>
</div>