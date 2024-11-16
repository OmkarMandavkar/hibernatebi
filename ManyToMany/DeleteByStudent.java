package ManyToMany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteByStudent {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MANYTOMANYBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Student student = em.find(Student.class, 3);

		if (student != null) {

			List<Subject> subject = student.getSubjects();

			for (Subject sub : subject) {
				sub.setStudents(null);
				em.merge(sub);
			}
			
			em.remove(student);
			et.commit();
			System.out.println("Record Deleted");
			
		} else {
			System.out.println("No Record Found");
		}
	}

}
