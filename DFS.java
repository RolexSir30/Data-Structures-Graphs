package demo;

import java.util.ArrayList;
import java.util.Stack;



public class DFS {

	public static void main(String[] args) {
		
		Arrete D = new Arrete("A","E",10);
		Arrete A = new Arrete("A","B",7);
		Arrete B = new Arrete("B","C",1);
		Arrete C = new Arrete("A","I",10);
		//Arrete E = new Arrete("D","I",10);


		ArrayList<Arrete> arrete = new ArrayList<Arrete> ();
		arrete.add(A);
		arrete.add(B);
		arrete.add(C);
		arrete.add(D);
		//arrete.add(E);
		
		ArrayList<String> sommets = new ArrayList<String>();
		sommets.add("I");
		sommets.add("E");
		sommets.add("A");
		sommets.add("B");
		sommets.add("C");
		sommets.add("D");
		
		


		Graphe g = new Graphe(arrete,sommets);
		///System.out.println(voisin("G ",g));
		System.out.println("sommets visités à l'aide l'algo DFS  : "+DFS(g,"A"));
		System.out.println("sommets visités à l'aide l'algo BFS  : "+BFS.BFS(g,"A"));

		
	}
	
	public static ArrayList<String> DFS(Graphe G,String s) {
		ArrayList<Arrete> arretes = G.getArrete();
		ArrayList<String> sommets = G.getSommets();
		ArrayList<String> sommetsVisites = new ArrayList<String>();

		Stack s1 = new Stack<String>();
		
		s1.push(s);
		
		while(s1.size()!=0) {
			String u = (String) s1.pop();
			if(!sommetsVisites.contains(u)) {
				sommetsVisites.add(u);
				for(String j : BFS.voisin(u, G)) {
					s1.push(j);
				}
				
			}
			
			
		}
		return sommetsVisites;
		
		
	}
}
