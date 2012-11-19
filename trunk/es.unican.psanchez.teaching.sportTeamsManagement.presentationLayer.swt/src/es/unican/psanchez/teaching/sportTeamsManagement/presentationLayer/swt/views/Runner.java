package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.swt.views;

/**
 * Entry point for the application. This class is only in charge 
 * of launching the application
 * @author Pablo Sánchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class Runner {
	
	/**
	 * Launch the application.
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		try {
			ApplicationWindow window = new ApplicationWindow();
			window.open();
		} catch (Exception e) {
			
			// e.printStackTrace();
		} // try
	} // main
} // Runner
