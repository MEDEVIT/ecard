package at.medevit.elexis.at.ecard.client.kse;

import static org.junit.Assert.*;

import java.io.IOException;
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
import at.chipkarte.client.base.soap.Ordination;
import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.TaetigkeitsBereich;
import at.chipkarte.client.base.soap.Vertragspartner;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.vp.ProduktInfo;
import at.chipkarte.client.kse.soap.Konsultationsdaten;
import at.chipkarte.client.kse.soap.Limit;
import at.chipkarte.client.kse.soap.OfflineRecord;
import at.chipkarte.client.kse.soap.SuchFilter;
import at.chipkarte.client.kse.soap.constants.LimitZeitraum;
import at.chipkarte.client.kse.soap.constants.Selektionsart;
import at.medevit.elexis.at.ecard.client.base.BaseService;

public class KseServiceTest {
	@Rule
	public TestName name = new TestName();
	
	final String GINALEPURL = "http://10.196.8.146/axis/services/soap/ServiceManager";
	final String WRONGGINAEPURL = "http://127.0.0.1/axis/services/soap/ServiceManager";
	
	final int PRODUCT_ID = 900201;
	final ProduktInfo pi = new ProduktInfo(PRODUCT_ID, "Elexis Desktop AT");
	
	private String dialogId;
	private BaseService bs = null;
	private KseService ks = null;
	private String ordinationId = null;
	private String taetigkeitsBereichId = null;
	
	@Before
	public void setUp() throws Exception{
		System.out.println("--" + name.getMethodName()
			+ "-----------------------------------------------------------");
		bs = BaseService.getInstance(GINALEPURL);
		String cardReaderId = bs.getCardReaders()[0].getId();
		String extUid = "UserIdinElexis";
		dialogId = bs.createDialog(cardReaderId, pi, extUid);
		System.out.println("[SU] createDialog():\t" + dialogId);
		
		// / AUTHENTICATE
		String CIN = bs.getCardData(bs.getCardReaders()[0].getId()).getCin();
		String pin = "2517"; // o-Card Dr. Ordination Muster_403016 MBA
		Vertragspartner vp = bs.authenticateDialog(dialogId, CIN, pin, cardReaderId);
		Assert.assertNotNull(vp);
		
		// SETZEN EINER ORDINATION UND EINES TÄTIGKEITSBEREICHS
		ordinationId = vp.getOrdination(0).getOrdinationId();
		System.out.println("[SU] ordinationId:\t" + ordinationId);
		taetigkeitsBereichId = vp.getOrdination(0).getTaetigkeitsBereich(0).getId();
		System.out.println("[SU] taetigkeitsBereichId:\t" + taetigkeitsBereichId);
		bs.setDialogAddress(dialogId, ordinationId, taetigkeitsBereichId);
		System.out.println("[SU] setDialogAddress() successfully completed.");
	}
	
	@After
	public void tearDown() throws Exception{
		System.out.println("[TD] closeDialog():\t dialogId: " + dialogId);
		bs.closeDialog(dialogId);
		dialogId = null;
		ordinationId = null;
		taetigkeitsBereichId = null;
		bs = BaseService.disconnect();
		ks = KseService.disconnect();

	}
	
	@Test
	public void testGetInstance(){
		ks = KseService.getInstance(GINALEPURL);
		Assert.assertEquals(true, KseService.isConnected());
	}
	
	@Test
	public void testGetFailingInstance(){
		ks = KseService.getInstance(WRONGGINAEPURL);
		Assert.assertEquals(false, KseService.isConnected());
	}
	
//	@Test
//	public void testIsConnected(){
//		fail("Not yet implemented");
//	}
	
	@Test
	public void testCheckStatus() throws RemoteException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		ks = KseService.getInstance(GINALEPURL);
		Property[] p = ks.checkStatus(dialogId);
		for (int i = 0; i < p.length; i++) {
			printAllStringGetters(Property.class, p[i]);
		}
	}
	
	@Test
	public void testGetBehandlungsfaelle() throws RemoteException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		ks = KseService.getInstance(GINALEPURL);
		BaseProperty[] bf = ks.getBehandlungsfaelle();
		for (int i = 0; i < bf.length; i++) {
			printAllStringGetters(BaseProperty.class, bf[i]);
		}
	}
	
	@Test
	public void testGetBehandlungsfaelleByFachgebiet() throws RemoteException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		ks = KseService.getInstance(GINALEPURL);
		BaseProperty[] bp = BaseService.getInstance(GINALEPURL).getFachgebieteByOrdId(dialogId, ordinationId, taetigkeitsBereichId);
		System.out.println("Ausgewähltes Fachgebiet: "+bp[0].getText());
		BaseProperty[] fg = ks.getBehandlungsfaelleByFachgebiet(bp[0].getCode());
		for (int i = 0; i < fg.length; i++) {
			printAllStringGetters(BaseProperty.class, fg[i]);
		}
	}
	
	@Test
	public void testGetLimit() throws RemoteException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		ks = KseService.getInstance(GINALEPURL);
		Limit[] li = ks.getLimit(dialogId, LimitZeitraum.AKTUELLE_PRUEFPERIODE);
		for (int i = 0; i < li.length; i++) {
			printAllStringGetters(Limit.class, li[i]);
		}
	}
	
	@Test
	public void testDoKonsultation(){
//		ks = KseService.getInstance(GINALEPURL);
//		ks.doKonsultation(null, dialogId, "7997216015", svtCode, anspruchId, fachgebietsCode, behandlungsfallCode, nacherfassungsgrundCode, behandlungsdatum, forceExecution, cardReaderId)
	}
	
//	@Test
//	public void testSendZusatzinformationsAntwort(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testDoKonsultationOffline(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testStornierenKonsultation(){
//		ks = KseService.getInstance(GINALEPURL);
//	}
//	
//	@Test
//	public void testWiederinkraftsetzenKonsultation(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testAendernKonsultation(){
//		fail("Not yet implemented");
//	}
	
	@Test
	public void testGetKonsultationsdaten() throws RemoteException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		ks = KseService.getInstance(GINALEPURL);
		SuchFilter sf = new SuchFilter("", "RF", "", "", "", "", "", "");
		Konsultationsdaten[] kd = ks.getKonsultationsdaten(dialogId, sf, Selektionsart.ALLE);
		if(kd == null) return;
		for (int i = 0; i < kd.length; i++) {
			printAllStringGetters(Konsultationsdaten.class, kd[i]);
		}
	}
	
	@Test
	public void testSendKonsultationsdatenAnfrage() throws RemoteException{
		ks = KseService.getInstance(GINALEPURL);
		SuchFilter sf = new SuchFilter();
		String out = ks.sendKonsultationsdatenAnfrage(dialogId, sf);
		System.out.println(out);
	}
//	
//	@Test
//	public void testDownloadKonsultationsdaten(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testGetKonsultationsdatenAnfragen(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testDeleteKonsultationsdatenAnfrage(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testNachsignierenKonsultationen(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testNachsignierenKonsultationenBCard(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testNachsignierenKonsultationenOffline(){
//		fail("Not yet implemented");
//	}
//	
//	
	@Test
	public void testGetOfflineRecords() throws IOException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		ks = KseService.getInstance(GINALEPURL);
		OfflineRecord[] or = ks.getOfflineRecords(dialogId);
		if(or==null) return;
		for (int i = 0; i < or.length; i++) {
			printAllStringGetters(OfflineRecord.class, or[i]);
		}
	}
	
//	@Test
//	public void testGetNumberOfflineKonsultationen(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testGetNumberOfflineNachsignaturen(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testDeleteOfflineRecord(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testSendOfflineKonsultation(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testSendOfflineNachsignatur(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testObject(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testGetClass(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testHashCode(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testEquals(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testClone(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testToString(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testNotify(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testNotifyAll(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testWaitLong(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testWaitLongInt(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testWait(){
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void testFinalize(){
//		fail("Not yet implemented");
//	}
	
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
