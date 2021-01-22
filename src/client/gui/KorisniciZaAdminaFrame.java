package client.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import baza.Korisnik;
import baza.Status;
import client.Client;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KorisniciZaAdminaFrame extends JFrame {
	private JPanel contentPane;
	private JTextArea textArea;
	JScrollPane scrollPane;
	private JRadioButton rbSvi;
	private JRadioButton rbPozitivni;
	private JRadioButton rbNegativni;
	private JRadioButton rbPodnadzorom;
	ButtonGroup grupa = new ButtonGroup();
	String sviString="";

	 public KorisniciZaAdminaFrame(String tekst) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 466, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 135, 358, 335);
		contentPane.add(scrollPane);
		
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setText(tekst);
		sviString=tekst;
		contentPane.add(getRbSvi());
		contentPane.add(getRbPozitivni());
		contentPane.add(getRbNegativni());
		contentPane.add(getRbPodnadzorom());
		
		grupa.add(rbNegativni);
		grupa.add(rbPodnadzorom);
		grupa.add(rbPozitivni);
		grupa.add(rbSvi);
		rbSvi.setSelected(true);
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBounds(49, 83, 345, 318);
		}
		return textArea;
	}
	private JRadioButton getRbSvi() {
		if (rbSvi == null) {
			rbSvi = new JRadioButton("Svi korisnici");
			rbSvi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					funkcija(null);
					
				}
			});
			rbSvi.setBounds(44, 35, 103, 21);
		}
		return rbSvi;
	}
	private JRadioButton getRbPozitivni() {
		if (rbPozitivni == null) {
			rbPozitivni = new JRadioButton("Pozitivni korisnici");
			rbPozitivni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					funkcija(Status.POZITIVAN);
				}
			});
			rbPozitivni.setBounds(43, 76, 103, 21);
		}
		return rbPozitivni;
	}
	private JRadioButton getRbNegativni() {
		if (rbNegativni == null) {
			rbNegativni = new JRadioButton("Negativni korisnici");
			rbNegativni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					funkcija(Status.NEGATIVAN);
				}
			});
			rbNegativni.setBounds(216, 35, 130, 21);
		}
		return rbNegativni;
	}
	private JRadioButton getRbPodnadzorom() {
		if (rbPodnadzorom == null) {
			rbPodnadzorom = new JRadioButton("Pod nadzorom");
			rbPodnadzorom.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					funkcija(Status.POD_NADZOROM);
				}
			});
			rbPodnadzorom.setBounds(216, 76, 103, 21);
		}
		return rbPodnadzorom;
	}
	
	void funkcija(Status status) {
		String tekst="";
		if(status==null) {
			textArea.setText(sviString);
			return;
		}
		for (Korisnik k : Client.korisnici) {
			if(k.getStatus().equals(status)) {
				
				tekst+=k.getIme()+" "+k.getPrezime()+" "+k.getEmail()+"\n";
				
			}
		}
		textArea.setText(tekst);
		
	}
}
