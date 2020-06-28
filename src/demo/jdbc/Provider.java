package demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Provider 
{
	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/hibernate_onetoone?useSSL=false"; // hb_student_tracker : database name
		String username = "hibernate"; // user-name
		String password = "hibernate"; //password
		
		try{
			con = DriverManager.getConnection(url,username,password);
			
			if(con != null)
				System.out.println("Connection Established");
			else
				System.out.println("Connection Error");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	// Class.forName("oracle.jdbc.OracleDriver");
	// Connection oracle_con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:db_name", "system", "password");

	// In older version (5.0.11) the Driver class is in com.mysql.jdbc.Driver
	// In new mysql connector 8.0.16 the driver class is in com.mysql.cj.jdbc.Driver
	// download latest from https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.16
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Connection mySQLConnection = Provider.getMySQLConnection();
		System.out.println(mySQLConnection);
		mySQLConnection.close();
	}
}
