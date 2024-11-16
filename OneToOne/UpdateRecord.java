package OneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateRecord {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ONETOONEBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Country c1 = em.find(Country.class, 103);

		if (c1 != null) {

			System.out.println("Previous record: " + c1);

			c1.setContinent("Antartica");

			State s1 = c1.getState();
			if (s1 != null) {
				s1.setName("Malaysia");
				em.merge(s1);
			}

			em.merge(c1);

			System.out.println("New Records: " + c1);
			et.commit();
			
			
			System.out.println("Records Updated");
		}
		else {
			System.out.println("No Record Found");
		}
	}
}