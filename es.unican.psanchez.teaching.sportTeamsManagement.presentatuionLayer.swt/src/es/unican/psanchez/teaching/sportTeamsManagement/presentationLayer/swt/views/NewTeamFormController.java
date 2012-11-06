package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.swt.views;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ISportManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation.SportMngImpl;

/**
 * Class implenting the controller for the new team form 
 * @author Pablo Sanchez (p.sanchez@unican.es)
 * 
 */
public class NewTeamFormController {
	
	NewTeamForm form = null;
	ISportManagement sportMng = new SportMngImpl();
	
	public NewTeamFormController(NewTeamForm form) {
		this.form = form;
	} // NewTeamFormController
	
	public void createNewTeamAction() {
		sportMng.createSport(form.getSportName());
	} // createNewTeamAction

} // NewTeamWindow
