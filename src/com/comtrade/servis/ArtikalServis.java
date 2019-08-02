package com.comtrade.servis;

import java.util.List;

import com.comtrade.entity.Artikal;

public interface ArtikalServis {
 public void insertArtikal(Artikal artikal);

public List<Artikal>getListArtikala();

public void deleteArtikal(Artikal artikal);

public void updateArtikal(Artikal artikal);
}
