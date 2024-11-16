package OneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteByCountry {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ONETOONEBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Country c1 = em.find(Country.class, 103);

		if (c1 != null) {
			em.remove(c1);
			et.commit();
			System.out.println("Record deleted");
		}
		else {
			System.out.println("No record found");
		}
	}
}
