package client.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import baza.Korisnik;
import client.Client;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPanel extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblBrTestovaSvih;
	private JLabel lblNewLabel_1_1;
	private JLabel lblBrTestovaPozitivni;
	private JLabel lblNewLabel_1_2;
	private JLabel lblBrTestovaNegativni;
	private JLabel lblNewLabel_1_3;
	private JLabel lblBrTestovaPodnadzorom;
	private JButton btnOsvezi;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblPozitivniKor;
	private JLabel lblNewLabel_1_1_2;
	private JLabel lblNegativniKor;
	
	private GlavniProzor glavniProzor;

	/**
	 * Create the panel.
	 */
	public AdminPanel(GlavniProzor glavniProzor,String[]podaci) {
		this.glavniProzor=glavniProzor;
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLblBrTestovaSvih());
		add(getLblNewLabel_1_1());
		add(getLblBrTestovaPozitivni());
		add(getLblNewLabel_1_2());
		add(getLblBrTestovaNegativni());
		add(getLblNewLabel_1_3());
		add(getLblBrTestovaPodnadzorom());
		add(getBtnOsvezi());
		add(getBtnNewButton());
		add(getLblNewLabel_1_1_1());
		add(getLblPozitivniKor());
		add(getLblNewLabel_1_1_2());
		add(getLblNegativniKor());
		ucitajParametre(podaci);
		

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Administrator");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
			lblNewLabel.setBounds(221, 39, 230, 50);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Broj uradjenih testova :");
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1.setBounds(55, 121, 153, 22);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblBrTestovaSvih() {
		if (lblBrTestovaSvih == null) {
			lblBrTestovaSvih = new JLabel("sample");
			lblBrTestovaSvih.setHorizontalAlignment(SwingConstants.LEFT);
			lblBrTestovaSvih.setFont(new Font("Arial", Font.PLAIN, 15));
			lblBrTestovaSvih.setBounds(239, 121, 153, 22);
		}
		return lblBrTestovaSvih;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Broj pozitivnih testova :");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblNewLabel_1_1.setBounds(55, 165, 177, 22);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblBrTestovaPozitivni() {
		if (lblBrTestovaPozitivni == null) {
			lblBrTestovaPozitivni = new JLabel("sample");
			lblBrTestovaPozitivni.setHorizontalAlignment(SwingConstants.LEFT);
			lblBrTestovaPozitivni.setFont(new Font("Arial", Font.PLAIN, 15));
			lblBrTestovaPozitivni.setBounds(239, 165, 153, 22);
		}
		return lblBrTestovaPozitivni;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("Broj negativnih testova :");
			lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
			lblNewLabel_1_2.setBounds(55, 214, 167, 22);
		}
		return lblNewLabel_1_2;
	}
	private JLabel getLblBrTestovaNegativni() {
		if (lblBrTestovaNegativni == null) {
			lblBrTestovaNegativni = new JLabel("sample");
			lblBrTestovaNegativni.setHorizontalAlignment(SwingConstants.LEFT);
			lblBrTestovaNegativni.setFont(new Font("Arial", Font.PLAIN, 15));
			lblBrTestovaNegativni.setBounds(239, 214, 153, 22);
		}
		return lblBrTestovaNegativni;
	}
	private JLabel getLblNewLabel_1_3() {
		if (lblNewLabel_1_3 == null) {
			lblNewLabel_1_3 = new JLabel("Broj korisnika pod nadzorom :");
			lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 15));
			lblNewLabel_1_3.setBounds(55, 261, 210, 22);
		}
		return lblNewLabel_1_3;
	}
	private JLabel getLblBrTestovaPodnadzorom() {
		if (lblBrTestovaPodnadzorom == null) {
			lblBrTestovaPodnadzorom = new JLabel("sample");
			lblBrTestovaPodnadzorom.setHorizontalAlignment(SwingConstants.LEFT);
			lblBrTestovaPodnadzorom.setFont(new Font("Arial", Font.PLAIN, 15));
			lblBrTestovaPodnadzorom.setBounds(272, 261, 153, 22);
		}
		return lblBrTestovaPodnadzorom;
	}
	private JButton getBtnOsvezi() {
		if (btnOsvezi == null) {
			btnOsvezi = new JButton("Osvezi podatke");
			btnOsvezi.setForeground(Color.BLUE);
			btnOsvezi.setFont(new Font("Arial", Font.PLAIN, 15));
			btnOsvezi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Client.zatraziStatistiku();
					while (Client.statistika==null) {
						System.out.println("Cekam");
					}
					System.out.println("ucitao");
					ucitajParametre(Client.statistika);
					
				}
			});
			btnOsvezi.setBounds(477, 123, 143, 35);
		}
		return btnOsvezi;
	}
	
	public void ucitajParametre(String[] podaci) {
		// 0 svi- 1 poz - 2 neg- 3 nadzor - 4 pozitivniKor - 5 negativni Kor
		if(podaci==null) {
			
			return;
		}
		lblBrTestovaSvih.setText(podaci[0]);
		lblBrTestovaPozitivni.setText(podaci[1]);
		lblBrTestovaNegativni.setText(podaci[2]);
		lblBrTestovaPodnadzorom.setText(podaci[3]);
		lblPozitivniKor.setText(podaci[4]);
		lblNegativniKor.setText(podaci[5]);
		
		
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Pregled korisnika");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Client.zatraziKorisnike();
					
					while(Client.korisnici==null) {
						System.out.println("Cekam na korisnike");
					}
					System.out.println("Ucitao");
					
					String tekst="";
					
					for (Korisnik k : Client.korisnici) {
						tekst+=k.getIme()+" "+k.getPrezime()+" "+k.getEmail()+"\n";
					}
				//	System.out.println(tekst);
					new KorisniciZaAdminaFrame(tekst).setVisible(true);
					
					
				}
			});
			btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
			btnNewButton.setForeground(Color.BLUE);
			btnNewButton.setBounds(477, 202, 143, 34);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("Broj pozitivnih korisnika :");
			lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblNewLabel_1_1_1.setBounds(55, 307, 177, 22);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblPozitivniKor() {
		if (lblPozitivniKor == null) {
			lblPozitivniKor = new JLabel((String) null);
			lblPozitivniKor.setHorizontalAlignment(SwingConstants.LEFT);
			lblPozitivniKor.setFont(new Font("Arial", Font.PLAIN, 15));
			lblPozitivniKor.setBounds(239, 307, 153, 22);
		}
		return lblPozitivniKor;
	}
	private JLabel getLblNewLabel_1_1_2() {
		if (lblNewLabel_1_1_2 == null) {
			lblNewLabel_1_1_2 = new JLabel("Broj negativnih korisnika :");
			lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
			lblNewLabel_1_1_2.setBounds(55, 357, 177, 22);
		}
		return lblNewLabel_1_1_2;
	}
	private JLabel getLblNegativniKor() {
		if (lblNegativniKor == null) {
			lblNegativniKor = new JLabel((String) null);
			lblNegativniKor.setHorizontalAlignment(SwingConstants.LEFT);
			lblNegativniKor.setFont(new Font("Arial", Font.PLAIN, 15));
			lblNegativniKor.setBounds(239, 357, 153, 22);
		}
		return lblNegativniKor;
	}
	
	
	
}
