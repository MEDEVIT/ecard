package at.medevit.elexis.at.ecard.client.kse.ui.dialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wb.swt.ResourceManager;

import at.chipkarte.client.base.soap.BaseProperty;
import at.medevit.elexis.at.XID.SVNR;

import ch.elexis.actions.ElexisEventDispatcher;
import ch.elexis.data.Artikel;
import ch.elexis.data.Kontakt;
import ch.elexis.data.Patient;
import ch.elexis.dialogs.KontaktSelektor;

public class BehandlungsfallDurchfuehrenMitOCardDialog extends BehandlungsfallDurchfuehrenDialog {
	
	private Text txtSVNR;

	public BehandlungsfallDurchfuehrenMitOCardDialog(Shell parentShell){
		super(parentShell);
	}
	
	
	@Override
	protected Control createDialogArea(Composite parent){
		init();
		final Patient pat = ElexisEventDispatcher.getSelectedPatient();		
		
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(3, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayout(new GridLayout(4, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
		Label lblSVNR = new Label(composite, SWT.NONE);
		lblSVNR.setText("SVNR des Patienten");
		
		txtSVNR = new Text(composite, SWT.BORDER);
		txtSVNR.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnCurrPatient = new Button(composite, SWT.NONE);
		btnCurrPatient.setText("aktueller Patient");
		if(pat==null) btnCurrPatient.setEnabled(false);
		btnCurrPatient.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				String svnr = pat.getXid(SVNR.DOMAIN_AT_SVNR);
				if(svnr!=null) txtSVNR.setText(svnr);
			}
		});
		
		Button btnSearch = new Button(composite, SWT.NONE);
		btnSearch.setImage(ResourceManager.getPluginImage("at.medevit.elexis.at.ecard.client.kse", "rsc/icons/system-search-3.ico"));
		btnSearch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				KontaktSelektor ksl = new KontaktSelektor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					Patient.class, "Patient suchen", "Bitte selektieren Sie den Patienten", Kontakt.DEFAULT_SORT);
				if (ksl.open() == Dialog.OK) {
					Patient p = (Patient) ksl.getSelection();
					String svnr = p.getXid(SVNR.DOMAIN_AT_SVNR);
					if(svnr!=null) txtSVNR.setText(svnr);
				}
			}
		});
		
		addFachgebietComboSelector(container);
		addBehandlungsfallComboSelector(container);
		addVersicherungstraegerComboSelector(container);
		addKonsultationsartComboSelectorWithNacherfassungDateTime(container);
		
		setFachgebietComboSelectorSelection(container);
		setBehandlungsfallComboSelectorSelection(container);
		
		return container;
	}
	
	@Override
	protected void okPressed(){
		if(SVNR.validateSVNumber(txtSVNR.getText())) {
			selectedSVNR = txtSVNR.getText();
		} else {
			setErrorMessage("Ungültige Versicherungsnummer");
			return;
		}
		super.okPressed();
	}
	
}
