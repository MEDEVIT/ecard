package at.medevit.elexis.at.ecard.client.kse.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerService {
	private static EntityManagerFactory emf;

	public static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("at.medevit.elexis.at.ecard.client.kse.model.annotated");
		}
		return emf.createEntityManager();
	}
}
