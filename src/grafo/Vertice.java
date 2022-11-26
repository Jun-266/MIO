package grafo;

import java.util.ArrayList;
import enums.Color;

public class Vertice<T> {
	
	private T dato;
	
	private int clave;
	
	// Propiedades para el recorrido BFS y DFS.
	private Color color;
	private int distancia;
	private Vertice<T> padre;
	
	private int tiempoInicial;
	private int tiempoFinal;
	
	private int indice;
	
	private ArrayList<Arista<T>> aristas;
	
	public Vertice(T dato) {
		this.dato = dato;
		this.indice = 0;
		this.aristas = new ArrayList<>();
	}
	
	public Vertice(T dato, int indice) {
		this.dato = dato;
		this.indice = indice;
		this.aristas = new ArrayList<>();
	}
	
	public void setDato(T dato) {
		this.dato = dato;
	}
	
	public void setClave(int clave) {
		this.clave = clave;
	}
	
	public int getClave() {
		return clave;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getDistancia() {
		return distancia;
	}
	
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	public Vertice<T> getPadre() {
		return padre;
	}
	
	public void setPadre(Vertice<T> padre) {
		this.padre = padre;
	}
	
	public int getTiempoInicial() {
		return tiempoInicial;
	}
	
	public void setTiempoInicial(int tiempo) {
		this.tiempoInicial = tiempo;
	}
	
	public int getTiempoFinal() {
		return tiempoFinal;
	}
	
	public void setTiempoFinal(int tiempo) {
		this.tiempoFinal = tiempo;
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
	
	public ArrayList<Arista<T>> getAristas() {
		return aristas;
	}
	
	public void agregarArista(Vertice<T> destino) {
		Arista<T> nuevaArista = new Arista<>(this, destino);
		aristas.add(nuevaArista);
	}
	
	public void agregarArista(Vertice<T> destino, int peso) {
		Arista<T> nuevaArista = new Arista<>(this, destino, peso);
		aristas.add(nuevaArista);
	}
	
	public void eliminarArista(Vertice<T> destino) {
		aristas.removeIf(arista -> arista.getDestino().equals(destino));
	}
	
	public boolean eliminarArista(T dato) {
		if (!aristas.isEmpty()) {
			for (int i = 0 ; i < aristas.size() ; i++) {
				Vertice<T> destino = aristas.get(i).getDestino();
				if (destino.getDato().equals(dato)) {
					aristas.remove(i);
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void ajustarPropiedadesParaBFS() {
		this.color = Color.BLANCO;
		this.distancia = Integer.MAX_VALUE;
		this.padre = null;
	}
	
	public void ajustarPropiedadesParaDFS() {
		this.color = Color.BLANCO;
		this.padre = null;
	}
	
	public void ajustarPropiedadesParaPrim() {
		this.clave = Integer.MAX_VALUE;
		this.color = Color.BLANCO;
		this.padre = null;
	}
	
	public void quickSort(ArrayList<Arista<T>> as, int izq, int der) {
		Arista<T> pivote = as.get(izq);
		
		int i = izq;
		int j = der;
		Arista<T> aux;
		
		while (i < j) {
			while ((as.get(i).getPeso() <= pivote.getPeso()) && (i < j))
				i++;
			
			while (as.get(j).getPeso() > pivote.getPeso()) 
				j--;
			
			if (i < j) {
				aux = as.get(i);
				as.set(i, as.get(j));
				as.set(j, aux);
			}
		}
		
		as.set(izq, as.get(j));
		as.set(j, pivote);
		
		if (izq < (j - 1)) 
			quickSort(as, izq, (j - 1));

		if ((j + 1) < der) 
			quickSort(as, (j + 1), der);
			
	}
	
}
