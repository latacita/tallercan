package es.unican.psanchez.teaching.sportTeamsManagement.domainObjects;

import java.util.Set;

/**
 * Bussines object representing sports. Each sport has basically a name and 
 * different teams can play a sport  
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class Sport {

	protected String name;
	protected Set<Team> teams;
	// Inv: pointsPerWin > 0
	protected int pointsPerWin;
	// Inv: pointsPerTie >= 0
	protected int pointsPerTie;
	// Inv: pointsPerDefeat => 0
	protected int pointsPerDefeat;
	
	public Sport(String name) {
		this.name = name;
	} // Sport
	
	public String getName() {
		return name;
	} // getName
	
	public void setName(String name) {
		this.name = name;
	} // setName
	
	public Set<Team> getAllTeams() {
		return this.teams;
	} // getAllTeams

	public int getPointsPerWin() {
		return pointsPerWin;
	}

	public void setPointsPerWin(int pointsPerWin) {
		this.pointsPerWin = pointsPerWin;
	}

	public int getPointsPerTie() {
		return pointsPerTie;
	}

	public void setPointsPerTie(int pointsPerTie) {
		this.pointsPerTie = pointsPerTie;
	}

	public int getPointsPerDefeat() {
		return pointsPerDefeat;
	}

	public void setPointsPerDefeat(int pointsPerDefeat) {
		this.pointsPerDefeat = pointsPerDefeat;
	}
	
} // Sport
