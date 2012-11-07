package es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices;

import java.util.Set;

import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;

/**
 * Services provided by the business layer related to sport management
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public interface ISportManagement {
	
	/**
	 * 
	 * @param sport
	 */
	public void createSport(String sport);
	
	public void removeSport(String sport);
	
	public Set<Sport> getAllSports();

} // ISportManagement
