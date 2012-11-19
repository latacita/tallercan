package es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices;

import java.util.SortedSet;

import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Team;

/**
 * Interface representing the services provided by the application 
 * (business layer) related to Team Management 
 * @author Pablo Sánchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public interface ITeamManagement {
	
	/**
	 * Creates a new team 
	 * @param name Name of the team to be created
	 * @param sport Sport to which the team belongs
	 * @return A boolean value indicating when the team was successfully created
	 */
	public boolean createTeam(String name, String sport);
	
	/**
	 * Returns all the teams in a league, alphabetically ordered
	 * @param sport The name of the sport with the associated league we are interested in
 	 * @return
	 * ISportDao.findSport()
	 */
	public SortedSet<Team> getTeamsInLeague(String sport);
	
} // ITeamManagement 
