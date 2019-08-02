package com.comtrade.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NaturalId;

@Entity
public class Racun {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_racuna;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_kupca")
	private Kupac kupac;
	@NaturalId
	private String brojRacuna;
	@Temporal(TemporalType.DATE)
	private Date date;
	@OneToMany(mappedBy = "racun",cascade = CascadeType.ALL,orphanRemoval = true)
	private  List<RacunStavke> listStavke = new ArrayList<RacunStavke>();
	public int getId_racuna() {
		return id_racuna;
	}

	public void setId_racuna(int id_racuna) {
		this.id_racuna = id_racuna;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public Kupac getKupac() {
		return kupac;
	}

	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}
	public void addRacunStavke(RacunStavke racunStavke) {   //metoda za sinhronizaciju
		listStavke.add(racunStavke);
		racunStavke.setRacun(this);
	}
	public void remove (RacunStavke racunStavke) {
		listStavke.remove(racunStavke);
		racunStavke.setRacun(null);
	}
}
