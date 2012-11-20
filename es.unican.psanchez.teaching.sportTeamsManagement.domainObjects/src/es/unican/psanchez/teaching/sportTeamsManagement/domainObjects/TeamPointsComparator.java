package es.unican.psanchez.teaching.sportTeamsManagement.domainObjects;

import java.util.Comparator;

/**
 * Comparator for team objects. It sorts team according to their 
 * current points
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class TeamPointsComparator implements Comparator<Team> {

	@Override
	public int compare(Team first, Team second) {
		
		int result = 0;
		
		if (first.getPoints() > second.getPoints()) {
			result = -1;
		} else if (first.getPoints() < second.getPoints()) {
			result = 1;
		} else {
			result = first.getName().compareTo(second.getName());
		}  // if
		
		return result;
	} // compare

} // TeamPointsComparator
