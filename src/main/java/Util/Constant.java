package Util;

import java.util.regex.Pattern;

public class Constant {
    static public String DBUserName = "root";
    static public String DBPassword = "Hesoyam1586";
    static public String DBAddress = "jdbc:mysql://localhost:3306/TICTACTOE?serverTimezone=PST";
    
    static public Pattern namePattern = Pattern.compile("^[ A-Za-z]+$");
}
