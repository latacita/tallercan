package es.unican.psanchez.teaching.sportTeamsManagement.presentatuionLayer.swt.views;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ApplicationWindow {

	protected Shell mainWindow;
	private Text name_Text;
	private Table table;

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		mainWindow.open();
		mainWindow.layout();
		while (!mainWindow.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		mainWindow = new Shell();
		mainWindow.setSize(742, 576);
		mainWindow.setText("Gesti\u00F3n de Competiciones Deportivos");
		
		CTabFolder mainTabFolder = new CTabFolder(mainWindow, SWT.BORDER);
		mainTabFolder.setBounds(0, 0, 734, 549);
		mainTabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem teams_tabItem = new CTabItem(mainTabFolder, SWT.NONE);
		teams_tabItem.setText("Equipos");
		
		Composite teams_composite = new Composite(mainTabFolder, SWT.NONE);
		teams_tabItem.setControl(teams_composite);
		
		CTabFolder teams_tabFolder = new CTabFolder(teams_composite, SWT.BORDER);
		teams_tabFolder.setBounds(0, 0, 728, 526);
		teams_tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem newTeam_tabItem = new CTabItem(teams_tabFolder, SWT.NONE);
		newTeam_tabItem.setText("NuevoEquipo");
		
		Composite newTeam_composite = new Composite(teams_tabFolder, SWT.NONE);
		newTeam_tabItem.setControl(newTeam_composite);
		newTeam_composite.setLayout(new GridLayout(2, false));
		
		Label name_Label = new Label(newTeam_composite, SWT.NONE);
		name_Label.setAlignment(SWT.RIGHT);
		GridData gd_name_Label = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_name_Label.widthHint = 94;
		name_Label.setLayoutData(gd_name_Label);
		name_Label.setText("Nombre Equipo");
		
		name_Text = new Text(newTeam_composite, SWT.BORDER);
		name_Text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label sport_Label = new Label(newTeam_composite, SWT.NONE);
		sport_Label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		sport_Label.setText("Deporte");
		
		Combo sport_combo = new Combo(newTeam_composite, SWT.NONE);
		sport_combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(newTeam_composite, SWT.NONE);
		
		Button newTeam_button = new Button(newTeam_composite, SWT.CENTER);
		newTeam_button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		newTeam_button.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false, 1, 1));
		newTeam_button.setText("Nuevo Equipo");
		
		CTabItem teamsList_tabItem = new CTabItem(teams_tabFolder, SWT.NONE);
		teamsList_tabItem.setText("ListaEquipo");
		
		Composite composite = new Composite(teams_tabFolder, SWT.NONE);
		teamsList_tabItem.setControl(composite);
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(0, 0, 520, 503);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("New Column");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("New Column");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("New Column");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("New Column");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(100);
		tblclmnNewColumn_4.setText("New Column");

	}
}
