package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.dao.implementation.mysql;

import java.util.Set;

import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Team;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ITeamDao;

public class Runner {
	
	protected static void testAnhadirDeporte(String name) {
		
		Sport prueba = new Sport(name);
		ISportDao sportDao = new SportDaoMySqlImpl(); 
		sportDao.addSport(prueba);
		System.out.println("Sport " + name + " added");

	} // testAnhadirDeporte
	
	protected static void testBorrarDeporte(String name) {
		
		ISportDao sportDao = new SportDaoMySqlImpl(); 
		sportDao.delete(name);
		System.out.println("Sport " + name + " deleted");

	} // testAnhadirDeporte
	
	protected static void testObtenerDeportes() {
		
		ISportDao sportDao = new SportDaoMySqlImpl(); 
		Set<Sport> sports = sportDao.findAll();
		
		int i = 0;
		
		System.out.println(" Sport List ");
		System.out.println("============");
		
		for(Sport s : sports) {
			System.out.println("Sport " + i++ + ": " + s.getName()); 
		} // for
		
		System.out.println("");

	} // testAnhadirDeporte
	
	protected static void testAnhadirEquipo(String name, String sport) {
		
		ITeamDao teamDao = new TeamDaoMySqlImpl(); 
		
		Sport prueba = new Sport(sport);
		Team team = new Team(name, prueba);
		
		teamDao.addTeam(team);
		System.out.println("Team " + name + " added");

	} // testAnhadirDeporte
	
	protected static void testBorrarEquipo(String name, String sport) {
		
		ITeamDao teamDao = new TeamDaoMySqlImpl(); 
		teamDao.delete(name, sport);
		System.out.println("Team " + name + " deleted");

	} // testBorrarEquipo
	
	protected static void printTeam(Team t) {
		System.out.println("");
		System.out.println("Team " + t.getName());
		System.out.println("===================================");
		System.out.println("Played = " + t.getMatchesPlayed());
		System.out.println("Won    = " + t.getMatchesWon());
		System.out.println("Tied   = " + t.getMatchesTied());
		System.out.println("Lost   = " + t.getMatchesLost());
		System.out.println("Points = " + t.getPoints());
		System.out.println("");
	} // printTeam
	
	protected static void testBuscarEquipo(String team, String sport) {
		
		ITeamDao teamDao = new TeamDaoMySqlImpl(); 
		Team t = teamDao.findByNameAndSport(team, sport);
		printTeam(t);
		
	}  // testBuscarEquipo
	
	protected static void testListarEquipos(String sport) {
		
		ITeamDao teamDao = new TeamDaoMySqlImpl(); 
		Set<Team> teams = teamDao.findAllInSport(sport);
		
		for (Team t : teams) {
			if (t == null) System.out.println("Null object in teams");
			else  printTeam(t);
		} // for
		
	}  // testBuscarEquipo

	protected static void testSportDao() {
		
		testAnhadirDeporte("PingPong");
		testAnhadirDeporte("Vela");
		
		testObtenerDeportes();
		
		testBorrarDeporte("Vela");
		testBorrarDeporte("PingPong");

	} // testSportDao
	
	protected static void testTeamDao() {
		
		testAnhadirDeporte("Vela");
		
		testAnhadirEquipo("Pedreña","Vela");
		testAnhadirEquipo("Somo","Vela");
		testAnhadirEquipo("Castro Urdiales","Vela");
		
		testBuscarEquipo("Castro Urdiales","Vela");
		
		testListarEquipos("Vela");
		
		testBorrarEquipo("Pedreña","Vela");
		testBorrarEquipo("Somo","Vela");
		testBorrarEquipo("Castro Urdiales","Vela");
		
		testBorrarDeporte("Vela");
		
	} // testTeamDao
	
	public static void main(String args[]) {
		
		// testSportDao()
		testTeamDao();
		
	} // main 

} // Runner
