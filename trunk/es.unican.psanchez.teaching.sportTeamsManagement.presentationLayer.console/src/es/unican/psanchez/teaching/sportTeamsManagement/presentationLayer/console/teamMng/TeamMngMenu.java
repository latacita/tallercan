package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.teamMng;

import es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.ConsoleUserInterfaceHelper;
import es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.InputOutputHelper;

/**
 * This class represents the menu for the management of teams 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class TeamMngMenu {

	public void run() {
		
		int option = 0;
		
		do {
			option = showMenu();

			switch(option) {
			case 0 : // We do nothing as we must exit this menu
				break; 
			case 1 : 
				NewTeamForm ntf = new NewTeamForm();
				ntf.run();
				break;
			case 2:
				ViewLeagueForm ltf = new ViewLeagueForm();
				ltf.run();
				break;
			case 3:
				NewResultForm nrf = new NewResultForm();
				nrf.run();
				break;
			} // switch
		} while (option != 0);
		
	} // run

	/**
	 * Displays the main menu and waits for a user valid option
	 * @return The numerical value of the option selected by the user
	 */
	private int showMenu() {
		
		System.out.println("");

		ConsoleUserInterfaceHelper.printHeader();
		
		System.out.println("0-. Salir");
		System.out.println("1-. Nuevo Equipo");
		System.out.println("2-. Ver Liga");
		System.out.println("3-. Añadir Resultado");
	
		return InputOutputHelper.readIntInRangeByKeyboard(0, 3, "Introduzca la opción elegida : ");
		
	} // showMenu

} // TeamMngMenu
