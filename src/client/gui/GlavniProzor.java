package client.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import baza.Korisnik;
import baza.Status;
import client.Client;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	public LoginPanel loginPanel= new LoginPanel(this);
	PanelGlavni glavniPanel =new PanelGlavni(this);
	TestSamoprocenePanel testSPPanel = new TestSamoprocenePanel(this);
	AdminPanel admin =new AdminPanel(this,Client.statistika);
	private Korisnik korisnik;


	public GlavniProzor(Korisnik k) {
		setTitle("Corona app");
		korisnik=k;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(loginPanel);
		
	
		
		setLocationRelativeTo(null);
	}

	
	public PanelGlavni getGlavniPanel() {
		return glavniPanel;
	}
	

	public JPanel getContentPane() {
		return contentPane;
	}
	
	public TestSamoprocenePanel getTestsp() {
		return testSPPanel;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	
	public void omoguciTestove(boolean odluka) {
		glavniPanel.getBtnTbrzi().setEnabled(odluka);
		glavniPanel.getBtnPCR().setEnabled(odluka);
	}
	
	public void prikaziGlavniPanel(Korisnik k) {
		getContentPane().removeAll();
		getContentPane().add(glavniPanel);
		getContentPane().revalidate();
		getContentPane().repaint();
		korisnik=k;
		glavniPanel.upisiParametre();
		//Client.zatraziTestove(k.getUsername());
		Client.zatraziPCR();
		
		/*while (Client.testoviKorisnika==null) {
			System.out.println("Wait tests");
			
		}*/
		
		
	}


	public void promeniStatus(Status status) {
		
		korisnik.setStatus(status);
		Client.promeniStatus(status);
		System.out.println("Status promenjen u "+status);
	}
	
	public void setStanjePCRTestaNaPanelu(String stanje) {
		
		glavniPanel.getLblStatuspcr().setText(stanje);
	}

	public void prikaziAdminPanel(Korisnik k) {	
		getContentPane().removeAll();
		admin = new AdminPanel(this, Client.statistika);
		getContentPane().add(admin);
		getContentPane().revalidate();
		getContentPane().repaint();
		korisnik=k;
		
	}
	
	
	
	public void rezultatPCRTesta() {
		
		glavniPanel.rezultatPCRTesta();
		
	}
	
	
	
	
}
