package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces;

import java.util.Set;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.businessObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.businessObjects.Team;

/**
 * Interface of the DAO pattern for the Sport business object 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public interface ISportDao {
	
	public void addSport(Sport sport);

	public void delete(String name);

	public Set<Sport> findAll();
	
	public Sport findByName(String name);
	
	public Set<Team> getTeams();
	
} // ISportDao
