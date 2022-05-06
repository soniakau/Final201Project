package Util;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;

public class Helper {

	/**
     * check if name is valid
     *
     * @param name the name user provides
     * @return valid or not valid
     */
    public static boolean validName(String name) {
        return Constant.namePattern.matcher(name).matches();
    }
    
	/**
     * check if user is logged in
     *
     * @param request
     * @return logged in or not logged in
     */
    public static String isLoggedIn(HttpServletRequest request) {
        Cookie [] cookies = request.getCookies(); 
        for (Cookie cookie : cookies) {
        	if (cookie.getName().equals("username") && cookie.getValue().equals("guest")) {
        		return "guest"; 
        	}
        	if (cookie.getName().equals("username") && !cookie.getValue().isBlank()) {
        		return "loggedin"; 
        	}
        }
        return "notloggedin";  
    }
    
    /**
     * get name of logged in user
     *
     * @param request
     * @return the name of the logged in user
     */
    public static String getName(HttpServletRequest request) {
    	if (isLoggedIn(request).equals("notloggedin")) {
    		return "guest"; 
    	}
        Cookie[] cookies = request.getCookies(); 
        for (Cookie cookie: cookies) {
        	if (cookie.getName().equals("username")) {
        		return cookie.getValue();
        	}
        }
        return ""; 
    }
}
