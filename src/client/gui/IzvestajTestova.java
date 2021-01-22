package client.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import java.awt.Scrollbar;
import java.awt.TextArea;

public class IzvestajTestova extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextArea textArea;
	JScrollPane scrollPane;


	public IzvestajTestova(String tekst) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 466, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 91, 358, 335);
		contentPane.add(scrollPane);
		
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setText(tekst);
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Izvestaj testova");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
			lblNewLabel.setBounds(134, 33, 149, 34);
		}
		return lblNewLabel;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBounds(49, 83, 345, 318);
		}
		return textArea;
	}
}
