package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.dao.implementation.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.SortedSet;
import java.util.TreeSet;

import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;

public class SportDaoMySqlImpl implements ISportDao {
	
	@Override
	public boolean delete(String name) {
		String deleteStmText = "DELETE FROM sport WHERE name = '" + name + "'";
		MySqlConnectionManager.executeSqlStatement(deleteStmText, "Excepción al borrar el deporte " + name);
		return true;
	} // delete 

	@Override
	public boolean addSport(Sport sport) {
		String insertStmText = "INSERT INTO sport(name, pointsPerWin, pointsPerTie, pointsPerDefeat) VALUES ('" + 
								 sport.getName() + "'," + 
								 sport.getPointsPerWin() + "," + 
								 sport.getPointsPerTie() + "," + 
								 sport.getPointsPerDefeat() + ")";
		MySqlConnectionManager.executeSqlStatement(insertStmText, "Excepción al añadir el deporte " + sport.getName());
		return true;
	} // sport

	@Override
	public SortedSet<Sport> findAll() {
		
		SortedSet<Sport> sports = null;
		
		Connection con = MySqlConnectionManager.getConnection();
		
		try {
			Statement selectStm = con.createStatement();
			String selectStmText = "SELECT * FROM sport"; 
			ResultSet results = selectStm.executeQuery(selectStmText);
			sports = resultSet2sports(results);
			selectStm.close();
		} catch (SQLException e) {
			// TODO: Throw insert sport exception
			System.out.println("Excepción al obtener el listado de todos los deportes");
			e.printStackTrace();
		} // try 

		return sports;
	} // findAll

	@Override
	public Sport findByName(String name) {
		
		Sport result = null;
		
		Connection con = MySqlConnectionManager.getConnection();
			
		try {
			Statement selectStm = con.createStatement();
			String selectStmText = "SELECT * FROM sport WHERE name = '" + name + "'"; 
			ResultSet results = selectStm.executeQuery(selectStmText);
			results.beforeFirst();results.next(); 
			result = processSport(results);  
			selectStm.close();
		} catch (SQLException e) {
			// TODO: Throw insert sport exception
			System.out.println("Excepción al obtener el listado de todos los deportes");
			e.printStackTrace();
		} // try
		
		return result;
	}

	private Sport processSport(ResultSet results) {
		
		Sport result = null;
		
		try {
			String name = results.getString("name");
			result = new Sport(name);
			int pointsPerWin    = Integer.parseInt(results.getString("pointsPerWin"));
			int pointsPerTie    = Integer.parseInt(results.getString("pointsPerTie"));
			int pointsPerDefeat = Integer.parseInt(results.getString("pointsPerDefeat"));
			result.setPointsPerWin(pointsPerWin);
			result.setPointsPerTie(pointsPerTie);
			result.setPointsPerDefeat(pointsPerDefeat);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try
		
		return result;
	} // processSport

	protected SortedSet<Sport> resultSet2sports(ResultSet results) {
		
		SortedSet<Sport> sports = new TreeSet<Sport>();
		
		try {
			results.beforeFirst();
			while (results.next()) {
				String sportName = results.getString("name");
				Sport s = new Sport(sportName);
				sports.add(s);
			} // while
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try
		
		return sports;
	} // resultSet2sportSet
	
	public int getSportId(String name) {
		
		int result = -1;
		
		Connection con = MySqlConnectionManager.getConnection();
			
		try {
			Statement selectStm = con.createStatement();
			String selectStmText = "SELECT idSport FROM sport WHERE name = '" + name + "'"; 
			ResultSet results = selectStm.executeQuery(selectStmText);
			results.beforeFirst();results.next(); 
			result = results.getInt("idSport"); 
			selectStm.close();
		} catch (SQLException e) {
			// TODO: Throw insert sport exception
			System.out.println("Excepción al obtener el identificador de un deporte");
			e.printStackTrace();
		} // try
		
		return result;

	} // 
	


} // SportDaoMySqlImpl
