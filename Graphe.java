package demo;

import java.util.ArrayList;

public class Graphe {

	ArrayList<Arrete> arrete;
	ArrayList<String> sommets;
	

	public void setSommets(ArrayList<String> sommets) {
		this.sommets = sommets;
	}

	public Graphe(ArrayList<Arrete> arrete,	ArrayList<String> sommets){
		this.arrete = arrete;
		this.sommets=sommets;
	}
	
	public void setArrete(ArrayList<Arrete> arrete) {
		this.arrete = arrete;
	}

	public void addArrete(Arrete arrete) {
		this.arrete.add(arrete);
	}

	public ArrayList<Arrete> getArrete() {
		// TODO Auto-generated method stub
		return arrete;
	}
	public ArrayList<String> getSommets() {
		// TODO Auto-generated method stub
		return sommets;
	}
	
	public int poids(String sommet1,String sommet2) {
		
		for (Arrete a :arrete) {
			if (a.getSommet1().equals(sommet1)&&a.getSommet2().equals(sommet2)) {
				return a.getPoids();
			};
		}
		return 0;
		
	}
	
}
