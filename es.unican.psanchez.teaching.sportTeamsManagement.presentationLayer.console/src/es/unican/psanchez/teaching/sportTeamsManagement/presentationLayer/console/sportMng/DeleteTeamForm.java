package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.sportMng;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ISportManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation.SportMngImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.ConsoleUserInterfaceHelper;
import es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.InputOutputHelper;

/**
 * Class representing the console form for deleting a team 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class DeleteTeamForm {
	
	/**
	 * Activates this form 
	 */
	public void run() {
		
		String name = showForm();
		
		invokeDeleteTeamService(name);
		
	} // run 

	/**
	 * Shows a simple form asking for the name of a sport 
	 * @return The name of the sport to be deleted
	 */
	protected String showForm() {
		System.out.println("");
		
		String name = ConsoleUserInterfaceHelper.readSportName("Introduzca el nombre del deporte a borrar : ");
		return name;
	} // showForm

	/**
	 * Invoke the corresponding business service that is used to delete the sport
	 * whose name is passed as a parameter
	 * @param name The name of the sport to be removed
	 */
	private void invokeDeleteTeamService(String name) {
		
		ISportManagement spmService = new SportMngImpl();
		spmService.removeSport(name);
		
	} // invokeDeleteTeamService

} // DeleteTeamForm
