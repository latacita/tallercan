package es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices;

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
	
	public void getAllSports(String sport);

} // ISportManagement
