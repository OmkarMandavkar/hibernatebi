package OneToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteByCar {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ONETOMANYBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Car c1 = em.find(Car.class, 105);

		if (c1 != null) {

			em.remove(c1);
			et.commit();
			System.out.println("Record Deleted");

		} else {
			System.out.println("No Record Found");
		}
	}
}
