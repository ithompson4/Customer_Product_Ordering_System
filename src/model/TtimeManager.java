package model;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import domain.Ttime;
import util.HibernateUtil;

public class TtimeManager extends HibernateUtil {

	public Ttime add() {
		Ttime ttime = new Ttime();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		ttime.setTdate(new Date());
		session.beginTransaction();
		session.save(ttime);
		session.getTransaction().commit();
		
		return ttime;
	}
	public Ttime delete(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Ttime ttime = (Ttime) session.load(Ttime.class, id);
		if(null != ttime) {
			session.delete(ttime);
		}
		session.getTransaction().commit();
		return ttime;
	}

	public List<Ttime> list() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Ttime> ttimes = null;
		try {			
			ttimes = (List<Ttime>)session.createQuery("FROM Ttime").list();			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return ttimes;
	}
}
