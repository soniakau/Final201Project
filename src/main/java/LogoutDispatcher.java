import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

/**
 * Servlet implementation class LogoutDispatcher
 */

@WebServlet("/LogoutDispatcher")
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
        // Remove username cookie by expiring it and adding it to response
    	Cookie [] cookies = request.getCookies(); 
    	for (Cookie cookie: cookies) {
    		if (cookie.getName().equals("username")) {
    			cookie.setMaxAge(0); // expire the cookie
    			response.addCookie(cookie); 
    		}
    		if (cookie.getName().equals("wins")) {
    			cookie.setMaxAge(0); // expire the cookie
    			response.addCookie(cookie); 
    		}
    		if (cookie.getName().equals("losses")) {
    			cookie.setMaxAge(0); // expire the cookie
    			response.addCookie(cookie); 
    		}
    		if (cookie.getName().equals("draws")) {
    			cookie.setMaxAge(0); // expire the cookie
    			response.addCookie(cookie); 
    		}
    	}
    	
    	// return to login page once user is logged out
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
