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

/**
 * Servlet implementation class LoginDispatcher
 */
@WebServlet("/LoginDispatcher")
public class LoginDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String landingPage = "home.jsp";  // replace with correct logged in landing page
       
    /**
     * Default Constructor
     */
    public LoginDispatcher() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = ""; 
    	/**
    	 * check if email and password exist in database
    	 * if logged in -> send to ________
    	 * if not -> send error and send to auth.jsp
    	 */
    	String username = request.getParameter("login_username");
    	String password = request.getParameter("login_password");
    	
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	
    	String find_sql = "SELECT * FROM Users WHERE username=?"; 
    	try (
    			Connection connection = DriverManager.getConnection(Constant.url, Constant.DBUserName, Constant.DBPassword);
    			PreparedStatement ps = connection.prepareStatement(find_sql);
    		) {
        	ps.setString(1, username);
        	ResultSet rs = ps.executeQuery();
        	
        	// checking if the email is in the database
        	if (rs.next()) {
        		// checking if the input password matches the database password
        		String login_password = rs.getString("userpass"); 
        		if (login_password.equals(password)) {
        			// user is logged in 
        			// add cookies for name display
        			Cookie usernameCookie = new Cookie("username", username);
        			response.addCookie(usernameCookie);
        			response.sendRedirect(landingPage);
        		} else { // password is wrong
            		error = "Password is incorrect! Try again.";
            		request.setAttribute("error", error);
            		request.getRequestDispatcher("auth.jsp").include(request, response);
        		}
        	} else { // username is not in the database
        		error = "Username does not exist! Please register first.";
        		request.setAttribute("error", error);
        		request.getRequestDispatcher("auth.jsp").include(request, response);
        	}
        	
        } catch (SQLException e) {
        	e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
