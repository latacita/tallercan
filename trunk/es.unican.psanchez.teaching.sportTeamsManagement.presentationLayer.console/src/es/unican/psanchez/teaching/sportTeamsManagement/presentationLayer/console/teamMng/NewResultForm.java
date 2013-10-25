package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.teamMng;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ILeagueManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation.LeagueManagementImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.ConsoleUserInterfaceHelper;
import es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.InputOutputHelper;

/**
 * Class representing a form for adding a new result
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class NewResultForm {
	
	/**
	 * Activates this form
	 */
	public void run() {
		
		String sport, local, visitante;
		int puntosLocal, puntosVisitante;
		
		do {
			sport           = ConsoleUserInterfaceHelper.readNotEmptyString("Introduzca el nombre deporte   : ");
			local           = ConsoleUserInterfaceHelper.readNotEmptyString("Introduzca el equipo local     : ");
			visitante       = ConsoleUserInterfaceHelper.readNotEmptyString("Introduzca el equipo visitante : ");
			puntosLocal     = InputOutputHelper.readNatByKeyboard("Introduzca los puntos del local : ");
			puntosVisitante = InputOutputHelper.readNatByKeyboard("Introduzca los puntos del local : ");
		} while (!isValidNewResultData(local,visitante));
		
		ILeagueManagement lm = new LeagueManagementImpl();
		lm.newResult(sport,local,visitante,puntosLocal,puntosVisitante);
		
	} // run

	private boolean isValidNewResultData(String local, String visitante) {
		return (!local.equals(visitante)) ;
	} // isValidNewResultData

} //
