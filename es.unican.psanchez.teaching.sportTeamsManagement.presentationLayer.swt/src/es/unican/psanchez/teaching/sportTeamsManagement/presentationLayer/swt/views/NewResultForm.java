package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.swt.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class NewResultForm extends Composite {
	
	private Combo sports_combo;
	private Combo localTeam_combo;
	private Combo visitingTeam_combo;
	
	protected NewResultFormController controller = new NewResultFormController(this); 
	private Text localTeamPoints_text;
	private Text visitingTeamPoints_text;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public NewResultForm(Composite parent, int style) {
		super(parent, style);
		addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				controller.initializeForm();
			}
		});
		setLayout(new FormLayout());
		
		Label sport_Label = new Label(this, SWT.RIGHT);
		FormData fd_sport_Label = new FormData();
		fd_sport_Label.right = new FormAttachment(0, 211);
		fd_sport_Label.top = new FormAttachment(0, 13);
		fd_sport_Label.left = new FormAttachment(0, 143);
		sport_Label.setLayoutData(fd_sport_Label);
		sport_Label.setText("Deporte");
		
		sports_combo = new Combo(this, SWT.NONE);
		sports_combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controller.sportSelectedAction();
			}
		});
		FormData fd_sports_combo = new FormData();
		fd_sports_combo.right = new FormAttachment(0, 415);
		fd_sports_combo.top = new FormAttachment(0, 10);
		fd_sports_combo.left = new FormAttachment(0, 215);
		sports_combo.setLayoutData(fd_sports_combo);
		
		localTeam_combo = new Combo(this, SWT.NONE);
		FormData fd_localTeam_combo = new FormData();
		fd_localTeam_combo.right = new FormAttachment(0, 316);
		fd_localTeam_combo.top = new FormAttachment(0, 57);
		fd_localTeam_combo.left = new FormAttachment(0, 141);
		localTeam_combo.setLayoutData(fd_localTeam_combo);
		
		visitingTeam_combo = new Combo(this, SWT.NONE);
		FormData fd_visiting_team = new FormData();
		fd_visiting_team.right = new FormAttachment(0, 316);
		fd_visiting_team.top = new FormAttachment(0, 95);
		fd_visiting_team.left = new FormAttachment(0, 141);
		visitingTeam_combo.setLayoutData(fd_visiting_team);
		
		Label localTeam_Label = new Label(this, SWT.RIGHT);
		FormData fd_localTeam_Label = new FormData();
		fd_localTeam_Label.right = new FormAttachment(0, 135);
		fd_localTeam_Label.top = new FormAttachment(0, 61);
		fd_localTeam_Label.left = new FormAttachment(0, 49);
		localTeam_Label.setLayoutData(fd_localTeam_Label);
		localTeam_Label.setText("Equipo Local");
		
		Label visitingTeam_label = new Label(this, SWT.RIGHT);
		FormData fd_visitingTeam_label = new FormData();
		fd_visitingTeam_label.right = new FormAttachment(0, 135);
		fd_visitingTeam_label.top = new FormAttachment(0, 99);
		fd_visitingTeam_label.left = new FormAttachment(0, 49);
		visitingTeam_label.setLayoutData(fd_visitingTeam_label);
		visitingTeam_label.setText("Equipo Visitante");
		
		localTeamPoints_text = new Text(this, SWT.BORDER);
		FormData fd_localTeamPoints_text = new FormData();
		fd_localTeamPoints_text.top = new FormAttachment(0, 57);
		fd_localTeamPoints_text.left = new FormAttachment(0, 322);
		localTeamPoints_text.setLayoutData(fd_localTeamPoints_text);
		
		visitingTeamPoints_text = new Text(this, SWT.BORDER);
		FormData fd_visitingTeamPoints_text = new FormData();
		fd_visitingTeamPoints_text.top = new FormAttachment(0, 95);
		fd_visitingTeamPoints_text.left = new FormAttachment(0, 322);
		visitingTeamPoints_text.setLayoutData(fd_visitingTeamPoints_text);
		
		Label localTeamPoints_label = new Label(this, SWT.NONE);
		FormData fd_localTeamPoints_label = new FormData();
		fd_localTeamPoints_label.right = new FormAttachment(0, 499);
		fd_localTeamPoints_label.top = new FormAttachment(0, 60);
		fd_localTeamPoints_label.left = new FormAttachment(0, 404);
		localTeamPoints_label.setLayoutData(fd_localTeamPoints_label);
		localTeamPoints_label.setText("Puntos Local");
		
		Label visitingTeamPoints_label = new Label(this, SWT.NONE);
		FormData fd_visitingTeamPoints_label = new FormData();
		fd_visitingTeamPoints_label.right = new FormAttachment(0, 499);
		fd_visitingTeamPoints_label.top = new FormAttachment(0, 98);
		fd_visitingTeamPoints_label.left = new FormAttachment(0, 404);
		visitingTeamPoints_label.setLayoutData(fd_visitingTeamPoints_label);
		visitingTeamPoints_label.setText("Puntos Visitante");
		
		Button newResult_button = new Button(this, SWT.NONE);
		newResult_button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controller.newResultAction();
			}
		});
		FormData fd_newResult_button = new FormData();
		fd_newResult_button.right = new FormAttachment(0, 375);
		fd_newResult_button.top = new FormAttachment(0, 150);
		fd_newResult_button.left = new FormAttachment(0, 255);
		newResult_button.setLayoutData(fd_newResult_button);
		newResult_button.setText("Nuevo Resultado");

	} // NewResultForm

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	} // checkSubclass
	
	public Combo getSportsCombo() {
		return this.sports_combo;
	} // getSportsCombo
	
	public Combo getLocalTeamCombo() {
		return this.localTeam_combo;
	} // getLocalTeamCombo
	
	public Combo getVisitingTeamCombo() {
		return this.visitingTeam_combo;
	} // getLocalTeamCombo
	
	public Text getLocalTeamText() {
		return this.localTeamPoints_text;
	} // getLocalTeamText
	
	public Text getVisitingTeamText() {
		return this.visitingTeamPoints_text;
	} // getLocalTeamText

} // NewResultForm
