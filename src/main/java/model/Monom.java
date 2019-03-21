package model;

public class Monom implements Comparable<Monom> { //clasa ce modeleaza un monom reprezentat prin coeficient si exponent

	private float coef;
	private int exp;

	public Monom(float c, int e) {
		this.coef = c;
		this.exp = e;
	}
//getters & setters
	public float getCoef() {
		return coef;
	}

	public void setCoef(int coef) {
		this.coef = coef;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	@Override
	public String toString() {//suprascriem toString-ul ca sa afisam monoamele tratand toate cazurile

		if (coef < 0) {
			if (coef != -1) { 
				if (exp == 0) { 
					return coef + "";
				} else {
					return coef + "*x^" + exp;
				}
			} else {
				if (exp == 0) {
					return ""+coef;
				} else {
					return "-x^" + exp;
				}

			}
		} else if (coef > 0) {
			if (coef != 1) {
				if (exp == 0) {
					return "+" + coef;
				} else {
					return "+" + coef + "*x^" + exp;
				}
			} else {
				if (exp == 0) {
					return "+" +coef ;
				} else {
					return "+" + "x^" + exp;
				}
			}
		}
		return "";

	}

	public int compareTo(Monom o) { //compareTo va fi utilizata in metoda de sortare a monoamelor
		int rez;
		if (this.getExp() == o.getExp())
			rez = 0;
		else if (this.getExp() > o.getExp())  //le sortam descrescator dupa exponent
			rez = -1;
		else
			rez = 1;
		return rez;            
	}

}
