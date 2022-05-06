package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

import Util.Constant;

public class GameData {
	String player2username;
	public static int gameId;
	
	public GameData(int gameId) {
		this.gameId = gameId;
	}
	
}
