package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.factory;

import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ITeamDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.SportDaoXmlImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.TeamDaoXmlImpl;

/**
 * Factory for the persistence layer
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class PersistenceLayerFactory {
	
	public static ISportDao createSportDao() {
		return new SportDaoXmlImpl(); 
	} // createSportDao
	
	public static ITeamDao createTeamDao() {
		return new TeamDaoXmlImpl(); 
	} // createSportDao
	
} // PersistenceLayerFactory
