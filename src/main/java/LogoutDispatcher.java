import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Help;

import java.io.IOException;
import java.io.Serial;

/**
 * Servlet implementation class LogoutDispatcher
 */
@WebServlet("/Logout")
public class LogoutDispatcher extends HttpServlet {
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
    	for (Cookie cookie: request.getCookies()) {
    		if (cookie.getName().equals("auth") || cookie.getName().equals("name") || cookie.getName().equals("G_AUTHUSER_H")) {
    			cookie.setMaxAge(0);
    			response.addCookie(cookie);
    		}
    	}
    	
    	try {
    		request.getRequestDispatcher("auth.jsp").include(request, response);
    	} catch (Exception e) {
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
