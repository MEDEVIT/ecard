package at.medevit.elexis.at.ecard.client.base.ui.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import at.medevit.elexis.at.ecard.client.base.status.GINAStatus;
import at.medevit.elexis.at.ecard.client.base.ui.dialog.provider.GINAStatusDialogServiceStatusInformationLabelProvider;

import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;

public class GINAStatusDialog extends TitleAreaDialog {
	private Table tableStatusInformationen;
	
	public GINAStatusDialog(Shell parentShell){
		super(parentShell);
	}
	
	@Override
	protected Control createDialogArea(Composite parent){
		setMessage("Informationen zum Status der GINA Box");
		setTitleImage(ResourceManager.getPluginImage("at.medevit.elexis.at.ecard.client.base", "rsc/icons/GINABoxTitle.png"));
		setTitle("GINA Box Status");
		Composite ret = new Composite(parent, SWT.NONE);
		ret.setLayout(new GridLayout(2, false));
		ret.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		int ginaStatus = GINAStatus.getGinaStatus();
		
		if(ginaStatus == GINAStatus.GINA_STATUS_CURRENTLY_UPDATING) {
			Label lab = new Label(ret, SWT.None);
			lab.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));
			lab.setText("Status wird derzeit aktualisiert, bitte versuchen Sie es später erneut.");
			return ret;
		}  
		if(ginaStatus == GINAStatus.GINA_STATUS_NO_CONNECTION_TO_GINA) {
			setErrorMessage("Verbindung zur GINA Box kann nicht hergestellt werden");
			
			Label lab = new Label(ret, SWT.None);
			lab.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1));
			lab.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
			lab.setText("Grund:");
			
			Exception e = GINAStatus.getRemoteExceptionInformation();
			if(e != null) {
				Label ex = new Label(ret, SWT.None);
				ex.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 2, 1));
				ex.setText(e.toString());
			}
			
			// TODO: Retry Button?
			return ret;
		}
		if(GINAStatus.getGinaStatus() == GINAStatus.GINA_STATUS_CONNECTION_NOT_CONFIGURED) {
			setErrorMessage("Verbindung zur GINA Box wurde noch nicht konfiguriert.");
			
			Label lab = new Label(ret, SWT.None);
			lab.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));
			lab.setText("Bitte konfigurieren Sie die GINA Verbindung");
			return ret;
		}
		
		Label lblGinaIp = new Label(ret, SWT.NONE);
		lblGinaIp.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblGinaIp.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, false, 1, 1));
		lblGinaIp.setText("IP Addresse");
		
		Label lblGINAIP = new Label(ret, SWT.NONE);
		lblGINAIP.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblGINAIP.setText(GINAStatus.getStatusInformationen().getGinaInfo().getIpAdresse());
		
		Label lblLblginadnsname = new Label(ret, SWT.NONE);
		lblLblginadnsname.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblLblginadnsname.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLblginadnsname.setText("DNS Name");
		
		Label lblDNSNAME = new Label(ret, SWT.NONE);
		lblDNSNAME.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblDNSNAME.setText(GINAStatus.getStatusInformationen().getGinaInfo().getDnsName());
		
		Label lblNewLabel = new Label(ret, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblNewLabel.setText("Produkt Version");
		
		Label lblPRODUKTVERSION = new Label(ret, SWT.NONE);
		lblPRODUKTVERSION.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblPRODUKTVERSION.setText(GINAStatus.getStatusInformationen().getGinaInfo().getProduktVersion());
		
		Label label = new Label(ret, SWT.NONE);
		label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		
		Label lblStatusinformationen = new Label(ret, SWT.NONE);
		lblStatusinformationen.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblStatusinformationen.setText("Statusinformationen");
		new Label(ret, SWT.NONE);
		
		TableViewer tableViewerStatusInformationen = new TableViewer(ret, SWT.BORDER | SWT.FULL_SELECTION);
		tableStatusInformationen = tableViewerStatusInformationen.getTable();
		tableStatusInformationen.setHeaderVisible(true);
		tableStatusInformationen.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		//TODO: TableLayout
		
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewerStatusInformationen, SWT.NONE);
		TableColumn tblclmnServiceName = tableViewerColumn.getColumn();
		tblclmnServiceName.setWidth(155);
		tblclmnServiceName.setText("Service Name");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewerStatusInformationen, SWT.NONE);
		TableColumn tblclmnHinweisText = tableViewerColumn_1.getColumn();
		tblclmnHinweisText.setWidth(100);
		tblclmnHinweisText.setText("Modus Text");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewerStatusInformationen, SWT.NONE);
		TableColumn tblclmnHinweisAktion = tableViewerColumn_2.getColumn();
		tblclmnHinweisAktion.setWidth(90);
		tblclmnHinweisAktion.setText("Hinweis Aktion");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewerStatusInformationen, SWT.NONE);
		TableColumn tblclmnHinweisZusatz = tableViewerColumn_3.getColumn();
		tblclmnHinweisZusatz.setWidth(90);
		tblclmnHinweisZusatz.setText("Hinweis Zusatz");
		tableViewerStatusInformationen.setContentProvider(new ArrayContentProvider());
		tableViewerStatusInformationen.setLabelProvider(new GINAStatusDialogServiceStatusInformationLabelProvider());
		tableViewerStatusInformationen.setInput(GINAStatus.getStatusInformationen().getServiceStatusInformation());
		tableViewerStatusInformationen.refresh();
		
		return ret;
	}
	
	@Override
	protected void createButtonsForButtonBar(Composite parent){		
		if(GINAStatus.getGinaStatus()==GINAStatus.GINA_STATUS_NO_CONNECTION_TO_GINA) {
			createButton(parent, IDialogConstants.RETRY_ID, "Erneut versuchen", false);
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
		case IDialogConstants.RETRY_ID:
			GINAStatus.updateStatus(false);
			if(GINAStatus.getGinaStatus()!=GINAStatus.GINA_STATUS_NO_CONNECTION_TO_GINA) close();
			break;
		default:
			break;
		}
	}
}
