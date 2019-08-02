package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PocetnaForma extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PocetnaForma frame = new PocetnaForma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PocetnaForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnArtikal = new JButton("Artikal");
		btnArtikal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArtikalForma af = new ArtikalForma();
				af.setVisible(true);
			}
		});
		btnArtikal.setBounds(49, 56, 89, 23);
		contentPane.add(btnArtikal);
		
		JButton btnKupac = new JButton("Kupac");
		btnKupac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KupacForma kf = new KupacForma();
				kf.setVisible(true);
			}
		});
		btnKupac.setBounds(254, 56, 89, 23);
		contentPane.add(btnKupac);
		
		JButton btnRacun = new JButton("Racun");
		btnRacun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RacunForma rf = new RacunForma();
				rf.setVisible(true);
			}
		});
		btnRacun.setBounds(161, 161, 89, 23);
		contentPane.add(btnRacun);
	}
}
