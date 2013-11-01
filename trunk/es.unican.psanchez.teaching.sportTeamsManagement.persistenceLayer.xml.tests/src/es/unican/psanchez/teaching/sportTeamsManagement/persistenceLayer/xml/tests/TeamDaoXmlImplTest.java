package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.tests;

import java.util.SortedSet;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Team;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ITeamDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.SportDaoXmlImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.TeamDaoXmlImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TeamDaoXmlImplTest {
	
	
	static ITeamDao  teamService  = new TeamDaoXmlImpl();
	static ISportDao sportService = new SportDaoXmlImpl();
	static String sportName = "Futbol";
	static Sport sport;
	static Team cadiz, racing, cuenca;
	
	@BeforeClass
	public static void initializeObjects() {
		
		SortedSet<Team> teams = teamService.findAllInSport(sportName);
		
		for (Team t : teams) {
			teamService.delete(t.getName(), t.getSport().getName());
		} // for
		
		sport = sportService.findByName(sportName);
		cadiz  = new Team("Cadiz",sport);
		cadiz.loadStatistics(38, 38, 0);
		racing = new Team("Racing",sport);
		racing.loadStatistics(38, 37, 1);
		cuenca = new Team("Cuenca",sport);
		
		teamService.addTeam(cadiz);
		teamService.addTeam(racing);
	} // 

	@Test
	public void test00FindAllInSport() {
		
		SortedSet<Team> teams = teamService.findAllInSport(sportName);
		
		Assert.assertEquals(teams.size(),2);
		Assert.assertTrue(teams.contains(cadiz));
		Assert.assertTrue(teams.contains(racing));
		Assert.assertFalse(teams.contains(cuenca));
	
	} // testFindAllInSport

	@Test
	public void test01FindByNameAndSport() {

		Team t = teamService.findByNameAndSport("Cadiz", sportName);
		Assert.assertNotNull(t);
		Assert.assertEquals(t,cadiz);
		
		t = teamService.findByNameAndSport("Racing", sportName);
		Assert.assertNotNull(t);
		Assert.assertEquals(t,racing);
		
		t = teamService.findByNameAndSport("Cuenca", sportName);
		Assert.assertNull(t);

	} // testFindByNameAndSport

	@Test
	public void test02UpdateTeamStatistics() {
		cadiz.addVictory();
		Assert.assertTrue(teamService.updateTeamStatistics(cadiz));
		Team updatedCadiz = teamService.findByNameAndSport("Cadiz", sportName);
		Assert.assertEquals(cadiz, updatedCadiz);
		
		Assert.assertFalse(teamService.updateTeamStatistics(cuenca));
	} // testUpdateTeamStatistics

	@Test
	public void test03AddTeam() {
		Assert.assertTrue(teamService.addTeam(cuenca));
		Team t = teamService.findByNameAndSport("Cuenca", sportName);
		Assert.assertEquals(t, cuenca);
		
		Assert.assertFalse(teamService.addTeam(cadiz));
	} // testAddTeam
	
	@Test
	public void test04Delete() {
		Assert.assertTrue(teamService.delete("Cuenca", sportName));
		Assert.assertNull(teamService.findByNameAndSport("Cuenca", sportName));
	} // testDelete
	
}
