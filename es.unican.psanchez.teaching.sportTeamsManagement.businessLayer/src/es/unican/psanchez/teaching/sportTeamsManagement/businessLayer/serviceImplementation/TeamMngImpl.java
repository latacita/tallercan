package es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation;

import java.util.SortedSet;

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
	public SortedSet<Team> getTeamsInLeague(String sport) {
		
		ITeamDao dao = new TeamDaoMySqlImpl();
		SortedSet<Team> result =  dao.findAllInSport(sport);
		
		System.out.println("Number of teams recovered " + result.size());
		
		return result;
	} // getTeamsInLeague

} // TeamMngImpl
