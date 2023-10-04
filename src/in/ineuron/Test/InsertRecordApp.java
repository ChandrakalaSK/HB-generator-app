package in.ineuron.Test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Student;
import in.ineuron.Util.HibernateMySqlUtil;
import in.ineuron.Util.HibernateUtil;

public class InsertRecordApp {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		boolean flag = false;
		String id=null;
		try {
		session=HibernateMySqlUtil.geSession();
		
		if(session !=null)
		{
			transaction = session.beginTransaction();
			if(transaction != null)
			{
				Student student=new Student();
				student.setSaddress("MI");
				student.setSage(30);
				student.setSname("Rohit");
				id=(String) session.save(student);
				flag=true;
				
			}
			
		}
		}catch (HibernateException e) {
			e.printStackTrace();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			if(flag) {
				transaction.commit();
			System.out.println("Object inserted into to database id ::" + id);
			
			}
			else {
				transaction.rollback();
				System.out.println("Object not  inserted into to database");
			
			}
			HibernateMySqlUtil.closeSession(session);
			HibernateMySqlUtil.closeSessionFactory();
		}

	}

}
