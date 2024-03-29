package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console;

import es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.sportMng.SportMngMenu;
import es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.teamMng.TeamMngMenu;

/**
 * This class represents the main menu of the 
 * Sport Teams Management application 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class MainMenu {
	
	/**
	 * Runs the main menu of the application
	 */
	public void run() {
		
		int option = 0;
		
		do {
			option = showMenu();
			switch(option) 
			{
			case 0 : 
				showExitMessage();
				break;
			case 1 :
				SportMngMenu sportMenu = new SportMngMenu();
				sportMenu.run();
				break;
			case 2:	
				TeamMngMenu teamMenu = new TeamMngMenu();
				teamMenu.run();
				break;
			} // switch
		
		} while (option != 0);
		
	} // run

	/**
	 * Shows the message that must be displayed just before leaving the application 
	 */
	private void showExitMessage() {
		System.out.println("");
		System.out.println("Bye bye, Miss American Pie");
		System.out.println("");
	} // showExitMessage

	/**
	 * Displays the main menu and waits for a user valid option
	 * @return The numerical value of the option selectedby the user
	 */
	private int showMenu() {
		
		System.out.println("");
		
		ConsoleUserInterfaceHelper.printHeader();
		
		System.out.println("0-. Salir");
		System.out.println("1-. Gestionar Deporte");
		System.out.println("2-. Gestionar Equipos");
		System.out.println("");
	
		return InputOutputHelper.readIntInRangeByKeyboard(0, 2, "Introduzca la opci�n elegida : ");
	
	} // showMenu
	
} // MainMenu
