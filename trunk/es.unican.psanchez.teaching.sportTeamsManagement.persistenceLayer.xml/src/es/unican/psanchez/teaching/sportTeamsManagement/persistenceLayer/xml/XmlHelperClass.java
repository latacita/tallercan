package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml;

import org.w3c.dom.Element;

/**
 * Class containing helper function for XML document management
 * using DOM 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class XmlHelperClass {
	
	/**
	 * Returns the value associated to a subelement of an element
	 * of a XML document. This subelement must exist and must have a 
	 * single instance
	 * @param e The element from which we want to get a concrete field 	
	 * @param field The name of the subelement whose value we want to get
	 * @return The value of such a subelement
	 */
	// Pre: (e != null) && (e.getElementsByTagName(field).getlength() == 1)
	//      (e.getElementsByTagName(field).item(0).getNodeType == Node.TEXT_NODE)   
	public static String getValue(Element e, String field) {
		
		return e.getElementsByTagName(field).item(0).getTextContent();
		
	} // 

} // XmlHelperClass
