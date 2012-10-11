package es.unican.psanchez.teaching.tallercan.presentationLayer.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;

public class MainTallercanWindow {

	protected Shell tallercanWindow_shlTallercan;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text text;
	private Text text_1;



	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		tallercanWindow_shlTallercan.open();
		tallercanWindow_shlTallercan.layout();
		while (!tallercanWindow_shlTallercan.isDisposed()) {
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
		tallercanWindow_shlTallercan = new Shell();
		tallercanWindow_shlTallercan.setSize(1295, 829);
		tallercanWindow_shlTallercan.setText("Tallercan 1.0");
		
		TabFolder tallercan_tabFolder = new TabFolder(tallercanWindow_shlTallercan, SWT.NONE);
		tallercan_tabFolder.setBounds(0, 0, 1287, 791);
		
		TabItem reparations_tabItem = new TabItem(tallercan_tabFolder, SWT.NONE);
		reparations_tabItem.setText("Reparations");
		
		TabItem tbtmNewItem = new TabItem(tallercan_tabFolder, SWT.NONE);
		tbtmNewItem.setText("Budget");
		
		TabItem tabItem = new TabItem(tallercan_tabFolder, SWT.NONE);
		tabItem.setText("New Item");
		
		TabItem employees_tabItem = new TabItem(tallercan_tabFolder, SWT.NONE);
		employees_tabItem.setText("Employees");
		
		TabFolder employees_tabFolder = new TabFolder(tallercan_tabFolder, SWT.NONE);
		employees_tabItem.setControl(employees_tabFolder);
		formToolkit.paintBordersFor(employees_tabFolder);
		
		TabItem newEmployee_tabItem = new TabItem(employees_tabFolder, SWT.NONE);
		newEmployee_tabItem.setText("NewEmployee");
		
		Composite composite = new Composite(employees_tabFolder, SWT.NO_BACKGROUND);
		newEmployee_tabItem.setControl(composite);
		formToolkit.paintBordersFor(composite);
		composite.setLayout(new GridLayout(3, false));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		CLabel name_label = new CLabel(composite, SWT.NONE);
		name_label.setEnabled(false);
		name_label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		GridData gd_name_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_name_label.widthHint = 104;
		name_label.setLayoutData(gd_name_label);
		formToolkit.adapt(name_label);
		formToolkit.paintBordersFor(name_label);
		name_label.setText("Name");
		
		text = new Text(composite, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text.widthHint = 513;
		text.setLayoutData(gd_text);
		formToolkit.adapt(text, true, true);
		new Label(composite, SWT.NONE);
		
		CLabel lblNewLabel = new CLabel(composite, SWT.NONE);
		GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel.widthHint = 104;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		formToolkit.adapt(lblNewLabel);
		formToolkit.paintBordersFor(lblNewLabel);
		lblNewLabel.setText("New Label");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		formToolkit.adapt(text_1, true, true);
		new Label(composite, SWT.NONE);
		
		CLabel lblNewLabel_1 = new CLabel(composite, SWT.NONE);
		GridData gd_lblNewLabel_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_1.widthHint = 104;
		lblNewLabel_1.setLayoutData(gd_lblNewLabel_1);
		formToolkit.adapt(lblNewLabel_1);
		formToolkit.paintBordersFor(lblNewLabel_1);
		lblNewLabel_1.setText("New Label");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		CLabel lblNewLabel_2 = new CLabel(composite, SWT.NONE);
		GridData gd_lblNewLabel_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_2.widthHint = 104;
		lblNewLabel_2.setLayoutData(gd_lblNewLabel_2);
		formToolkit.adapt(lblNewLabel_2);
		formToolkit.paintBordersFor(lblNewLabel_2);
		lblNewLabel_2.setText("New Label");
		new Label(composite, SWT.NONE);
		
		TabItem tbtmNewItem_3 = new TabItem(tallercan_tabFolder, SWT.NONE);
		tbtmNewItem_3.setText("New Item");
		
		TabItem tbtmNewItem_4 = new TabItem(tallercan_tabFolder, SWT.NONE);
		tbtmNewItem_4.setText("New Item");
		
		TabItem tabItem_1 = new TabItem(tallercan_tabFolder, SWT.NONE);
		tabItem_1.setText("New Item");

	}
}
