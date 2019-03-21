package view;

import javax.swing.*;

import operations.Operatii;

public class Frame extends JFrame{

	public Frame(Operatii o) {
		this.setContentPane(new Panou(o));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
	public static void main(String[] args) {
		
		Operatii o=new Operatii();
		Frame f = new Frame(o);
		
	}

}
