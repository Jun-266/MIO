package matriz_adyacencia;

import java.util.ArrayList;

public class MatrizAdyacencia<T> {
	
	private ArrayList<Vertice<T>> vertices;
	
	private Arista<?>[][] matriz;
	
	public MatrizAdyacencia(int numeroVertices) {
		this.vertices = new ArrayList<>();
		this.matriz = new Arista[numeroVertices][numeroVertices];
	}

	public ArrayList<Vertice<T>> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertice<T>> vertices) {
		this.vertices = vertices;
	}

	public Arista<?>[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(Arista<?>[][] matriz) {
		this.matriz = matriz;
	}

}