package view;

import javax.swing.*;

import operations.Operatii;

public class Frame extends JFrame { // crearea unei ferestre ce va fi folosita pentru interactiunea cu utilizatorul
									// prin adaugarea de butoane, text fields, etichete..

	public Frame(Operatii o) {
		this.setContentPane(new Panou(o)); // in content pane va fi panoul creat separat in clasa Panou cu toate
											// elemente componente
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}

	public static void main(String[] args) {

		Operatii o = new Operatii();
		Frame f = new Frame(o);

	}

}
