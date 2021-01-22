package client.gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Checkbox;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import baza.Korisnik;
import baza.Status;
import baza.Test;
import baza.TipTesta;
import client.Client;

public class TestSamoprocenePanel extends JPanel {
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2_1_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_4_1;
	private JLabel lblNewLabel_4_2;
	private JLabel lblNewLabel_4_3;
	private JLabel lblNewLabel_4_4;
	private JCheckBox chP1;
	private JCheckBox chP2;
	private JCheckBox chP3;
	private JCheckBox chP4;
	private JCheckBox chP5;
	private JCheckBox chP6;
	private JCheckBox chP7;
	
	int brojacChBox=0;
	GlavniProzor glavniProzor;
	
	
	private JButton btnPotvrdi;
	/**
	 * Create the panel.
	 */
	public TestSamoprocenePanel(GlavniProzor glavni) {
		setLayout(null);
		add(getBtnNewButton());
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLblNewLabel_2());
		add(getLblNewLabel_2_1());
		add(getLblNewLabel_2_2());
		add(getLblNewLabel_2_1_1());
		add(getLblNewLabel_3());
		add(getLblNewLabel_4());
		add(getLblNewLabel_4_1());
		add(getLblNewLabel_4_2());
		add(getLblNewLabel_4_3());
		add(getLblNewLabel_4_4());
		add(getChP1());
		add(getChP2());
		add(getChP3());
		add(getChP4());
		add(getChP5());
		add(getChP6());
		add(getChP7());
		add(getBtnPotvrdi());
		
		this.glavniProzor=glavni;
	
	}

	/*private void vratiSe() {
		glavniProzor.getContentPane().removeAll();
		glavniProzor.getContentPane().add(glavniProzor.getGlavniPanel());
		glavniProzor.getContentPane().revalidate();
		glavniProzor.getContentPane().repaint();
	}*/
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Odustani");
			btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
			btnNewButton.setForeground(Color.RED);
			btnNewButton.setBounds(178, 377, 116, 34);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//vratiSe();
					glavniProzor.prikaziGlavniPanel(glavniProzor.getKorisnik());
				}
			});
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Test samoprocene");
			lblNewLabel.setForeground(Color.BLUE);
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
			lblNewLabel.setBounds(273, 24, 178, 34);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Molimo vas odgovorite na sledeca pitanja");
			lblNewLabel_1.setForeground(Color.BLUE);
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(233, 80, 294, 27);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Da li ste putovali van Srbije u okviru");
			lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(24, 136, 244, 34);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("14 dana pre po\u010Detka simptoma?");
			lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNewLabel_2_1.setBounds(24, 154, 234, 34);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("Da li ste bili u kontaku sa zara\u017Eenim");
			lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNewLabel_2_2.setBounds(358, 136, 234, 34);
		}
		return lblNewLabel_2_2;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("osobama?");
			lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNewLabel_2_1_1.setBounds(358, 154, 234, 34);
		}
		return lblNewLabel_2_1_1;
	}
	private JLabel getLblNewLabel_3() {

		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\u0160ta imate od simptoma (Da/Ne):");
			lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
			lblNewLabel_3.setBounds(46, 208, 234, 27);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {

		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("- Povi\u0161ena temperatura");
			lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
			lblNewLabel_4.setBounds(56, 245, 162, 27);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_4_1() {
		if (lblNewLabel_4_1 == null) {
			lblNewLabel_4_1 = new JLabel("- Ka\u0161alj");
			lblNewLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 15));
			lblNewLabel_4_1.setBounds(56, 282, 162, 27);
		}
		return lblNewLabel_4_1;
	}
	private JLabel getLblNewLabel_4_2() {
		if (lblNewLabel_4_2 == null) {
			lblNewLabel_4_2 = new JLabel("- Op\u0161ta slabost");
			lblNewLabel_4_2.setFont(new Font("Arial", Font.PLAIN, 15));
			lblNewLabel_4_2.setBounds(56, 320, 162, 27);
		}
		return lblNewLabel_4_2;
	}
	private JLabel getLblNewLabel_4_3() {
		if (lblNewLabel_4_3 == null) {
			lblNewLabel_4_3 = new JLabel("- Gubitak \u010Dula mirisa");
			lblNewLabel_4_3.setFont(new Font("Arial", Font.PLAIN, 15));
			lblNewLabel_4_3.setBounds(321, 245, 162, 27);
		}
		return lblNewLabel_4_3;
	}
	private JLabel getLblNewLabel_4_4() {
		if (lblNewLabel_4_4 == null) {
			lblNewLabel_4_4 = new JLabel("- Gubitak/promena \u010Dula ukusa");
			lblNewLabel_4_4.setFont(new Font("Arial", Font.PLAIN, 15));
			lblNewLabel_4_4.setBounds(321, 282, 198, 27);
		}
		return lblNewLabel_4_4;
	}
	private JCheckBox getChP1() {
		if (chP1 == null) {
			chP1 = new JCheckBox("Ne");
			chP1.setHorizontalAlignment(SwingConstants.CENTER);
			chP1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chP1.isSelected()) {
						chP1.setText("Da");
						brojacChBox++;
					}else {
						chP1.setText("Ne");
						brojacChBox--;
					}
					
				}
			});
			chP1.setBounds(273, 144, 49, 21);
		}
		return chP1;
	}
	private JCheckBox getChP2() {
		if (chP2 == null) {
			chP2 = new JCheckBox("Ne");
			chP2.setHorizontalAlignment(SwingConstants.CENTER);
			chP2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chP2.isSelected()) {
						chP2.setText("Da");
						brojacChBox++;
					}else {
						chP2.setText("Ne");
						brojacChBox--;
					}
					
				}
			});
			chP2.setBounds(607, 144, 61, 26);
		}
		return chP2;
	}
	private JCheckBox getChP3() {
		if (chP3 == null) {
			chP3 = new JCheckBox("Ne");
			chP3.setHorizontalAlignment(SwingConstants.CENTER);
			chP3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					if(chP3.isSelected()) {
						chP3.setText("Da");
						brojacChBox++;
					}else {
						chP3.setText("Ne");
						brojacChBox--;
					}
					
				}
			});
			chP3.setBounds(233, 249, 61, 27);
		}
		return chP3;
	}
	private JCheckBox getChP4() {
		if (chP4 == null) {
			chP4 = new JCheckBox("Ne");
			chP4.setHorizontalAlignment(SwingConstants.CENTER);
			chP4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chP4.isSelected()) {
						chP4.setText("Da");
						brojacChBox++;
					}else {
						chP4.setText("Ne");
						brojacChBox--;
					}
				
				}
			});
			chP4.setBounds(233, 286, 61, 23);
		}
		return chP4;
	}
	private JCheckBox getChP5() {
		if (chP5 == null) {
			chP5 = new JCheckBox("Ne");
			chP5.setHorizontalAlignment(SwingConstants.CENTER);
			chP5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chP5.isSelected()) {
						chP5.setText("Da");
						brojacChBox++;
					}else {
						chP5.setText("Ne");
						brojacChBox--;
					}
					
				}
			});
			chP5.setBounds(233, 324, 61, 23);
		}
		return chP5;
	}
	private JCheckBox getChP6() {
		if (chP6 == null) {
			chP6 = new JCheckBox("Ne");
			chP6.setHorizontalAlignment(SwingConstants.CENTER);
			chP6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chP6.isSelected()) {
						chP6.setText("Da");
						brojacChBox++;
					}else {
						chP6.setText("Ne");
						brojacChBox--;
					}
					
				}
			});
			chP6.setBounds(523, 249, 61, 23);
		}
		return chP6;
	}
	private JCheckBox getChP7() {
		if (chP7 == null) {
			chP7 = new JCheckBox("Ne");
			chP7.setHorizontalAlignment(SwingConstants.CENTER);
			chP7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chP7.isSelected()) {
						chP7.setText("Da");
						brojacChBox++;
					}else {
						chP7.setText("Ne");
						brojacChBox--;
					}
					
				}
			});
			chP7.setBounds(523, 286, 61, 27);
		}
		return chP7;
	}
	private JButton getBtnPotvrdi() {
		if (btnPotvrdi == null) {
			btnPotvrdi = new JButton("Potvrdi");
			btnPotvrdi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				int kod=JOptionPane.showConfirmDialog(null, "Da li ste sigurni?","",JOptionPane.YES_NO_OPTION);
				if(kod==JOptionPane.NO_OPTION || kod== JOptionPane.CLOSED_OPTION) return;
				
				Status rezultat = Status.POD_NADZOROM;
					
				if(brojacChBox>=2) {
					glavniProzor.omoguciTestove(true);	
				//	glavniProzor.getGlavniPanel().getLbStatus().setText("Potrebno je uraditi brzi test ili  PCR test");
					glavniProzor.getKorisnik().setStatus(Status.BRZI_PCR_POTREBAN);
					glavniProzor.promeniStatus(Status.BRZI_PCR_POTREBAN);
					rezultat=Status.BRZI_PCR_POTREBAN;
				}else {
					
					if(glavniProzor.getKorisnik().getStatus().equals(Status.POD_NADZOROM) 
							|| glavniProzor.getKorisnik().getStatus().equals(Status.NIJE_POD_NADZOROM)
							|| glavniProzor.getKorisnik().getStatus().equals(Status.NEGATIVAN)) {
					//	glavniProzor.getGlavniPanel().getLbStatus().setText("Nije pod nadzorom");
						glavniProzor.promeniStatus(Status.NIJE_POD_NADZOROM);
						rezultat=Status.NIJE_POD_NADZOROM;
					}else {
					//	glavniProzor.getGlavniPanel().getLbStatus().setText("Pod nadzorom");
						glavniProzor.promeniStatus(Status.POD_NADZOROM);
					}
					
					
				}
				String id = glavniProzor.getKorisnik().getUsername()+(Client.testoviKorisnika.size()+1);
				
				Client.posaljiTest(new Test(id, TipTesta.TESTSAMOPROCENE,glavniProzor.getKorisnik().getUsername() ,new GregorianCalendar() , rezultat));
				glavniProzor.prikaziGlavniPanel(glavniProzor.getKorisnik());
				//vratiSe();
					
				}
			});
			btnPotvrdi.setForeground(new Color(0, 128, 0));
			btnPotvrdi.setFont(new Font("Arial", Font.PLAIN, 15));
			btnPotvrdi.setBounds(407, 376, 122, 34);
		}
		return btnPotvrdi;
	}
	
}
