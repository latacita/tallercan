package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml;

import java.util.SortedSet;
import java.util.TreeSet;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;

public class SportDaoXmlImpl implements ISportDao {
	

	@Override
	public boolean addSport(Sport sport) {
		
		
		
		return true;
	} // addSport

	@Override
	public boolean delete(String name) {

		return false;
	}

	@Override
	public SortedSet<Sport> findAll() {
		
		SortedSet<Sport> result = new TreeSet<Sport>();
		Document doc = XmlDocument.getInstance();
		
		Element e = doc.getDocumentElement();

		NodeList nodes = e.getElementsByTagName("stm:sport");
		
		for(int i = 0;i<nodes.getLength();i++) {
			Node n = (Element) nodes.item(i);
			Sport s = processSport(n);
			result.add(s);
		} // for
		
		return result;
	}

	/**
	 * Converts a XML node representing a sport into an Sport object
	 * @param n The XML node to be converted
	 * @return An sport object equivalent to XML node
	 */
	private Sport processSport(Element n) {
		
		Sport result = new Sport(getSportName(n));
		
		return result;
	} // getSportName

	private String getSportName(Element n) {
		return n.getFirstChild().getNodeValue();
	} // getSportName

	@Override
	public Sport findByName(String name) {
		
		// We access to the root of the target element
		Document doc = XmlDocument.getInstance();
		Element e = doc.getDocumentElement();

		NodeList nodes = e.getElementsByTagName("stm:sport");
		Sport result = new Sport() 
		
		return null;
	} // findByName

} // SportDaoXmlImpl
