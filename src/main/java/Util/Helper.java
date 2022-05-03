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
    public static boolean isLoggedIn(HttpServletRequest request) {
        Cookie [] cookies = request.getCookies(); 
        for (Cookie cookie : cookies) {
        	if (cookie.getName().equals("name") && !cookie.getValue().isBlank()) {
        		return true; 
        	}
        }
        return false;  
    }
    
    /**
     * get name of logged in user
     *
     * @param request
     * @return logged in or not logged in
     */
    public static String getName(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies(); 
        for (Cookie cookie: cookies) {
        	if (cookie.getName().equals("name")) {
        		return cookie.getValue().replace('+', ' ');
        	}
        }
        return ""; 
    }
}
