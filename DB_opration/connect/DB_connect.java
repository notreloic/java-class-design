package com.DB.connect;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

//import sun.security.util.Password;

public class DB_connect {
	public static Connection getconn() throws SQLException,IOException{
		String drivers="com.mysql.cj.jdbc.Driver";
		if (drivers != null)
			System.setProperty("jdbc.drivers", drivers);
		String user="root";
		String pwd="hblcch999";
		String url="jdbc:mysql://localhost:3306/java?useSSL=false&serverTimezone=UTC";
		return DriverManager.getConnection(url, user, pwd);
	}
}
