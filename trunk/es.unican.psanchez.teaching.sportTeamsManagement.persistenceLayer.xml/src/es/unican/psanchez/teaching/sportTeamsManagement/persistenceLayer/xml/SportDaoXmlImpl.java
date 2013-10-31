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
		
		boolean result = false;
		
		XmlDocument builder = XmlDocument.getInstance();
		Document doc = builder.getDocument();

		if (XmlDocument.getInstance().findSportNode(sport.getName()) ==  null) {
		
			// We firstly create the attributes for the class
			Element name = XmlHelper.createTextElement(doc,"stm:name",sport.getName());
			Element pointsPerVictory = XmlHelper.createTextElement(doc,"stm:pointsPerWin",
				Integer.toString(sport.getPointsPerWin()));
			Element pointsPerTie     = XmlHelper.createTextElement(doc,"stm:pointsPerTie",
				Integer.toString(sport.getPointsPerTie()));
			Element pointsPerDefeat  = XmlHelper.createTextElement(doc,"stm:pointsPerDefeat",
				Integer.toString(sport.getPointsPerDefeat()));
		
			// We create the sport element
			Element sportNode = doc.createElement("stm:sport");
			sportNode.appendChild(name);
			sportNode.appendChild(pointsPerVictory);
			sportNode.appendChild(pointsPerTie);
			sportNode.appendChild(pointsPerDefeat);
		
			// We add the node to the root of the document
			Element root = getRootElement();
			root.appendChild(sportNode);
		
			// and finally, we save the changes
			builder.saveChanges();
			
			result = true;
		} // if
		
		return result;
	}

	@Override
	public SortedSet<Sport> findAll() {
		
		SortedSet<Sport> result = new TreeSet<Sport>();
		Element e = getRootElement();

		NodeList nodes = e.getElementsByTagName("stm:sport");
		
		for(int i = 0;i<nodes.getLength();i++) {
			Element sport = (Element) nodes.item(i);
			Sport s = processSport(sport);
			result.add(s);
		} // for
		
		return result;
	}

	@Override
	public Sport findByName(String name) {
		
		Sport result = null;
		
		Element sport = XmlDocument.getInstance().findSportNode(name);
		
		if (sport != null) {
			result = processSport(sport);
		} // if
		
		return result;
	} // 
	
	@Override
	public boolean delete(String name) {
		
		boolean result = false;

		Element sport = XmlDocument.getInstance().findSportNode(name);
		
		if (sport != null) {
			Node parent = sport.getParentNode();
			parent.removeChild(sport);
			result = true;
		}
		
		XmlDocument.getInstance().saveChanges();

		return result;
	}

	
	/**
	 * Converts a XML node representing a sport into an Sport object
	 * @param n The XML node to be converted
	 * @return An sport object equivalent to XML node
	 */
	private Sport processSport(Element sport) {
		Sport result = new Sport(XmlHelper.getChildTextValue(sport,"stm:name"));
		getSportPoints(result,sport);
		return result;
	} // processSport

	private void getSportPoints(Sport result, Element sport) {
		result.setPointsPerWin(Integer.parseInt(sport.getElementsByTagName("stm:pointsPerWin").item(0).getTextContent()));	
		result.setPointsPerTie(Integer.parseInt(sport.getElementsByTagName("stm:pointsPerTie").item(0).getTextContent()));
		result.setPointsPerDefeat(Integer.parseInt(sport.getElementsByTagName("stm:pointsPerDefeat").item(0).getTextContent()));
	}

	/**
	 * @return
	 */
	protected Element getRootElement() {
		
		Document doc = XmlDocument.getInstance().getDocument();
		
		Element e = doc.getDocumentElement();
		return e;
	}


}
