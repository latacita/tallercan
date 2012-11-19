package es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation;

import java.util.List;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ISportManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.dao.implementation.mysql.SportDaoMySqlImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;

public class SportMngImpl implements ISportManagement {

	/**
	 * @see ISportManagement.createSport
	 */
	@Override
	public boolean createSport(String sport, int pointsPerWin, int pointsPerTie, int pointsPerDefeat) {
		Sport s = new Sport(sport);
		s.setPointsPerWin(pointsPerWin);
		s.setPointsPerTie(pointsPerTie);
		s.setPointsPerDefeat(pointsPerDefeat);
		ISportDao daoSport = new SportDaoMySqlImpl();
		daoSport.addSport(s);
		return true; 
	} // createSport

	/**
	 * @see ISportManagement.removeSport
	 */
	@Override
	public boolean removeSport(String sport) {
		ISportDao daoSport = new SportDaoMySqlImpl();
		daoSport.delete(sport);
		return false;
	} // removeSport

	/**
	 * @see ISportManagement.getAllSports
	 */
	@Override
	public List<Sport> getAllSports() {
		ISportDao daoSport = new SportDaoMySqlImpl();
		return daoSport.findAll();
	} // getAllSports

} // SportMngImpl
