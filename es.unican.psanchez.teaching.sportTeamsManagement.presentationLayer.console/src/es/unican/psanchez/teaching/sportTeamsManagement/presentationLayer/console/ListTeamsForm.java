package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console;

import java.util.SortedSet;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ISportManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation.SportMngImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;

/**
 * Class representing a form that displays a lists of sports
 * @author Pablo S�nchez (p.sanchez@unican.es) 
 * http://personales.unican.es/sanchezbp
 */
public class ListTeamsForm {
	
	/**
	 * Activates this form 
	 */
	public void run() {
		
		ISportManagement spmService = new SportMngImpl();
		SortedSet<Sport> sports = spmService.getAllSports();
		
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.println(" Deportes actualmente registrados ");
		System.out.println("----------------------------------");
		System.out.println("");
		
		for (Sport s : sports) {
			showSport(s);
		} // for
		
	} // run

	/**
	 * Shows an sport name by console
	 * @param s The sport to be displayed
	 */
	private void showSport(Sport s) {
		System.out.println(s.getName());
	} // showSport

} // ListTeamsForm
