package OneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteByState {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ONETOONEBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		State s1 = em.find(State.class, 3);

		if (s1 != null) {
			
			Country c1 =em.find(Country.class, 103);
			c1.setState(null);
			em.merge(c1);
			
			em.remove(s1);

			et.commit();
			System.out.println("Record Deleted");
		} else {
			System.out.println("No Record Found");
		}
	}
}
