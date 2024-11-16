package ManyToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateRecord {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MANYTOMANYBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Student s1 = em.find(Student.class, 1);

		if (s1 != null) {

			s1.setName("Dummy");
			em.merge(s1);

			Subject subject = em.find(Subject.class, 103);
			if (subject != null) {
				subject.setName("JDBC");
				em.merge(subject);
				System.out.println("Subject Updated");
			}

			em.merge(s1);
			et.commit();
			System.out.println("Record Updated");
		} 
		else {
			System.out.println("No record found");
		}
	}

}
