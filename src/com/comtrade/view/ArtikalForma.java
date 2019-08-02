package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.entity.Artikal;
import com.comtrade.konstante.Konstante;
import com.comtrade.kontrolerPL.ArtikalKontroler;
import com.comtrade.servis.ArtikalServis;
import com.comtrade.servis.impl.ArtikalServisImpl;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class ArtikalForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfNaziv;
	private JTextField tfSifra;
	private JTextField tfBarKod;
	private JTextField tfCena;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private int idArtikla;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ArtikalForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Naziv");
		lblNewLabel.setBounds(35, 62, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfNaziv = new JTextField();
		tfNaziv.setBounds(155, 59, 86, 20);
		contentPane.add(tfNaziv);
		tfNaziv.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Sifra");
		lblNewLabel_1.setBounds(35, 127, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfSifra = new JTextField();
		tfSifra.setBounds(155, 124, 86, 20);
		contentPane.add(tfSifra);
		tfSifra.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("BarKod");
		lblNewLabel_2.setBounds(35, 196, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		tfBarKod = new JTextField();
		tfBarKod.setBounds(155, 193, 86, 20);
		contentPane.add(tfBarKod);
		tfBarKod.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cena");
		lblNewLabel_3.setBounds(35, 257, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		tfCena = new JTextField();
		tfCena.setBounds(155, 254, 86, 20);
		contentPane.add(tfCena);
		tfCena.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArtikalKontroler artikalKontroler = new ArtikalKontroler();
				artikalKontroler.insertArtikal(vratiArtikal(Konstante.INSERT));
				ocistiPolja();
				srediFormu();
				
			}
		});
		btnInsert.setBounds(25, 298, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArtikalKontroler ak = new ArtikalKontroler();
				ak.updateArtikal(vratiArtikal(Konstante.UPDATE));
			  ocistiPolja();
			  srediFormu();
			}
		});
		btnUpdate.setBounds(176, 298, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Artikal artikal = new Artikal();
				artikal.setId(idArtikla);
				ArtikalKontroler ak = new ArtikalKontroler();
				ak.deleteArtikal(artikal);
				ocistiPolja();
				srediFormu();
			}
		});
		btnDelete.setBounds(324, 298, 89, 23);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(35, 343, 475, 75);
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
				int red =table.getSelectedRow();
				
				idArtikla = Integer.parseInt((table.getModel().getValueAt(red,0).toString()));
				String naziv =table.getModel().getValueAt(red, 1).toString();
				String sifra =table.getModel().getValueAt(red, 2).toString();
                String barKod =table.getModel().getValueAt(red, 3).toString();
				String  cena =table.getModel().getValueAt(red, 4).toString();
               tfBarKod.setText(barKod);
               tfCena.setText(cena);
               tfNaziv.setText(naziv);
               tfSifra.setText(sifra);
				
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnPocetna = new JButton("Pocetna Forma");
		btnPocetna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PocetnaForma pf = new  PocetnaForma();
				pf.setVisible(true);
			}
		});
		btnPocetna.setBounds(324, 223, 133, 32);
		contentPane.add(btnPocetna);
        Object[]kolone = new Object[5];
		kolone[0] = "id";
		kolone[1] = "naziv";
		kolone[2] = "sifra";
		kolone[3] = "barKod";
		kolone[4] = "cena";
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		dtm.addColumn(kolone[3]);
		dtm.addColumn(kolone[4]);
		srediFormu();
		
	}

	private void srediFormu() {
		dtm.setRowCount(0);
		ArtikalServis artikalServis = new ArtikalServisImpl();
		for(Artikal a :artikalServis.getListArtikala()) {
			Object[]redovi = new Object[5];
			redovi[0]=a.getId();
			redovi[1]=a.getNaziv();
			redovi[2]=a.getSifra();
			redovi[3]=a.getBarKod();
			redovi[4]=a.getCena();
			dtm.addRow(redovi);
			
		}
		
	}
	private void ocistiPolja() {
		tfBarKod.setText("");
		tfCena.setText("");
		tfNaziv.setText("");
		tfSifra.setText("");
	}
	public Artikal vratiArtikal(Konstante konstante) {
		String naziv = tfNaziv.getText();
		String  barKod=tfBarKod.getText();
		String sifra=tfSifra.getText();
		double cena = Double.valueOf(tfCena.getText());
		Artikal artikal = new Artikal( naziv, barKod, cena, sifra);
		if(String.valueOf(konstante).equals(String.valueOf(Konstante.UPDATE))) {
			artikal.setId(idArtikla);
		}
		
		return  artikal;
	}
}
