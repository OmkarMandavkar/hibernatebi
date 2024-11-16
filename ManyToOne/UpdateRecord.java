package ManyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateRecord {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MANYTOONEBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Department d1 = em.find(Department.class, 1);

		if (d1 != null) {

			d1.setDname("DevOps");
			em.merge(d1);

			Employee e1 = em.find(Employee.class, 102);
			if (e1 != null) {
				e1.setName("Poseidon");
				em.merge(e1);
				System.out.println("Employee Record Updated");
			}

			et.commit();
			System.out.println("Record Updated");

		} else {
			System.out.println("No Record Found");
		}
	}
}