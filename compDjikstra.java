package demo;

import java.util.Comparator;

public class compDjikstra implements Comparator<String > {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return  Djikstra.distance.get(o1)-Djikstra.distance.get(o2);	}

}
