package demo;

public class Arrete {

	 @Override
	public String toString() {
		return "Arrete [sommet1=" + sommet1 + ", sommet2=" + sommet2 + ", poids=" + poids + "]";
	}
	String sommet1;
	String sommet2;
	int poids;
	public String getSommet1() {
		return sommet1;
	}
	public void setSommet1(String sommet1) {
		this.sommet1 = sommet1;
	}
	public String getSommet2() {
		return sommet2;
	}
	public void setSommet2(String sommet2) {
		this.sommet2 = sommet2;
	}
	public int getPoids() {
		return poids;
	}
	public void setPoids(int poids) {
		this.poids = poids;
	}
	public Arrete(String sommet1, String sommet2, int poids) {
		super();
		this.sommet1 = sommet1;
		this.sommet2 = sommet2;
		this.poids = poids;
	}
	 
	 
}
