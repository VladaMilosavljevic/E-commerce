package com.comtrade.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.comtrade.entity.Adresa;
import com.comtrade.entity.Artikal;
import com.comtrade.entity.Kupac;
import com.comtrade.entity.Racun;
import com.comtrade.entity.RacunStavke;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory= new Configuration().configure("hibernate.cfg.xml").
			addAnnotatedClass(Artikal.class).
			addAnnotatedClass(Kupac.class).
			addAnnotatedClass(Racun.class).
			addAnnotatedClass(Adresa.class).
			addAnnotatedClass(RacunStavke.class).buildSessionFactory();

	public static SessionFactory getFactory() {
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}
}

