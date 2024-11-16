package OneToMany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchRecord {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ONETOMANYBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Family f1 = em.find(Family.class, 2);

		if (f1 != null) {
			System.out.println("----    Family    ----");
			f1.getFid();
			f1.getFname();
			f1.getCountmember();

			List<Car> car = f1.getCar();
			System.out.println("----    Car    ----");

			for (Car c1 : car) {
				System.out.println(c1);
			}

		} else {
			System.out.println("No Records Found");
		}
	}

}
