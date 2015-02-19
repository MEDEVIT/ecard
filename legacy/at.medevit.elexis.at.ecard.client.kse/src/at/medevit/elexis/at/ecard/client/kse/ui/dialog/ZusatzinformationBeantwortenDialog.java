package at.medevit.elexis.at.ecard.client.kse.ui.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.kse.soap.Zusatzinformation;
import at.chipkarte.client.kse.soap.constants.ZusatzinformationsAntwort;
import at.chipkarte.client.kse.soap.exceptions.InvalidParameterException;
import at.chipkarte.client.kse.soap.exceptions.KseException;
import at.medevit.elexis.at.ecard.client.base.status.DialogStatus;
import at.medevit.elexis.at.ecard.client.kse.KseService;
import at.medevit.elexis.at.ecard.client.kse.helper.KonsultationsdatenLabelHelper;

public class ZusatzinformationBeantwortenDialog extends TitleAreaDialog {
	
	private Zusatzinformation m_zi;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	private ZusatzinformationBeantwortenDialog(Shell parentShell){
		super(parentShell);
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public ZusatzinformationBeantwortenDialog(Shell parentShell, Zusatzinformation zi){
		super(parentShell);
		m_zi = zi;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent){
		setMessage("Bitte um Stellungnahme");
		setTitle("Anfrage des Sozialversicherungsträgers "+KonsultationsdatenLabelHelper.versicherungstraegerCodeToLabel(Integer.parseInt(m_zi.getSvtCode())));
		setTitleImage(Display.getCurrent().getSystemImage(SWT.ICON_QUESTION));
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lblAnfrageId = new Label(container, SWT.NONE);
		lblAnfrageId.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblAnfrageId.setText("Anfrage ID");
		
		Label lblANFRAGEID = new Label(container, SWT.NONE);
		lblANFRAGEID.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblANFRAGEID.setText(m_zi.getZusatzinformationsAntwortId()+"");
		
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblINFORMATION = new Label(container, SWT.WRAP);
		lblINFORMATION.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 2, 1));
		
		lblINFORMATION.setText(m_zi.getZusatzinformationsText());
		
		return area;
	}
	
	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent){
		Button buttonNein = createButton(parent, IDialogConstants.NO_ID, IDialogConstants.OK_LABEL, true);
		buttonNein.setText("Nein");
		Button buttonJa = createButton(parent, IDialogConstants.YES_ID, IDialogConstants.CANCEL_LABEL, false);
		buttonJa.setText("Ja");
	}
	
	
	@Override
	protected void buttonPressed(int buttonId){
		setReturnCode(buttonId);
		boolean s = false;
		switch (buttonId) {
		case IDialogConstants.YES_ID:
			s = sendZusatzinformationsAntwort(ZusatzinformationsAntwort.JA);
			if(s) close();
			break;
		case IDialogConstants.NO_ID:
			s = sendZusatzinformationsAntwort(ZusatzinformationsAntwort.NEIN);
			if(s) close();
			break;
		default:
			break;
		}
	}
	
	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize(){
		return new Point(450, 300);
	}
	
	private boolean sendZusatzinformationsAntwort(int antwort) {
		boolean success = false;
		try {
			KseService.getInstance(null).sendZusatzinformationsAntwort(DialogStatus.getDialogId(), m_zi.getZusatzinformationsAntwortId(), antwort);
			success = true;
		} catch (InvalidParameterException e) {
			setErrorMessage(e.getMessage1());
		} catch (AccessException e) {
			setErrorMessage(e.getMessage1());
		} catch (KseException e) {
			setErrorMessage(e.getMessage1());
		} catch (DialogException e) {
			setErrorMessage(e.getMessage1());
		} catch (ServiceException e) {
			setErrorMessage(e.getMessage1());
		}
		return success;
	}
}
