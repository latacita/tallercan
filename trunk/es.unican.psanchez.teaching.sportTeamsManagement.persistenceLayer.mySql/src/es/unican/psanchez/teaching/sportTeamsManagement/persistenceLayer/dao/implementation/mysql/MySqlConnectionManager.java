package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.dao.implementation.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Class that represents 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class MySqlConnectionManager {
	
	protected static Connection connection;
	
	public static Connection getConnection() {
		
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sportteamsmng", "pablo", "pablo123");
			} catch (SQLException e) {
				System.out.println("Database connection not available");
				System.out.println("Error Code =" + e.getErrorCode());
				System.out.println(e.getSQLState());
			} catch (ClassNotFoundException e) {
				System.out.println("MySQL connector driver not found");
			} // try
		} // 
		return connection;
	} // getConenction
	
	public static void executeSqlStatement(String stm, String exceptionMsg) {
		Connection con = MySqlConnectionManager.getConnection();
		try {
			Statement insertStm = con.createStatement();
			insertStm.execute(stm);
			insertStm.close();
		} catch (SQLException e) {
			// TODO: Throw customised exception
			System.out.println(exceptionMsg);
			e.printStackTrace();
		} // try
	} // executeSqlStatement

} // MySqlConnectionManager
