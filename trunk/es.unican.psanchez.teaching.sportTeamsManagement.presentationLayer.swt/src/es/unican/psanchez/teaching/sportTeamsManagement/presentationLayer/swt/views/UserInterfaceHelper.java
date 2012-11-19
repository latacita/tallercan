package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.swt.views;

import java.util.Set;
import java.util.SortedSet;

import org.eclipse.swt.widgets.Combo;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ISportManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ITeamManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation.SportMngImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation.TeamMngImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Team;

/**
 * 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class UserInterfaceHelper {
	
	public static void feedComboWithSports(Combo c) {
		
		ISportManagement sportService = new SportMngImpl(); 
		
		c.removeAll();
		
		SortedSet<Sport> sports = sportService.getAllSports();
		
		for (Sport s : sports) {
			c.add(s.getName());
		} // for
		
		c.select(0);
		
	} // feedComboWithSports
	
	public static void feedComboWithTeams(Combo c, String sport) {
		
		ITeamManagement teamService = new TeamMngImpl(); 
		
		c.removeAll();
		
		Set<Team> teams = teamService.getTeamsInLeague(sport);
		
		for (Team t : teams) {
			c.add(t.getName());
		} // for
		
		c.select(0);
		
	} // feedComboWithSports
	
	public static String getSelectedFromCombo(Combo c) {
		return c.getItem(c.getSelectionIndex());
	} // 


} // UserInterfaceHelper
