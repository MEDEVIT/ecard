package at.medevit.elexis.at.ecard.client.kse.ui.dialog;

import java.text.DecimalFormat;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.ResourceManager;

import ch.elexis.Hub;

import at.chipkarte.client.base.soap.BaseProperty;
import at.chipkarte.client.base.soap.Card;
import at.chipkarte.client.base.soap.SvtProperty;
import at.chipkarte.client.base.soap.constants.ServiceExceptionConstants;
import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.BCardException;
import at.chipkarte.client.base.soap.exceptions.CardException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.kse.soap.ErgebnisKonsultation;
import at.chipkarte.client.kse.soap.OfflineRecord;
import at.chipkarte.client.kse.soap.constants.KseExceptionConstants;
import at.chipkarte.client.kse.soap.exceptions.InvalidParameterException;
import at.chipkarte.client.kse.soap.exceptions.KseException;
import at.medevit.elexis.at.ecard.client.GINAConfigurationConstants;
import at.medevit.elexis.at.ecard.client.base.BaseService;
import at.medevit.elexis.at.ecard.client.base.status.CardReaderStatus;
import at.medevit.elexis.at.ecard.client.base.status.DialogStatus;
import at.medevit.elexis.at.ecard.client.base.status.GINAStatus;
import at.medevit.elexis.at.ecard.client.kse.KseService;
import at.medevit.elexis.at.ecard.client.kse.ui.dialog.provider.BasePropertyComboLabelProvider;
import at.medevit.elexis.at.ecard.client.kse.ui.dialog.provider.BasePropertyViewerComparator;
import at.medevit.elexis.at.ecard.client.kse.ui.dialog.provider.KonsultationsartLabelProvider;
import at.medevit.elexis.at.ecard.client.kse.ui.dialog.provider.SvtPropertyComboLabelProvider;

public class BehandlungsfallDurchfuehrenDialog extends TitleAreaDialog {
	
	public static final int BEHANDLUNGSFALL_OK_ONLINE = 333;
	public static final int BEHANDLUNGSFALL_OK_OFFLINE = 444;
	public static final int BEHANDLUNGSFALL_NOT_OK = 666;
	
	public static final String AUTOMATISCH_ERMITTELN = "Automatisch ermitteln";
	
	protected ErgebnisKonsultation m_ergebnisKonsultation = null;
	protected OfflineRecord m_offlineRecord = null;
	protected Card m_cardData = null;
	
	protected Button btnOk;
	protected ComboViewer comboViewerFachgebiet;
	protected ComboViewer comboViewerBehandlungsfall;
	protected ComboViewer comboViewerSVT;
	protected ComboViewer comboViewerKonsultationsart;
	protected DateTime dateTimeNacherfassung;
	
	protected String selectedFachgebietscode;
	protected String selectedBehandlungsfallCode;
	protected String selectedVersicherungstraegerCode = null;
	protected String selectedKonsultationsart = KonsultationsartLabelProvider.REGULAERE_KONSULTATION;
	protected String selectedBehandlungsDatum = null;
	protected String selectedSVNR = null;
	
	private BaseProperty[] behandlungsfaelleforSelectedFachgebiet;
	
	private boolean executeOk = false;
	
	public BehandlungsfallDurchfuehrenDialog(Shell parentShell){
		super(parentShell);
		setReturnCode(BEHANDLUNGSFALL_NOT_OK);
	}
	
	protected void init(){
		try {
			m_cardData = BaseService.getInstance(null).getCardData(null);
		} catch (CardException e) {
			setErrorMessage(e.getMessage1());
		}
		
		StringBuilder sb = new StringBuilder();
		if (GINAStatus.getGinaStatus() == GINAStatus.GINA_STATUS_OFFLINE)
			sb.append("[OFFLINE] ");
		sb.append("Patient: "+m_cardData.getNachname() + ", " + m_cardData.getVorname() + " ("
			+ m_cardData.getGeschlechtCode() + "), "+m_cardData.getNummer());
				
		int crs = CardReaderStatus.getStatus();
		switch (crs) {
		case CardReaderStatus.CARD_READER_CONTAINS_E_CARD:
			setTitle("Konsultation mit eCard");
			setMessage(sb.toString());
			break;
		case CardReaderStatus.CARD_READER_CONTAINS_O_CARD:
			setTitle("Konsultation mit oCard");
			break;
		case CardReaderStatus.CARD_READER_CONTAINS_SCHULUNGS_E_CARD:
			setTitle("Konsultation mit Schulungs-eCard");
			setMessage(sb.toString());
			break;
		case CardReaderStatus.CARD_READER_CONTAINS_B_CARD:
			setTitle("Konsultation mit Bürgerkarte");
			break;
		default:
			break;
		}
		
		setTitleImage(ResourceManager.getPluginImage("at.medevit.elexis.at.ecard.client.kse",
				"rsc/icons/konsultationTitle.png")); // TODO: Different icons? e-card, o-card
	}
	
	protected void addFachgebietComboSelector(Composite container){
		BaseProperty[] bp = DialogStatus.getFachgebieteByOrdId();
		// TODO: If there is only one in bp, shall we even bother to show it?
		
		Label lblFachgebiet = new Label(container, SWT.NONE);
		lblFachgebiet.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFachgebiet.setText("Fachgebiet");
		
		comboViewerFachgebiet = new ComboViewer(container, SWT.NONE);
		comboViewerFachgebiet.getCombo().setLayoutData(
			new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		comboViewerFachgebiet.setContentProvider(new ArrayContentProvider());
		comboViewerFachgebiet.setLabelProvider(new BasePropertyComboLabelProvider());
		comboViewerFachgebiet.setComparator(new BasePropertyViewerComparator());
		comboViewerFachgebiet.setInput(bp);

		comboViewerFachgebiet.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event){
				IStructuredSelection fachgebietSelection =
					(IStructuredSelection) comboViewerFachgebiet.getSelection();
				BaseProperty bp = (BaseProperty) fachgebietSelection.getFirstElement();
				selectedFachgebietscode = bp.getCode();
				try {
					setExecuteOk(false);
					behandlungsfaelleforSelectedFachgebiet =
						KseService.getInstance(null).getBehandlungsfaelleByFachgebiet(bp.getCode());
					comboViewerBehandlungsfall.setInput(behandlungsfaelleforSelectedFachgebiet);
					if (behandlungsfaelleforSelectedFachgebiet.length == 1) {
						comboViewerBehandlungsfall.setSelection(new StructuredSelection(behandlungsfaelleforSelectedFachgebiet[0]));
					}
					comboViewerBehandlungsfall.getCombo().setEnabled(true);
				} catch (ServiceException e) {
					setErrorMessage(e.getMessage1());
				}
			}
		});
	}
		
	protected void setFachgebietComboSelectorSelection(Composite container) {
		BaseProperty[] bp = (BaseProperty[]) comboViewerFachgebiet.getInput();
		if (bp.length == 1) {
			comboViewerFachgebiet.setSelection(new StructuredSelection(bp[0]));
		} else {
			String preSelectedFachgebiet = Hub.mandantCfg.get(GINAConfigurationConstants.CFG_MANDANT_PRE_SELECTED_FACHGEBIET, 
				GINAConfigurationConstants.NO_VALUE);
			if(!preSelectedFachgebiet.equalsIgnoreCase(GINAConfigurationConstants.NO_VALUE)) {
				for (BaseProperty baseProperty : bp) {
					if(Integer.parseInt(baseProperty.getCode()) == Integer.parseInt(preSelectedFachgebiet)) {
						comboViewerFachgebiet.setSelection(new StructuredSelection(baseProperty));
						continue;
					}
				}
			}
		}
	}

	
	protected void addBehandlungsfallComboSelector(Composite container){
		Label lblBehandlungsfall = new Label(container, SWT.NONE);
		lblBehandlungsfall.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblBehandlungsfall.setText("Behandlungsfall");
		
		comboViewerBehandlungsfall = new ComboViewer(container, SWT.NONE);
		comboViewerBehandlungsfall.getCombo().setLayoutData(
			new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		comboViewerBehandlungsfall.getCombo().setEnabled(false);
		comboViewerBehandlungsfall.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerBehandlungsfall.setLabelProvider(new BasePropertyComboLabelProvider());
		comboViewerBehandlungsfall.setComparator(new BasePropertyViewerComparator());
		comboViewerBehandlungsfall.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event){
				IStructuredSelection behandlungsfallSelection =
					(IStructuredSelection) event.getSelection();
				selectedBehandlungsfallCode =
					((BaseProperty) behandlungsfallSelection.getFirstElement()).getCode();
				setExecuteOk(true);
			}
		});
	}
	
	protected void setBehandlungsfallComboSelectorSelection(Composite container) {
		BaseProperty[] bf = (BaseProperty[]) comboViewerBehandlungsfall.getInput();
		if(bf==null) {
			System.out.println("still null");
			return;
		}
		if (bf.length == 1) {
			comboViewerBehandlungsfall.setSelection(new StructuredSelection(bf[0]));
		} else {
			String preSelectedBehandlungsfall = Hub.mandantCfg.get(GINAConfigurationConstants.CFG_MANDANT_PRE_SELECTED_BEHANDLUNGSFALL, 
				GINAConfigurationConstants.NO_VALUE);
			if(!preSelectedBehandlungsfall.equalsIgnoreCase(GINAConfigurationConstants.NO_VALUE)) {
				for (BaseProperty baseProperty : bf) {
					if(baseProperty.getCode().equalsIgnoreCase(preSelectedBehandlungsfall)) {
						comboViewerBehandlungsfall.setSelection(new StructuredSelection(baseProperty));
						continue;
					}
				}
			}
		}
	}
	
	protected void addVersicherungstraegerComboSelector(Composite container){
		Label lblSVT = new Label(container, SWT.NONE);
		lblSVT.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSVT.setText("Versicherungsträger");
		
		comboViewerSVT = new ComboViewer(container, SWT.NONE);
		comboViewerSVT.getCombo().setLayoutData(
			new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		comboViewerSVT.setContentProvider(new ArrayContentProvider());
		comboViewerSVT.setLabelProvider(new SvtPropertyComboLabelProvider());
		SvtProperty[] sp = GINAStatus.getCurrentSVTList();
		if (sp != null)
			comboViewerSVT.setInput(sp);
		comboViewerSVT.getCombo().setText(AUTOMATISCH_ERMITTELN);
		comboViewerSVT.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event){
				IStructuredSelection versicherungstraegerSelection =
					(IStructuredSelection) event.getSelection();
				selectedVersicherungstraegerCode =
					((SvtProperty) versicherungstraegerSelection.getFirstElement()).getCode();
			}
		});
	}
	
	protected void addKonsultationsartComboSelectorWithNacherfassungDateTime(Composite container){
		Label lblKonsultationsart = new Label(container, SWT.NONE);
		lblKonsultationsart.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblKonsultationsart.setAlignment(SWT.RIGHT);
		lblKonsultationsart.setText("Konsultationsart");
		
		comboViewerKonsultationsart = new ComboViewer(container, SWT.None);
		comboViewerKonsultationsart.getCombo().setLayoutData(
			new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		comboViewerKonsultationsart.setContentProvider(ArrayContentProvider.getInstance());
		KonsultationsartLabelProvider kA = new KonsultationsartLabelProvider();
		comboViewerKonsultationsart.setLabelProvider(kA);
		comboViewerKonsultationsart.setInput(KonsultationsartLabelProvider.values);
		comboViewerKonsultationsart.getCombo().setText(kA.getText(KonsultationsartLabelProvider.REGULAERE_KONSULTATION));
		comboViewerKonsultationsart.addSelectionChangedListener(new ISelectionChangedListener() {	
			@Override
			public void selectionChanged(SelectionChangedEvent event){
				IStructuredSelection konsultationsartSelection =
						(IStructuredSelection) event.getSelection();
				String konsultationsart = (String) konsultationsartSelection.getFirstElement();
				selectedKonsultationsart = konsultationsart;
				if(konsultationsart.equals(KonsultationsartLabelProvider.REGULAERE_KONSULTATION)) {
					dateTimeNacherfassung.setEnabled(false);
					selectedBehandlungsDatum = null;
				} else {
					dateTimeNacherfassung.setEnabled(true);
				}
			}
		});
		
		new Label(container, SWT.NONE);	
		Label lblDatumNacherfassung = new Label(container, SWT.NONE);
		lblDatumNacherfassung.setText("Datum für Nacherfassung");
		
		dateTimeNacherfassung =
			new DateTime(container, SWT.DATE | SWT.BORDER | SWT.DROP_DOWN | SWT.LONG);
		dateTimeNacherfassung.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
		dateTimeNacherfassung.setEnabled(false);
		dateTimeNacherfassung.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				DecimalFormat df = new DecimalFormat("00");
				selectedBehandlungsDatum =
						df.format(dateTimeNacherfassung.getDay()) + "." + df.format(dateTimeNacherfassung.getMonth()+1) + "."
							+ dateTimeNacherfassung.getYear();
			}
		});
	}
	
	@Override
	protected void okPressed(){
		System.out.println("SVT " + selectedVersicherungstraegerCode);
		System.out.println("Fachgebietscode " + selectedFachgebietscode);
		System.out.println("Behandlungsfallcode " + selectedBehandlungsfallCode);
	
		String nachErfGr = (selectedKonsultationsart.equals(KonsultationsartLabelProvider.REGULAERE_KONSULTATION)) ? null : selectedKonsultationsart;

		System.out.println("Konsultationsart " + nachErfGr);
		
		if(GINAStatus.getGinaStatus() == GINAStatus.GINA_STATUS_OFFLINE) {
			doKonsultationOffline(null, DialogStatus.getDialogId(), selectedSVNR, selectedVersicherungstraegerCode, selectedBehandlungsfallCode,
				selectedFachgebietscode, nachErfGr, selectedBehandlungsDatum, false, null);
		} else {
			try {
				m_ergebnisKonsultation =
					KseService.getInstance(null).doKonsultation(null, DialogStatus.getDialogId(), selectedSVNR,
						selectedVersicherungstraegerCode, null, selectedFachgebietscode, selectedBehandlungsfallCode, nachErfGr,
						selectedBehandlungsDatum, false, null);
				setReturnCode(BEHANDLUNGSFALL_OK_ONLINE);
				close();
			} catch (CardException e) {
				setErrorMessage(e.getMessage1());
			} catch (DialogException e) {
				setErrorMessage(e.getMessage1());
			} catch (KseException e) {
				if (e.getErrorCode() == KseExceptionConstants.OFFLINE_FRIST_EXCEEDED) {
//					offlineKonsultationsdatenUebertragen();
				}
				setErrorMessage(e.getMessage1());
				// TODO -> Need to react on certain Exceptions KseExceptionConstants
			} catch (BCardException e) {
				setErrorMessage(e.getMessage1());
			} catch (ServiceException e) {
				// TODO -> Meldung an den User das auf Offline gewechselt wird??
				if (e.getErrorCode() == ServiceExceptionConstants.CONNECTION_ERROR) {
					doKonsultationOffline(null, DialogStatus.getDialogId(), selectedSVNR, selectedVersicherungstraegerCode, selectedBehandlungsfallCode,
						selectedFachgebietscode, nachErfGr, selectedBehandlungsDatum, false, null);
				}
			} catch (AccessException e) {
				setErrorMessage(e.getMessage1());
			} catch (InvalidParameterException e) {
				setErrorMessage(e.getMessage1());
			}
		}
	}
	
	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent){
		Button btnCancel =
			createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		btnOk = createButton(parent, IDialogConstants.OK_ID, "Konsultation durchführen", true);
		btnOk.setEnabled(executeOk);
	}
	
	/**
	 * @return {@link ErgebnisKonsultation} if dialog return value is
	 *         {@link BehandlungsfallDurchfuehrenDialog#BEHANDLUNGSFALL_OK_ONLINE} else null
	 */
	public ErgebnisKonsultation getErgebnisKonsultation(){
		return m_ergebnisKonsultation;
	}
	
	/**
	 * @return {@link OfflineRecord} if dialog return value is
	 *         {@link BehandlungsfallDurchfuehrenDialog#BEHANDLUNGSFALL_OK_OFFLINE} else null
	 */
	public OfflineRecord getOfflineRecord(){
		return m_offlineRecord;
	}

	protected void doKonsultationOffline(String cin, String dialogId, String svNummer,
		String svtCode, String behandlungsfallCode, String fachgebietsCode,
		String nacherfassungsgrundCode, String behandlungsdatum, boolean forceExecution,
		String cardReaderId){
		
		try {
			m_offlineRecord =
				KseService.getInstance(null).doKonsultationOffline(cin, dialogId, svNummer,
					svtCode, fachgebietsCode, behandlungsfallCode, nacherfassungsgrundCode,
					behandlungsdatum, forceExecution, cardReaderId);
			System.out.println("Offline Record erstellt: "+m_offlineRecord.getErstellungsDatum());
			setReturnCode(BEHANDLUNGSFALL_OK_OFFLINE);
			close();
		} catch (InvalidParameterException e) {
			setErrorMessage(e.getMessage1());
		} catch (AccessException e) {
			setErrorMessage(e.getMessage1());
		} catch (CardException e) {
			setErrorMessage(e.getMessage1());
		} catch (KseException e) {
			setErrorMessage(e.getMessage1());
		} catch (ServiceException e) {
			setErrorMessage(e.getMessage1());
		} catch (DialogException e) {
			setErrorMessage(e.getMessage1());
		}
	}
	
	private void setExecuteOk(boolean ok) {
		executeOk = ok;
		if(btnOk != null) btnOk.setEnabled(executeOk);
	}
}
