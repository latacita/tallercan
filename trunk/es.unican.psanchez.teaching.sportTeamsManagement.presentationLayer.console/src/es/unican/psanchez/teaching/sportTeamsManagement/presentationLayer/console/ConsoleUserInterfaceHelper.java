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
	public static String readSportName(String message) {
		
		String name;
		name = InputOutputHelper.readStringByKeyboard(message);
		
		while (!isSportNameValid(name)) {
			System.out.println("Nombre de deporte no válido.");
			name = InputOutputHelper.readStringByKeyboard(message);
		} // while
		
		return name;
	} // run
	
	/**
	 * Checks that the sport name received as a parameter is valid
	 * @param name The sport name to be checked   
	 * @return True is the name is correct, otherwise false
	 */
	private static boolean isSportNameValid(String name) {
		return (name != null) && !(name.equals(""));
	} // isSportNameValid

	
} // ConsoleUserInterfaceHelper
