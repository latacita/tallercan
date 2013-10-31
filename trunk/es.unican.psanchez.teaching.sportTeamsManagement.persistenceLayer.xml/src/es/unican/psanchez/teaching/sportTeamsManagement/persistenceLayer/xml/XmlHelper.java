package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * Class containing a set of static XML helper functions 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class XmlHelper {
	
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
	
	protected static String getChildTextValue(Element e, String tag) {

		return e.getElementsByTagName(tag).item(0).getTextContent();
		
	} // createTextElement

	
} // XmlHelperClass
