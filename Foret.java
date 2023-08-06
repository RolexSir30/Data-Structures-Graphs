package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Foret {
static ArrayList<ArrayList<Integer>> foret= new ArrayList<>();
static Queue f = new LinkedList<Integer>();
static ArrayList<Integer> size=new ArrayList<Integer>();
static ArrayList<Integer> size2=new ArrayList<Integer>();

static int[][] paysage=new int[25][25];
static int nb_Foret=0;
static int nb=0;
static ArrayList<ArrayList> sommetVisites;
public static void main(String[] args) {
	for(int i =0;i<5;i++) {
		for(int j =0;j<5;j++) {
			paysage[i][j]=0;
		}
	}
	paysage[4][4]=1;

	paysage[2][2]=1;
	paysage[2][1]=1;
	paysage[3][1]=1;

	//paysage[2][4]=1;


	forest();
	System.out.println(foret);
	System.out.println(size);
	System.out.println(size2);
}

public static void forest() {
	for(int i =0;i<25;i++) {
		for(int j =0;j<25;j++) {
			connexe(paysage,i,j);
		}
	}
	System.out.println("Nombres de Foret : "+nb_Foret);
	//System.out.println(size);
	size2.add(size.get(0));
	for(int i=1;i<size.size();i++) {
		size2.add( size.get(i)-size.get(i-1));
	}
	//System.out.println(size2);
	Collections.sort(size2);
     System.out.println("Le nombre maximale d'arbres dans une forêt est de "+ size2.get(size2.size()-1));
}


public static void connexe(int paysage[][],int i, int j) {
	
    ArrayList<Integer> check = new ArrayList<Integer>();
    check.add(i);
    check.add(j);
   
    if(!foret.contains(check)&&paysage[i][j]!=0) {
    	
    
   
	//ArrayList<ArrayList> sommetsDepart =new ArrayList<>();
	ArrayList<Integer> sommetsDepart = new ArrayList<>();
	sommetsDepart.add(i);
	sommetsDepart.add(j);
	f.add(sommetsDepart);
	while(f.size()>0) {

		ArrayList<Integer> fileHead =(ArrayList<Integer>) f.remove();
		if(!foret.contains(fileHead)) {
			foret.add(fileHead);

			ArrayList<Integer> VoisinDroite=new ArrayList();
			ArrayList<Integer> VoisinGauche=new ArrayList();
			ArrayList<Integer> VoisinHaut=new ArrayList();
			ArrayList<Integer> VoisinBas=new ArrayList();

			int fileheadX = fileHead.get(0);
			int fileheadY = fileHead.get(1);
			
			VoisinDroite.add(fileheadX);
			VoisinDroite.add(fileheadY+1);

			VoisinGauche.add(fileheadX);
			VoisinGauche.add(fileheadY-1);
			
			VoisinHaut.add(fileheadX-1);
			VoisinHaut.add(fileheadY);
			
			VoisinBas.add(fileheadX+1);
			VoisinBas.add(fileheadY);
			
			if((paysage[fileheadX][fileheadY+1])==(1)&&!foret.contains(VoisinDroite)) {
				f.add(VoisinDroite);
			}
			if((paysage[fileheadX][fileheadY-1])==(1)&&!foret.contains(VoisinGauche)) {
				f.add(VoisinGauche);
			}
			if((paysage[fileheadX-1][fileheadY])==(1)&&!foret.contains(VoisinHaut)) {
				f.add(VoisinHaut);
			}
			if((paysage[fileheadX+1][fileheadY])==(1)&&!foret.contains(VoisinBas)) {
				f.add(VoisinBas);
			}

		}

	}
	nb_Foret++;
	
	int a=foret.size();
	size.add(a);
//System.out.println("foret : " +foret + " a :"+size);
}

}


}
				
	

				
				


