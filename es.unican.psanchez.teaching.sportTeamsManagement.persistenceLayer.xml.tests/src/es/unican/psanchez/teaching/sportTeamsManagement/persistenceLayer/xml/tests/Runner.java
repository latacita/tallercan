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
