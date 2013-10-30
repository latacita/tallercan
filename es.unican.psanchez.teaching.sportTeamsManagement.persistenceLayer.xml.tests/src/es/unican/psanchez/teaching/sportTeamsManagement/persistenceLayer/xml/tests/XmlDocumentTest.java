package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.XmlDocument;

public class XmlDocumentTest {

	@Test
	public void testGetDocument() {
		assert(XmlDocument.getInstance() != null);
	} // testGetDocument

} // XmlDocumentTest
