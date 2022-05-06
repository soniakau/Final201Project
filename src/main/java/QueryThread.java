package Util;
import java.io.IOException;
import java.io.Serial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class QueryThread extends Thread {
	GameData data;
	
	public QueryThread(GameData data) {
		this.data = data;
	}
	
	public void run() {
		String username = "";
		for (int i = 0; i < 100; i ++) {
			
			// Query for player 2 name
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (Exception ex) {
	    		ex.printStackTrace();
	    	}
	    	
	    	String find_sql = "SELECT * FROM Users WHERE gameID=" + data.gameId + "AND secondUsername <> NULL"; 
	    	try (
	    			Connection connection = DriverManager.getConnection(Constant.DBAddress, Constant.DBUserName, Constant.DBPassword);
	    			PreparedStatement ps = connection.prepareStatement(find_sql);
	    		) {
	        	ps.setString(1, username);
	        	ResultSet rs = ps.executeQuery();
	        	
	        	// checking if the email is in the database
	        	if (rs.next()) {
	        	}
	        	else { }
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        
	        
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
