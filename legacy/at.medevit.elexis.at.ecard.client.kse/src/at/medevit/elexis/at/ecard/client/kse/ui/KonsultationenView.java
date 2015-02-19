package at.medevit.elexis.at.ecard.client.kse.ui;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.ViewPart;

import at.medevit.elexis.at.ecard.client.kse.command.KonsultationsbelegAnzeigen;
import at.medevit.elexis.at.ecard.client.kse.status.KseStatus;
import at.medevit.elexis.at.ecard.client.kse.ui.provider.KonsultationenTreeContentProvider;
import at.medevit.elexis.at.ecard.client.kse.ui.provider.KonsultationenTreeLabelProvider;

public class KonsultationenView extends ViewPart {
	private DataBindingContext m_bindingContext;
	
	public static final String ID = "at.medevit.elexis.at.ecard.client.kse.ui.KonsultationenView";
	private TreeViewer treeViewer;
	private KseStatus kseStatus = KseStatus.getInstance();
	private Label lblOFFLINENACHSIGNATUREN;
	private Label lblGESPEICHERTEKONSULTATIONEN;
	
	public KonsultationenView() {
	}

	@Override
	public void createPartControl(Composite parent){
		parent.setLayout(new GridLayout(1, false));
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		TreeColumnLayout tcl_composite = new TreeColumnLayout();
		composite.setLayout(tcl_composite);
		
		treeViewer = new TreeViewer(composite, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		
		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn trclmnNewColumn = treeViewerColumn.getColumn();
		tcl_composite.setColumnData(trclmnNewColumn, new ColumnWeightData(100));
		trclmnNewColumn.setText("New Column");
		
		treeViewer.setLabelProvider(new KonsultationenTreeLabelProvider());
		treeViewer.setContentProvider(new KonsultationenTreeContentProvider(treeViewer));

		treeViewer.setInput("0");
		treeViewer.addDoubleClickListener(new KonsultationsbelegAnzeigen());
		
		MenuManager menuManager = new MenuManager();
		menuManager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		tree.setMenu(menuManager.createContextMenu(tree));
		
		getSite().registerContextMenu(menuManager, treeViewer);
		getSite().setSelectionProvider(treeViewer);
		
		Composite composite_1 = new Composite(parent, SWT.NONE);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		composite_1.setLayout(new GridLayout(4, false));
		
		Label lblOfflineNachsignaturen = new Label(composite_1, SWT.NONE);
		lblOfflineNachsignaturen.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		lblOfflineNachsignaturen.setText("Gespeicherte Offline-Nachsignaturen: ");
		
		lblOFFLINENACHSIGNATUREN = new Label(composite_1, SWT.NONE);
		GridData gd_lblOFFLINENACHSIGNATUREN = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblOFFLINENACHSIGNATUREN.widthHint = 25;
		lblOFFLINENACHSIGNATUREN.setLayoutData(gd_lblOFFLINENACHSIGNATUREN);
		lblOFFLINENACHSIGNATUREN.setText("n/a");
		
		Label lblGespeicherteOfflineKonsultationen = new Label(composite_1, SWT.NONE);
		lblGespeicherteOfflineKonsultationen.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		lblGespeicherteOfflineKonsultationen.setText("Gespeicherte Offline Konsultationen:");
		
		lblGESPEICHERTEKONSULTATIONEN = new Label(composite_1, SWT.NONE);
		GridData gd_lblGESPEICHERTEKONSULTATIONEN = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblGESPEICHERTEKONSULTATIONEN.widthHint = 25;
		lblGESPEICHERTEKONSULTATIONEN.setLayoutData(gd_lblGESPEICHERTEKONSULTATIONEN);
		lblGESPEICHERTEKONSULTATIONEN.setText("n/a");
		m_bindingContext = initDataBindings();
	}

	@Override
	public void setFocus(){
		treeViewer.refresh();	
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue lblOFFLINENACHSIGNATURENObserveTextObserveWidget = SWTObservables.observeText(lblOFFLINENACHSIGNATUREN);
		IObservableValue kseStatusNumberOfflineNachsignaturenObserveValue = BeansObservables.observeValue(kseStatus, "numberOfflineNachsignaturen");
		bindingContext.bindValue(lblOFFLINENACHSIGNATURENObserveTextObserveWidget, kseStatusNumberOfflineNachsignaturenObserveValue, null, null);
		//
		IObservableValue lblGESPEICHERTEKONSULTATIONENObserveTextObserveWidget = SWTObservables.observeText(lblGESPEICHERTEKONSULTATIONEN);
		IObservableValue kseStatusNumberOfflineKonsultationenObserveValue = BeansObservables.observeValue(kseStatus, "numberOfflineKonsultationen");
		bindingContext.bindValue(lblGESPEICHERTEKONSULTATIONENObserveTextObserveWidget, kseStatusNumberOfflineKonsultationenObserveValue, null, null);
		//
		return bindingContext;
	}
}
