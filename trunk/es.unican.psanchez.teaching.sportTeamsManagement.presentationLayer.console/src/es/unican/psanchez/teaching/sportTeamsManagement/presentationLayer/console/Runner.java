package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console;

import java.util.Scanner;

/**
 * This class represents the main entry point for the application
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class Runner {

	/**
	 * Main entry point for the application
	 * @param args Command-line arguments. They are just ignored
	 */
	public static void main(String[] args) {
		
		Scanner sc = SingletonScanner.getInstance();
		
		MainMenu menu = new MainMenu();
		menu.run();
		sc.close();
		
	} //  main
} // Runner
