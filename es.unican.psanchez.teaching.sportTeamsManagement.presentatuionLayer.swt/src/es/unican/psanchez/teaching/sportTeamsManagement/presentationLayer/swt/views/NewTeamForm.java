package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.swt.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class NewTeamForm extends Composite {
	
	private Text name_text;
	protected NewTeamFormController controller = new NewTeamFormController(this); 
	
	public String getSportName() {
		return name_text.getText();
	} // getSportName

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public NewTeamForm(Composite parent, int style) {
		super(parent, style);
		setLayout(new FormLayout());
		
		Label name_label = new Label(this, SWT.NONE);
		FormData fd_name_label = new FormData();
		fd_name_label.top = new FormAttachment(0, 10);
		fd_name_label.left = new FormAttachment(0, 23);
		name_label.setLayoutData(fd_name_label);
		name_label.setText("Name");
		
		name_text = new Text(this, SWT.BORDER);
		FormData fd_name_text = new FormData();
		fd_name_text.top = new FormAttachment(name_label, -3, SWT.TOP);
		fd_name_text.right = new FormAttachment(name_label, 267, SWT.RIGHT);
		fd_name_text.left = new FormAttachment(name_label, 8);
		name_text.setLayoutData(fd_name_text);
		
		Button newTeam_button = new Button(this, SWT.NONE);
		newTeam_button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controller.createNewTeamAction();
			}
		});
		FormData fd_newTeam_button = new FormData();
		fd_newTeam_button.top = new FormAttachment(name_text, 29);
		fd_newTeam_button.left = new FormAttachment(0, 126);
		newTeam_button.setLayoutData(fd_newTeam_button);
		newTeam_button.setText("Nuevo Equipo");

	} // NewTeamForm
} // NewTeamForm
