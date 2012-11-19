package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces;

import java.util.SortedSet;

import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;

/**
 * Interface of the DAO pattern for the Sport business object 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public interface ISportDao {
	
	/**
	 * Adds the sport to the persistent storage
	 * @param sport The sport to be store
	 * @return True is everything runs ok, otherwise false
	 * Pre: findbyName(sport.getName()) == null
	 */
	public boolean addSport(Sport sport);
	
	/**
	 * Remove the sport with the specified name from the persistent store
	 * @param name The name of the sport to be removed 
	 * @return True is everything runs ok, otherwise false
	 * Pre: findbyName(sport.getName()) != null
	 */
	public boolean delete(String name);

	/**
	 * Returns a list with all the sports stores in the persistent storage,
	 * alphabetically ordered
	 * @return A list with all the sports stores in the persistent storage,
	 * 		   alphabetically ordered
	 */
	public SortedSet<Sport> findAll();
	
	/**
	 * Returns the sport which name is specified in the parameter
	 * @param name The name of the sport to be recovered
	 * @return The sport whose name is the one specified
	 * Pre: (name != null) and (name != "")
	 */
	public Sport findByName(String name);
	
} // ISportDao
