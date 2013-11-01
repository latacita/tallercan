package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.factory;

import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ITeamDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.SportDaoXmlImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml.TeamDaoXmlImpl;

public class SportTeamMngDaoFactory {
	
	public static ISportDao createSportDao() {
		return new SportDaoXmlImpl(); 
	} // createSportDao
	
	public static ITeamDao createTeamDao() {
		return new TeamDaoXmlImpl(); 
	} // createSportDao

} // SportTeamMngDaoFactory
