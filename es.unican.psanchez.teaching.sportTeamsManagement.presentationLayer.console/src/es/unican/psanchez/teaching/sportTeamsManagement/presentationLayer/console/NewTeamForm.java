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
		
		String name = readSportName();
		
		int pointsPerVictory = InputOutputHelper.readNatByKeyboard("Introduzca los puntos por victoria : ");
		int pointsPerTie     = InputOutputHelper.readNatByKeyboard("Introduzca los puntos por empate   : ");
		int pointsPerDefeat  = InputOutputHelper.readNatByKeyboard("Introduzca los puntos por derrota  : ");
		
		while (!arePointsValid(pointsPerVictory,pointsPerTie,pointsPerDefeat)) {
			System.out.println("Los valores introducidos son erróneos.");
			System.out.println("Los puntos por victoria deben ser mayores que los puntos por empate y derrota.");
			pointsPerVictory = InputOutputHelper.readNatByKeyboard("Introduzca los puntos por victoria : ");
			pointsPerTie     = InputOutputHelper.readNatByKeyboard("Introduzca los puntos por empate   : ");
			pointsPerDefeat  = InputOutputHelper.readNatByKeyboard("Introduzca los puntos por derrota  : ");
		} // while 	
		
		
		invokeNewTeamService(name,pointsPerVictory,pointsPerTie,pointsPerDefeat);
		
	}

	/**
	 * Checks whether the combination of point per win, per tie and per defeat in a sport are
	 * valid. For these points being valid, pointsPerVictory > pointsPerTie >= pointsPerDefeat  
	 * @param pointsPerVictory Numbers of points got by a victory in a match 
	 * @param pointsPerTie Numbers of points got by a tie in a match
	 * @param pointsPerDefeat Numbers of points got, if any, by a defeat in a match
	 * @return True if the combination is valid, otherwise false 
	 */
	private boolean arePointsValid(int pointsPerVictory, int pointsPerTie,
			int pointsPerDefeat) {
		return (pointsPerVictory > pointsPerTie) && (pointsPerTie >= pointsPerDefeat);
	}

	/**
	 * Reads a valid sport name by keyboard
	 * @return A valid sport name
	 */
	// Post : (result != null) && (!result.equals(""))  
	protected String readSportName() {
		
		String name;
		name = InputOutputHelper.readStringByKeyboard("Introduzca el nombre del nuevo deporte : ");
		
		while (!isSportNameValid(name)) {
			System.out.println("Nombre de deporte no válido.");
			name = InputOutputHelper.readStringByKeyboard("Introduzca el nombre del nuevo deporte : ");
		} // while
		
		return name;
	} // run
	
	/**
	 * Checks that the sport name received as a parameter is valid
	 * @param name The sport name to be checked   
	 * @return True is the name is correct, otherwise false
	 */
	private boolean isSportNameValid(String name) {
		return (name != null) && !(name.equals(""));
	} // isSportNameValid

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
