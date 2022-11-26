package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import grafo.Vertice;
import model.CentroOperacion;

public class Programa {

	private CentroOperacion sistemaMIO;

	public Programa() {
		this.sistemaMIO = new CentroOperacion();
	}

	public CentroOperacion getSistemaMIO() {
		return sistemaMIO;
	}

	public void menu() {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		boolean terminado = false;
		while (!terminado) {
			try {
				System.out.println("Sistema de gestión de rutas y estaciones del MIO.");
				System.out.println("Digita el número de la opción a ejecutar.");
				System.out.println("1) Agregar una estación.");
				System.out.println("2) Eliminar una estación.");
				System.out.println("3) Comprobar si una estación existe.");
				System.out.println("4) Agregar una ruta con tiempo especifico.");
				System.out.println("5) Agregar una ruta con una distancia especifica.");
				System.out.println("6) Eliminar una ruta que contiene distancia.");
				System.out.println("7) Eliminar una ruta que contiene tiempo.");
				System.out.println("8) Salir");

				String input = lector.readLine();
				int opcion = Integer.parseInt(input);

				switch (opcion) {
				case 1:
					opcion1();
					break;
				case 2:
					opcion2();
					break;
				case 3:
					opcion3();
					break;
				case 4:
					opcion4();
					break;
				case 5:
					opcion5();
					break;
				case 6:
					opcion6();
					break;
				case 7:
					break;
				case 8:
					terminado = true;
					System.out.println("¡Hasta la proxima!");
					lector.close();
					break;
				default:
					System.out.println("Digita una opción valida.");
					System.out.println();
				}
			} catch (IOException e) {
				System.out.println("Error en el flujo de entrada de datos.");
				System.out.println("");
			} catch (NumberFormatException e) {
				System.out.println("No se permiten caracteres para las opciones disponibles.");
				System.out.println();
			}
		}
	}

	private void opcion1() {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Escribe el nombre de la estación: ");
		try {
			String nombreEstacion = lector.readLine();
			sistemaMIO.agregarEstacion(nombreEstacion);
			System.out.println();
			System.out.println("¡La estación fue agregada de manera exitosa!");
			System.out.println();
		} catch (IOException e) {
			System.out.println("Error en el flujo de entrada de datos.");
		}
	}

	private void opcion2() {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Escribe el nombre de la estación: ");
		try {
			String nombreEstacion = lector.readLine();
			boolean a = sistemaMIO.eliminarEstacionLED(nombreEstacion);
			boolean c = sistemaMIO.eliminarEstacionMED(nombreEstacion);

			if (a && c) {
				System.out.println();
				System.out.println("La estación ha sido eliminada.");
				System.out.println();
			} else {
				System.out.println();
				System.out.println("La estación no existe.");
				System.out.println();
			}
		} catch (IOException e) {
			System.out.println("Error en el flujo de entrada de datos.");
		}
	}

	private void opcion3() {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Escribe el nombre de la estación: ");
		try {
			String nombreEstacion = lector.readLine();
			Vertice<String> a = sistemaMIO.buscarEstacionLED(nombreEstacion);
			Vertice<String> c = sistemaMIO.buscarEstacionMED(nombreEstacion);

			if (a != null && c != null) {
				System.out.println();
				System.out.println("¡Estación encontrada!");
				System.out.println("Nombre de la estación: " + a.getDato());
				System.out.println();
			} else {
				System.out.println();
				System.out.println("La estación no existe.");
				System.out.println();
			}
		} catch (IOException e) {
			System.out.println("Error en el flujo de entrada de datos.");
		}
	}

	private void opcion4() {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		boolean terminado = false;

		// Recuerda: tiempo.
		while (!terminado) {
			try {
				System.out.print("Escribe el nombre de la estación origen: ");
				String origen = lector.readLine();
				System.out.print("Escribe el nombre de la estación destino: ");
				String destino = lector.readLine();
				System.out.print("Digita el valor en minutos de la estación origen a la estación destino: ");
				String tiempo = lector.readLine();
				int t = Integer.parseInt(tiempo);

				if (origen.equals(destino)) {
					terminado = true;
					System.out.println();
					System.out.println("No se permiten estaciones de origen y destino con el mismo valor.");
					System.out.println();
				} else {
					/*
					if (agregado) {
						System.out.println();
						System.out.println("La ruta con tiempo: " + t);
						System.out.println("Con su estación de origen: " + origen);
						System.out.println("Y con su estación destino: " + destino);
						System.out.println("¡Ha sido agregada de manera exitosa!");
						System.out.println();
					} else {
						System.out.println();
						System.out.println("No se pudo agregar la ruta porque no se encontraron las estaciones");
						System.out.println();
					}
					*/
				}

				terminado = true;
			} catch (IOException e) {
				System.out.println("Error en el flujo de entrada de datos.");
				terminado = true;
			} catch (NumberFormatException e) {
				System.out.println();
				System.out.println("No se permiten caracteres para el tiempo de la ruta.");
				System.out.println("Por favor, intente nuevamente.");
				System.out.println();
			}
		}
	}

	private void opcion5() {
		// Recuerda: Distancia.
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		boolean terminado = false;

		while (!terminado) {
			try {
				System.out.print("Escribe el nombre de la estación origen: ");
				String origen = lector.readLine();
				System.out.print("Escribe el nombre de la estación destino: ");
				String destino = lector.readLine();
				System.out.print("Digita el valor en metros de la estación origen a la estación destino: ");
				String distancia = lector.readLine();
				int d = Integer.parseInt(distancia);

				if (origen.equals(destino)) {
					terminado = true;
					System.out.println();
					System.out.println("No se permiten estaciones de origen y destino con el mismo valor.");
					System.out.println();
				} else {
					boolean agregado = sistemaMIO.agregarRutaDistancia(origen, destino, d);
					if (agregado) {
						System.out.println();
						System.out.println("La ruta con distancia: " + d);
						System.out.println("Con su estación de origen: " + origen);
						System.out.println("Y con su estación destino: " + destino);
						System.out.println("¡Ha sido agregada de manera exitosa!");
						System.out.println();
					} else {
						System.out.println();
						System.out.println("No se pudo agregar la ruta porque no se encontraron las estaciones");
						System.out.println();
					}
				}

				terminado = true;
			} catch (IOException e) {
				System.out.println("Error en el flujo de entrada de datos.");
				terminado = true;
			} catch (NumberFormatException e) {
				System.out.println();
				System.out.println("No se permiten caracteres para la distancia de la ruta.");
				System.out.println("Por favor, intente nuevamente.");
				System.out.println();
			}
		}
	}

	private void opcion6() {
		// Recuerda: Distancia.
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		try {
			String origen = lector.readLine();
			String destino = lector.readLine();
			
			if (origen.equals(destino)) {
				System.out.println();
				System.out.println("No se permiten estaciones de origen y destino con el mismo valor.");
				System.out.println();
			} else {
				boolean eliminado = sistemaMIO.eliminarRutaDistancia(origen, destino);
			}
		} catch (IOException e) {
			
		}
	}

	public static void main(String[] args) {
		Programa p = new Programa();
		p.menu();
	}

}
