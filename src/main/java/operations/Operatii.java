package operations;

import java.util.Collections;
import java.util.Scanner;

import model.Monom;
import model.Polinom;

public class Operatii {

	public Polinom adunare(Polinom p1, Polinom p2) { // metoda de adunare care returneaza suma polinoamelor date ca
														// parametru prin alt polinom
		Polinom rez = new Polinom();

		for (Monom m : p1.poly) { // parcurgem monoamele primului polinom
			int e1 = m.getExp(); // salvam exponentul
			int c1 = (int) m.getCoef();// ..si coeficientul monomului curent
			if (p2.getElemAfterExp(e1) != null) { // daca exista in p2 un monom cu acest exponent
				int c2 = (int) p2.getElemAfterExp(e1).getCoef();
				int c3 = c1 + c2;
				rez.poly.add(new Monom(c3, e1)); // ..il adunam cu monomul curent si il adaugam in polinomul final
				p2.poly.remove(p2.getElemAfterExp(e1)); // apoi il stergem din p2
			} else {
				rez.poly.add(m); // altfel, daca nu exista in p2 un monom cu acest exponent,adaugam monomul
									// direct in polinomul rezultat
			}

		}
		for (Monom m : p2.poly) { // adaugam in rez monoamele ramase in p2
			rez.poly.add(m);
		}

		Collections.sort(rez.poly); // sortam monoamele descrescator
		return rez;

	}

	public Polinom scadere(Polinom p1, Polinom p2) {// scaderea
		Polinom rez = new Polinom();

		for (Monom m : p2.poly) { // parcurgem al doilea polinom si il inmultim cu -1
			int c = (int) m.getCoef() * (-1);
			m.setCoef(c);
		}

		for (Monom m : p1.poly) { // ...apoi facem adunarea dintre cele doua polinoame
			int e1 = m.getExp();
			int c1 = (int) m.getCoef();
			if (p2.getElemAfterExp(e1) != null) {
				int c2 = (int) p2.getElemAfterExp(e1).getCoef();
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

	public Polinom inmultire(Polinom p1, Polinom p2) {// inmultirea
		Polinom rez = new Polinom();
		Polinom rez_final = new Polinom();

		for (Monom m : p1.poly) { // parcurgem cele doua polinoame, inmultind fiecare monom din p1 cu fiecare din
									// p2 si adaugand monoamele rezultate in polinomul rez
			for (Monom m2 : p2.poly) {
				rez.poly.add(new Monom((int) m.getCoef() * (int) m2.getCoef(), (int) m.getExp() + (int) m2.getExp()));
			}
		}

		for (Monom m : rez.poly) { // facem o copie a lui rez in rez_final
			rez_final.poly.add(m);
		}

		for (int i = 0; i < rez.poly.size(); i++) { // aici adunam monoamele din rezultat care au acelasi exponent
			for (int j = i + 1; j < rez.poly.size(); j++) {
				if (rez.poly.get(i).getExp() == rez.poly.get(j).getExp()) {
					rez_final.poly.add(new Monom((int) rez.poly.get(i).getCoef() + (int) rez.poly.get(j).getCoef(),
							rez.poly.get(i).getExp()));
					rez_final.poly.remove(rez.poly.get(j));
					rez_final.poly.remove(rez.poly.get(i));
				}

			}
		}

		Collections.sort(rez_final.poly);
		return rez_final;

	}

	public Polinom derivare(Polinom p1) {// derivarea
		Polinom rez = new Polinom();

		for (Monom m : p1.poly) {
			int e1 = m.getExp();
			int c1 = (int) m.getCoef();
			if (e1 == 0) { // in cazul in care exponentul e 0, adica monomul e o constanta, derivata
							// acestuia este 0
				if (c1 != 0) {
					rez.poly.add(new Monom(0, 0));
				}
			}

			rez.poly.add(new Monom(e1 * c1, e1 - 1));  //altfel, calculam derivata dupa formula (c*x^e)'=e*c*x^(e-1)

		}

		Collections.sort(rez.poly);
		return rez;

	}

	public Polinom integrare(Polinom p1) {// integrarea
		Polinom rez = new Polinom();

		for (Monom m : p1.poly) {
			int e1 = m.getExp();
			float c1 = m.getCoef();

			rez.poly.add(new Monom(c1 / (e1 + 1), e1 + 1)); // integram monoamele dupa formula
															// (c*x^e)'=[c*x^(e+1)]/(e+1)

		}

		Collections.sort(rez.poly);
		return rez;

	}

	public Polinom parsare(String input) {
		Polinom rez = new Polinom(); // punem String-ul'input' parsat intr-un polinom 'rez'

		String input2 = input.replaceAll("-", "+-"); // in input2 vom avea string-ul nostru in care am inlocuit '-' cu
														// '+-' pt a-l putea imparti mai usor in bucati, dupa '+'
		String input22 = "";
		if (input.charAt(0) == '-') { // daca string-ul initial incepea cu '-', atunci dupa replace va incepe cu '+-'
										// si nu il vom putea parsa corect deoarece se ia ceea ce este de o parte si de
										// alta a lui '+', iar inainte de '+-' nu va fi nimic de fapt
			input22 = input2.substring(1); // asadar, in input22 vom avea un string care sa inceapa cu '-' daca
											// string-ul initial incepea cu '-'
		} else {
			input22 = input2; // ...sau il lasam asa
		}

		String[] input3 = input22.split("\\+"); // impartim string-ul in bucati folosind '+' ca delimitator si obtinem
												// astfel monoamele

		for (String s : input3) {

			String[] s2 = s.split("\\*x\\^"); // dupa acest split ramanem cu coeficientul si exponentul fiecarui monom
												// in parte si il putem crea

			if (s2.length > 1) { // daca exponentul este nenul, formam monomul cu coeficientul=s2[0] si
									// exponentul=s2[1]

				Monom y = new Monom(Integer.parseInt(s2[0]), Integer.parseInt(s2[1]));
				rez.poly.add(y);

			} else if (s2.length == 1) { // altfel inseamna ca monomul e o constanta, avand exponentul 0
				Monom y = new Monom(Integer.parseInt(s2[0]), 0);
				rez.poly.add(y);

			}

		}
		Collections.sort(rez.poly);
		return rez;
	}

}