package com.comtrade.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
@Entity
public class Adresa {
	@Id
	private int id;
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Kupac kupac;
	private String ulica;
	private String ptt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Kupac getKupac() {
		return kupac;
	}
	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getPtt() {
		return ptt;
	}
	public void setPtt(String ptt) {
		this.ptt = ptt;
	}

}
