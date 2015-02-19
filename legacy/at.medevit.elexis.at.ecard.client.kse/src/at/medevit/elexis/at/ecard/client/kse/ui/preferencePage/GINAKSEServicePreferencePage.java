package at.medevit.elexis.at.ecard.client.kse.ui.preferencePage;

import static at.medevit.elexis.at.ecard.client.GINAConfigurationConstants.CFG_MANDANT_PRE_SELECTED_BEHANDLUNGSFALL;
import static at.medevit.elexis.at.ecard.client.GINAConfigurationConstants.CFG_MANDANT_PRE_SELECTED_FACHGEBIET;
import static at.medevit.elexis.at.ecard.client.GINAConfigurationConstants.NO_VALUE;

import java.util.List;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import at.chipkarte.client.base.soap.BaseProperty;
import at.medevit.elexis.at.dynamicdata.Behandlungsfaelle;
import at.medevit.elexis.at.ecard.client.base.status.GINAStatus;
import at.medevit.elexis.at.ecard.client.kse.ui.dialog.provider.BasePropertyComboLabelProvider;
import at.medevit.elexis.at.ecard.client.kse.ui.dialog.provider.BasePropertyViewerComparator;
import ch.elexis.Hub;
import ch.elexis.data.Mandant;
import org.eclipse.wb.swt.SWTResourceManager;

public class GINAKSEServicePreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {
	
	private ComboViewer comboViewerBEHANDLUNGSFALL;
	private ComboViewer comboViewerFACHGEBIET;
	
	private BaseProperty[] bps = GINAStatus.getFachgebiete();
	private List<Behandlungsfaelle.Behandlungsfall> bfl = Behandlungsfaelle.getAllBehandlungsfaelle();
	
	public GINAKSEServicePreferencePage(){
		noDefaultAndApplyButton();
	}
	
	@Override
	public void init(IWorkbench workbench){}
	
	@Override
	protected Control createContents(Composite parent){
		Composite ret = new Composite(parent, SWT.None);
		ret.setLayout(new GridLayout(1, false));
		
		Label lblMANDANT = new Label(ret, SWT.NONE);
		lblMANDANT.setText("Einstellungen für Mandant");
		lblMANDANT.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblMANDANT.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Mandant m = Hub.actMandant;
		if(m != null) {
			lblMANDANT.setText("Einstellungen für Madant "+m.getVorname()+" "+m.getName());
		} 
		
		Group grpMandanten = new Group(ret, SWT.NONE);
		grpMandanten.setLayout(new GridLayout(2, false));
		grpMandanten.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpMandanten.setText("Voreinstellungen für Konsultation");
		
		Label lblFachgebiet = new Label(grpMandanten, SWT.NONE);
		lblFachgebiet.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFachgebiet.setText("Fachgebiet");
		
		comboViewerFACHGEBIET = new ComboViewer(grpMandanten, SWT.NONE);
		Combo comboFACHGEBIET = comboViewerFACHGEBIET.getCombo();
		comboFACHGEBIET.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comboViewerFACHGEBIET.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerFACHGEBIET.setLabelProvider(new BasePropertyComboLabelProvider());
		comboViewerFACHGEBIET.setComparator(new BasePropertyViewerComparator());
		comboViewerFACHGEBIET.setInput(bps);
		comboViewerFACHGEBIET.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event){
				IStructuredSelection ordSelection = (IStructuredSelection) comboViewerFACHGEBIET.getSelection();
				BaseProperty prop = (BaseProperty) ordSelection.getFirstElement();
				Hub.mandantCfg.set(CFG_MANDANT_PRE_SELECTED_FACHGEBIET, prop.getCode());
			}
		});

		String fgs = Hub.mandantCfg.get(CFG_MANDANT_PRE_SELECTED_FACHGEBIET, NO_VALUE);
		
		if(!fgs.equalsIgnoreCase(NO_VALUE)) {
			for (BaseProperty baseProperty : bps) {
				if(baseProperty.getCode().equalsIgnoreCase(fgs)) {
					comboViewerFACHGEBIET.setSelection(new StructuredSelection(baseProperty));
					continue;
				}
			}
		}
		
		Label lblBehandlungsfall = new Label(grpMandanten, SWT.NONE);
		lblBehandlungsfall.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblBehandlungsfall.setText("Behandlungsfall");
		
		comboViewerBEHANDLUNGSFALL = new ComboViewer(grpMandanten, SWT.NONE);
		Combo comboBEHANDLUNGSFALL = comboViewerBEHANDLUNGSFALL.getCombo();
		comboBEHANDLUNGSFALL.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comboViewerBEHANDLUNGSFALL.setContentProvider(ArrayContentProvider.getInstance());
		comboViewerBEHANDLUNGSFALL.setLabelProvider(new BehandlungsfallViewerLabelProvider());
		comboViewerBEHANDLUNGSFALL.setComparator(new BehandlungsfallViewerComparator());
		comboViewerBEHANDLUNGSFALL.setInput(bfl);
		comboViewerBEHANDLUNGSFALL.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event){
				IStructuredSelection ordSelection = (IStructuredSelection) comboViewerBEHANDLUNGSFALL.getSelection();
				Behandlungsfaelle.Behandlungsfall prop = (Behandlungsfaelle.Behandlungsfall) ordSelection.getFirstElement();
				System.out.println("setting "+prop.getText());
				Hub.mandantCfg.set(CFG_MANDANT_PRE_SELECTED_BEHANDLUNGSFALL, prop.getNewCode());
			}
		});
		
		String bfs = Hub.mandantCfg.get(CFG_MANDANT_PRE_SELECTED_BEHANDLUNGSFALL, NO_VALUE);
		
		if(!bfs.equalsIgnoreCase(NO_VALUE)) {
			for (Behandlungsfaelle.Behandlungsfall bf : bfl) {
				if(bf.getNewCode().equalsIgnoreCase(bfs)) {
					comboViewerBEHANDLUNGSFALL.setSelection(new StructuredSelection(bf));
					continue;
				}
			}
		}
		
		return ret;
	}
	
	private static class BehandlungsfallViewerLabelProvider extends LabelProvider {
		public Image getImage(Object element){
			return super.getImage(element);
		}
		
		public String getText(Object element){
			return ((Behandlungsfaelle.Behandlungsfall) element).getText();
		}
	}
	
	private static class BehandlungsfallViewerComparator extends ViewerComparator {
		
		@Override
		public int compare(Viewer viewer, Object e1, Object e2){
			Behandlungsfaelle.Behandlungsfall a1 = (Behandlungsfaelle.Behandlungsfall) e1;
			Behandlungsfaelle.Behandlungsfall a2 = (Behandlungsfaelle.Behandlungsfall) e2;
			return a1.getText().compareToIgnoreCase(a2.getText());
		}
	}
}
