package es.unican.psanchez.teaching.sportTeamsManagement.domainObjects;

/**
 * This class represents a team participating in a league associated to one sport.
 * It contains the statistics about the participation of the team in such a league 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class Team {
	
	// Inv: (name != null) && (!name.equals(""))
	protected String name;
	// Inv: (sport != null) 
	protected Sport sport;
	// Inv: (points >= 0)
	protected int points = 0;   
	// Inv: (matchesPlayed >= 0)
	protected int matchesPlayed;   
	// Inv: (matchesWon >= 0)
	protected int matchesWon = 0;   
	// Inv: (matchesTied >= 0)
	protected int matchesTied = 0;   
	// Inv: (matchesLost >= 0)
	protected int matchesLost;
	// Inv: (matchesPlayed = matchesWon + matchesTied + matchesLost)   
	// Inv: (points = matchesWon*sport.getPointsPerWin() + matchesTied*sport.getPointsPerWin() +
	//                matchesWon*sport.getPointsPerWin())
	
	/**
	 * Class constructor. It creates a new Team object.
	 * @param name The name for the team. It must be unique for each team inside a same league
	 * @param s The sport in which this team competes. 
	 */
	public Team(String name, Sport s) {
		this.sport = s;
		this.name = name;
	} // Team
	
	/**
	 * Return the name of the tame
	 * @return The name of the team
	 */
	public String getName() {
		return name;
	} // getName
	
	/**
	 * Sets the name of the team
	 * @param name The new name for the team
	 */
	public void setName(String name) {
		this.name = name;
	} // setName 
	
	/**
	 * Returns the sport to which this team plays
	 * @return The sport 
	 */
	public Sport getSport() {
		return sport;
	} // getSport
	
	/**
	 * Set the sport to which this team plays
	 * @param sport The sport this team practices
	 */
	public void setSport(Sport sport) {
		this.sport = sport;
		// We restore the invariant
		this.points = this.matchesWon*this.sport.getPointsPerWin()+
				this.matchesTied*this.sport.getPointsPerTie()+
				this.matchesLost*this.sport.getPointsPerDefeat();
	}// setSport
	
	/**
	 * Returns the current number of points got by the team
	 * @return The current number of points got by the team
	 */
	public int getPoints() {
		return points;
	}// getPoints
	
	/**
	 * Returns the current number of matches played by the team
	 * @return The current number of matches played by the team
	 */
	public int getMatchesPlayed() {
		return matchesPlayed;
	} // getMatchesPlayed
	
	/**
	 * Returns the current number of matches won by the team
	 * @return The current number of matches won by the team
	 */
	public int getMatchesWon() {
		return matchesWon;
	} // getMatchesWon
	
	/**
	 * Returns the current number of matches tie by the team
	 * @return The current number of matches tie by the team
	 */
	public int getMatchesTied() {
		return matchesTied;
	} // getMatchesTied
	
	/**
	 * Returns the current number of matches lost by the team
	 * @return The current number of matches lost by the team
	 */
	public int getMatchesLost() {
		return matchesLost;
	} // getMatchesLost

	/**
	 * Add a victory to the team 
	 */
	public void addVictory() {
		this.matchesPlayed++;
		this.matchesWon++;
		this.points += sport.getPointsPerWin(); 
	} // addVictory
	
	
	/**
	 * Add a tie to the team 
	 */
	public void addTie() {
		this.matchesPlayed++;
		this.matchesTied++;
		this.points += sport.getPointsPerTie(); 
	} // addTie
	
	/**
	 * Add a defeat to the team 
	 */
	public void addDefeat() {
		this.matchesPlayed++;
		this.matchesLost++;
		this.points += sport.getPointsPerDefeat(); 
	} // addDefeat 

	
	/**
	 * Load a new set of statistics into the the team 
	 * @param matchesPlayed Number of matches played by the team 
	 * @param matchesWon  Number of matches won by the team
	 * @param matchesTied Number of matches tied by the team
	 * Pre: matchesPlayed >= (matchesWon + matchesTied)
	 */
	public void loadStatistics(int matchesPlayed, int matchesWon, int matchesTied) {
		this.matchesPlayed = matchesPlayed;
		this.matchesWon    = matchesWon;
		this.matchesTied   = matchesTied;
		this.matchesLost   = matchesPlayed - (matchesWon + matchesTied);
		this.points        = matchesWon*sport.getPointsPerWin()+
				             matchesTied*sport.getPointsPerTie()+
				             matchesLost*sport.getPointsPerDefeat();
				
	} // loadStatistics

} // Team
