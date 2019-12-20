package model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import domain.Product;
import util.HibernateUtil;

public class ProductManager extends HibernateUtil {

	public Product add(Product product) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		return product;
	}

	public Product delete(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Product product = (Product) session.load(Product.class, id);
		if (null != product) {
			session.delete(product);
		}
		session.getTransaction().commit();
		return product;
	}

	public Product load(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Product product = (Product) session.get(Product.class, id);
		session.getTransaction().commit();
		return product;
	}

	public List<Product> list() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Product> products = null;
		try {
			products = (List<Product>) session.createQuery("FROM Product").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return products;
	}
}
