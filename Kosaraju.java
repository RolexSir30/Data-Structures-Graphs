package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Kosaraju {
	static ArrayList<String> visited = new ArrayList<String>();

	public static void main(String[] args) {
		
		Arrete D = new Arrete("A","E",10);
		Arrete A = new Arrete("A","I",7);
		Arrete B = new Arrete("A","B",1);
		Arrete C = new Arrete("B","C",10);
		Arrete E = new Arrete("E","A",10);


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
		//sommets.add("B");
		sommets.add("C");
		sommets.add("D");
		
		


		Graphe g = new Graphe(arrete,sommets);
		System.out.println("DFS1 de A : "+DFS1(g,"B"));
//		System.out.println("DFS de D : "+DFS(g,"D"));



		visited.clear();
         
		
		//sSystem.out.println(DFS(g,"I"));
		
		/***System.out.println("DFS de C : "+DFS(inverserGraphe(g),"C"));
		System.out.println("DFS de D : "+DFS(inverserGraphe(g),"D"));
		System.out.println("DFS de A : "+DFS(inverserGraphe(g),"A"));
		System.out.println("DFS de E : "+DFS(inverserGraphe(g),"E"));
		System.out.println("DFS de I : "+DFS(inverserGraphe(g),"I"));
**/

		//System.out.println(visited);
	}
	
	
	
	public static ArrayList<String> Kosaraju(Graphe g, String sommet ) {
		// TODO Auto-generated constructor stub
		ArrayList<Arrete> arrete = g.getArrete();
		ArrayList<String> sommets= g.getSommets();
		ArrayList<ArrayList<String>> composantesconnexes = new ArrayList<>();
		for(String s : sommets) {
			// faire en sorte d'jouter dans visited lorsque le TRAITEMENT DFS est terminé.
			DFS1(g,s);
		}
		//System.out.println(visited);
       // System.out.println("visited : "+visited);
		Collections.reverse(visited);	
		ArrayList<String> visited2 = new ArrayList<String>(); 
		for(String c : visited) {
			visited2.add(c);
		}
		System.out.println("visited reverse : "+visited2);
		//System.out.println("j" +visited2);
		//System.out.println("j"+visited);
		visited.clear();// L eprobleme ici c que quand je clear visited je clear aussi visited2.
		//System.out.println("ja" +visited2);

		//System.out.println(visited);
		//System.out.println(visited2);
		for(String p : visited2 ) {
			
//Le probleme ici c'est que le deuxieme dfs utilise la liste visited qu'on a créé auparavant comment remédier le probleme ? 
			
			ArrayList<String> a= DFS( inverserGraphe(g), p);
			//System.out.println("e");

			composantesconnexes.add(a);
			
		}
		
		
		
		
	for(ArrayList<String> summet : composantesconnexes ) {
		if(summet.contains(sommet)) {
			
			return summet;
		}
	}
	return null;
		
	}
	
	
	
	
	
	
	public static ArrayList<String> DFS1(Graphe G,String s) {
		ArrayList<Arrete> arretes = G.getArrete();
		ArrayList<String> sommets = G.getSommets();

		Stack s1 = new Stack<String>();
		
		s1.push(s);
		
		while(s1.size()!=0) {
			String opo = (String) s1.pop();
			System.out.println(contains(Djikstra.voisin(opo,G),visited));

			if(contains(Djikstra.voisin(opo,G),visited)) {
				//System.out.println(contains(Djikstra.voisin(opo,G),visited));
				for(String v : Djikstra.voisin(opo, G)){
					s1.push(v);
				}
			}else {
				visited.add(opo);
			}
		}
		return visited;
	}
	
	
	
	
	
	
	public static ArrayList<String> DFS(Graphe G,String s) {
		ArrayList<Arrete> arretes = G.getArrete();
		ArrayList<String> sommets = G.getSommets();
		//ArrayArrayList<String>List<String> sommetsVisites = new ArrayList<String>();

		Stack s1 = new Stack<String>();
		
		s1.push(s);
		
		while(s1.size()!=0) {
			String u = (String) s1.pop();
			if(!visited.contains(u)) {
			  //if u a tout ses voisins  visités ou pas de voisin l'ajouter. Le premier dfs faut que je le programme.
				ArrayList<String> voisins= Djikstra.voisin(u, G);
				//if(voisins.size()==0||contains(voisins,visited)) {
				visited.add(u);
				//}
				
				for(String j : Djikstra.voisin(u, G)) {
					s1.push(j);
				}
				
			}
			
			
		}
		
		return visited;
		
		
	}
	
	
	public static boolean contains(ArrayList<String> g, ArrayList<String>d ){
		
		for(String f : g) {
			if(d.contains(f)) {
				return false;
			}
		}
		
		return true;
		
		
	}
	public static Graphe inverserGraphe(Graphe G) {
		ArrayList<Arrete> arretes = G.getArrete();
		ArrayList<String> sommets = G.getSommets();
		ArrayList<Arrete> edges =new ArrayList<>();
		
		
		for(Arrete k : arretes) {
			Arrete newbe = new Arrete(k.getSommet2(),k.getSommet1(),k.getPoids());
			edges.add(newbe);
		}
		Graphe o= new Graphe(edges,sommets);
		return o;
	}

}
