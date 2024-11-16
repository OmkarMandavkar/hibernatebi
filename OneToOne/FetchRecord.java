package OneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchRecord {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ONETOONEBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		
		Country c1 = em.find(Country.class, 101);
		
		if(c1!=null) {
			System.out.println("\n\n----    Country    ----");
			System.out.println(c1);	
			
			State s1 = em.find(State.class, 1);
			System.out.println("\n----    State    ----");
			System.out.println(s1);	
		}
		else {
			System.out.println("No Record Found");
		}
	}
}