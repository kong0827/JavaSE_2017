import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo4 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql:///school";
		String user = "root";
		String password = "root";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		Statement st = conn.createStatement();
		String sql = "select * from student";
		ResultSet rs = st.executeQuery(sql);
		
		System.out.println("编号"+"\t"+"姓名"+"\t"+"年龄");
		while(rs.next()){
			System.out.println(rs.getObject(1)+"\t"+rs.getObject(2)+"\t"+rs.getObject(3));
		}
		
		
		rs.close();
		st.close();
		conn.close();
	}

}
