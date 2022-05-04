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

import Util.GameData;
import Util.Constant;

@WebServlet("/Create")
public class CreateDispatcher extends HttpServlet {
	@Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    	// Delete cookie
    	String username = "";
    	int gameCode = 0;
    	for (Cookie cookie: request.getCookies()) {
    		if (cookie.getName().equals("username")) {
    			username = cookie.getValue();
    		}
    	}
    	
    	try {
    		request.setAttribute("code", gameCode);
            request.getRequestDispatcher("create.jsp").forward(request, response);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch (Exception ex){
    		ex.printStackTrace();
    	}
    	
    	String insert_sql = "INSERT INTO Games (gameID, firstUsername, secondUsername) VALUES (?, ?, ?);";
    	
    	try (
    			Connection connection = DriverManager.getConnection(Constant.DBAddress, Constant.DBUserName, Constant.DBPassword);
    			PreparedStatement ps = connection.prepareStatement(insert_sql);
    	){
    		ps.setInt(1, GameData.gameId);
    		ps.setString(2, username); 
    		ps.setString(3, null);
    		ps.executeUpdate();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        doGet(request, response);
    }

}
