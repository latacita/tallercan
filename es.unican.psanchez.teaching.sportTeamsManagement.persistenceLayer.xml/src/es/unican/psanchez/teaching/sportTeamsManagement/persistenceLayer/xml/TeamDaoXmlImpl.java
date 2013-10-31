package es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.xml;

import java.util.SortedSet;
import java.util.TreeSet;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Team;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.TeamPointsComparator;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ITeamDao;

/**
 * Class implementing the ITeamDao interface for 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * http://personales.unican.es/sanchezbp
 */
public class TeamDaoXmlImpl implements ITeamDao{
	
	//-----------------------------------------------------------------------------------------------------//
	// 											Public Methods										       // 
	//-----------------------------------------------------------------------------------------------------//
	
	@Override
	public boolean addTeam(Team team) {
		
		boolean result = false;
		
		XmlDocument builder = XmlDocument.getInstance();
		Document doc = builder.getDocument();
		Element sportNode = XmlDocument.getInstance().findSportNode(team.getSport().getName());
		Element teamNode  = XmlDocument.getInstance().findTeamNode(sportNode,team.getName());

		if (teamNode ==  null) {
			
			// We firstly create the attributes for the class
			Element name = XmlHelper.createTextElement(doc,"stm:name",team.getName());
			Element matchesPlayed = XmlHelper.createTextElement(doc,"stm:matchesPlayed",Integer.toString(team.getMatchesPlayed()));
			Element matchesWon = XmlHelper.createTextElement(doc,"stm:matchesWon",Integer.toString(team.getMatchesWon()));
			Element matchesTied = XmlHelper.createTextElement(doc,"stm:matchesTied",Integer.toString(team.getMatchesTied()));
			
			teamNode = doc.createElement("stm:team");
			teamNode.appendChild(name);
			teamNode.appendChild(matchesPlayed);
			teamNode.appendChild(matchesWon);
			teamNode.appendChild(matchesTied);
			
			// We add the node to the root of the document
			Element teamsList = (Element) sportNode.getElementsByTagName("stm:teams").item(0);
			teamsList.appendChild(teamNode);
			
			// and finally, we save the changes
			builder.saveChanges();
			
			result = true;
		} // if
		
		return result;
	}

 
	@Override
	public SortedSet<Team> findAllInSport(String sport) {
		
		SortedSet<Team> result = new TreeSet<Team>(new TeamPointsComparator());
		
		Element sportNode = XmlDocument.getInstance().findSportNode(sport);
		NodeList teams = sportNode.getElementsByTagName("stm:team");
		
		Sport s = new SportDaoXmlImpl().findByName(sport); 
		
		for(int i = 0;i<teams.getLength();i++) {
			Team t = processTeam((Element) teams.item(i),s);
			result.add(t);
		} // for
		
		return result;
	}

	@Override
	public Team findByNameAndSport(String name, String sport) {
		
		Team result = null;
		
		Sport s = new SportDaoXmlImpl().findByName(sport);
		
		if (s != null) {
			
			Element sportNode = XmlDocument.getInstance().findSportNode(sport);
			Element teamNode = XmlDocument.getInstance().findTeamNode(sportNode,name);
			
			if (teamNode != null) {
				result = processTeam(teamNode,s);
			} // if
		} // if
			
		return result;
	} // findByNameAndSport

	@Override
	public boolean updateTeamStatistics(Team team) {
		
		boolean result = false;
		
		Document doc = XmlDocument.getInstance().getDocument();
		
		Element sportNode = XmlDocument.getInstance().findSportNode(team.getSport().getName());
		
		if (sportNode != null) {
		
			Element teamNode  = XmlDocument.getInstance().findTeamNode(sportNode,team.getName());
			
			if (teamNode != null) {

				Element matchesPlayed = XmlHelper.createTextElement(doc,"stm:matchesPlayed",Integer.toString(team.getMatchesPlayed()));
				Element matchesWon = XmlHelper.createTextElement(doc,"stm:matchesWon",Integer.toString(team.getMatchesWon()));
				Element matchesTied = XmlHelper.createTextElement(doc,"stm:matchesTied",Integer.toString(team.getMatchesTied()));

				Node oldMatchesPlayed = teamNode.getElementsByTagName("stm:matchesPlayed").item(0); 
				Node oldMatchesWon    = teamNode.getElementsByTagName("stm:matchesWon").item(0);
				Node oldMatchesTied   = teamNode.getElementsByTagName("stm:matchesTied").item(0);

				teamNode.replaceChild(matchesPlayed, oldMatchesPlayed);
				teamNode.replaceChild(matchesWon, oldMatchesWon);
				teamNode.replaceChild(matchesTied, oldMatchesTied);
				
				result = true;
				
			} // if
		} // if
		
		return result;
	} // updateTeamStatistics

	@Override
	public boolean delete(String name, String sport) {
		
		boolean result = false;
		
		Element sportNode = XmlDocument.getInstance().findSportNode(sport);
		
		if (sportNode != null) {
		
			Element teamNode  = XmlDocument.getInstance().findTeamNode(sportNode,name);
			
			if (teamNode != null) {
				
				teamNode.getParentNode().removeChild(teamNode);
				result = true;

			} // if
		} // if
		
		return result;
	}
	
	//-----------------------------------------------------------------------------------------------------//
	// 											Helper Methods										       // 
	//-----------------------------------------------------------------------------------------------------//
	
	private Team processTeam(Element team, Sport s) {
		
		Team result = new Team(XmlHelper.getChildTextValue(team,"stm:name"),s);
		
		int matchesPlayed = Integer.parseInt(XmlHelper.getChildTextValue(team,"stm:matchesPlayed"));
		int matchesWon    = Integer.parseInt(XmlHelper.getChildTextValue(team,"stm:matchesWon"));
		int matchesTied   = Integer.parseInt(XmlHelper.getChildTextValue(team,"stm:matchesTied"));
		
		result.loadStatistics(matchesPlayed, matchesWon, matchesTied);
		return result;

	} // processTeam


} // TeamDaoXmlImpl
