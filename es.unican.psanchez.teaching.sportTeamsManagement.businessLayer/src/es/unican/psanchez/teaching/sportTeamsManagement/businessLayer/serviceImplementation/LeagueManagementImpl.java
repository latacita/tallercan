package es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ILeagueManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Team;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.dao.implementation.mysql.TeamDaoMySqlImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ITeamDao;

public class LeagueManagementImpl implements ILeagueManagement {

	@Override
	public boolean newResult(String sport, String localTeam,
			String visitingTeam, int localTeamPoints, int visitingTeamPoints) {
		
		System.out.println("Processing result in " + sport + " : " + localTeam + " vs " + visitingTeam +  " " +  localTeamPoints + ":" + visitingTeamPoints);
		
		ITeamDao daoService = new TeamDaoMySqlImpl();
		
		Team localTeamObject = daoService.findByNameAndSport(localTeam, sport);
		Team visitingTeamObject = daoService.findByNameAndSport(visitingTeam, sport);
		
		if (localTeamPoints < visitingTeamPoints) {
			localTeamObject.addVictory();
			visitingTeamObject.addDefeat();
		} else if (localTeamPoints == visitingTeamPoints) {
			localTeamObject.addTie();
			visitingTeamObject.addTie();
		} else {
			localTeamObject.addDefeat();
			visitingTeamObject.addVictory();
		} // if
		
		daoService.updateTeamStatistics(localTeamObject);
		daoService.updateTeamStatistics(visitingTeamObject);
				
		return true;
	} // newResult

} // LeagueManagementImpl
