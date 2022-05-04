package Util;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Help {
    
	public static boolean isLoggedIn(HttpServletRequest request) {
		boolean hasAuth = false;
		boolean hasEmail = false;

    	if (request.getCookies() == null) {
    		return false;
    	}
		for (Cookie cookie: request.getCookies()) {
			if (cookie.getName().equals("auth") && cookie.getValue().equals("true") && cookie.getMaxAge() != 0) {
				hasAuth = true;
			} else if (cookie.getName().equals("name") && !cookie.getValue().isBlank()) {
				hasEmail = true;
			}
		}
		return hasAuth && hasEmail;
	}
	
	public static String getParameter(HttpServletRequest request, String key, String def) {
		String res = request.getParameter(key);
		if (res == null) {
			return def;
		} else {
			return res;
		}
	}
	
	public static String getName(HttpServletRequest request) {
		if (request.getCookies() == null) {
    		return "";
    	}
		
		Cookie[] cookies = request.getCookies();
		String email = "";
		for (Cookie c: cookies) {
			if (c.getName().equals("name")) {
				return c.getValue().replace('+', ' ');
			}
		}
		return "";
	}
	
}
