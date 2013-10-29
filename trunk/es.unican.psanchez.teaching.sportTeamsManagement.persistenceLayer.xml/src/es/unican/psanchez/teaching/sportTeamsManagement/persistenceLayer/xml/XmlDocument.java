package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * Singleton class representing the XML document that stores the 
 * data for the Sport Management Team application 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class XmlDocument {
	
	// Path to the file storing the data
	private static final String XML_FILE = "SportTeamsMngData.xml";

	//Singleton attribute
	private static XmlDocument singleton = null;
	private Document document = null;   
	
	/**
	 * Constructor for the XmlDocument. It is hidden from public usage 
	 */
	private XmlDocument() {
		// We got an instance of the XML parsers factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		// and we try to open the document
		try {
			db  = dbf.newDocumentBuilder();
			document = db.parse(new File(XmlDocument.XML_FILE));
		} catch (ParserConfigurationException e1) {
			// TODO Write a proper exception handler  
			e1.printStackTrace();
		} catch (SAXException | IOException e) {
			// TODO Write a proper exception handler
			e.printStackTrace();
		}
	} // XmlDocument
	/**
	 * Static method that returns a reference to a Document object that handles
	 * the XML persistent data storage
	 * @return  a Document object that handles the XML persistent data storage
	 */
	public static Document getInstance() {
		
		if (singleton == null) {
			singleton = new XmlDocument();
		} // if
		
		return singleton.getDocument();
	} // getDocument
	
	/**
	 * Returns the document object associated to this XML document
	 * @return A document object representing the XML document that holds
	 *  the data for the Sport Teams Management application 
	 */
	public Document getDocument() {
		return document;
	} // getDocument
	
}
