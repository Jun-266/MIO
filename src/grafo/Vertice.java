package grafo;

import enums.Color;

public class Vertice<T> {
	
	private T dato;
	
	// Propiedades para el recorrido BFS.
	private Color color;
	private int distancia;
	private Vertice<T> padre;
	
	private int tiempoInicial;
	private int tiempoFinal;
	
	private int indice;
	
	public Vertice(T dato) {
		this.dato = dato;
		this.indice = 0;
	}
	
	public Vertice(T dato, int indice) {
		this.dato = dato;
		this.indice = indice;
	}
	
	public void setDato(T dato) {
		this.dato = dato;
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
	
	public void ajustarPropiedadesParaBFS() {
		this.color = Color.BLANCO;
		this.distancia = Integer.MAX_VALUE;
		this.padre = null;
	}
	
	public void ajustarPropiedadesParaDFS() {
		this.color = Color.BLANCO;
		this.padre = null;
	}
	
}
