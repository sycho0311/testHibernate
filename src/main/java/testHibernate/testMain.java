package testHibernate;

import java.util.Date;

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
		
		/*
		Category category1 = new Category();
		category1.setName("Computer");

		Category category2 = new Category();
		category2.setName("Car");
		
		Product product1 = new Product();
		product1.setName("notebook");
		product1.setPrice(1000000);
		product1.setDescription("Awesome notebook");
		product1.setCategory(category1);
		
		category1.getProducts().add(product1); // bidirection

		Product product2 = new Product();
		product2.setName("Desktop");
		product2.setPrice(2000000);
		product2.setDescription("Powerful Desktop");
		product2.setCategory(category1);
		
		category1.getProducts().add(product2); // bidirection
		
		Product product3 = new Product();
		product3.setName("Sonanta");
		product3.setPrice(30000000);
		product3.setDescription("Popular Car");
		product3.setCategory(category2);
		
		category2.getProducts().add(product3);
		*/
		
		Person person1 = new Person();
		person1.setFirstName("Sungyoon");
		person1.setLastName("Cho");
		
		Licence licence1 = new Licence();
		licence1.setLicenceNumber("123456");
		licence1.setIssueDate(new Date());
		licence1.setPerson(person1);
		
		person1.setLicence(licence1);
		
		Person person2 = new Person();
		person2.setFirstName("Alice");
		person2.setLastName("Lee");
		
		Licence licence2 = new Licence();
		licence2.setLicenceNumber("456789");
		licence2.setIssueDate(new Date());
		licence2.setPerson(person2);
		
		person2.setLicence(licence2);
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		// Parent, One save
		session.save(person1);
		session.save(person2);

		// save Product 1, 2, 3 but Cascade product -> category save category 1, 2
		// session.save(product1);
		// session.save(product2);
		// session.save(product3);
		
		// session.delete(category1);
		
		tx.commit();
		session.close();
		
	}
}
