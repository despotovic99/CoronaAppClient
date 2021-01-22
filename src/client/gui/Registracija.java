package client.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import baza.Korisnik;
import baza.Status;
import client.Client;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

public class Registracija extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtEmail;
	private JComboBox comboPol;
	private JPasswordField txtPassword;
	private JCheckBox chPrikaziPass;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnReg;
	private JButton btnOtkazi;
	private JLabel lblNewLabel_6;


	/**
	 * Create the frame.
	 */
	
	
	
	public Registracija() {
		setResizable(false);
		setTitle("Registracija");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 518, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTxtUsername());
		contentPane.add(getTxtIme());
		contentPane.add(getTxtPrezime());
		contentPane.add(getTxtEmail());
		contentPane.add(getComboPol());
		contentPane.add(getTxtPassword());
		contentPane.add(getChPrikaziPass());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getLblNewLabel_5());
		contentPane.add(getBtnReg());
		contentPane.add(getBtnOtkazi());
		contentPane.add(getLblNewLabel_6());
		setLocationRelativeTo(null);
	}
	

	private JTextField getTxtUsername() {
		if (txtUsername == null) {
			txtUsername = new JTextField();
			txtUsername.setBounds(172, 108, 144, 19);
			txtUsername.setColumns(10);
		}
		return txtUsername;
	}
	private JTextField getTxtIme() {
		if (txtIme == null) {
			txtIme = new JTextField();
			txtIme.setColumns(10);
			txtIme.setBounds(172, 196, 144, 19);
		}
		return txtIme;
	}
	private JTextField getTxtPrezime() {
		if (txtPrezime == null) {
			txtPrezime = new JTextField();
			txtPrezime.setColumns(10);
			txtPrezime.setBounds(172, 239, 144, 19);
		}
		return txtPrezime;
	}
	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(172, 334, 144, 19);
		}
		return txtEmail;
	}
	private JComboBox getComboPol() {
		if (comboPol == null) {
			comboPol = new JComboBox();
			comboPol.setModel(new DefaultComboBoxModel(new String[] {"Musko", "Zensko"}));
			comboPol.setBounds(209, 288, 73, 21);
		}
		return comboPol;
	}
	private JPasswordField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setBounds(172, 154, 144, 19);
		}
		return txtPassword;
	}
	private JCheckBox getChPrikaziPass() {
		if (chPrikaziPass == null) {
			chPrikaziPass = new JCheckBox("Prikazi password");
			chPrikaziPass.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(chPrikaziPass.isSelected()) {
						txtPassword.setEchoChar((char)0);
					}else {
						txtPassword.setEchoChar('●');
					}
					
				}
			});
			chPrikaziPass.setBounds(343, 153, 127, 21);
		}
		return chPrikaziPass;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Username");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNewLabel.setBounds(67, 111, 81, 13);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Password");
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(67, 157, 81, 13);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Ime");
			lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(67, 199, 81, 13);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Prezime");
			lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(67, 242, 81, 13);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("Pol");
			lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNewLabel_4.setBounds(67, 292, 81, 13);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("Email");
			lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNewLabel_5.setBounds(67, 337, 81, 13);
		}
		return lblNewLabel_5;
	}
	private JButton getBtnReg() {
		if (btnReg == null) {
			btnReg = new JButton("Registruj se");
			btnReg.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(praznaPolja()) {
						JOptionPane.showMessageDialog(null,"Popuni sva polja!", "Greska",JOptionPane.WARNING_MESSAGE);
						return; 
					}
					Korisnik korisnik = new Korisnik(txtUsername.getText(), txtPassword.getText(), txtIme.getText(),
							txtPrezime.getText(), comboPol.getSelectedItem().toString(), txtEmail.getText(),Status.NIJE_TESTIRAN,null);
					System.out.println(korisnik.toString());
					Client.registracijaKorisnika(korisnik);
					
				}
			});
			btnReg.setFont(new Font("Arial", Font.PLAIN, 15));
			btnReg.setBounds(83, 405, 133, 21);
		}
		return btnReg;
	}
	private JButton getBtnOtkazi() {
		if (btnOtkazi == null) {
			btnOtkazi = new JButton("Otkazi");
			btnOtkazi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOtkazi.setFont(new Font("Arial", Font.PLAIN, 15));
			btnOtkazi.setBounds(254, 405, 85, 21);
		}
		return btnOtkazi;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("Registracija korisnika");
			lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 25));
			lblNewLabel_6.setBounds(124, 32, 257, 31);
		}
		return lblNewLabel_6;
	}
	
	private boolean praznaPolja() {
		return txtUsername.getText().equals("") || txtPassword.getText().equals("") 
				|| txtIme.getText().equals("") || txtPrezime.getText().equals("") ||
				txtEmail.getText().equals("");
	}
	
	public void ispisiRezultat(String naslov,String poruka) {
		int kod=JOptionPane.INFORMATION_MESSAGE;
		if(naslov.equals("Greska")) {
			kod=JOptionPane.ERROR_MESSAGE;
		}
		JOptionPane.showMessageDialog(null, poruka,naslov, kod);
	}
	
}
