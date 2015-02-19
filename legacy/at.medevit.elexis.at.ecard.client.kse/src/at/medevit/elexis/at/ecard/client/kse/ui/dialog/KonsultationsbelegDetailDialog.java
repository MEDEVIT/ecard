package at.medevit.elexis.at.ecard.client.kse.ui.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

import at.chipkarte.client.base.soap.BaseProperty;
import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.kse.soap.ErgebnisKonsultation;
import at.chipkarte.client.kse.soap.KonsultationsBeleg;
import at.chipkarte.client.kse.soap.Zusatzinformation;
import at.chipkarte.client.kse.soap.constants.KseMessage;
import at.chipkarte.client.kse.soap.constants.StatusKonsultation;
import at.chipkarte.client.kse.soap.exceptions.InvalidParameterException;
import at.chipkarte.client.kse.soap.exceptions.KseException;
import at.medevit.elexis.at.data.SVPerson;
import at.medevit.elexis.at.ecard.client.base.status.DialogStatus;
import at.medevit.elexis.at.ecard.client.base.tooltip.HTMLToolTip;
import at.medevit.elexis.at.ecard.client.kse.KseService;
import at.medevit.elexis.at.ecard.client.kse.helper.KonsultationsdatenHelper;
import at.medevit.elexis.at.ecard.client.kse.helper.KonsultationsdatenLabelHelper;
import at.medevit.elexis.at.ecard.client.kse.model.annotated.Konsultationsbeleg;
import at.medevit.elexis.at.ecard.client.kse.model.annotated.Konsultationsdaten;
import at.medevit.elexis.at.ecard.client.kse.ui.dialog.provider.BasePropertyComboLabelProvider;
import org.eclipse.jface.fieldassist.ControlDecoration;

public class KonsultationsbelegDetailDialog extends TitleAreaDialog {
	
	private Konsultationsdaten m_kd;
	private Konsultationsbeleg m_kb;
	private Label lblKONSULTATIONSID;
	private Label lblABRECHNUNGSPERIODE;
	private Label lblVERSICHERUNG;
	private Label lblVERSICHERTENKATEGORIE;
	private Label lblVERSICHERTENART;
	private Label lblGEBUEHRENBEFREIT;
	private Label lblKOSTENANTEILBEFREIT;
	private Label lblANSPRUCHSART;
	private Label lblBEARBEITUNGSDATUM;
	private Label lblBEHANDLUNGSDATUM;
	private Label lblKONSULTATIONSART;
	private Label lblSTATUS;
	private Label lblBEZUGSBEREICH;
	private Label lblBUNDESLAND;
	private Label lblFACHGEBIET;
	private Label lblBELEGVERSION;
	private Label lblVERSION;
	private Combo comboBEHANDLUNGSFALL;
	private Label lblLIMITPRUEFUNG;
	private Label lblREZEPTGEBUEHRENBEFREIT;
	private Label lblORDINATIONSNUMMER;
	private Label lblTRANSAKTIONSNUMMER;
	private ComboViewer comboViewerBEHANDLUNGSFALL;
	private boolean editMode = false;
	private Button buttonLocked;
	private Button buttonChangeState;

	public KonsultationsbelegDetailDialog(Shell parentShell, Konsultationsdaten kd){
		super(parentShell);
		m_kd = kd;
		m_kb = kd.getKonsultationsBeleg();
	}
	
	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent){
		setTitleImage(ResourceManager.getPluginImage("at.medevit.elexis.at.ecard.client.kse", "rsc/icons/konsultationTitle.png"));
		setTitle("Konsultationsbeleg");
		
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(4, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lblKonsultationsId = new Label(container, SWT.NONE);
		lblKonsultationsId.setToolTipText("Eindeutige Nummer der Konsultation");
		lblKonsultationsId.setText("Konsultations ID");
		
		lblKONSULTATIONSID = new Label(container, SWT.NONE);
		lblKONSULTATIONSID.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblKONSULTATIONSID.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		
		Label lblAbrechnungsperiode = new Label(container, SWT.NONE);
		lblAbrechnungsperiode.setToolTipText("Zeitperiode, in der die Abrechnung der Konsultation stattfindet.");
		lblAbrechnungsperiode.setText("Abrechnungsperiode");
		
		lblABRECHNUNGSPERIODE = new Label(container, SWT.NONE);
		lblABRECHNUNGSPERIODE.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblABRECHNUNGSPERIODE.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblBehandlungsfall = new Label(container, SWT.NONE);
		lblBehandlungsfall.setText("Behandlungsfall");

		comboViewerBEHANDLUNGSFALL = new ComboViewer(container, SWT.NONE);	
		comboBEHANDLUNGSFALL = comboViewerBEHANDLUNGSFALL.getCombo();
		comboBEHANDLUNGSFALL.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		comboBEHANDLUNGSFALL.setEnabled(editMode);
		comboViewerBEHANDLUNGSFALL.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerBEHANDLUNGSFALL.setLabelProvider(new BasePropertyComboLabelProvider());
		
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblVersichertenart = new Label(container, SWT.NONE);
		lblVersichertenart.setText("Versichertenart");
		
		lblVERSICHERTENART = new Label(container, SWT.NONE);
		lblVERSICHERTENART.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblVERSICHERTENART.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblVERSICHERTENART.setText("VERSICHERTENART");
				
		Label lblVersicherung = new Label(container, SWT.NONE);
		lblVersicherung.setText("Versicherung");
		
		lblVERSICHERUNG = new Label(container, SWT.NONE);
		lblVERSICHERUNG.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblVERSICHERUNG.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblKostenanteilbefreit = new Label(container, SWT.NONE);
		lblKostenanteilbefreit.setText("Kostenanteilbefreit");
		
		lblKOSTENANTEILBEFREIT = new Label(container, SWT.NONE);
		lblKOSTENANTEILBEFREIT.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblKOSTENANTEILBEFREIT.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblGebhrenbefreit = new Label(container, SWT.NONE);
		lblGebhrenbefreit.setText("Gebührenbefreit");
		
		lblGEBUEHRENBEFREIT = new Label(container, SWT.NONE);
		lblGEBUEHRENBEFREIT.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblGEBUEHRENBEFREIT.setText("GEBÜHRENBEFREIT");
		
		Label lblBearbeitungsdatum = new Label(container, SWT.NONE);
		lblBearbeitungsdatum.setToolTipText("Datum der zuletzt durchgeführten Änderung (Anlage, Änderung, Storno, Nachsignierung, Wiederinkraftsetzung)");
		lblBearbeitungsdatum.setText("Bearbeitungsdatum");
		
		lblBEARBEITUNGSDATUM = new Label(container, SWT.NONE);
		lblBEARBEITUNGSDATUM.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		
		Label lblBehandlungsdatum = new Label(container, SWT.NONE);
		lblBehandlungsdatum.setText("Behandlungsdatum");
		
		lblBEHANDLUNGSDATUM = new Label(container, SWT.NONE);
		lblBEHANDLUNGSDATUM.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblBEHANDLUNGSDATUM.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblKonsultationsart = new Label(container, SWT.NONE);
		lblKonsultationsart.setText("Konsultationsart");
		
		lblKONSULTATIONSART = new Label(container, SWT.NONE);
		lblKONSULTATIONSART.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblKONSULTATIONSART.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblStatus = new Label(container, SWT.NONE);
		lblStatus.setText("Status");
		
		lblSTATUS = new Label(container, SWT.WRAP);
		lblSTATUS.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblSTATUS.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblSTATUS.setToolTipText("Statuscode der Konsultation");
		
		Label lblBezugsbereich = new Label(container, SWT.NONE);
		lblBezugsbereich.setText("Bezugsbereich");
		
		lblBEZUGSBEREICH = new Label(container, SWT.NONE);
		lblBEZUGSBEREICH.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		
		Label lblBundesland = new Label(container, SWT.NONE);
		lblBundesland.setText("Bundesland");
		
		lblBUNDESLAND = new Label(container, SWT.NONE);
		lblBUNDESLAND.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		
		Label lblFachgebiet = new Label(container, SWT.NONE);
		lblFachgebiet.setText("Fachgebiet");
		
		lblFACHGEBIET = new Label(container, SWT.NONE);
		lblFACHGEBIET.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		
		Label lblAnspruchsart = new Label(container, SWT.NONE);
		lblAnspruchsart.setText("Anspruchsart");
		
		lblANSPRUCHSART = new Label(container, SWT.NONE);
		lblANSPRUCHSART.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblANSPRUCHSART.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		
		Label lblLimitprfung = new Label(container, SWT.NONE);
		lblLimitprfung.setText("Limitprüfung");
		
		lblLIMITPRUEFUNG = new Label(container, SWT.NONE);
		lblLIMITPRUEFUNG.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblVersichertenKategorie = new Label(container, SWT.NONE);
		lblVersichertenKategorie.setToolTipText("");
		lblVersichertenKategorie.setText("Versichertenkategorie");

		String lblVersTT = "<li style=\"text\" value=\"01\">Erwerbstätige, Arbeitslose, Selbstversicherte, Zivildiener, Asylanten, Flüchtlinge</li>" +
				"<li style=\"text\" value=\"05\">Pensionist, Ruhe und Versorgungsgenussbezieher</li>" +
				"<li style=\"text\" value=\"07\">Kriegshinterbliebener</li>" +
				"<li style=\"text\" value=\"20\">Zugeteilte nach OFG</li>" +
				"<li style=\"text\" value=\"22\">Zugeteilte nach KOVG, HVG</li>" +
				"<li style=\"text\" value=\"24\">Zugeteilte nach VOG</li>" +
				"<li style=\"text\" value=\"29\">Fremdstaaten (De-facto-Versicherte)</li>";
		new HTMLToolTip(lblVersichertenKategorie, lblVersTT);
		
		ControlDecoration controlDecoration = new ControlDecoration(lblVersichertenKategorie, SWT.RIGHT | SWT.TOP);
		
		lblVERSICHERTENKATEGORIE = new Label(container, SWT.NONE);
		lblVERSICHERTENKATEGORIE.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblVERSICHERTENKATEGORIE.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		Label lblRezeptgebhrenbefreit = new Label(container, SWT.NONE);
		lblRezeptgebhrenbefreit.setText("Rezeptgebührenbefreit");
		
		lblREZEPTGEBUEHRENBEFREIT = new Label(container, SWT.NONE);
		lblREZEPTGEBUEHRENBEFREIT.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblBelegversion = new Label(container, SWT.NONE);
		lblBelegversion.setToolTipText("Format-/Inhaltsversion des Konsultationsbelegs");
		lblBelegversion.setText("Belegversion");
		
		lblBELEGVERSION = new Label(container, SWT.NONE);
		lblBELEGVERSION.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		
		Label lblVersion = new Label(container, SWT.NONE);
		lblVersion.setToolTipText("Laufende Nummer der Konsultation, die pro Status Änderung (zum Beispiel: nachgebracht oder storniert) hinaufgezählt wird.");
		lblVersion.setText("Version");
		
		lblVERSION = new Label(container, SWT.NONE);
		lblVERSION.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		
		Label lblOrdinationsnummer = new Label(container, SWT.NONE);
		lblOrdinationsnummer.setToolTipText("Fortlaufende Ordinationsnummer aufgrund der Verträge des Vertragspartners");
		lblOrdinationsnummer.setText("Ordinationsnummer");
		
		lblORDINATIONSNUMMER = new Label(container, SWT.NONE);
		lblORDINATIONSNUMMER.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		
		Label lblTransaktionsnummer = new Label(container, SWT.NONE);
		lblTransaktionsnummer.setToolTipText("Eindeutige fortlaufende vertragspartnerspezifische Nummer für diese Version des Konsultationsbelegs");
		lblTransaktionsnummer.setText("Transaktionsnummer");
		
		lblTRANSAKTIONSNUMMER = new Label(container, SWT.NONE);
		lblTRANSAKTIONSNUMMER.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		
		init();
		
		comboViewerBEHANDLUNGSFALL.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event){
				StructuredSelection sel = (StructuredSelection) comboViewerBEHANDLUNGSFALL.getSelection();
				BaseProperty bfCode = (BaseProperty)sel.getFirstElement();
				
				boolean confirmed = MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
					"Behandlungsfall ändern", "Sind Sie sicher dass Sie den Behandlungsfall von "
				+m_kb.getBehandlungsfallCode()+" auf "+bfCode.getCode()+" ändern wollen?" );
				
				if(confirmed) {
					try {
						KonsultationsBeleg kb = KseService.getInstance(null).aendernKonsultation(DialogStatus.getDialogId(), m_kb.getId(), m_kb.getVersion(), bfCode.getCode());
						m_kb = KonsultationsdatenHelper.persistKonsultationsbeleg(kb, true);
						setMessage("Der Behandlungsfall wurde erfolgreich geändert.");
						refreshValues();
					} catch (DialogException e) {
						setErrorMessage(e.getMessage1());
					} catch (ServiceException e) {
						setErrorMessage(e.getMessage1());
					} catch (KseException e) {
						setErrorMessage(e.getMessage1());
					} catch (AccessException e) {
						setErrorMessage(e.getMessage1());
					} catch (InvalidParameterException e) {
						setErrorMessage(e.getMessage1());
					}
				}
				
			}
		});
		
		return area;
	}
	
	
	/**
	 * Die Werte des Dialogs initialisieren
	 */
	private void init(){
		try { // TODO: Caching? KSEstatus
			//TODO: Das sollte auch funktionieren, wenn keine Verbindung verfügbar ist!
			// getBehandlungsfaelleByFachgebiet local cachen
			
			BaseProperty[] bf = KseService.getInstance(null).getBehandlungsfaelleByFachgebiet(m_kb.getFachgebietsCode());
			if(bf!=null) {
				comboViewerBEHANDLUNGSFALL.setInput(bf);
			
				IStructuredSelection selected = null;
				for (BaseProperty baseProperty : bf) {
					String selCode = baseProperty.getCode();
					String currCode = m_kb.getBehandlungsfallCode();
				
					if(currCode.equalsIgnoreCase(selCode)) {
						selected = new StructuredSelection(baseProperty);
						continue;
					}
				}
			
				comboViewerBEHANDLUNGSFALL.setSelection(selected);
			} else {
				comboViewerBEHANDLUNGSFALL.getCombo().setText(m_kb.getBehandlungsfallCode());
			}
		} catch (ServiceException e) {
			setErrorMessage(e.getMessage1());
		}
		
		refreshValues();
	}
	
	private void refreshValues() {
		SVPerson p = SVPerson.findBySVNR(m_kb.getSvNummer());
		if(p!=null) {
			setMessage(KonsultationsdatenLabelHelper.konsultationsartToLabel(m_kb.getKonsultationsartCode())+": "
					+p.getVorname()+" "+p.getNachname()+" ("+p.getGeschlecht()+")");
		} else {
			setMessage(KonsultationsdatenLabelHelper.konsultationsartToLabel(m_kb.getKonsultationsartCode())+": "
					+"Person dem System nicht bekannt");
		}
		lblKONSULTATIONSID.setText(m_kb.getId()+"");
		lblABRECHNUNGSPERIODE.setText(KonsultationsdatenLabelHelper.abrechnungsPeriodeToLabel(m_kb.getAbrechnungsPeriode()));
		lblVERSICHERUNG.setText(KonsultationsdatenLabelHelper.versicherungstraegerCodeToLabel(Integer.parseInt(m_kb.getLeistungsSvtCode())));
		lblVERSICHERTENKATEGORIE.setText(m_kb.getVersichertenKategorie());
		lblVERSICHERTENART.setText(m_kb.getVersichertenartCode());
		lblGEBUEHRENBEFREIT.setText(KonsultationsdatenLabelHelper.booleanValueToLabel(m_kb.isRezeptgebbefreit()));
		lblKOSTENANTEILBEFREIT.setText(KonsultationsdatenLabelHelper.booleanValueToLabel(m_kb.isKostenanteilbefreit()));
		lblBEHANDLUNGSDATUM.setText(KonsultationsdatenLabelHelper.datumToLabel(m_kb.getBehandlungsDatum()));
		lblBEARBEITUNGSDATUM.setText(KonsultationsdatenLabelHelper.datumToLabel(m_kb.getBearbeitungsDatum()));
		lblKONSULTATIONSART.setText(m_kb.getKonsultationsartCode());
		lblSTATUS.setText(KonsultationsdatenLabelHelper.statusToLabel(m_kb.getStatus()));
		lblBEZUGSBEREICH.setText(m_kb.getBezugsBereich());
		lblBUNDESLAND.setText(KonsultationsdatenLabelHelper.bundeslandCodeToLabel(Integer.parseInt(m_kb.getBundeslandCode())));
		lblFACHGEBIET.setText(m_kb.getFachgebietsCode());
		lblBELEGVERSION.setText(m_kb.getBelegInhaltVersion()+"");
		lblVERSION.setText(m_kb.getVersion()+"");
		lblLIMITPRUEFUNG.setText(m_kb.getLeistungsrechtlichesLimitGeprueft());
		lblREZEPTGEBUEHRENBEFREIT.setText(KonsultationsdatenLabelHelper.booleanValueToLabel(m_kb.isRezeptgebbefreit()));
		lblORDINATIONSNUMMER.setText(m_kb.getOrdNummer()+"");
		lblTRANSAKTIONSNUMMER.setText(m_kb.getTxnNummer()+"");
		lblANSPRUCHSART.setText(KonsultationsdatenLabelHelper.anspruchsartToLabel(m_kb.getAnspruchsart()));
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent){
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);	
		buttonLocked = createButton(parent, IDialogConstants.NEXT_ID, "", false);	
		buttonChangeState = createButton(parent, IDialogConstants.STOP_ID, IDialogConstants.CANCEL_LABEL, false);
		buttonChangeState.setEnabled(editMode);
	
		setLocked();
		
		switch (Integer.parseInt(m_kb.getStatus())) {
		case StatusKonsultation.STORNIERT:
			buttonChangeState.setText("Reinstate");
			buttonChangeState.setData(new Integer(IDialogConstants.PROCEED_ID));
			break;
		default: 
			buttonChangeState.setText("Stornieren");
			buttonChangeState.setData(new Integer(IDialogConstants.STOP_ID));
			break;
		}
	}
	
	@Override
	protected void buttonPressed(int buttonId){
		super.buttonPressed(buttonId);
		
		switch (buttonId) {
		case IDialogConstants.NEXT_ID:
			String dialogId = DialogStatus.getDialogId();
			if(dialogId == null) {
				setErrorMessage("Es ist derzeit kein Dialog aufgebaut, die Konsultation kann " +
							"daher nicht bearbeitet werden. Bitte versuchen Sie es nach einem Dialogaufbau erneut.");
				return;
			}
			editMode = (!editMode);
			setLocked();
			return;
		case IDialogConstants.STOP_ID:
			try {
				KonsultationsBeleg kbIn = KseService.getInstance(null).stornierenKonsultation(DialogStatus.getDialogId(), m_kb.getId(), m_kb.getVersion());
				m_kb = KonsultationsdatenHelper.persistKonsultationsbeleg(kbIn, true);
				refreshValues();
			} catch (InvalidParameterException e) {
				setErrorMessage(e.getMessage1());
			} catch (AccessException e) {
				setErrorMessage(e.getMessage1());
			} catch (KseException e) {
				setErrorMessage(e.getMessage1());
			} catch (ServiceException e) {
				setErrorMessage(e.getMessage1());
			} catch (DialogException e) {
				setErrorMessage(e.getMessage1());
			}
			break;
		case IDialogConstants.PROCEED_ID:
			try {
				ErgebnisKonsultation kbIn = KseService.getInstance(null).wiederinkraftsetzenKonsultation(DialogStatus.getDialogId(), m_kb.getId(), m_kb.getVersion());
				Integer[] mc = kbIn.getKseMessageCodes();
				if(mc != null) for (int i = 0; i < mc.length; i++) {
					if (mc[i] == KseMessage.PATIENT_ZUSATZINFO) {
						Zusatzinformation zi = kbIn.getZusatzinformation();
						ZusatzinformationBeantwortenDialog zbd =
							new ZusatzinformationBeantwortenDialog(PlatformUI.getWorkbench()
								.getActiveWorkbenchWindow().getShell(), zi);
						int retValZBD = zbd.open();
					}
				}
				m_kd = KonsultationsdatenHelper.persistKonsultationsdaten(kbIn.getKonsultationsDaten(), true);
				m_kb = m_kd.getKonsultationsBeleg();
				refreshValues();
			} catch (InvalidParameterException e) {
				setErrorMessage(e.getMessage1());
			} catch (AccessException e) {
				setErrorMessage(e.getMessage1());
			} catch (KseException e) {
				setErrorMessage(e.getMessage1());
			} catch (ServiceException e) {
				setErrorMessage(e.getMessage1());
			} catch (DialogException e) {
				setErrorMessage(e.getMessage1());
			}
			break;
		default:
			break;
		}
	}
	
	private void setLocked() {
		if(!editMode) {
			buttonLocked.setImage(ResourceManager.getPluginImage("at.medevit.elexis.at.ecard.client.kse", "rsc/icons/object-locked-2.png"));
			comboBEHANDLUNGSFALL.setEnabled(false);
			buttonChangeState.setEnabled(false);
		} else {
			buttonLocked.setImage(ResourceManager.getPluginImage("at.medevit.elexis.at.ecard.client.kse", "rsc/icons/object-unlocked-2.png"));
			comboBEHANDLUNGSFALL.setEnabled(true);
			buttonChangeState.setEnabled(true);
		}
	}
	
}
