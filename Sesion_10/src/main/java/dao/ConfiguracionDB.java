package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Conection.HibernateManager;
import dao.pojos.Configuracion;

public class ConfiguracionDB {
	
	//Métodos
	public static List<Configuracion> getConfiguracion(String query) {
		if(query.equals("")) {
			query = "FROM Configuracion";
		}
		Session session = HibernateManager.getSessionFactory().openSession();
		List<Configuracion> objs = null;
		try {
			objs = (List<Configuracion>)session.createQuery(query).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return objs;
	}
	
	public static void update(Configuracion obj) {
		Session session = HibernateManager.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(obj);
		tx.commit();
		session.close();
	}
	
	
	public static void update(ArrayList<Configuracion> obj) {
		
		
		for (Configuracion c : obj) {
			Session session = HibernateManager.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.update(c);
			tx.commit();
			session.close();
		}
		
	}
	

	public static void create(Configuracion obj) {
		Session session = HibernateManager.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(obj);
		tx.commit();
		session.close();
	}
}
