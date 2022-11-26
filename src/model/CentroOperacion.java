package model;

import grafo.ListaAdyacencia;
import grafo.MatrizAdyacencia;
import grafo.Vertice;

public class CentroOperacion {
	
	final int NUMERO_VERTICES = 60;

	private ListaAdyacencia<String> listaEstacionesDistancia;
	private MatrizAdyacencia<String> matrizEstacionesDistancia;
	
	private ListaAdyacencia<String> listaEstacionesTiempo;
	private MatrizAdyacencia<String> matrizEstacionesTiempo;
	
	public CentroOperacion() {
		this.listaEstacionesDistancia = new ListaAdyacencia<>(true);
		this.matrizEstacionesDistancia = new MatrizAdyacencia<>(NUMERO_VERTICES);
		
		this.listaEstacionesTiempo = new ListaAdyacencia<>(true);
		this.matrizEstacionesTiempo = new MatrizAdyacencia<>(NUMERO_VERTICES);
	}
	
	public ListaAdyacencia<String> getListaEstacionesDistancia() {
		return this.listaEstacionesDistancia;
	}
	
	public MatrizAdyacencia<String> getMatrizEstacionesDistancia() {
		return this.matrizEstacionesDistancia;
	}
	
	public ListaAdyacencia<String> getListaEstacionesTiempo() {
		return listaEstacionesTiempo;
	}

	public MatrizAdyacencia<String> getMatrizEstacionesTiempo() {
		return matrizEstacionesTiempo;
	}

	public void agregarEstacion(String nombreEstacion) {
		listaEstacionesDistancia.agregarVertice(nombreEstacion);
		listaEstacionesTiempo.agregarVertice(nombreEstacion);
		matrizEstacionesDistancia.agregarVertice(nombreEstacion);
		matrizEstacionesTiempo.agregarVertice(nombreEstacion);
	}
	
	public boolean eliminarEstacionLED(String nombreEstacion) {
		return listaEstacionesDistancia.eliminarVertice(nombreEstacion);
	}
	
	public boolean eliminarEstacionLET(String nombreEstacion) {
		return listaEstacionesTiempo.eliminarVertice(nombreEstacion);
	}
	
	public boolean eliminarEstacionMED(String nombreEstacion) {
		return matrizEstacionesDistancia.eliminarVertice(nombreEstacion);
	}
	
	public boolean eliminarEstacionMET(String nombreEstacion) {
		return matrizEstacionesTiempo.eliminarVertice(nombreEstacion);
	}
	
	public Vertice<String> buscarVerticeListaEstacionesDistancia(String nombreEstacion) {
		return listaEstacionesDistancia.buscarVertice(nombreEstacion);
	}
	
	public Vertice<String> buscarVerticeListaEstacionesTiempo(String nombreEstacion) {
		return listaEstacionesTiempo.buscarVertice(nombreEstacion);
	}
	
	public Vertice<String> buscarVerticeMatrizEstacionesDistancia(String nombreEstacion) {
		return matrizEstacionesDistancia.buscarVertice(nombreEstacion);
	}
	
	public Vertice<String> buscarVerticeMatrizEstacionesTiempo(String nombreEstacion) {
		return matrizEstacionesTiempo.buscarVertice(nombreEstacion);
	}

}
