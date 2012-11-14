package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.dao.implementation.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.mysql.jdbc.MySQLConnection;

import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Team;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;

public class SportDaoMySqlImpl implements ISportDao {
	
	@Override
	public void delete(String name) {
		String deleteStmText = "DELETE FROM sport WHERE name = '" + name + "'";
		MySqlConnectionManager.executeSqlStatement(deleteStmText, "Excepción al borrar el deporte " + name);
	} // delete 

	@Override
	public void addSport(Sport sport) {
		String insertStmText = "INSERT INTO sport(name) VALUES ('" + sport.getName() + "')";
		MySqlConnectionManager.executeSqlStatement(insertStmText, "Excepción al añadir el deporte " + sport.getName());
	} // sport

	@Override
	public Set<Sport> findAll() {
		
		Set<Sport> sports = null;
		
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
			result = new Sport(results.getString("name"));  
			selectStm.close();
		} catch (SQLException e) {
			// TODO: Throw insert sport exception
			System.out.println("Excepción al obtener el listado de todos los deportes");
			e.printStackTrace();
		} // try
		
		return result;
	}

	@Override
	public Set<Team> getTeams() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected Set<Sport> resultSet2sports(ResultSet results) {
		
		Set<Sport> sports = new HashSet<Sport>();
		
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
