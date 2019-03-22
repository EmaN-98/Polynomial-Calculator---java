package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.Polinom;
import operations.Operatii;

public class Panou extends JPanel { //clasa ce realizeaza interfata grafica, instantiata apoi in Frame
	private Label label0 = new Label( // etichete
			"Dati polinoamele cu toti coeficientii si exponentii nenuli, inclusiv 1, dupa formatul: '-2*x^1+4*x^2-1*x^4+10'");
	private Label label = new Label("Polinom1:");
	private Label label2 = new Label("Polinom2:");
	private Label label3 = new Label("Rezultat:");
	private JTextField tf = new JTextField(2); // text field din care citim primul polinom pt adunare, scadere,
												// inmultire, dar si polinomul ce va fi derivat/integrat
	private JTextField tf2 = new JTextField(2); // text field din care citim al doilea polinom pt adunare, scadere, inmultire
	private JTextField tf3 = new JTextField(2); //text field in care afisam rezultatul operatiei selectate
	private JButton buton = new JButton("Aduna"); //butoane pt fiecare operatie implementata
	private JButton buton2 = new JButton("Scade");
	private JButton buton3 = new JButton("Inmulteste");
	private JButton buton4 = new JButton("Resetare"); //buton de resetare, care sterge continutul adaugat/afisat anterior in text fields
	private JButton buton5 = new JButton("Derivare");
	private JButton buton6 = new JButton("Integrare");

	public Panou(Operatii o) {//construim panoul cu atributele declarate anterior

		this.setPreferredSize(new Dimension(650, 400)); 
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//adaugam etichetele si text field-urile
		this.add(label0);
		label0.setAlignment(Label.CENTER);

		this.add(label);
		label.setAlignment(Label.LEFT);
		this.add(tf);

		this.add(label2);
		label2.setAlignment(Label.LEFT);
		this.add(tf2);

		this.add(label3);
		label3.setAlignment(Label.LEFT);
		this.add(tf3);

		this.add(buton); //adaugam primul buton, cel folosit la adunare si ii implementam ascultatorul
		buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = tf.getText(); //citim din text fields polinoamele
				String txt2 = tf2.getText();
				
				Operatii op = new Operatii(); 
				Polinom p = op.parsare(txt); //folosind o instanta a clasei Operatii, parsam polinoamele citite ca string-uri
				Polinom p2 = op.parsare(txt2);
	
				Polinom p3 = op.adunare(p, p2); //facem adunarea
			
				String x = p3.toString(); //transformam rezultatul in string
				tf3.setText(x); //..si il afisam in ultimul text field

			}
		});

		this.add(buton2); //butonul de scadere
		buton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				String txt = tf.getText();
				String txt2 = tf2.getText();
				
				Operatii op = new Operatii();
				Polinom p = op.parsare(txt);
				Polinom p2 = op.parsare(txt2);
				
				Polinom p3 = op.scadere(p, p2);
			
				String x = p3.toString();
				tf3.setText(x);

			}
		});

		this.add(buton3); //butonul de inmultire
		buton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e3) {
				String txt = tf.getText();
				String txt2 = tf2.getText();
				
				Operatii op = new Operatii();
				Polinom p = op.parsare(txt);
				Polinom p2 = op.parsare(txt2);
				
				Polinom p3 = op.inmultire(p, p2);
				
				String x = p3.toString();
				tf3.setText(x);

			}
		});

		this.add(buton5);//butonul de derivare
		buton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e5) {
				String txt = tf.getText(); //citim polinomul din PRIMUL text field
				
				Operatii op = new Operatii();
				Polinom p = op.parsare(txt);
			
				Polinom p3 = op.derivare(p);
				
				String x = p3.toString();
				tf3.setText(x);

			}
		});

		this.add(buton6); //butonul de integrare
		buton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e6) {
				String txt = tf.getText();
				
				Operatii op = new Operatii();
				Polinom p = op.parsare(txt);
			
				Polinom p3 = op.integrare(p);
			
				String x = p3.toString();
				tf3.setText(x);

			}
		});

		this.add(buton4); //butonul de reset
		buton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e4) {
				tf.setText(""); //goleste text field-urile
				tf2.setText("");
				tf3.setText("");

			}
		});

	}
}