import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Unesite ime\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(51, 31, 125, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(51, 60, 199, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblUnesitePrezime = new JLabel("Unesite prezime\r\n\r\n");
		lblUnesitePrezime.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUnesitePrezime.setBounds(51, 116, 125, 21);
		frame.getContentPane().add(lblUnesitePrezime);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(51, 148, 199, 30);
		frame.getContentPane().add(textField_1);
		
		JLabel lblUnesiteMatiniBroj = new JLabel("Unesite mati\u010Dni broj\r\n");
		lblUnesiteMatiniBroj.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUnesiteMatiniBroj.setBounds(51, 204, 164, 22);
		frame.getContentPane().add(lblUnesiteMatiniBroj);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(51, 237, 199, 30);
		frame.getContentPane().add(textField_2);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(344, 60, 376, 288);
		textArea.setEditable(false);
		frame.getContentPane().add(textArea);
		
		JLabel lblVaeInformacije = new JLabel("Va\u0161e informacije\r\n");
		lblVaeInformacije.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblVaeInformacije.setBounds(344, 27, 125, 22);
		frame.getContentPane().add(lblVaeInformacije);
		frame.setBounds(100, 100, 790, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Validiraj JMBG");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
			
				Osoba o = new Osoba();
				String ime = textField.getText();
				String prezime = textField_1.getText();
				String jmbg = textField_2.getText();
			
				o.setIme(ime);
				o.setPrezime(prezime);
				o.setJmbg(jmbg);
				o.getGodinaRodjenja();
				o.getDanRodjenja();
				o.getMesecRodjenja();
							
				 if(o.getValidanJMBG() && o.kontrolnaCifra()) {
					o.getIme();
					o.getPrezime();
					o.odrediRegionRodjenja();
			
					o.getPol();
					textArea.append("Vaše ime:" + "\n");
					textArea.append(o.getIme() + "\n\n");
					textArea.append("Vaše prezime:" + "\n");
					textArea.append(o.getPrezime() + "\n\n");
					textArea.append("Datum roðenja:" + "\n");
					textArea.append(o.getDanRodjenja() + " " + o.getMesecRodjenja() + " " + o.getGodinaRodjenja() + "\n\n");
					o.odrediRegionRodjenja();
					textArea.append("Država roðenja:" + "\n");
					textArea.append(o.getDrzavaRodjenja() + "\n\n");
					textArea.append("Mesto roðenja:" + "\n");
					textArea.append(o.getMestoRodjenja() + "\n\n");
					textArea.append("Pol:" + "\n");
					textArea.append(o.getPol());
					
				} 
				else {
					textArea.append(o.getKontrolnaGreska());
			}    	
		}
		});
		


		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(215, 385, 155, 54);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNovaValidacija = new JButton("Nova validacija\r\n");
		btnNovaValidacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textArea.setText(null);
			}
		});
		btnNovaValidacija.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNovaValidacija.setBounds(436, 385, 155, 54);
		frame.getContentPane().add(btnNovaValidacija);
		
		
	}
}
