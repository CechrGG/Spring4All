/**
 * @Title: HibernateTest.java
 * @Package: review.database
 * @Description: TODO
 *
 */
package review.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * @author Leslie
 * @version 创建时间：2019年6月12日
 *
 */
public class HibernateTest {

	/**
	 * @author: Leslie
	 * @param args
	 */
	@Test
	public void hibernateTest() {
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		User user = new User("hibernate1", "hibernate123", "2019-06-12 17:00:00");
		Role role = new Role("hibernate", "desc");
		session.save(user);
		session.save(role);
		transaction.commit();
		session.close();
	}

}
