package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.swt.views;

import java.util.Set;

import org.eclipse.swt.widgets.Combo;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ISportManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ITeamManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation.SportMngImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation.TeamMngImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;

public class NewTeamFormController {

	protected NewTeamForm form = null;
	protected ISportManagement sportService = new SportMngImpl();
	protected ITeamManagement teamService = new TeamMngImpl();
	
	public NewTeamFormController(NewTeamForm form) {
		this.form = form;
	} // NewTeamFormController
	
	public void feedSportsAction() {
		
		Combo combo = form.getSportsCombo();
		UserInterfaceHelper.feedComboWithSports(combo);
		
	} // feedSportsAction
	
	public void newTeamAction() {
		int selectedItem = form.getSportsCombo().getSelectionIndex();
		String sport = form.getSportsCombo().getItem(selectedItem);
		String team = form.getTeamName();
		teamService.createTeam(team, sport);
		
	} // newTeamAction
	

} // NewTeamFormController
