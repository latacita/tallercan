package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console;

import java.util.Scanner;

/**
 * Utility class containing auxiliary methods for handling console inputs and outputs
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class InputOutputHelper {
	
	/**
	 * Reads an integer from keyboard representing an option in user menu. This 
	 * integer must be in the range [min, max]. Before reading the integer, a message
	 * explaining waht information is expected is displayed  
	 * @param min Minimum value representing an option
	 * @param max Maximum value representing an option
	 * @return The integer read by keyboard
	 */
	// Pre: min <= max 
	// Post: min <= result <= max
	public static int readIntInRangeByKeyboard(int min, int max, String message) {
		
		int result = min;
		
		result = readIntByKeyboard(message);
		
		while (!((min <= result) && (result <= max))) {
			System.out.println("El valor no estñá dentro del rango [" + min + ", " +  max + "]");
			result = readIntByKeyboard(message);
		} // while 	  
		 
		 return result;
	} // readIntByKeyboard

	/**
	 * Reads an integer from keyboard representing an option in user menu. Before reading 
	 * the integer, a message explaining what information is expected is displayed  
	 * @param message The message to be displayed before asking for data
	 * @return The integer read by keyboard
	 */
	public static int readIntByKeyboard(String message) {
		
		int result = 0;
		boolean isValueRight = false;
		
		Scanner sc = SingletonScanner.getInstance();
		 do {
			 System.out.print(message);
			 if (sc.hasNextInt()) {
				 result = sc.nextInt();
				 isValueRight = true;
			 } else {
				 System.out.println("Valor introducido erróneo."); 
				 sc.nextLine();
			 } // if
		 } while (!isValueRight); 	 
		 
		 return result;
	} // readIntByKeyboard
	
	/**
	 * Reads a natural (positive integer) from keyboard representing an option in user menu. 
	 * Before reading the integer, a message explaining what information is expected is 
	 * displayed  
	 * @param message The message to be displayed before asking for data
	 * @return The integer read by keyboard
	 */
	public static int readNatByKeyboard(String message) {
		
		int result = 0;
		boolean isValueRight = false;
		
		Scanner sc = SingletonScanner.getInstance();
		 do {
			 System.out.print(message);
			 if (sc.hasNextInt()) {
				 result = sc.nextInt();
				 if (result >= 0) {
					 isValueRight = true;
				 } else {
					 System.out.println("El valor introducido debe ser superior a 0");
				 } // if
			 } else {
				 System.out.println("Valor introducido erróneo."); 
				 sc.nextLine();
			 } // if
			 
		 } while (!isValueRight); 	 
		 
		 return result;
	} // readIntByKeyboard

	
	/**
	 * Reads a string from keyboard 
	 * @param The m  
	 * @return The string read by keyboard
	 */
	public static String readStringByKeyboard(String message) {
		
		String result = null;
		
		Scanner sc = SingletonScanner.getInstance();
		System.out.print(message);
		result = sc.next();
	 
		 return result;
	} // readIntByKeyboard
	


} // InputOutputHelper
