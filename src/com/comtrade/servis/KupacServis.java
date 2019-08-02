package com.comtrade.servis;

import java.util.List;

import com.comtrade.entity.Adresa;
import com.comtrade.entity.Kupac;

public interface KupacServis {
	public void insertKupac(Adresa adresa);

	public List<Kupac> getListaKupaca();

	public void updateKupca(Kupac kupac);

	public void deleteKupac(Kupac kupac);

}
