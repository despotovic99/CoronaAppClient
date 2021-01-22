package client.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import baza.Status;
import baza.Test;
import baza.TipTesta;
import client.Client;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelGlavni extends JPanel {
	private JLabel lbIme;
	private JLabel lbPrezime;
	private JButton btnTestSamoprocene;
	private JButton btnTbrzi;
	private JButton btnPCR;
	private JLabel lblNewLabel;
	private JLabel lbStatus;

	GlavniProzor glavniProzor;
	private JButton btnIzadji;
	private JLabel lblStatusPcrT;
	private JLabel lblStatuspcr;
	private JButton btnNewButton;
	private JLabel lblPoslednjaPrijava;
	private JLabel lblPoslednjaPrijava_2lbl;

	/**
	 * Create the panel.
	 */
	public PanelGlavni(GlavniProzor glavniFrame) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				upitTestsamoprocene();
			}
		});
		setLayout(null);
		add(getLbIme());
		add(getLbPrezime());
		add(getBtnTestSamoprocene());
		add(getBtnTbrzi());
		add(getBtnPCR());
		add(getLblNewLabel());
		add(getLbStatus());

		this.glavniProzor = glavniFrame;
		add(getBtnIzadji());
		add(getLblStatusPcrT());
		add(getLblStatuspcr());
		add(getBtnNewButton());
		add(getLblPoslednjaPrijava());
		add(getLblPoslednjaPrijava_2lbl());

		
		
		

	}

	private JLabel getLbIme() {
		if (lbIme == null) {
			lbIme = new JLabel("Ime");
			lbIme.setForeground(new Color(0, 0, 0));
			lbIme.setHorizontalAlignment(SwingConstants.CENTER);
			lbIme.setFont(new Font("Arial", Font.PLAIN, 18));
			lbIme.setBounds(85, 47, 201, 29);
		}
		return lbIme;
	}

	private JLabel getLbPrezime() {
		if (lbPrezime == null) {
			lbPrezime = new JLabel("Prezime");
			lbPrezime.setHorizontalAlignment(SwingConstants.CENTER);
			lbPrezime.setFont(new Font("Arial", Font.PLAIN, 18));
			lbPrezime.setBounds(394, 43, 201, 36);
		}
		return lbPrezime;
	}

	private JButton getBtnTestSamoprocene() {
		if (btnTestSamoprocene == null) {
			btnTestSamoprocene = new JButton("Test samoprocene");
			btnTestSamoprocene.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (Client.testMoguc(TipTesta.TESTSAMOPROCENE)) {
						glavniProzor.getContentPane().removeAll();
						glavniProzor.getContentPane().add(new TestSamoprocenePanel(glavniProzor));
						glavniProzor.getContentPane().revalidate();
						glavniProzor.getContentPane().repaint();
					} else {
						JOptionPane.showMessageDialog(null, "Korisnik je uradio jedan test samoprocene danas!",
								"Test uradjen", JOptionPane.INFORMATION_MESSAGE);
					}

				}
			});
			btnTestSamoprocene.setForeground(Color.BLUE);
			btnTestSamoprocene.setFont(new Font("Arial", Font.PLAIN, 15));
			btnTestSamoprocene.setBounds(38, 274, 161, 36);
		}
		return btnTestSamoprocene;
	}

	public JButton getBtnTbrzi() {
		if (btnTbrzi == null) {
			btnTbrzi = new JButton("Brzi test");
			btnTbrzi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					zapocniBrziTest();

				}

			});
			btnTbrzi.setEnabled(false);
			btnTbrzi.setForeground(Color.BLUE);
			btnTbrzi.setFont(new Font("Arial", Font.PLAIN, 15));
			btnTbrzi.setBounds(38, 336, 161, 36);
		}
		return btnTbrzi;
	}

	public JButton getBtnPCR() {
		if (btnPCR == null) {
			btnPCR = new JButton("PCR test");
			btnPCR.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(Client.pcrTest!=null) {
						
						JOptionPane.showMessageDialog(null, "PCR test vec pokrenut!", "Test pokrenut",
								JOptionPane.INFORMATION_MESSAGE);
						return;	
					}
					
					if (!Client.testMoguc(TipTesta.PCR)) {
						JOptionPane.showMessageDialog(null, "Korisnik je uradio jedan PCR test danas!", "Test uradjen",
								JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					
					if (JOptionPane.showConfirmDialog(null, "Zapoceti PCR test?", "PCR test",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						Client.zapocniPCRTest();
						lblStatuspcr.setText("Na cekanju");
					}

				}
			});
			btnPCR.setEnabled(false);
			btnPCR.setForeground(Color.BLUE);
			btnPCR.setFont(new Font("Arial", Font.PLAIN, 15));
			btnPCR.setBounds(38, 395, 161, 36);
		}
		return btnPCR;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("STATUS :");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
			lblNewLabel.setBounds(85, 105, 91, 36);
		}
		return lblNewLabel;
	}

	public JLabel getLbStatus() {
		if (lbStatus == null) {
			lbStatus = new JLabel("status");
			lbStatus.setVerticalAlignment(SwingConstants.TOP);
			lbStatus.setHorizontalAlignment(SwingConstants.LEFT);
			lbStatus.setFont(new Font("Arial", Font.PLAIN, 18));
			lbStatus.setBounds(202, 112, 409, 70);
		}
		return lbStatus;
	}

	public void upisiParametre() {
		lbIme.setText(glavniProzor.getKorisnik().getIme());
		lbPrezime.setText(glavniProzor.getKorisnik().getPrezime());
		lbStatus.setForeground(Color.BLACK);
		if(glavniProzor.getKorisnik().getVremePoslednjePrijave()!=null) {
			GregorianCalendar vremeCalendar = glavniProzor.getKorisnik().getVremePoslednjePrijave();
			int godina = vremeCalendar.get(GregorianCalendar.YEAR);
			int mesec = vremeCalendar.get(GregorianCalendar.MONTH);
			int dan = vremeCalendar.get(GregorianCalendar.DAY_OF_MONTH);
			int sat = vremeCalendar.get(GregorianCalendar.HOUR_OF_DAY);
			int minut = vremeCalendar.get(GregorianCalendar.MINUTE);
			lblPoslednjaPrijava.setText(dan+"."+(mesec+1)+"."+godina+" "+sat+":"+minut);
		}

		this.getBtnTestSamoprocene().setEnabled(true);
		glavniProzor.omoguciTestove(false);
		Status status = glavniProzor.getKorisnik().getStatus();
		String textZaLabel = "";

		switch (status) {
		case NIJE_TESTIRAN:
			textZaLabel = "Korisnik nije testiran";
			break;

		case POD_NADZOROM:
			textZaLabel = "<html>Korisnik je pod nadzorom i potrebno je ponoviti <br>test samoprocene</html>";
			break;

		case BRZI_PCR_POTREBAN:
			textZaLabel = "Potrebno je uraditi brzi test, PCR test ili oba";
			// ovde treba da ga preusmeris na to
			this.getBtnTestSamoprocene().setEnabled(false);
			glavniProzor.omoguciTestove(true);
			break;

		case POZITIVAN:
			textZaLabel = "Korisnik je pozitivan na korona virus";
			lbStatus.setForeground(Color.RED);
			this.getBtnTestSamoprocene().setEnabled(false);
			glavniProzor.omoguciTestove(true);
			//
			break;
		case NEGATIVAN:
			textZaLabel = "Korisnik je negativan na korona virus";
			lbStatus.setForeground(Color.GREEN);
			break;
		case NIJE_POD_NADZOROM:
			textZaLabel = "Nije pod nadzorom";
			lbStatus.setForeground(Color.GREEN);
			break;
		default:
			break;
		}

		lbStatus.setText(textZaLabel);

		
	}

	private JButton getBtnIzadji() {
		if (btnIzadji == null) {
			btnIzadji = new JButton("Izadji");
			btnIzadji.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					  System.out.println(glavniProzor.getKorisnik().toString());
					  glavniProzor.getKorisnik().setVremePoslednjePrijave(new GregorianCalendar());
					  Client.sacuvajKorisnika(glavniProzor.getKorisnik());
					 
					System.exit(0);
				}
			});
			btnIzadji.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnIzadji.setForeground(Color.RED);
			btnIzadji.setBounds(408, 394, 161, 36);
		}
		return btnIzadji;
	}

	private JLabel getLblStatusPcrT() {
		if (lblStatusPcrT == null) {
			lblStatusPcrT = new JLabel("STATUS PCR TESTA :");
			lblStatusPcrT.setFont(new Font("Arial", Font.PLAIN, 18));
			lblStatusPcrT.setBounds(85, 184, 206, 36);
		}
		return lblStatusPcrT;
	}

	public JLabel getLblStatuspcr() {
		if (lblStatuspcr == null) {
			lblStatuspcr = new JLabel("");
			lblStatuspcr.setFont(new Font("Arial", Font.PLAIN, 18));
			lblStatuspcr.setBounds(323, 184, 201, 36);
		}
		return lblStatuspcr;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Pregled testova");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (Client.testoviKorisnika == null || Client.testoviKorisnika.size() == 0) {
						JOptionPane.showMessageDialog(null, "Korisnik nije radio testove", "Nema testova",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						String tekst = "";

						for (Test test : Client.testoviKorisnika) {
							GregorianCalendar vreme = test.getVreme();
							tekst += "\n" + test.getTipTesta().toString() + " rezultat " + test.getRezultat().toString()
									+ "\n";
							tekst += "Vreme :" + vreme.get(GregorianCalendar.DAY_OF_MONTH) + "."
									+ (vreme.get(GregorianCalendar.MONTH) + 1) + "." + vreme.get(GregorianCalendar.YEAR)
									+ "\n"+
									vreme.get(GregorianCalendar.HOUR_OF_DAY)+":"+vreme.get(GregorianCalendar.MINUTE);
						}

						new IzvestajTestova(tekst).setVisible(true);
					}

				}
			});
			btnNewButton.setForeground(Color.BLUE);
			btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
			btnNewButton.setBounds(408, 275, 161, 36);
		}
		return btnNewButton;
	}

	public void zapocniBrziTest() {
		if (!Client.testMoguc(TipTesta.BRZI)) {
			JOptionPane.showMessageDialog(null, "Korisnik je uradio jedan brzi test danas!", "Test uradjen",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		Status rezultat = Status.NEGATIVAN;
		int br = new Random().nextInt();
		if (br % 2 == 0)
			rezultat = Status.POZITIVAN;
		GregorianCalendar vreme = new GregorianCalendar();

		String id = glavniProzor.getKorisnik().getUsername() + (Client.testoviKorisnika.size() + 1);

		Test test = new Test(id, TipTesta.BRZI, glavniProzor.getKorisnik().getUsername(), vreme, rezultat);

		JOptionPane.showMessageDialog(null,
				glavniProzor.getKorisnik().getIme() + " " + glavniProzor.getKorisnik().getPrezime() + "\n"
						+ "Rezultat testa :" + rezultat.toString() + "\nDatum "
						+ vreme.get(GregorianCalendar.DAY_OF_MONTH) + "." + (vreme.get(GregorianCalendar.MONTH) + 1)
						+ "." + (vreme.get(GregorianCalendar.YEAR)) + ".\n" + vreme.get(GregorianCalendar.HOUR) + ":"
						+ vreme.get(GregorianCalendar.MINUTE),
				"Rezultat brzog testa", JOptionPane.INFORMATION_MESSAGE);

		Client.posaljiTest(test);
		glavniProzor.promeniStatus(rezultat);
		upisiParametre();

	}


	
	private JLabel getLblPoslednjaPrijava() {
		if (lblPoslednjaPrijava == null) {
			lblPoslednjaPrijava = new JLabel("/");
			lblPoslednjaPrijava.setFont(new Font("Arial", Font.PLAIN, 12));
			lblPoslednjaPrijava.setBounds(562, 10, 120, 21);
		}
		return lblPoslednjaPrijava;
	}
	private JLabel getLblPoslednjaPrijava_2lbl() {
		if (lblPoslednjaPrijava_2lbl == null) {
			lblPoslednjaPrijava_2lbl = new JLabel("Poslednja prijava:");
			lblPoslednjaPrijava_2lbl.setFont(new Font("Arial", Font.PLAIN, 12));
			lblPoslednjaPrijava_2lbl.setBounds(421, 12, 120, 21);
		}
		return lblPoslednjaPrijava_2lbl;
	}

	public void rezultatPCRTesta() {

		Status rezultat = Status.NEGATIVAN;
		int br = new Random().nextInt();
		if (br % 2 == 0)
			rezultat = Status.POZITIVAN;
		GregorianCalendar vreme = new GregorianCalendar();

		String id = glavniProzor.getKorisnik().getUsername() + (Client.testoviKorisnika.size() + 1);

		Test test = new Test(id, TipTesta.PCR, glavniProzor.getKorisnik().getUsername(), vreme, rezultat);

		JOptionPane.showMessageDialog(null,
				glavniProzor.getKorisnik().getIme() + " " + glavniProzor.getKorisnik().getPrezime() + "\n"
						+ "Rezultat PCR testa :" + rezultat.toString() + "\nDatum "
						+ vreme.get(GregorianCalendar.DAY_OF_MONTH) + "." + (vreme.get(GregorianCalendar.MONTH) + 1)
						+ "." + (vreme.get(GregorianCalendar.YEAR)) + ".\n" + vreme.get(GregorianCalendar.HOUR) + ":"
						+ vreme.get(GregorianCalendar.MINUTE),
				"Rezultat PCR testa", JOptionPane.INFORMATION_MESSAGE);

		Client.posaljiTest(test);
		glavniProzor.promeniStatus(rezultat);
		upisiParametre();
		
	}
	void upitTestsamoprocene() {
		if(Client.istekaoPeriodTestasamoprocene()) {
			JOptionPane.showMessageDialog(null, "Istekao period testasamoprocene, morate ga uraditi opet!","Istekao test",JOptionPane.INFORMATION_MESSAGE);
		}else {
			System.out.println("Nije istekao");
		}
	}
}

