package com.portal.daos;



import org.hibernate.SessionFactory;

public class HibernateSession
{
   private SessionFactory sessionFactory;
  
   public SessionFactory getSessionFactory()
   {
      return sessionFactory;
   }

public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}
 
  
}