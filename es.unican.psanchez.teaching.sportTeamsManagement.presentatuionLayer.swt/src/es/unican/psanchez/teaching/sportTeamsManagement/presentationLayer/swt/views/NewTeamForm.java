package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.swt.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;

public class NewTeamForm extends Composite {
	
	private Text name_text;
	protected NewTeamFormController controller = new NewTeamFormController(this); 
	private Combo sports_combo;
	
	public String getSport() {
		return name_text.getText();
	}

	public Combo getSportsCombo() {
		return sports_combo;
	}

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public NewTeamForm(Composite parent, int style) {
		super(parent, style);
		addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				controller.feedSportsAction();
			}
		});
		setLayout(new FormLayout());
		
		Label name_Label = new Label(this, SWT.RIGHT);
		FormData fd_name_Label = new FormData();
		fd_name_Label.right = new FormAttachment(0, 74);
		fd_name_Label.top = new FormAttachment(0, 21);
		fd_name_Label.left = new FormAttachment(0, 25);
		name_Label.setLayoutData(fd_name_Label);
		name_Label.setText("Nombre");
		
		name_text = new Text(this, SWT.BORDER);
		FormData fd_name_text = new FormData();
		fd_name_text.right = new FormAttachment(100, -25);
		fd_name_text.left = new FormAttachment(name_Label, 6);
		fd_name_text.top = new FormAttachment(name_Label, -3, SWT.TOP);
		name_text.setLayoutData(fd_name_text);
		
		Label lblNewLabel = new Label(this, SWT.RIGHT);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.left = new FormAttachment(name_Label, -49);
		fd_lblNewLabel.right = new FormAttachment(name_Label, 0, SWT.RIGHT);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("Deporte");
		
		sports_combo = new Combo(this, SWT.NONE);
		fd_lblNewLabel.top = new FormAttachment(sports_combo, 3, SWT.TOP);
		FormData fd_sports_combo = new FormData();
		fd_sports_combo.left = new FormAttachment(0, 80);
		fd_sports_combo.top = new FormAttachment(name_text, 6);
		sports_combo.setLayoutData(fd_sports_combo);
		
		Button newTeam_Button = new Button(this, SWT.NONE);
		fd_sports_combo.right = new FormAttachment(newTeam_Button, -98);
		FormData fd_newTeam_Button = new FormData();
		fd_newTeam_Button.top = new FormAttachment(name_text, 6);
		fd_newTeam_Button.right = new FormAttachment(name_text, 0, SWT.RIGHT);
		newTeam_Button.setLayoutData(fd_newTeam_Button);
		newTeam_Button.setText("Nuevo Equipo");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
