package operations;

import java.util.Collections;
import java.util.Scanner;

import model.Monom;
import model.Polinom;

public class Operatii {

	public Polinom adunare(Polinom p1, Polinom p2) {
		Polinom rez = new Polinom();

		for (Monom m : p1.poly) {
			int e1 = m.getExp();
			int c1 = (int)m.getCoef();
			if (p2.getElemAfterExp(e1) != null) {
				int c2 = (int)p2.getElemAfterExp(e1).getCoef();
				int c3 = c1 + c2;
				rez.poly.add(new Monom(c3, e1));
				p2.poly.remove(p2.getElemAfterExp(e1));
			} else {
				rez.poly.add(m);
			}

		}
		for (Monom m : p2.poly) {
			rez.poly.add(m);
		}

		Collections.sort(rez.poly);
		return rez;

	}

	public Polinom scadere(Polinom p1, Polinom p2) {
		Polinom rez = new Polinom();

		for (Monom m : p2.poly) {
			int c = (int)m.getCoef() * (-1);
			m.setCoef(c); // System.out.print(m);
		}

		for (Monom m : p1.poly) {
			int e1 = m.getExp();
			int c1 = (int)m.getCoef();
			if (p2.getElemAfterExp(e1) != null) {
				int c2 = (int)p2.getElemAfterExp(e1).getCoef();
				int c3 = c1 + c2;
				rez.poly.add(new Monom(c3, e1));
				p2.poly.remove(p2.getElemAfterExp(e1));
			} else {
				rez.poly.add(m);
			}

		}
		for (Monom m : p2.poly) {
			rez.poly.add(m);
		}

		Collections.sort(rez.poly);
		return rez;

	}

	public Polinom inmultire(Polinom p1, Polinom p2) {
		Polinom rez = new Polinom();
		Polinom rez_final = new Polinom();

		for (Monom m : p1.poly) {
			for (Monom m2 : p2.poly) {
				rez.poly.add(new Monom((int)m.getCoef() * (int)m2.getCoef(), (int)m.getExp() + (int)m2.getExp()));
			}
		}

		for (Monom m : rez.poly) {
			rez_final.poly.add(m);
		}
		rez_final.afisarePolinom();
		;
		System.out.println();
		for (int i = 0; i < rez.poly.size(); i++) {
			for (int j = i + 1; j < rez.poly.size(); j++) {
				if (rez.poly.get(i).getExp() == rez.poly.get(j).getExp()) {
					rez_final.poly.add(
							new Monom((int)rez.poly.get(i).getCoef() + (int)rez.poly.get(j).getCoef(), rez.poly.get(i).getExp()));
					rez_final.poly.remove(rez.poly.get(j));
					rez_final.poly.remove(rez.poly.get(i));
				}

			}
		}

		Collections.sort(rez_final.poly);
		return rez_final;

	}

	public Polinom derivare(Polinom p1) {
		Polinom rez = new Polinom();

		for (Monom m : p1.poly) {
			int e1 = m.getExp();
			int c1 = (int)m.getCoef();
			if (e1 == 0) {
				if (c1 != 0) {
					rez.poly.add(new Monom(0, 0));
				}
			}

			rez.poly.add(new Monom(e1 * c1, e1 - 1));

		}

		Collections.sort(rez.poly);
		return rez;

	}
	
	public Polinom integrare(Polinom p1) {
		Polinom rez = new Polinom();

		for (Monom m : p1.poly) {
			int e1 = m.getExp();
			float c1 = m.getCoef();
			
			rez.poly.add(new Monom(c1/(e1+1), e1 + 1));

		}

		Collections.sort(rez.poly);
		return rez;

	}

	public Polinom parsare(String input) {
		Polinom rez = new Polinom(); //punem String-ul'input' parsat intr-un polinom 'rez'

		String input2 = input.replaceAll("-", "+-");  //in input2 vom avea string-ul nostru in care am inlocuit '-' cu '+-' pt a-l putea imparti mai usor in bucati, dupa '+' 
		String input22 = "";  
		if (input.charAt(0) == '-') {  //daca string-ul initial incepea cu '-', atunci dupa replace va incepe cu '+-' si nu il vom putea parsa corect deoarece se ia ceea ce este de o parte si de alta a lui '+', iar inainte de '+-' nu va fi nimic de fapt 
			input22 = input2.substring(1); //asadar, in input22 vom avea un string care sa inceapa cu '-' daca string-ul initial incepea cu '-'
		} else {
			input22 = input2; //...sau il lasam asa
		}

		String[] input3 = input22.split("\\+"); //impartim string-ul in bucati folosind '+' ca delimitator si obtinem astfel monoamele

		for (String s : input3) {

			String[] s2 = s.split("\\*x\\^"); //dupa acest split ramanem cu coeficientul si exponentul fiecarui monom in parte si il putem crea

			if (s2.length > 1) {

				Monom y = new Monom(Integer.parseInt(s2[0]), Integer.parseInt(s2[1]));
				rez.poly.add(y);

			} else if (s2.length == 1) {
				// if (s2[0].length() > 0) {
				Monom y = new Monom(Integer.parseInt(s2[0]), 0);
				rez.poly.add(y);
				/// }

			}

		}
		Collections.sort(rez.poly);
		return rez;
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * Polinom r = new Polinom(); Scanner in = new Scanner(System.in); String input
	 * = in.nextLine();
	 * 
	 * 
	 * 
	 * String input2 = in.nextLine(); Operatii o = new Operatii(); r =
	 * o.parsare(input); Polinom r2 = new Polinom(); r2 = o.parsare(input2); //
	 * Collections.sort(r.poly); for (Monom yy : r.poly) { System.out.println(yy +
	 * "   "); } for (Monom yyy : r2.poly) { System.out.println(yyy + "   "); }
	 * System.out.println("input1:" + input + " input2:" + input2);
	 * 
	 * // Polinom rezAd = new Polinom(); // rezAd = o.adunare(r, r2); // Polinom
	 * rezAd2 = o.scadere(r, r2); // rezAd.afisarePolinom(); //
	 * rezAd2.afisarePolinom(); Polinom rezOri=new Polinom(); rezOri=o.inmultire(r,
	 * r2); rezOri.afisarePolinom();
	 * 
	 * in.close(); }
	 */
}