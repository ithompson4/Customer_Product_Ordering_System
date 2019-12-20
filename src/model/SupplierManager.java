package model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import domain.Supplier;
import util.HibernateUtil;

public class SupplierManager extends HibernateUtil {

	public Supplier add(Supplier supplier) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(supplier);
		session.getTransaction().commit();
		return supplier;
	}

	public Supplier delete(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Supplier supplier = (Supplier) session.load(Supplier.class, id);
		if (null != supplier) {
			session.delete(supplier);
		}
		session.getTransaction().commit();
		return supplier;
	}

	public Supplier load(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Supplier supplier = (Supplier) session.get(Supplier.class, id);
		session.getTransaction().commit();
		return supplier;
	}

	public List<Supplier> list() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Supplier> suppliers = null;
		try {
			suppliers = (List<Supplier>) session.createQuery("FROM Supplier").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return suppliers;
	}
}
