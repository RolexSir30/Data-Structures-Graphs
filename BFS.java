package demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
	static String input;
	 ArrayList<String> voisin;
      
public static void main(String[] args) {
	Arrete D = new Arrete("A","E",10);
	Arrete A = new Arrete("A","B",7);
	Arrete B = new Arrete("A","C",1);
	Arrete C = new Arrete("A","D",10);
	Arrete E = new Arrete("D","I",10);


	ArrayList<Arrete> arrete = new ArrayList<Arrete> ();
	arrete.add(A);
	arrete.add(B);
	arrete.add(C);
	arrete.add(D);
	arrete.add(E);
	
	ArrayList<String> sommets = new ArrayList<String>();
	sommets.add("I");
	sommets.add("E");
	sommets.add("A");
	sommets.add("B");
	sommets.add("C");
	sommets.add("D");
	
	


	Graphe g = new Graphe(arrete,sommets);
	///System.out.println(voisin("G ",g));
	System.out.println("sommets visités  : "+BFS(g,"D"));

}

public static ArrayList<String> BFS(Graphe G,String sommet){
	ArrayList<String> liste_sommet= G.getSommets();
	
	
	Queue f = new LinkedList<String>();
	ArrayList<String> sommets_visites = new ArrayList<String> ();
	f.add(sommet);
	//int i=0;
	while(f.size()>0) {
		//System.out.println("avant le remove : "+f);

		String u =(String) f.remove();
		//i++;
	//	System.out.println("i : "+i );
		///System.out.println("aprï¿½s le remove : "+f);
		//System.out.println(u);
		if(!sommets_visites.contains(u)) {
			sommets_visites.add(u);
		}
		for (String v :voisin(u,G)) {
			if(!sommets_visites.contains(v)) {
				//System.out.println(v +" nest pas dans : "+sommets_visitï¿½s);
				f.add(v);
			}
		}
	}
	
	return sommets_visites;
		
	}




public static ArrayList<String> voisin(String sommet1,Graphe g){
	ArrayList<String> vo=new ArrayList<String>();
	ArrayList<Arrete> arretes = g.getArrete();
	//System.out.println("arretes : "+arretes);
	for(Arrete a :arretes ) {
		
		if(a.getSommet1().equals(sommet1)) {
			vo.add(a.getSommet2());
		}
		if(a.getSommet2().equals(sommet1)) {
			vo.add(a.getSommet1());
		}
		
	}
	return vo;

}

}
