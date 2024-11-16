package OneToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertRecord {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ONETOMANYBI");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Family f1 = new Family();
		f1.setFid(01);
		f1.setFname("Royal Family of Saudi");
		f1.setCountmember(15);

		Family f2 = new Family();
		f2.setFid(02);
		f2.setFname("Royal Family of Qatar");
		f2.setCountmember(10);

		Car c1 = new Car();
		c1.setCid(101);
		c1.setCname("Pagani");
		c1.setFamily(f1);
		
		Car c2 = new Car();
		c2.setCid(102);
		c2.setCname("Koenigsegg");
		c2.setFamily(f2);

		Car c3 = new Car();
		c3.setCid(103);
		c3.setCname("Maserati");
		c3.setFamily(f1);

		Car c4 = new Car();
		c4.setCid(104);
		c4.setCname("Buggati");
		c4.setFamily(f1);
		
		Car c5 = new Car();
		c5.setCid(105);
		c5.setCname("McLaren");
		c5.setFamily(f1);

//		f1.setCar(Arrays.asList(c1, c2, c5));
//
//		f2.setCar(Arrays.asList(c3, c4, c5));
		
		em.persist(f1);
		em.persist(f2);
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		em.persist(c5);
		et.commit();
		System.out.println("Records Added");
		
	}

}
