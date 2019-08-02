package com.comtrade.dao;

import java.util.List;

import com.comtrade.entity.Racun;

public interface RacunDAO {
	public List<Racun>vratiRacune();
	public int brojRacuna();
	public void insert(Racun racun);

}
