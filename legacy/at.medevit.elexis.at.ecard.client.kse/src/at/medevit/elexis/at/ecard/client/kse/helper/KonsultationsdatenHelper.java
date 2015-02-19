package at.medevit.elexis.at.ecard.client.kse.helper;

import java.lang.reflect.InvocationTargetException;

import javax.persistence.EntityManager;

import org.apache.commons.beanutils.BeanUtils;

import at.chipkarte.client.kse.soap.KonsultationsBeleg;
import at.medevit.elexis.at.data.SVPerson;
import at.medevit.elexis.at.ecard.client.base.helper.PatientHelper;
import at.medevit.elexis.at.ecard.client.kse.entitymanager.EntityManagerService;
import at.medevit.elexis.at.ecard.client.kse.model.annotated.Konsultationsbeleg;
import at.medevit.elexis.at.ecard.client.kse.model.annotated.Konsultationsdaten;
import ch.elexis.util.Log;

public class KonsultationsdatenHelper {
	private static EntityManager em = EntityManagerService.getEntityManager();
	private static Log logger = Log.get(KonsultationsdatenHelper.class.getName());
	
	/**
	 * Persist an entity of type {@link at.chipkarte.client.kse.soap.Konsultationsdaten} including
	 * the associated {@link Konsultationsbeleg}<br>
	 * ATTENTION: This method tries to find an existing entry according to the associated
	 * {@link Konsultationsbeleg#getId()}
	 * 
	 * @param kd
	 * @param overwriteIfExisting
	 *            overwrite existing entries
	 */
	public static Konsultationsdaten persistKonsultationsdaten(
		at.chipkarte.client.kse.soap.Konsultationsdaten kd, boolean overwriteIfExisting){
		boolean newEntity = false;
		Konsultationsdaten ret;
		
		Konsultationsbeleg kb =
			KonsultationsdatenHelper.adaptToLocalKonsultationsbeleg(kd.getKonsultationsBeleg());
		
		Konsultationsdaten kdNeu = null;
		kdNeu = em.find(Konsultationsdaten.class, kb.getId());
		if (kdNeu == null) {
			kdNeu = new Konsultationsdaten();
			newEntity = true;
		}
		ret = kdNeu;
		
		if (newEntity == false) {
			if (!overwriteIfExisting) {
				logger.log("Overwrite of an existing entry deactivated on "
					+ kdNeu.getKonsultationsBeleg().getId(), Log.ERRORS);
				return ret; // We do not overwrite existing entries
			} else {
				logger.log("Overwriting entry " + kdNeu.getKonsultationsBeleg().getId(),
					Log.DEBUGMSG);
			}
		}
		
		em.getTransaction().begin();
		
		if (kd.getAngehoerigenDaten() != null) {
			SVPerson p = PatientHelper.findAndIfNotAvailableAddSVPerson(kd.getAngehoerigenDaten());
			kdNeu.setAngehoerigenDaten(p.storeToString());
		}
		
		kdNeu.setKonsultationsBeleg(kb); // TODO: Overwriting with same not allowed?!?
		
		if (kd.getVersichertenDaten() != null) {
			SVPerson p = PatientHelper.findAndIfNotAvailableAddSVPerson(kd.getVersichertenDaten());
			kdNeu.setVersichertenDaten(p.storeToString());
		}
		
		if (newEntity) {
			em.persist(kdNeu);
		} else {
			ret = em.merge(kdNeu);
		}
		em.getTransaction().commit();
		return ret;
	}
	
	public static Konsultationsbeleg adaptToLocalKonsultationsbeleg(
		at.chipkarte.client.kse.soap.KonsultationsBeleg kb){
		Konsultationsbeleg kbNeu = new Konsultationsbeleg();
		try {
			BeanUtils.copyProperties(kbNeu, kb);
		} catch (IllegalAccessException e) {
			logger.log(e, "Error in BeanUtils.copyProperties()", Log.ERRORS);
		} catch (InvocationTargetException e) {
			logger.log(e, "Error in BeanUtils.copyProperties()", Log.ERRORS);
		}
		// TODO This would be a serious error, as the konsultation is lost?! How to handle?
		return kbNeu;
	}
	
	/**
	 * Get the associated {@link Konsultationsdaten} entry to an existing {@link Konsultationsbeleg}
	 * 
	 * @param kb
	 * @return
	 */
	public static Konsultationsdaten getKonsultationsdatenEntry(Konsultationsbeleg kb){
		Konsultationsdaten k = null;
		k = em.find(Konsultationsdaten.class, kb.getId());
		return k;
	}

	public static Konsultationsbeleg persistKonsultationsbeleg(KonsultationsBeleg kb, boolean overwrite){
		Konsultationsbeleg kbNeu = KonsultationsdatenHelper.adaptToLocalKonsultationsbeleg(kb);
		Konsultationsbeleg kbExisting = em.find(Konsultationsbeleg.class, kbNeu.getId());
		em.getTransaction().begin();
		Konsultationsbeleg kbPers = em.merge(kbNeu);
		em.getTransaction().commit();
		return kbPers;
	}
}
