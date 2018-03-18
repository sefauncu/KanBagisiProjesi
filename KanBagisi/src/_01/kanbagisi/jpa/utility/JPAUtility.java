package _01.kanbagisi.jpa.utility;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtility {

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("BagisciPersistenceUnit");

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

}
