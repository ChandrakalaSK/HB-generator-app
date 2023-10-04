package in.ineuron.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.Model.Student;

public class HibernateMySqlUtil {
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	
	public HibernateMySqlUtil() {
		
	}
	static {
		sessionFactory = new Configuration().configure("in/ineuron/cfg/mysql-hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
	}

	public static Session geSession()
	{
		if(session == null)
			session = sessionFactory.openSession();
		return session;
	}
	public static void closeSession(Session session)
	{
		if(session != null)
			session.close();
	}
	public static void closeSessionFactory()
	{
		if(sessionFactory != null)
		sessionFactory.close();
	}
}
