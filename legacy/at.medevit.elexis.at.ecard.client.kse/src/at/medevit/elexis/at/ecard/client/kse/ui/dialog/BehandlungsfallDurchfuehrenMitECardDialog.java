package at.medevit.elexis.at.ecard.client.kse.ui.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import at.chipkarte.client.base.soap.BaseProperty;

public class BehandlungsfallDurchfuehrenMitECardDialog extends BehandlungsfallDurchfuehrenDialog {
	
	public BehandlungsfallDurchfuehrenMitECardDialog(Shell parentShell){
		super(parentShell);
	}
	
	@Override
	protected Control createDialogArea(Composite parent){
		init();
		
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(3, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		addFachgebietComboSelector(container);
		addBehandlungsfallComboSelector(container);
		addVersicherungstraegerComboSelector(container);
		addKonsultationsartComboSelectorWithNacherfassungDateTime(container);

		setFachgebietComboSelectorSelection(container);
		setBehandlungsfallComboSelectorSelection(container);
		
		return area;
	}
}
