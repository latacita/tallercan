package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console;

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
		
		int option = showMenu();
		switch(option) {
		case 0 : // We do nothing as we must exit this menu
			break; 
		case 1 : 
			NewTeamForm ntm = new NewTeamForm();
			ntm.run();
			break;
		case 2: // TODO: complete method
			break;
		case 3: // TODO: complete method
			break;
		} // switch 
		
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
