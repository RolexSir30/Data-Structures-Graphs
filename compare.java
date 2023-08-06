package demo;

import java.util.Comparator;

public class compare implements Comparator<Arrete>  {

	@Override
	public int compare(Arrete o1, Arrete o2) {
		return o1.getPoids()-o2.getPoids();
	}

}
