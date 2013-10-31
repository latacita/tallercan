package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.tests;

import java.util.SortedSet;

import org.junit.Assert;

import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Team;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ITeamDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.SportDaoXmlImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.TeamDaoXmlImpl;

public class Runner {

	public static void main(String[] args) {
		
		// testFindAllSports();
		// testAddSport();
		// testFindByName();
		// testDeleteSport();
		
		ITeamDao  teamService  = new TeamDaoXmlImpl();
		ISportDao sportService = new SportDaoXmlImpl(); 
		
		String sportName = "Futbol";
		Sport s = sportService.findByName(sportName);
		SortedSet<Team> teams = teamService.findAllInSport(sportName);
		
		for (Team t : teams) {
			System.out.println(t);
		}
		
		System.out.println(s);
		
		Team cadiz  = new Team("Cadiz",s);
		cadiz.loadStatistics(38, 38, 0);
		Team racing = new Team("Racing",s);
		Team cuenca = new Team("Cuenca",s);  
		
		Assert.assertEquals(teams.size(),2);
		Assert.assertTrue(teams.contains(cadiz));
		// Assert.assertTrue(teams.contains(racing));
		// Assert.assertFalse(teams.contains(cuenca));
		
	} // 

	/**
	 * 
	 */
	protected static void testDeleteSport() {
		ISportDao service = new SportDaoXmlImpl();
		service.delete("Vela");
	}

	/**
	 * 
	 */
	protected static void testFindByName() {
		ISportDao service = new SportDaoXmlImpl();
		
		Sport s = service.findByName("Futbol");
		System.out.println(s.getName() + " " + s.getPointsPerWin() + " " + s.getPointsPerTie() + " " + s.getPointsPerDefeat());
		s = service.findByName("Baloncesto");
		System.out.println(s.getName() + " " + s.getPointsPerWin() + " " + s.getPointsPerTie() + " " + s.getPointsPerDefeat());
	}

	/**
	 * 
	 */
	protected static void testAddSport() {
		ISportDao service = new SportDaoXmlImpl();
		
		Sport dummy = new Sport("Vela");
		dummy.setPointsPerWin(1);
		dummy.setPointsPerTie(0);
		dummy.setPointsPerDefeat(0);
		
		service.addSport(dummy);
	}

	/**
	 * 
	 */
	protected static void testFindAllSports() {
		ISportDao service = new SportDaoXmlImpl();
		SortedSet<Sport> sports = service.findAll();
		
		if (sports.size() == 0) {
			System.out.println("Colección vacía");
		} // if
		
		for(Sport s : sports) {
			System.out.println(s.getName() + s.getPointsPerWin() + " " + s.getPointsPerTie() + " " + s.getPointsPerDefeat());
		} // for
	}

}
