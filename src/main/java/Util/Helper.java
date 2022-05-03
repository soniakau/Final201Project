package Util;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

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
     * check if email is valid
     *
     * @param email the email user provides
     * @return valid or not valid
     */
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return Constant.emailPattern.matcher(email).matches();
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
    

    /**
     * Get username with the email
     *
     * @param email
     * @return userName
     * @throws SQLException
     */
    public static String getUserName(String email) throws SQLException {
        //TODO
        return null;
    }

    /**
     * Get userID with email
     *
     * @param email
     * @return userID
     * @throws SQLException
     */
    public static int getUserID(String email) throws SQLException {
        //TODO
        return 0;
    }

    /**
     * check if the email and password matches
     *
     * @param email
     * @param password
     */
    public static boolean checkPassword(String email, String password) throws SQLException {
        //TODO
        return false;
    }

    /** NOT USED, caught in exception
     * Check if email is already registered
     *
     * @param email
     * @param request
     * @param response
     * @return email registered or not
     * @throws ServletException
     * @throws IOException
     */
    public static boolean emailAlreadyRegistered(String email, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO
        return false;
    }
}

