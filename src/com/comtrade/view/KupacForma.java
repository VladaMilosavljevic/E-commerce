package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.entity.Adresa;
import com.comtrade.entity.Kupac;
import com.comtrade.kontrolerPL.KupacKontroler;
import com.comtrade.servis.KupacServis;
import com.comtrade.servis.impl.KupacServisImpl;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class KupacForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfIme;
	private JTextField tfPib;
	private JTextField tfAdresa;
	private JTextField tfPtt;
	private JTable table;
    private DefaultTableModel dtm = new DefaultTableModel();
    private int idKupca;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public KupacForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ime kupca");
		lblNewLabel.setBounds(48, 47, 73, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PIB");
		lblNewLabel_1.setBounds(48, 100, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Adresa");
		lblNewLabel_2.setBounds(48, 158, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		tfIme = new JTextField();
		tfIme.setBounds(131, 44, 86, 20);
		contentPane.add(tfIme);
		tfIme.setColumns(10);
		
		tfPib = new JTextField();
		tfPib.setBounds(131, 97, 86, 20);
		contentPane.add(tfPib);
		tfPib.setColumns(10);
		
		tfAdresa = new JTextField();
		tfAdresa.setBounds(131, 155, 86, 20);
		contentPane.add(tfAdresa);
		tfAdresa.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("PTT");
		lblNewLabel_3.setBounds(48, 218, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		tfPtt = new JTextField();
		tfPtt.setBounds(131, 215, 86, 20);
		contentPane.add(tfPtt);
		tfPtt.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KupacKontroler kontroler = new KupacKontroler();
				kontroler.insertKupac(vratiAdresu());
				ocistiFildove();
				srediFormu();
				
			}
		});
		btnInsert.setBounds(21, 270, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KupacServis kupacServis = new KupacServisImpl();
				kupacServis.updateKupca(vratiKupca());
				ocistiFildove();
				srediFormu();
			}
		});
		btnUpdate.setBounds(167, 270, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kupac kupac = new Kupac();
				kupac.setId_kupca(idKupca);
				KupacServis kupacServis = new KupacServisImpl();
				kupacServis.deleteKupac(kupac);
				ocistiFildove();
				srediFormu();
				
			}
		});
		btnDelete.setBounds(308, 270, 89, 23);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(21, 328, 459, 70);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int red = table.getSelectedRow();
				idKupca=Integer.parseInt((table.getModel().getValueAt(red, 0)).toString());
				String ime = (table.getModel().getValueAt(red, 1).toString());
				String pib=(table.getModel().getValueAt(red, 2).toString());
			    tfIme.setText(ime);
			    tfPib.setText(pib);
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnPocetna = new JButton("Pocetna Forma");
		btnPocetna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PocetnaForma pf = new PocetnaForma();
				pf.setVisible(true);
			}
		});
		btnPocetna.setBounds(308, 201, 131, 36);
		contentPane.add(btnPocetna);
		Object[]kolone = new Object [3];
		kolone[0]="id";
		kolone[1]="ime";
		kolone[2]="pib";
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		srediFormu();
		
		
	}
	private void srediFormu() {
		dtm.setRowCount(0);
		KupacServis kupacServis = new KupacServisImpl();
		Object[]redovi = new Object[3];
		for(Kupac kupac : kupacServis.getListaKupaca()) {
			
			redovi[0]=kupac.getId_kupca();
			redovi[1]=kupac.getIme();
			redovi[2]=kupac.getPib();
			dtm.addRow(redovi);
			
		}
		
	}
	public Adresa vratiAdresu() {
		String ime=tfIme.getText();
		String pib=tfPib.getText();
		String ulica = tfAdresa.getText();
		String ptt=tfPtt.getText();
		Adresa adresa = new Adresa();
		adresa.setPtt(ptt);
		adresa.setUlica(ulica);
		Kupac kupac = new Kupac();
		kupac.setIme(ime);
		kupac.setPib(pib);
		adresa.setKupac(kupac);
		return adresa;
		
	}
	public Kupac vratiKupca() {
		String ime = tfIme.getText();
		String pib = tfPib.getText();
		Kupac kupac = new Kupac();
		kupac.setId_kupca(idKupca);
		kupac.setIme(ime);
		kupac.setPib(pib);
		return kupac;
	}
	public void ocistiFildove() {
		tfIme.setText("");
		tfPib.setText("");
		
		
	}
	
}
