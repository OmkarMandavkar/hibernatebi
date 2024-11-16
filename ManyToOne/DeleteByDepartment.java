package ManyToOne;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteByDepartment {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MANYTOONEBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Department d1 = em.find(Department.class, 2);

		if (d1 != null) {

			List<Employee> employee = d1.getEmployee();

			for (Employee emp : employee) {
				emp.setDepartment(null);
				em.merge(emp);
			}

			em.remove(d1);
			et.commit();
			System.out.println("Record Deleted");
		} 
		else {
			System.out.println("No Record Found");
		}
	}
}