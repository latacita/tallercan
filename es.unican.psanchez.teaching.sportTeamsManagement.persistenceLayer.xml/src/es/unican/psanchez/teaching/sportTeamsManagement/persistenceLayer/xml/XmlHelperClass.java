package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;

/**
 * Class containing a set of static XML helper functions 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class XmlHelperClass {
	
	/**
	 * 
	 * @param doc
	 * @param tag
	 * @param content
	 */
	protected static Element createTextElement(Document doc, String tag, String content) {

		Element node = doc.createElement(tag);
		Text textNode = doc.createTextNode(content);
		node.appendChild(textNode);
		
		return node;
		
	} // createTextElement
	

} // XmlHelperClass
