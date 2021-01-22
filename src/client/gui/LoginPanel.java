package client.gui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import client.Client;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class LoginPanel extends JPanel {
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lbUsername;
	private JLabel lbPass;
	private JButton btnNewButton;
	private JLabel lblNemasNalog;
	private JLabel lblNewLabel;
	GlavniProzor glavniProzor;

	/**
	 * Create the panel.
	 */
	public LoginPanel(GlavniProzor glavni) {
		setLayout(null);
		add(getTxtUsername());
		add(getTxtPassword());
		add(getLbUsername());
		add(getLbPass());
		add(getBtnNewButton());
		add(getLblNemasNalog());
		add(getLblNewLabel());
		this.glavniProzor=glavni;

	}
	private JTextField getTxtUsername() {
		if (txtUsername == null) {
			txtUsername = new JTextField();
			txtUsername.setColumns(10);
			txtUsername.setBounds(264, 175, 179, 19);
		}
		return txtUsername;
	}
	private JPasswordField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setBounds(264, 234, 179, 19);
		}
		return txtPassword;
	}
	private JLabel getLbUsername() {
		if (lbUsername == null) {
			lbUsername = new JLabel("Korisnicko ime");
			lbUsername.setFont(new Font("Arial", Font.PLAIN, 16));
			lbUsername.setBounds(134, 178, 120, 13);
		}
		return lbUsername;
	}
	private JLabel getLbPass() {
		if (lbPass == null) {
			lbPass = new JLabel("Sifra");
			lbPass.setFont(new Font("Arial", Font.PLAIN, 16));
			lbPass.setBounds(134, 237, 120, 13);
		}
		return lbPass;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Prijavi se");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Client.prijavaKorisnika(txtUsername.getText(), txtPassword.getText());
				}
			});
			btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
			btnNewButton.setBounds(280, 290, 146, 39);
		}
		return btnNewButton;
	}
	private JLabel getLblNemasNalog() {
		if (lblNemasNalog == null) {
			lblNemasNalog = new JLabel("Nemas nalog? Registruj se..");
			lblNemasNalog.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblNemasNalog.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Client.registracijaKorisnikaProzor();
				}
			});
			lblNemasNalog.setForeground(Color.BLUE);
			lblNemasNalog.setFont(new Font("Arial", Font.ITALIC, 15));
			lblNemasNalog.setBounds(408, 369, 204, 19);
		}
		return lblNemasNalog;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Corona test");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
			lblNewLabel.setBounds(264, 85, 179, 46);
		}
		return lblNewLabel;
	}
	public void ispisiLoginGresku() {
		JOptionPane.showMessageDialog(this,"Pogresno korisnicko ime ili lozinka","Greska pri prijavljivanju", JOptionPane.ERROR_MESSAGE);
		ocistiPolja();
	}
	private void ocistiPolja() {
		txtUsername.setText("");
		txtPassword.setText("");
	}
}
