package demo;

public class BubbleSort {

	
	public static void main(String[] args) {
		
		int[] array = new int[] {4,9,1,2,3,5,8,4,81,21,2,145};
		BubbleSort(array);
	}
	
	
	
	int[] array;
	
	public static void BubbleSort(int[] array) {
		String depart ="";
		for(int i=0;i<array.length;i++) {
			depart+=" "+array[i];
		}
		System.out.println("Voici la liste de départ : "+depart);
		
		for(int j=array.length-1;j>0;j--) {
		for(int i =0;i<j;i++) {
			
			if(array[i]>array[i+1]) {
				int tmp=array[i];
				array[i]=array[i+1];
				array[i+1]=tmp;

			}
		}
		}
		String result="";
		for(int i=0;i<array.length;i++) {
			result+=" "+array[i];
		}
		System.out.println("Voici la liste d'arrivée après un tri à bulle: "+result);
	}
}
