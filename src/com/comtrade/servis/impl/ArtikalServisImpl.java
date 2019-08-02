package com.comtrade.servis.impl;

import java.util.List;

import com.comtrade.dao.ArtikalDao;
import com.comtrade.dao.impl.ArtikalDaoImpl;
import com.comtrade.entity.Artikal;
import com.comtrade.servis.ArtikalServis;

public class ArtikalServisImpl  implements ArtikalServis{

	@Override
	public void insertArtikal(Artikal artikal) {
	ArtikalDao artikalDao = new ArtikalDaoImpl();
	artikalDao.insertArtikal(artikal);
	}

	@Override
	public List<Artikal> getListArtikala() {
		ArtikalDao artikalDao = new ArtikalDaoImpl();
		return artikalDao.getListaArtikala();
	}

	@Override
	public void deleteArtikal(Artikal artikal) {
		ArtikalDao artikalDao = new ArtikalDaoImpl();
		artikalDao.deleteArtikal(artikal);
		
	}

	@Override
	public void updateArtikal(Artikal artikal) {
		ArtikalDao artikalDao = new ArtikalDaoImpl();
		artikalDao.updateArtikal(artikal);
		
	}

}
