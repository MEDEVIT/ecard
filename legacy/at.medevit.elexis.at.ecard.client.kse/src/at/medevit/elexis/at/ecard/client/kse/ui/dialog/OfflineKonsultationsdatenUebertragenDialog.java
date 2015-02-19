package at.medevit.elexis.at.ecard.client.kse.ui.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wb.swt.ResourceManager;

import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.kse.soap.ErgebnisKonsultation;
import at.chipkarte.client.kse.soap.KonsultationsBeleg;
import at.chipkarte.client.kse.soap.OfflineKonsultation;
import at.chipkarte.client.kse.soap.OfflineRecord;
import at.chipkarte.client.kse.soap.constants.OfflineRecordType;
import at.chipkarte.client.kse.soap.exceptions.InvalidParameterException;
import at.chipkarte.client.kse.soap.exceptions.KseException;
import at.medevit.elexis.at.ecard.client.base.status.DialogStatus;
import at.medevit.elexis.at.ecard.client.kse.KseService;
import at.medevit.elexis.at.ecard.client.kse.helper.ErgebnisKonsultationHelper;
import at.medevit.elexis.at.ecard.client.kse.helper.KonsultationsdatenHelper;
import at.medevit.elexis.at.ecard.client.kse.status.KseStatus;
import at.medevit.elexis.at.ecard.client.kse.ui.dialog.provider.OfflineKonsultationsdatenUebertragenLabelProvider;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;

public class OfflineKonsultationsdatenUebertragenDialog extends TitleAreaDialog {
	private TableViewer tableViewerOfflineRecords;
	private Menu popupMenu;
	private MenuItem task;
	private OfflineRecord selectedOfflineRecord;
	
	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public OfflineKonsultationsdatenUebertragenDialog(Shell parentShell){
		super(parentShell);
	}
	
	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent){
		setTitleImage(ResourceManager.getPluginImage("at.medevit.elexis.at.ecard.client.kse",
			"rsc/icons/konsultationTitle.png"));
		setTitle("Offline Datensätze übertragen");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite.setBounds(0, 0, 64, 64);
		TableColumnLayout tcl_composite = new TableColumnLayout();
		composite.setLayout(tcl_composite);
		
		tableViewerOfflineRecords = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewerOfflineRecords.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event){
				selectedOfflineRecord =
					(OfflineRecord) ((StructuredSelection) event.getSelection()).getFirstElement();
				// TODO: NPE wenn liste leer
				if (selectedOfflineRecord.getType() == OfflineRecordType.KONSULTATION) {
					task.setEnabled(true);
					task.setText("Offline Konsultation senden");
				} else if (selectedOfflineRecord.getType() == OfflineRecordType.NACHSIGNATUR) {
					task.setEnabled(true);
					task.setText("Nachsignierungsanfrage senden");
				} else if (selectedOfflineRecord == null) {
					task.setEnabled(false);
				}
			}
		});
		Table tableOfflineRecords = tableViewerOfflineRecords.getTable();
		tableOfflineRecords.setHeaderVisible(true);
		tableOfflineRecords.setLinesVisible(true);
		
		TableViewerColumn tableViewerColumn =
			new TableViewerColumn(tableViewerOfflineRecords, SWT.NONE);
		TableColumn tblclmnErstellungsdatum = tableViewerColumn.getColumn();
		tcl_composite.setColumnData(tblclmnErstellungsdatum, new ColumnWeightData(15, 80, true));
		tblclmnErstellungsdatum.setText("Erstellungsdatum");
		
		TableViewerColumn tableViewerColumn_1 =
			new TableViewerColumn(tableViewerOfflineRecords, SWT.NONE);
		TableColumn tblclmnOfflinefrist = tableViewerColumn_1.getColumn();
		tcl_composite.setColumnData(tblclmnOfflinefrist, new ColumnWeightData(15, 80, true));
		tblclmnOfflinefrist.setText("Offline-Frist");
		
		TableViewerColumn tableViewerColumn_2 =
			new TableViewerColumn(tableViewerOfflineRecords, SWT.NONE);
		TableColumn tblclmnPerson = tableViewerColumn_2.getColumn();
		tcl_composite.setColumnData(tblclmnPerson, new ColumnWeightData(35,
			ColumnWeightData.MINIMUM_WIDTH, true));
		tblclmnPerson.setText("Person");
		
		TableViewerColumn tableViewerColumn_3 =
			new TableViewerColumn(tableViewerOfflineRecords, SWT.NONE);
		TableColumn tblclmnId = tableViewerColumn_3.getColumn();
		tcl_composite.setColumnData(tblclmnId, new ColumnWeightData(15,
			ColumnWeightData.MINIMUM_WIDTH, true));
		tblclmnId.setText("Id");
		
		TableViewerColumn tableViewerColumn_4 =
			new TableViewerColumn(tableViewerOfflineRecords, SWT.NONE);
		TableColumn tblclmnTyp = tableViewerColumn_4.getColumn();
		tcl_composite.setColumnData(tblclmnTyp, new ColumnWeightData(20,
			ColumnWeightData.MINIMUM_WIDTH, true));
		tblclmnTyp.setText("Typ");
		
		popupMenu = new Menu(tableOfflineRecords);
		task = new MenuItem(popupMenu, SWT.PUSH);
		task.setEnabled(false);
		task.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				switch (selectedOfflineRecord.getType()) {
				case OfflineRecordType.KONSULTATION:
					offlineKonsultationSenden();
					break;
				case OfflineRecordType.NACHSIGNATUR:
					nachsignierungsAnfrageSenden();
					break;
				default:
					break;
				}
			}
		});
		tableOfflineRecords.setMenu(popupMenu);
		
		tableViewerOfflineRecords.setContentProvider(ArrayContentProvider.getInstance());
		tableViewerOfflineRecords
			.setLabelProvider(new OfflineKonsultationsdatenUebertragenLabelProvider());
		
		init();
		
		return area;
	}
	
	private void init(){
		try {
			OfflineRecord[] or =
				KseService.getInstance(null).getOfflineRecords(DialogStatus.getDialogId());
			tableViewerOfflineRecords.setInput(or);
		} catch (DialogException e) {
			setErrorMessage(e.getMessage1());
		} catch (ServiceException e) {
			setErrorMessage(e.getMessage1());
		} catch (KseException e) {
			setErrorMessage(e.getMessage1());
		} catch (AccessException e) {
			setErrorMessage(e.getMessage1());
		}
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
	
	private void offlineKonsultationSenden(){
		OfflineKonsultation ok = selectedOfflineRecord.getOfflineKonsultation();
		try {
			ErgebnisKonsultation ek =
				KseService.getInstance(null).sendOfflineKonsultation(DialogStatus.getDialogId(),
					selectedOfflineRecord.getId(), ok.getFachgebietsCode(),
					ok.getBehandlunsfallCode(), ok.getSvtCode(), null);
			ErgebnisKonsultationHelper.handleIncomingErgebnisKonsultation(ek);
			selectedOfflineRecord = null;
			KseStatus.getInstance().updateStatus();
			init();
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
	
	private void nachsignierungsAnfrageSenden(){
		try {
			KonsultationsBeleg[] kb =
				KseService.getInstance(null).sendOfflineNachsignatur(DialogStatus.getDialogId(),
					selectedOfflineRecord.getId());
			for (int i = 0; i < kb.length; i++) {
				KonsultationsdatenHelper.persistKonsultationsbeleg(kb[i], true);
			}
			selectedOfflineRecord = null;
			KseStatus.getInstance().updateStatus();
			init();
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
