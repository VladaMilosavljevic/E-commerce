package com.comtrade.kontrolerPL;

import com.comtrade.entity.Artikal;
import com.comtrade.servis.ArtikalServis;
import com.comtrade.servis.impl.ArtikalServisImpl;

public class ArtikalKontroler {

	
	public void insertArtikal(Artikal artikal) {
		ArtikalServis artikalServis = new ArtikalServisImpl();
		artikalServis.insertArtikal(artikal);
	}

	public void deleteArtikal(Artikal artikal) {
		ArtikalServis artikalServis = new ArtikalServisImpl();
		artikalServis.deleteArtikal(artikal);
	}

	public void updateArtikal(Artikal artikal) {
		ArtikalServis artikalServis = new ArtikalServisImpl();
		artikalServis.updateArtikal(artikal);
	}
}
