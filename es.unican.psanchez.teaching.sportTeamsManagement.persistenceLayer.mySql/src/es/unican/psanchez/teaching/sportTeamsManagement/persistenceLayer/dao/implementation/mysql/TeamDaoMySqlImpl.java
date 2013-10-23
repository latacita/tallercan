package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.dao.implementation.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.SortedSet;
import java.util.TreeSet;

import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Team;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.TeamPointsComparator;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ITeamDao;

public class TeamDaoMySqlImpl implements ITeamDao {

	@Override
	public boolean addTeam(Team team) {
		
		SportDaoMySqlImpl daoSport = new SportDaoMySqlImpl();  
		int idSport = daoSport.getSportId(team.getSport().getName());
		String insertStmText = "INSERT INTO team(name,sport) VALUES ('" + 
	                                   team.getName() + "','" + idSport + "')";
		MySqlConnectionManager.executeSqlStatement(insertStmText, "Excepción al añadir equipo" + team.getName());
		
		return true;
	} // addTeam

	@Override
	public boolean delete(String name, String sport) {
		
		SportDaoMySqlImpl daoSport = new SportDaoMySqlImpl();  
		int idSport = daoSport.getSportId(sport);
		String deleteStmText = "DELETE FROM team WHERE name = '" + 
	                                   name + "' and sport =" + idSport;
		MySqlConnectionManager.executeSqlStatement(deleteStmText, "Excepción al borrar equipo" + name);
		return true;
		
	} // delete

	@Override
	public SortedSet<Team> findAllInSport(String sport) {
		
		SortedSet<Team> result = null;

		Connection con = MySqlConnectionManager.getConnection();
		
		try {
			SportDaoMySqlImpl daoSport = new SportDaoMySqlImpl();  
			int idSport = daoSport.getSportId(sport);
			Sport sportObject = daoSport.findByName(sport);
			Statement selectStm = con.createStatement();
			String selectStmText = "SELECT * FROM team WHERE sport=" + idSport; 
			ResultSet results = selectStm.executeQuery(selectStmText);
			result = processTeams(results,sportObject);  
			selectStm.close();
		} catch (SQLException e) {
			// TODO: Throw insert sport exception
			System.out.println("Excepción al obtener los equipos del deporte " + sport);
			e.printStackTrace();
		} // try

		return result;
	}

	@Override
	public Team findByNameAndSport(String name, String sport) {
		
		Team result = null;
		
		Connection con = MySqlConnectionManager.getConnection();
		
		try {
			SportDaoMySqlImpl daoSport = new SportDaoMySqlImpl();  
			int idSport = daoSport.getSportId(sport);
			Sport sportObject = daoSport.findByName(sport);
			Statement selectStm = con.createStatement();
			String selectStmText = "SELECT * FROM team WHERE name = '" + name + "' and sport=" + idSport; 
			ResultSet results = selectStm.executeQuery(selectStmText);
			results.beforeFirst();results.next();
			result = processTeam(results,sportObject);  
			selectStm.close();
		} catch (SQLException e) {
			// TODO: Throw insert sport exception
			System.out.println("Excepción al obtener un equipo por nombre");
			e.printStackTrace();
		} // try
		
		return result;

	} // findByNameAndSport
	
	protected Team processTeam(ResultSet cursor, Sport sport) {
		
		Team result = null;
		
		try {
			int played = cursor.getInt("matchesPlayed");
			int won    = cursor.getInt("matchesWon");
			int tied   = cursor.getInt("matchesTied");
			result = new Team(cursor.getString("name"),sport);
			result.loadStatistics(played, won, tied);
		} catch (SQLException e) {
			System.out.println("Excepción al procesar un equipo ");
			e.printStackTrace();
		} // try
		
		return result;
	} // processTeam
	
	protected SortedSet<Team> processTeams(ResultSet cursor, Sport sport) {
		
		SortedSet<Team> result = new TreeSet<Team>(new TeamPointsComparator());
		
		try {
			cursor.beforeFirst();
			while (cursor.next()) {
				Team t = processTeam(cursor,sport);
				if (!result.add(t)) System.out.println("Equipo repetido");
			} // while
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try
		
		return result;
	} // processTeams 

	@Override
	public boolean updateTeamStatistics(Team team) {
		
		SportDaoMySqlImpl daoSport = new SportDaoMySqlImpl();  
		int idSport = daoSport.getSportId(team.getSport().getName());
		String updateStmText = "UPDATE team	SET" +
				" matchesPlayed= " + team.getMatchesPlayed() + "," + 
				" matchesWon=" + team.getMatchesWon() + "," +
				" matchesTied=" + team.getMatchesTied() + " WHERE" +
				" sport= "+ idSport + " and name='" + team.getName() + "'";  
		MySqlConnectionManager.executeSqlStatement(updateStmText, "Excepción al actualizar el equipo" + team.getName());
		
		return true;
	} // team 

} // TeamDaoMySqlImpl
