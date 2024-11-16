package ManyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteByEmployee {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MANYTOONEBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Employee e1 = em.find(Employee.class, 103);

		if (e1 != null) {
			em.remove(e1);
			et.commit();
			System.out.println("Record Deleted");

		} else {
			System.out.println("No Record Found");
		}
	}
}
