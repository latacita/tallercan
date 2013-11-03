package es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation;

import java.util.SortedSet;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ILeagueManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Team;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ITeamDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.factory.PersistenceLayerFactory;

public class LeagueManagementImpl implements ILeagueManagement {

	@Override
	public boolean newResult(String sport, String localTeam,
			String visitingTeam, int localTeamPoints, int visitingTeamPoints) {
		
		System.out.println("Processing result in " + sport + " : " + localTeam + " vs " + visitingTeam +  " " +  localTeamPoints + ":" + visitingTeamPoints);
		
		ITeamDao daoService = PersistenceLayerFactory.createTeamDao();
		
		Team localTeamObject = daoService.findByNameAndSport(localTeam, sport);
		Team visitingTeamObject = daoService.findByNameAndSport(visitingTeam, sport);
		
		if (localTeamPoints > visitingTeamPoints) {
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
	
	
	@Override
	public SortedSet<Team> getTeamsInLeague(String sport) {
		
		ITeamDao dao = PersistenceLayerFactory.createTeamDao();
		SortedSet<Team> result =  dao.findAllInSport(sport);
		
		return result;
	} // getTeamsInLeague
	

} // LeagueManagementImpl
