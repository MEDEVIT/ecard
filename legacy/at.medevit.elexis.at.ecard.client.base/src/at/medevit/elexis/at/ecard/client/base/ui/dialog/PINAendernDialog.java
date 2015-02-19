package at.medevit.elexis.at.ecard.client.base.ui.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wb.swt.SWTResourceManager;

import at.chipkarte.client.base.soap.exceptions.CardException;
import at.medevit.elexis.at.ecard.client.base.BaseService;
import at.medevit.elexis.at.ecard.client.base.Activator;
import at.medevit.elexis.at.ecard.client.base.command.PINAendern;

public class PINAendernDialog extends TitleAreaDialog {
	private Text txtOLDPIN;
	private Text txtNEWPIN;
	private Text txtNEWPIN2;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public PINAendernDialog(Shell parentShell){
		super(parentShell);
	}
	
	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent){
		setMessage("Personal Identification Number der o-Card ändern");
		setTitle("Karten PIN ändern");
		setTitleImage(ResourceManager.getPluginImage("at.medevit.elexis.at.ecard.client.base", "rsc/icons/lanCCRTitle.png"));
		
		setHelpAvailable(true);
		setDialogHelpAvailable(true);
		PlatformUI.getWorkbench().getHelpSystem()
			.setHelp(parent, Activator.PLUGIN_ID+".PINAendern");
		
		
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(4, false));
		GridData gd_container = new GridData(GridData.FILL_BOTH);
		gd_container.verticalAlignment = SWT.CENTER;
		container.setLayoutData(gd_container);
		
		Label lblOldPin = new Label(container, SWT.NONE);
		lblOldPin.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.NORMAL));
		lblOldPin.setAlignment(SWT.RIGHT);
		lblOldPin.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		lblOldPin.setText("Derzeitige PIN");
		
		txtOLDPIN = new Text(container, SWT.BORDER);
		txtOLDPIN.setTextLimit(8);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblNewPin = new Label(container, SWT.NONE);
		lblNewPin.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.NORMAL));
		lblNewPin.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewPin.setText("Neue PIN");
		
		txtNEWPIN = new Text(container, SWT.BORDER);
		txtNEWPIN.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		txtNEWPIN.setTextLimit(8);
		
		Label lnlNewPin2 = new Label(container, SWT.NONE);
		lnlNewPin2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lnlNewPin2.setText("Neue PIN bestätigen");
		
		txtNEWPIN2 = new Text(container, SWT.BORDER);
		txtNEWPIN2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		txtNEWPIN2.setTextLimit(8);
		
		return area;
	}
	
	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent){
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}
	
	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize(){
		return new Point(450, 208);
	}
	
	@Override
	protected void okPressed(){		
		if(txtNEWPIN.getText().equals(txtNEWPIN2.getText())) {
			try {
				BaseService.getInstance(null).changePin(null, null, txtOLDPIN.getText(), txtNEWPIN.getText());
				super.okPressed();
			} catch (CardException e) {
				setErrorMessage(e.getMessage1());
			}
		} else {
			setErrorMessage("Die Eingaben für \"Neue PIN\" und \"Neue PIN bestätigen\" sind nicht ident.");
		}
	}
}
