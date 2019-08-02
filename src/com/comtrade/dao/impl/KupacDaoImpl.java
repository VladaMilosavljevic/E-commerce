package com.comtrade.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.comtrade.dao.KupacDao;
import com.comtrade.entity.Adresa;
import com.comtrade.entity.Kupac;
import com.comtrade.util.HibernateUtil;

public class KupacDaoImpl  implements KupacDao{
     @Override
	public void insertKupac(Adresa adresa) {
	
    	 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
 		session.beginTransaction();
 		session.save(adresa);
 		session.getTransaction().commit();
 	
	}

	@Override
	public List<Kupac> getListaKupaca() {
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		 Query query = session.createQuery("from Kupac");
		 List<Kupac>listaKupaca=query.getResultList();
			session.getTransaction().commit();
		return listaKupaca;
	}

	@Override
	public void update(Kupac kupac) {
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		 session.update(kupac);
		 session.getTransaction().commit();
	 	
		 
		
	}

	@Override
	public void delete(Kupac kupac) {
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		 session.delete(kupac);
		 session.getTransaction().commit();
		
	}

}
