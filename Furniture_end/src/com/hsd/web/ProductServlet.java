package com.hsd.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;
import com.hsd.domain.Cart;
import com.hsd.domain.CartItem;
import com.hsd.domain.ConCategory;
import com.hsd.domain.Order;
import com.hsd.domain.OrderItem;
import com.hsd.domain.PageBean;
import com.hsd.domain.Product;
import com.hsd.domain.Style;
import com.hsd.domain.User;
import com.hsd.service.ProductService;
import com.hsd.utils.PaymentUtil;

public class ProductServlet extends BaseServlet {

	// 商品列表展示
	public void productList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductService service = new ProductService();
		String currentPageStr = request.getParameter("currentPage");
		if (currentPageStr == null)
			currentPageStr = "1";
		int currentPage = Integer.parseInt(currentPageStr);

		String currentCountStr = request.getParameter("currentCount");
		if (currentCountStr == null)
			currentCountStr = "8";
		int currentCount = Integer.parseInt(currentCountStr);

		/* int currentCount = 8; */
		PageBean pageBean = null;
		try {
			pageBean = service.findPageBean(currentPage, currentCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/shop_grid_full_width.jsp").forward(request, response);
	}

	// 首页具体分类
	public void concategoryList(HttpServletRequest request, HttpServletResponse response) {
		String conid = request.getParameter("conid");
		String cid = request.getParameter("cid");
		
		System.out.println(cid + "\n" + conid);
	}

	public void highProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductService service = new ProductService();
		String currentPageStr = request.getParameter("currentPage");
		if (currentPageStr == null)
			currentPageStr = "1";
		int currentPage = Integer.parseInt(currentPageStr);

		String currentCountStr = request.getParameter("currentCount");
		if (currentCountStr == null)
			currentCountStr = "8";
		int currentCount = Integer.parseInt(currentCountStr);

		/* int currentCount = 8; */
		PageBean pageBean = null;
		try {
			pageBean = service.findHighPageBean(currentPage, currentCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/all_shop.jsp").forward(request, response);
	}

	public void single_product(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取单个商品的信息
		String pid = request.getParameter("pid");
		// System.out.println(pid);
		ProductService service = new ProductService();
		Product product = null;
		try {
			product = service.findSingleProduct(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("product", product);
		request.getRequestDispatcher("/single_product.jsp").forward(request, response);
	}

	public void searchWord(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String word = request.getParameter("word");
		ProductService service = new ProductService();
		List<Object> pnameList = null;
		try {
			pnameList = service.findPnameByWord(word);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(pnameList);
		response.getWriter().write(json);
	}

	public void styleList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		ProductService service = new ProductService();
		List<Style> styleList = null;
		try {
			styleList = service.findStyleList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(styleList);
		// System.out.println(json);

		response.getWriter().write(json);
	}

	public void conCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String cid = request.getParameter("cid");
		ProductService service = new ProductService();
		List<ConCategory> conCategory = null;
		try {
			conCategory = service.findConCategory(cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(conCategory);
		// System.out.println(json);
		response.getWriter().write(json);
	}

	public void searchProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String word = request.getParameter("word");
		word = new String(word.getBytes("ISO-8859-1"), "utf-8");
		String style = request.getParameter("style");
		System.out.println(word + " " + style);
		ProductService service = new ProductService();
		List<Product> productList = null;
		try {
			productList = service.searchProduct(word, style);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/shop_grid.jsp").forward(request, response);
	}

	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service = new ProductService();

		// 查询主打产品
		List<Product> featuredShop = null;
		// 查询热销商品
		List<Product> hotProduct = null;
		// 查询特价商品
		List<Product> specialProduct = null;
		// 查询一周热销
		List<Product> weekProduct = null;
		try {
			featuredShop = service.findFeaturedShop();
			hotProduct = service.findHotProduct();
			specialProduct = service.findSpecialProduct();
			weekProduct = service.findWeekProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("weekProduct", weekProduct);
		request.setAttribute("hotProduct", hotProduct);
		request.setAttribute("specialProduct", specialProduct);
		request.setAttribute("featuredShop", featuredShop);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	public void quick_view(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		/*
		 * request.getRequestDispatcher("/quick_view.jsp").forward(request,
		 * response);
		 */
		String pid = request.getParameter("pid");
		ProductService service = new ProductService();
		Product product = service.findSingleProduct(pid);
		request.setAttribute("product", product);
		request.getRequestDispatcher("/quick_view.jsp").forward(request, response);

	}

	public void addProductToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		// 将商品添加到购物车

		HttpSession session = request.getSession();

		ProductService service = new ProductService();

		// 获得要放到购物车的商品的pid
		String pid = request.getParameter("pid");
		// 获得该商品的购买数量
		int buyNum = Integer.parseInt(request.getParameter("buyNum"));

		// 获得product对象
		Product product = service.findSingleProduct(pid);
		// 计算小计
		double subtotal = product.getPprice() * buyNum;
		// 封装CartItem
		CartItem item = new CartItem();
		item.setProduct(product);
		item.setBuyNum(buyNum);
		item.setSubtotal(subtotal);

		// 获得购物车---判断是否在session中已经存在购物车
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
		}

		// 将购物项放到车中---key是pid
		// 先判断购物车中是否已将包含此购物项了 ----- 判断key是否已经存在
		// 如果购物车中已经存在该商品----将现在买的数量与原有的数量进行相加操作
		Map<String, CartItem> cartItems = cart.getCartItems();

		double newsubtotal = 0.0;

		if (cartItems.containsKey(pid)) {
			// 取出原有商品的数量
			CartItem cartItem = cartItems.get(pid);
			int oldBuyNum = cartItem.getBuyNum();
			oldBuyNum += buyNum;
			cartItem.setBuyNum(oldBuyNum);
			cart.setCartItems(cartItems);
			// 修改小计
			// 原来该商品的小计
			double oldsubtotal = cartItem.getSubtotal();
			// 新买的商品的小计
			newsubtotal = buyNum * product.getPprice();
			cartItem.setSubtotal(oldsubtotal + newsubtotal);

		} else {
			// 如果车中没有该商品
			cart.getCartItems().put(product.getPid(), item);
			newsubtotal = buyNum * product.getPprice();
		}

		// 计算总计
		double total = cart.getTotal() + newsubtotal;
		cart.setTotal(total);

		// 将车再次访问session
		session.setAttribute("cart", cart);

		// 直接跳转到购物车页面
		response.sendRedirect(request.getContextPath() + "/shopping_cart.jsp");

	}

	// 删除购物车单一商品
	public void delProFromCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获得要删除的item的pid
		String pid = request.getParameter("pid");
		// 删除session中的购物车中的购物项集合中的item
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart != null) {
			Map<String, CartItem> cartItems = cart.getCartItems();
			// 修改总价
			cart.setTotal(cart.getTotal() - cartItems.get(pid).getSubtotal());
			// 删除
			cartItems.remove(pid);
			cart.setCartItems(cartItems);

		}

		session.setAttribute("cart", cart);

		// 跳转回cart.jsp
		response.sendRedirect(request.getContextPath() + "/shopping_cart.jsp");
	}

	// 清空购物车
	public void clearCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("cart");
		// 跳转回cart.jsp
		response.sendRedirect(request.getContextPath() + "/shopping_cart.jsp");

	}

	// 提交订单
	public void submitOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// 判断用户是否已经登录 未登录下面代码不执行
		User user = (User) session.getAttribute("user");
		if (user == null) {
			// 没有登录
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}

		// 目的：封装好一个Order对象 传递给service层
		Order order = new Order();

		// 1、private String oid;//该订单的订单号
		String oid = UUID.randomUUID().toString();
		order.setOid(oid);

		// 2、private Date ordertime;//下单时间
		order.setOrdertime(new Date());

		// 3、private double total;//该订单的总金额
		// 获得session中的购物车
		Cart cart = (Cart) session.getAttribute("cart");
		double total = cart.getTotal();
		order.setTotal(total);

		// 4、private int state;//订单支付状态 1代表已付款 0代表未付款
		order.setState(0);

		// 5、private String address;//收货地址
		order.setAddress(null);

		// 6、private String name;//收货人
		order.setName(null);

		// 7、private String telephone;//收货人电话
		order.setTelephone(null);

		// 8、private User user;//该订单属于哪个用户
		order.setUser(user);

		// 9、该订单中有多少订单项List<OrderItem> orderItems = new ArrayList<OrderItem>();
		// 获得购物车中的购物项的集合map
		Map<String, CartItem> cartItems = cart.getCartItems();
		for (Map.Entry<String, CartItem> entry : cartItems.entrySet()) {
			// 取出每一个购物项
			CartItem cartItem = entry.getValue();
			// 创建新的订单项
			OrderItem orderItem = new OrderItem();
			// 1)private String itemid;//订单项的id
			orderItem.setItemid(UUID.randomUUID().toString());
			// 2)private int count;//订单项内商品的购买数量
			orderItem.setCount(cartItem.getBuyNum());
			// 3)private double subtotal;//订单项小计
			orderItem.setSubtotal(cartItem.getSubtotal());
			// 4)private Product product;//订单项内部的商品
			orderItem.setProduct(cartItem.getProduct());
			// 5)private Order order;//该订单项属于哪个订单
			orderItem.setOrder(order);

			// 将该订单项添加到订单的订单项集合中
			order.getOrderItems().add(orderItem);
		}
		// order对象封装完毕
		// 传递数据到service层
		ProductService service = new ProductService();
		service.submitOrder(order);

		session.setAttribute("order", order);

		// 页面跳转
		response.sendRedirect(request.getContextPath() + "/order_info.jsp");
	}

	// 确认订单---更新收获人信息+在线支付
	public void confirmOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1、更新收货人信息
		Map<String, String[]> properties = request.getParameterMap();
		Order order = new Order();
		try {
			BeanUtils.populate(order, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		ProductService service = new ProductService();
		service.updateOrderAdrr(order);

		// 只接入一个接口，这个接口已经集成所有的银行接口了 ，这个接口是第三方支付平台提供的
		// 接入的是易宝支付
		// 获得 支付必须基本数据
		String orderid = request.getParameter("oid");
		// String money = order.getTotal()+"";//支付金额
		String money = "0.01";// 支付金额
		// 银行
		String pd_FrpId = request.getParameter("pd_FrpId");

		// 发给支付公司需要哪些数据
		String p0_Cmd = "Buy";
		String p1_MerId = ResourceBundle.getBundle("merchantInfo").getString("p1_MerId");
		String p2_Order = orderid;
		String p3_Amt = money;
		String p4_Cur = "CNY";
		String p5_Pid = "";
		String p6_Pcat = "";
		String p7_Pdesc = "";
		// 支付成功回调地址 ---- 第三方支付公司会访问、用户访问
		// 第三方支付可以访问网址
		String p8_Url = ResourceBundle.getBundle("merchantInfo").getString("callback");
		String p9_SAF = "";
		String pa_MP = "";
		String pr_NeedResponse = "1";
		// 加密hmac 需要密钥
		String keyValue = ResourceBundle.getBundle("merchantInfo").getString("keyValue");
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc,
				p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);

		String url = "https://www.yeepay.com/app-merchant-proxy/node?pd_FrpId=" + pd_FrpId + "&p0_Cmd=" + p0_Cmd
				+ "&p1_MerId=" + p1_MerId + "&p2_Order=" + p2_Order + "&p3_Amt=" + p3_Amt + "&p4_Cur=" + p4_Cur
				+ "&p5_Pid=" + p5_Pid + "&p6_Pcat=" + p6_Pcat + "&p7_Pdesc=" + p7_Pdesc + "&p8_Url=" + p8_Url
				+ "&p9_SAF=" + p9_SAF + "&pa_MP=" + pa_MP + "&pr_NeedResponse=" + pr_NeedResponse + "&hmac=" + hmac;

		// 重定向到第三方支付平台
		response.sendRedirect(url);

	}

}