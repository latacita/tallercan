package es.unican.psanchez.teaching.sportTeamsManagement.presentationLayer.swt.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class ApplicationWindow {

	protected Shell mainWindow;

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
		mainWindow.setSize(742,576);
		mainWindow.setText("Gesti\u00F3n de Competiciones Deportivos");
		
		CTabFolder mainTabFolder = new CTabFolder(mainWindow, SWT.BORDER);
		mainTabFolder.setBounds(0,0,734,549);
		mainTabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem teams_tabItem = new CTabItem(mainTabFolder, SWT.NONE);
		teams_tabItem.setText("Equipos");
		
		Composite teams_composite = new Composite(mainTabFolder, SWT.NONE);
		teams_tabItem.setControl(teams_composite);
		
		CTabFolder teams_tabFolder = new CTabFolder(teams_composite, SWT.BORDER);
		teams_tabFolder.setBounds(0,0,728,526);
		teams_tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem newTeam_tabItem = new CTabItem(teams_tabFolder, SWT.NONE);
		newTeam_tabItem.setText("NuevoEquipo");
		
		NewTeamForm newTeamForm = new NewTeamForm(teams_tabFolder, SWT.NONE);
		newTeam_tabItem.setControl(newTeamForm);
		
		CTabItem teamsList_tabItem = new CTabItem(teams_tabFolder, SWT.NONE);
		teamsList_tabItem.setText("ListaEquipo");
		
		CTabItem sports_tabItem = new CTabItem(mainTabFolder, SWT.NONE);
		sports_tabItem.setText("Deportes");
		
		CTabFolder sports_tabFolder = new CTabFolder(mainTabFolder, SWT.BORDER);
		sports_tabItem.setControl(sports_tabFolder);
		sports_tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem newSport_tabItem = new CTabItem(sports_tabFolder, SWT.NONE);
		newSport_tabItem.setText("NuevoDeporte");
		
		NewSportForm newSportForm = new NewSportForm(sports_tabFolder, SWT.NONE);
		newSport_tabItem.setControl(newSportForm);
		
		CTabItem listaDeportes_tabItem = new CTabItem(sports_tabFolder, SWT.NONE);
		listaDeportes_tabItem.setText("ListaDeportes");
		
		SportListForm sportListForm = new SportListForm(sports_tabFolder, SWT.NONE);
		listaDeportes_tabItem.setControl(sportListForm);
		
	}
}
