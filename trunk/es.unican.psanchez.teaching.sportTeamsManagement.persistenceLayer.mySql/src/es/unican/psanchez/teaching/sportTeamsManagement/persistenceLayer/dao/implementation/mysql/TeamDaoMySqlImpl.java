package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.dao.implementation.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Team;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ITeamDao;

public class TeamDaoMySqlImpl implements ITeamDao {
	


	@Override
	public void addTeam(Team team) {
		
		SportDaoMySqlImpl daoSport = new SportDaoMySqlImpl();  
		int idSport = daoSport.getSportId(team.getSport().getName());
		String insertStmText = "INSERT INTO team(name,sport) VALUES ('" + 
	                                   team.getName() + "','" + idSport + "')";
		MySqlConnectionManager.executeSqlStatement(insertStmText, "Excepción al añadir equipo" + team.getName());
		
	} // addTeam

	@Override
	public void delete(String name, String sport) {
		
		SportDaoMySqlImpl daoSport = new SportDaoMySqlImpl();  
		int idSport = daoSport.getSportId(sport);
		String deleteStmText = "DELETE FROM team WHERE name = '" + 
	                                   name + "' and sport =" + idSport;
		MySqlConnectionManager.executeSqlStatement(deleteStmText, "Excepción al borrar equipo" + name);
		
	} // delete

	@Override
	public Set<Team> findAllInSport(String sport) {
		
		Set<Team> result = null;

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
			int lost   = played-(won+tied);
			result = new Team(cursor.getString("name"),sport);
			result.setMatchesPlayed(played);
			result.setMatchesWon(won);
			result.setMatchesTied(tied);
			result.setMatchesLost(lost);
			result.setPoints(sport.getPointsPerWin()*won+
							 sport.getPointsPerTie()*tied+
							 sport.getPointsPerDefeat()*lost);
		} catch (SQLException e) {
			System.out.println("Excepción al procesar un equipo ");
			e.printStackTrace();
		} // try
		
		return result;
	} // processTeam
	
	protected Set<Team> processTeams(ResultSet cursor, Sport sport) {
		
		Set<Team> result = new HashSet<Team>();
		
		try {
			cursor.beforeFirst();
			while (cursor.next()) {
				Team t = processTeam(cursor,sport);
				result.add(t);
			} // while
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try
		
		return result;
	} // processTeams 

} // TeamDaoMySqlImpl
