package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console;

import java.util.Scanner;

/**
 * Singleton class for the java scanner 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */

public class SingletonScanner {
	
	protected static Scanner singleton = null;
	
	/**
	 * Private constructor according to the singleton pattern
	 */
	private SingletonScanner() {

	} // SingletonScanner
	
	public static Scanner getInstance() {
		
		if (singleton == null) {
			singleton = new Scanner(System.in); 
		} // if
		
		return singleton;
	} // SingletonScanner

} // Scanner
