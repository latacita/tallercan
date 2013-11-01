package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.teamMng;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ITeamManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation.TeamMngImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.ConsoleUserInterfaceHelper;

/**
 * Class representing a form
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class NewTeamForm {
	
	/**
	 * Activates this form
	 */
	public void run() {
		
		System.out.println("");
		
		String sport = ConsoleUserInterfaceHelper.readNotEmptyString("Introduzca el nombre deporte del equipo : ");
		String team  = ConsoleUserInterfaceHelper.readNotEmptyString("Introduzca el nombre del nuevo equipo   : ");
		
		invokeNewTeamService(sport, team);
		
	} // run

	/**
	 * Invokes the business service for adding a new team to the system  
	 * @param sport The name of the sport the new team plays
	 * @param team  The name of the new team to be added 
 	 */
	protected void invokeNewTeamService(String sport, String team) {
		ITeamManagement tm = new TeamMngImpl();
		tm.createTeam(team, sport);
	} // invokeNewTeamService

} // NewTeamForm
