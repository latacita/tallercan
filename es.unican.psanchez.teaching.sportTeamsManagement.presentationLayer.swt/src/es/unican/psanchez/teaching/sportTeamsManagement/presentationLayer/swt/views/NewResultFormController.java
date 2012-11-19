package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.swt.views;

import org.eclipse.swt.widgets.Combo;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ILeagueManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation.LeagueManagementImpl;

public class NewResultFormController {
	
	NewResultForm form = null;

	public NewResultFormController(NewResultForm form) {
		this.form = form;
	} // NewResultFormController
	
	public void initializeForm() {
		Combo sportsCombo =  form.getSportsCombo();
		UserInterfaceHelper.feedComboWithSports(sportsCombo);
		String selectedSport = sportsCombo.getItem(0);
		UserInterfaceHelper.feedComboWithTeams(form.getLocalTeamCombo(),selectedSport);
		UserInterfaceHelper.feedComboWithTeams(form.getVisitingTeamCombo(),selectedSport);
	} // initializeForm

	public void sportSelectedAction() {
		Combo sportsCombo =  form.getSportsCombo();
		String selectedSport = sportsCombo.getItem(sportsCombo.getSelectionIndex());
		UserInterfaceHelper.feedComboWithTeams(form.getLocalTeamCombo(),selectedSport);
		UserInterfaceHelper.feedComboWithTeams(form.getVisitingTeamCombo(),selectedSport);
	} // sportSelectedAction

	public void newResultAction() {
		ILeagueManagement leagueService = new LeagueManagementImpl();
		String sport = UserInterfaceHelper.getSelectedFromCombo(form.getSportsCombo());
		String localTeam = UserInterfaceHelper.getSelectedFromCombo(form.getLocalTeamCombo());
		String visitingTeam = UserInterfaceHelper.getSelectedFromCombo(form.getVisitingTeamCombo());
		int localTeamPoints = Integer.parseInt(form.getLocalTeamText().getText());
		int visitingTeamPoints = Integer.parseInt(form.getVisitingTeamText().getText());
		leagueService.newResult(sport, localTeam, visitingTeam, localTeamPoints, visitingTeamPoints);
	} // newResultAction

} // NewResultFormController
