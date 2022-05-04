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

import Util.Constant;
import Util.GameData;

@WebServlet("/Join")
public class JoinDispatcher extends HttpServlet{
	@Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    	
    	String secondUsername = ""; // FIGURE OUT HOW TO GET THIS 
    	for (Cookie cookie: request.getCookies()) {
    		if (cookie.getName().equals("secondUsername")) {
    			secondUsername = cookie.getValue();
    		}
    	}
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch (Exception ex){
    		ex.printStackTrace();
    	}
    	
    	String sql = "UPDATE Games SET secondUsername=? WHERE gameID=?;";
    	
    	try (
    			Connection connection = DriverManager.getConnection(Constant.DBAddress, Constant.DBUserName, Constant.DBPassword);
    			PreparedStatement ps = connection.prepareStatement(sql);
    	){
    		ps.setString(1, secondUsername);
    		ps.setInt(2,  GameData.gameId);
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
