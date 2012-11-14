package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces;

import java.util.Set;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Team;

public interface ITeamDao {
	
	public void addTeam(Team team);

	public void delete(String name, String sport);

	public Set<Team> findAllInSport(String sport);
	
	public Team findByNameAndSport(String name, String sport);
	
}
