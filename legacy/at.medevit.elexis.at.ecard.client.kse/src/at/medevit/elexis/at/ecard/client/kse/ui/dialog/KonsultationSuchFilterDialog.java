package at.medevit.elexis.at.ecard.client.kse.ui.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import at.chipkarte.client.kse.soap.SuchFilter;
import at.chipkarte.client.kse.soap.constants.Selektionsart;
import at.medevit.elexis.at.ecard.client.base.status.DialogStatus;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.ResourceManager;

// TODO: Finish SuchFilter selektion in  okPressed
public class KonsultationSuchFilterDialog extends TitleAreaDialog {
	private Text txtSVNR;
	private Text txtBEHANDLUNGSFALLCODE;
	private Text txtFACHGEBIETSCODE;
	private Text txtKONSULTATIONSARTCODE;
	private Text txtORDINATIONSID;
	private Text txtSVTCODE;
	private String m_errorMessage = null;
	
	private ComboViewer comboViewerSelektionsart;
	private Combo comboSelektionsart;
	
	private SuchFilter sf;
	private Selektionsart selectedSA;
	private Button btnUSESVNR, btnUSEBEHANDLUNGSFALLCODE;
	
	private boolean m_showSelektionsartSelection;
	
	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @wbp.parser.constructor
	 */
	public KonsultationSuchFilterDialog(Shell parentShell){
		super(parentShell);
		m_showSelektionsartSelection = true;
	}
	
	public KonsultationSuchFilterDialog(Shell parentShell, String errorMessage){
		super(parentShell);
		m_errorMessage = errorMessage;
		m_showSelektionsartSelection = true;
	}
	
	public KonsultationSuchFilterDialog(Shell parentShell, boolean showSelektionsartSelection){
		super(parentShell);
		m_showSelektionsartSelection = showSelektionsartSelection;
	}
	
	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent){
		setMessage("Bitte definieren Sie die Suchparameter");
		setTitleImage(ResourceManager.getPluginImage("at.medevit.elexis.at.ecard.client.kse", "rsc/icons/konsultationTitleSearch.png"));
		setTitle("Such-Filter Konsultationsdaten");
		if (m_errorMessage != null)
			setErrorMessage(m_errorMessage);
		
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(5, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		if (m_showSelektionsartSelection) {
			Label lblSelektionsart = new Label(container, SWT.NONE);
			lblSelektionsart.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblSelektionsart.setText("Selektionsart");
			
			comboViewerSelektionsart = new ComboViewer(container, SWT.NONE);
			comboSelektionsart = comboViewerSelektionsart.getCombo();
			comboSelektionsart.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
			comboViewerSelektionsart.setContentProvider(ArrayContentProvider.getInstance());
			Selektionsart[] sa = new Selektionsart[] {
				Selektionsart.ALLE_, Selektionsart.MODIFIZIERBAR_, Selektionsart.STORNIERT_
			};
			comboViewerSelektionsart.setInput(sa);
			comboViewerSelektionsart.setSelection(new StructuredSelection(sa[0]));
			selectedSA = sa[0];
			comboViewerSelektionsart.addSelectionChangedListener(new ISelectionChangedListener() {
				@Override
				public void selectionChanged(SelectionChangedEvent event){
					IStructuredSelection selection = (IStructuredSelection) event.getSelection();
					selectedSA = (Selektionsart) selection.getFirstElement();
					// TODO If selektionsart ALLE deactivate SVNR
					// Selektionsart, weitere infos
				}
			});
			new Label(container, SWT.NONE);
		}
		
		Label lblSvnr = new Label(container, SWT.NONE);
		lblSvnr.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSvnr.setText("SVNR");
		
		txtSVNR = new Text(container, SWT.BORDER);
		txtSVNR.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
		btnUSESVNR = new Button(container, SWT.CHECK);
		
		Label lblBehandlungsfallcode = new Label(container, SWT.NONE);
		lblBehandlungsfallcode
			.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblBehandlungsfallcode.setText("Behandlungsfallcode");
		
		txtBEHANDLUNGSFALLCODE = new Text(container, SWT.BORDER);
		txtBEHANDLUNGSFALLCODE.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
		btnUSEBEHANDLUNGSFALLCODE = new Button(container, SWT.CHECK);
		
		Label lblVon = new Label(container, SWT.NONE);
		lblVon.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblVon.setText("von");
		
		DateTime dateTimeVON = new DateTime(container, SWT.BORDER);
		
		Label lblBis = new Label(container, SWT.NONE);
		lblBis.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblBis.setText("bis");
		
		DateTime dateTimeBIS = new DateTime(container, SWT.BORDER);
		dateTimeBIS.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Button btnUSEDATE = new Button(container, SWT.CHECK);
		
		Label lblFachgebietscode = new Label(container, SWT.NONE);
		lblFachgebietscode.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFachgebietscode.setText("Fachgebietscode");
		
		txtFACHGEBIETSCODE = new Text(container, SWT.BORDER);
		txtFACHGEBIETSCODE.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		
		Button btnUSEFACHGEBIETSCODE = new Button(container, SWT.CHECK);
		
		Label lblKonsultationsartcode = new Label(container, SWT.NONE);
		lblKonsultationsartcode.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1,
			1));
		lblKonsultationsartcode.setText("Konsultationsartcode");
		
		txtKONSULTATIONSARTCODE = new Text(container, SWT.BORDER);
		txtKONSULTATIONSARTCODE
			.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
		Button btnUSEKONSULTATIONSART = new Button(container, SWT.CHECK);
		
		Label lblOrdinationsId = new Label(container, SWT.NONE);
		lblOrdinationsId.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblOrdinationsId.setText("Ordinations ID");
		
		txtORDINATIONSID = new Text(container, SWT.BORDER);
		txtORDINATIONSID.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
		Button btnUSEORDINATIONSID = new Button(container, SWT.CHECK);
		
		Label lblSvtCode = new Label(container, SWT.NONE);
		lblSvtCode.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSvtCode.setText("SVT Code");
		
		txtSVTCODE = new Text(container, SWT.BORDER);
		txtSVTCODE.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
		txtORDINATIONSID.setText(DialogStatus.getOrdination().getOrdinationId());
		
		Button btnUSESVTCODE = new Button(container, SWT.CHECK);
		
		return area;
	}
	
	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent){
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}
	
	@Override
	protected void okPressed(){
		String svnr = (btnUSESVNR.getSelection()) ? txtSVNR.getText().trim() : "";
		sf =
			new SuchFilter(svnr, txtBEHANDLUNGSFALLCODE.getText().trim(), null, null,
				txtFACHGEBIETSCODE.getText().trim(), txtKONSULTATIONSARTCODE.getText().trim(),
				txtORDINATIONSID.getText().trim(), null);
		
		super.okPressed();
	}
	
	/**
	 * @return Der Name der ausgewählten {@link Selektionsart}
	 */
	public String getSelektionsart(){
		return selectedSA.getName();
	}
	
	public SuchFilter getSelektionskriterien(){
		return sf;
	}
	
}
