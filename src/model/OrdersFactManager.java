package model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import domain.OrdersFact;
import domain.OrdersFactId;
import domain.Ttime;
import util.HibernateUtil;

public class OrdersFactManager extends HibernateUtil {

	public OrdersFact add(OrdersFact ordersFact) {

		// saving the ttime
		TtimeManager mngr = new TtimeManager();
		List<OrdersFact> list = search(ordersFact);
		if (list.size() != 0)
			return null;
		Ttime t = mngr.add();
		ordersFact.setTtime(t);
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(ordersFact);
		session.getTransaction().commit();
		return ordersFact;
	}

	public OrdersFact update(OrdersFact ordersFact) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(ordersFact);
		session.getTransaction().commit();
		return ordersFact;
	}

	public OrdersFact load(OrdersFactId id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		OrdersFact ordersFact = (OrdersFact) session.get(OrdersFact.class, id);
		session.getTransaction().commit();
		return ordersFact;
	}

	public List<OrdersFact> search(OrdersFact fact) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Criteria cr = session.createCriteria(OrdersFact.class);
		cr.add(Restrictions.eq("customer", fact.getCustomer()));
		cr.add(Restrictions.eq("supplier", fact.getSupplier()));
		cr.add(Restrictions.eq("employee", fact.getEmployee()));
		cr.add(Restrictions.eq("product", fact.getProduct()));

		List<OrdersFact> ordersFacts = null;
		try {
			ordersFacts = (List<OrdersFact>) cr.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return ordersFacts;
	}

	public List<OrdersFact> list() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<OrdersFact> ordersFacts = null;
		try {
			ordersFacts = (List<OrdersFact>) session.createQuery("FROM OrdersFact").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return ordersFacts;
	}
}
