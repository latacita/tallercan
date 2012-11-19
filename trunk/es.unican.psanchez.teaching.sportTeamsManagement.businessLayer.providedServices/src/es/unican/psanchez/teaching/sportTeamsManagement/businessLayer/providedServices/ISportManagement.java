package es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices;

import java.util.SortedSet;

import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;

/**
 * Services related to sport management
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public interface ISportManagement {
	
	/**
	 * Adds a new sport to the application
	 * @param sport The name of the sport to be added
	 * @param pointsPerWin Number of points a team gets per win in this sport
	 * @param pointsPerTie Number of points a team gets per tie in this sport
	 * @param PointsPerDefeat Number of points a team gets per defeat in this sport
	 * @return True is everything runs ok, otherwise false
	 * Pre: (sport != null) && (sport != "") && (pointsPerWin > pointsPerTie) && 
	 *      (pointsPerTie >= pointsPerDefeat)
	 */
	public boolean createSport(String sport, int pointsPerWin, int pointsPerTie, int PointsPerDefeat);
	
	/**
	 * Remove an sport from the application. All the teams playing in the league associated to this sport
	 * will be removed  
	 * @param sport The name of the sport to be removed
	 * @return True is everything runs ok, otherwise false 
	 * Pre: (sport != null) && (sport != "") 
	 */
	public boolean removeSport(String sport);
	
	/**
	 * Get all sports stored in the system
	 * @return The list of sports stored in the system, alphabetically ordered 
	 */
	public SortedSet<Sport> getAllSports();

} // ISportManagement
