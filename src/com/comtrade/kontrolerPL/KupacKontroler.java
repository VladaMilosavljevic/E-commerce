package com.comtrade.kontrolerPL;

import com.comtrade.entity.Adresa;
import com.comtrade.entity.Kupac;
import com.comtrade.servis.KupacServis;
import com.comtrade.servis.impl.KupacServisImpl;

public class KupacKontroler {
	public void insertKupac(Adresa adresa) {
		KupacServis kupacServis = new KupacServisImpl();
		kupacServis.insertKupac(adresa);
	}

}
