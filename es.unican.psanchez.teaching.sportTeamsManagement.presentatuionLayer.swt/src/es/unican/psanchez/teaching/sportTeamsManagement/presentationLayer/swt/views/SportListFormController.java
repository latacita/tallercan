package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.swt.views;

import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.providedServices.ISportManagement;
import es.unican.psanchez.teaching.sportTeamsManagement.businessLayer.serviceImplementation.SportMngImpl;
import es.unican.psanchez.teaching.sportTeamsManagement.domainObjects.Sport;

public class SportListFormController {
	
	SportListForm form = null;
	ISportManagement service = new SportMngImpl();
	
	public SportListFormController(SportListForm form) {
		this.form = form;
	} // SportListFormController
	
	public void feedTable() {
		
		Set<Sport> sports = service.getAllSports();
		Table table = form.getTable();
		table.removeAll();
		
		for (Sport s : sports) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(0, s.getName());
		} // for
		
		
	} // feedTable

} // SportListFormController
