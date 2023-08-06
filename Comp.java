package demo;

import java.util.ArrayList;
import java.util.Comparator;

public class Comp implements Comparator<String >{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return  Prim.cout.get(o1)-Prim.cout.get(o2);
		
		
		
		
	}



	
	
}
