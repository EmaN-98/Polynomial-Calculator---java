package model;
import java.util.ArrayList;

public class Polinom {

	public ArrayList<Monom> poly = new ArrayList<Monom>();

//	private int size=poly.size();

	/*public void addMonom(int c,int e) {
		Polinom.poly.add(new Monom(c,e));
	}*/
	
	
	//@Override
	//public String toString() {
	//	return this.poly+"";
	//}

	//public int getSize() {
	//	return size;
	//}
	
	/*public boolean findExp(int e) {
		for (Monom m: poly) {
			int ee=m.getExp();
			if(ee==e) return false;
		}
		return true;
	}*/
	public String toString() {
		String s="";
		for(Monom m:this.poly)
			s=s+ m.toString();
		return s;
	}
	
	public void afisarePolinom() {
		for(Monom m:this.poly)
			System.out.print(m);
	}
	
	public Monom getElemAfterExp(int e) {
		for (Monom m: poly) {
			int ee=m.getExp();
			if(ee==e) return m;
		}
		return null;
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		Monom m1 = new Monom(2, 3);
		Monom m2 = new Monom(-1, 2);
		Monom m3 = new Monom(4, 0);
		
		poly.add(m1);
		poly.add(m2);
		poly.add(m3);
		
  
		//Iterator<Monom> i = poly.iterator();
		//while (i.hasNext())
		//	System.out.print(i.next());
		//System.out.println();
		
		for (Monom m: poly) {     System.out.print(m); } 
*/
	

}
