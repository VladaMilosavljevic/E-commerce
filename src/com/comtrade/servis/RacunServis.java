package com.comtrade.servis;

import java.util.List;

import com.comtrade.entity.Racun;

public interface RacunServis {
public List<Racun>vratiRacune();
public int brojRacuna();
public void insertRacun(Racun racun);
}
