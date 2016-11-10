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

public List<User> getUsers(){
	List<User> users=null;
	try{
	Session session = mySessionFactory.openSession();
    session.beginTransaction();
    Criteria criteria = session.createCriteria(User.class);
    users= (List<User>)criteria.list();
    session.getTransaction().commit();
    session.close();
	}catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return users;
}

public User getUserByUsername(String uname){
	User user=null;
	try{
	Session session = mySessionFactory.openSession();
    session.beginTransaction();
    Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("uname", uname));
	user = (User)criteria.uniqueResult();
    session.getTransaction().commit();
    session.close();
	}catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return user;
}


public boolean addUser(User u){
	boolean commit = false;
	try{
	Session session = mySessionFactory.openSession();
    session.beginTransaction();
    session.save(u);
    session.getTransaction().commit();
    session.close();
    commit = true;
	}catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return commit;
}


public boolean UpdateUser(User u){
	boolean commit = false;
	try{
	Session session = mySessionFactory.openSession();
    session.beginTransaction();
    session.update(u);
    session.getTransaction().commit();
    session.close();
    commit = true;
	}catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return commit;
}


public boolean RemoveUser(User u){
	boolean commit = false;
	try{
	Session session = mySessionFactory.openSession();
    session.beginTransaction();
    session.remove(u);
    session.getTransaction().commit();
    session.close();
	commit = true;
	}catch(Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return commit;
}


}  