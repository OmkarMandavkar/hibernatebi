package ManyToMany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchBySubject {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MANYTOMANYBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Subject subject = em.find(Subject.class, 104);

		if (subject != null) {
			System.out.println("\n--------    Subject    --------");
			System.out.println(subject);

			List<Student> students = subject.getStudents();

			System.out.println("\n--------    Students    --------");

			for (Student stud : students) {
				System.out.println(stud);
			}

		} else {
			System.out.println("No Record Found");
		}
	}
}
