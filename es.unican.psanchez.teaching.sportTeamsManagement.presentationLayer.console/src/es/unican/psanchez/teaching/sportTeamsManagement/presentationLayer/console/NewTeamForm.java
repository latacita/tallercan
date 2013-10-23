package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ISportManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation.SportMngImpl;

/**
 * Class representing a 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class NewTeamForm {

	/**
	 * Activates the form
	 */
	public void run() {
		
		System.out.println("");
		
		String nombre = InputOutputHelper.readStringByKeyboard("Introduzca el nombre del nuevo deporte : ");
		int pointsPerVictory = InputOutputHelper.readIntByKeyboard("Introduzca sus puntos por victoria : ");
		int pointsPerTie     = InputOutputHelper.readIntByKeyboard("Introduzca sus puntos por victoria : ");
		int pointsPerDefeat  = InputOutputHelper.readIntByKeyboard("Introduzca sus puntos por victoria : ");
		
		invokeNewTeamService(nombre,pointsPerVictory,pointsPerTie,pointsPerDefeat);
		
	} // run
	
	/**
	 * 
	 * @param nombre
	 * @param pointsPerVictory
	 * @param pointsPerTie
	 * @param pointsPerDefeat
	 */
	protected void invokeNewTeamService(String nombre, int pointsPerVictory, int pointsPerTie, int pointsPerDefeat) {
		
		ISportManagement spmService = new SportMngImpl();
		spmService.createSport(nombre, pointsPerVictory, pointsPerTie, pointsPerDefeat);
		
	} // 

}
