package es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices;
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
	 * @return A boolean value indicating when the team was sucessfully created
	 */
	public boolean createTeam(String name, String sport);
	
	

} // ITeamManagement 
