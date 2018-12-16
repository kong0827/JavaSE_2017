import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

public class Demo2 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql:///school";
		String user = "root";
		String password = "root";
		Connection conn = DriverManager.getConnection(url, user, password);
		String sql = "select * from student ";
		
		PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			System.out.println(rs.getObject(1)+"\t"+rs.getObject(2));
		}
	}

}
