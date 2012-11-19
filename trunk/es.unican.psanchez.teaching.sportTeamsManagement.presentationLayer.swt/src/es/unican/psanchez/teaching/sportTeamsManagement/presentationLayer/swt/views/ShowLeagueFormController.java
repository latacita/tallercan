package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.swt.views;

import java.util.SortedSet;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ITeamManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation.TeamMngImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Team;

public class ShowLeagueFormController {
	
	protected ShowLeagueForm form = null;
	
	public ShowLeagueFormController(ShowLeagueForm form) {
		this.form = form;
	} // ShowLeagueFormController

	public void initializeForm() {
		Combo c = this.form.getSportsCombo();
		UserInterfaceHelper.feedComboWithSports(c);
		sportComboChanged();
	} // initializeForm
	
	protected void feedTable(Table table, SortedSet<Team> teams) {
		table.removeAll();
		for(Team t : teams) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(0, t.getName());
			item.setText(1, Integer.toString(t.getPoints()));
			item.setText(2, Integer.toString(t.getMatchesPlayed()));
			item.setText(3, Integer.toString(t.getMatchesWon()));
			item.setText(4, Integer.toString(t.getMatchesTied()));
			item.setText(5, Integer.toString(t.getMatchesLost()));
		} // for
	} // feedTable
	
	public void sportComboChanged() {
		Combo c = this.form.getSportsCombo();
		ITeamManagement teamService = new TeamMngImpl();
		String sport = c.getItem(c.getSelectionIndex());
		SortedSet<Team> teams = teamService.getTeamsInLeague(sport);
		feedTable(this.form.getLeagueTable(),teams);
	} // 
	
	

} // ShowLeagueFormController
