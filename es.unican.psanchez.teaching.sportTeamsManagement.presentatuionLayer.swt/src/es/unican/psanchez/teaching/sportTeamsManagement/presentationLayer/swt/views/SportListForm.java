package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.swt.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;

public class SportListForm extends Composite {
	private Table sportList_table;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public SportListForm(Composite parent, int style) {
		super(parent, style);
		
		sportList_table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		sportList_table.setBounds(0, 0, 450, 300);
		sportList_table.setHeaderVisible(true);
		sportList_table.setLinesVisible(true);
		
		TableColumn name_Column = new TableColumn(sportList_table, SWT.NONE);
		name_Column.setWidth(444);
		name_Column.setText("Name");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
