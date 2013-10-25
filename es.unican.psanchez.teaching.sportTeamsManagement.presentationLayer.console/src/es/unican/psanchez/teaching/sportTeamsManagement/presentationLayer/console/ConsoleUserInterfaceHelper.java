package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console;

/**
 * This class contains several utility methods that are used by several 
 * classes of the console version of the user interface
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class ConsoleUserInterfaceHelper {
	
	/**
	 * Prints the header of any menu for the console version of the 
	 * user interface 
	 */
	public static void printHeader() {
		System.out.println("==================================================");
		System.out.println("               SPORTS TEAM MANAGEMENT             ");
		System.out.println("==================================================");
	} // printHeader
	
	/**
	 * Reads a valid sport name by keyboard. Previously, it shows a message in the console 
	 * indicating what kind of information is requested 
	 * @param message The message to be displayed
	 * @return A valid sport name
	 */
	// Post : (result != null) && (!result.equals(""))  
	public static String readNotEmptyString(String message) {
		
		String name;
		name = InputOutputHelper.readStringByKeyboard(message);
		
		while ((name == null) || name.equals("")) {
			System.out.println("Nombre de deporte no válido.");
			name = InputOutputHelper.readStringByKeyboard(message);
		} // while
		
		return name;
	} // run
	
} // ConsoleUserInterfaceHelper
