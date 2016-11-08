package DAOs;  
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;

import models.User;  
public class UserDAO{
	
private SessionFactory sessionFactory;

public void setSessionFactory(SessionFactory sessionFactory)
{
this.sessionFactory = sessionFactory;	
}
	
public UserDAO() {
Configuration configuration = new Configuration().configure();
	
}	
	
public List getUserByUname(String uname)
{
	List<User> users = null;
	
	try{
		
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("uname", uname));
		users = (List<User>)criteria.list();
		tx.commit();
	}catch(Exception e){e.printStackTrace();}
	
	
    return users;	
	
}



//method to return all employees  

}  