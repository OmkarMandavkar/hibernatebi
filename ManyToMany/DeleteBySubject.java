package ManyToMany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteBySubject {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MANYTOMANYBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Subject subject = em.find(Subject.class, 104);

		if (subject != null) {

			List<Student> student = subject.getStudents();

			for (Student stud : student) {
				stud.setSubjects(null);
				em.merge(stud);
			}

			em.remove(subject);
			et.commit();
			System.out.println("Record Deleted");

		} else {
			System.out.println("No Record Found");
		}
	}

}
