package com.comtrade.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class RacunStavke {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int kolicina;
	private int redniBrojStavke;
	public Artikal getArtikal() {
		return artikal;
	}
	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_artikla")
	private Artikal artikal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public int getRedniBrojStavke() {
		return redniBrojStavke;
	}
	public void setRedniBrojStavke(int redniBrojStavke) {
		this.redniBrojStavke = redniBrojStavke;
	}
	public Racun getRacun() {
		return racun;
	}
	public void setRacun(Racun racun) {
		this.racun = racun;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_racuna")
	private Racun racun;

}
