package es.unican.psanchez.teaching.tallercan.presentationLayer.swt;

/**
 * This class has as unique responsability to launch the application
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class Runner {
	
	/**
	 * Entry point for the application execution.
	 * @param args Command-line arguments. These arguments are simply ignored in this application
	 */
	public static void main(String[] args) {
		try {
			MainTallercanWindow window = new MainTallercanWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		} // try 
	} // main
} // Runner
