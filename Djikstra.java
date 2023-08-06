package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Djikstra {
public static void main(String[] args) {
	Arrete D = new Arrete("A","B",10);
	Arrete A = new Arrete("B","C",7);
	Arrete B = new Arrete("A","D",1);
	Arrete C = new Arrete("D","C",10);
	Arrete E = new Arrete("D","E",10);


	ArrayList<Arrete> arrete = new ArrayList<Arrete> ();
	arrete.add(A);
	arrete.add(B);
	arrete.add(C);
	arrete.add(D);
	arrete.add(E);
	
	ArrayList<String> sommets = new ArrayList<String>();
	//sommets.add("I");
	sommets.add("E");
	sommets.add("A");
	sommets.add("B");
	sommets.add("C");
	sommets.add("D");
	
	


	Graphe g = new Graphe(arrete,sommets);
	//Djikstra(g, "A");
	System.out.println("distance : "+Djikstra(g, "A"));
	System.out.println("Parent : "+Parent);

	///System.out.println(voisin("G ",g));
}


static HashMap<String,Integer> distance ;
static HashMap<String,String> Parent;
static HashMap<String,Integer> cout;
static int infini = Integer.MAX_VALUE;
static Queue<String> maFile;
public static HashMap<String, Integer> Djikstra(Graphe G, String sommet){
	
	distance= new HashMap<String,Integer>();
	Parent = new HashMap<String,String>();
	ArrayList<String> liste_sommets = G.getSommets();
	ArrayList<Arrete> liste_arretes = G.getArrete();
	
	for(String som : liste_sommets) {
		distance.put(som, infini);
	}
	distance.put(sommet, 0);
	for(String som : liste_sommets) {
		Parent.put(som, null);
	}
	Parent.put(sommet, null);
	
	Collections.sort(liste_sommets,new compDjikstra());

	maFile = new LinkedList<>();
	for(String a : liste_sommets) {
		maFile.add(a);
	}
//Initialisation finie !!!!
	
	
	while(maFile.size()>0) {
		String u =maFile.remove();
		liste_sommets.remove(u);
		for(String v :voisin(u,G)) {
			
			relachement(u,v,G);
			
		}
		Collections.sort(liste_sommets,new compDjikstra());

		 maFile = new LinkedList<>();
		for(String a : liste_sommets) {
			maFile.add(a);
		}
		//Ce qu'on fait ici c'est qu'on au tail le file par un sommet n'ayant pas encore été traité tel que distance est minimum
		
	
	}
	
 
	return distance;
	
	}



public static void relachement(String u, String v,Graphe G) {
	if(distance.get(v)>distance.get(u)+G.poids(u,v)) {
		Parent.put(v,u);
		distance.put(v, distance.get(u)+G.poids(u,v));
	}
}


//ici on cherche les voisins  du sommet sommet1 des arretes directes de g
public static ArrayList<String> voisin(String sommet1,Graphe g){
	ArrayList<String> vo=new ArrayList<String>();
	ArrayList<Arrete> arretes = g.getArrete();
	//System.out.println("arretes : "+arretes);
	for(Arrete a :arretes ) {
		
		if(a.getSommet1().equals(sommet1)) {
			vo.add(a.getSommet2());
		}

		
	}
	return vo;

}
}
