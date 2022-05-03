// servlet class to handle user registration
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Constant;
import Util.Helper;

/**
 * Servlet implementation class RegisterDispatcher
 */
@WebServlet("/RegisterDispatcher")
public class RegisterDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Default constructor
     */
    public RegisterDispatcher() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = ""; 
    	
    	String username = (String) request.getParameter("username");
    	String password = (String) request.getParameter("password");
    	String cpassword = (String) request.getParameter("confpassword");
    	
    	// checking is passwords match in the two fields
    	if (! password.equals(cpassword)) {
    		error = "Passwords do not match!"; 
    		request.setAttribute("error", error);
    		request.getRequestDispatcher("auth.jsp").include(request, response);
    		return;
    	}
    	
    	if (! Helper.validName(username)) {
    		error = "Username is invalid. Use only letters and numbers.";
    		request.setAttribute("error", error);
    		request.getRequestDispatcher("auth.jsp").include(request, response);
    		return;
    	}
    	
    	// Initializing JDBC driver
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	String insert_sql = "INSERT INTO USERS (username, password) VALUES (?, ?);";
    	
    	try(
    		Connection connection = DriverManager.getConnection(Constant.url, Constant.DBUserName, Constant.DBPassword);
    		// use the connection object to build a statement
    		PreparedStatement ps = connection.prepareStatement(insert_sql);
    	) {
    		// adding new user to the database
    		ps.setString(1, username); 
    		ps.setString(2, password);
    		ps.executeUpdate();
    		// logging them in 
    		request.getRequestDispatcher("LoginDispatcher?login_username=" + username + "&login_password=" + password).forward(request, response);
    	} catch (SQLException e) {
    		// process the SQL exception 
    		if(e.getMessage().contains("Duplicate entry")) {
    			// the email entered already exists in the database
    			error = "Existing username! Please sign in or create a unique username.";
    			request.setAttribute("error", error); 
    			request.getRequestDispatcher("auth.jsp").include(request, response);
    			return; 
    		}
    		// FOR TESTING
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
