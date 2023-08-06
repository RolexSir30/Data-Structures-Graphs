package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class KruskalAlgo {
	
	static HashMap<String,String> ensembles=new HashMap<String,String>();
	static ArrayList<Arrete> kruskal = new ArrayList<Arrete>() ;
    static String d = "";
	public static void main(String[] args) {
	
		Arrete A = new Arrete("G","A",7);
		Arrete B = new Arrete("A","B",1);
		Arrete C = new Arrete("B","E",10);
		Arrete D = new Arrete("G","F",9);
		Arrete E = new Arrete("F","C",5);
		Arrete NI = new Arrete("F","D",4);
		Arrete F = new Arrete("A","C",2);
		Arrete G = new Arrete("C","D",2);
		Arrete H = new Arrete("F","H",4);
		Arrete I = new Arrete("B","D",12);
		Arrete J = new Arrete("D","E",11);
		Arrete K = new Arrete("H","E",18);
		Arrete L = new Arrete("D","H",7);

		/**Arrete A = new Arrete("B","A",4);
		Arrete B = new Arrete("B","C",6);
		Arrete C = new Arrete("C","D",8);
		Arrete D = new Arrete("C","A",5);
		Arrete E = new Arrete("B","D",9);**/

		ArrayList<Arrete> arrete = new ArrayList<Arrete> ();
		arrete.add(NI);
		arrete.add(A);
		arrete.add(B);
		arrete.add(C);
		arrete.add(D);
		arrete.add(E);
		arrete.add(F);
		arrete.add(G);
		arrete.add(H);
		arrete.add(I);
		arrete.add(J);
		arrete.add(K);
		arrete.add(L);

		
		ArrayList<String> sommets = new ArrayList<String>();
		sommets.add("A");
		sommets.add("B");
		sommets.add("C");
		sommets.add("D");
		sommets.add("E");
		sommets.add("F");
		sommets.add("G");
		sommets.add("H");


		Graphe g = new Graphe(arrete,sommets);
		
		//System.out.println(Kruskal(g));
		ArrayList<Arrete> aczsc=Kruskal(g);
		int nb = aczsc.size();
		System.out.println("Voici les arrêtes appartenant à l'arbre couvrant minimale : ");
		for(int i=0;i<nb;i++) {
			
			System.out.println("" +aczsc.get(i).getSommet1()+ "--"+aczsc.get(i).getSommet2()+" poids : " +aczsc.get(i).getPoids());
		}
	}
	
	
	public static ArrayList<Arrete> Kruskal(Graphe g) {
	
		String d="";
		ArrayList<String> sommets =  g.getSommets();
		ArrayList<Arrete> arrete=g.getArrete();
		
		//On trie la liste d'arrete arrete par rapport au poids des arrêtes.
		Collections.sort(arrete,new compare());;

		//On instancie une liste d'arrete null
		//ArrayList<Arrete> boum;

		
		
		// Pour tout sommets u de G créer un ensemble(u). C'est ce qu'on vient de faire là.
		for(String a : sommets) {
			String b = null ;
			b+= a;
			ensembles.put(a,b);
		}
		int length = arrete.size();
		for(int i=0;i<length;i++) {
			Arrete monPrécieux = arrete.get(i);
			String sommet1 = monPrécieux.getSommet1();
			String sommet2 = monPrécieux.getSommet2();
			
			if(!find(sommet1).equals(find(sommet2))) {
				kruskal.add(monPrécieux);
			
				union(sommet1,sommet2);
			}

		}
		
		return kruskal;
		
	}
	
	
	public static String find(String sommet) {
		for(int i=0;i<d.length();i++) {
			String o=""+d.charAt(i);
			if(o.equals(sommet)) {
				return d;
			}
			
		}
		return ensembles.get(sommet);
				
		
	}
	public static void union(String sommet1,String sommet2) {
		
		
		  d = ensembles.get(sommet1)+ensembles.get(sommet2);
		//ensembles.remove(sommet1);		
		ensembles.put(sommet1,d);
		//ensembles.remove(sommet2);
		ensembles.put(sommet2,d);

		//return ensembles.get(sommet);
				
		
	}
	
	
}
