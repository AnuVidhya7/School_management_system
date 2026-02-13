package com.wipro.school.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	 public static Connection getDBConnection() {
	        Connection con = null;
	        try {
	            Class.forName("oracle.jdbc.OracleDriver");

	            con = DriverManager.getConnection(
	                "jdbc:oracle:thin:@localhost:1521:XE",
	                "anu",
	                "Anuvidhya$7"
	            );

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return con;
	    }
}
