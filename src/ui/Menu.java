package ui;

import enums.Color;
import matriz_adyacencia.Arista;
import matriz_adyacencia.MatrizAdyacencia;
import matriz_adyacencia.Vertice;

public class Menu {
	
	public void iniciar() {
		
	}
	
	public static void main(String[] args) {
		MatrizAdyacencia<String> grafo = new MatrizAdyacencia<>(5);
		grafo.esGrafoDirigido = true;
		grafo.agregarVertice("A");
		grafo.agregarVertice("B");
		grafo.agregarVertice("C");
		grafo.agregarVertice("D");
		grafo.agregarVertice("E");
		
		grafo.agregarAristaMatriz("A", "D");
		grafo.agregarAristaMatriz("A", "B");
		grafo.agregarAristaMatriz("A", "C");
		grafo.agregarAristaMatriz("B", "C");
		grafo.agregarAristaMatriz("C", "E");
		grafo.agregarAristaMatriz("E", "A");
		
		Vertice<String>[] vs = grafo.vertices;
		for (Vertice<String> v : vs) {
			v.ajustarPropiedadesParaBFS();
		}
		
		Arista<String>[][] as = grafo.matrizAristas;
		for(int i = 0 ; i < as.length ; i++) {
			for (int j = 0 ; j < as[i].length ; j++) {
				if (as[i][j] != null) {
					System.out.print("[Origen:" + as[i][j].getOrigen().getDistancia());
					System.out.print("| Destino:" + as[i][j].getDestino().getDistancia() + "]");
				} else {
					System.out.print("[*]");
				}
			}
			System.out.println();
		}

		// Vertice<String> inicio = grafo.buscarVertice("B");
		// grafo.recorridoBFS(inicio);
		/*
		Arista<String>[][] ma = grafo.matrizAristas;
		for (int i = 0 ; i < ma.length ; i++) {
			for (int j = 0 ; j < ma[i].length ; j++) {
				if (ma[i][j] != null) {
					Arista<String> a = ma[i][j];
					System.out.print("[Origen: " + a.getOrigen().getDato());
					System.out.print("| Destino: " + a.getDestino().getDato() + "]");
				} else {
					System.out.print("[*]");
				}
			}
			System.out.println();
		}
		
		Vertice<String>[] vs = grafo.vertices;
		for (int i = 0 ; i < vs.length ; i++) {
			System.out.print("[" + vs[i].getColor() + "]");
		}
		
		for (int i = 0 ; i < ma.length ; i++) {
			for (int j = 0 ; j < ma[i].length ; j++) {
				if ( ma[i][j] != null ) {
					System.out.print("[" + 1 + "]");
				} else {
					System.out.print("[" + "*" + "]");
				}
			}
			System.out.println();
		}
		
		grafo.eliminarVertice("B");
		System.out.println();
		
		for (int i = 0 ; i < ma.length ; i++) {
			for (int j = 0 ; j < ma[i].length ; j++) {
				if ( ma[i][j] != null ) {
					System.out.print("[" + 1 + "]");
				} else {
					System.out.print("[" + "*" + "]");
				}
			}
			System.out.println();
		}
		*/
	}
	
}
