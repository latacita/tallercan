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
	private Text pointsPerWin_text;
	private Text pointsPerTie_text;
	private Text pointsPerDefeat_text;
	
	public Text getSportText() {
		return name_text;
	} // getSportName
	
	public Text getPointsPerWinText() {
		return pointsPerWin_text;
	} // getPointsPerWinText

	public Text getPointsPerTieText() {
		return pointsPerWin_text;
	} // getPointsPerTieText

	public Text getPointsPerDefeatText() {
		return pointsPerWin_text;
	} // getPointsPerDefeatText

	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public NewSportForm(Composite parent, int style) {
		super(parent, style);
		setLayout(new FormLayout());
		
		Label name_Label = new Label(this, SWT.RIGHT);
		FormData fd_name_Label = new FormData();
		fd_name_Label.left = new FormAttachment(0, 70);
		name_Label.setLayoutData(fd_name_Label);
		name_Label.setText("Nombre");
		
		name_text = new Text(this, SWT.BORDER);
		fd_name_Label.top = new FormAttachment(name_text, 3, SWT.TOP);
		fd_name_Label.right = new FormAttachment(name_text, -6);
		FormData fd_name_text = new FormData();
		fd_name_text.top = new FormAttachment(0, 88);
		fd_name_text.right = new FormAttachment(0, 360);
		name_text.setLayoutData(fd_name_text);
		
		Button newSport_button = new Button(this, SWT.NONE);
		FormData fd_newSport_button = new FormData();
		fd_newSport_button.top = new FormAttachment(0, 213);
		fd_newSport_button.left = new FormAttachment(0, 178);
		newSport_button.setLayoutData(fd_newSport_button);
		newSport_button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controller.newTeamAction();
			}
		});
		newSport_button.setText("Nuevo Deporte");
		
		Label pointsPerWin_label = new Label(this, SWT.RIGHT);
		FormData fd_pointsPerWin_label = new FormData();
		fd_pointsPerWin_label.left = new FormAttachment(0, 70);
		pointsPerWin_label.setLayoutData(fd_pointsPerWin_label);
		pointsPerWin_label.setText("Puntos por Victoria");
		
		Label pointsPerTie_label = new Label(this, SWT.RIGHT);
		fd_pointsPerWin_label.right = new FormAttachment(pointsPerTie_label, 0, SWT.RIGHT);
		FormData fd_pointsPerTie_label = new FormData();
		fd_pointsPerTie_label.left = new FormAttachment(0, 70);
		pointsPerTie_label.setLayoutData(fd_pointsPerTie_label);
		pointsPerTie_label.setText("Puntos por Empate");
		
		Label pointsPerDefeat_label = new Label(this, SWT.RIGHT);
		FormData fd_pointsPerDefeat_label = new FormData();
		fd_pointsPerDefeat_label.left = new FormAttachment(pointsPerTie_label, 0, SWT.LEFT);
		pointsPerDefeat_label.setLayoutData(fd_pointsPerDefeat_label);
		pointsPerDefeat_label.setText("Puntos por Derrota");
		
		pointsPerWin_text = new Text(this, SWT.BORDER);
		fd_pointsPerWin_label.top = new FormAttachment(pointsPerWin_text, 3, SWT.TOP);
		fd_name_text.left = new FormAttachment(pointsPerWin_text, 0, SWT.LEFT);
		FormData fd_pointsPerWin_text = new FormData();
		fd_pointsPerWin_text.bottom = new FormAttachment(newSport_button, -82);
		fd_pointsPerWin_text.left = new FormAttachment(0, 195);
		fd_pointsPerWin_text.right = new FormAttachment(0, 232);
		pointsPerWin_text.setLayoutData(fd_pointsPerWin_text);
		
		pointsPerTie_text = new Text(this, SWT.BORDER);
		fd_pointsPerTie_label.right = new FormAttachment(pointsPerTie_text, -6);
		fd_pointsPerTie_label.top = new FormAttachment(pointsPerTie_text, 3, SWT.TOP);
		FormData fd_pointsPerTie_text = new FormData();
		fd_pointsPerTie_text.bottom = new FormAttachment(newSport_button, -57);
		fd_pointsPerTie_text.left = new FormAttachment(0, 195);
		fd_pointsPerTie_text.top = new FormAttachment(pointsPerWin_text, 6);
		fd_pointsPerTie_text.right = new FormAttachment(0, 232);
		pointsPerTie_text.setLayoutData(fd_pointsPerTie_text);
		
		pointsPerDefeat_text = new Text(this, SWT.BORDER);
		fd_pointsPerDefeat_label.top = new FormAttachment(pointsPerDefeat_text, 3, SWT.TOP);
		fd_pointsPerDefeat_label.right = new FormAttachment(pointsPerDefeat_text, -6);
		FormData fd_pointsPerLost_text = new FormData();
		fd_pointsPerLost_text.bottom = new FormAttachment(newSport_button, -31);
		fd_pointsPerLost_text.left = new FormAttachment(0, 195);
		fd_pointsPerLost_text.right = new FormAttachment(0, 232);
		pointsPerDefeat_text.setLayoutData(fd_pointsPerLost_text);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
