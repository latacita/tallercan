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
	
} // Sport
