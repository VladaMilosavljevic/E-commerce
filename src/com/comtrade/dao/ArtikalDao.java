package com.comtrade.dao;

import java.util.List;

import com.comtrade.entity.Artikal;

public interface ArtikalDao {
public void insertArtikal(Artikal artikal);

public List<Artikal> getListaArtikala();

public void deleteArtikal(Artikal artikal);

public void updateArtikal(Artikal artikal);
}
