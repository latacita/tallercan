package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.factory;

import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.dao.implementation.mysql.SportDaoMySqlImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.dao.implementation.mysql.TeamDaoMySqlImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ITeamDao;

/**
 * Factory for the persistence layer
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class PersistenceLayerFactory {
	
	public static ISportDao createSportDao() {
		return new SportDaoMySqlImpl(); 
	} // createSportDao
	
	public static ITeamDao createTeamDao() {
		return new TeamDaoMySqlImpl(); 
	} // createSportDao
	
} // PersistenceLayerFactory
