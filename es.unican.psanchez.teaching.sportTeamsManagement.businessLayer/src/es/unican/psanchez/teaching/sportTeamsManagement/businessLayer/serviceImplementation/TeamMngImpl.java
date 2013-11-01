package es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ITeamManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Team;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ITeamDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.factory.PersistenceLayerFactory;

public class TeamMngImpl implements ITeamManagement {

	@Override
	public boolean createTeam(String name, String sport) {
		
		ISportDao daoSport = PersistenceLayerFactory.createSportDao();
		ITeamDao daoTeam = PersistenceLayerFactory.createTeamDao();
		
		Sport s = daoSport.findByName(sport);
		Team t = new Team(name,s);
		daoTeam.addTeam(t);
		
		return true;
	} //  createTeam

} // TeamMngImpl
