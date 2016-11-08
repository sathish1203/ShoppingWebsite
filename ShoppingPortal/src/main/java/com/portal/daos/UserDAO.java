package com.portal.daos;  
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.portal.models.User;

public class UserDAO extends HibernateSession{
	SessionFactory mySessionFactory;
	
public UserDAO(SessionFactory mySessionFactory){
	new Configuration().configure();
	this.mySessionFactory = mySessionFactory;
	
}
	
public List getUserByUname(String uname)
{
	Session session = mySessionFactory.openSession();
    session.beginTransaction();
	
    User user_sathishtest = new User();
    user_sathishtest.setFirstname("Sathish_test");
    user_sathishtest.setLastname("Sathish_test");
    user_sathishtest.setUname("Sathish_test_11");
    user_sathishtest.setPassword("Sathish_test");
    user_sathishtest.setEnabled(true);
    
    session.save(user_sathishtest);
    session.getTransaction().commit();
    
    session.beginTransaction();
    Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("uname", uname));
	List<User> users = (List<User>)criteria.list();
	session.getTransaction().commit();
	session.close();
    return users;
    	
}



//method to return all employees  

}  