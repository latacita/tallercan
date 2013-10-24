package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.dao.implementation.mysql.test;

import static org.junit.Assert.*;

import org.junit.Test;

import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.dao.implementation.mysql.MySqlConnectionManager;

public class MySqlConnectionManagerTest {

	@Test
	public void testGetConnection() {
		assertTrue("Database connection properly created",MySqlConnectionManager.getConnection() != null);
	}

	@Test
	public void testExecuteSqlStatement() {
		
	}

}
