package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.tests;

import java.util.SortedSet;

import org.junit.Assert;
import org.junit.Test;

import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.SportDaoXmlImpl;

public class SportDaoXmlImplTest {
	
	ISportDao service = new SportDaoXmlImpl();

	@Test
	public void testFindAll() {
		
		SortedSet<Sport> sports = service.findAll(); 
		
		Assert.assertNotNull(sports);
		Assert.assertEquals(sports.size(),2);
		
		Sport s1 = new Sport("Futbol");
		Sport s2 = new Sport("Baloncesto");
		Sport s3 = new Sport("Pesca");
		
		Assert.assertTrue(sports.contains(s1));
		Assert.assertTrue(sports.contains(s2));
		Assert.assertFalse(sports.contains(s3));
		
	} // testFindAll

	@Test
	public void testFindByName() {
		
		Sport f = service.findByName("Futbol");
		
		Assert.assertNotNull(f);
		Assert.assertNotNull(service.findByName("Baloncesto"));
		Assert.assertNull(service.findByName("Pesca"));
		
		Assert.assertEquals(f.getPointsPerWin(),3);
		Assert.assertEquals(f.getPointsPerTie(),1);
		Assert.assertEquals(f.getPointsPerDefeat(),0);
		
	} // testFindByName
	
	@Test
	public void testAddSport() {
		
		Sport dummy = new Sport("Vela");
		dummy.setPointsPerWin(1);
		dummy.setPointsPerTie(0);
		dummy.setPointsPerDefeat(0);
		
		Assert.assertEquals(service.addSport(dummy),true);
		
		Sport f = service.findByName("Vela");
		
		Assert.assertNotNull(f);
		
		Assert.assertEquals(f.getName(),"Vela");
		Assert.assertEquals(f.getPointsPerWin(),1);
		Assert.assertEquals(f.getPointsPerTie(),0);
		Assert.assertEquals(f.getPointsPerDefeat(),0);
		
		Sport replicated = new Sport("Vela");
		Assert.assertEquals(service.addSport(replicated),false);
		
	} // testAddSport

	
	@Test
	public void testDelete() {
		
		Assert.assertEquals(service.delete("Vela"),true);
		Assert.assertNull(service.findByName("Vela"));
		Assert.assertEquals(service.delete("Vela"),false);
	
	} // testDelete()

} // SportDaoXmlImplTest
