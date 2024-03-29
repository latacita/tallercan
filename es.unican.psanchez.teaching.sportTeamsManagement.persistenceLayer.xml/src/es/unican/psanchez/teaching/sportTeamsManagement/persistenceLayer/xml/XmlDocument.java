package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
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
	public static XmlDocument getInstance() {
		
		if (singleton == null) {
			singleton = new XmlDocument();
		} // if
		
		return singleton;
	} // getDocument
	
	/**
	 * Returns the document object associated to this XML document
	 * @return A document object representing the XML document that holds
	 *  the data for the Sport Teams Management application 
	 */
	public Document getDocument() {
		return document;
	} // getDocument
	
	public void saveChanges() {
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(XmlDocument.XML_FILE));
		try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	} // saveChanges
	
	public Element findSportNode(String name) {	
		
		Element result = null;
		
		NodeList sports = document.getElementsByTagName("stm:sport");
		
		int i = 0;
		while ((i < sports.getLength()) && (!name.equals(XmlHelper.getChildTextValue((Element) sports.item(i),"stm:name")))) {
			i = i + 1;
		} // while
		
		if (i < sports.getLength()) {
			result = (Element) sports.item(i);
		} // if
		
		return result ;
	
	} // findSportNode
	
	public Element findTeamNode(Element sport, String name) {	
		
		Element result = null;
		
		NodeList teams   = sport.getElementsByTagName("stm:team");
		
		int i = 0;
		while ((i < teams.getLength()) && (!name.equals(XmlHelper.getChildTextValue((Element) teams.item(i),"stm:name")))) {
			i = i + 1;
		} // while
		
		if (i < teams.getLength()) {
			result = (Element) teams.item(i);
		} // if
		
		return result;
		
	} // findSportNode

	
} // XmlDocument
