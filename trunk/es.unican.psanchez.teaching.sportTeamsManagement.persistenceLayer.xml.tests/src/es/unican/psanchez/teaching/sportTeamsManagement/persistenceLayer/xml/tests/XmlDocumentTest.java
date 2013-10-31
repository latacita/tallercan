package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.tests;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Element;

import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ITeamDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.SportDaoXmlImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.TeamDaoXmlImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.XmlDocument;

public class XmlDocumentTest {
	
	ISportDao sportService = new SportDaoXmlImpl();
	ITeamDao teamService = new TeamDaoXmlImpl();

	@Test
	public void testGetDocument() {
		Assert.assertNotNull(XmlDocument.getInstance());
	} // testGetDocument
	
	@Test
	public void testFindSportNode() {
		Assert.assertNotNull(XmlDocument.getInstance().findSportNode("Futbol"));
		Assert.assertNull(XmlDocument.getInstance().findSportNode("Pesca"));
	}
	
	@Test
	public void testFindTeamNode() {
		
		Element sport = XmlDocument.getInstance().findSportNode("Futbol"); 
		
		Assert.assertNotNull(XmlDocument.getInstance().findTeamNode(sport,"Cadiz"));
		Assert.assertNull(XmlDocument.getInstance().findTeamNode(sport,"Cuenca"));
	}
	

} // XmlDocumentTest
