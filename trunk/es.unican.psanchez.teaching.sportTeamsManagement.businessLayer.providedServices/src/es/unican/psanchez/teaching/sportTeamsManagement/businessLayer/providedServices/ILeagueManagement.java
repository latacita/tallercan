package es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices;

import java.util.SortedSet;

import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Team;

/**
 * Interface containing the services for league management 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public interface ILeagueManagement {
	
	/**
	 * It adds a new result to the league associated to one sport 
	 * @param sport The name of the sport to which this match belongs to
	 * @param localTeam The name of the team playing as local team 
	 * @param visitingTeam The name of the team playing as visiting team
	 * @param localTeamPoints Score got by the local team
	 * @param visitingTeamPoints Score got by the visiting team
	 * @return True if everything runs ok, false otherwise
	 * Pre: (sport != null) && (sport != "") &&
	 *      (localTeam != null) && (sport != "") &&
	 *      (visitingTeam != null) && (sport != "") && 
	 *      (localTeamPoints >= 0) && (visitingTeamPoints >= 0) 
	 */
	public boolean newResult(String sport, String localTeam, String visitingTeam, 
			                 int localTeamPoints, int visitingTeamPoints);

	/**
	 * Returns all the teams in a league, sorted according to their classification
	 * @param sport The name of the sport with the associated league we are interested in
 	 * @return All the teams in a league, sorted according to their classification
	 */
	public SortedSet<Team> getTeamsInLeague(String sport);

} // ILeagueManagement
