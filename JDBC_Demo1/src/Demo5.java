import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo5 {
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
			System.out.println(rs.getObject("sid")+"\t"+rs.getObject("sname")+"\t"+rs.getObject("age"));
		}
		
		
		rs.close();
		st.close();
		conn.close();
	}

}
