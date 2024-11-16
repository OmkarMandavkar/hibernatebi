package ManyToOne;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchRecord {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MANYTOONEBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Department d1 = em.find(Department.class, 1);

		if (d1 != null) {
			//System.out.println("\n--------    Department    --------");
			System.out.println(d1);

			List<Employee> employee = d1.getEmployee();
		
			//System.out.println("\n--------    Employees    --------");
			for (Employee emp : employee) {
				System.out.println(emp);
			}		
		} 
		else {
			System.out.println("No Record Found");
		}
	}
}