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
public class Kupac {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_kupca;
	private String ime;
	private String pib;
	@OneToMany(mappedBy = "kupac" ,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Racun>list = new ArrayList<Racun>();
	public int getId_kupca() {
		return id_kupca;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public void setId_kupca(int id_kupca) {
		this.id_kupca = id_kupca;
	}
	

	public String getPib() {
		return pib;
	}
	public void setPib(String pib) {
		this.pib = pib;
	}
	public void addRacun(Racun racun) {
		
		list.add(racun);
		racun.setKupac(this);
	}
	
	public void removeRacun(Racun racun) {
		list.remove(racun);
		racun.setKupac(null);
	}

	
}
