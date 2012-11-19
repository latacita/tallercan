package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.swt.views;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ISportManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation.SportMngImpl;

public class NewSportFormController {
	
	NewSportForm form = null;
	ISportManagement service = new SportMngImpl();
	
	public NewSportFormController(NewSportForm form) {
		this.form =  form;
	} // NewSportFormController
	
	public void newTeamAction() {
		service.createSport(form.getSportText().getText(),
				Integer.parseInt(form.getPointsPerWinText().getText()),
				Integer.parseInt(form.getPointsPerTieText().getText()),
				Integer.parseInt(form.getPointsPerDefeatText().getText()));
	} // newTeamAction

} // NewSportFormController
