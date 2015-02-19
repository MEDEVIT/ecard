package at.medevit.elexis.at.ecard.client.base.ui.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import at.chipkarte.client.base.soap.Card;
import at.chipkarte.client.base.soap.Ordination;
import at.chipkarte.client.base.soap.TaetigkeitsBereich;
import at.chipkarte.client.base.soap.Vertragspartner;
import at.chipkarte.client.base.soap.exceptions.CardException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.medevit.elexis.at.ecard.client.base.BaseService;
import at.medevit.elexis.at.ecard.client.base.exceptionHandler.CardExceptionHandler;
import at.medevit.elexis.at.ecard.client.base.ui.dialog.provider.DialogAufbauenDialogOrdinationLabelProvider;
import at.medevit.elexis.at.ecard.client.base.ui.dialog.provider.DialogAufbauenDialogTaetigkeitsbereichLabelProvider;

public class DialogAufbauenDialog extends TitleAreaDialog {

	private String CIN;
	private Vertragspartner vp;
	private String dialogId;
	private Ordination ord;
	private String ordinationId;
	private TaetigkeitsBereich taetigkeitsBereich;
	private String taetigkeitsBereichId;
	private boolean userWantsToSeeDialogInfo;
	
	private Text textPIN;
	private Card oCard;
//	private Combo comboBehandlungsfall;
	private Combo comboOrdination;
	private Combo comboTaetigkeitsbereich;
	private Button btnOk;
	private ComboViewer comboViewerOrdination;
	private ComboViewer comboViewerTaetigkeitsbereich;
//	private ComboViewer comboViewerBehandlungsfall;
	private Button btnShowDialogInfo;
	
	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public DialogAufbauenDialog(Shell parentShell, String dialogId) {
		super(parentShell);

		try {
			oCard = BaseService.getInstance(null).getCardData(null);
			CIN = oCard.getCin();
		} catch (CardException e) {
			setErrorMessage(e.getMessage1());
			CardExceptionHandler.handle(e);
		}
		
		this.dialogId = dialogId;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("o-Card Anmeldung");
		setTitleImage(org.eclipse.wb.swt.ResourceManager.getPluginImage("at.medevit.elexis.at.ecard.client.base", "rsc/icons/oCardTitle.png"));
		setMessage(oCard.getTitel() + " " + oCard.getNachname() + " "
				+ oCard.getVorname() + ", " + oCard.getTitelHinten());

		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(3, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		Label lbloCard = new Label(container, SWT.WRAP);
		lbloCard.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				3, 1));
		lbloCard.setText("Bitte geben Sie Ihre PIN ein, und drücken Sie auf Abfragen.");

		Label lblNewLabel_1 = new Label(container, SWT.HORIZONTAL);
		lblNewLabel_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 3, 1));
		
		Label lblPIN = new Label(container, SWT.NONE);
		lblPIN.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		lblPIN.setText("PIN");

		textPIN = new Text(container, SWT.BORDER | SWT.PASSWORD);
		textPIN.addKeyListener(new KeyListener() {	
			@Override
			public void keyReleased(KeyEvent e){}
			
			@Override
			public void keyPressed(KeyEvent e){
				if(e.keyCode == 13 || e.keyCode == 16777296) {
					initializeAfterPinEntered();
				}
			}
		});
		
		Button btncheckPIN = new Button(container, SWT.NONE);
		btncheckPIN.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent ev) {
				initializeAfterPinEntered();
			}
		});
		btncheckPIN.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		btncheckPIN.setText("Abfragen");

		Label lblOrdination = new Label(container, SWT.NONE);
		lblOrdination.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblOrdination.setText("Ordination");

		comboViewerOrdination = new ComboViewer(container, SWT.NONE);
		comboViewerOrdination.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection ordSelection = (IStructuredSelection) comboViewerOrdination.getSelection();
				ord = (Ordination) ordSelection.getFirstElement();
				ordinationId = ord.getOrdinationId();
				TaetigkeitsBereich[] tb = ord.getTaetigkeitsBereich();
				comboViewerTaetigkeitsbereich.setInput(tb);
				comboViewerTaetigkeitsbereich.refresh();
				if(tb.length==1) {
					comboViewerTaetigkeitsbereich.setSelection(new StructuredSelection(tb[0]));
				}
				comboTaetigkeitsbereich.setEnabled(true);
			}
		});
		
		
		comboOrdination = comboViewerOrdination.getCombo();
		comboOrdination.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				2, 1));
		comboViewerOrdination.setContentProvider(new ArrayContentProvider());
		comboViewerOrdination.setLabelProvider(new DialogAufbauenDialogOrdinationLabelProvider());

		Label lblTtigkeitsbereich = new Label(container, SWT.NONE);
		lblTtigkeitsbereich.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		lblTtigkeitsbereich.setText("Tätigkeitsbereich");

		comboViewerTaetigkeitsbereich = new ComboViewer(container, SWT.NONE);
		comboViewerTaetigkeitsbereich.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection taetigkeitbereichSelection = (IStructuredSelection) comboViewerTaetigkeitsbereich.getSelection();
				taetigkeitsBereich = (TaetigkeitsBereich) taetigkeitbereichSelection.getFirstElement();
				taetigkeitsBereichId = taetigkeitsBereich.getId();
				btnOk.setEnabled(true);
			}
		});
		comboTaetigkeitsbereich = comboViewerTaetigkeitsbereich.getCombo();
		comboTaetigkeitsbereich.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				2, 1));
		comboViewerTaetigkeitsbereich.setContentProvider(new ArrayContentProvider());
		comboViewerTaetigkeitsbereich.setLabelProvider(new DialogAufbauenDialogTaetigkeitsbereichLabelProvider());

		// TODO: Auslagern in Preferences
//		Label lblStandardBehandlungsfall = new Label(container, SWT.NONE);
//		lblStandardBehandlungsfall.setLayoutData(new GridData(SWT.RIGHT,
//				SWT.CENTER, false, false, 1, 1));
//		lblStandardBehandlungsfall.setText("Standard Behandlungsfall");
//
//		comboViewerBehandlungsfall = new ComboViewer(container, SWT.NONE);
//		comboBehandlungsfall = comboViewerBehandlungsfall.getCombo();
//		comboBehandlungsfall.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2,
//				1));
//		comboViewerBehandlungsfall.setContentProvider(new ArrayContentProvider());
//		comboBehandlungsfall.setEnabled(false);
		
		
		// TODO: Selektion des Fachgebietes
		
		comboOrdination.setEnabled(false);
		comboTaetigkeitsbereich.setEnabled(false);
		new Label(container, SWT.NONE);
		
		// TODO: Init by stored selection
		btnShowDialogInfo = new Button(container, SWT.CHECK);
		btnShowDialogInfo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		btnShowDialogInfo.setText("Nach Anmeldung Dialoginformationen anzeigen");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		return area;
	}

	private void initializeAfterPinEntered() {
		// TODO: Show busy cursor while executing
		try {
			vp = BaseService.getInstance(null).authenticateDialog(dialogId, CIN, textPIN.getText().trim(), null);
			// TODO remove
			System.out.println("dialogID: "+dialogId);
			
			Ordination[] ord = vp.getOrdination();			
			comboViewerOrdination.setInput(ord);
			comboViewerOrdination.refresh();
			if (ord.length == 1) {
				comboViewerOrdination.setSelection(new StructuredSelection(
						ord[0]));
			}
			comboOrdination.setEnabled(true);
		} catch (CardException e) {
			setErrorMessage(e.getMessage1());
		} catch (DialogException e) {
			setErrorMessage(e.getMessage1());
		}
	}
	
	@Override
	protected void okPressed(){
		userWantsToSeeDialogInfo = btnShowDialogInfo.getSelection();
		super.okPressed();
	}
	
	
	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button btnCancel = createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		btnOk = createButton(parent, IDialogConstants.OK_ID,
				IDialogConstants.OK_LABEL, true);
		btnOk.setEnabled(false);
	}

	
	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
	
	public Ordination getSelectedOrdination(){
		return ord;
	}
	
	public TaetigkeitsBereich getSelectedTaetigkeitsBereich(){
		return taetigkeitsBereich;
	}

	public Vertragspartner getVertragspartner() {
		return vp;
	}

	public Ordination getOrdination(){
		return ord;
	}
	
	/**
	 * Does the user want to see the dialog information after registration of the dialog?
	 * @return
	 */
	public boolean getUserWantsToSeeDialogInfo() {
		return userWantsToSeeDialogInfo;
	}
}
