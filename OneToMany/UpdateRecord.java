package OneToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateRecord {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ONETOMANYBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Family family = em.find(Family.class, 1);
		Family family2 = em.find(Family.class, 2);
		
		if (family != null) {
			System.out.println("Old Record: " + family);
			
			Car car = em.find(Car.class, 103);
			if (car != null) {
				car.setCname("Chevrolet");
				car.setFamily(family2);
				em.merge(car);
			}
			em.merge(family);
			
			System.out.println("New Records: " + family);
			et.commit();
			System.out.println("Record Updated");

		} else {
			System.out.println("No Record Found");
		}

		et.begin();
	}
}
