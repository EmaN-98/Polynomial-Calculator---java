package model;

import java.util.ArrayList;

public class Polinom {

	public ArrayList<Monom> poly = new ArrayList<Monom>(); //in ArrayList vor fi monoamele unui polinom

	public String toString() {
		String s = "";
		for (Monom m : this.poly)
			s = s + m.toString();
		return s;
	}

	public void afisarePolinom() {
		for (Monom m : this.poly)
			System.out.print(m);
	}

	public Monom getElemAfterExp(int e) { // metoda ce cauta un anumit monom dupa exponentul sau si il returneaza daca exista in polinom
		for (Monom m : poly) {
			int ee = m.getExp();
			if (ee == e)
				return m;
		}
		return null;
	}

}
