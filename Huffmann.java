package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Huffmann {

	public static void main(String[] args) {
		System.out.println("Voici le codage  de Huffmann : "+Huffmann("tlhtlf"));
		
	}
	
	public static String Huffmann(String codex) {
		System.out.println("Chaîne de départ : "+codex);
		HashMap<String,Integer> frequence = new HashMap<>();
		HashMap<String,String> encodage = new HashMap<>();
		HashMap<String,Integer> fzf = new HashMap<>();
        String solution="";
		ArrayList<String> code  =new ArrayList<>();
		for(int i =0;i<codex.length();i++) {
			String j = codex.charAt(i)+"";
			code.add(j);
		}
		
		for(String element :code) {
			frequence.put(element,   nombreOccuration(code,element));
			fzf.put(element,   nombreOccuration(code,element));

		}

		
		Graphe arbreHuffmann = creerArbreHuffman( frequence) ;
		
		String root=arbreHuffmann.getSommets().get(arbreHuffmann.getSommets().size()-1);//The last String created on the huffmann algo

		
		ArrayList<String> feuilles = new ArrayList<>();
		for(String z : fzf.keySet()) {
			feuilles.add(z);
		}		
		//System.out.println("feuilles"+feuilles);
		
		for(String leaf : feuilles) {
			String d="";
			ArrayList<String> pathRootFeuille =path(arbreHuffmann,root,leaf);
			//System.out.println("path"+pathRootFeuille);
			for(int i=0;i<pathRootFeuille .size()-1;i++) {
				//System.out.println("j");
				String sommetDepart = pathRootFeuille.get(i);
				String sommetArrivee = pathRootFeuille.get(i+1);
				//System.out.println(sommetDepart+","+sommetArrivee+","+arbreHuffmann.poids(sommetDepart,sommetArrivee));
				d+=""+arbreHuffmann.poids(sommetDepart,sommetArrivee);
			}
			encodage.put(leaf, d);
		}
		System.out.println("encodage : "+encodage);

		
		for(int i =0;i<codex.length();i++) {
			String j = codex.charAt(i)+"";
			solution+=encodage.get(j);
		}

		return solution;
	}
	
	
	public static int nombreOccuration(ArrayList<String> chaine,String a) {
		int nombre=0;
		for(String k : chaine) {
			if(k.equals(a)) {
				nombre++;
			}
		}
		return nombre;
}
	
	
	public static Graphe creerArbreHuffman(HashMap<String,Integer> frequence) {
		ArrayList<Arrete> arretes = new ArrayList<>();
		ArrayList<String> sommets = new ArrayList<>();

		Graphe g ;
		
		ArrayList<String> keys = new ArrayList<>();
		for(String z : frequence.keySet()) {
			keys.add(z);
		}
       
        int valueUnion=0;
		while(frequence.size()>2) {
			 String min1=(keys.get(0));
		      String union="";
			for(String s : frequence.keySet()) {
				if(frequence.get(s)<frequence.get(min1)) {
					min1=s;
					
				}
			}
			//System.out.println("min1 : "+min1);

			union=min1;
			valueUnion=frequence.get(min1);
			frequence.remove(min1);
			//System.out.println(frequence);
			keys.remove(min1);
	        String min2=(keys.get(0));
	       // System.out.println("min2 "+min2);
			for(String s : frequence.keySet()) {
				if(frequence.get(s)<frequence.get(min2)) {
					min2=s;
					
				}
			}
			//System.out.println("min2 "+min2);

			union+=min2;
			valueUnion+=frequence.get(min2);
			frequence.remove(min2);
			keys.remove(min2);
			keys.add(union);
			//frequence.remove(min1);
			frequence.put(union, valueUnion);
			//System.out.println(frequence);
			Arrete droite = new Arrete(union,min2,1);
			Arrete gauche = new Arrete(union,min1,0);
			//System.out.println(keys);

			arretes.add(gauche);
			arretes.add(droite);
			sommets.add(min1);
			sommets.add(min2);
			sommets.add(union);
			//System.out.println("yeah");
		
		}
		String root =""+keys.get(0)+keys.get(1);
		
		
        sommets.add(root);
        arretes.add(new Arrete(root,keys.get(0),1));
        arretes.add(new Arrete(root,keys.get(1),0));

        //System.out.println(frequence.get(keys.get(0)));
		//System.out.println(keys);
		//System.out.println("root : "+root);
		System.out.println("Sommets de l'abre de Hoffmann : "+sommets);
		System.out.println("Aretes de l'abre de Hoffmann : "+arretes);
        g=new Graphe(arretes,sommets);
		return g;
		
	}
	
	
	public static  ArrayList<String> path(Graphe g, String root,String feuille) {
		ArrayList<String> path=new ArrayList<>();
		path.add(feuille);
		ArrayList<String> patho=new  ArrayList<>();
		ArrayList<Arrete> arretes = g.getArrete();
		ArrayList<String>  sommets= g.getSommets();
		String parent="";
		String child=feuille;
		while(!parent.equals(root)) {
			child=parent2(g,child);
			path.add(child);

			parent=parent2(g,child);
		}
		patho.add(root);
		for(int k=path.size()-1;k>-1;k--) {
			patho.add(path.get(k));
		}
		
		return patho;
		
		
		
	}
	
	public static String parent2(Graphe g, String sommet) {
		
		ArrayList<Arrete> arretes = g.getArrete();
		
		for(Arrete a : arretes) {
			if(a.getSommet2().equals(sommet)) {
				return a.getSommet1();
			}
		}
		return null;
		
		
	}
	
}
