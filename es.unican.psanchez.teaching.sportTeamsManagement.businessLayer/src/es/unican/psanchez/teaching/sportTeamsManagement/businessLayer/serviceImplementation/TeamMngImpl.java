package es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation;

import java.util.Set;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ITeamManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Team;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.dao.implementation.mysql.SportDaoMySqlImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.dao.implementation.mysql.TeamDaoMySqlImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ITeamDao;

public class TeamMngImpl implements ITeamManagement {

	@Override
	public boolean createTeam(String name, String sport) {
		
		ISportDao daoSport = new SportDaoMySqlImpl();
		ITeamDao daoTeam = new TeamDaoMySqlImpl();
		
		Sport s = daoSport.findByName(sport);
		Team t = new Team(name,s);
		daoTeam.addTeam(t);
		
		return true;
	} //  createTeam

	@Override
	public Set<Team> getTeamsInLeague(String sport) {
		ITeamDao dao = new TeamDaoMySqlImpl();
		return dao.findAllInSport(sport);
	}

} // TeamMngImpl
