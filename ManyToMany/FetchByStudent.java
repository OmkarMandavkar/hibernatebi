package ManyToMany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchByStudent {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MANYTOMANYBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Student student = em.find(Student.class, 2);

		if (student != null) {
			System.out.println("\n--------    Student    --------");
			System.out.println(student);

			List<Subject> subject = student.getSubjects();
			
			System.out.println("\n--------    Subject    --------");
			
			for (Subject sub : subject) {
				System.out.println(sub);
			}

		} else {
			System.out.println("No Record Found");
		}
	}
}