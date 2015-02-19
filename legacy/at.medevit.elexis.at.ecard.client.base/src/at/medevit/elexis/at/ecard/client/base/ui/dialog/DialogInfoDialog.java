package at.medevit.elexis.at.ecard.client.base.ui.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

import at.chipkarte.client.base.soap.DialogsInfo;
import at.medevit.elexis.at.ecard.client.base.BaseService;
import at.medevit.elexis.at.ecard.client.base.command.DialogAufbauen;
import at.medevit.elexis.at.ecard.client.base.command.DialogSchliessen;
import at.medevit.elexis.at.ecard.client.base.status.DialogStatus;
import at.medevit.elexis.at.ecard.client.base.ui.dialog.provider.DialogInfoDialogVertragsDatenLabelProvider;

public class DialogInfoDialog extends TitleAreaDialog {
	private Table tableVertragsdaten;
	
	public DialogInfoDialog(Shell parentShell){
		super(parentShell);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected Control createDialogArea(Composite parent){
		setMessage("Informationen zum Dialog");
		setTitleImage(ResourceManager.getPluginImage("at.medevit.elexis.at.ecard.client.base",
			"rsc/icons/GINABoxTitle.png"));
		setTitle("Dialog Status");
		Composite ret = new Composite(parent, SWT.NONE);
		ret.setLayout(new GridLayout(3, false));
		ret.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		if (DialogStatus.dialogOpen()) {
			Label lblAdresse = new Label(ret, SWT.NONE);
			lblAdresse.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
			lblAdresse.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblAdresse.setText("Adresse:");
			
			Label lblADRESSE = new Label(ret, SWT.NONE);
			lblADRESSE.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, true, false, 2, 1));
			lblADRESSE.setText(DialogStatus.getOrdination().getStrasse() + ", "
				+ DialogStatus.getOrdination().getStadt());
			
			Label lblOrdinationsid = new Label(ret, SWT.NONE);
			lblOrdinationsid.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblOrdinationsid.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
			lblOrdinationsid.setText("Ordinations-Id:");
			
			Label lblORDINATIONSID = new Label(ret, SWT.NONE);
			lblORDINATIONSID.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1));
			lblORDINATIONSID.setText(DialogStatus.getOrdination().getOrdinationId());
			
			Label lblTaetigkeitsbereich = new Label(ret, SWT.NONE);
			lblTaetigkeitsbereich.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
			lblTaetigkeitsbereich.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblTaetigkeitsbereich.setText("Tätigkeitsbereich:");
			
			Label lblFACHBEREICH = new Label(ret, SWT.NONE);
			lblFACHBEREICH.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
			lblFACHBEREICH.setText(DialogStatus.getTaetigkeitsBereich().getAnzeigeText());
			
			Label lblSetupTime = new Label(ret, SWT.NONE);
			lblSetupTime.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
			lblSetupTime.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, false, 1, 1));
			lblSetupTime.setText("Dialog aufgebaut am:");
			
			Label lblDIALOGSETUPTIME = new Label(ret, SWT.NONE);
			lblDIALOGSETUPTIME.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
			// TODO replace deprecated method
			lblDIALOGSETUPTIME.setText(DialogStatus.getSetupTime().toLocaleString());
			
			Label lblServiceStatus = new Label(ret, SWT.NONE);
			lblServiceStatus.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
			lblServiceStatus.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, false, 1, 1));
			lblServiceStatus.setText("Service Status:");
			
			Label lblSERVICESTATUS = new Label(ret, SWT.NONE);
			lblSERVICESTATUS.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
			lblSERVICESTATUS.setText("TODO");
			
			Label lblNachrichtenStatus = new Label(ret, SWT.NONE);
			lblNachrichtenStatus.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
			lblNachrichtenStatus.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1,
				1));
			lblNachrichtenStatus.setText("Nachrichten Status:");
			
			Label lblNACHRICHTENSTATUS = new Label(ret, SWT.NONE);
			int noMessages = DialogStatus.getNoOfNewMessages();
			if (noMessages == 0) {
				lblNACHRICHTENSTATUS.setText("Keine neuen Nachrichten");
			} else {
				lblNACHRICHTENSTATUS.setText(noMessages + " neue Nachricht(en)");
			}
			new Label(ret, SWT.NONE);
			new Label(ret, SWT.NONE);
			
			Label lblSeparator1 = new Label(ret, SWT.NONE);
			lblSeparator1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
			
			Label lblVertragsdaten = new Label(ret, SWT.NONE);
			lblVertragsdaten.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
			lblVertragsdaten.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
			lblVertragsdaten.setText("Vertragsdaten:");
			new Label(ret, SWT.NONE);
			
			TableViewer tableViewerVertragsdaten =
				new TableViewer(ret, SWT.BORDER | SWT.FULL_SELECTION);
			tableVertragsdaten = tableViewerVertragsdaten.getTable();
			tableVertragsdaten.setHeaderVisible(true);
			GridData gd_tableVertragsdaten = new GridData(SWT.FILL, SWT.TOP, true, true, 3, 1);
			gd_tableVertragsdaten.heightHint = 100;
			tableVertragsdaten.setLayoutData(gd_tableVertragsdaten);
			
			TableViewerColumn tableViewerColumn =
				new TableViewerColumn(tableViewerVertragsdaten, SWT.NONE);
			TableColumn tblclmnBezugsbereich = tableViewerColumn.getColumn();
			tblclmnBezugsbereich.setToolTipText("Bezugsbereich des Vertrags");
			tblclmnBezugsbereich.setWidth(100);
			tblclmnBezugsbereich.setText("Bezugsbereich");
			
			TableViewerColumn tableViewerColumn_1 =
				new TableViewerColumn(tableViewerVertragsdaten, SWT.NONE);
			TableColumn tblclmnFachgebietscode = tableViewerColumn_1.getColumn();
			tblclmnFachgebietscode.setToolTipText("Fachgebietscode für den Vertrag");
			tblclmnFachgebietscode.setWidth(100);
			tblclmnFachgebietscode.setText("Fachgebietscode");
			
			TableViewerColumn tableViewerColumn_2 =
				new TableViewerColumn(tableViewerVertragsdaten, SWT.NONE);
			TableColumn tblclmnLeistungsSVT = tableViewerColumn_2.getColumn();
			tblclmnLeistungsSVT
				.setToolTipText("Code des leistungszuständigen Sozialversicherungsträgers für den Vertrag");
			tblclmnLeistungsSVT.setWidth(100);
			tblclmnLeistungsSVT.setText("Leistungs SVT");
			
			TableViewerColumn tableViewerColumn_3 =
				new TableViewerColumn(tableViewerVertragsdaten, SWT.NONE);
			TableColumn tblclmnOrdinationsId = tableViewerColumn_3.getColumn();
			tblclmnOrdinationsId
				.setToolTipText("Ordinations-Id derjenigen Ordination, an die der Vertrag gebunden ist.");
			tblclmnOrdinationsId.setWidth(100);
			tblclmnOrdinationsId.setText("Ordinations ID");
			
			TableViewerColumn tableViewerColumn_4 =
				new TableViewerColumn(tableViewerVertragsdaten, SWT.NONE);
			TableColumn tblclmnVerrechnungsSVT = tableViewerColumn_4.getColumn();
			tblclmnVerrechnungsSVT
				.setToolTipText("Code des verrechnungszuständigen Sozialversicherungsträgers für den Vertrag.");
			tblclmnVerrechnungsSVT.setWidth(100);
			tblclmnVerrechnungsSVT.setText("Verrechnungs SVT");
			
			TableViewerColumn tableViewerColumn_5 =
				new TableViewerColumn(tableViewerVertragsdaten, SWT.NONE);
			TableColumn tblclmnTaetigkeitsbereichId = tableViewerColumn_5.getColumn();
			tblclmnTaetigkeitsbereichId
				.setToolTipText("Kennzeichnung des Tätigkeitsbereichs, an den der Vertrag gebunden ist.");
			tblclmnTaetigkeitsbereichId.setWidth(100);
			tblclmnTaetigkeitsbereichId.setText("Tätigkeitsbereich ID");
			
			TableViewerColumn tableViewerColumn_6 =
				new TableViewerColumn(tableViewerVertragsdaten, SWT.NONE);
			TableColumn tblclmnVertragstyp = tableViewerColumn_6.getColumn();
			tblclmnVertragstyp.setToolTipText("Typ des Vertrags");
			tblclmnVertragstyp.setWidth(100);
			tblclmnVertragstyp.setText("Vertragstyp");
			tableViewerVertragsdaten
				.setLabelProvider(new DialogInfoDialogVertragsDatenLabelProvider());
			tableViewerVertragsdaten.setContentProvider(new ArrayContentProvider());
			tableViewerVertragsdaten.setInput(DialogStatus.getVertragsDatens());
			
			Label lblBerechtigungen = new Label(ret, SWT.NONE);
			lblBerechtigungen.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
			lblBerechtigungen.setText("Berechtigungen:");
			new Label(ret, SWT.NONE);
			new Label(ret, SWT.NONE);

			ListViewer listViewer = new ListViewer(ret, SWT.BORDER | SWT.V_SCROLL);
			List listBerechtigungen = listViewer.getList();
			GridData gd_listBerechtigungen = new GridData(SWT.FILL, SWT.TOP, true, false, 3, 1);
			gd_listBerechtigungen.heightHint = 100;
			listBerechtigungen.setLayoutData(gd_listBerechtigungen);
			new Label(ret, SWT.NONE);
			listViewer.setContentProvider(new ArrayContentProvider());
			listViewer.setLabelProvider(new LabelProvider());
			listViewer.setInput(DialogStatus.getBerechtigungen());
			// TODO If there is a message, provide a link to download and read, + info on icon!
			
		} else {
			Label lab = new Label(ret, SWT.None);
			GridData gd_lab = new GridData(SWT.FILL, SWT.TOP, true, false);
			gd_lab.horizontalSpan = 3;
			lab.setLayoutData(gd_lab);
			lab.setText("Es ist derzeit kein Dialog aufgebaut.");
			
			Label lblFreeDialogs = new Label(ret, SWT.NONE);
			lblFreeDialogs.setText("Anzahl der freien Dialoge: ");
			
			Label lblFREEDIALOGS = new Label(ret, SWT.NONE);
			lblFREEDIALOGS.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
			lblFREEDIALOGS.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
			
			DialogsInfo di = BaseService.getInstance(null).getFreeDialogs();
			if(di != null) {
				lblFREEDIALOGS.setText((di.getMaxDialogsCount()-di.getCurrentDialogsCount())+" von maximal "+di.getMaxDialogsCount());
			} else {
				lblFREEDIALOGS.setText("Information derzeit nicht verfügbar");
			}
		}
		
		return ret;
	}
	
	@Override
	protected void createButtonsForButtonBar(Composite parent){
		if (DialogStatus.dialogOpen()) {
			createButton(parent, IDialogConstants.CLOSE_ID, "Dialog schliessen", false);
		} else {
			createButton(parent, IDialogConstants.OPEN_ID, "Dialog aufbauen", false);
		}
		Button btnOk =
			createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		btnOk.setEnabled(true);
	}
	
	@Override
	protected void buttonPressed(int buttonId){
		switch (buttonId) {
		case IDialogConstants.OK_ID:
			super.okPressed();
			break;
		case IDialogConstants.OPEN_ID:
			close();
			{
				IHandlerService handlerService =
					(IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);
				try {
					handlerService.executeCommand(DialogAufbauen.ID, null);
				} catch (Exception e) {}
			}
			break;
		case IDialogConstants.CLOSE_ID:
			close();
			{
				IHandlerService handlerService =
					(IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);
				try {
					handlerService.executeCommand(DialogSchliessen.ID, null);
				} catch (Exception e) {}
			}
		default:
			break;
		}
	}
}
