package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.sportMng;

import es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.ConsoleUserInterfaceHelper;
import es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.InputOutputHelper;

/**
 * Class representing a menu for sport management 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class SportMngMenu {
	
	/**
	 * Shows and executes the sport management menu
	 */
	public void run() {
		
		int option = 0;
		
		do {
			option = showMenu();

			switch(option) {
			case 0 : // We do nothing as we must exit this menu
				break; 
			case 1 : 
				NewSportForm ntf = new NewSportForm();
				ntf.run();
				break;
			case 2:
				ListSportsForm ltf = new ListSportsForm();
				ltf.run();
				break;
			case 3: 
				DeleteSportsForm dtf = new DeleteSportsForm();
				dtf.run();
				break;
			} // switch 
		} while (option != 0);
		
	} // run

	/**
	 * Displays the main menu and waits for a user valid option
	 * @return The numerical value of the option selectedby the user
	 */
	private int showMenu() {
		
		System.out.println("");

		ConsoleUserInterfaceHelper.printHeader();
		
		System.out.println("0-. Salir");
		System.out.println("1-. Nuevo Deporte");
		System.out.println("2-. Listar Deportes");
		System.out.println("3-. Borrar Deporte");
	
		return InputOutputHelper.readIntInRangeByKeyboard(0, 3, "Introduzca la opción elegida : ");
		
	} // showMenu

} // SportMngMenu
