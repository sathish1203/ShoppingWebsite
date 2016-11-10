package com.portal.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.portal.daos.HibernateSession;
import com.portal.daos.UserDAO;
import com.portal.daos.modelDaos.userAccess;
import com.portal.models.User;



public class App {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring_Module.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		HibernateSession db_session = (HibernateSession) context.getBean("h2_db_01");
		obj.printHello();
		
	    userAccess userAcc = new userAccess(db_session.getSessionFactory());
		List<User> users = new ArrayList<User>();
		users= userAcc.getUsers();
		
		System.out.println("User is"+users);
		for (User user:users)
		{
			System.out.println("User is "+ user.getUname());
			System.out.println("Last name is "+ user.getLastname());
			
		}
		
		((AbstractApplicationContext) context).close();
	}
}