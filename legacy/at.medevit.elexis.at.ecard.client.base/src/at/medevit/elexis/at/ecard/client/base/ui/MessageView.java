package at.medevit.elexis.at.ecard.client.base.ui;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.ViewPart;

import at.medevit.elexis.at.ecard.client.base.status.DialogStatus;
import at.medevit.elexis.at.ecard.client.base.ui.dialog.provider.DialogInfoDialogNachrichtenLabelProvider;

public class MessageView extends ViewPart {
	
	public static final String ID = "at.medevit.elexis.at.ecard.client.base.ui.MessageView";
	
	private TableViewer tableViewerMessages;
	
	public MessageView(){
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void createPartControl(Composite parent){
		
		Composite tableComposite = new Composite(parent, SWT.NONE);
		TableColumnLayout tableColumnLayout = new TableColumnLayout();
		tableComposite.setLayout(tableColumnLayout);	
		
		tableViewerMessages = new TableViewer(tableComposite, SWT.BORDER | SWT.FULL_SELECTION);
		Table tableMessages = tableViewerMessages.getTable();
		tableMessages.setHeaderVisible(true);
		
		TableViewerColumn tableViewerTS = new TableViewerColumn(tableViewerMessages, SWT.NONE);
		TableColumn tblclmnTS = tableViewerTS.getColumn();
		tblclmnTS.setToolTipText("Zeitstempel, wann die Nachricht erzeugt wurde");
		tblclmnTS.setText("Zeitstempel");
		tableColumnLayout.setColumnData(tblclmnTS, new ColumnWeightData(15, 100, true));
		
		TableViewerColumn tableViewerId = new TableViewerColumn(tableViewerMessages, SWT.NONE);
		TableColumn tblclmnId = tableViewerId.getColumn();
		tblclmnId.setToolTipText("Eindeutiger Bezeichner für die Nachricht");
		tblclmnId.setText("Message ID");
		tableColumnLayout.setColumnData(tblclmnId, new ColumnWeightData(15, 100, true));
		
		TableViewerColumn tableViewerText = new TableViewerColumn(tableViewerMessages, SWT.NONE);
		TableColumn tblclmnText = tableViewerText.getColumn();
		tblclmnText.setToolTipText("Nachrichtentext");
		tblclmnText.setText("Text");
		tableColumnLayout.setColumnData(tblclmnText, new ColumnWeightData(20, 100, true));
		
		TableViewerColumn tableViewerApp = new TableViewerColumn(tableViewerMessages, SWT.NONE);
		TableColumn tblclmnApp = tableViewerApp.getColumn();
		tblclmnApp.setToolTipText("ID des Nachricht-erzeugenden Service");
		tblclmnApp.setText("App ID");
		tableColumnLayout.setColumnData(tblclmnApp, new ColumnWeightData(15, 100, true));
		
		TableViewerColumn tableViewerCategory =
			new TableViewerColumn(tableViewerMessages, SWT.NONE);
		TableColumn tblclmnCategory = tableViewerCategory.getColumn();
		tblclmnCategory.setToolTipText("Kategorie der Nachricht");
		tblclmnCategory.setText("Kategorie");
		tableColumnLayout.setColumnData(tblclmnCategory, new ColumnWeightData(15, 100, true));
		
		TableViewerColumn tableViewerData = new TableViewerColumn(tableViewerMessages, SWT.NONE);
		TableColumn tblclmnData = tableViewerData.getColumn();
		tblclmnData.setToolTipText("Datenfeld für das jeweilige Service mit beliebigem Inhalt");
		tblclmnData.setText("Daten");
		tableColumnLayout.setColumnData(tblclmnData, new ColumnWeightData(20, 100, true));
		
		tableViewerMessages.setContentProvider(ArrayContentProvider.getInstance());
		tableViewerMessages.setLabelProvider(new DialogInfoDialogNachrichtenLabelProvider());
		tableViewerMessages.setInput(DialogStatus.getMessages());
		
		MenuManager menuManager = new MenuManager();
		menuManager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		tableViewerMessages.getTable().setMenu(menuManager.createContextMenu(tableViewerMessages.getTable()));	
		getSite().registerContextMenu(menuManager, tableViewerMessages);
		getSite().setSelectionProvider(tableViewerMessages);
	}
	
	@Override
	public void setFocus(){
		tableViewerMessages.setInput(DialogStatus.getMessages());
	}
	
}
