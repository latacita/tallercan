package es.unican.psanchez.teaching.sportTeamsManagement.domainObjects;

/**
 * This class represents a team participating in a league associated to one sport.
 * It contains the statistics about the participation of the team in such a league 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class Team {
	
	// Inv: (name != null) && (! name.equals(""))
	protected String name;
	// Inv: (sport != null) 
	protected Sport sport;
	// Inv: (points >= null)
	protected int points;   
	// Inv: (points >= null)
	protected int matchesPlayed;   
	// Inv: (points >= null)
	protected int matchesWon;   
	// Inv: (points >= null)
	protected int matchesTied;   
	// Inv: (points >= null)
	protected int matchesLost;
	// Inv: (matchesPlayed = matchesWon + matchesTied + matchesLost)   
	// Inv: (points = matchesWon*sport.getPointsPerWin() + matchesTied*sport.getPointsPerWin() +
	//                matchesWon*sport.getPointsPerWin())
	
	public Team(String name, Sport s) {
		this.sport = s;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sport getSport() {
		return sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	public int getPoints() {
		return points;
	}
	public int getMatchesPlayed() {
		return matchesPlayed;
	}
	public int getMatchesWon() {
		return matchesWon;
	}
	public int getMatchesTied() {
		return matchesTied;
	}
	public int getMatchesLost() {
		return matchesLost;
	}
	
	public void addVictory() {
		this.matchesPlayed++;
		this.matchesWon++;
		this.points += sport.getPointsPerWin(); 
	} // 
	
	public void addTie() {
		this.matchesPlayed++;
		this.matchesTied++;
		this.points += sport.getPointsPerTie(); 
	} // 
	
	public void addDefeat() {
		this.matchesPlayed++;
		this.matchesLost++;
		this.points += sport.getPointsPerDefeat(); 
	} // 

	public void setPoints(int points) {
		this.points = points;
	}

	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}

	public void setMatchesWon(int matchesWon) {
		this.matchesWon = matchesWon;
	}

	public void setMatchesTied(int matchesTied) {
		this.matchesTied = matchesTied;
	}

	public void setMatchesLost(int matchesLost) {
		this.matchesLost = matchesLost;
	}
	
	
	

} // Team
