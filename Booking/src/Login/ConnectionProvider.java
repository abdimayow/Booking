package Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider implements Provider {
	public static  Connection conn = null;
	public static Connection getconn() {
		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
		     System.out.println("there is an exception 1");
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
			return conn;
		}
}
