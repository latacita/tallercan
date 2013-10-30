package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.tests;

import static org.junit.Assert.*;

import java.util.SortedSet;



import org.junit.Assert;
import org.junit.Test;

import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.SportDaoXmlImpl;

public class SportDaoXmlImplTest {

	@Test
	public void testAddSport() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		
		ISportDao service = new SportDaoXmlImpl();
		SortedSet<Sport> sports = service.findAll(); 
		
		Assert.assertNotNull(sports);
		Assert.assertEquals(sports.size(),2);
		
		Sport s1 = new Sport("Futbol");
		Sport s2 = new Sport("Baloncesto");
		Sport s3 = new Sport("Vela");
		
		Assert.assertTrue(sports.contains(s1));
		Assert.assertTrue(sports.contains(s2));
		Assert.assertFalse(sports.contains(s3));
		
	} // testFindAll

	@Test
	public void testFindByName() {
		fail("Not yet implemented");
	}

}
