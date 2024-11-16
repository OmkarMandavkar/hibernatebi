package OneToMany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteByFamily {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ONETOMANYBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Family f1 = em.find(Family.class, 2);

		if (f1 != null) {
			List<Car> cars = f1.getCar();

			for (Car car : cars) {
				car.setFamily(null);
				em.merge(car);
			}

			em.remove(f1);
			et.commit();
			System.out.println("Record Deleted");

		} else {
			System.out.println("No Records Found");
		}
	}

}
