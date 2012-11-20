package es.unican.psanchez.teaching.sportTeamsManagement.domainObjects;

/**
 * Business object representing sports. Each sport has basically a name and 
 * different teams can play a sport  
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class Sport implements Comparable<Sport> {

	protected String name;
	// Inv: (name != null) and (name != "")
	protected int pointsPerWin;
	// Inv: pointsPerWin > 0
	protected int pointsPerTie;
	// Inv: pointsPerTie >= 0
	protected int pointsPerDefeat;
	// Inv: pointsPerDefeat => 0
	// Inv: pointsPerWin >= pointsPerTie >= pointsPerDefeat
	
	/**
	 * Creates a new sport object
	 * @param name The name of the new sport
	 */
	public Sport(String name) {
		this.name = name;
	} // Sport
	
	/**
	 * Gets the name of the sport
	 * @return The name of the sport
	 */
	public String getName() {
		return name;
	} // getName
	
	/**
	 * Sets the name of the sport to a new vale 
	 * @param name The new name for the sport
	 * Pre: (name != null) && (name != "")
	 */
	public void setName(String name) {
		this.name = name;
	} // setName
	
	/**
	 * Gets the number of points a team gets per win in this sport 
	 * @return The number of points a team gets per win in this sport
	 */
	public int getPointsPerWin() {
		return pointsPerWin;
	} // getPointsPerWin
	
	/**
	 * Gets the number of points a team gets per tie in this sport 
	 * @return The number of points a team gets per tie in this sport
	 */
	public int getPointsPerTie() {
		return pointsPerTie;
	} // getPointsPerTie
	
	/**
	 * Gets the number of points a team gets per defeat in this sport 
	 * @return The number of points a team gets per defeat in this sport
	 */
	public int getPointsPerDefeat() {
		return pointsPerDefeat;
	} // getPointsPerDefeat

	/**
	 * Sets the number of points a team gets per win to the specific number 
	 * @param pointsPerWin The number of points a team gets per win
	 * Pre: (pointsPerWin >0) && (pointsPerWin > pointsPerDefeat) && 
	 *      (pointsPerWin >= pointsPerDefeat)
	 */
	public void setPointsPerWin(int pointsPerWin) {
		this.pointsPerWin = pointsPerWin;
	} // setPointsPerWin

	/**
	 * Sets the number of points a team gets per tie to the specific number 
	 * @param pointsPerWin The number of points a team gets per tie
	 * Pre: (pointsPerTie >=0) && (pointsPerWin > pointsPerTie) && 
	 *      (pointsPerTie >= pointsPerDefeat)
	 */
	public void setPointsPerTie(int pointsPerTie) {
		this.pointsPerTie = pointsPerTie;
	} // setPointsPerTie

	/**
	 * Sets the number of points a team gets per defeat, if any to the specific number 
	 * @param pointsPerWin The number of points a team gets per win
	 * Pre: (pointsPerDefeat >=0) && (pointsPerDefeat > pointsPerTie) && 
	 *      (pointsPerTie >= pointsPerDefeat)
	 */
	public void setPointsPerDefeat(int pointsPerDefeat) {
		this.pointsPerDefeat = pointsPerDefeat;
	} // setPointsPerDefeat

	@Override
	public int hashCode() {
		return name.hashCode();
	} // hasCode

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if ((obj!= null) && (obj instanceof Sport)) {
			Sport other = (Sport) obj;
			result = this.name.equals(other.getName());
		} // if
		return result;
	}

	@Override
	public int compareTo(Sport other) {
		return this.name.compareTo(other.getName());
	} // equals
	
} // Sport
