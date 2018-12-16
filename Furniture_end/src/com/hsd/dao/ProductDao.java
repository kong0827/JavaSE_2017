package com.hsd.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hsd.domain.Category;
import com.hsd.domain.ConCategory;
import com.hsd.domain.Order;
import com.hsd.domain.OrderItem;
import com.hsd.domain.Product;
import com.hsd.domain.Style;
import com.hsd.utils.DataSourceUtils;

/**
 * 
 * @author 孔祥劲
 * @date 2018年10月18日
 *
 */
public class ProductDao {

	// 主打产品
	public List<Product> findFeaturedShop() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from Product where is_featured = ? limit 0,10";
		List<Product> featuredShop = runner.query(sql, new BeanListHandler<>(Product.class), 1);

		return featuredShop;
	}

	// 热销商品
	public List<Product> findHotProduct() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from Product where pprice between '7000' and '10000' limit 0,10";
		return runner.query(sql, new BeanListHandler<>(Product.class));

	}

	// 特价商品
	public List<Product> findSpecialProduct() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from Product where is_special = 1 ";
		return runner.query(sql, new BeanListHandler<>(Product.class));
	}

	// pageBean对象
	public List<Product> findPageBean(int currentPage, int currentCount) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from Product limit ?,?";
		List<Product> productList = runner.query(sql, new BeanListHandler<>(Product.class), currentPage, currentCount);

		return productList;
	}

	// 获取一共多少数据
	public int getTotalCount() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product";
		Long totalCount = (Long) runner.query(sql, new ScalarHandler());
		return totalCount.intValue();
	}

	// 单个商品信息
	public Product findSingleProduct(String pid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid =?";
		return runner.query(sql, new BeanHandler<Product>(Product.class), pid);
	}

	// 分类信息显示
	public List<Category> findCategoryList() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		List<Category> categoryList = runner.query(sql, new BeanListHandler<>(Category.class));
		return categoryList;
	}

	public List<Style> findStyleList() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from style";
		List<Style> styleList = runner.query(sql, new BeanListHandler<>(Style.class));
		return styleList;
	}

	// 具体分类
	public List<ConCategory> findConCategory(String cid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from concategory where cid =?";
		return runner.query(sql, new BeanListHandler<>(ConCategory.class), cid);
	}

	public List<Object> findPnameByWord(String word) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pname like ? limit 0,8";
		return runner.query(sql, new ColumnListHandler("pname"), "%" + word + "%");

	}

	public List<Product> searchProduct(String word, String style) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "";
		List<Product> productList = null;
		if (word != null && !style.equals("0")) {
			sql = "select * from product where pname like ? and sid = ?";
			productList = runner.query(sql, new BeanListHandler<>(Product.class), "%" + word + "%", style);
		}
		if (word == null && style.equals("0")) {
			sql = "select * from product";
			productList = runner.query(sql, new BeanListHandler<>(Product.class));
		}
		if (word != null && style.equals("0")) {
			sql = "select * from product where pname like ?";
			productList = runner.query(sql, new BeanListHandler<>(Product.class), "%" + word + "%");
		}
		if (word == null && !style.equals("0")) {
			sql = "select * from product where  sid = ?";
			productList = runner.query(sql, new BeanListHandler<>(Product.class), style);
		}
		return productList;
	}

	public List<Product> findWeekProduct() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pprice between '3000' and '8000' limit 0,6 ";
		return runner.query(sql, new BeanListHandler<>(Product.class));

	}

	public int getHighTotalCount() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product where pprice >=8000";
		Long totalCount = (Long) runner.query(sql, new ScalarHandler());
		return totalCount.intValue();
	}

	public List<Product> findHighPageBean(int index, int currentCount) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from Product where pprice >=8000  limit ?,?";
		List<Product> productList = runner.query(sql, new BeanListHandler<>(Product.class), index, currentCount);

		return productList;
	}

	// 向orders表插入数据
	public void addOrders(Order order) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
		Connection conn = DataSourceUtils.getConnection();
		runner.update(conn, sql, order.getOid(), order.getOrdertime(), order.getTotal(), order.getState(),
				order.getAddress(), order.getName(), order.getUser().getUid(), order.getTelephone());
	}

	/*
	 * 向orderitem表插入数据
	 */
	public void addOrderItem(Order order) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql = "insert into orderitem values(?,?,?,?,?)";
		Connection conn = DataSourceUtils.getConnection();
		List<OrderItem> orderItems = order.getOrderItems();
		for (OrderItem item : orderItems) {
			runner.update(conn, sql, item.getItemid(), item.getCount(), item.getSubtotal(), item.getProduct().getPid(),
					item.getOrder().getOid());
		}

	}

	public void updateOrderAdrr(Order order) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update orders set address=?,name=?,telephone=? where oid=?";
		runner.update(sql, order.getAddress(), order.getName(), order.getTelephone(), order.getOid());

	}

	public void updateOrderState(String r6_Order) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update orders set state=? where oid=?";
		runner.update(sql, 1, r6_Order);

	}

}
