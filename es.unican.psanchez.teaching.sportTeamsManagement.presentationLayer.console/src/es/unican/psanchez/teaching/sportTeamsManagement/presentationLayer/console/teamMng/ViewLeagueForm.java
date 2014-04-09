package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.teamMng;

import java.util.SortedSet;



import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ILeagueManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation.LeagueManagementImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Team;
import es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.console.ConsoleUserInterfaceHelper;

/**
 * Class representing a form for viewing a league
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class ViewLeagueForm {

	private static final int NAME_WIDTH = 15;

	/**
	 * Activates this form
	 */
	public void run() {
		
		System.out.println("");
		
		String sport = ConsoleUserInterfaceHelper.readNotEmptyString("Introduzca el nombre deporte del equipo  : ");
				
		SortedSet<Team> teams = invokeListLeagueService(sport);
		
		printLeagueHeader(sport);
		
		showClassification(teams);
		
		
	} // run

	private void printLeagueHeader(String sport) {
		
		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("  " + sport + " League                      ");
		System.out.println("--------------------------------------------");
		System.out.println("");
		System.out.println(" Equipo         Pt PJ PG PE PP              ");
		System.out.println(" ------        --- -- -- -- --              ");
	} // printLeagueHeader

	protected void showClassification(SortedSet<Team> teams) {
		
		for (Team t : teams) {
			
			System.out.print(t.getName());
			fillWithSpaces(NAME_WIDTH,t.getName());
			System.out.format("%3d %2d %2d %2d %2d %n",t.getPoints(),t.getMatchesPlayed(),
					t.getMatchesWon(),t.getMatchesTied(),t.getMatchesLost());
			
		} // for
	} // showClassification

	private void fillWithSpaces(int width, String name) {
		
		for(int i = 0;i < (width - name.length());i++) {
			System.out.print(" ");
		} // for
		
	} // fillWithSpaces

	protected SortedSet<Team> invokeListLeagueService(String sport) {
		ILeagueManagement tm = new LeagueManagementImpl();
		SortedSet<Team> teams = tm.getTeamsInLeague(sport);
		return teams;
	}

} // ListTeamsForm
