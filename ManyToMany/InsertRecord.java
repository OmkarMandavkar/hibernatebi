package ManyToMany;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertRecord {

	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MANYTOMANYBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Student s1 = new Student();
		s1.setId(1);
		s1.setName("Zeus");

		Student s2 = new Student();
		s2.setId(2);
		s2.setName("Posedion");

		Student s3 = new Student();
		s3.setId(3);
		s3.setName("Krypto");

		Subject x1 = new Subject();
		x1.setId(101);
		x1.setName("Java");

		Subject x2 = new Subject();
		x2.setId(102);
		x2.setName("Sql");

		Subject x3 = new Subject();
		x3.setId(103);
		x3.setName("Spring");

		Subject x4 = new Subject();
		x4.setId(104);
		x4.setName("Hibernate");

		s1.setSubjects(Arrays.asList(x1, x2));
		s2.setSubjects(Arrays.asList(x1, x3, x4));
		s3.setSubjects(Arrays.asList(x4));

		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(x1);
		em.persist(x2);
		em.persist(x3);
		em.persist(x4);

		et.commit();
		System.out.println("Records Saved");
	}

}
