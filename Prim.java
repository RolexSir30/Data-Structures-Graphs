package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Prim {
	static HashMap<String,Integer> cout;
	int infini = Integer.MAX_VALUE;
	static HashMap<String,String> pred;
	public static void main(String[] args) {
		Arrete A = new Arrete("G","A",7);
		Arrete B = new Arrete("A","B",1);
		Arrete C = new Arrete("B","E",10);
		Arrete D = new Arrete("G","F",9);
		Arrete E = new Arrete("F","C",5);
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
		
		Prim(g , "A");
		
	}
	
	
	public static void Prim(Graphe G, String s) {
		
		ArrayList<Arrete> arrete = G.getArrete();
		ArrayList<String> sommets=G.getSommets();
		
		 cout = new HashMap<> (); 
		 pred = new HashMap<> (); 
		for(String k:sommets) {
			cout.put(k, Integer.MAX_VALUE);
			pred.put(k, null);
		
		}
		cout.put(s, 0);
        Collections.sort(sommets,new Comp());

		Queue<String> maFile = new LinkedList<>();
		for(String a : sommets) {
			maFile.add(a);
		}
		

		while(maFile.size()>0) {
			String t = maFile.remove();
			//System.out.println(t);
			for(String u : maFile) {
				if((G.poids(u,t)!=0||G.poids(t,u)!=0)&&cout.get(u)>cout.get(t)+G.poids(u,t)) {
					cout.put(u,G.poids(u,t));
					pred.put(u, t);
					
				}
			//System.out.println(pred);
			}
		}
		System.out.println("pred : "+pred);
		System.out.println("cout : "+cout);

	}
	
	
}
