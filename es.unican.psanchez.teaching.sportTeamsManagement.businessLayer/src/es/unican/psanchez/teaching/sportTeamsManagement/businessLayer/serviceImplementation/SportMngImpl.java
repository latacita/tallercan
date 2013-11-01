package es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation;

import java.util.SortedSet;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ISportManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.factory.PersistenceLayerFactory;

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
		ISportDao daoSport = PersistenceLayerFactory.createSportDao();
		daoSport.addSport(s); 
		return true; 
	} // createSport

	/**
	 * @see ISportManagement.removeSport
	 */
	@Override
	public boolean removeSport(String sport) {
		ISportDao daoSport = PersistenceLayerFactory.createSportDao();
		daoSport.delete(sport);
		return false;
	} // removeSport

	/**
	 * @see ISportManagement.getAllSports
	 */
	@Override
	public SortedSet<Sport> getAllSports() {
		ISportDao daoSport = PersistenceLayerFactory.createSportDao();
		return daoSport.findAll();
	} // getAllSports

} // SportMngImpl
