package at.medevit.elexis.at.ecard.client.kse.ui.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.kse.soap.Limit;
import at.chipkarte.client.kse.soap.constants.LimitZeitraum;
import at.chipkarte.client.kse.soap.exceptions.InvalidParameterException;
import at.medevit.elexis.at.ecard.client.base.status.DialogStatus;
import at.medevit.elexis.at.ecard.client.kse.KseService;
import at.medevit.elexis.at.ecard.client.kse.ui.dialog.provider.LimitZeitraumComboLabelProvider;
import at.medevit.elexis.at.ecard.client.kse.ui.dialog.provider.LimitstaendeTreeContentProvider;
import at.medevit.elexis.at.ecard.client.kse.ui.dialog.provider.LimitstaendeTreeLabelProvider;

public class LimitstaendeAnzeigenDialog extends TitleAreaDialog {
	private ComboViewer comboViewerZeitraum;
	
	private int lz = LimitZeitraum.AKTUELLE_PRUEFPERIODE;
	private TreeViewer tableTreeViewerLimits;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public LimitstaendeAnzeigenDialog(Shell parentShell){
		super(parentShell);
	}
	
	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent){
		setTitle("Limitstände");
		Composite area = (Composite) super.createDialogArea(parent);
		
		Composite compositeFilter = new Composite(area, SWT.NONE);
		compositeFilter.setLayout(new GridLayout(2, false));
		compositeFilter.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblZeitraum = new Label(compositeFilter, SWT.NONE);
		lblZeitraum.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblZeitraum.setBounds(0, 0, 59, 14);
		lblZeitraum.setText("Zeitraum");
		
		comboViewerZeitraum = new ComboViewer(compositeFilter, SWT.NONE);
		Combo comboZeitraum = comboViewerZeitraum.getCombo();
		comboZeitraum.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comboViewerZeitraum.setLabelProvider(new LimitZeitraumComboLabelProvider());
		comboViewerZeitraum.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerZeitraum.setInput(new int[] {LimitZeitraum.AKTUELLE_PRUEFPERIODE, LimitZeitraum.NACHBRINGFRIST});
		comboViewerZeitraum.setSelection(new StructuredSelection(LimitZeitraum.AKTUELLE_PRUEFPERIODE));
		
		tableTreeViewerLimits = new TreeViewer(area, SWT.BORDER | SWT.FULL_SELECTION);
		Tree tableTreeLimits = tableTreeViewerLimits.getTree();
		tableTreeLimits.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		tableTreeViewerLimits.setContentProvider(new LimitstaendeTreeContentProvider(tableTreeViewerLimits));
		tableTreeViewerLimits.setLabelProvider(new LimitstaendeTreeLabelProvider());
		
		comboViewerZeitraum.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event){
				lz = (Integer) ((StructuredSelection) event.getSelection()).getFirstElement();
				init();
			}
		});
		
		init();
		
		return area;
	}
	
	void init() {
		try {
			Limit[] limits = KseService.getInstance(null).getLimit(DialogStatus.getDialogId(), lz);
			tableTreeViewerLimits.setInput(limits);
			setMessage("Limitstände per jetzt"); // TODO
		} catch (DialogException e) {
			setErrorMessage(e.getMessage1());
		} catch (ServiceException e) {
			setErrorMessage(e.getMessage1());
		} catch (AccessException e) {
			setErrorMessage(e.getMessage1());
		} catch (InvalidParameterException e) {
			setErrorMessage(e.getMessage1());
		}
	}
	
	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent){
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}
	
	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize(){
		return new Point(450, 300);
	}
}
