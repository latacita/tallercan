package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.swt.views;

import java.util.Set;

import org.eclipse.swt.widgets.Combo;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ISportManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation.SportMngImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;

public class NewTeamFormController {

	protected NewTeamForm form = null;
	protected ISportManagement service = new SportMngImpl();
	
	public NewTeamFormController(NewTeamForm form) {
		this.form = form;
	} // NewTeamFormController
	
	public void feedSportsAction() {
		
		Combo combo = form.getSportsCombo();
		combo.removeAll();
		
		Set<Sport> sports = service.getAllSports();
		
		for (Sport s : sports) {
			combo.add(s.getName());
		} // for
		
	} // feedSportsAction
	

} // NewTeamFormController
