package model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import domain.Employee;
import util.HibernateUtil;

public class EmployeeManager extends HibernateUtil {

	public Employee add(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		return employee;
	}

	public Employee delete(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Employee employee = (Employee) session.load(Employee.class, id);
		if (null != employee) {
			session.delete(employee);
		}
		session.getTransaction().commit();
		return employee;
	}

	public Employee load(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, id);
		session.getTransaction().commit();
		return employee;
	}

	public List<Employee> list() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Employee> employees = null;
		try {
			employees = (List<Employee>) session.createQuery("FROM Employee").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return employees;
	}
}
