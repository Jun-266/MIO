package grafo;

import java.util.Comparator;

public class VeticesComparator<T> implements Comparator<Vertice<T>>{

	@Override
	public int compare(Vertice<T> o1, Vertice<T> o2) {
		
		if(o1.getClave()<o2.getClave())
			return -1;
		if(o1.getClave()>o2.getClave())
			return 1;
		
		return 0;
	}
}
