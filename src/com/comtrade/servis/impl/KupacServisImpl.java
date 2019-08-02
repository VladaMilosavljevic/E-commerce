package com.comtrade.servis.impl;

import java.util.List;

import com.comtrade.dao.KupacDao;
import com.comtrade.dao.impl.KupacDaoImpl;
import com.comtrade.entity.Adresa;
import com.comtrade.entity.Kupac;
import com.comtrade.servis.KupacServis;

public class KupacServisImpl implements KupacServis{
	@Override
	public void insertKupac(Adresa adresa) {
		KupacDao kupacDao = new KupacDaoImpl();
		kupacDao.insertKupac(adresa);
		
	}

	@Override
	public List<Kupac> getListaKupaca() {
	 KupacDao kupacDao = new KupacDaoImpl();
	
		return  kupacDao.getListaKupaca();
	}

	@Override
	public void updateKupca(Kupac kupac) {
		KupacDao kupacDao = new KupacDaoImpl();
		kupacDao.update(kupac);
		
	}

	@Override
	public void deleteKupac(Kupac kupac) {
		KupacDao kupacDao = new KupacDaoImpl();
		kupacDao.delete(kupac);
		
	}

}
