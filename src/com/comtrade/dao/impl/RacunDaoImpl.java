package com.comtrade.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.comtrade.dao.RacunDAO;
import com.comtrade.entity.Racun;
import com.comtrade.util.HibernateUtil;

public class RacunDaoImpl implements RacunDAO {

	@Override
	public List<Racun> vratiRacune() {
		
		return null;
	}

	@Override
	public int brojRacuna() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Racun racun = session.createNativeQuery("select  * from Racun order by brojRacuna DESC  LIMIT 1",Racun.class).getSingleResult();
		int brojRacuna = 0;
	
		try {
		
		 brojRacuna=Integer.parseInt(racun.getBrojRacuna());
		}	catch (Exception e) {
			brojRacuna = 0;
		}
	  session.getTransaction().commit();
		return brojRacuna;
	}

	@Override
	public void insert(Racun racun) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.persist(racun);
	    session.getTransaction().commit();
	}
	

}
