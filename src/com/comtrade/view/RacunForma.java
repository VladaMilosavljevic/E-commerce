package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.entity.Artikal;
import com.comtrade.entity.Kupac;
import com.comtrade.entity.Racun;
import com.comtrade.entity.RacunStavke;
import com.comtrade.servis.ArtikalServis;
import com.comtrade.servis.KupacServis;
import com.comtrade.servis.RacunServis;
import com.comtrade.servis.impl.ArtikalServisImpl;
import com.comtrade.servis.impl.KupacServisImpl;
import com.comtrade.servis.impl.RacunServisImpl;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class RacunForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfBroj;
	private JTextField tfKolicina;
	private JTable table;
	private JComboBox cbKupac,cbArtikal;
	private int brojRacuna =1;
	private Kupac kupac1;
	private List<RacunStavke>stavke= new ArrayList<RacunStavke>();
	private Artikal artikal;
	private DefaultTableModel dtm = new DefaultTableModel();
	private int redniBrojStavke =0 ;
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public RacunForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 cbKupac = new JComboBox();
		 cbKupac.addActionListener(new ActionListener() {
		
		 	public void actionPerformed(ActionEvent e) {
		 		 int idKupca;
				 String naziv = cbKupac.getSelectedItem().toString();
		 		KupacServis kupacServis = new KupacServisImpl();
		 		for(Kupac kupac  : kupacServis.getListaKupaca()) {
		 			if(kupac.getIme().equals(naziv)) {
		 				idKupca=kupac.getId_kupca();
		 				kupac1 = new Kupac();
		 				kupac1.setId_kupca(idKupca);
		 			}
		 		}
		 	}
		 });
		cbKupac.setBounds(117, 55, 127, 20);
		contentPane.add(cbKupac);
		
		 cbArtikal = new JComboBox();
		 cbArtikal.addActionListener(new ActionListener() {
			
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		String naziv = cbArtikal.getSelectedItem().toString();
		 		ArtikalServis artikalServis = new ArtikalServisImpl();
		 	for(Artikal a :	artikalServis.getListArtikala()) {
		 		if(a.getNaziv().equals(naziv)) {
		 			artikal = new Artikal();
		 			artikal.setId(a.getId());
		 			artikal.setNaziv(a.getNaziv());;;
		 		}
		 		
		 	}
		 		
		 		
		 	}
		 });
		cbArtikal.setBounds(117, 101, 127, 20);
		contentPane.add(cbArtikal);
		
		tfBroj = new JTextField();
		tfBroj.setBounds(89, 173, 86, 20);
		contentPane.add(tfBroj);
		tfBroj.setColumns(10);
		
		tfKolicina = new JTextField();
		tfKolicina.setBounds(270, 173, 86, 20);
		contentPane.add(tfKolicina);
		tfKolicina.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(38, 253, 411, 134);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		
		JButton cbDodaj = new JButton("Dodaj");
		cbDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					redniBrojStavke ++ ;
				
				RacunStavke racunStavke = new RacunStavke();
				racunStavke.setKolicina(Integer.parseInt(tfKolicina.getText()));
				racunStavke.setRedniBrojStavke(redniBrojStavke);
		         artikal.addRacunStavke(racunStavke);
		         stavke.add(racunStavke);
		         dodaj();
			}

			private void dodaj() {
				dtm.setRowCount(0);
				Object [] red = new Object[3];
			for(RacunStavke rs: stavke) {
				red[0] = rs.getRedniBrojStavke();
				red[1]=rs.getArtikal().getNaziv();
				red[2]=rs.getKolicina();
				dtm.addRow(red);
			}
				
			}
		});
		cbDodaj.setBounds(62, 219, 89, 23);
		contentPane.add(cbDodaj);
		
		JButton cbInsert = new JButton("Insert");
		cbInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Racun racun = new Racun();
				racun.setBrojRacuna(tfBroj.getText());
				racun.setDate(new Date());
				kupac1.addRacun(racun); //setovanje racuna za odredjenog kupca
				for(RacunStavke rs : stavke) {
					racun.addRacunStavke(rs);
				}
				
				RacunServis racunServis = new RacunServisImpl();
				racunServis.insertRacun(racun);
			}
		});
		cbInsert.setBounds(267, 219, 89, 23);
		contentPane.add(cbInsert);
		
		JLabel lblNewLabel = new JLabel("Broj Racuna");
		lblNewLabel.setBounds(10, 176, 69, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Kolicina");
		lblNewLabel_1.setBounds(214, 176, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Kupac");
		lblNewLabel_2.setBounds(10, 58, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Artikal");
		lblNewLabel_3.setBounds(10, 104, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnPocetna = new JButton("Pocetna Forma");
		btnPocetna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PocetnaForma pf = new PocetnaForma();
				pf.setVisible(true);
			}
		});
		btnPocetna.setBounds(333, 54, 116, 36);
		contentPane.add(btnPocetna);
		Object [] kolone = new Object[3];
		kolone[0] = "redniBrojStavke";
		kolone[1] = "naziv";
		kolone[2] = "kolicina";
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		srediFormu();
		postaviBrojac();
	}

	private void postaviBrojac() {
		RacunServis racunServis = new RacunServisImpl();
		int brojRacunaBaza=racunServis.brojRacuna();
		if( brojRacunaBaza != 0) {
			brojRacunaBaza++;
			tfBroj.setText(String.valueOf(brojRacunaBaza));
		}else {
			tfBroj.setText(String.valueOf(brojRacuna));
		}
	}

	private void srediFormu() {
		KupacServis kupacServis = new KupacServisImpl();
		ArtikalServis artikalServis = new ArtikalServisImpl();
		for(Kupac kupac : kupacServis.getListaKupaca()) {
			cbKupac.addItem(kupac.getIme());
		}
		for(Artikal artikal : artikalServis.getListArtikala()) {
			 cbArtikal.addItem(artikal.getNaziv());
		}
		
	}
}










