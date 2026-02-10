package com.library.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static Connection getConnection() {

    	String url = "jdbc:postgresql://localhost:5433/trainingdb";
		String username = "postgres";
		String password = "tiger";
	
        Connection connection = null;
        try {
        	connection = DriverManager.getConnection(url,username,password);
        	if(connection != null) {
    			System.out.println("Connected Successfully");
    		}else {
    			System.out.println("Connection Failed");
    		}
        } catch (SQLException e) {
            System.err.println("Connection failed");
            System.err.println(e.getMessage());
        }
        return connection;
    }
}