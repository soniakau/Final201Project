import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Constant;

import java.io.IOException;
import java.io.Serial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginDispatcher
 */

@WebServlet("/Login")
public class LoginDispatcher extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	
        String sql = "SELECT * FROM Users WHERE email = ?";
        try (
    			Connection conn = DriverManager.getConnection(Constant.DBAddress, Constant.DBUserName, Constant.DBPassword);
    			PreparedStatement st = conn.prepareStatement(sql);
    		) {
        	st.setString(1, email);
        	ResultSet rs = st.executeQuery();
        
        	if (rs.next()) {
        		String dbpassword = rs.getString("password");
        		if (dbpassword.equals(password)) {
        			// Successful login, send cookie
        			Cookie auth = new Cookie("auth", "true");
        			Cookie name = new Cookie("name", rs.getString("name").replace(' ', '+'));
        			response.addCookie(auth);
        			response.addCookie(name);
        			response.sendRedirect("index.jsp");
        		} else {
        			// Incorrect Password
        			sendError("Password is incorrect.", request, response);
        		}
        	} else {
        		// User not found
        		sendError("An account with this email does not exist.", request, response);
        	} 
        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
    private void sendError(String error, HttpServletRequest request, HttpServletResponse response) {
    	try {
    		request.setAttribute("error", error);
    		request.getRequestDispatcher("auth.jsp").include(request, response);
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    }
}
