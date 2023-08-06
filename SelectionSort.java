package demo;

import java.util.ArrayList;

public class SelectionSort {

	
	public static void main(String[] args) {
		ArrayList array = new ArrayList<>(); 
		array.add(4);
		array.add(9);
		array.add(49848);
        array.add(5454544);
		array.add(1);
		array.add(2);
		array.add(4984848);
		array.add(3);

		SelectionSort(array);
		
	}
	
	public static void SelectionSort(ArrayList<Integer> array) {
		System.out.println("Avant le tri : "+array);
		
		for(int i=0;i<array.size();i++) {
			int beginning=array.get(i);
			int min =array.get(i);
			int indice=i;
			for(int j=i;j<array.size();j++) {
				if(array.get(j)<min) {
					min=array.get(j);
					indice=j;
				}
			}
			array.set(i,min);
			array.set(indice, beginning);
		}
		
		System.out.println("Après le tri par sélection : "+array);

	}
}
