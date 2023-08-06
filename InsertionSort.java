package demo;

import java.util.ArrayList;

public class InsertionSort {

	public static void main(String[] args) {
		
		ArrayList array = new ArrayList<>(); 
array.add(4);
array.add(9);
array.add(1);
array.add(2);
array.add(4984848);
array.add(3);

		InsertionSort(array);
	}
	
	
	public static void InsertionSort(ArrayList<Integer> array) {
		
		System.out.println("Voici la liste de départ : "+array);
		
		for(int i=1;i<array.size();i++) {
			int tmp = array.get(i);
			array.set(i,null);
			//System.out.println(array+" "+tmp);
			for(int j=i-1;j>-1;j--) {
				//System.out.println(array.get(j) + " tmp "+tmp);

				if(array.get(j)>tmp) {
					int deplacement =array.get(j);
					for(int h=i;h>0;h--) {
						
						if(array.get(h)==null) {
							array.set(h,deplacement);
						}
					}
					array.set(j, null);
					//System.out.println("j : "+array);
				}
			
				
			}
	     
		for(int h=0;h<array.size();h++) {
			if(array.get(h)==null) {
				array.set(h, tmp);
			}
			
			}

		}

		System.out.println("Final après tri par insertion : "+array);
	}
}
