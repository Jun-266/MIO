package model;

import grafo.ListaAdyacencia;
import grafo.MatrizAdyacencia;
import grafo.Vertice;
import enums.Color;

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
	
	public Vertice<String> buscarEstacionLED(String nombreEstacion) {
		return listaEstacionesDistancia.buscarVertice(nombreEstacion);
	}
	
	public Vertice<String> buscarEstacionLET(String nombreEstacion) {
		return listaEstacionesTiempo.buscarVertice(nombreEstacion);
	}
	
	public Vertice<String> buscarEstacionMED(String nombreEstacion) {
		return matrizEstacionesDistancia.buscarVertice(nombreEstacion);
	}
	
	public Vertice<String> buscarEstacionMET(String nombreEstacion) {
		return matrizEstacionesTiempo.buscarVertice(nombreEstacion);
	}
	
	public boolean agregarRutaDistancia(String origen, String destino, int distancia) {
		return matrizEstacionesDistancia.agregarAristaMatriz(origen, destino, distancia);
	}
	
	public String calcularRutaMenor(String origen, String destino) {
		String msg="";
		Vertice<String> src=buscarEstacionLED(origen);
		Vertice<String> dst=buscarEstacionLED(destino);
		
		if(dst!=null && src!=null)
			src=listaEstacionesDistancia.dijkstra(src);
		else
			return "No existe una estación de origen con el nombre dado y/o una esteción de destino con este nombre";
		
		boolean conti=true;
		while(src!=null && conti) {
			if(src.getPadre()!=null)
				msg+=src.getDato()+" <==";
			else
				msg+=src.getDato();
			
			if(src.equals(dst))
				conti=false;
			
			src=src.getPadre();
		}
		
		return msg;
		
	}
	
	public String esAccesible(String origen, String destino) {
		Vertice<String> src=buscarEstacionLED(origen);
		Vertice<String> dst=buscarEstacionLED(destino);
		
		if(dst!=null && src!=null)
			src=listaEstacionesDistancia.dijkstra(src);
		else
			return "No existe una estación de origen con el nombre dado y/o una esteción de destino con este nombre";
		
		listaEstacionesDistancia.recorridoBFS(src);
		
		if(dst.getColor().equals(Color.BLANCO))
			return "No se puede acceder a esta estación desde este punto de origen";
		else
			return "Si hay acceso desde este punto de origen al destino";
					
	}

}
