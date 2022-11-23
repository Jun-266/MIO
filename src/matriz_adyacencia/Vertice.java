package matriz_adyacencia;

public class Vertice<T> {
	
	private T dato;
	
	private int indice;
	
	public Vertice(T dato) {
		this.dato = dato;
		this.indice = 0;
	}
	
	public void setDato(T dato) {
		this.dato = dato;
	}
	
	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	public T getDato() {
		return this.dato;
	}
	
	public int getIndice() {
		return this.indice;
	}

}
