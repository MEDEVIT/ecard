package at.medevit.elexis.at.ecard.client.base;

import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import at.chipkarte.client.base.soap.AuthenticationStatus;
import at.chipkarte.client.base.soap.BaseProperty;
import at.chipkarte.client.base.soap.Card;
import at.chipkarte.client.base.soap.CardReader;
import at.chipkarte.client.base.soap.DialogsInfo;
import at.chipkarte.client.base.soap.GinaVersion;
import at.chipkarte.client.base.soap.Ordination;
import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.ReaderStatusEvent;
import at.chipkarte.client.base.soap.ReaderStatusResult;
import at.chipkarte.client.base.soap.ServiceStatusInformation;
import at.chipkarte.client.base.soap.StatusInformationen;
import at.chipkarte.client.base.soap.SvtProperty;
import at.chipkarte.client.base.soap.TaetigkeitsBereich;
import at.chipkarte.client.base.soap.VertragsDaten;
import at.chipkarte.client.base.soap.Vertragspartner;
import at.chipkarte.client.base.soap.exceptions.CardException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.vp.ProduktInfo;

public class BaseServiceTest {
	@Rule public TestName name = new TestName(); 
	
	final String GINALEPURL = "http://10.196.8.146/axis/services/soap/ServiceManager";
	final String WRONGGINAEPURL = "http://127.0.0.1/axis/services/soap/ServiceManager";

	final int PRODUCT_ID = 900201;
	final ProduktInfo pi = new ProduktInfo(PRODUCT_ID, "Elexis Desktop AT");

	private String dialogId;
	private BaseService bs;

	@Before
	public void setUp() throws Exception {
		System.out
				.println("--"+name.getMethodName()+"-----------------------------------------------------------");
	}

	@After
	public void tearDown() throws Exception {
		bs = BaseService.disconnect();
	}

	@Test
	public void testGetInstance() {
		bs = BaseService.getInstance(GINALEPURL);
		Assert.assertEquals(true, BaseService.isConnected());
	}

	@Test
	public void testGetFailingInstance() {
		bs = BaseService.getInstance(WRONGGINAEPURL);
		Assert.assertEquals(false, BaseService.isConnected());
	}

	@Test(expected = CardException.class)
	public void testCreateDialogCardException() throws CardException,
			DialogException {
		bs = BaseService.getInstance(GINALEPURL);
		String cardReaderId = "wrongId";
		String extUid = "UserIdinElexis";
		bs.createDialog(cardReaderId, pi, extUid);
	}


	@Test(expected = DialogException.class)
	public void testCreateDialogDialogException() throws CardException,
			DialogException {
		bs = BaseService.getInstance(GINALEPURL);
		String cardReaderId = bs.getCardReaders()[0].getId();
		String extUid = "UserIdinElexis";
		bs.createDialog(cardReaderId, new ProduktInfo(), extUid);
	}

	@Test
	public void testGetCardReaders() {
		bs = BaseService.getInstance(GINALEPURL);
		CardReader[] cr = bs.getCardReaders();
		for (int i = 0; i < cr.length; i++) {
			System.out.println("CardReader[" + i + "] getId():\t"
					+ cr[i].getId());
			System.out.println("CardReader[" + i + "] getName():\t"
					+ cr[i].getName());
		}
	}

	@Test
	public void testGetCardData() throws CardException {
		bs = BaseService.getInstance(GINALEPURL);
		// returns null if no valid card inserted!
		Card c = bs.getCardData(bs.getCardReaders()[0].getId());
		System.out.println("getCardType():\t" + c.getCardType());
		System.out.println("getCin():\t" + c.getCin());
		System.out.println("getCSn():\t" + c.getCsn());
		System.out.println("getGeburtsdatum():\t" + c.getGeburtsdatum());
		System.out.println("getGeschlechtCode():\t" + c.getGeschlechtCode());
		System.out.println("getNachname():\t" + c.getNachname());
		System.out.println("getNachnameLatin1():\t" + c.getNachnameLatin1());
		System.out.println("getNummer():\t" + c.getNummer());
		System.out.println("getTitel():\t" + c.getTitel());
		System.out.println("getTitelLatin1():\t" + c.getTitelLatin1());
		System.out.println("getTitelHinten():\t" + c.getTitelHinten());
		System.out.println("getTitelHintenLatin1():\t"
				+ c.getTitelHintenLatin1());
		System.out.println("getVorname():\t" + c.getVorname());
		System.out.println("getVornameLatin1():\t" + c.getVornameLatin1());
	}

	@Test
	public void testGetExtendedCardData() throws CardException {
		bs = BaseService.getInstance(GINALEPURL);
		String CIN = bs.getCardData(bs.getCardReaders()[0].getId()).getCin();
		Property[] p = bs.getExtendedCardData(bs.getCardReaders()[0].getId(),
				CIN);
		if (p == null || p.length == 0) {
			System.out.println("No extended card data.");
		} else {
			for (int i = 0; i < p.length; i++) {
				System.out.println("Property [" + i + "]: K=" + p[i].getKey()
						+ " V=" + p[i].getValue());
			}
		}
	}

//	@Test
//	public void testChangePin() {
//		
//		
//	}

	@Test
	public void testChangePinWithPuk() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoCardTest() throws CardException {
		bs = BaseService.getInstance(GINALEPURL);
		int output = bs.doCardTest(bs.getCardReaders()[0].getId());
		System.out.println("doCardTest():\t"+output);
	}

	@Test
	public void testAuthenticateDialog() throws CardException, DialogException {
		bs = BaseService.getInstance(GINALEPURL);
		String cardReaderId = bs.getCardReaders()[0].getId();
		String extUid = "UserIdinElexis";
		dialogId = bs.createDialog(cardReaderId, pi, extUid);
		System.out.println("createDialog():\t" + dialogId);

		// / AUTHENTICATE
		String CIN = bs.getCardData(bs.getCardReaders()[0].getId()).getCin();
		String pin = "2517"; // o-Card Dr. Ordination Muster_403016 MBA
		Vertragspartner vp = bs.authenticateDialog(dialogId, CIN, pin,
				cardReaderId);
		Assert.assertNotNull(vp);
		// FINALIZE
		bs.closeDialog(dialogId);
		System.out.println("closeDialog():\t dialogId: " + dialogId);
	}

	@Test
	public void testSetDialogAddress() throws CardException, DialogException {
		bs = BaseService.getInstance(GINALEPURL);
		String cardReaderId = bs.getCardReaders()[0].getId();
		String extUid = "UserIdinElexis";
		dialogId = bs.createDialog(cardReaderId, pi, extUid);
		System.out.println("createDialog():\t" + dialogId);

		// / AUTHENTICATE
		String CIN = bs.getCardData(bs.getCardReaders()[0].getId()).getCin();
		String pin = "2517"; // o-Card Dr. Ordination Muster_403016 MBA
		Vertragspartner vp = bs.authenticateDialog(dialogId, CIN, pin,
				cardReaderId);
		Assert.assertNotNull(vp);
		
		// SETZEN EINER ORDINATION UND EINES TÄTIGKEITSBEREICHS
		String ordinationId = vp.getOrdination(0).getOrdinationId();
		System.out.println("ordinationId:\t"+ordinationId);
		String taetigkeitsBereichId = vp.getOrdination(0).getTaetigkeitsBereich(0).getId();
		System.out.println("taetigkeitsBereichId:\t"+taetigkeitsBereichId);
		bs.setDialogAddress(dialogId, ordinationId, taetigkeitsBereichId);
		System.out.println("setDialogAddress() successfully completed.");
		
		// FINALIZE
		bs.closeDialog(dialogId);
		System.out.println("closeDialog():\t dialogId: " + dialogId);
	}

	@Test
	public void testCheckStatus() throws DialogException, CardException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		bs = BaseService.getInstance(GINALEPURL);
		String cardReaderId = bs.getCardReaders()[0].getId();
		String extUid = "UserIdinElexis";
		dialogId = bs.createDialog(cardReaderId, pi, extUid);
		System.out.println("createDialog():\t" + dialogId);
		
		// / AUTHENTICATE
		String CIN = bs.getCardData(bs.getCardReaders()[0].getId()).getCin();
		String pin = "2517"; // o-Card Dr. Ordination Muster_403016 MBA
		Vertragspartner vp = bs.authenticateDialog(dialogId, CIN, pin,
				cardReaderId);
		
		// SETZEN EINER ORDINATION UND EINES TÄTIGKEITSBEREICHS
		String ordinationId = vp.getOrdination(0).getOrdinationId();
		System.out.println("ordinationId:\t"+ordinationId);
		String taetigkeitsBereichId = vp.getOrdination(0).getTaetigkeitsBereich(0).getId();
		System.out.println("taetigkeitsBereichId:\t"+taetigkeitsBereichId);
		bs.setDialogAddress(dialogId, ordinationId, taetigkeitsBereichId);
		System.out.println("setDialogAddress() successfully completed.");
		
		Property[] status = bs.checkStatus(dialogId);
		for (int i = 0; i < status.length; i++) {
			printAllStringGetters(Property.class, status[i]);
		}
		
		bs.closeDialog(dialogId);
		System.out.println("closeDialog():\t dialogId: " + dialogId);
	}

	@Test
	public void testUebersiedelnOrdination() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMessages() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFreeDialogs() {
		bs = BaseService.getInstance(GINALEPURL);
		DialogsInfo d = bs.getFreeDialogs();
		System.out.println("getCurrentDialogsCount():\t"
				+ d.getCurrentDialogsCount());
		System.out.println("getMaxDialogsCount():\t" + d.getMaxDialogsCount());
		Assert.assertEquals(20, d.getMaxDialogsCount());
	}

	@Test
	public void testGetGinaSoftwareVersion() {
		BaseService bs = BaseService.getInstance(GINALEPURL);
		GinaVersion gv = bs.getGinaSoftwareVersion();
		Assert.assertNotNull(gv);
		System.out.println("Gina Version: " + gv.getSoftwareVersion());
		System.out.println("Giny Typ: " + gv.getTyp());
	}

	@Test
	public void testGetVertraege() throws CardException, DialogException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		bs = BaseService.getInstance(GINALEPURL);
		String cardReaderId = bs.getCardReaders()[0].getId();
		String extUid = "UserIdinElexis";
		dialogId = bs.createDialog(cardReaderId, pi, extUid);
		System.out.println("createDialog():\t" + dialogId);

		// / AUTHENTICATE
		String CIN = bs.getCardData(bs.getCardReaders()[0].getId()).getCin();
		String pin = "2517"; // o-Card Dr. Ordination Muster_403016 MBA
		Vertragspartner vp = bs.authenticateDialog(dialogId, CIN, pin,
				cardReaderId);
		
		String ordinationId = vp.getOrdination(0).getOrdinationId();
		System.out.println("ordinationId:\t"+ordinationId);
		String taetigkeitsBereichId = vp.getOrdination(0).getTaetigkeitsBereich(0).getId();
		System.out.println("taetigkeitsBereichId:\t"+taetigkeitsBereichId);
		bs.setDialogAddress(dialogId, ordinationId, taetigkeitsBereichId);
		System.out.println("setDialogAddress() successfully completed.");
		if (vp != null) {
			VertragsDaten[] vd = bs.getVertraege(dialogId);
			for (int i = 0; i < vd.length; i++) {
				printAllStringGetters(VertragsDaten.class, vd[i]);
			}
		}
		// FINALIZE
		bs.closeDialog(dialogId);
		System.out.println("closeDialog():\t dialogId: " + dialogId);
	}

	@Test
	public void testGetBCardSvPerson() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSVTs() {
		bs = BaseService.getInstance(GINALEPURL);
		SvtProperty[] stp = bs.getSVTs();
		for (int i = 0; i < stp.length; i++) {
			System.out.println("SvtProperty[" + i + "] getCode():\t"
					+ stp[i].getCode());
			System.out.println("SvtProperty[" + i + "] getEKVKCode():\t"
					+ stp[i].getEKVKCode());
			System.out.println("SvtProperty[" + i + "] getEKVKName():\t"
					+ stp[i].getEKVKName());
			System.out.println("SvtProperty[" + i + "] getKurzbezeichnung:\t"
					+ stp[i].getKurzbezeichnung());
			System.out.println("SvtProperty[" + i + "] getText():\t"
					+ stp[i].getText());
		}
	}

	@Test
	public void testGetFachgebiete() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		bs = BaseService.getInstance(GINALEPURL);
		BaseProperty[] fg = bs.getFachgebiete();
		for (int i = 0; i < fg.length; i++) {
			printAllStringGetters(BaseProperty.class, fg[i]);
		}
	}

	@Test
	public void testGetFachgebieteByOrdId() throws DialogException, CardException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		bs = BaseService.getInstance(GINALEPURL);
		String cardReaderId = bs.getCardReaders()[0].getId();
		String extUid = "UserIdinElexis";
		dialogId = bs.createDialog(cardReaderId, pi, extUid);
		System.out.println("createDialog():\t" + dialogId);

		// / AUTHENTICATE
		String CIN = bs.getCardData(bs.getCardReaders()[0].getId()).getCin();
		String pin = "2517"; // o-Card Dr. Ordination Muster_403016 MBA
		Vertragspartner vp = bs.authenticateDialog(dialogId, CIN, pin,
				cardReaderId);
		Assert.assertNotNull(vp);
		
		// SETZEN EINER ORDINATION UND EINES TÄTIGKEITSBEREICHS
		String ordinationId = vp.getOrdination(0).getOrdinationId();
		System.out.println("ordinationId:\t"+ordinationId);
		String taetigkeitsBereichId = vp.getOrdination(0).getTaetigkeitsBereich(0).getId();
		System.out.println("taetigkeitsBereichId:\t"+taetigkeitsBereichId);
		bs.setDialogAddress(dialogId, ordinationId, taetigkeitsBereichId);
		System.out.println("setDialogAddress() successfully completed.");
		
		BaseProperty[] bp = bs.getFachgebieteByOrdId(dialogId, ordinationId, taetigkeitsBereichId);
		for (int i = 0; i < bp.length; i++) {
			printAllStringGetters(BaseProperty.class, bp[i]);
		}
		
		// FINALIZE
		bs.closeDialog(dialogId);
		System.out.println("closeDialog():\t dialogId: " + dialogId);
	}

	@Test
	public void testGetGinaAndServiceavailabilityInformation() throws RemoteException {
		bs = BaseService.getInstance(GINALEPURL);
		StatusInformationen si = bs.getGinaAndServiceavailabilityInformation();
		System.out.println("-- GinaServiceAndAvailabilityInformation --");
		System.out.println("getGinaInfo():\t" + si.getGinaInfo());
		System.out
				.println("|--getDnsName():\t" + si.getGinaInfo().getDnsName());
		System.out.println("|--getIpAdresse():\t"
				+ si.getGinaInfo().getIpAdresse());
		System.out.println("|--getProduktVersion():\t"
				+ si.getGinaInfo().getProduktVersion());
		ServiceStatusInformation[] sif = si.getServiceStatusInformation();
		System.out.println("getServiceStatusInformation():\t" + sif);
		for (int i = 0; i < sif.length; i++) {
			System.out.println("|---[" + i + "] getHinweisAktion():\t"
					+ sif[i].getHinweisAktion());
			System.out.println("|---[" + i + "] getHinweisZusatz():\t"
					+ sif[i].getHinweisZusatz());
			System.out.println("|---[" + i + "] getModusText():\t"
					+ sif[i].getModusText());
			System.out.println("|---[" + i + "] getServiceName():\t"
					+ sif[i].getServiceName());
		}
		System.out.println("getWartungsfensterVon():\t"
				+ si.getWartungsfensterVon());
		System.out.println("getWartungsfensterBis():\t"
				+ si.getWartungsfensterBis());
		System.out.println("getWartungsfensterText():\t"
				+ si.getWartungsfensterText());
		System.out.println("getWartungsfensterHinweis():\t"
				+ si.getWartungsfensterHinweis());
	}

	@Test
	public void testSetCardReader() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetReaderStatusEvents() throws CardException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		bs = BaseService.getInstance(GINALEPURL);
		String cardReaderId = bs.getCardReaders()[0].getId();
		ReaderStatusResult rs = bs.getReaderStatusEvents("", new String[] { cardReaderId }, 500);
		System.out.println("getHandle():\t"+rs.getHandle());
		ReaderStatusEvent[] rse = rs.getReaderStatusEvents();
		for (int i = 0; i < rse.length; i++) {
			printAllStringGetters(ReaderStatusEvent.class, rse[i]);
		}
	}

	@Test
	public void testReleaseCardReader() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBerechtigungen() throws CardException, DialogException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		bs = BaseService.getInstance(GINALEPURL);
		String cardReaderId = bs.getCardReaders()[0].getId();
		String extUid = "UserIdinElexis";
		dialogId = bs.createDialog(cardReaderId, pi, extUid);
		System.out.println("createDialog():\t" + dialogId);

		// / AUTHENTICATE
		String CIN = bs.getCardData(bs.getCardReaders()[0].getId()).getCin();
		String pin = "2517"; // o-Card Dr. Ordination Muster_403016 MBA
		Vertragspartner vp = bs.authenticateDialog(dialogId, CIN, pin,
				cardReaderId);
		Assert.assertNotNull(vp);
		
		// SETZEN EINER ORDINATION UND EINES TÄTIGKEITSBEREICHS
		String ordinationId = vp.getOrdination(0).getOrdinationId();
		System.out.println("ordinationId:\t"+ordinationId);
		String taetigkeitsBereichId = vp.getOrdination(0).getTaetigkeitsBereich(0).getId();
		System.out.println("taetigkeitsBereichId:\t"+taetigkeitsBereichId);
		bs.setDialogAddress(dialogId, ordinationId, taetigkeitsBereichId);
		System.out.println("setDialogAddress() successfully completed.");
		
		String[] berechtigungen = bs.getBerechtigungen(dialogId);
		if(berechtigungen != null) {
			for (int i = 0; i < berechtigungen.length; i++) {
				System.out.println("Berechtigung "+i+": "+berechtigungen[i]);
			}
		}
		
		// FINALIZE
		bs.closeDialog(dialogId);
		System.out.println("closeDialog():\t dialogId: " + dialogId);
	}

	@Test
	public void testBasicCreateDialog() throws CardException, DialogException {
		bs = BaseService.getInstance(GINALEPURL);
		String cardReaderId = bs.getCardReaders()[0].getId();
		String extUid = "UserIdinElexis";
		dialogId = bs.createDialog(cardReaderId, pi, extUid);
		System.out.println("createDialog():\t" + dialogId);
		bs.closeDialog(dialogId);
		System.out.println("closeDialog():\t dialogId: " + dialogId);
	}

	@Test
	public void testFullCreateDialogGenerateVertragspartner()
			throws CardException, DialogException, IllegalArgumentException, IllegalAccessException, InvocationTargetException
			 {
		bs = BaseService.getInstance(GINALEPURL);
		String cardReaderId = bs.getCardReaders()[0].getId();
		String extUid = "UserIdinElexis";
		dialogId = bs.createDialog(cardReaderId, pi, extUid);
		System.out.println("createDialog():\t" + dialogId);

		// / AUTHENTICATE
		String CIN = bs.getCardData(bs.getCardReaders()[0].getId()).getCin();
		String pin = "2517"; // o-Card Dr. Ordination Muster_403016 MBA
		Vertragspartner vp = bs.authenticateDialog(dialogId, CIN, pin,
				cardReaderId);
		if (vp != null) {
			printAllStringGetters(Vertragspartner.class, vp);
			AuthenticationStatus as = vp.getAuthenticationStatus();
			if(as!=null) printAllStringGetters(AuthenticationStatus.class, as);
			Ordination[] o = vp.getOrdination();
			for (int i = 0; i < o.length; i++) {
				printAllStringGetters(Ordination.class, o[i]);
				TaetigkeitsBereich[] t = o[i].getTaetigkeitsBereich();
				for (int k = 0; k < t.length; k++) {
					printAllStringGetters(TaetigkeitsBereich.class, t[k]);
				}
			}
		}
		// FINALIZE
		bs.closeDialog(dialogId);
		System.out.println("closeDialog():\t dialogId: " + dialogId);
	}

	
	
	private void printAllStringGetters(Class klasse, Object ob) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		System.out.println("|-- "+klasse.toString());
		for (Method method : klasse.getMethods()) {
			if ((method.getName().startsWith("get")
					|| method.getName().startsWith("is")) && method.getReturnType() == String.class) {
				System.out.println("    "+method.getName() + "():\t"+method.invoke(ob, null));
			}
		}
	}
	
}