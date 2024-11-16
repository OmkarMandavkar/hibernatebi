package OneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertRecord {

	public static void main(String[] args) {

		EntityManagerFactory emf =  Persistence.createEntityManagerFactory("ONETOONEBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Country c1 = new Country();
		c1.setCid(101);
		c1.setName("Brazil");
		c1.setContinent("South America");
		
		Country c2 = new Country();
		c2.setCid(102);
		c2.setName("Bali");
		c2.setContinent("Asia");
		
		Country c3 = new Country();
		c3.setCid(103);
		c3.setName("Japan");
		c3.setContinent("Asia");
		
		State s1 = new State();
		s1.setSid(01);
		s1.setName("Peru");
		c1.setState(s1);
		
		State s2 = new State();
		s2.setSid(02);
		s2.setName("Denpasar");
		c2.setState(s2);
		
		State s3 = new State();
		s3.setSid(03);
		s3.setName("Tokyo");
		c3.setState(s3);
		
		
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		
		et.commit();
		
		System.out.println("Records Added");
		
				
	}

}
