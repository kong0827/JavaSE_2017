import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Demo1 {
	@Test
	public void test() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/school";
		String user = "root";
		String password = "root";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		Statement st = conn.createStatement();
		String sql = "insert into student(sname,age) values('小度','22'),('小爱','23'),('小宝','24')";
		int rows = st.executeUpdate(sql);
		if(rows>0){
			System.out.println("插入数据成功");
		}else{
			System.out.println("插入数据失败");
		} 

	}

}
