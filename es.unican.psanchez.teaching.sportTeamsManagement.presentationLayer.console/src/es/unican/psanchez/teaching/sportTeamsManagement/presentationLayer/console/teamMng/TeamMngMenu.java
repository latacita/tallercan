package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.teamMng;

import es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.sportMng.DeleteSportsForm;
import es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.sportMng.ListSportsForm;
import es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.sportMng.NewSportForm;

/**
 * This class represents the menu for the management of teams 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class TeamMngMenu {

	public void run() {
		int option = 0;
		
		do {
			// option = showMenu();

			switch(option) {
			case 0 : // We do nothing as we must exit this menu
				break; 
			case 1 : 
				 NewTeamForm ntf = new NewTeamForm();
				// ntf.run();
				// break;
			case 2:
				// ListTeamsForm ltf = new ListTeamsForm();
				// ltf.run();
				// break;
			case 3: 
				// DeleteTeamForm dtf = new DeleteTeamForm();
				// dtf.run();
				// break;
			} // switch 
		} while (option != 0);
		
	}

}
