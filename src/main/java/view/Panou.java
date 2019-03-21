package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.Polinom;
import operations.Operatii;

public class Panou extends JPanel {
	private Label label0 = new Label(
			"Dati polinoamele cu toti coeficientii si exponentii nenuli, inclusiv 1, dupa formatul: '-2*x^1+4*x^2-1*x^4+10'");
	private Label label = new Label("Polinom1:");
	private Label label2 = new Label("Polinom2:");
	private Label label3 = new Label("Rezultat:");
//	private TextArea text = new TextArea(10, 10);
	private JTextField tf = new JTextField(2);
	private JTextField tf2 = new JTextField(2);
	private JTextField tf3 = new JTextField(2);
	private JButton buton = new JButton("Aduna");
	private JButton buton2 = new JButton("Scade");
	private JButton buton3 = new JButton("Inmulteste");
	private JButton buton4 = new JButton("Resetare");
	private JButton buton5 = new JButton("Derivare");
	private JButton buton6 = new JButton("Integrare");

	public Panou(Operatii o) {

		this.setPreferredSize(new Dimension(650, 400));

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.add(label0);
		label0.setAlignment(Label.CENTER);

		this.add(label);
		label.setAlignment(Label.CENTER);
		this.add(tf);

		this.add(label2);
		label2.setAlignment(Label.CENTER);
		this.add(tf2);

		this.add(label3);
		label2.setAlignment(Label.CENTER);
		this.add(tf3);

		this.add(buton);

		buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = tf.getText();
				System.out.println(txt);
				String txt2 = tf2.getText();
				System.out.println(txt2);
				Operatii op = new Operatii();
				Polinom p = op.parsare(txt);
				p.afisarePolinom();
				System.out.println();
				Polinom p2 = op.parsare(txt2);
				p2.afisarePolinom();
				System.out.println();
				Polinom p3 = op.adunare(p, p2);
				p3.afisarePolinom();
				System.out.println();
				String x = p3.toString();
				System.out.println(x);
				tf3.setText(x);

			}
		});

		this.add(buton2);

		buton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				String txt = tf.getText();
				System.out.println(txt);
				String txt2 = tf2.getText();
				System.out.println(txt2);
				Operatii op = new Operatii();
				Polinom p = op.parsare(txt);
				p.afisarePolinom();
				System.out.println();
				Polinom p2 = op.parsare(txt2);
				p2.afisarePolinom();
				System.out.println();
				Polinom p3 = op.scadere(p, p2);
				p3.afisarePolinom();
				System.out.println();
				String x = p3.toString();
				System.out.println(x);
				tf3.setText(x);

			}
		});

		this.add(buton3);

		buton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e3) {
				String txt = tf.getText();
				System.out.println(txt);
				String txt2 = tf2.getText();
				System.out.println(txt2);
				Operatii op = new Operatii();
				Polinom p = op.parsare(txt);
				p.afisarePolinom();
				System.out.println();
				Polinom p2 = op.parsare(txt2);
				p2.afisarePolinom();
				System.out.println();
				Polinom p3 = op.inmultire(p, p2);
				p3.afisarePolinom();
				System.out.println();
				String x = p3.toString();
				System.out.println(x);
				tf3.setText(x);

			}
		});

		this.add(buton5);

		buton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e5) {
				String txt = tf.getText();
				System.out.println(txt);
				Operatii op = new Operatii();
				Polinom p = op.parsare(txt);
				p.afisarePolinom();
				System.out.println();
				Polinom p3 = op.derivare(p);
				p3.afisarePolinom();
				System.out.println();
				String x = p3.toString();
				System.out.println(x);
				tf3.setText(x);

			}
		});
		
		this.add(buton6);

		buton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e6) {
				String txt = tf.getText();
				System.out.println(txt);
				Operatii op = new Operatii();
				Polinom p = op.parsare(txt);
				p.afisarePolinom();
				System.out.println();
				Polinom p3 = op.integrare(p);
				p3.afisarePolinom();
				System.out.println();
				String x = p3.toString();
				System.out.println(x);
				tf3.setText(x);

			}
		});

		this.add(buton4);

		buton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e4) {
				tf.setText("");
				tf2.setText("");
				tf3.setText("");

			}
		});

	}
}