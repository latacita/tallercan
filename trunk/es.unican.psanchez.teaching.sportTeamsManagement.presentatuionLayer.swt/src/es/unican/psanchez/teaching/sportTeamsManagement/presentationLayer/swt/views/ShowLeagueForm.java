package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.swt.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ShowLeagueForm extends Composite {
	
	private Table league_Table;
	private TableColumn pointColumn;
	private Combo sport_Combo;
	
	protected ShowLeagueFormController controller = new ShowLeagueFormController(this);
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ShowLeagueForm(Composite parent, int style) {
		super(parent, style);
		addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				controller.initializeForm();
			}
		});
		setLayout(new FormLayout());
		
		Label sport_Label = new Label(this, SWT.NONE);
		FormData fd_sport_Label = new FormData();
		sport_Label.setLayoutData(fd_sport_Label);
		sport_Label.setText("Deporte");
		
		sport_Combo = new Combo(this, SWT.NONE);
		sport_Combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controller.sportComboChanged();
			}
		});
		fd_sport_Label.top = new FormAttachment(0, 23);
		fd_sport_Label.right = new FormAttachment(sport_Combo, -6);
		FormData fd_sport_Combo = new FormData();
		fd_sport_Combo.top = new FormAttachment(sport_Label, -4, SWT.TOP);
		fd_sport_Combo.right = new FormAttachment(100, -176);
		fd_sport_Combo.left = new FormAttachment(0, 176);
		sport_Combo.setLayoutData(fd_sport_Combo);
		
		league_Table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		FormData fd_league_Table = new FormData();
		fd_league_Table.top = new FormAttachment(sport_Combo, 30);
		fd_league_Table.left = new FormAttachment(0, 80);
		fd_league_Table.right = new FormAttachment(0, 511);
		league_Table.setLayoutData(fd_league_Table);
		league_Table.setHeaderVisible(true);
		league_Table.setLinesVisible(true);
		
		TableColumn team_Column = new TableColumn(league_Table, SWT.NONE);
		team_Column.setWidth(128);
		team_Column.setText("Equipo");
		
		pointColumn = new TableColumn(league_Table, SWT.NONE);
		pointColumn.setWidth(50);
		pointColumn.setText("Puntos");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(league_Table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(60);
		tblclmnNewColumn_2.setText("Jugados");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(league_Table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(59);
		tblclmnNewColumn_3.setText("Ganados");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(league_Table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(67);
		tblclmnNewColumn_4.setText("Empatados");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(league_Table, SWT.NONE);
		tblclmnNewColumn_5.setWidth(61);
		tblclmnNewColumn_5.setText("Perdidos");
		
		Button deleteTeam_button = new Button(this, SWT.NONE);
		fd_league_Table.bottom = new FormAttachment(deleteTeam_button, -25);
		FormData fd_deleteTeam_button = new FormData();
		fd_deleteTeam_button.bottom = new FormAttachment(100, -10);
		fd_deleteTeam_button.right = new FormAttachment(100, -245);
		deleteTeam_button.setLayoutData(fd_deleteTeam_button);
		deleteTeam_button.setText("Borrar Deporte");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public Combo getSportsCombo() {
		return this.sport_Combo;
	}  // getSportsCombo
	
	public Table getLeagueTable() {
		return this.league_Table;
	}  // getSportsCombo

} 
