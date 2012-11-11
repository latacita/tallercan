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

public class NewSportForm extends Composite {
	
	private Text name_text;
	protected NewSportFormController controller = new NewSportFormController(this);
	
	public String getSportName() {
		return name_text.getText();
	} // getSportName
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public NewSportForm(Composite parent, int style) {
		super(parent, style);
		setLayout(new FormLayout());
		
		Label name_Label = new Label(this, SWT.NONE);
		FormData fd_name_Label = new FormData();
		fd_name_Label.top = new FormAttachment(0, 21);
		fd_name_Label.left = new FormAttachment(0, 25);
		name_Label.setLayoutData(fd_name_Label);
		name_Label.setText("Name");
		
		name_text = new Text(this, SWT.BORDER);
		FormData fd_name_text = new FormData();
		fd_name_text.top = new FormAttachment(name_Label, -3, SWT.TOP);
		fd_name_text.left = new FormAttachment(name_Label, 6);
		fd_name_text.right = new FormAttachment(100, -21);
		name_text.setLayoutData(fd_name_text);
		
		Button newSport_button = new Button(this, SWT.NONE);
		newSport_button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		FormData fd_newSport_button = new FormData();
		fd_newSport_button.top = new FormAttachment(0, 70);
		fd_newSport_button.left = new FormAttachment(0, 179);
		newSport_button.setLayoutData(fd_newSport_button);
		newSport_button.setText("Nuevo Deporte");
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
