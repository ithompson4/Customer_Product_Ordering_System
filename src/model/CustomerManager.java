package model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import domain.Customer;
import util.HibernateUtil;

public class CustomerManager extends HibernateUtil {

	public Customer add(Customer customer) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
		return customer;
	}

	public Customer delete(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Customer customer = (Customer) session.load(Customer.class, id);
		if (null != customer) {
			session.delete(customer);
		}
		session.getTransaction().commit();
		return customer;
	}

	public Customer load(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, id);
		session.getTransaction().commit();
		return customer;
	}

	public List<Customer> list() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Customer> customers = null;
		try {
			customers = (List<Customer>) session.createQuery("FROM Customer").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return customers;
	}
}
