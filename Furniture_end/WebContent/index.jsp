<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
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
<script type="text/javascript">
	function hidePopup() {
		//alert(obj.checked)
		//alert("${pageContext.request.contextPath}/notShowPopup?checked="+obj.checked)
		checked = document.getElementById("notshowpopup").checked;
		if(checked)  //不再弹出时才跳转，否则不做任何操作 
		window.location.href = "${pageContext.request.contextPath}/notShowPopup";	
	}

</script>
</head>

<body class="cms-index-index cms-home-page">

<!--[if lt IE 8]>
      <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
  <![endif]--> 
<!-- mobile menu -->
<div id="mobile-menu">
  <div id="mobile-search">
    <form>
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
        <button class="btn-search" type="button"><i class="fa fa-search"></i></button>
      </div>
    </form>
  </div>
  <ul>
    <li><a href="index.html" class="home1">Home</a>
      <ul>
        <li><a href="../Version1/index.html"><span>Home Version 1</span></a></li>
        <li><a href="index.html"><span>Home Version 2</span></a></li>
        <li><a href="../Version3/index.html"><span>Home Version 3</span></a></li>
        <li><a href="../Version4/index.html"><span>Home Version 4</span></a></li>
        <li><a href="../Version5/index.html"><span>Home Version 5</span></a></li>
        
      
      </ul>
    </li>
    <li><a href="shop_grid.html">Pages</a>
      <ul>
        <li><a href="#" class="">Shop Pages </a>
          <ul>
            <li> <a href="shop_grid.html"> Shop grid </a> </li>
            <li> <a href="shop_grid_right_sidebar.html"> Shop grid right sidebar</a> </li>
            <li> <a href="shop_list.html"> Shop list </a> </li>
            <li> <a href="shop_list_right_sidebar.html"> Shop list right sidebar</a> </li>
            <li> <a href="shop_grid_full_width.html"> Shop Full width </a> </li>
          </ul>
        </li>
        <li><a href="#">Ecommerce Pages </a>
          <ul>
            <li> <a href="wishlist.html"> Wishlists </a> </li>
            <li> <a href="checkout.html"> Checkout </a> </li>
            <li> <a href="compare.html"> Compare </a> </li>
            <li> <a href="shopping_cart.html"> Shopping cart </a> </li>
            <li> <a href="quick_view.html"> Quick View </a> </li>
          </ul>
        </li>
        <li> <a href="#">Static Pages </a>
          <ul>
            <li> <a href="account_page.html"> Create Account Page </a> </li>
            <li> <a href="about_us.html"> About Us </a> </li>
            <li> <a href="contact_us.html"> Contact us </a> </li>
            <li> <a href="404error.html"> Error 404 </a> </li>
            <li> <a href="faq.html"> FAQ </a> </li>
          </ul>
        </li>
        <li> <a href="#">Product Categories </a>
          <ul>
            <li> <a href="cat-3-col.html"> 3 Column Sidebar </a> </li>
            <li> <a href="cat-4-col.html"> 4 Column Sidebar</a> </li>
            <li> <a href="cat-4-col-full.html"> 4 Column Full width </a> </li>
            <li> <a href="cat-6-col.html"> 6 Columns Full width</a> </li>
          </ul>
        </li>
        <li> <a href="#">Single Product Pages </a>
          <ul>
            <li><a href="single_product.html"> single product </a> </li>
            <li> <a href="single_product_left_sidebar.html"> single product left sidebar</a> </li>
            <li> <a href="single_product_right_sidebar.html"> single product right sidebar</a> </li>
            <li> <a href="single_product_magnify_zoom.html"> single product magnify zoom</a> </li>
          </ul>
        </li>
        <li> <a href="#"> Blog Pages </a>
          <ul>
            <li><a href="blog_right_sidebar.html">Blog – Right sidebar </a></li>
            <li><a href="blog_left_sidebar.html">Blog – Left sidebar </a></li>
            <li><a href="blog_full_width.html">Blog_ - Full width</a></li>
            <li><a href="single_post.html">Single post </a></li>
          </ul>
        </li>
      </ul>
    </li>
    <li><a href="contact_us.html">Contact us</a></li>
    <li><a href="about_us.html">About us</a></li>
    <li><a href="blog.html">Blog</a>
      <ul>
        <li><a href="blog_right_sidebar.html">Blog – Right sidebar </a></li>
        <li><a href="blog_left_sidebar.html">Blog – Left sidebar </a></li>
        <li><a href="blog_full_width.html">Blog_ - Full width</a></li>
        <li><a href="single_post.html">Single post </a></li>
      </ul>
    </li>
    <li><a href="shop_grid.html">Home Appliances</a>
      <ul>
        <li><a href="#" class="">Room Heaters</a>
          <ul>
            <li><a href="shop_grid.html">Cocktail</a></li>
            <li><a href="shop_grid.html">Day</a></li>
            <li><a href="shop_grid.html">Evening</a></li>
            <li><a href="shop_grid.html">Sundresses</a></li>
          </ul>
        </li>
        <li><a href="#">Lightings</a>
          <ul>
            <li><a href="shop_grid.html">Accessories</a></li>
            <li><a href="shop_grid.html">Hats and Gloves</a></li>
            <li><a href="shop_grid.html">Lifestyle</a></li>
            <li><a href="shop_grid.html">Bras</a></li>
          </ul>
        </li>
        <li> <a href="#">Outdoor Furniture</a>
          <ul>
            <li> <a href="shop_grid.html">Flat Shoes</a> </li>
            <li> <a href="shop_grid.html">Flat Sandals</a> </li>
            <li> <a href="shop_grid.html">Boots</a> </li>
            <li> <a href="shop_grid.html">Heels</a> </li>
          </ul>
        </li>
        <li> <a href="#">Air Coolers</a>
          <ul>
            <li> <a href="shop_grid.html">Bracelets</a> </li>
            <li> <a href="shop_grid.html">Necklaces &amp; Pendent</a> </li>
            <li> <a href="shop_grid.html">Pendants</a> </li>
            <li> <a href="shop_grid.html">Pins &amp; Brooches</a> </li>
          </ul>
        </li>
        <li> <a href="#">Microwave Ovens</a>
          <ul>
            <li> <a href="shop_grid.html">Casual Dresses</a> </li>
            <li> <a href="shop_grid.html">Evening</a> </li>
            <li> <a href="shop_grid.html">Designer</a> </li>
            <li> <a href="shop_grid.html">Party</a> </li>
          </ul>
        </li>
        <li> <a href="#">Nightstands</a>
          <ul>
            <li> <a href="shop_grid.html">Swimsuits</a> </li>
            <li> <a href="shop_grid.html">Beach Clothing</a> </li>
            <li> <a href="shop_grid.html">Clothing</a> </li>
            <li> <a href="shop_grid.html">Bikinis</a> </li>
          </ul>
        </li>
      </ul>
    </li>
    <li><a href="shop_grid.html">Living Rooms</a>
      <ul>
        <li> <a href="#" class="">Sofas</a>
          <ul class="level1">
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">Coats &amp; Jackets</a> </li>
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">Raincoats</a> </li>
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">Blazers</a> </li>
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">Jackets</a> </li>
          </ul>
        </li>
        <li> <a href="#">Folding Chairs</a>
          <ul class="level1">
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">Casual Dresses</a> </li>
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">Evening</a> </li>
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">Designer</a> </li>
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">Party</a> </li>
          </ul>
        </li>
        <li> <a href="#" class="">Side Tables</a>
          <ul class="level1">
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">Sport Shoes</a> </li>
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">Casual Shoes</a> </li>
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">Leather Shoes</a> </li>
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">canvas shoes</a> </li>
          </ul>
        </li>
        <li> <a href="#">Designer</a>
          <ul class="level1">
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">Coats</a> </li>
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">Formal Jackets</a> </li>
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">Leather Jackets</a> </li>
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">Blazers</a> </li>
          </ul>
        </li>
        <li> <a href="#">Accesories</a>
          <ul class="level1">
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">Backpacks</a> </li>
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">Wallets</a> </li>
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">Laptops Bags</a> </li>
            <li class="level2 nav-6-1-1"> <a href="shop_grid.html">Belts</a> </li>
          </ul>
        </li>
      </ul>
    </li>
    <li><a href="shop_grid.html">Home Office</a>
      <ul>
        <li> <a href="shop_grid.html">Wall Units</a>
          <ul>
            <li> <a href="shop_grid.html">iPhone</a> </li>
            <li> <a href="shop_grid.html">Samsung</a> </li>
            <li> <a href="shop_grid.html">Nokia</a> </li>
            <li> <a href="shop_grid.html">Sony</a> </li>
          </ul>
        </li>
        <li> <a href="shop_grid.html" class="">Bedroom</a>
          <ul>
            <li> <a href="shop_grid.html">Audio</a> </li>
            <li> <a href="shop_grid.html">Cameras</a> </li>
            <li> <a href="shop_grid.html">Appling</a> </li>
            <li> <a href="shop_grid.html">Car Music</a> </li>
          </ul>
        </li>
        <li> <a href="shop_grid.html">Kitchen & Dining</a>
          <ul>
            <li> <a href="shop_grid.html">Home &amp; Office</a> </li>
            <li> <a href="shop_grid.html">TV &amp; Home Theater</a> </li>
            <li> <a href="shop_grid.html">Phones &amp; Radio</a> </li>
            <li> <a href="shop_grid.html">All Electronics</a> </li>
          </ul>
        </li>
      </ul>
    </li>
  </ul>
</div>
<!-- end mobile menu -->
<div id="page"> 
 
  <%
   //首先设置显示
   	String show = "";
   	String display="";
  	 Cookie[] cookies = request.getCookies();
  	 
   	 if(cookies!=null){
   		for(Cookie cookie : cookies ){
   			//dangcookie中有数据时，即选中不再显示时，则设置其隐藏
   			if(cookie.getName().equals("popup")){
   				display = "display: ";
   				show = cookie.getValue();
   			}
   		}
   	}
   
   %>
 
  <!--Newsletter Popup Start-->
  <div id="newsletter-popup-conatiner"  style="<%=display%><%=show%>">
    <div id="newsletter-pop-up"> <span class="hide-popup"  onclick="hidePopup()">X</span>
      <div class="subscribe-pop-up">
        <div class="title-subscribe">
          <h1>加入我们的即时通讯</h1>
        </div>
        <form id="newsletter-form" method="post" action="${pageContext.request.contextPath}/getDiscount">
          <div class="content-subscribe">
            <div class="form-subscribe-header">
              <label>输入你的电子邮件，我们会给你一张优惠券，下一个订单会有10%的折扣.</label>
            </div>
            <div class="input-box">
              <input type="text" class="input-text newsletter-subscribe" title="Sign up for our newsletter" name="email" placeholder="Enter your email address">
            </div>
            <div class="actions">
              <button class="button-subscribe" title="Subscribe" type="submit">发 送</button>
            </div>
          </div>
        </form>
        <div class="subscribe-bottom">
          <input name="notshowpopup" id="notshowpopup" type="checkbox">
       	  不再弹出 </div>
      </div>
    </div>
  </div>
  <!--End of Newsletter Popup--> 
  
  <!-- Header -->
  <!-- 引入头部 -->
  <jsp:include page="header.jsp"></jsp:include>
  <!-- end header --> 
  
  <!-- Navbar -->
  
  <!-- end nav --> 
  
  <!-- Home Slider Start -->
  
  <div id="home-section" class="slider1">
    <div class="tp-banner-container">
      <div class="tp-banner" >
        <ul>
          <!-- SLIDE  -->
          <li data-transition="fade" data-slotamount="7" data-masterspeed="500" data-saveperformance="on"  data-title="Intro Slide"> 
            <!-- MAIN IMAGE --> 
            <img src="images/slider/slider-bg1.jpg"  alt="slidebg1" data-lazyload="images/slider/slider-bg1.jpg" data-bgposition="center top" data-bgfit="cover" data-bgrepeat="no-repeat"> 
            <!-- LAYERS --> 
            
            <!-- LAYER NR. 1 -->
            <div class="tp-caption small_text lft tp-resizeme rs-parallaxlevel-0"
								data-x="0"
								data-y="245" 
								data-customin="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0;scaleY:0;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
								data-speed="500"
								data-start="1200"
								data-easing="Power3.easeInOut"
								data-splitin="none"
								data-splitout="none"
								data-elementdelay="0.1"
								data-endelementdelay="0.1"
								style="z-index: 7; max-width: auto; max-height: auto; white-space: nowrap; font-size:24px; font-weight:500; color:#fff; background-color:#f4a137; padding:15px 25px;">the new design collection </div>
            
            <!-- LAYER NR. 2 -->
            <div class="tp-caption finewide_medium_white lfl tp-resizeme rs-parallaxlevel-0"
								data-x="0"
								data-y="315" 
								data-customin="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0;scaleY:0;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
								data-speed="500"
								data-start="1800"
								data-easing="Power3.easeInOut"
								data-splitin="none"
								data-splitout="none"
								data-elementdelay="0.1"
								data-endelementdelay="0.1"
								style="z-index: 8; max-width: auto; max-height: auto; white-space: nowrap; font-size:50px; font-weight:700; color:#222;">new arrivals <br>
              the sofa deser </div>
            
            <!-- LAYER NR. 3 -->
            <div class="tp-caption small_text customin tp-resizeme rs-parallaxlevel-0"
								data-x="0"
								data-y="440" 
								data-customin="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0;scaleY:0;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
								data-speed="500"
								data-start="2000"
								data-easing="Power3.easeInOut"
								data-splitin="none"
								data-splitout="none"
								data-elementdelay="0.1"
								data-endelementdelay="0.1"
								style="z-index: 7; max-width: auto; max-height: auto; white-space: nowrap;">
              <p class="line hidden-xs"></p>
            </div>
            
            <!-- LAYER NR. 4 -->
            <div class="tp-caption small_text lfb tp-resizeme rs-parallaxlevel-0"
								data-x="0"
								data-y="470" 
								data-customin="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0;scaleY:0;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
								data-speed="500"
								data-start="2400"
								data-easing="Power3.easeInOut"
								data-splitin="none"
								data-splitout="none"
								data-elementdelay="0.1"
								data-endelementdelay="0.1"
								style="z-index: 7; max-width: auto; max-height: auto; white-space: nowrap; color:#666;">Up to 75% Off Furnitured Design Shop Now </div>
            
            <!-- LAYER NR. 5 -->
            <div class="tp-caption lfr tp-resizeme rs-parallaxlevel-0"
								data-x="450"
								data-y="450"
								data-customin="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0;scaleY:0;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
								data-speed="500"
								data-start="2800"
								data-easing="Power3.easeInOut"
								data-splitin="none"
								data-splitout="none"
								data-elementdelay="0.1"
								data-endelementdelay="0.1"
								data-linktoslide="next"
								style="z-index: 12; max-width: auto; max-height: auto; white-space: nowrap;"><img src="images/slider/banner-img1.png" alt=""> </div>
          </li>
          
          <!-- SLIDE  -->
          <li data-transition="fade" data-slotamount="7" data-masterspeed="2000" data-saveperformance="on"  data-title="Ken Burns Slide"> 
            <!-- MAIN IMAGE --> 
            <img src="images/slider/slider-bg2.jpg"  alt="2" data-lazyload="images/slider/slider-bg2.jpg" data-bgposition="right top" data-kenburns="on" data-duration="12000" data-ease="Power0.easeInOut" data-bgfit="115" data-bgfitend="100" data-bgpositionend="center bottom"> 
            <!-- LAYERS --> 
            
            <!-- LAYER NR. 1 -->
            <div class="tp-caption small_text lft tp-resizeme rs-parallaxlevel-0"
								data-x="350"
								data-y="230" 
								data-customin="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0;scaleY:0;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
								data-speed="500"
								data-start="1200"
								data-easing="Power3.easeInOut"
								data-splitin="none"
								data-splitout="none"
								data-elementdelay="0.05"
								data-endelementdelay="0.1"
								style="z-index: 9; max-width: auto; max-height: auto; white-space: nowrap; font-size:24px; font-weight:500; color:#fff; background-color:#222; padding:15px 25px;"><span>Make your home look amazing</span> </div>
            
            <!-- LAYER NR. 2 -->
            <div class="tp-caption finewide_medium_white lfl tp-resizeme rs-parallaxlevel-0 center-align"
								data-x="300"
								data-y="300" 
								data-customin="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0;scaleY:0;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
								data-speed="500"
								data-start="1800"
								data-easing="Power3.easeInOut"
								data-splitin="none"
								data-splitout="none"
								data-elementdelay="0.1"
								data-endelementdelay="0.1"
								style="z-index: 8; max-width: auto; max-height: auto; white-space: nowrap; font-size:50px; font-weight:700; color:#f4a137;"><span>Special offer <br>
              45% off bedrooms</span> </div>
            
            <!-- LAYER NR. 3 -->
            <div class="tp-caption small_text customin tp-resizeme rs-parallaxlevel-0"
								data-x="590"
								data-y="425" 
								data-customin="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0;scaleY:0;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
								data-speed="500"
								data-start="2000"
								data-easing="Power3.easeInOut"
								data-splitin="none"
								data-splitout="none"
								data-elementdelay="0.1"
								data-endelementdelay="0.1"
								style="z-index: 7; max-width: auto; max-height: auto; white-space: nowrap;">
              <p class="line white hidden-xs"></p>
            </div>
            
            <!-- LAYER NR. 5 -->
            <div class="tp-caption small_text lfr tp-resizeme rs-parallaxlevel-0"
								data-x="480"
								data-y="455" 
								data-customin="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0;scaleY:0;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
								data-speed="500"
								data-start="2400"
								data-easing="Power3.easeInOut"
								data-splitin="none"
								data-splitout="none"
								data-elementdelay="0.1"
								data-endelementdelay="0.1"
								style="z-index: 7; max-width: auto; max-height: auto; white-space: nowrap;"><span>on rustic bedroom furniture</span> </div>
            
            <!-- LAYER NR. 6 -->
            <div class="tp-caption lfb tp-resizeme rs-parallaxlevel-0"
								data-x="530"
								data-y="510"
								data-customin="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0;scaleY:0;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
								data-speed="500"
								data-start="2800"
								data-easing="Power3.easeInOut"
								data-splitin="none"
								data-splitout="none"
								data-elementdelay="0.1"
								data-endelementdelay="0.1"
								data-linktoslide="next"
								style="z-index: 12; max-width: auto; max-height: auto; white-space: nowrap;"><a href='#' class='trans-btn'>buy this template</a> </div>
          </li>
          <!-- SLIDE  -->
          <li data-transition="fade" data-slotamount="7" data-masterspeed="1000" data-saveperformance="on"  data-title="Parallax 3D"> 
            <!-- MAIN IMAGE --> 
            <img src="images/slider/slider-bg3.jpg"  alt="3dbg" data-lazyload="images/slider/slider-bg3.jpg" data-bgposition="center top" data-bgfit="cover" data-bgrepeat="no-repeat"> 
            <!-- LAYERS --> 
            
            <!-- LAYER NR. 1 -->
            <div class="tp-caption finewide_medium_white lft tp-resizeme rs-parallaxlevel-0 center-align"
								data-x="394"
								data-y="360" 
								data-customin="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0;scaleY:0;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
								data-speed="500"
								data-start="1200"
								data-easing="Power3.easeInOut"
								data-splitin="none"
								data-splitout="none"
								data-elementdelay="0.1"
								data-endelementdelay="0.1"
								style="z-index: 8; max-width: auto; max-height: auto; white-space: nowrap; font-size:50px; font-weight:700; color:#f4a137;"><span>Welcome to our <br>
              Furniture Gallery </span> </div>
            
            <!-- LAYER NR. 3 -->
            <div class="tp-caption small_text lfr tp-resizeme rs-parallaxlevel-0"
								data-x="440"
								data-y="510" 
								data-customin="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0;scaleY:0;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
								data-speed="500"
								data-start="2000"
								data-easing="Power3.easeInOut"
								data-splitin="none"
								data-splitout="none"
								data-elementdelay="0.1"
								data-endelementdelay="0.1"
								style="z-index: 7; max-width: auto; max-height: auto; white-space: nowrap;font-size:22px; font-weight:500; color:#fff;"><span>Lorem ipsum dolor sit adipiscing elit.</span> </div>
          </li>
        </ul>
        <div class="tp-bannertimer"></div>
      </div>
    </div>
  </div>
  <!-- End home section -->
  
  <div class="top-banner">
    <div class="container">
      <div class="row">
        <div class="col-sm-6">
          <div class="jtv-banner1"><a href="#"><img src="images/banner1.jpg" alt=""></a>
            <div class="hover_content">
              <div class="hover_data">
                <div class="title"> Season sale </div>
                <div class="desc-text"> offer </div>
                <div class="shop-now"><a href="#">Shop now</a></div>
              </div>
            </div>
          </div>
          <div class="jtv-banner2"><a href="#"><img src="images/banner2.jpg" alt=""></a>
            <div class="hover_content">
              <div class="hover_data">
                <div class="title"> New year Sale</div>
                <div class="desc-text"> 35% Off all items </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-sm-6">
          <div class="jtv-banner3">
            <div class="jtv-banner3-inner"><a href="#"><img src="images/banner3.jpg" alt=""></a>
              <div class="hover_content">
                <div class="hover_data">
                  <div class="title"> new trend </div>
                  <div class="desc-text"> Lorem ipsum dolor sit</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <!-- main container -->
  <div class="main-container col1-layout">
    <div class="container">
      <div class="row"> 
        
        <!--Hot deal -->
        
        <div class="col-md-3 col-sm-4 col-xs-12">
          <div class="jtv-banner-top">
            <div class="jtv-banner-box">
              <div class=""> <a class="jtv-banner-inner-text" href="#">
                <div class="jtv-text">
                  <p class="animated animate1"><span>sale up to</span><span>25% off</span></p>
                  <p class="animated animate2">On selected products</p>
                </div>
                <div class="jtv-banner-box-image"> <img src="images/chair-img.png" alt="Catbox-Images"> </div>
                </a> </div>
            </div>
            <!-- End jtv-banner-box --> 
          </div>
        </div>
        <!-- Home Tabs  -->
        <div class="col-sm-8 col-md-9 col-xs-12">
          <div class="home-tab">
            <ul class="nav home-nav-tabs home-product-tabs">
              <li class="active"><a href="#featured" data-toggle="tab" aria-expanded="false">主 打 商 品</a></li>
              <li> <a href="#top-sellers" data-toggle="tab" aria-expanded="false">热 销 商 品</a> </li>
            </ul>
            <div id="productTabContent" class="tab-content">
              <div class="tab-pane active in" id="featured">
                <div class="featured-pro">
                  <div class="slider-items-products">
                    <div id="featured-slider" class="product-flexslider hidden-buttons">
                      <div class="slider-items slider-width-col4">
                      
                     <!--  主打商品 -->
                     <c:forEach items="${featuredShop }" var="pro">
                        <div class="product-item">
                          <div class="item-inner">
                            <div class="product-thumb has-hover-img">
                              <div class="icon-sale-label sale-left">Sale</div>
                              <div class="icon-new-label new-right"><span>New</span></div>
                              <figure> <a href="${pageContext.request.contextPath }/product?method=single_product&pid=${pro.pid}"><img src="${pageContext.request.contextPath }/${pro.pimage}" alt=""></a> <a class="hover-img" href="${pageContext.request.contextPath }/product?method=single_product&pid=${pro.pid}"><img src="${pageContext.request.contextPath }/${pro.pimage}" alt=""></a></figure>
                              <div class="pr-info-area animated animate4"><a href="${pageContext.request.contextPath }/product?method=quick_view&pid=${pro.pid}" class="quick-view"><i class="fa fa-search"><span>Quick view</span></i></a> <a href="wishlist.html" class="wishlist"><i class="fa fa-heart"><span>Wishlist</span></i></a> <a href="compare.html" class="compare"><i class="fa fa-exchange"><span>Compare</span></i></a> </div>
                            </div>
                            <div class="item-info">
                              <div class="info-inner">
                                <div class="item-title"> <a title="Ipsums Dolors Untra" href="${pageContext.request.contextPath }/product?method=single_product&pid=${pro.pid}">${pro.pname} </a> </div>
                                <div class="item-content">
                                  <div class="rating"> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> </div>
                                  <div class="item-price">
                                    <div class="price-box"> <span class="regular-price"> <span class="price">￥${pro.pprice}</span> </span> </div>
                                  </div>
                                  <div class="pro-action">
                                    <a href="${pageContext.request.contextPath}/product?method=addProductToCart&pid=${pro.pid}&buyNum=1">
                                    <button type="button"  class="add-to-cart-mt"> 
                                    <i class="fa fa-shopping-cart"></i><span> 加 入 购 物 车</span>
                                     </button>
                                     </a>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </c:forEach>
                        
                        </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="tab-pane fade" id="top-sellers">
                <div class="top-sellers-pro">
                  <div class="slider-items-products">
                    <div id="top-sellers-slider" class="product-flexslider hidden-buttons">
                      <div class="slider-items slider-width-col4">
                      
                      <!-- 热销产品 -->
                       <c:forEach items="${hotProduct }" var="pro">
                        <div class="product-item">
                          <div class="item-inner">
                            <div class="product-thumb has-hover-img">
                              <div class="icon-sale-label sale-left">热销</div>
                             <!--  <div class="icon-new-label new-right">New</div> -->
                              <figure> <a href="${pageContext.request.contextPath }/product?method=single_product&pid=${pro.pid}">
                              <img src="${pageContext.request.contextPath }/${pro.pimage}" alt=""></a> 
                              <a class="hover-img" href="${pageContext.request.contextPath }/product?method=single_product&pid=${pro.pid}">
                              <img src="${pageContext.request.contextPath }/${pro.pimage}" alt=""></a></figure>
                              <div class="pr-info-area animated animate4">
                              <a href="${pageContext.request.contextPath }/product?method=quick_view&pid=${pro.pid}" class="quick-view"><i class="fa fa-search"><span>Quick view</span></i></a> <a href="wishlist.html" class="wishlist">
                              <i class="fa fa-heart"><span>Wishlist</span></i>
                              </a> <a href="compare.html" class="compare">
                              <i class="fa fa-exchange"><span>Compare</span></i></a> </div>
                            </div>
                            <div class="item-info">
                              <div class="info-inner">
                                <div class="item-title"> <a title="Ipsums Dolors Untra" href="single_product.html">${pro.pname}</a> </div>
                                <div class="item-content">
                                  <div class="rating"> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> </div>
                                  <div class="item-price">
                                    <div class="price-box"> <span class="regular-price"> <span class="price">￥${pro.pprice }</span> </span> </div>
                                  </div>
                                  <div class="pro-action">
                                   <a href="${pageContext.request.contextPath}/product?method=addProductToCart&pid=${pro.pid}&buyNum=1">
                                    <button type="button" class="add-to-cart-mt"> <i class="fa fa-shopping-cart"></i><span> 加 入 购 物 车</span> </button>
                                   </a>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </c:forEach>
                        </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- end main container -->
  <div class="container">
    <div class="block-static2-inner">
      <div class="img"><a href="#"><img class="alignnone size-full" src="images/banner6.jpg" alt="banner6"></a></div>
      <div class="content">
        <h3>大 促 销 2018</h3>
        <h2>七 折 优 惠 起</h2>
        <p>嗨 翻 全 场. </p>
      </div>
      <div class="trending">
       <div class="trending-inner">
          <h3>chuangyi</h3>
          <h2>HUGE SALE</h2>
          <p>新 设 计 </p>
        </div>
      </div>
    </div>
  </div>
  
  <!--special-products-->
  
  <div class="container">
    <div class="special-products">
      <div class="page-header">
        <h2> 特 价 商 品</h2>
      </div>
      <div class="special-products-pro">
        <div class="slider-items-products">
          <div id="special-products-slider" class="product-flexslider hidden-buttons">
            <div class="slider-items slider-width-col4">
            
            <c:forEach items="${specialProduct }" var="pro">
              <div class="product-item">
                <div class="item-inner">
                  <div class="product-thumb has-hover-img"> <a title="Ipsums Dolors Untra" href="${pageContext.request.contextPath }/product?method=single_product&pid=${pro.pid}">
                    <figure> <img src="${pageContext.request.contextPath }/${pro.pimage}" alt=""> <img class="hover-img" src="${pageContext.request.contextPath }/${pro.pimage}" alt=""></figure>
                    </a>
                    <div class="pr-info-area animated animate4"><a href="${pageContext.request.contextPath }/product?method=quick_view&pid=${pro.pid}" class="quick-view"><i class="fa fa-search"><span>Quick view</span></i></a> <a href="wishlist.html" class="wishlist"><i class="fa fa-heart"><span>Wishlist</span></i></a> <a href="compare.html" class="compare"><i class="fa fa-exchange"><span>Compare</span></i></a> </div>
                  </div>
                  <div class="item-info">
                    <div class="info-inner">
                      <div class="item-title"> <a title="Ipsums Dolors Untra" href="single_product.html">${pro.pname } </a> </div>
                      <div class="item-content">
                        <div class="rating"> <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> </div>
                        <div class="item-price">
                          <div class="price-box"> <span class="regular-price"> <span class="price">￥${pro.pprice }</span> </span> </div>
                        </div>
                        <div class="pro-action">
                         <a href="${pageContext.request.contextPath}/product?method=addProductToCart&pid=${pro.pid}&buyNum=1">
                          <button type="button" class="add-to-cart-mt"> <i class="fa fa-shopping-cart"></i><span>加入购物车</span> </button>
                          </a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
             </c:forEach>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="container">
    <div class="row"> 
      
      <!-- daily deal section-->
      <div class="col-md-6">
        <div class="daily-deal-section daily-deal-parallax">
          <div class="daily-deal">
            <h3 class="deal-title">DEAL THIS WEEK</h3>
            <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident.</p>
            <div class="box-timer">
              <div class="time" data-countdown="countdown" data-date="09-30-2017-10-20-50"></div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-6"> 
        <!-- Testimonials Box -->
        <div class="testimonials">
          <div class="slider-items-products">
            <div id="testimonials-slider" class="product-flexslider hidden-buttons home-testimonials">
              <div class="slider-items slider-width-col4 ">
                <div class="holder">
                  <p>sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad 
                    minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip 
                    ex ea commodo consequat. </p>
                  <div class="thumb"> <img src="images/testimonials-img3.jpg" alt="testimonials img"> </div>
                  <strong class="name">John Doe</strong> <strong class="designation">CEO, Company</strong> </div>
                <div class="holder">
                  <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip 
                    ex ea commodo consequat. fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident.</p>
                  <div class="thumb"> <img src="images/testimonials-img1.jpg" alt="testimonials img"> </div>
                  <strong class="name">Vince Roy</strong> <strong class="designation">CEO, Newspaper</strong> </div>
                <div class="holder">
                  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
                    eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad 
                    minim veniam, quis nostrud. </p>
                  <div class="thumb"> <img src="images/testimonials-img2.jpg" alt="testimonials img"> </div>
                  <strong class="name">John Doe</strong> <strong class="designation">CEO, ABC Softwear</strong> </div>
                <div class="holder">
                  <p>sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad 
                    minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip 
                    ex ea commodo consequat.</p>
                  <div class="thumb"> <img src="images/testimonials-img4.jpg" alt="testimonials img"> </div>
                  <strong class="name">Vince Roy</strong> <strong class="designation">CEO, XYZ Softwear</strong> </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- End Testimonials Box --> 
      
    </div>
  </div>
  
  <!-- category area start -->
  <div class="jtv-category-area">
    <div class="container">
      <div class="row">
        <div class="col-md-8 col-sm-12">
          <div class="jtv-single-cat">
            <div class="page-header">
              <h2>一 周 热 销</h2>
            </div>
            
            <c:forEach items="${weekProduct }" var="pro">
            <div class="jtv-product">
              <div class="product-img"> <a href="${pageContext.request.contextPath }/product?method=single_product&pid=${pro.pid}"> <img src="${pageContext.request.contextPath }/${pro.pimage}" alt=""> <img class="secondary-img" src="${pageContext.request.contextPath }/${pro.pimage}" alt=""> </a> </div>
              <div class="jtv-product-content">
                <h3><a href="single_product.html">${pro.pname }</a></h3>
                <div class="price-box"> <span class="regular-price"> <span class="price">${pro.pprice }</span> </span> </div>
                <div class="jtv-product-action">
                  <div class="jtv-extra-link">
                    <div class="button-cart">
                      <button><i class="fa fa-shopping-cart"></i></button>
                    </div>
                    <a href="${pageContext.request.contextPath }/product?method=quick_view&pid=${pro.pid}" data-toggle="modal" data-target="#productModal">
                    <i class="fa fa-search"></i></a> <a href="javascript:void(0);">
                    <i class="fa fa-heart"></i></a> </div>
                </div>
              </div>
            </div>
           </c:forEach>
          </div>
        </div>
        
        <!-- banner -->
        <div class="col-md-4 col-sm-12 col-xs-12">
          <div class="jtv-banner">
            <div class="upper">
              <div class="jtv-subbanner1"><a href="#"><img class="img-respo" alt="jtv-subbanner1" src="images/banner4.jpg"></a>
                <div class="text-block">
                  <div class="text1"><a href="#"> Lightings</a></div>
                  <div class="text2"><a href="#">for new room</a></div>
                  <div class="text3"><a href="#">35% off</a></div>
                </div>
              </div>
              <div class="jtv-subbanner2"><a href="#"><img class="img-respo" alt="jtv-subbanner2" src="images/banner5.jpg"></a>
                <div class="text-block">
                  <div class="text1"><a href="#">chair</a></div>
                  <div class="text2"><a href="#">CUSTOM FURNITURE </a></div>
                  <div class="text3"><a href="#">25% off</a></div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- category-area end --> 
  <!-- Latest news start -->
  
  <div class="container">
    <div id="latest-news" class="news">
      <div class="page-header">
        <h2>Latest news</h2>
      </div>
      <div class="slider-items-products">
        <div id="latest-news-slider" class="product-flexslider hidden-buttons">
          <div class="slider-items slider-width-col6"> 
            
            <!-- Item -->
            <div class="item">
              <div class="jtv-single-blog">
                <div class="blog-image"> <a href="single_post.html"> <img src="images/blog-img1.jpg" alt="Blog"> </a> <span class="blog-date"> <a href="#"> <span class="month-date"><small>20</small>Feb</span> </a> </span> </div>
                <div class="blog-content">
                  <div class="title-desc"> <a href="single_post.html">
                    <h4>Sed do eiusmod sit amet</h4>
                    </a>
                    <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat,</p>
                  </div>
                  <div class="blog-info"> <span class="author-name"> <i class="fa fa-user"></i>By <a href="#">John Doe</a> </span> <span class="comments-number"> <i class="fa fa-comment"></i>20 Comment </span> </div>
                </div>
              </div>
            </div>
            <!-- End Item --> 
            
            <!-- Item -->
            <div class="item">
              <div class="jtv-single-blog">
                <div class="blog-image"> <a href="single_post.html"> <img src="images/blog-img2.jpg" alt="Blog"> </a> <span class="blog-date"> <a href="#"> <span class="month-date"><small>15</small>Mar</span> </a> </span> </div>
                <div class="blog-content">
                  <div class="title-desc"> <a href="single_post.html">
                    <h4>Lorem ipsum dolor sit amet</h4>
                    </a>
                    <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat,</p>
                  </div>
                  <div class="blog-info"> <span class="author-name"> <i class="fa fa-user"></i>By <a href="#">Vince Roy</a> </span> <span class="comments-number"> <i class="fa fa-comment"></i>20 Comment </span> </div>
                </div>
              </div>
            </div>
            <!-- End Item --> 
            <!-- Item -->
            <div class="item">
              <div class="jtv-single-blog">
                <div class="blog-image"> <a href="single_post.html"> <img src="images/blog-img3.jpg" alt="Blog"> </a> <span class="blog-date"> <a href="#"> <span class="month-date"><small>30</small>Aug</span> </a> </span> </div>
                <div class="blog-content">
                  <div class="title-desc"> <a href="single_post.html">
                    <h4>Sed do eiusmod sit amet</h4>
                    </a>
                    <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat,</p>
                  </div>
                  <div class="blog-info"> <span class="author-name"> <i class="fa fa-user"></i>By <a href="#">John Doe</a> </span> <span class="comments-number"> <i class="fa fa-comment"></i>20 Comment </span> </div>
                </div>
              </div>
            </div>
            <!-- End Item --> 
            <!-- Item -->
            <div class="item">
              <div class="jtv-single-blog">
                <div class="blog-image"> <a href="single_post.html"> <img src="images/blog-img4.jpg" alt="Blog"> </a> <span class="blog-date"> <a href="#"> <span class="month-date"><small>08</small>Jun</span> </a> </span> </div>
                <div class="blog-content">
                  <div class="title-desc"> <a href="single_post.html">
                    <h4>Lorem ipsum dolor sit amet</h4>
                    </a>
                    <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat,</p>
                  </div>
                  <div class="blog-info"> <span class="author-name"> <i class="fa fa-user"></i>By <a href="#">Vince Roy</a> </span> <span class="comments-number"> <i class="fa fa-comment"></i>20 Comment </span> </div>
                </div>
              </div>
            </div>
            <!-- End Item --> 
            
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <!-- service section -->
  
  <div class="jtv-service-area">
    <div class="container">
      <div class="row">
        <div class="col-lg-4 col-sm-4 col-xs-12">
          <div class="jtv-service">
            <div class="ser-icon"> <i class="fa fa-truck flip-horizontal"></i> </div>
            <div class="service-content">
              <h5>FREE SHIPPING WORLDWIDE </h5>
              <p>free ship-on oder over $299.00</p>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-sm-4 col-xs-12">
          <div class="jtv-service">
            <div class="ser-icon"> <i class="fa fa-mail-forward"></i> </div>
            <div class="service-content">
              <h5>MONEY BACK GUARATEE! </h5>
              <p>30 days money back guarantee!</p>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-sm-4 col-xs-12">
          <div class="jtv-service">
            <div class="ser-icon"> <i class="fa fa-comments flip-horizontal"></i> </div>
            <div class="service-content">
              <h5>24/7 CUSTOMER SERVICE </h5>
              <p>We support online 24 hours a day</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <!-- Footer -->
  
  <jsp:include page="footer.jsp"></jsp:include>
  <a href="#" class="totop"><i class="fa fa-arrow-up"></i></a> </div>

<!-- End Footer --> 

<!-- JS --> 

<!-- jquery js --> 
<script type="text/javascript" src="js/jquery.min.js"></script> 

<!-- bootstrap js --> 
<script type="text/javascript" src="js/bootstrap.min.js"></script> 

<!-- Slider Js --> 
<script type="text/javascript" src="js/revolution-slider.js"></script> 

<!-- owl.carousel.min js --> 
<script type="text/javascript" src="js/owl.carousel.min.js"></script> 

<!-- bxslider js --> 
<script type="text/javascript" src="js/jquery.bxslider.js"></script> 

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

<!-- countdown js --> 
<script type="text/javascript" src="js/countdown.js"></script> 

<!-- Revolution slider --> 
<script type="text/javascript">

		jQuery(document).ready(function() {
						
			jQuery('.tp-banner').show().revolution(
			{
				dottedOverlay:"none",
				delay:10000,
				startwidth:960,
				startheight:715,
				hideThumbs:200,
				
				thumbWidth:100,
				thumbHeight:50,
				thumbAmount:5,
				
				navigationType:"bullet",
				navigationArrows:"on",
				
				touchenabled:"on",
				onHoverStop:"off",
				
				swipe_velocity: 0.7,
				swipe_min_touches: 1,
				swipe_max_touches: 1,
				drag_block_vertical: false,
										
										parallax:"mouse",
				parallaxBgFreeze:"on",
				parallaxLevels:[7,4,3,2,5,4,3,2,1,0],
										
				keyboardNavigation:"off",
				
				navigationHAlign:"center",
				navigationVAlign:"bottom",
				navigationHOffset:0,
				navigationVOffset:60,
						
				shadow:0,

				spinner:"spinner4",
				
				stopLoop:"off",
				stopAfterLoops:-1,
				stopAtSlide:-1,

				shuffle:"off",
				
				autoHeight:"off",						
				forceFullWidth:"off",						
										
										
										
				hideThumbsOnMobile:"off",
				hideNavDelayOnMobile:1500,						
				hideBulletsOnMobile:"off",
				hideArrowsOnMobile:"off",
				hideThumbsUnderResolution:0,
				
				hideSliderAtLimit:0,
				hideCaptionAtLimit:0,
				hideAllCaptionAtLilmit:0,
				startWithSlide:0,
				fullScreenOffsetContainer: ".header"	
			});
							
		});	//ready

	
		
	</script>
</body>
</html>
