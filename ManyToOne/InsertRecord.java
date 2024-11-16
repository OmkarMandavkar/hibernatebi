package ManyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertRecord {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MANYTOONEBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
	
		Department d1 = new Department();
		d1.setId(1);
		d1.setDname("Dev");
		d1.setStrength(20);
		
		Department d2 = new Department();
		d2.setId(2);
		d2.setDname("Testing");
		d2.setStrength(10);
		
		Employee e1 = new Employee();
		e1.setEid(101);
		e1.setName("Omkar");
		e1.setYOJ(2023);
		e1.setDepartment(d1);
		
		Employee e2 = new Employee();
		e2.setEid(102);
		e2.setName("Zeus");
		e2.setYOJ(2024);
		e2.setDepartment(d1);
		
		Employee e3 = new Employee();
		e3.setEid(103);
		e3.setName("Krypto");
		e3.setYOJ(2022);
		e3.setDepartment(d2);


//		d1.setEmployee(Arrays.asList(e1));
//		d2.setEmployee(Arrays.asList(e2, e3));		
		
		em.persist(d1);
		em.persist(d2);
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		
		et.commit();
		
		System.out.println("Records Saved");
		
		
	}
}