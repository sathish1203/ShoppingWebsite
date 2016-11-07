package DAOs;  
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.springframework.orm.hibernate3.*;
import models.Employee;  
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
	List<Employee> users = null;
	
	try{
		
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class).add(Restrictions.eq("uname", uname));
		users = (List<Employee>)criteria.list();
		tx.commit();
	}catch(Exception e){e.printStackTrace();}
	
	
    return users;	
	
}



HibernateTemplate template;  
public void setTemplate(HibernateTemplate template) {  
    this.template = template;  
}  
//method to save employee  
public void saveEmployee(Employee e){  
    template.save(e);  
}  
//method to update employee  
public void updateEmployee(Employee e){  
    template.update(e);  
}  
//method to delete employee  
public void deleteEmployee(Employee e){  
    template.delete(e);  
}  
//method to return one employee of given id  
public Employee getByUname(String uname){  
    Employee e=(Employee)template.get(Employee.class,uname);  
    return e;  
}  
//method to return all employees  
public List<Employee> getEmployees(){  
    List<Employee> list=new ArrayList<Employee>();  
    list=template.loadAll(Employee.class);  
    return list;  
}  
}  