package com.comtrade.dao;

import java.util.List;

import com.comtrade.entity.Adresa;
import com.comtrade.entity.Kupac;

public interface KupacDao {
	

	public void insertKupac(Adresa adresa);

	public List<Kupac> getListaKupaca();

	public void update(Kupac kupac);

	public void delete(Kupac kupac);

}
