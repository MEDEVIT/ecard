package at.medevit.elexis.at.ecard.client.base.ui.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;

import at.chipkarte.client.base.soap.Card;
import at.chipkarte.client.base.soap.SvPerson;
import at.medevit.elexis.at.data.SVPerson;

public class PatientAufnehmenDialog extends TitleAreaDialog {
	
	private String m_titelVorne;
	private String m_Vorname;
	private String m_Nachname;
	private String m_titelHinten;
	private String m_SVNR;
	private String m_Geburtsdatum;
	private String m_Geschlecht;
	
	private Text txtTitelVorne;
	private Text txtVorname;
	private Text txtNachname;
	private Text txtTitelHinten;
	private Text txtSVNR;

	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public PatientAufnehmenDialog(Shell parentShell){
		super(parentShell);
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public PatientAufnehmenDialog(Shell parentShell, Card cardData){
		super(parentShell);
		
		m_titelVorne = (cardData.getTitel() != null) ? cardData.getTitel() : "";
		m_Vorname = (cardData.getVorname() != null) ? cardData.getVorname() : "";
		m_Nachname = (cardData.getNachname() != null) ? cardData.getNachname() : "";
		m_titelHinten = (cardData.getTitelHinten() != null) ? cardData.getTitelHinten() : "";
		m_Geburtsdatum = (cardData.getGeburtsdatum() != null) ? cardData.getGeburtsdatum() : "";
		m_SVNR = (cardData.getNummer() != null) ? cardData.getNummer() : "";
		m_Geschlecht = (cardData.getGeschlechtCode() != null) ? cardData.getGeschlechtCode() : "";
	}

	public PatientAufnehmenDialog(Shell parentShell, SvPerson p){
		super(parentShell);
		
		m_titelVorne = (p.getTitelVorne() != null) ? p.getTitelVorne() : "";
		m_Vorname = (p.getVorname() != null) ? p.getVorname() : "";
		m_Nachname = (p.getNachname() != null) ? p.getNachname() : "";
		m_titelHinten = (p.getTitelHinten() != null) ? p.getTitelHinten() : "";
		m_Geburtsdatum = (p.getGeburtsdatum() != null) ? p.getGeburtsdatum() : "";
		m_SVNR = (p.getSvNummer() != null) ? p.getSvNummer() : "";
		m_Geschlecht = (p.getGeschlecht() != null) ? p.getGeschlecht() : "";
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent){
		setMessage("Patient ist derzeit nicht im System geführt.");
		setTitle("Patient aufnehmen");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(5, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lblTitelVorne = new Label(container, SWT.NONE);
		lblTitelVorne.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTitelVorne.setText("Titel Vorne");
		
		txtTitelVorne = new Text(container, SWT.BORDER | SWT.READ_ONLY);
		txtTitelVorne.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
		txtTitelVorne.setText(m_titelVorne);
		
		Label lblVorname = new Label(container, SWT.NONE);
		lblVorname.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblVorname.setText("Vorname");
		
		txtVorname = new Text(container, SWT.BORDER | SWT.READ_ONLY);
		txtVorname.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 4, 1));
		txtVorname.setText(m_Vorname);
		
		Label lblNachname = new Label(container, SWT.NONE);
		lblNachname.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNachname.setText("Nachname");
		
		txtNachname = new Text(container, SWT.BORDER | SWT.READ_ONLY);
		txtNachname.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
		txtNachname.setText(m_Nachname);
		
		Label lblTitelHinten = new Label(container, SWT.NONE);
		lblTitelHinten.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTitelHinten.setText("TitelHinten");
		
		txtTitelHinten = new Text(container, SWT.BORDER | SWT.READ_ONLY);
		txtTitelHinten.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
		txtTitelHinten.setText(m_titelHinten);
		
		Label lblGeburtsdatum = new Label(container, SWT.NONE);
		lblGeburtsdatum.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblGeburtsdatum.setText("Geburtsdatum");
		
		DateTime dateTimeBirthday = new DateTime(container, SWT.BORDER | SWT.LONG);
		String bd[] = m_Geburtsdatum.split("\\.");
		dateTimeBirthday.setDay(Integer.parseInt(bd[0]));
		dateTimeBirthday.setMonth(Integer.parseInt(bd[1])-1);
		dateTimeBirthday.setYear(Integer.parseInt(bd[2]));
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayout(new GridLayout(2, true));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 3, 1));
		
		Button btnRadioButtonMale = new Button(composite, SWT.RADIO);
		btnRadioButtonMale.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		btnRadioButtonMale.setText("männlich");
		btnRadioButtonMale.setImage(ResourceManager.getPluginImage("at.medevit.elexis.at.ecard.client.base", "rsc/icons/male.ico"));
		
		Button btnRadioButtonFemale = new Button(composite, SWT.RADIO);
		btnRadioButtonFemale.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		btnRadioButtonFemale.setImage(ResourceManager.getPluginImage("at.medevit.elexis.at.ecard.client.base", "rsc/icons/female.ico"));
		btnRadioButtonFemale.setText("weiblich");
		
		if(m_Geschlecht.equalsIgnoreCase(SVPerson.MAENNLICH)) {
			btnRadioButtonMale.setSelection(true);
		} else {
			btnRadioButtonFemale.setSelection(true);
		}
		
		Label lblSvnr = new Label(container, SWT.NONE);
		lblSvnr.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSvnr.setText("SVNR");
		
		txtSVNR = new Text(container, SWT.BORDER | SWT.READ_ONLY);
		txtSVNR.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
		txtSVNR.setText(m_SVNR);
		
		return area;
	}
	
	
	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent){
		Button btnAufnehmen = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		btnAufnehmen.setText("Aufnehmen");
		Button btnSelectExisting = createButton(parent, IDialogConstants.SELECT_TYPES_ID, "", false);
		btnSelectExisting.setText("Zuweisen");
		btnSelectExisting.setEnabled(false);
	}
	
	@Override
	protected Point getInitialSize(){
		return new Point(430, 305);
	}
}
