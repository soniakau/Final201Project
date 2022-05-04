import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Constant;

@WebServlet("/StatDispatcher")

public class StatDispatcher extends HttpServlet{
	private static final long serialVersionUID = 1L;
	String username = "";
	public StatDispatcher()
	{
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //TODO check if you've done the initialization
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("driver error");
        }
    	String connect = Constant.url;
    	username = request.getParameter("username");
    	String sql = "SELECT * FROM Users WHERE ? = Users.username";
    	
    	try
    	{
    		Connection c = DriverManager.getConnection(connect, Constant.DBUserName, Constant.DBPassword);
			PreparedStatement task = c.prepareStatement(sql);
			task.setString(1, username);
			ResultSet result = task.executeQuery();
			result.next();
			Cookie winsCookie = new Cookie("wins", ""+result.getInt("wins"));
			Cookie drawsCookie = new Cookie("draws", ""+result.getInt("draws"));
			Cookie lossesCookie = new Cookie("losses", ""+result.getInt("losses"));
			response.addCookie(winsCookie);
			response.addCookie(drawsCookie);
			response.addCookie(lossesCookie);
			response.sendRedirect("home.jsp");
    	}
    	catch (SQLException e)
    	{
    		e.printStackTrace();
    	}
    	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}