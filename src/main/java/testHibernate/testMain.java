package testHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class testMain {

	private static SessionFactory sessionFactory;
	
	public static void main(String [] args) {
		
		/*Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		sessionFactory = conf.buildSessionFactory();*/
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Product product = new Product();
		product.setName("notebook");
		product.setPrice(1000000);
		product.setDescription("Awesome notebook");
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(product);
		
		tx.commit();
		session.close();
		
	}
}
