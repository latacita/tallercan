package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces;

import java.util.SortedSet;

import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Team;

/**
 * Interface of the DAO pattern for the Team business object 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public interface ITeamDao {
	
	/**
	 * Add a team object to the persistent storage
	 * @param team
	 * @return True is everything runs ok, otherwise false
	 * Pre: (team != null)
	 */
	public boolean addTeam(Team team);
	
	/**
	 * Returns all teams that play a league associated to one sport. These teams
	 * are alphabetically ordered
	 * @param sport The sport that defines such a league
	 * @return A set with all the teams that play the league of the sport
	 * Pre: (sport != null) and (sport != "")
	 */
	public SortedSet<Team> findAllInSport(String sport);
	
	/**
	 * Returns the team with the specified name that plays to the indicated sport   
	 * @param name The name of the team we want to recover
	 * @param sport The name of the sport this team plays 
	 * @return The team that matches with the specified name and sport
	 * Pre: (sport != null) and (sport != "") and (name != null) and (name != "") 
	 */
	public Team findByNameAndSport(String name, String sport);
	
	/**
	 * Updates the team statistics in the pesistente storage
	 * @param team The team to be upated
	 * @return True is everything was ok, otherwise false  
	 * Pre: (team != null)
	 */
	public boolean updateTeamStatistics(Team team);

	/**
	 * Removes a team that plays in a certain sport league from the persistent storage
	 * @param name The name of team
	 * @param sport The name of the sport this team plays
	 * @return True is everything was ok, otherwise false  
	 * Pre: (sport != null) and (sport != "") and (name != null) and (name != "")
	 */
	public boolean delete(String name, String sport);

} // ITeamDao
