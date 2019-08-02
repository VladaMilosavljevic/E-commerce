package com.comtrade.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artikal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @OneToMany(mappedBy = "artikal",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RacunStavke>stavke= new ArrayList<RacunStavke>();
    private String naziv;
    private String barKod;
    private double cena;
    private String sifra;
	@Override
	public int hashCode() {
		
		return 31;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artikal other = (Artikal) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public Artikal() {
		super();
	}
	public Artikal( String naziv, String barKod, double cena, String sifra) {
		super();
		
		this.naziv = naziv;
		this.barKod = barKod;
		this.cena = cena;
		this.sifra = sifra;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getBarKod() {
		return barKod;
	}
	public void setBarKod(String barKod) {
		this.barKod = barKod;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
    public void addRacunStavke(RacunStavke racunStavke) {
    	stavke.add(racunStavke);
    	racunStavke.setArtikal(this);
    }
    public void removeRacunStavke(RacunStavke racunStavke) {
    	stavke.remove(racunStavke);
    	racunStavke.setArtikal(null);
    }
	
	
}
