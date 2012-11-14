package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.swt.views;

import java.util.Set;

import org.eclipse.swt.widgets.Combo;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ISportManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation.SportMngImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;

/**
 * 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class UserInterfaceHelper {
	
	public static void feedComboWithSports(Combo c) {
		
		ISportManagement sportService = new SportMngImpl(); 
		
		c.removeAll();
		
		Set<Sport> sports = sportService.getAllSports();
		
		for (Sport s : sports) {
			c.add(s.getName());
		} // for
		
		c.select(0);
		
	} // feedComboWithSports

} // UserInterfaceHelper
