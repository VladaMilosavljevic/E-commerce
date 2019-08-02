package com.comtrade.servis.impl;

import java.util.List;

import com.comtrade.dao.RacunDAO;
import com.comtrade.dao.impl.RacunDaoImpl;
import com.comtrade.entity.Racun;
import com.comtrade.servis.RacunServis;

public class RacunServisImpl implements RacunServis {

	@Override
	public List<Racun> vratiRacune() {
		
		return null;
	}

	@Override
	public int brojRacuna() {
	RacunDAO racunDAO = new RacunDaoImpl();
	
		return racunDAO.brojRacuna();
	}

	@Override
	public void insertRacun(Racun racun) {
		RacunDAO racunDAO = new RacunDaoImpl();
		racunDAO.insert(racun);
		
	}

}
