package config;
import java.sql.*;

public class Jdbcconnection {
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
		
		//Datasource information
		String url="jdbc:mysql://localhost:3306/PCSDB";
		String username="root";
		String password="Niran@12";
		//Loading Driver
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
	}

}