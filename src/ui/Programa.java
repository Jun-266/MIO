package ui;

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
		
	}
	
	public static void main(String[] args) {
		Programa p = new Programa();
		p.menu();
	}

}
