package grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

import enums.Color;

public class ListaAdyacencia<T> {
	
	private boolean esGrafoDirigido;
	
	private int tiempo;
	
	private ArrayList<Vertice<T>> vertices;
	
	public ListaAdyacencia(boolean esGrafoDirigido) {
		this.esGrafoDirigido = esGrafoDirigido;
		this.tiempo = 0;
		this.vertices = new ArrayList<>();
	}
	
	public boolean getEsGrafoDirigido() {
		return esGrafoDirigido;
	}
	
	public int getTiempo() {
		return tiempo;
	}
	
	public ArrayList<Vertice<T>> getVertices() {
		return vertices;
	}
	
	/*
	public Vertice<T> agregarVertice(T dato) {
		Vertice<T> nuevoVertice = new Vertice<T>(dato);
		vertices.add(nuevoVertice);
		return nuevoVertice;
	}
	
	public void eliminarVertice(Vertice<T> vertice) {
		vertices.remove(vertice);
	}
	
	public void agregarArista(Vertice<T> verticeInicial, Vertice<T> verticeFinal) {
		if ( esGrafoDirigido ) {
			verticeInicial.agregarArista(verticeFinal);
		} else {
			verticeInicial.agregarArista(verticeFinal);
			verticeFinal.agregarArista(verticeInicial);
		}
	}
	
	public void agregarArista(Vertice<T> verticeInicial, Vertice<T> verticeFinal, int peso) {
		if ( esGrafoDirigido ) {
			verticeInicial.agregarArista(verticeFinal, peso);
		} else {
			verticeInicial.agregarArista(verticeFinal, peso);
			verticeFinal.agregarArista(verticeInicial, peso);
		}
	}
	
	public void eliminarArista(Vertice<T> verticeInicial, Vertice<T> verticeFinal) {
		if ( esGrafoDirigido ) {
			verticeInicial.eliminarArista(verticeFinal);
		} else {
			verticeInicial.eliminarArista(verticeFinal);
			verticeFinal.eliminarArista(verticeInicial);
		}
	}
	
	public Vertice<T> buscarVertice(T dato) {
		for ( Vertice<T> v : vertices ) {
			if ( v.getDato().equals(dato) ) {
				return v;
			}
		}
		return null;
	}
	*/
	public void agregarVertice(T dato) {
		Vertice<T> nuevo = new Vertice<T>(dato);
		vertices.add(nuevo);
	}
	
	public Vertice<T> buscarVertice(T dato) {
		if (!vertices.isEmpty()) {
			for (Vertice<T> v : vertices) {
				if (v.getDato().equals(dato)) {
					return v;
				}
			}
		}
		return null;
	}
	
	public boolean eliminarVertice(T dato) {
		if (!vertices.isEmpty()) {
			for ( Vertice<T> v : vertices ) {
				if (v.getDato().equals(dato)) {
					vertices.remove(v);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean agregarArista(T datoOrigen, T datoDestino) {
		Vertice<T> origen = buscarVertice(datoOrigen);
		Vertice<T> destino = buscarVertice(datoDestino);
		
		if ((origen != null) && (destino != null)) {
			if (esGrafoDirigido) {
				origen.agregarArista(destino);
				return true;
			} else {
				origen.agregarArista(destino);
				destino.agregarArista(origen);
				return true;
			}
		}
		return false;
	}

	public boolean agregarArista(T datoOrigen, T datoDestino, int peso) {
		Vertice<T> origen = buscarVertice(datoOrigen);
		Vertice<T> destino = buscarVertice(datoDestino);
		
		if ((origen != null) && (destino != null)) {
			if (esGrafoDirigido) {
				origen.agregarArista(destino, peso);
				return true;
			} else {
				origen.agregarArista(destino, peso);
				destino.agregarArista(origen, peso);
				return true;
			}
		}
		return false;
	}
	
	public boolean eliminarArista(T datoOrigen, T datoDestino) {
		Vertice<T> origen = buscarVertice(datoOrigen);
		Vertice<T> destino = buscarVertice(datoDestino);
		
		if (origen != null && destino != null) {
			if (esGrafoDirigido) {
				origen.eliminarArista(destino);
				return true;
			} else {
				origen.eliminarArista(destino);
				destino.eliminarArista(origen);
				return true;
			}
		}
		return false;
	}

	public void reiniciarTiempo() {
		tiempo = 0;
	}
	
	public void recorridoDFS() {
		for ( Vertice<T> u : vertices ) {
			u.ajustarPropiedadesParaDFS();
		}
		tiempo = 0;
		for ( Vertice<T> u : vertices ) {
			if ( u.getColor().equals(Color.BLANCO) )
				recorridoDFSVisitante(u);
		}
		reiniciarTiempo();
	}
	
	public void recorridoDFSVisitante( Vertice<T> u ) {
		tiempo += 1;
		u.setTiempoInicial(tiempo);
		u.setColor(Color.GRIS);
		
		ArrayList<Arista<T>> verticesAdyacentes = u.getAristas();
		for ( Arista<T> arista: verticesAdyacentes ) {
			Vertice<T> v = arista.getDestino();
			if ( v.getColor().equals(Color.BLANCO) ) {
				v.setPadre(u);
				recorridoDFSVisitante(v);
			}
		}
		
		u.setColor(Color.NEGRO);
		tiempo += 1;
		u.setTiempoFinal(tiempo);
	}
	
	public void recorridoBFS(Vertice<T> vertice) {
		for (Vertice<T> v : vertices)
			v.ajustarPropiedadesParaBFS();
		
		vertice.setColor(Color.GRIS);
		vertice.setDistancia(0);
		vertice.setPadre(null);
		
		Queue<Vertice<T>> colaDeVertices = new LinkedList<>();
		colaDeVertices.offer(vertice);
		
		while ( !colaDeVertices.isEmpty() ) {
			Vertice<T> v = colaDeVertices.poll();
			ArrayList<Arista<T>> aristas = v.getAristas();
			for (Arista<T> a : aristas) {
				Vertice<T> w = a.getDestino();
				if ( w.getColor().equals(Color.BLANCO) ) {
					w.setColor(Color.GRIS);
					w.setDistancia(v.getDistancia() + 1);
					w.setPadre(v);
					colaDeVertices.offer(w);
				}
			}
			v.setColor(Color.NEGRO);
		}
	}
	
	public boolean revisarColorDeVertices() {
		// boolean r = false;
		int contador = 0;
		for ( Vertice<T> v : vertices ) {
			if ( v.getColor().equals(Color.NEGRO) )
				contador += 1;
		}
		
		if ( contador == vertices.size() )
			return true;
		
		// return r;
		return false;
	}
	
	public boolean comprobarSiEsGrafoConexoConBFS() {
		boolean y = false;
		int contador = 0;
		for ( Vertice<T> v : vertices ) {
			recorridoBFS(v);
			y = revisarColorDeVertices();
			if ( y == true )
				contador += 1;
		}
		
		if ( contador == vertices.size() )
			return true;
		
		// return y;
		return false;
	}
	
	public void algoritmoDePrim(Vertice<T> inicio) {
		for (Vertice<T> v : vertices)
			v.ajustarPropiedadesParaPrim();

		inicio.setClave(0);
		inicio.setPadre(null);

		Comparator<Vertice<T>> comparator = new VeticesComparator<T>();
		PriorityQueue<Vertice<T>> cp = new PriorityQueue<>(30,comparator );
		for (Vertice<T> v : vertices) {
			cp.offer(v);
		}

		while ( !cp.isEmpty() ) {
			Vertice<T> u = cp.poll();
			ArrayList<Arista<T>> aristas = u.getAristas();
			for (Arista<T> a : aristas) {
				Vertice<T> v = a.getDestino();
				if (v.getColor().equals(Color.BLANCO) && (a.getPeso() < v.getClave())) {
					v.setClave(a.getPeso());
					v.setPadre(u);
				}
			}
			u.setColor(Color.NEGRO);
			PriorityQueue<Vertice<T>> cp2 = new PriorityQueue<>(30,comparator );
			while(!cp.isEmpty()) {
				cp2.add(cp.poll());
			}
			cp=cp2;
			cp2.clear();
		}
	}
	
	public ArrayList<Arista<T>> kruskal() {
		ArrayList<Arista<T>> set= new ArrayList<>();
		ArrayList<Arista<T>> path= new ArrayList<>();
		
		for(Vertice<T> ad: vertices) {
			set.addAll(ad.getAristas());
		}
		
		Collections.sort(set);
		
		for(Arista<T> cnx: set) {
			Vertice<T> org=cnx.getOrigen();
			Vertice<T> dst=cnx.getDestino();
			if(!org.getMiembros().contains(dst)) {
				path.add(cnx);
				org.getMiembros().addAll(dst.getMiembros());
				
				for(Vertice<T> vt : org.getMiembros()) {
					vt.setMiembros(org.getMiembros());
				}
			}
		}
		
		return path;
	}
	
	public Vertice<T> dijkstra(Vertice<T> src){
		
		for(Vertice<T> v: vertices) {
			v.ajustarPropiedadesParaDikjstra();
		}
		
		src.setDistancia(0);
		
		PriorityQueue<Vertice<T>> pq= new PriorityQueue<>(30, new VerticeComparatorDj<T>());
		pq.addAll(vertices);
		Vertice<T> u = null;
		
		while(!pq.isEmpty()) {
			u = pq.poll();
			for(Arista<T> a: u.getAristas()) {
				Vertice<T> v = a.getDestino();
				int alt= u.getDistancia()+a.getPeso();
				
				if(alt<v.getDistancia()) {
					v.setDistancia(alt);
					v.setPadre(u);
				}
			}
			
			PriorityQueue<Vertice<T>> pq2= new PriorityQueue<>(30, new VerticeComparatorDj<T>());
			while(!pq.isEmpty()) {
				pq2.add(pq.poll());
			}
			pq = pq2;
			pq2.clear();
		}
		
		return u;
	}
	
}
