package Util;

import java.util.regex.Pattern;

public class Constant {
    //TODO replace it with your DB credentials and appropriate URL
    static public String DBUserName = "root";
    static public String DBPassword = "root";
    public static String url = "jdbc:mysql://localhost:3306/TICTACTOE";

    static public Pattern namePattern = Pattern.compile("^[ A-Za-z]+$");
}
