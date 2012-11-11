package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.swt.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Button;

public class SportListForm extends Composite {

	private Table sportList_table;
	protected SportListFormController controller = new SportListFormController(this);
	
	public Table getTable() {
		return sportList_table;
	} // getTable

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public SportListForm(Composite parent, int style) {
		super(parent, style);
		addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				controller.feedTable();
			}
		});
		setLayout(new FormLayout());
		
		sportList_table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		FormData fd_sportList_table = new FormData();
		fd_sportList_table.top = new FormAttachment(0, 10);
		fd_sportList_table.left = new FormAttachment(0, 10);
		fd_sportList_table.bottom = new FormAttachment(0, 294);
		fd_sportList_table.right = new FormAttachment(0, 177);
		sportList_table.setLayoutData(fd_sportList_table);
		sportList_table.setHeaderVisible(true);
		sportList_table.setLinesVisible(true);
		
		TableColumn name_Column = new TableColumn(sportList_table, SWT.NONE);
		name_Column.setWidth(163);
		name_Column.setText("Nombre");
		
		Button borrarDeporte_btn = new Button(this, SWT.NONE);
		FormData fd_borrarDeporte_btn = new FormData();
		fd_borrarDeporte_btn.top = new FormAttachment(0, 10);
		fd_borrarDeporte_btn.left = new FormAttachment(sportList_table, 19);
		borrarDeporte_btn.setLayoutData(fd_borrarDeporte_btn);
		borrarDeporte_btn.setText("Borrar Deporte");
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
