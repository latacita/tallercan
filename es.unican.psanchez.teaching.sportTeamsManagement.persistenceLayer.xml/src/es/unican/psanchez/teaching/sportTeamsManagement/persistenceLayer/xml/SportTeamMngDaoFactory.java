package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml;

import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ITeamDao;

public class SportTeamMngDaoFactory {
	
	public static ISportDao createSportDao() {
		return new SportDaoXmlImpl(); 
	} // createSportDao
	
	public static ITeamDao createTeamDao() {
		return new TeamDaoXmlImpl(); 
	} // createSportDao

} // SportTeamMngDaoFactory
