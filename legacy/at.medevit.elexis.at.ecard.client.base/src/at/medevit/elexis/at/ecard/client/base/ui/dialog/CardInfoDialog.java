package at.medevit.elexis.at.ecard.client.base.ui.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import at.chipkarte.client.base.soap.Card;
import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.constants.CardType;
import at.chipkarte.client.base.soap.exceptions.CardException;
import at.medevit.elexis.at.ecard.client.base.BaseService;
import at.medevit.elexis.at.ecard.client.base.ui.dialog.provider.CardInfoDialogExtendedCardDataLabelProvider;

import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;

public class CardInfoDialog extends TitleAreaDialog {
	
	private Card cardData = null;
	private Property[] extendedCardData = null;
	private Table tableErweiterteKartendaten;
	
	public CardInfoDialog(Shell parentShell){
		super(parentShell);
	}
	
	@Override
	protected Control createDialogArea(Composite parent){
		setTitle("Daten der eingelesenen Karte");
		
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(4, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		try {
			cardData = BaseService.getInstance(null).getCardData(null);
			extendedCardData = BaseService.getInstance(null).getExtendedCardData(null, null);
		} catch (CardException e) {
			setErrorMessage(e.getMessage1());
			e.printStackTrace();
		}
		
		if(cardData == null) return area;
		
		if (cardData.getCardType().equalsIgnoreCase(CardType.O_CARD)) {
			setTitleImage(org.eclipse.wb.swt.ResourceManager.getPluginImage(
				"at.medevit.elexis.at.ecard.client.base", "rsc/icons/oCardTitle.png"));
		} else {
			setTitleImage(org.eclipse.wb.swt.ResourceManager.getPluginImage(
				"at.medevit.elexis.at.ecard.client.base", "rsc/icons/eCardTitle.png"));
		}
		
		String titelVorne = cardData.getTitel();
		String titelHinten = cardData.getTitelHinten();
		
		StringBuilder sb = new StringBuilder();
		sb.append("Kartenbesitzer: ");
		if(titelVorne != null) sb.append(titelVorne+" ");
		sb.append(cardData.getNachname()+" ");
		sb.append(cardData.getVorname());
		if(titelHinten != null) sb.append(", "+titelHinten);
		
		setMessage(sb.toString());
		
		Label lblCin = new Label(container, SWT.NONE);
		lblCin.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblCin.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCin.setAlignment(SWT.RIGHT);
		lblCin.setToolTipText("Card Identification Number: Eindeutige Nummer der Karte im e-card System");
		lblCin.setText("CIN:");
		
		Label lblCIN = new Label(container, SWT.NONE);
		lblCIN.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblCIN.setText(cardData.getCin());
		
		Label lblCsn = new Label(container, SWT.NONE);
		lblCsn.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblCsn.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCsn.setAlignment(SWT.RIGHT);
		lblCsn.setText("Karten-Laufnummer");
		
		Label lblCSN = new Label(container, SWT.NONE);
		lblCSN.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblCSN.setText(cardData.getCsn());
		
		Label lblNSvnr = new Label(container, SWT.NONE);
		lblNSvnr.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblNSvnr.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		if (cardData.getCardType().equalsIgnoreCase(CardType.O_CARD)) {
			lblNSvnr.setToolTipText("Vertragspartnernummer");
			lblNSvnr.setText("VPNR");
		} else {
			lblNSvnr.setToolTipText("Sozialversicherungsnummer");
			lblNSvnr.setText("SVNR");
		}

		
		Label lblSVNR = new Label(container, SWT.NONE);
		lblSVNR.setText(cardData.getNummer());
		
		Label lblGeburtsdatum = new Label(container, SWT.NONE);
		lblGeburtsdatum.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblGeburtsdatum.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblGeburtsdatum.setText("Geburtsdatum");
		
		Label lblGEBURTSDATUM = new Label(container, SWT.NONE);
		lblGEBURTSDATUM.setText(cardData.getGeburtsdatum());
		
		Label label = new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblGeschlecht = new Label(container, SWT.NONE);
		lblGeschlecht.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblGeschlecht.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblGeschlecht.setText("Geschlecht");
		
		Label lblGESCHLECHT = new Label(container, SWT.NONE);
		lblGESCHLECHT.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1));
		lblGESCHLECHT.setText(cardData.getGeschlechtCode());
		
		Label lblErweiterteKartendaten = new Label(container, SWT.NONE);
		lblErweiterteKartendaten.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblErweiterteKartendaten.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblErweiterteKartendaten.setText("Erweiterte Kartendaten");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		TableViewer tableViewerErweiterteKartendaten = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		tableErweiterteKartendaten = tableViewerErweiterteKartendaten.getTable();
		tableErweiterteKartendaten.setHeaderVisible(true);
		tableErweiterteKartendaten.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1));
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewerErweiterteKartendaten, SWT.NONE);
		TableColumn tblclmnKey = tableViewerColumn.getColumn();
		tblclmnKey.setWidth(200);
		tblclmnKey.setText("Schlüssel");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewerErweiterteKartendaten, SWT.NONE);
		TableColumn tblclmnValue = tableViewerColumn_1.getColumn();
		tblclmnValue.setWidth(200);
		tblclmnValue.setText("Wert");
		tableViewerErweiterteKartendaten.setContentProvider(new ArrayContentProvider());
		tableViewerErweiterteKartendaten.setLabelProvider(new CardInfoDialogExtendedCardDataLabelProvider());
		tableViewerErweiterteKartendaten.setInput(extendedCardData);
		
		return area;
	}
	
	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent){
		Button btnOk =
			createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		btnOk.setEnabled(true);
	}
	
}
