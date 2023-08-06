package demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Path {

	
	public static void main(String[] args) {
		
			Arrete a = new Arrete("A","D",12);
			Arrete b = new Arrete("A","B",12);
			Arrete c = new Arrete("A","E",12);
			Arrete d = new Arrete("B","C",12);
			Arrete e = new Arrete("C","E",12);
			Arrete f = new Arrete("D","C",12);
			Arrete g = new Arrete("A","I",12);
			Arrete h = new Arrete("I","M",12);
			Arrete i = new Arrete("M","N",12);
			Arrete j = new Arrete("M","O",12);
			Arrete k = new Arrete("O","D",12);


			
			ArrayList<Arrete> vectors =new ArrayList<Arrete>();
			vectors.add(a);
			vectors.add(b);
			vectors.add(c);
			vectors.add(d);
			vectors.add(e);
			vectors.add(f);
			vectors.add(g);
			vectors.add(h);
			vectors.add(i);
			vectors.add(j);
			vectors.add(k);
			//vectors.add(h);

			ArrayList<String> sommets =new ArrayList<>();
			sommets.add("A");
			sommets.add("B");
			sommets.add("C");
			sommets.add("D");
			sommets.add("E");
			sommets.add("F");
			//sommets.add("A");
			
			Graphe graphe = new Graphe(vectors,sommets);
			
			System.out.println(chemin(graphe,"A","C"));

	}
	
	
	public static List<String> chemin(Graphe g , String s1, String s2) {
		ArrayList<Arrete> aretes = g.getArrete();
		ArrayList<String> sommets = g.getSommets();
		List<String> chemins = new ArrayList<>();;
		ArrayList<String> départ = new ArrayList<String>(); // les sommets de daprts 		
		ArrayList<String> arrival = new ArrayList<String>();// les sommets d'arrivée
		List<String> paths = new ArrayList<>();;

		//int sizooo = aretes.size();
		
		//On rajoute ici les arcs retours
		/**for(int k =0;k<sizooo;k++) {
			String a=aretes.get(k).sommet1;
			String b=aretes.get(k).sommet2;
			int value = aretes.get(k).poids;
			Arrete arreti = new Arrete(b,a,value);
			aretes.add(arreti);
		}**/
		
		for( Arrete b : aretes) {
			départ.add(b.sommet1);
			arrival.add(b.sommet2);
		}		

		ArrayList<String> voisins1 = voisin(s1, g);
		for(String v : voisins1) {

			chemins.add(s1+v);
		}			
	//beginning de la boucle : 
			for(int j=0;j<chemins.size();j++) {
			    String a = chemins.get(j);
			    //System.out.println(a);
				char lastChar = a.charAt(a.length() - 1);
				String elmt = ""+lastChar;
				if(arrival.contains(elmt)){

				ArrayList<String> j1 = voisin(elmt, g);
				//System.out.println(elmt+" "+j);
                for(String h : j1 ) {
    				//System.out.println("h1");

                	String n=a+h;
                	chemins.add(n);
    				//System.out.println("h1");
    				//System.out.println(chemins);

                	
                }
			}//chemins.remove(a);
			}
			
			for(String che : chemins) {
				char lastChar = che.charAt(che.length() -1);
				String elmt = ""+lastChar;
				//System.out.println(elmt+" "+s2);
				if(elmt.equals(s2)) {
					paths.add(che);
					//System.out.println("r"+che);
				}
	
			
		}
			//System.out.println("h1");

			return paths;
			
		

	}
	
	
	
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
