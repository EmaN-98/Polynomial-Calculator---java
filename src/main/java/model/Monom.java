package model;

public class Monom implements Comparable<Monom> {

	private float coef;
	private int exp;

	public Monom(float c, int e) {
		this.coef = c;
		this.exp = e;
	}

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
	public String toString() {

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

	public int compareTo(Monom o) {
		int rez;
		if (this.getExp() == o.getExp())
			rez = 0;
		else if (this.getExp() > o.getExp())
			rez = -1;
		else
			rez = 1;
		return rez;
	}

}
