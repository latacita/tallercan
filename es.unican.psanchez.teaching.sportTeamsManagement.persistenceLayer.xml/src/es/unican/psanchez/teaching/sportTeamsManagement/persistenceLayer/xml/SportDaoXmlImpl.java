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
	}

	@Override
	public boolean delete(String name) {

		return false;
	}

	@Override
	public SortedSet<Sport> findAll() {
		
		System.out.println("Sport.findAll executing");
		
		SortedSet<Sport> result = new TreeSet<Sport>();
		Document doc = XmlDocument.getInstance();
		
		
		Element e = doc.getDocumentElement();

		System.out.println("Found node = " +e.getNodeName());
		
		NodeList nodes = e.getElementsByTagName("stm:sport");
		
		for(int i = 0;i<nodes.getLength();i++) {
			Node n = nodes.item(i);
			System.out.println(n);
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
	private Sport processSport(Node n) {
		
		Sport result = new Sport(getSportName(n));
		
		return result;
	}

	private String getSportName(Node n) {
		
		System.out.println("");
		System.out.println("Sport first child = " + n.getChildNodes().item(2));
		
		return n.getFirstChild().getNodeValue();
	} // String

	@Override
	public Sport findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
