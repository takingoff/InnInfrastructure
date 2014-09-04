/**
 * projectName: InnInfrastructure
 * 
 * fileName: UtilTest.java
 * 
 * author : tangli <tanglidehaizi@gamil.com>
 * 
 * createTime :2014 2014-4-8 下午10:57:45
 * 
 * version : V1.0
 * 
 */
package tang.li.inn.infrastructure.util;

import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import tang.li.inn.entity.staff.Staff;

/**
 *<description>
 *@author tangli <tanglidehaizi@gamil.com>
 *@version V1.0 
 *@see 
 *@since
*/
public class UtilTest extends TestCase
{

	@Test
	public void testConnection()
	{
		@SuppressWarnings("deprecation")
//		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		SessionFactory sf = new Configuration().addAnnotatedClass(Staff.class).configure().buildSessionFactory();
		
		Session s = sf.openSession();
		
//		Transaction tx = s.beginTransaction();
		Staff m = new Staff();
		m.setName("mmmm");
		m.setPassword("ssss");
		m.setLevel(1);
		
		s.save(m);
		s.flush();
//		tx.commit();
		
		@SuppressWarnings("unchecked")
		List<Staff> list =  s.createQuery("from Staff ").list();
		for(int i= 0 ;i < list.size(); i ++  )
			System.out.println(list.get(i).getName());
		
		s.close();
		sf.close();
	}
	
	
	@Override
	protected void setUp() throws Exception
	{
		System.out.println("setUp");
		super.setUp();
	}
	
	
	@Override
	protected void tearDown() throws Exception
	{
		System.out.println("tearDown");
		super.tearDown();
	}

}
