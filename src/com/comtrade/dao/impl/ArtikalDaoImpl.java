package com.comtrade.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.comtrade.dao.ArtikalDao;
import com.comtrade.entity.Artikal;
import com.comtrade.util.HibernateUtil;


public class ArtikalDaoImpl  implements ArtikalDao{

	@Override
	public void insertArtikal(Artikal artikal) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(artikal);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public List<Artikal> getListaArtikala() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Artikal");
		List<Artikal>list=query.getResultList();
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	@Override
	public void deleteArtikal(Artikal artikal) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(artikal);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateArtikal(Artikal artikal) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(artikal);
		session.getTransaction().commit();
		session.close();
	}


}
