package es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ISportManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;
import es.unican.psanchez.teaching.sportTeamsManagement.persistenceLayer.daoInterfaces.ISportDao;

public class SportMngImpl implements ISportManagement {

	@Override
	public void createSport(String sport) {
		Sport s = new Sport(sport);
		ISportDao daoSport = new SportDaoMySqlImpl();
		daoSport.addSport(sport);
	} // createSport

	@Override
	public void removeSport(String sport) {
		// TODO Auto-generated method stub

	} // removeSport

	@Override
	public void getAllSports(String sport) {
		// TODO Auto-generated method stub

	} // getAllSports

} // SportMngImpl
