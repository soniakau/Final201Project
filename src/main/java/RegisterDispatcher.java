import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Constant;

import java.io.IOException;
import java.io.Serial;
import java.sql.*;

/**
 * Servlet implementation class RegisterDispatcher
 */

@WebServlet("/Register")
public class RegisterDispatcher extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final String url = "jdbc:mysql://localhost:3306/PA4Users";

    /**
     * Default constructor.
     */
    public RegisterDispatcher() {
    	
    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO
    	String name = request.getParameter("name");
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	String confPassword = request.getParameter("conf-password");
    	
    	if (!password.equals(confPassword)) {
    		request.setAttribute("error", "Passwords do not match.");
    		request.getRequestDispatcher("auth.jsp").include(request, response);
    		return;
    	}
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	
    	
    	String sql = "INSERT INTO Users VALUES (?, ?, ?);";
    	try (
    			Connection conn = DriverManager.getConnection(Constant.DBAddress, Constant.DBUserName, Constant.DBPassword);
    			PreparedStatement st = conn.prepareStatement(sql);
    		) {
    		st.setString(1, name);
    		st.setString(2, email);
    		st.setString(3, password);
    		st.executeUpdate();
    		
    		request.getRequestDispatcher("Login?email=" + email + "&password=" + password).forward(request, response);
    	} catch (SQLException ex) {
    		if (ex.getErrorCode() == 1062) {
    			// Email already exists.
    			request.setAttribute("error", "An account with this email already exists. Please log in.");
        		request.getRequestDispatcher("auth.jsp").include(request, response);
        		return;
    		}
    		System.out.println(ex.getMessage());
    		System.out.println(ex.getErrorCode());
    	}
    	
    	// USER REGISTRATION SUCCESSFUL
    	
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
