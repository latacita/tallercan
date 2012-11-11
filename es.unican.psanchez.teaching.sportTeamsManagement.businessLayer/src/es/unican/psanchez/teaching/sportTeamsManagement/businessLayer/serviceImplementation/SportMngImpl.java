package es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation;

import java.util.Set;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ISportManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.dao.implementation.mysql.SportDaoMySqlImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;

public class SportMngImpl implements ISportManagement {

	@Override
	public void createSport(String sport) {
		Sport s = new Sport(sport);
		ISportDao daoSport = new SportDaoMySqlImpl();
		daoSport.addSport(s);
	} // createSport

	@Override
	public void removeSport(String sport) {
		ISportDao daoSport = new SportDaoMySqlImpl();
		daoSport.delete(sport);
	} // removeSport

	@Override
	public Set<Sport> getAllSports() {
		ISportDao daoSport = new SportDaoMySqlImpl();
		return daoSport.findAll();
	} // getAllSports

} // SportMngImpl
